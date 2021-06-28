package i_api;

public class StringSpeedTest {

	public static void main(String[] args) {
		//문자열에 변경이 가해지면  "abc" + "d"를하면 "abcd"라는 새로운 객체를 만들어서 저장
		//★String의 특징 :문자열을 많이 변경하게 되면 객체는 계속 생성하게되면 메모리에 계속 쌓이게 되어 메모리 낭비됨 => 이점을 보완하고자 StringBuffer

//		String str = "a";
//		long start = System.currentTimeMillis(); //현재시간을 millis까지 long 타입으로 나태내줌 
//		for (int i = 0; i < 200000; i++) {
//			str += "a";
//		}
//		long end = System.currentTimeMillis();
//		System.out.println(end - start + "ms"); //오래걸림 ㅡㅡ
		
		StringBuffer sb = new StringBuffer("a"); //문자열을 많이 변경할 시 애용하셈 ㅋㅎ
		long start = System.currentTimeMillis();
		for (int i = 0; i < 200000; i++) {
			sb.append("a");
		}
		long end = System.currentTimeMillis();
		System.out.println(end - start + "ms");
	}

}
