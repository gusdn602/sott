package Controller;

/*
 	1. ��� �̸��� �Է��ϸ� �ش� ����� �����ȣ, �̸�, �Ի���, �޿��� ��ȸ�ؼ� ������ִ� ���α׷��� �ۼ��ϼ���.
   
	2. �Ի��ϴ� ����� ������ �Է��ϴ� ����� �����ϼ���.
   
	3. ����� �޿��� �������ִ� ����� �����ϼ���.
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
		String name = JOptionPane.showInputDialog("����� �̸��� �Է��ϼ���");
		// �̸��� �Է��ϸ� �����ȣ, �̸�, �Ի���, �޿� ��ȸ
		// dao�� ���ο� ��ü�� ����
		Dao dao = new Dao();
		// �������μ����� �Էº��� select�� �Լ��� �Է� �ް���
		Vo mvo = dao.getMemberInfo(name);
		// ����� ���
		JOptionPane.showMessageDialog(null, "�����ȣ : " + mvo.getEno() + "\n����� : " + mvo.getEname() + "\n�Ի��� : "
				+ mvo.getHiredate() + "\n�޿� : " + mvo.getSal());
		
		}
		
		
		
	public void No2() {	
		// �����ͺ��̽� ó���Լ� ȣ��
		Dao mDao = new Dao();
		// �Ի��ϴ� ����� ������ �Է��ϴ� ����� ����.
		// �űԻ���� �߰��ϱ� ���� Vo�� ���ο� ��ü�� ����
		Vo addmember = new Vo();
		
		// �����ȣ�� ���� �Է� �ް� ��
		String eno = JOptionPane.showInputDialog("�ű� �����ȣ�� �Է��ϼ���!!");
		// �Է°� �޴� Ÿ���� String�̶� int�� ��ȯ
		int empno = Integer.parseInt(eno);
		// ��ȯ�� ������ �����ȣ�� �Է� �ް���
		addmember.setEno(empno);
		// ������� �Է¹��� ���� ����
		String ename = JOptionPane.showInputDialog("�ű�  ����̸��� �Է��ϼ���!!");
		addmember.setEname(ename);
		
		String job = JOptionPane.showInputDialog("�ű�  �����å�� �Է��ϼ���!!");
		addmember.setJob(job);

		String mgr = JOptionPane.showInputDialog("�ű� ����� ����ȣ�� �Է��ϼ���!!");
		int mgr1 = Integer.parseInt(mgr);
		addmember.setMgr(mgr1);

		String hiredate = JOptionPane.showInputDialog("�ű� ����� �Ի����� �Է��ϼ���!!");
		addmember.setHiredate(hiredate);

		String sal = JOptionPane.showInputDialog("�ű� ����� �޿��� �Է��ϼ���!!");
		int sal1 = Integer.parseInt(sal);
		addmember.setSal(sal1);

		String comm = JOptionPane.showInputDialog("�ű� ����� comm�� �Է��ϼ���!!");
		int comm1 = Integer.parseInt(comm);
		addmember.setComm(comm1);

		String dno = JOptionPane.showInputDialog("�ű� ����� �μ���ȣ�� �Է��ϼ���!!");
		int dno1 = Integer.parseInt(dno);
		addmember.setDno(dno1);

		
		
		

	}
	
	public void No3() {
		Dao dao = new Dao();
		String upsal = JOptionPane.showInputDialog("������ �޿��� �Է��ϼ���");
		String upeno = JOptionPane.showInputDialog("��� �����ȣ�� �Է��ϼ���");
		int upsal1 = Integer.parseInt(upsal);
		int upeno1 = Integer.parseInt(upeno);
		int mupdate = dao.getMemberUpdate(upsal1, upeno1);
		JOptionPane.showMessageDialog(null, "���� ��� �����ȣ :" + upeno1 + "\n�����޿�" + upsal1);
		
	}
	

	public static void main(String[] args) {
		new Main();

	}

}
