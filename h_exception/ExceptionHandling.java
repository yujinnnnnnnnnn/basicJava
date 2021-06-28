package h_exception;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class ExceptionHandling {

	public static void main(String[] args) {
		/*
		 * 에러
		 * -컴파일 에러: 컴파일 시에 발생되는 에러 (빨간줄)
		 * 논리적 에러 : 시행은 되지만  의도와 다르게 동작하는것 (버그)
		 * 런타임 에러 : 실행시에 발생되는 에러
		 * 
		 * 런타임 에러
		 * 런타임 에러 발생시 발생한 위치에서 프로그램이 비정상적으로 종료된다
		 * 에러 : 프로그램 코드에 의해 수습될 수 없는 심각한 오류 (처리불가)
		 * 예외 : 프로그램 코드에 의해서 수습될 수 있는 다소 미약한 오류 (처리가능)
		 * 
		 * 예외 
		 * 모든 예외는 Exception 클래스의 자식클래스이다
		 * RuntimeException 클래스와 그 자식들을 예외처리가 강제되지 않는다
		 * {RuntimeException 클래스와 그 자식을들 제외한 } Exception 클래스의 자식들은 예외 처리가 강제된다
		 * 
		 * 예외처리 (try- catch)
		 * 예외처리를 통해 프로그램이 비정상적으로 종료되는것을 방지할 수 있음
		 * try {} catch(Exception e) {} 
		 * try 블럭 안의 내용을 실행 중 예외가 발생하면 catch로 넘어간다
		 * catch의 ()안에는 처리할 예외를 지정해줄 수 있다
		 * 여러 종류의예외를 처리할 수있도록 catch는 하나 이상 올 수 있다
		 * 발생한 예외와 일치하는 catch 블럭안의 내용이 수행된후 try catch를 빠져나간다
		 * 발생한 예외와 일치하는 catch 가 없을 경우 예외는처리되지 않는다 
		 */
		try{                  //예외 처리 (정상적으로 사용하게 하기 위해/ 컴파일에러를 잡기위해 사용 [형식적임])
			int result = 10 / 0;
			System.out.println(result); //예외 발생 
		}catch(ArithmeticException | IndexOutOfBoundsException e){ // |를 기준으로 여러개(1)
			e.printStackTrace(); //실행했을 때의 메세지를똑같이 띄움
		}catch(NullPointerException e){      //catch를 여려개 (2)
			
		}catch(Exception e){ //모든 예외의 부모 클래스 Exception을 파라미터로 넣어줌으로써 모든 예외 처리 가능
 			
		}
		/*
		 * CallStack
		 * 
		 * |           |
		 * |__test2()__|
		 * |__test1()__|
		 * |___main()__|
		 * 
		 * 특징 : 아래는 막혀있음 제일 먼저들어온것이 제일 마지막 제일 최근에 들어온것이 제일 위에 제일 최근 메서드를 먼저호출 
		 */
		
		
		test1();
	}

	private static void test1() {
		test2();
	}

	private static void test2() {
//		System.out.println(10 / 0);
		try {
			new FileInputStream("");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
//		java.lang.ArithmeticException: / by zero                        이런경우 제일 위에부터 내가 알고잇는 것을 찾아서 들어가면 됨
//		at h_exception.ExceptionHandling.main(ExceptionHandling.java:35)
//	java.io.FileNotFoundException: 
//		at java.io.FileInputStream.open(Native Method)
//		at java.io.FileInputStream.<init>(FileInputStream.java:146)
//		at java.io.FileInputStream.<init>(FileInputStream.java:101)
//		at h_exception.ExceptionHandling.test2(ExceptionHandling.java:66)
//		at h_exception.ExceptionHandling.test1(ExceptionHandling.java:60)
//		at h_exception.ExceptionHandling.main(ExceptionHandling.java:56)
		
		
	}
//	java.lang.ArithmeticException: / by zero
//	at h_exception.ExceptionHandling.main(ExceptionHandling.java:32)
//Exception in thread "main" java.lang.ArithmeticException: / by zero    예외 발생 이유
//	at h_exception.ExceptionHandling.test2(ExceptionHandling.java:61)   at은 어느위치에서 발생했는지 알려줌  제일 최근 메서드를 들어가면 예외발생을 볼 수있음
//	at h_exception.ExceptionHandling.test1(ExceptionHandling.java:57)	
//	at h_exception.ExceptionHandling.main(ExceptionHandling.java:53)	
	
	
}
