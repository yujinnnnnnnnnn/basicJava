package f_game;

import e_oop.ScanUtil;

public class MyGame {
	//변수선언
	Character c;  
	Item[] items;
	//초기화 
	MyGame() {
		c = new Character("가렌", 100, 50, 20, 10);

		items = new Item[10];
		items[0] = new Item("무한의 대검", 0, 0, 10, 0);
		items[1] = new Item("가시갑옷", 0, 0, 0, 10);
	}

	public static void main(String[] args) {
		new MyGame().start();
//		ggobuck go = new ggobuck("꼬북이", 10, 20, 30, 40, Item[]{ items[0],
//				items[1] });
	}// static 없이 사용하기 위해 위에 객체생성해주고 아래에 메서드 만들어서 사용

	private void start() {
		int input = 0; //지역변수를 만들때는 선언과 초기화를 해주는 것이 좋음
		while (true) {
			System.out.println("1. 내정보\t 2.사냥 \t0.종료");
			input = ScanUtil.nextInt();

			switch (input) {
			case 1:
				c.showInfo();
				break;
			case 2:
				hunt(); // 내용 길어서 따로 메서드 만듬
				break;
			case 0:
				System.out.println("종료되었습니다.");
				System.exit(0);
				break;

			}
		}

	}

	// 사냥 메서드
	void hunt() {
		Monster m = new Monster("고블린", 20, 10, 15, 10, new Item[] { items[0],
				items[1] });
		System.out.println(m.name + "를 만났습니다. 전투를 시작합니다.");

		int input = 0;
		battle: while (true) {
			System.out.println("1.공격\t2.도망");
			input = ScanUtil.nextInt();
			switch (input) {
			case 1:
				c.attack(m);
				if (m.hp <= 0) {
					System.out.println(m.name + "을 처치하였습니다");
					c.getExp(150);
					c.getItem(m.itemDrop());
					break battle;
				}
				m.attack(c);
				break;
			case 2:
				System.out.println(m.name + "으로부터 도망쳤습니다");
				break battle;
			}
		}
	}
}
