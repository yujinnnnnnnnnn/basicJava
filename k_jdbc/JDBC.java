package k_jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBC {

	public static void main(String[] args) {
		/*
		 * JDBC(Java Database Connectivity)
		 * - 자바와 데이터베이스를연결해주는 라이브러리
		 * - ojdbc : 오라클 jdbc
		 * 
		 * JDBC 작성단계
		 * 1. Connection 생성 (DB연결)
		 * 2. Statement생성 (쿼리작성) 
		 * 3. Query실행
		 * 4. ResultSet에서 결과 추출 (select 인경우)
		 * 5. ResultSet, Statement, Connection 닫기
		 * (닫아줄때는 작성단계의 역순으로 닫기)
		 */
 //프로젝트할 시 OJDBC 추가햐애함
		
		//데이터베이스에 접속할 정보 필요                          //↓서버의 ip주소 넣어줘도 됨
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user ="koo";
		String password ="java";
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs =null;   // ps의 결과를 담아줌
		
		//DriverManager: 데이터베이스에 접속하기 위한 드라이버를 관리해주는 클래스//자바와 오라클 같이 서로 다른 것들을 연결해주는 다리역할
		try {
			con = DriverManager.getConnection(url, user, password);
			//쿼리 준비
			String sql = "SELECT * FROM MEMBER";
			ps = con.prepareStatement(sql);
			//실행
			//select
			rs = ps.executeQuery(); 
			
			//insert,update, delete 
//			int result = ps.executeUpdate();
			//insert,update, delete 수정,삭제 등 영향이 테이블의 row가 몇줄이 영향을 받았는지 return 됨
	
			while(rs.next()){ //현재 바라보고있는 행의 데이터만 추출함 한번 next시키면 첫번째 행에 바라보게 되고 첫번째 행에서 데이터 추출 가능 next를 호출할때마다 그다음 행을 바라봄 더이상 바라볼 행이 없으면 false로 간주하여 끝남
				String memId = rs.getString(1);//파라미터 안에 내용 : 컬럼의 순서
				String memPass = rs.getString("MEM_PASS");
				System.out.println("MEM_ID : " +  memId + " / MEM_PASS" + memPass);
				
//				rs.getInt(columnIndex); 상황에 따라 사용하면됨
//				rs.getDate(columnIndex);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {  //닫는 기능
			if(rs != null) try{rs.close();} catch (Exception e){}
			if(ps != null) try{ps.close();} catch (Exception e){}
			if(con != null) try{con.close();} catch (Exception e){}
			}
		
	}

}
