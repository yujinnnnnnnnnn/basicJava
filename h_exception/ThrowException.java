package h_exception;

import java.io.IOException;

public class ThrowException {

	public static void main(String[] args) {
		/*
		 * 예외 발생시키기
		 * - throw new Exception();
		 * -throw 예약어와 예외 클래스의 객체로 예외를발생 시킬 수 있다
		 */

		try {
			throw new IOException("강지*는 멍청이");   //이 위치에서 IOException가 발생할 거라서 try로 감싸준거임 / 발생이유없음 => 이유를만들어주려면 파라미터에 넣어주면 됨
		} catch (IOException e) {   
			e.printStackTrace();
		}
		
		//자주 만나게될 예외
//		throw new NullPointerException(); //null을 참조했다는 뜻 (null은 참조형의 기본값)
		
		String str = null;
		System.out.println(str.equals("문자열비교")); // 이중에 어떤 변수가 null인 것을 알 수 있음 (들어가면 안되는 곳에 null이 들어간것)
		
		throw new IndexOutOfBoundsException(); // 인덱스가 범위를 벗어남 
	}

}
