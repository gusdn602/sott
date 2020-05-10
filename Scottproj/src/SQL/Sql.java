package SQL;

public class Sql {
	public final int MEMB_ALL = 1001;
	
	public final int ADD_MEMB = 3001;
	public final int UPDATE_MEMB = 3002;
	
	public String getSQL(int code) {
		StringBuffer buf = new StringBuffer();
		
		switch(code) {
		case MEMB_ALL:
			buf.append("SELECT ");
			buf.append("empno , ename , hiredate , sal ");
			buf.append("FROM ");
			buf.append("EMP0 ");
			buf.append("WHERE ");
			buf.append("ename=? ");
			
			break;
			
		case ADD_MEMB:
			buf.append("INSERT INTO ");
			buf.append("EMP0(empno, ename, job, mgr, hiredate, sal, comm, deptno) ");
			buf.append("VALUES( ");
			buf.append("?,?,?,?,sysdate,?,?,? ");
			buf.append(") ");
			break;
			
		case UPDATE_MEMB:
			buf.append("UPDATE ");
			buf.append("EMP0 ");
			buf.append("SET ");
			buf.append("sal=? ");
			buf.append("WHERE ");
			buf.append("empno=? ");
			break;
		}
		return buf.toString();
	}


}
