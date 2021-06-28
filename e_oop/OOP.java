package e_oop;

public class OOP {

	public static void main(String[] args) {
		/*
		 * 객체지향 프로그래밍 (Object Oriented Programming)
		 * -프로그래밍을 단순히 코드의 연속으로 보는것이 아니라 객체간의 상호작용으로 보는것
		 * -코드의 재사용성이 높고 유지보수 용이
		 */
		
		//return 하고싶으면 타입이 꼭 있어야함 (void는 안됨)
		SampleClass sc = new SampleClass(); //샘플클래스 내용이 메모리에 올라감 (메모리에 올라간것이 객체임)
		
		System.out.println(sc.field);
		
		String returnValue = sc.method1(5); // int 타입 값 넘겨주고  String 타입인 변수를 리턴
		System.out.println(returnValue);
		
		sc.method2();  //파라미터, 리턴 값없는 변수 
		
		sc.flowTest1();

		 //다음을 한줄씩 계산해서 최종  결과값을 출력해주세요
		 //1. 123456 + 654321
		 //2. 1번의 결과값 * 123456
		 //3. 2번의 결과값 / 123456
		 //4. 3번의 결과값 - 654321
		 //5. 4번의 결과값 % 123456
		
		Calculator cal = new Calculator();
		
		double result = cal.add(123456, 654321);
		result = cal.mutiply(result, 123456);
		result = cal.divide(result, 123456);
		result = cal.subtract(result, 654321);
		result = cal.mod(result, 123456);
		System.out.println(result);
	}

}
