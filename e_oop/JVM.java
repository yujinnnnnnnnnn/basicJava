package e_oop;

public class JVM {

	public static void main(String[] args) {    //static이 아닌 것들은 메인 메서드에서는 반드시 객체생성을 하고 사용해야함 (static이 있기 때문)
		/*
		 * Java Virtual Machine
		 * -자바로 만들어진 프로그램이 실행되는 컴퓨터 안의 가상 컴퓨터
		 * -운영체제 -> JVM -> 자바 프로그램
		 * -장점 : 운영체제 상관없이 실행 할 수 있다
		 * -단점 : 속도가 느리다
		 * 
		 * JVM 메모리구조
		 * -Method Area (메서드 영역) : 클래스 멤버가 저장된다 (static이 붙은 것들 )
		 * -Heap : 객체가 저장된다 (객체 생성된 것들 / 생성된 객체가 저장)
		 * -Call Stack (호출 스택 ): 현재 호출되어 있는 메서드가 저장된다 (실행중인) 
		 */
		  
		  
		//프로그램 실행시 main(), classVar, classMethod() 가 Method Area에 저장됨 [1]
		//main()이 호출되어 CallStack에 저장됨 [2]
		
		System.out.println(classVar);  //out이라는 변수에 static이 붙어 있어서 객체생성 안해도 됨
		//System 클래스의 out이 MethodArea에 저장됨
		//println()이 호출되어 CallStack에 저장됨
		//println()이 classVar를 출력 후 CallStack에서 삭제됨
		
		classMethod();
		//classMethod()가 호출되어 CallStack에 저장되고 메서드의 내용을 수행 후 삭제됨
		
		JVM jvm = new JVM(); // int instanceVar과 메서드가 메모리에 올라가 있지 않기때문에 객체생성해줌 (static이 없는 것들)
		//JVM객체가 Heap에 저장됨
		//jvm변수가 CallStack에 생성되고, JVM객체의 주소가 저장됨
		//(jvm = 지역변수 / 지역변수는 CallStack에 저장됨)
		
		System.out.println(jvm.instanceVar);
		//println()이 호출되어 CallStack에 저장됨
		//println()이 instanceVar를 출력 후 CallStack에서 삭제됨
		
		jvm.instanceMethod();
		//instanceMethod()가 호출되어 CallStack에 저장되고, 메서드의 내용을 수행 후 삭제됨
		
		jvm = null;
		//jvm 변수에 null이 저장됨
		//어디에서도 주소를 참조하지 않는 JVM객체는 GarbageCollector에 의해 삭제됨
		
		//maim()의 실행이 종료되어 CallStack 에서 삭제됨
		//프로그램이 종료되고 MethodArea의 데이터가 삭제됨
		
	}

	int instanceVar;
	static int classVar;
	
	void instanceMethod(){       
		System.out.println(instanceVar);  //객체생성할 때 같이 메모리에 올라감
		System.out.println(classVar);    // 프로그램 실행하자 메모리에 마자 올라감
	}
	
	static void classMethod(){            //호출시점 : 객체생성 하기 전
//		System.out.println(instanceVar);  // 객체생성 전이여서 컴파일 에러뜸 (사용하려면 **반드시 객체생성** 해야함)
		System.out.println(classVar);     // 실행하자마자 메모리에 올라가기 때문에 사용 가능
	}
}
