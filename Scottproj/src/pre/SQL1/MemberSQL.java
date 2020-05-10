package pre.SQL1;

import java.sql.*;
public class MemberSQL {
	public final int SEL_INFO = 1001;
	
	public String getSQL(int code) {
		StringBuffer buff = new StringBuffer();
		
		switch(code) {
		case SEL_INFO:
			buff.append("SELECT ");
			buff.append("ID, NAME, MAIL ");
			buff.append("FROM ");
			buff.append("member ");
			buff.append("WHERE ");
			buff.append("mno = ? ");
			
		}
		return buff.toString();
	}
}
