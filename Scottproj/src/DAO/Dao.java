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
	//데이터베이스 드라이버 로딩
		db = new JDBC();
		con = db.getCon();
	//SQL초기화
		sql = new Sql();
	}
	
	public int addMember(Vo vo) {
		
		con = db.getCon();
		int cnt = 0; //반환값 변수 생성
		
		String sql1 = sql.getSQL(sql.ADD_MEMB);
		
		//preparedstatement 가져온다.
		pstmt = db.getPSTMT(con, sql1);
		
		// 질의 명령에 필요한 데이터 채우기
		try {
			pstmt.setInt(1, vo.getEno());
			pstmt.setString(2, vo.getEname());
			pstmt.setString(3, vo.getJob());
			pstmt.setInt(4, vo.getMgr());
			pstmt.setString(5, vo.getHiredate());
			pstmt.setInt(6, vo.getSal());
			pstmt.setInt(7, vo.getComm());
			pstmt.setInt(8, vo.getDno());
			
		//질의명령 완성 및 보내기, 변경된 행수 반환
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
		//커넥션 얻어오기
		con = db.getCon();
		//질의 명령 가져오기
		String query = sql.getSQL(sql.MEMB_ALL);
		//PreParedStatement 가져오기
		pstmt = db.getPSTMT(con, query);
		try {
			//질의 명령 완성
			pstmt.setString(1, ename);
			//질의 명령 보내고 결과 받기
			rs = pstmt.executeQuery();
			
			//작업줄 내리기
			rs.next();
			// ResultSet에 담긴 내용 VO에 채워주기
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
		// 커넥션 얻어오기
		con = db.getCon();
		// 질의명령 갖고 오기
		String query = sql.getSQL(sql.UPDATE_MEMB);
		int cnt = 0;
		//PreParedStatement 가져오기
		pstmt = db.getPSTMT(con, query);
		try {
			//질의 명령 완성하기
			pstmt.setInt(1, sal);
			pstmt.setInt(2, eno);
			//질의 명령 보내고 결과 받기
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
