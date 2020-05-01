package Controller;
/*
 	1. 사원 이름을 입력하면 해당 사원의 사원번호, 이름, 입사일, 급여를 조회해서 출력해주는 프로그램을 작성하세요.
   
	2. 입사하는 사원의 정보를 입력하는 기능을 구현하세요.
   
	3. 사원의 급여를 수정해주는 기능을 구현하세요.
 */
import java.sql.*;

import javax.swing.JOptionPane;

import DAO.Dao;
import Data.JDBC;
import SQL.Sql;
import VO.Vo;

public class Main {

	public Main() {
		Dao dao = new Dao();
		Vo mvo = dao.getMemberInfo("KING");
		JOptionPane.showMessageDialog(null, "ename : " + mvo.getEname()
				
		);
	}

	public static void main(String[] args) {
		 new Main();
		

	}

}
