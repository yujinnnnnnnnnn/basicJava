package k_jdbc;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class delete {

	public static void main(String[] args) {
		
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "koo";
		String password = "java";
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			con = DriverManager.getConnection(url, user, password);
			String sql = "DELETE EMP" //띄어쓰기 중요함 
					+ " WHERE ENAME = ?";
			ps = con.prepareStatement(sql);
			ps.setString(1, "유진");
		
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
