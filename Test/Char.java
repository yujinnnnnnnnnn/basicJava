package Test;

public class Char {
	String name;
	int hp;
	int maxHp;
	int level;
	int att;
	int def;
	int exp;
	Item[] items;

	Char(String name, int hp, int att, int def) {
		this.name = name;
		this.maxHp = hp;
		this.hp = this.maxHp;
		this.att = att;
		this.def = def;
		this.exp = 0;
		this.level = 1;
		this.items = new Item[10]; // 아이템 10개의 공간을 만듦
	}
 
	// 캐릭터 상태출력 메서드 (상태창)

	void showInfo() {
		System.out.println("================================");
		System.out.println("---------------상태--------------");
		System.out.println("이름 : " + name);
		System.out.println("레벨 : " + level + "(" + exp + "/100)");
		System.out.println("체력 : " + hp + "/" + maxHp);
		System.out.println("공격 : " + att);
		System.out.println("방어: " + def);
		System.out.println("---------------아이템--------------");
		for (int j = 0; j < items.length; j++) {
			if (items[j] != null) {
				System.out.println(items[j].itemInfo());
			}
		}
		System.out.println("=================================");
	}

	void attack(Mon m) {
		int damage = att - m.def;
		damage = damage <= 0 ? 1 : damage;
		m.hp = m.hp < damage ? m.hp - m.hp : m.hp - damage;
		System.out.println();
		System.out.println(name + "가 " + m.name + " 에게 " + damage
		+ "만큼 데미지를 주었습니다.");
		System.out.println(">>>" + m.name + " 의 남은 Hp : " + m.hp);
		System.out.println();
	}

	// 경험치얻는 메소드

	void getExp(int exp) {
		System.out.println(exp + "의 경험치를 획득하였습니다");
		this.exp += exp;
		while (100 <= this.exp) {
			levelUp();
			this.exp = 0;
		}
	}
 
	// 레벨업 메서드

	void levelUp() {
		level++;
		maxHp += 15;
		att += 10;
		def += 10;
		hp = maxHp;
		win();
		System.out.println("LevelUp! ");
	}
//이겼을 때
	void win() {
		if (level == 4) {
			System.out.println("모든 몬스터를 처치하였습니다.");
			System.out.println();
			System.out.println("★☆★☆★☆!!WIN!!★☆★☆★☆ ");
			System.exit(0);
		}
	}
	// 아이템 얻는 메서드

	void getItem(Item item) {
		System.out.println(item.name + " 을 획득하였습니다");
		for (int i = 0; i < items.length; i++) {
			if (items[i] == null) {
				items[i] = item;
				break;
			}
		}
		maxHp += item.hp;
		hp += item.hp;
		att += item.att;
		def += item.def;
	}
}
