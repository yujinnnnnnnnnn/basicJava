package e_oop.restaurant;

import e_oop.ScanUtil;

public class TV {

	// 대상의 속성을 메서드로?
	// tv 속성 = 채널 / 볼륨 / 전원 /
	// 3개의 변수를 조작할 수 있는 메서드를 만들기
	// 리모컨 전원 변경 버튼 1나 -> 켜지고 꺼짐
	// 채널 변경 - 숫자누르기
	// -채널 올렸다가 내렸다가 => 3개의 메서드 (직접 숫자 입력해서 채널 변경/ 채널 올리는 메서드 1나/ 내리는 메서드 1나)
	// 볼륨 - 메서드 2개 올리는 것 내리는 것
	// 3개의 변수 와 6개의 메서드 만들기

	// 전원 변경
	// 채녈 변경
	// 채널 업
	// 채널 다운
	// 볼륨 업
	// 볼룸다운

	// 리모컨 버튼을 누를때 필요한것이 없음 / 버튼을 누를때 돌아오는 것도 없음
	// 채널 - 내가 원하는 채널의 정보가 필요함 업 /다운 현자 채널의 1만큼 올리고 내리고 피라미터 x
	// 볼륨 또한 마찬가지

	/*
	 * 과제. 임의의 사물을 대상으로 클래스를 만들어주세요. 사물이 가지고 있는 속성을 변수로 만들고, 변수와 관계된 동작들을 메서드로
	 * 만들어주시면 됩니다.
	 */

	boolean power; // 전원
	int channel; // 채널
	int volume; // 음량

	final int MIN_CHANNEL = 18;
	final int MAX_CHANNEL = 32;
	final int MIN_VOLUME = 0;
	final int MAX_VOLUME = 10;

	TV() {
		power = false;
		channel = 1;
		volume = 5;
	}

	void power() {
		power = !power;
		System.out.println(power ? "TV 켜짐" : "TV 꺼짐");
	}

	void changeChannel(int channel) {
		if (power) {
			if (MIN_CHANNEL <= channel && channel <= MAX_CHANNEL) {
				this.channel = channel;
			}
			System.out.println("채널. " + this.channel);
		}
	}

	void channelUp() {
		changeChannel(channel + 1);
	}

	void channelDown() {
		changeChannel(channel - 1);
	}

	void volumeUp() {
		if (power) {
			if (volume < MAX_VOLUME) {
				volume++;
			}
			showVolume();
		}
	}

	void volumeDown() {
		if (power) {
			if (MIN_VOLUME < volume) {
				volume--;
			}
			showVolume();
		}
	}

	void showVolume() {
		System.out.print("음량. ");
		for (int i = MIN_VOLUME + 1; i <= MAX_VOLUME; i++) {
			if (i <= volume) {
				System.out.print("●");
			} else {
				System.out.print("○");
			}
		}
		System.out.println();
	}

	public static void main(String[] args) {
		TV tv = new TV();

		while (true) {
			System.out.println("-------------------------------");
			System.out.println("1.전원  2.채널변경  3.채널업  4.채널다운");
			System.out.println("5.볼륨업  6.볼륨다운  0.종료");
			System.out.println("-------------------------------");
			System.out.print("번호 입력>");
			int input = ScanUtil.nextInt();

			switch (input) {
			case 1:
				tv.power();
				break;

			case 2:
				System.out.print("변경할 채널 입력>");
				int ch = ScanUtil.nextInt();
				tv.changeChannel(ch);
				break;

			case 3:
				tv.channelUp();
				break;
			case 4:
				tv.channelDown();
				break;
			case 5:
				tv.volumeUp();
				break;
			case 6:
				tv.volumeDown();
				break;

			default:
				System.out.println("종료되었습니다.");
				System.exit(0);
				break;
			}
		}
	}

}

// 임의의 사물을 대상으로 클래스를 만들고
// 사물이 가지고 있는 속성을 변수로 만들고
// 변수와 관계된 동장득르 메서드로 만들기

