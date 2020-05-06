package Controller;

/*
 	1. 사원 이름을 입력하면 해당 사원의 사원번호, 이름, 입사일, 급여를 조회해서 출력해주는 프로그램을 작성하세요.
   
	2. 입사하는 사원의 정보를 입력하는 기능을 구현하세요.
   
	3. 사원의 급여를 수정해주는 기능을 구현하세요.
 */
import java.sql.*;

import javax.swing.JOptionPane;

import com.sun.org.apache.xalan.internal.xsltc.util.IntegerArray;

import DAO.Dao;
import Data.JDBC;
import SQL.Sql;
import VO.Vo;
import oracle.sql.DATE;

import java.util.*;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Main {


	public Main() {
		//No1();
		No2();
		//No3();
	}
	public void No1() {
		String name = JOptionPane.showInputDialog("사원의 이름을 입력하세요");
		// 이름을 입력하면 사원번호, 이름, 입사일, 급여 조회
		// dao를 새로운 객체로 생성
		Dao dao = new Dao();
		// 전역으로선언한 입력변수 select를 함수로 입력 받게함
		Vo mvo = dao.getMemberInfo(name);
		// 결과값 출력
		JOptionPane.showMessageDialog(null, "사원번호 : " + mvo.getEno() + "\n사원명 : " + mvo.getEname() + "\n입사일 : "
				+ mvo.getHiredate() + "\n급여 : " + mvo.getSal());
		
		}
		
		
		
	public void No2() {	
		// 데이터베이스 처리함수 호출
		Dao mDao = new Dao();
		// 입사하는 사원의 정보를 입력하는 기능을 구현.
		// 신규사원을 추가하기 위해 Vo를 새로운 객체로 생성
		Vo addmember = new Vo();
		
		// 사원번호를 직접 입력 받게 함
		String eno = JOptionPane.showInputDialog("신규 사원번호를 입력하세요!!");
		// 입력값 받는 타입이 String이라서 int로 변환
		int empno = Integer.parseInt(eno);
		// 변환한 변수를 사원번호로 입력 받게함
		addmember.setEno(empno);
		// 사원명을 입력받을 변수 선언
		String ename = JOptionPane.showInputDialog("신규  사원이름을 입력하세요!!");
		addmember.setEname(ename);
		
		String job = JOptionPane.showInputDialog("신규  사원직책을 입력하세요!!");
		addmember.setJob(job);

		String mgr = JOptionPane.showInputDialog("신규 사원의 상사번호를 입력하세요!!");
		int mgr1 = Integer.parseInt(mgr);
		addmember.setMgr(mgr1);

		String hiredate = JOptionPane.showInputDialog("신규 사원의 입사일을 입력하세요!!");
		addmember.setHiredate(hiredate);

		String sal = JOptionPane.showInputDialog("신규 사원의 급여를 입력하세요!!");
		int sal1 = Integer.parseInt(sal);
		addmember.setSal(sal1);

		String comm = JOptionPane.showInputDialog("신규 사원의 comm를 입력하세요!!");
		int comm1 = Integer.parseInt(comm);
		addmember.setComm(comm1);

		String dno = JOptionPane.showInputDialog("신규 사원의 부서번호를 입력하세요!!");
		int dno1 = Integer.parseInt(dno);
		addmember.setDno(dno1);

		
		
		

	}
	
	public void No3() {
		Dao dao = new Dao();
		String upsal = JOptionPane.showInputDialog("수정할 급여를 입력하세요");
		String upeno = JOptionPane.showInputDialog("대상 사원번호를 입력하세요");
		int upsal1 = Integer.parseInt(upsal);
		int upeno1 = Integer.parseInt(upeno);
		int mupdate = dao.getMemberUpdate(upsal1, upeno1);
		JOptionPane.showMessageDialog(null, "수정 대상 사원번호 :" + upeno1 + "\n수정급여" + upsal1);
		
	}
	

	public static void main(String[] args) {
		new Main();

	}

}
