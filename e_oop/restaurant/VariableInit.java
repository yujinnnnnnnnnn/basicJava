package e_oop.restaurant;

import e_oop.JVM;

public class VariableInit {

	//명시적 초기화
	int var = 10;
	static int classVar = 20;
	
	//초기화 블럭
	{ //아무것도 없이 블럭을 열면 초기화 블럭
		var = 30;
	}
	
	static { //클래스 변수 초기화
		classVar = 40;
	}
	
	/*
	 * 생성자 / ()가 붙으면 무조건 메서드  / ex. JVM jvm = new JVM(); 에서 ()앞이 생성자
	 * - 클래스와 같은 이름의 메서드
	 * - 인스턴스 변수를 초기화하기 위해 사용한다
	 * - 클래스에생성자는 반드시 하나 이상 존재해야 한다
	 * - 직접 선언해주지 않으면 컴파일러가 기본 생성자를 만들어준다
	 * - 생성자는 리턴타입이 없다
	 * - 메서드 이기 때문에 () 안에 파라미터를 받을 수 있음
	 */
	
	//명시적 초기화는 안에 로직을 넣을 수 없음 => 이럴 경우 초기화 블럭이나 생성자 사용 
	
	//생성자 사용 이유
	//초기화에 여러줄의 코드가 필요할 때
	//초기화에 파라미터가 필요할 때
	
	VariableInit(){
		var = 50;
	}

	public static void main(String[] args) {
		 Init i = new Init(); // 생성자를 만들면 컴파일러는 생성자를 만들어주지 않음 그래서 컴파일 에러가 생김
		 i.a = 10;
		 i.b = 20;
		 i.c = 30;
		 
		 Init i2 = new Init();
		 i.a = 40;
		 i.b = 50;
		 i.c = 60;
	
		 Init i3 = new Init(70, 80, 90);
	}
	
	}
	class Init{
		int a;   //인스턴스 변수
		int b;
		int c;
		
		     //↓파라미터
		Init(int a, int b, int c){
			this.a = a; //지역변수
			this.b = b; 
			this.c = c;    
			// 객체생성했을 때의 변수의 주소가 this에 들어감
			//생성자 생성 (메서드의 변수들이 많을 때 사용)
			//this : 인스턴스 변수와 지역변수의 이름이 같을 때 둘을 구분하기 위해 사용
		}  
		
		//오버로딩 : 같은 이름의 메서드를 여러개 정의하는 것 / 파라미터의 타입이나 갯수로 구분함
		Init(){
//			a = 10;
//			b = 20;
//			c = 30;     //중복되게 초기화 하지 않음
			this(10, 20, 30);  //생성자의 첫줄에서만 사용할 수 있다
			//this() : 생성자에서 다른 생성자를 호출할떄 사용한다.
		}
	}
