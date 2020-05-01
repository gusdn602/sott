package Data;

import java.sql.*;

import SQL.Sql;
public class JDBC {
	private Connection con = null;
	
	public JDBC() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	public Connection getCon() {
		return getCon("scott", "tiger");
	}
	
	public Connection getCon(String user, String pw) {
		String url = "jdbc:oracle:thin:@localhost:1521:orcl";
		
		try {
				this.con = DriverManager.getConnection(url,user,pw);
			}catch(Exception e) {
				e.printStackTrace();
			}
			
			return con;
		}
	
	//Statement얻어온다.
	public Statement getStmt(Connection con) {
		Statement stmt = null;
		try {
			stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return stmt;
	}
	
	//PreparedStatement 얻어온다.
	public PreparedStatement getPSTMT(Connection con, String sql) {
		PreparedStatement pstmp = null;
		try {
			pstmp = con.prepareStatement(sql,ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return pstmp;
	}
		//객체가 필요 없을경우 닫아준다.
		public void close(Object o) {
			try {
				if(o instanceof Connection) {
					((Connection)o).close();
				}else if(o instanceof PreparedStatement) {
					((PreparedStatement)o).close();
				}else if(o instanceof Statement) {
					((Statement)o).close();
				}
			}catch(Exception e) {
				e.printStackTrace();
			}
		
		}
		
}
		
	
	


	

