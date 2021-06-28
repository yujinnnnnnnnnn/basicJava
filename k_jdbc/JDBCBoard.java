package k_jdbc;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;

import e_oop.ScanUtil;


public class JDBCBoard {

	public static void main(String[] args) {
		// 오라클 데이터베이스에 생성한 게시판 테이블을 이용해 게시판 프로그램을 만들어주세요.

		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "koo";
		String password = "java";
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			con = DriverManager.getConnection(url, user, password);
			
			String sql = "SELECT * "
					+ "FROM TB_JDBC_BOARD ";
			ps = con.prepareStatement(sql);
			ps.setInt(1, 10);
			
			rs = ps.executeQuery();
			
			ResultSetMetaData metaData = rs.getMetaData();
			int columnCount = metaData.getColumnCount();
			
			for (int i = 1; i < columnCount; i++) {
				System.out.print(metaData.getColumnName(i) + "\t");
			}
			System.out.println();
			while(rs.next()){
				for (int i = 1; i < columnCount; i++) {
					Object value = rs.getObject(i);
					System.out.print(value + "\t");
				}
				System.out.println();
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally{
			if(rs != null) try{rs.close();} catch (Exception e){}
			if(ps != null) try{ps.close();} catch (Exception e){}
			if(con != null) try{con.close();} catch (Exception e){}
			
		}
	}

}
