package DAO;

import java.sql.*;
import java.text.*;
import SQL.Sql;
import VO.Vo;
import Data.*;
import java.util.*;
public class Dao {
	JDBC db;
	Connection con;
	PreparedStatement pstmt;
	ResultSet rs;
	Sql sql;
	
	public Dao() {
	//�����ͺ��̽� ����̹� �ε�
		db = new JDBC();
		con = db.getCon();
	//SQL�ʱ�ȭ
		sql = new Sql();
	}
	
	public int addMember(Vo vo) {
		
		con = db.getCon();
		int cnt = 0; //��ȯ�� ���� ����
		
		String sql1 = sql.getSQL(sql.ADD_MEMB);
		
		//preparedstatement �����´�.
		pstmt = db.getPSTMT(con, sql1);
		
		// ���� ��ɿ� �ʿ��� ������ ä���
		try {
			pstmt.setInt(1, vo.getEno());
			pstmt.setString(2, vo.getEname());
			pstmt.setString(3, vo.getJob());
			pstmt.setInt(4, vo.getMgr());
			pstmt.setString(5, vo.getHiredate());
			pstmt.setInt(6, vo.getSal());
			pstmt.setInt(7, vo.getComm());
			pstmt.setInt(8, vo.getDno());
			
		//���Ǹ�� �ϼ� �� ������, ����� ��� ��ȯ
			cnt = pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			db.close(pstmt);
			db.close(con);
			
		}
		return cnt;
	}
	public Vo getMemberInfo(String ename) {
		Vo mvo = new Vo();
		//Ŀ�ؼ� ������
		con = db.getCon();
		//���� ��� ��������
		String query = sql.getSQL(sql.MEMB_ALL);
		//PreParedStatement ��������
		pstmt = db.getPSTMT(con, query);
		try {
			//���� ��� �ϼ�
			pstmt.setString(1, ename);
			//���� ��� ������ ��� �ޱ�
			rs = pstmt.executeQuery();
			
			//�۾��� ������
			rs.next();
			// ResultSet�� ��� ���� VO�� ä���ֱ�
			mvo.setEno(rs.getInt("empno"));
			mvo.setEname(rs.getString("ename"));
			/*
			 * mvo.setsDate(rs.getDate("hiredate")); mvo.setsTime(rs.getTime("hiredate"));
			 * mvo.setHiredate();
			 */
			
			mvo.setSal(rs.getInt("sal"));
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			db.close(rs);
			db.close(pstmt);
			db.close(con);
		}
		return mvo;
	}
	public int getMemberUpdate(int sal, int eno) {
		Vo mVO = new Vo();
		// Ŀ�ؼ� ������
		con = db.getCon();
		// ���Ǹ�� ���� ����
		String query = sql.getSQL(sql.UPDATE_MEMB);
		int cnt = 0;
		//PreParedStatement ��������
		pstmt = db.getPSTMT(con, query);
		try {
			//���� ��� �ϼ��ϱ�
			pstmt.setInt(1, sal);
			pstmt.setInt(2, eno);
			//���� ��� ������ ��� �ޱ�
			cnt = pstmt.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			db.close(rs);
			db.close(pstmt);
			db.close(con);
		}
		return cnt;
	}
}
