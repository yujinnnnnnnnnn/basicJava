package Test;

import e_oop.ScanUtil;

public class Game {
	Char c;
	Item[] items;

	Game() {
		c = new Char("피카츄", 80, 30, 10);

		items = new Item[10];
		items[0] = new Item("꼬부기 꼬리", 0, 2, 0);
		items[1] = new Item("꼬부기 입 ", 3, 2, 0);
		items[2] = new Item("데구리의 돌가루",  0, 7, 5);
		items[3] = new Item("데구리의 주먹 ", 8,  3, 2);
		items[4] = new Item("데구리의 돌덩이", 5,  6, 0);
		items[5] = new Item("뮤츠 손", 5,  2, 8);
		items[6] = new Item("뮤츠 발 ", 6, 0, 10);
		items[7] = new Item("뮤츠 유전자", 18, 4, 6);
		items[8] = new Item("HP회복력", 10, 3, 10);
		items[9] = new Item("뮤츠의 명상", 21, 10, 10);
	}
 	public static void main(String[] args) {
		// 포켓몬스터 게임
		new Game().start();
	}
	private void start() {
		int input = 0;
		while (true) {
			System.out.println("");
			System.out.println("=======pokemon fight Game=======");
			System.out.println("1.피카츄정보\t2.공격 ");
			System.out.println("3.몬스터 정보\t0. 종료");
			input = ScanUtil.nextInt();
			switch (input) {
			case 1:
				c.showInfo();
				break;
			case 2:
				fight();
				break;
			case 3:
				int input2 = 0;
				System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
				System.out.println("단계별 몬스터들의 정보를 알고 싶으면 번호를 입력해주세요.");
				System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
				System.out.println("1. level 1단계 : 꼬부기");
				System.out.println("2. level 2단계 : 데구리");
				System.out.println("3. level 3단계 : 뮤츠");
				
				input2 = ScanUtil.nextInt();
				//몬스터 정보 메서드
				switch(input2){
				case 1:
					System.out.println();
					System.out.println("이름 : 꼬부기\n 체력 : 30\n공격력 : 15\n방어력 : 10\n특징: 물을 좋아함"); break;
				case 2:
					System.out.println();
					System.out.println("이름 : 데구리\n 체력 : 50\n공격력 : 42\n방어력 : 18\n특징: 단단한 바위덩어리 그자체"); break;
				case 3:
					System.out.println();
					System.out.println("이름 : 뮤츠\n 체력 : 110\n공격력 : 56\n방어력 : 43\n특징: 연구소에서 유전자조작을 통해 만들어진 이기적 유전자를 보유"); break;
				} break;
			case 0:
				System.out.println("종료되었습니다 ");
				System.exit(0);
			}
		}
	}
	// fight 메서드
	void fight() {
		if (c.level == 1) {
			Mon m = new Mon("꼬부기", 30, 15, 10, new Item[] { items[0],
					items[1] });
			System.out.println(m.name + "을(를)만났습니다. 공격하시겠습니까?");
			int input = 0;
			battle: while (true) {
				System.out.println("1. 공격 \t 2. 포켓못볼 안으로 피신");
				input = ScanUtil.nextInt();
				//스킬 메서드
				switch (input) {
				case 1:
					int input2 = 0;
					System.out.println("스킬을 고르세요.");
					System.out.println("1.백만볼트\t2. 발톱할퀴기");
					input2 = ScanUtil.nextInt();

				switch(input2){
				case 1:
					System.out.println("백만볼트를 선택하셨습니다");
					System.out.println();
			
					System.out.println("전기구슬로 싸우는중 ...");
					stop(500);
					break;
				case 2:
					System.out.println("발톱할퀴기를 선택하셨습니다");
					System.out.println();
					System.out.println("발톱을 세우며 싸우는중 ...");
					stop(500);
					break;
				}
					c.attack(m);
					if (m.hp <= 0) {
						System.out.println(m.name + "을(를) 이겼습니다.");
						c.getExp(40);
						c.getItem(m.itemDrop());
						break battle;
					}
					m.attack(c);
					stop(500);
					System.out.println();
					if(c.hp <= 0){
						System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
						System.out.println(m.name + "에게 공격당해 기력을 찾지 못합니다.");
						System.out.println("몬스터볼로 들어갔습니다. 다음 기회에 도전하세요 ㅜ 3 ㅜ");
						System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
						System.exit(0);
					}
					break;
				case 2:
					System.out.println(m.name + " (을)를 피해 포켓몬볼 안으로 도망쳤습니다.");
					break battle;
				}
			}
		} else if (c.level == 2) {
			Mon m = new Mon("데구리", 50, 42, 18, new Item[] { items[2],
					items[3], items[4] });
			System.out.println(m.name + "을(를)만났습니다. 공격을 시작합니다.");
			int input = 0;
			battle: while (true) {
				System.out.println("1. 공격 \t 2. 포켓몬볼 안으로 피신");
				input = ScanUtil.nextInt();
				switch (input) {
				case 1:
					int input2 = 0;
					System.out.println("스킬을 고르세요.");
					System.out.println("1.백만볼트\t2. 발톱할퀴기");
					input2 = ScanUtil.nextInt();

					switch(input2){
					case 1:
						System.out.println("백만볼트를 선택하셨습니다");
						System.out.println();
						System.out.println("전기구슬로 싸우는중 ...");
						stop(500);
						break;
					case 2:
						System.out.println("발톱할퀴기를 선택하셨습니다");
						System.out.println();
						System.out.println("발톱을 세우며 싸우는중 ...");
						stop(500);
						break;
					}
					c.attack(m);
					if (m.hp <= 0) {
						System.out.println(m.name + "을(를) 이겼습니다.");
						c.getExp(55);
						c.getItem(m.itemDrop());
						break battle;
					}
					m.attack(c);
					stop(500);
					System.out.println();
					if(c.hp <= 0){
						System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
						System.out.println(m.name + "에게 공격당해 기력을 찾지 못합니다.");
						System.out.println("몬스터볼로 들어갔습니다. 다음 기회에 도전하세요 ㅜ 3 ㅜ");
						System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
						System.exit(0);
					}
					break;
				case 2:
					System.out.println(m.name + " (을)를 피해 포켓몬볼 안으로 도망쳤습니다.");
					break battle;
				}
			}
		} else {
			Mon m = new Mon("뮤츠", 110, 56, 43, new Item[] { items[5],
					items[6], items[7], items[8], items[9] });
			System.out.println(m.name + "을(를)만났습니다. 공격을 시작합니다.");
			int input = 0;
			battle: while (true) {
				System.out.println("1. 공격 \t 2. 포켓몬볼 안으로 피신");
				input = ScanUtil.nextInt();
				//스킬 메서드
				switch (input) {
				case 1:
					int input2 = 0;
					System.out.println("스킬을 고르세요.");
					System.out.println("1.백만볼트\t2. 발톱할퀴기");
					input2 = ScanUtil.nextInt();

					switch(input2){
					case 1:
						System.out.println("백만볼트를 선택하셨습니다");
						System.out.println();
						System.out.println("전기구슬로 싸우는중 ...");
						stop(500);
						break;
					case 2:

						System.out.println("발톱할퀴기를 선택하셨습니다");
						System.out.println();
						System.out.println("발톱을 세우며 싸우는중 ...");
						stop(500);
						break;
					}
					c.attack(m);
					if (m.hp <= 0) {
						System.out.println(m.name + "을(를) 이겼습니다.");
						c.getExp(60);
						c.getItem(m.itemDrop());
						break battle;
					}
					m.attack(c);
					stop(500);
					System.out.println();
					if(c.hp <= 0){
						System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-==-=-");
						System.out.println(m.name + "에게 공격당해 기력을 찾지 못합니다.");
						System.out.println("몬스터볼로 들어갔습니다. 다음 기회에 도전하세요 ㅜ 3 ㅜ");
						System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
						System.exit(0);
					}
					break;
				case 2:
					System.out.println(m.name + " (을)를 피해 포켓몬볼 안으로 도망쳤습니다.");
					break battle;
				}
			}
		}
	}

	private void stop(int interval) {
		try {
			Thread.sleep(interval);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}