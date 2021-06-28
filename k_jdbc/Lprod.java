package k_jdbc;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Lprod {

	public static void main(String[] args) {
		
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "koo";
		String password = "java";
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		
		try {
			con = DriverManager.getConnection(url, user, password);
			
			String sql = "SELECT * FROM LPROD";
			ps = con.prepareStatement(sql);
			
			rs = ps.executeQuery();
			
			while(rs.next()){
				String lprodId = rs.getNString(1);
				String lprodGu = rs.getNString(2);
				String lprodNm = rs.getNString(3);
				System.out.println("LPROD_ID : " + lprodId + "/ LPROD_GU : " + lprodGu 
						+ "LPROD_NM : " + lprodNm);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			if(rs != null)try{rs.close();} catch (Exception e){}
			if(ps != null)try{ps.close();} catch (Exception e){}
			if(con != null)try{con.close();} catch (Exception e){}
		}
		
		
		
	}

}
