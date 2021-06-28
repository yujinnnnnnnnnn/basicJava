package e_oop;

public class Elevator {

	// 위 아래 버튼
	// 층수 버튼
	// 문여닫이 버튼


	boolean open;
	int floor;



	final int MIN_FLOOR = 1;
	final int MAX_FLOOR = 10;
	final int MIN_PEOPLE = 1;
	final int MAX_PEOPLE = 5;

 
	Elevator() {
		open = false;
		floor = 1;
	}

	void door() {
		open = !open;
		System.out.print(open ? "문이 열립니다." : "문이 닫힙니다.");
		System.out.println();
	}

	void changeFloor(int floor) {
		System.out.println(floor + "층을 누르셨습니다.");
		if (MIN_FLOOR <= floor && floor <= MAX_FLOOR) {
			if (this.floor < floor) {
				floorUp(floor);
			}else if (this.floor > floor) {
				floorDown(floor);
			}else {
				this.floor = floor;
				System.out.println(floor + "층 입니다.");
			}
		}
	}

	void floorUp(int floor) {
		door();
		System.out.println("올라갑니다.");
		for (int i = this.floor ; i <= floor; i++) {
			System.out.println(i + "층");
			this.floor = floor;
		}
		door();
	}

	void floorDown(int floor) {
		door();
		System.out.println("내려갑니다");
		for (int i = this.floor; i >= floor; i--) {
			System.out.println(i + "층");
			this.floor = floor;
		}
		door();
	}
	
	public static void main(String[] args) {
		Elevator ele = new Elevator();
		
		ele.door();

		while (true) {

			System.out.println("============");
			System.out.println(" 1   2   3 ");
			System.out.println(" 4   5   6 ");
			System.out.println(" 7   8   9 ");
			System.out.println(" 10        ");
			System.out.println("============");
			System.out.print("층을 입력해주세요> ");
			int input = ScanUtil.nextInt();

			ele.changeFloor(input);

			

 

		}

	}
}
