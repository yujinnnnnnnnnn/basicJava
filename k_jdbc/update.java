package k_jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class update {

	public static void main(String[] args) {
		
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "koo";
		String password = "java";
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			con = DriverManager.getConnection(url, user, password);
			String sql = "UPDATE EMP SET EMPNO =?, ENAME =?"
					+ " WHERE EMPNO = ?";
			ps = con.prepareStatement(sql);
			ps.setInt(1, 10);
			ps.setString(2, "지수");
			ps.setInt(3, 7777);
			int result = ps.executeUpdate();
			
		} catch (SQLException e){
			e.printStackTrace();
			
		}finally {
			if(rs != null) try{rs.close();} catch (Exception e){}
			if(ps != null) try{ps.close();} catch (Exception e){}
			if(con != null) try{con.close();} catch (Exception e){}
			}
	}
}
