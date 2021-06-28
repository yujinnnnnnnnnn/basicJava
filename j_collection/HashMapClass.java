package j_collection;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Set;

public class HashMapClass {

	public static void main(String[] args) {
		/*
		 * Object put (Object key, Object value) : 지정된 키와 값을 저장 한다 
		 * Object remove (Object key) : 지정된 키로 저장된 값을제거
		 * Object get (Object key) : 지정된 키의 값(없으면 null)을 반환 /키에 해당하는 값을 얻을 수 있음
		 * Set keySet() : 저장된 모든 키를 set으로 반환
		 *  인덱스로 저장하는 것이 아니라 키로 저장 / 순서라는 것이 없음
		 *  키는 사용자가 임의로정하는 것 
		 */
		
		HashMap<String, Object> map = new HashMap<>(); //키는 왠만하면 String , 값은 object로 결정 / 제네릭을 지정하지 않는 것 = Object 
		
		map.put("age", 10); 
		map.put("name", "홍길동"); //해쉬맵은 키로 저장되기 때문에 값이 오브젝트여도 가능
		map.put("date", new Date()); //import 눌러야함 / 날짜를저장하는 클래스
		
		System.out.println(map); // 출력하면 저장된 순서대로 저장되지 않음(순서라는 것이 없기 때문)
		
		map.put("name", "이순신");
		System.out.println(map); //같은 키로 다시 저장하면 값을 덮어씀

		map.remove("age");
		System.out.println(map); // 키로 저장된 값과 키가 동시에 제거
		
		Object value = map.get("name"); //map에서 값을 꺼냈을때 리턴 타입 : object 
		System.out.println(value);
		
		String str = (String)map.get("name"); // 리턴타입을 선언했던 키타입으로 하고 싶을때는 형변환해줌
		System.out.println(str);
		
		Set<String> keys = map.keySet(); // 모든키를 set타입으로 반환 / set은 인터페이스임 / 잘 사용 안됨 => why?: 중복된 값을 허용하지 않음, 값을 꺼낼 수 있는 메서드가 존재 하지않음
		
		for (String key : keys) { //향상된 for문 (오른쪽의 있는 값을 꺼냈을때 타입의 변수(변수이름은 상관없음) :배열,arrayList 등을 담고있는 값) /실행방식 : 오른쪽에 있는 값을 하나 꺼내서 변수에 저장하고 실행
			System.out.println(key + ": "+ map.get(key));
		}
		
		//hashMap => 테이블(datevase)을 표현하는데 사용됨  키 : 컬럼명 / 값 : 컬럼값 / 해시맵 하나로 테이블 한줄을 저장할 수 있음
		//해시맵을 여러개 만들어서 ArrayList에 저장  => 그 ArrayList는 테이블이 됨
		
		//회원테이블
//		HashMap<String, Object> row = new HashMap<>();
//		row.put("id", "admin");
//		row.put("password", "admin123");
//		row.put("name", "관리자");
//		row.put("tel", "010-1234-5678");
//		
//		HashMap<String, Object> row2 = new HashMap<>();
//		row2.put("id", "유진이래요");
//		row2.put("password", "yujin123");
//		row2.put("name", "교육생");
//		row2.put("tel", "010-2871-8442");
//		
//		ArrayList<HashMap<String, Object>> table = new ArrayList<>();
//		table.add(row);
//		table.add(row2);
//		System.out.println(table);
		ArrayList<HashMap<String, Object>> table = new ArrayList<>();
		HashMap<String, Object> row1 = new HashMap<>();
		row1.put("LPROD_ID", 1);
		row1.put("LPROD_GU", "P101");
		row1.put("LPROD_NM", "컴퓨터제품");
		table.add(row1);
		
		HashMap<String, Object> row2 = new HashMap<>();
		row2.put("LPROD_ID", 2);
		row2.put("LPROD_GU", "P102");
		row2.put("LPROD_NM", "전자제품");
		table.add(row2);
		
		HashMap<String, Object> row3 = new HashMap<>();
		row3.put("LPROD_ID", 3);
		row3.put("LPROD_GU", "P201");
		row3.put("LPROD_NM", "여성캐주얼");
		table.add(row3);
		
		HashMap<String, Object> row4 = new HashMap<>();
		row4.put("LPROD_ID", 4);
		row4.put("LPROD_GU", "P202");
		row4.put("LPROD_NM", "남성캐주얼");
		table.add(row4);
		HashMap<String, Object> row5 = new HashMap<>();
		row5.put("LPROD_ID", 5);
		row5.put("LPROD_GU", "P301");
		row5.put("LPROD_NM", "피혁잡화");
		table.add(row5);
		
		System.out.println("LPROD_ID\tLPROD_GU\tLPROD_NM");
		
		for (int i = 0; i < table.size(); i++) {
			HashMap<String,Object> _row = table.get(i);
			System.out.println(_row.get("LPROD_ID") +"\t\t"           // 변수타입을 HashMap으로 한 이유는 ""키에 존재하는 값을 출력하기 위해서
					+ _row.get("LPROD_GU") + "\t\t" + _row.get("LPROD_NM"));
		}
		
		
	}

}
