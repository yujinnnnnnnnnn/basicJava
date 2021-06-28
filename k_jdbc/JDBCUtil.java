package k_jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JDBCUtil {

	//싱글톤 패턴 : 인스턴스의 생성을 제한하여 하나의 인스턴스만 사용하는디자인 패턴 /여러군데 사용해도 객체 하나만 사용 (디자인 패턴 :클래스를 구축하는 패턴) / 메모리 절약 , 속도 향상
	//필요한 것 : private이 붙은 생성자 (private : 다른 클래스에서 객체생성 하지 못함)
	private JDBCUtil(){
		
	}
	//인스턴스를 보관할 변수
	private static JDBCUtil instance; //기본값 null
	
	//인스턴스를 빌려주는 메서드(객체생성후 다른 클래스에서 사용가능한 메서드)
	public static JDBCUtil getInstance(){
		if(instance == null){
			instance = new JDBCUtil(); 
		}
		return instance; //처음 객체생성 후 필요할시 리턴해줌
	}
	
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String user = "koo";
	String password = "java";
	
	Connection con = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	
	/*  리턴타입                                                            파라미터
	 * Map<String, Object> selectOne (String sql) - 조회의 결과가 한줄일때 사용하는 메서드 / 물음표가 없는 쿼리
	 * Map<String, Object> selectOne (String sql, List<Object> param) - (물음표가 있는 쿼리, 물음표의 값) 물음표의 순서대로 어레이리스트에 저장해서 메서트에 물음표를 하나씩 넣는것
	 * List<Map<String, Object>> selectList(string sql) - 조회의 결과가 여려줄일때 사용하는 메서드/ 리턴타입 :맵을 리스트에담음 
	 * List<Map<String, Object>> selectList(string sql, List<Object> param) - 물음표가 있는 쿼리 물음표가 있는 값
	 * int update(string sql) - select를 제외한 명령어 사용 메서드 / 리턴타입 : int 행의 갯수를 리턴
	 * int update(string sql, List<Object> param) - 쿼리, 물음표 값
	 */
	//접근제어자 public 붙여줘야함 다른 클래스에서 사용할 수 있기 위해
	//selectList(String sql, List<Object> param)
	public List<Map<String, Object>> selectList(String sql, List<Object> param){
		List<Map<String, Object>> list = new ArrayList<>();
		
		try {
			con = DriverManager.getConnection(url, user, password);
			ps = con.prepareStatement(sql);
			for (int i = 0; i < param.size(); i++) { //ArrayList이기때문에 for문사용(파라미터에 대한 구문)
				ps.setObject(i+1, param.get(i));
			} //            arraylist 인덱스는 0 부터 시작하지만 물음표 인덱스는 1부터 시작하기 때문
			rs = ps.executeQuery();
			
			//컬럼의 갯수를 알기 위해 메타데이터
			ResultSetMetaData metaData = rs.getMetaData();
			int columnCount = metaData.getColumnCount();
			//결과추출
			while(rs.next()){
				HashMap<String, Object> row = new HashMap<>();//for문이 한줄의 데이터를 나타내므로 for문밖에서 만들어서 포문을 돌면서 해쉬맵에 담기
				for (int i = 1; i <= columnCount; i++) {  //한줄에대한 컬럼을 하나하나 돌아가면서 값 추출 -> 해쉬맵에 담기
					String key = metaData.getColumnName(i); //key : 컬럼이름   metaData.getColumnName(i)-> 컬럼 이름 알 수 있음
					Object value = rs.getObject(i);
					row.put(key, value);
				}
				list.add(row); //list에 해쉬맵 내용 넣기
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(rs != null) try { rs.close(); } catch(Exception e) {}
			if(ps != null) try { ps.close(); } catch(Exception e) {}
			if(con != null) try { con.close(); } catch(Exception e) {}
		}
		
		return list;
	}
	
	//selectOne (String sql)
	public Map<String, Object> selectOne (String sql){
		 Map<String, Object> Map= null;// 여기서 초기화하는 것이 아닌 null로 초기화해야함
//		 Map<String, Object> Map= new HashMap<>();// 여기서 초기화하는 것이 아닌 null로 초기화해야함 -> 결과값이 여러줄이 나올 수도 있고 안나올 수 있음 / 결과값이 안나올 경우에는 null로 초기화해야 확인 여부를 알 수있음 해쉬맵으로 초기화를 하게되면 그 객체가 반환되어 결과값을 알 수 없음 
		 try {
			con = DriverManager.getConnection(url, user, password);
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();

			ResultSetMetaData metaData = rs.getMetaData();
			int columnCount = metaData.getColumnCount();

			while(rs.next()){
				Map = new HashMap<>();
			for (int i = 1; i <= columnCount; i++) {
				String key = metaData.getColumnName(i);
				Object value = rs.getObject(i);
				Map.put(key, value);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(rs != null) try { rs.close(); } catch(Exception e) {}
			if(ps != null) try { ps.close(); } catch(Exception e) {}
			if(con != null) try { con.close(); } catch(Exception e) {}
		}
		 return Map;
	 }
	
	//selectOne(String sql, List<Object> param)
	 public Map<String, Object> selectOne(String sql, List<Object> param){
		 Map<String, Object> map = null;
		 try {
			con = DriverManager.getConnection(url, user, password);
			
			ps = con.prepareStatement(sql);
			for (int i = 0; i < param.size(); i++) {
				ps.setObject(i+1, param.get(i));
			} 
			rs = ps.executeQuery();
			
			ResultSetMetaData metaData = rs.getMetaData();
			int columnCount = metaData.getColumnCount();
			while(rs.next()){
				for (int i = 1; i <= columnCount; i++) {  
					String key = metaData.getColumnName(i); 
					Object value = rs.getObject(i);
					map.put(key, value);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(rs != null) try { rs.close(); } catch(Exception e) {}
			if(ps != null) try { ps.close(); } catch(Exception e) {}
			if(con != null) try { con.close(); } catch(Exception e) {}
		}
		 return map;
	 }
	 //List<Map<String, Object>> selectList(string sql)
	 List<Map<String, Object>> selectList(String sql){
		 List<Map<String, Object>> List = new ArrayList<>();
		 try {
				con = DriverManager.getConnection(url, user, password);
				ps = con.prepareStatement(sql);
				rs = ps.executeQuery();

				ResultSetMetaData metaData = rs.getMetaData();
				int columnCount = metaData.getColumnCount();
				
				while(rs.next()){
					HashMap<String, Object> row = new HashMap<>();
					for (int i = 1; i <= columnCount; i++) {  
						String key = metaData.getColumnName(i); 
						Object value = rs.getObject(i);
						row.put(key, value);
					}
					List.add(row); 
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				if(rs != null) try { rs.close(); } catch(Exception e) {}
				if(ps != null) try { ps.close(); } catch(Exception e) {}
				if(con != null) try { con.close(); } catch(Exception e) {}
			}
			
			return List;
		 }
	 // public int update(String sql)
	 public int update(String sql){
		 int result = 0; 
		 
	 try {
		 	con = DriverManager.getConnection(url, user, password);
			ps = con.prepareStatement(sql);
			result = ps.executeUpdate();
		
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(rs != null) try { rs.close(); } catch(Exception e) {}
			if(ps != null) try { ps.close(); } catch(Exception e) {}
			if(con != null) try { con.close(); } catch(Exception e) {}
		}
		 return result;
	 }
//	 int update(string sql, List<Object> param)
	 public int update(String sql, List<Object> param){
		 int result = 0;
		 try {
			con = DriverManager.getConnection(url, user, password);
			ps = con.prepareStatement(sql);
			for (int i = 0; i < param.size(); i++) {
				ps.setObject(i+1, param.get(i));
			} 
			result = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(rs != null) try { rs.close(); } catch(Exception e) {}
			if(ps != null) try { ps.close(); } catch(Exception e) {}
			if(con != null) try { con.close(); } catch(Exception e) {}
		}
		 return result;
		 
	 }
}
