package k_jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class JDBC2 {

	public static void main(String[] args) {
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user ="koo";
		String password ="java";
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs =null;
			//prepareStatement와  Statement 차이점 : 쿼리 작성시 '?'를 사용할 수 있는지 없는지 
			//prepareStatement => '?'사용가능 where절에 값대신 ?를 적고 ?를 따로 코드로 작성
		try {
			con = DriverManager.getConnection(url, user, password);
			
			String sql = "SELECT * "
					+ "FROM CART "
					+ "WHERE CART_MEMBER = ? "
					+ "AND CART_QTY >=?";
			ps = con.prepareStatement(sql);
			//prepareStatement 사용법
			ps.setString(1, "a001"); //(물음표의 인덱스, 인덱스의값)
			ps.setInt(2,10);
			
			rs = ps.executeQuery();
			
			ResultSetMetaData metaData = rs.getMetaData();   //리턴타입있는 경우 crt+1하면 타입에 맞는 변수를 집어 넣어줌
																//메타데이터 : 데이터에 대한 데이터 / 결과가 행이몇개, 컬럼이 몇개가 있는지 
			 int columnCount = metaData.getColumnCount(); //컬럼 수 (for문을 이용해서 컬럼을 첫번째 컬럼부터 마지막까지 전부추출가능)
			 
			 for (int i = 1; i < columnCount; i++) {
				System.out.print(metaData.getColumnName(i) + "\t");
			}
			 System.out.println();
			 while(rs.next()){
				 for (int i = 1; i < columnCount; i++) {
					Object value = rs.getObject(i); //타입이 각자 다를수 있으므로 모든 받아줄 수 있는 getObject로 씀
					System.out.print(value+ "\t");
				}
				 System.out.println();
			 }
		} catch (SQLException e) {	
			e.printStackTrace();
		}finally {
			if(rs != null) try{rs.close();} catch (Exception e){}
			if(ps != null) try{ps.close();} catch (Exception e){}
			if(con != null) try{con.close();} catch (Exception e){}
			}
	}

}
