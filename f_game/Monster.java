package f_game;

public class Monster {
	String name;
	int hp; // 체력
	int maxHp;
	int maxMp;
	int mp; // 스킬
	int att; // 공격력
	int def; // 방어력
	Item[] items; // 보유하고 있는 아이템 //몬스터가 죽으면서 랜덤으로 보유 아이템 떨굼

	Monster(String name, int hp, int mp, int att, int def, Item[] items) {
		this.name = name;
		this.maxHp = hp;
		this.maxMp = mp;
		this.hp = this.maxHp;
		this.mp = this.maxMp; 
		this.att = att;
		this.def = def;
		this.items = items;  //파라미터로 받아야함
	}
	
	//공격 메서드     //ctrl +1 = 선택 대상 rename
	void attack(Character c) {   
		int damage = att - c.def;
		damage = damage <= 0 ? 1 : damage;
		c.hp = c.hp < damage ? c.hp - c.hp : c.hp - damage;// 상대방 체력 감소
		System.out.println(name + "가 공격으로 " + c.name + "에게 " + damage
				+ "만큼 데미지를 주었습니다.");
		System.out.println(c.name + "의 남은  Hp : " + c.hp); 
	}
	//아이템 떨어트리는 메서드
	Item itemDrop(){
		return items[(int)(Math.random() * items.length)];
	}
	
}
class ggobuck extends Monster{
	ggobuck(String name, int hp, int mp, int att, int def, Item[] items){
		super(name, hp, mp, att, def, items);
	}
	
	Character c = new Character("name", 10, 20, 30, 40);
	void method(){ //파라미터를 안적어준 이유는 위에 c를 선언해줘서 같이 클래스안에 있기 때문
		attack(c);
	}
}