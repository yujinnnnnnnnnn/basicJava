package Test;

import java.awt.List;
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
import java.util.Map;
import java.util.logging.SimpleFormatter;

import e_oop.ScanUtil;

import java.sql.Connection;

public class jdbcboard {

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

	void start() {
		//목록
		while (true) {
			try {
				con = DriverManager.getConnection(url, user, password);

				String sql = "SELECT BOARD_NO, TITLE, CONTENT, USER_ID, TO_CHAR(REG_DATE, 'YY-MM-DD') AS REG_DATE FROM TB_JDBC_BOARD";
				ps = con.prepareStatement(sql);
				rs = ps.executeQuery();

				System.out.println("----------------------------------");
				System.out.println("번호\t제목\t작성자\t작성일");
				System.out.println("----------------------------------");
				while (rs.next()) {
//					java.util.Date date = rs.getDate("reg_date");
//					String reg_date = format.format(date);

					System.out.println(rs.getInt("BOARD_NO") + "\t"
							+ rs.getString("TITLE") + "\t"
							+ rs.getString("user_id") + "\t" + rs.getString("reg_date"));
				}
				System.out.println("---------------------------------");
			} catch (SQLException e) {
				e.printStackTrace();
			}finally{
				if(rs != null) try {rs.close();}catch (Exception e){}
				if(ps != null) try {ps.close();}catch (Exception e){}
				if(con != null) try {con.close();}catch (Exception e){}	
			}
			System.out.println("1.조회 \t2.등록\t3.종료");
			System.out.println("---------------------------------");
			System.out.print("입력 >>>");
			int input = ScanUtil.nextInt();
			
			switch(input){
			case 1:
				select();
				break;
			case 2:
				insert();
				break;
			case 3:
				System.exit(3);
				break;
			}
			
		}
	}
	void select(){
		System.out.println("조회할 번호>>>");
		int input = ScanUtil.nextInt();
		int boardNo = 0;
		
		try {
			con = DriverManager.getConnection(url, user, password);
			
			String sql = "select board_no, title, content, user_id, TO_CHAR(REG_DATE, 'YY-MM-DD') AS REG_DATE "
					+ "from tb_jdbc_board "
					+ "where board_no = ?";
			ps = con.prepareStatement(sql);
			ps.setInt(1, input);
			
			rs = ps.executeQuery();
			
			while(rs.next()){
				boardNo = rs.getInt("board_no");
				System.out.println("번호\t : " + rs.getInt("board_no"));
				System.out.println("작성자\t : " + rs.getString("user_id"));
				System.out.println("작성일\t : " + rs.getString("reg_date"));
				System.out.println("제목\t : " + rs.getString("title"));
				System.out.println("내용\t : " + rs.getString("content"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			if(rs != null)try{rs.close();} catch(Exception e){}
			if(ps != null)try{ps.close();} catch(Exception e){}
			if(con != null)try{con.close();} catch(Exception e){}
		}
		System.out.println("1.수정\t2.삭제\t3.목록");
		System.out.print("입력>>>");
		input = ScanUtil.nextInt();
		
		switch(input){
		case 1:
			update(boardNo);
			break;
		case 2:
			delete(boardNo);
			break;
			
		}
	}
	void update(int boardNo){
		System.out.print("제목>");
		String input = ScanUtil.nextLine();
		System.out.print("내용>");
		String input2 = ScanUtil.nextLine();
		
		try {
			con= DriverManager.getConnection(url, user, password);
			String sql = "UPDATE TB_JDBC_BOARD "
					+ "SET TITLE = ?, CONTENT = ? "
					+ "WHERE BOARD_NO = ?";
					
			ps = con.prepareStatement(sql);
			ps.setString(1, input);
			ps.setString(2, input2);
			ps.setInt(3, boardNo);
			
			int result = ps.executeUpdate();
			if(0 < result){
				System.out.println("수정이 완료되었습니다.");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			if(rs!= null)try{rs.close();}catch(Exception e){}
			if(ps!= null)try{ps.close();}catch(Exception e){}
			if(con!= null)try{con.close();}catch(Exception e){}
		}
	}
	void delete(int boardNo){
		try {
			con = DriverManager.getConnection(url, user, password);
			String sql = "delete from tb_jdbc_board"
					+ " where board_no = ?";
			ps = con.prepareStatement(sql);
			ps.setInt(1, boardNo);
			
			int result = ps.executeUpdate();
			if(0 < result){
				System.out.println("삭제가 완료되었습니다.");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if(rs != null) try { rs.close(); } catch(Exception e) {}
			if(ps != null) try { ps.close(); } catch(Exception e) {}
			if(con != null) try { con.close(); } catch(Exception e) {}
		}
	}
	void insert(){
		System.out.print("제목>");
		String input = ScanUtil.nextLine();
		System.out.print("내용>");
		String input2 = ScanUtil.nextLine();
		System.out.print("작성자");
		String input3 = ScanUtil.nextLine();
		
		try {
			con = DriverManager.getConnection(url, user, password);
			String sql = "insert into tb_jdbc_board values(select nvl(max(board_no),0)+1 from tb_jdbc_board)"
					+ ",?,?,?,sysdate)";
			ps = con.prepareStatement(sql);
			ps.setString(1, input);
			ps.setString(2, input2);
			ps.setString(3, input3);
			
			int result = ps.executeUpdate();
			if(0 < result){
				System.out.println("등록이 완료되었습니다.");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if(rs != null) try { rs.close(); } catch(Exception e) {}
			if(ps != null) try { ps.close(); } catch(Exception e) {}
			if(con != null) try { con.close(); } catch(Exception e) {}
		}
	}
}
