package e_oop;

public class Static {
	/*
	 * static을 붙이면 프로그램 실행시 메모리에 올라간다
	 * 객체생성을 하지 않아도 사용할 수 있다
	 * static을 붙인 변수는 객체간에 변수의 값을 공유한다 => 값이 동일
	 * static이 붙은 멤버의 명칭 : 클래스 변수, 클래스 메서드 => 클래스 이름을 통해 사용
	 * static이 붙지 않은 멤버의 명칭 : 인스턴스 변수, 인스턴스 메서드 => 객체를 통해 사용
	 */
	
	static int var; // 클래스 변수 : 값을 공유하기 위해 사용
	
	public static void main(String[] args) {
		Saram s1 = new Saram();
		Saram s2 = new Saram();
		
		s1.name = "철수";
		s2.name = "영희";
		
		s1.saveMoney(100000);
		s2.saveMoney(200000);
		
		s1.saveDateMoney(200000);
		s2.saveDateMoney(200000);
		// 값이 공유되어서 40만원이 됨
		
		//System.out.println(Math.random());
		// Math.random 는 static이  있기 때문에 바로 호출가능
		
		//static 
		//메서드에서 사용 - 자주사용하기 때문에 객체생성하지 않고 바로 호출가능  
		//객체에서 사용 - 값을 공유하기 위해 
		
		
		System.out.print("문자열 입력 > ");
		String str = ScanUtil.nextLine();
		System.out.println(str);
		
		System.out.print("숫자 입력 >");
		int num = ScanUtil.nextInt();
		System.out.println(num);
		
	}

}

class Saram{
	
	String name;  //이름을 표현할 변수
	int account;  // 계좌 잔고 표현할 변수
	
	void saveMoney(int money){   
		account += money;
		System.out.println(name + "의 계좌 잔고 : " + account);
	}
	
	static int dateAccount; //데이트 통장 (객체에서는 값 공유)
	 
	void saveDateMoney(int money){
		 dateAccount += money;
		 System.out.println("데이트 통장 잔고 : " + dateAccount);
	 }
}