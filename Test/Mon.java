package Test;

public class Mon {
	String name;
	int hp;
	int maxHp;
	int att;
	int def;
	Item[] items;

	// 생성자로 초기화
	Mon(String name, int hp, int att, int def, Item[] items) {
		this.name = name;
		this.maxHp = hp;
		this.hp = this.maxHp;
		this.att = att;
		this.def = def;
		this.items = items;
	}

	// 공격 메서드
	void attack(Char c) {
		int damage = att - c.def; // 
		damage = damage <= 0 ? 1 : damage; // 데미지 구하기
		c.hp = c.hp < damage ? c.hp - c.hp : c.hp - damage; // 
															// 
		System.out.println(name + "(이)가  공격으로 " + c.name + "에게 " + damage
				+ " 만큼 데미지를 주었습니다.");
		System.out.println(">>>" + c.name + "의 남은 hp: " + c.hp);
	}

	// 아이템 떨어트리는 메서드
	Item itemDrop() {
		return items[(int) (Math.random() * items.length)];
	}
}
