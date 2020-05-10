package pre.JDBC;

import java.sql.*;
public class ORJDBC {
	private Connection con =null;
	Statement stmt = null;
	PreparedStatement pstmt = null;
	
	public ORJDBC() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	public Connection getCon(String url,String user, String pw) {
		url = "jdbc:oracle:thin:@localhost:1521:orcl";
		user = "scott";
		pw = "tiger";
		try {
			this.con = DriverManager.getConnection(url,user,pw);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return con;
	}
	
	//Statement얻기
	public Statement getStmt(Connection con) {
		
		try {
			stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return stmt;
	}
	
	//PreparedStatement 얻기
	public PreparedStatement getPSTMT(Connection con, String sql) {
		
		try {
			pstmt = con.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY, 0);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return pstmt;
	}
	
	//닫아주는 함수 
	public void close(Object o) {
		try {
			if(o instanceof Connection) {
				((Connection) o).close();
			}else if(o instanceof PreparedStatement) {
				((PreparedStatement) o).close();
			}else if(o instanceof Statement) {
				((Statement)o).close();
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
