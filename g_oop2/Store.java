package g_oop2;

public class Store {

	public static void main(String[] args) {
		//상점
		//공통멤버 : 물건이름, 가격 => 부모클래스
		//손님 클래스 : 물건 구매하도록 만들기
		
		//객체생성
		Desktop d1 = new Desktop("삼성 컴퓨터", 100000);
		Desktop d2 = new Desktop("LG 컴퓨터", 100000);
		
		AirCon ac1 = new AirCon("삼성 에어컨" , 200000);
		AirCon ac2 = new AirCon("LG 에어컨" , 200000);
		
		TV tv1 = new TV("삼성 TV", 300000);
		TV tv2 = new TV("LG TV", 300000);
		
		Customer c = new Customer();
		
		System.out.println(d1.getInfo());
		System.out.println(d2.getInfo());
		c.buy(d2);
		
		c.buy(ac2);
		
		c.buy((Product)tv1); //형변환해준것 
		
		
	}

}

class Product{
	String name; // 이름
	int price; // 가격
	
	//파라미터를 받으려면 생성자 사용
	Product(String name, int price){
		this.name = name;
		this.price = price;
	}
	
	String getInfo(){
		return name + "(" + price +"원)";
	}
} 

class Desktop extends Product{
	Desktop(String name, int price){  
		super(name, price);    //부모클래스 생성자 호출 변수까지 선언
	}
	void programming(){
		System.out.println("프로그램을 만듭니다.");
	}
}

class AirCon extends Product{
	AirCon(String name, int price){
		super(name, price);
	}
	void setTemperature(){
		System.out.println("온도를 설정합니다");
	}
}

class TV extends Product{
	TV(String name, int price){
		super(name, price);
	}
	void setChannel(){
		System.out.println("채널을 변경합니다");
	}
}

class Customer{  //물건을 사면 물건을 가지고 있어야함 - 타입이 각자 달라 부모클래스로 배열 만듦
	int money = 100000000;
	
	Product[] item = new Product[100];
	
	//구매메서드 어떤물건을 살것인지 파라미터로 받아야함
	void buy(Product p){
//		((TV)p).setChannel(); //무조건 tv가 넘어온다고 가정했을때
		
		if(money < p.price){
			System.out.println("잔돈이 부족하다.");
			return;
		}
		
		money -= p.price;
		
		for (int i = 0; i < item.length; i++) {
			if(item[i] == null){
				item[i]=p;
				break;
			}
		}
		System.out.println(p.getInfo() + "를구매했다");
	}
	
}