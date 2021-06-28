package g_oop2;

public interface SampleInterface {

	//상수와 추상메서드만 가질수 있음
	//변수와 메서드로 구성되어 있지 않음
	
	//인터페이스의 모든 멤버변수는 public static final 제어자를 사용해야한다
	public static final int NUM1 =10; //static = 상수
	
	//모든 멤버 변수의 제어자가 같기 때문에생략이 가능하다
	int NUM2 = 20;
	
	//인터페이스의 모든 **메서드**는 public abstract제어자를 사용해야한다
	public abstract void method1(); //abstract = 추상메서드
	
	//모든 메서드의 제어자가같기때문에 생략이가능하다
	void method2();
}

class SampleImplement implements SampleInterface, SampleInterface2{//인터페이스를 상속받을 땐 implements를 사용 /class를 상속받는다는 것은 기존 클래스를 확장 개념이지만 
												             		//인터페이스경우 내용이 없기 때문에 내용을 구현한다는 느낌이 강해서 implements를 사용
																	//다중상속이 가능함 (부모가 여러명 가능)
																	//여러가지 용도로 사용가능 
	@Override
	public void method1() {
		
	}

	@Override
	public void method2() {
			
	}

	@Override
	public void method3() {
			
	} 
	
}

interface SampleInterface2{
	void method1();
	void method3();
}




