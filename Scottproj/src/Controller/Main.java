package Controller;
/*
 	1. ��� �̸��� �Է��ϸ� �ش� ����� �����ȣ, �̸�, �Ի���, �޿��� ��ȸ�ؼ� ������ִ� ���α׷��� �ۼ��ϼ���.
   
	2. �Ի��ϴ� ����� ������ �Է��ϴ� ����� �����ϼ���.
   
	3. ����� �޿��� �������ִ� ����� �����ϼ���.
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
