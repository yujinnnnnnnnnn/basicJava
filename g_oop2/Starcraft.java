package g_oop2;

public class Starcraft {

	public static void main(String[] args) {
		
		Marine m = new Marine();
		Tank t = new Tank();
		Dropship d = new Dropship();
		SCV scv = new SCV();
		
//		scv.redpair(m);  //Marine 은 Repairable을 상속받지 않았기때문에 컴파일 에러가 뜸
		scv.redpair(t);
		scv.redpair(d);

	}

}

class Unit{
	int hp; //현재 체력
	final int MAX_HP;
	
	Unit(int hp){
		MAX_HP = hp;
		this.hp = MAX_HP;
	}
}
class Marine extends Unit{ //기계가 아님
	Marine(){
		super(40);
	}
}

class Tank extends Unit implements Repairable{
	Tank(){
		super(150);
	}
}
class Dropship extends Unit implements Repairable{
	Dropship(){
		super(125);
	}
}
class SCV extends Unit{  //다른유닛을 수리해줘야함
	SCV(){
		super(60);
	}
	
	void redpair(Repairable r){ //수리메서드 (누구를 수리해줄 것인지 수리 대상을 알아야함) marine이 기계가 아니므로 파라미터에 부모클래스로 타입을 쓰면 안됨 / 인터페이스타입을 사용해야함
		if(r instanceof Unit){     //Repairable 의 내용이 없기 때문에 instanceof로 Unit으로 형변환 가능여부 확인
			Unit u = (Unit)r;      //true 이면 unit타입으로 형변환함
			
			while (u.hp < u.MAX_HP){
				u.hp++;
			}
		}
	}
}

interface Repairable{   //Dropship 과 SCV 둘만의 관계를 만들어줌
	
}



