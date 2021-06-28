package f_game;

public class Character {
	String name;
	int hp; // 체력
	int maxHp;
	int maxMp;
	int level;
	int mp; // 스킬
	int att; // 공격력
	int def; // 방어력
	int exp; // 경험치
	Item[] items; // 보유하고 있는 아이템

	Character(String name, int hp, int mp, int att, int def) {
		this.name = name;
		this.maxHp = hp;
		this.maxMp = mp;
		this.hp = this.maxHp;
		this.mp = this.maxMp;
		this.att = att;
		this.def = def;
		this.level = 1;
		this.exp = 0;
		this.items = new Item[10];
	} // 초기화 생성자

	// 캐릭터 상태출력 메서드 (상태창) -- 파라미터는 외부 클래스에서 필요한 것만 적음
	void showInfo() {
		System.out.println("============================");
		System.out.println("-----------상태--------------");
		System.out.println("이름 : " + name);
		System.out.println("레벨 :" + level + "(" + exp + "/100)");
		System.out.println("체력 :" + hp + "/" + maxHp);
		System.out.println("마나 :" + mp + "/" + maxMp);
		System.out.println("공격 :" + att);
		System.out.println("방어 :" + def);
		System.out.println("------------아이템------------");
		for (int i = 0; i < items.length; i++) {
			if (items[i] != null) {
				System.out.println(items[i].itemInfo());
			}
		}
		System.out.println("=============================");
	}

	// 누구를 공격할지 파라미터에 넣음 / 얼마만큼 데미지를 줄것인가 생각해야함
	void attack(Monster m) {
		int damage = att - m.def;
		damage = damage <= 0 ? 1 : damage;
		m.hp = m.hp < damage ? m.hp - m.hp : m.hp - damage;// 몬스터 체력 감소
		System.out.println(name + "가 공격으로 " + m.name + "에게 " + damage
				+ "만큼 데미지를 주었습니다.");
		System.out.println(m.name + "의 남은  Hp : " + m.hp); // 공격메서드
	}

	// 공격하면 얻을 것 1. 아이템 /2 경험치

	// 경험치 얻는 메소드
	void getExp(int exp) {
		System.out.println(exp + "의 경험치를 획득하였습니다");
		this.exp += exp; // 내경험치 증가
		while (100 <= this.exp) { // 최대치 100 이상이 되면 레벨업
			levelUp();
			this.exp -= 100; // 한번 레벨업 할때마다 100을 빼서 경험치 리셋
		}
	}

	// 레벨업 메소드
	void levelUp() {
		level++; // 레벨 1만큼 증가
		maxHp += 10;
		maxMp += 5;
		att += 2;
		def += 2;
		hp = maxHp; // 현재 채력을 최대 체력까지 올려줌
		mp = maxMp;
		System.out.println("LEVEL UP!");
	}

	// 아이템을 얻는 메소드
	void getItem(Item item) {
		System.out.println(item.name + "을 획득하였습니다");
		for (int i = 0; i < items.length; i++) {
			if (items[i] == null) {
				items[i] = item;
				break;
			}
		}
		maxHp += item.hp;
		maxMp += item.mp;
		att += item.att;
		def += item.def;
	}
}
