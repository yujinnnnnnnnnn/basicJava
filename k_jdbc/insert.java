package k_jdbc;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class insert {

	public static void main(String[] args) {
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "koo";
		String password = "java";
		
		Connection con = null;
		PreparedStatement ps = null;
//		ResultSet rs = null; insert, update, delete시 필요없음
		
		try {
			con = DriverManager.getConnection(url, user, password);
			String sql = "INSERT INTO EMP(EMPNO, ENAME, JOB, MGR, HIREDATE, SAL, DEPTNO) "
					+ "VALUES(?,?,?,?,?,?,?)";
			ps = con.prepareStatement(sql);
			ps.setInt(1, 7777);
			ps.setString(2, "유진");
			ps.setString(3, "학생");
			ps.setInt(4, 7661);
//			java.util.Date d = new java.util.Date();
//			d.setYear(2021); // 줄 쳐져있는 이유 : 더이상 사용하지 말라겅 ㅋㅎ
//			d.setMonth(4); //월은 0부터 시작해서 결과는 5월임 ㅋㅋ
//			d.setDate(7);
//			ps.setDate(5, new Date(d.getTime()));
			
			ps.setDate(5, Date.valueOf("2021-04-09"));
			ps.setInt(6, 3000);
			ps.setInt(7, 10);
			//타입 귀찮을 시 ps.setObject(3,10);
			
			int result = ps.executeUpdate();
			System.out.println(result +"개의 행이 영향을 받았습니다");
			
		} catch (SQLException e){
			e.printStackTrace();
		}finally {
//			if(rs != null) try{rs.close();} catch (Exception e){}
			if(ps != null) try{ps.close();} catch (Exception e){}
			if(con != null) try{con.close();} catch (Exception e){}
			}
		

	}

}
