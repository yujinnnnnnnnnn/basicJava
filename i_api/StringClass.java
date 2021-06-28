package i_api;

import java.util.Arrays;

public class StringClass {

	public static void main(String[] args) {
		/*
		 * String 
		 * - 여러개의 문자를 사용하기쉽게 만들어 놓은 클래스
		 * 
		 * String 의 주요 메서드
		 * - equals() : 문자열의 내용이 같은지 반환한다
		 * - length(): 문자열의 길이 반환
		 * - charAt() : 특정 인덱스에 위치한 문자를 반환 / 파라미터로 인덱스를 넘기면 그 위치에 있는 문자반환 / 문자열 아님
		 * - substring() : 문자열의 특정부분을 잘라서 반환
		 * - indexOf() :문자열 내의 특정 문자의 인덱스를 반환한다
		 * - contains() : 문자열이 특정 문자열을 포함하고 있는지 여부를반홚나다
		 * - split(): 문자열을 특정문자를 기준으로 나누어 배열형태로 반환
		 * - trim() : 문자열 앞뒤 공백을 제거해 반환
		 * - valueOf() : 다른 타입의 데이터를 문자열로 변환해 반환(string 타입으로 형변환)
		 */

		//equals()사용
		boolean equals = "문자열".equals("문자열"); // ""의 내용과 파라미터의 내용이 같은지 확인/반환 타입이 불린타입
		System.out.println(equals);
		
		String str1 = "문자열";
		String str2 = null;
		System.out.println(str1.equals(str2)); 
//		System.out.println(str2.equals(str1)); //앞에오는 변수에 null이 있으면 안됨 -> 에러뜸 앞에는 반드시 null이 없는 변수 사용(파라미터에는 null이 들어와도 상관없음)
		
		//length()사용
		String str ="12345";
		
		for (int i = 0; i < str.length(); i++) {
		char charAt = str.charAt(i); //인덱스를 한글자씩 가져오는 메서드 : charAt (return 타입 : char)
		System.out.println(charAt);
		}
		//거꾸로 반환
		String rev = "";
		for (int i = str.length()-1; 0 <= i; i--) {
			rev += str.charAt(i);
		}
		System.out.println(rev);
		
		//substring 특정 인덱스 잘라서 반환
		str = "0123456789";
		String sub1 = str.substring(3); //3번 인덱스부터 잘라서 반환 / 파라미터를 하나 : 시작하는 인덱스 / 파라미터 두개 : 시작과 끝 인덱스 / 반환 타입 : String
		System.out.println(sub1);
		String sub2 = str.substring(5,8); //5번인덱스부터 8번 인덱스 전까지 잘라서 반환(5번포함, 8번 미포함)
		System.out.println(sub2);
		

		
		str = "수박 오렌지 귤 블루베리";
		int index  = str.indexOf("오렌지"); //문자열 안에서 파라미터로 넘긴 문자열의 위치(인덱스) / 인덱스이기 떄문에 반환 타입 : int
		System.out.println(index);
		
//		substring 과 indexOf 같이 사용 인덱스 오브로 찾아서 반환		
	
		String[] menu = {
				"수박 20000원",
				"오렌지 100000원",
				"귤 500원",
				"블루베리 3000원" // 공백에서 끝나는 패턴 => 공백 까지잘라서 사용
		};
		
		for (int i = 0; i < menu.length; i++) {
			String name = menu[i].substring(0, menu[i].indexOf(" "));
			System.out.println(name);
			
			//가격만 잘라서 int 타입 변수에 저장
			int price = Integer.parseInt(menu[i].substring(menu[i].indexOf(" ")+1, menu[i].indexOf("원"))); //String 타입을 int 타입으로 형변환 : Integer.parseInt 
			System.out.println(price);
	
		}
		
		str = "abcd";
			boolean contains = str.contains("c"); //abcd안에 c문자열이 포함되어있는 가 
			System.out.println(contains);
		
		for (int i = 0; i < menu.length; i++) {
			if(menu[i].contains("오렌지")){
				System.out.println("오렌지는 " + i + "번 인덱스에 있습니다.");
			}
		}
		
		str = "a/b/c";
		String[] split = str.split("/");  //배열 형태로 반환됨
		System.out.println(Arrays.toString(split)); 
		
		for (int i = 0; i < menu.length; i++) {
		String[] split2 = menu[i].split(" ");
		System.out.println("메뉴명 : " + split2[0] + " / 가격 : " + split2[1]);
		}
		
		str = " 문자열  ";
		String trim = str.trim();
		System.out.println("[" + str + "] -> [" + trim +"]"); //"" 중간에 공백은 없어지지 않음 / 사용자의 로그인 잘못입력을 trim으로 방지
		
		String id = " myid";
		String password = "mypassword ";
		System.out.println(id.trim());
		System.out.println(password.trim());
		
		int number = 10;  
		str = String.valueOf(number); // (1) 정석
		str = number + ""; //(2) 문자열을 만났기 때문에 문자열로 형변환 가능
		System.out.println(str);
	}		
}









