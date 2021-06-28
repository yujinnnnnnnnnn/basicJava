package g_oop2;

public abstract class SampleAbstractParent {
	
	
	void method(){
		
		
	}
	
	abstract void abstractMethod(); //추상메서드 : 선언만 있고, 블럭이 없는 것 제어자 abstract가 붙음 / 추상메서드가 하나라도 있으면 추상 클래스가 됨(클래스에도 abstract를 넣어줌)
                                   // 객체생성을 하지 못함 / 부모클래스 역할만 함 따라서 부모클래스로 상속받아 사용하겠다는 의미를 가짐	
}

class SampleabstractChild extends SampleAbstractParent{ //추상클래스로하던가 추상메서드의 내용을 만들어주어야 컴파일 에러가 안남 ctrl +1 눌러서 오버라이딩 만들어서 추상메서드를 만들어줌

	@Override
	void abstractMethod() { //추상클래스 상속받은 자식메서드를 오버라이딩해서 내용을 만들어서 사용하게 강제로 시킴
		                    //상속받아서 사용하면 자식 클래스마다 내용이 다를수 있기때문에 새로운 내용을 추가하는 거임
		
	} 
	
}
