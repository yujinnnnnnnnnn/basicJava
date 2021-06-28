package k_jdbc;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class JDBCTest {

	public static void main(String[] args) {

		JDBCUtil jdbc = JDBCUtil.getInstance();
		// 객체생성이아닌 getInstance를 호출

		// selectList(String sql, List<Object> param)
		// String sql = "SELECT * FROM CART WHERE CART_MEMBER =?";
		// ArrayList<Object> param = new ArrayList<>();
		// param.add("a001");
		// //조회된 결과
		// List<Map<String, Object>> list = jdbc.selectList(sql, param);
		//
		// for (int i = 0; i < list.size(); i++) {
		// Map<String, Object> row = list.get(i);
		// for(String key: row.keySet()){
		// System.out.print(key + " : " + row.get(key) + "\t");
		// }
		// System.out.println();
		// }
		// selectOne (String sql)
		 String sql = "SELECT * FROM EMP WHERE EMPNO = 7782";
		
		 Map<String, Object> Map = jdbc.selectOne(sql);
		 for (String key : Map.keySet()){
		 System.out.print(key + " : " + Map.get(key) + "\t");
		 }
		 System.out.println();

		// selectOne(String sql, List<Object> param)
		// String sql = "SELECT * FROM EMP WHERE EMPNO = ?";
		// ArrayList<Object> param = new ArrayList<>();
		// param.add(7782);
		// Map<String, Object> map = jdbc.selectOne(sql, param);
		// for(String key : map.keySet()){
		// System.out.print(key + " : " + map.get(key) + "\t");
		// }
		// System.out.println();

		
		// List<Map<String, Object>> selectList(string sql)
//		String sql = "select * from emp where deptno = 10";
//		List<Map<String, Object>> List = jdbc.selectList(sql);
//
//		for (int i = 0; i < List.size(); i++) {
//			Map<String, Object> row = List.get(i);
//			for (String key : row.keySet()) {
//				System.out.print(key + " : " + row.get(key) + "\t");
//			}
//			System.out.println();
//		}
		
		// public int update(String sql)
//		String sql = "update emp set ename = 'yujin' where ename = 'KING'";
//		int result = jdbc.update(sql);
//		System.out.println(result + "행이 수정되었습니다");
		
//		int update(String sql, List<Object> param)
//		String sql = "update emp set ename = ? where ename = ?";
//		ArrayList<Object> param = new ArrayList<>();
//
//		param.add("yujin");
//		param.add("KING");
//		int result = jdbc.update(sql, param);
//		System.out.println(result + "행이 수정됨");
	}
}
