package Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

import e_oop.ScanUtil;

public class jjbdcboard {

	public static void main(String[] args) {
		
		new jdbcboard().start();
	}

	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String user = "koo";
	String password = "java";
	
	Connection con = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	
	SimpleDateFormat format = new SimpleDateFormat("yy-MM-dd");
	void start(){
		while(true){
			try {
				con = DriverManager.getConnection(url, user, password);
				
				String sql = "SELECT BOARD_NO, TITLE, CONTENT, USER_ID, TO_CHAR(REG_DATE, 'YY-MM-DD') "
						+ "FROM TB_JDBC_BOARD";
				ps = con.prepareStatement(sql);
				rs = ps.executeQuery();
				
				System.out.println("------------------------------------------");
				System.out.println("번호\t제목\t작성자\t작성일");
				System.out.println("------------------------------------------");
				while(rs.next()){
					System.out.println(rs.getInt("board_no") +"\t"+ rs.getString("title") +"\t"+ rs.getString("user_id") +"\t"+ rs.getString("reg_date"));	
				}
				System.out.println("------------------------------------------");
				System.out.println("1.조회 \t2.등록\t 3.종료");
				System.out.print("입력 >>>");
				int input = ScanUtil.nextInt();
				
				switch(input){
				case 1:
					
					break;
				case 2:
					
					break;
				case 3:
					System.exit(3);
					break;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
