package g_oop2;

public class SampleChild extends SampleParent{

	void ChildMethod(){
		System.out.println(var);
		System.out.println(method(7, 13));
	}
	
	//오버라이딩 --부모로부터 메서드를 물려받아 내용 변경
	//super, super() --부모클래스의 있는 멤버이름과 자식클래스의 있는 멤버의 이름이 같을때 사용 
	//==> 자식클래스에서 부모클래스 생성사 호출
	//다형성 --부모타입 변수를 사용해서 자식 타입의 객체를 사용
	
	//오버라이딩 : 상속받은 메서드의 내용을 재정의 하는것
	@Override //어노테이션 : 클래스, 변스, 메서드 등에 표시해 놓는것
	int method(int a, int b){//리턴타입 메서드명 파라미터 모두 같아야 변경 가능
		return a * b;
	}
	
	//super,super()
	int var;
	
	void test(double var){
//		System.out.println(var); //지역변수(파라미터)
//		System.out.println(this.var); //인스턴스 변수
//		System.out.println(super.var); //부모 클래스의 인스턴스 변수
//		//super : 부모 클래스의 멤버와 자식 클래스의멤버가 이름이 중복 될 때 둘을 구분하기 위해 사용한다 /멤버 : 변수와 메서드 둘 다 포함
//		System.out.println(this.method(10, 20)); //오버라이드한 메서드 호출
		System.out.println(super.method(10, 20)); // 부모클래스로부터 상속받은 메서드
	}
	
	SampleChild(){ //자식클래스 생성자를 사용하려면 반드시 부모클래스 생성자를 호출해야함
		super(); //부모클래스의 생성자 호출
		//super()를 통해 부모클래스의 생성자를 호출하고 부모클래스의 인스턴스 변수도 초기화한다
		//super()가 없으면 컴파일러가 자동으로 super()를넣어준다
		//생성자에 파라미터가 있을경우 자동으로 super()를 호출해주지 않으므로 반드시 super() 해줘야함
	}
	
	//다형성
	public static void main(String[] args) {
		SampleChild sc = new SampleChild();
		SampleParent sp = new SampleChild(); //부모 타입의 변수
		//sp = new SampleChild2();
		//sp = new SampleChild3(); 자식클래스가여럿 있을 경우 여러모습으로 바뀔 수 있어서 다형성이라 불림
		
		sc = (SampleChild)sp;
		sp = (SampleParent)sc;
		//형변환 생략 가능 : 자식타입 -> 부모타입 형변환
		
		sc = (SampleChild)new SampleParent(); //부모타입 -> 자식타입 형변환/ sc는 총 5개의 멤버사용 해야함 but 객체가 SampleParent이므로 총 2개의 멤버만 사용가능하므로 에러가 발생
		sp = new SampleChild(); //sp는 총 2개의 멤버 사용해야함 SampleChild는 총 5개 멤버가 있으므로 형변환 가능
	}
	
}
