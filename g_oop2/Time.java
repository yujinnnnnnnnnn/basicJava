package g_oop2;

public class Time {

	private int hour;
	private int minute;
	private int second;  //옳지 못한 데이터 입력을 막기 위해 private를만들어줌

	// 로직을 만들어서 잘못된 값을 막을 수 있음
	public int getHour() {  //get : 변수의 값 얻기위한 메서드
		return hour;
	}

	public void setHour(int hour) { //get : 변수의 값 저장하기 위한 메서드 
		// if (0 <= hour && hour < 24)
		// this.hour = hour;

		if (hour < 0) {
			this.hour = 0;
		} else if (23 < hour) {
		//	this.hour = 23;
			this.hour = hour % 24;
		} else {
			this.hour = hour;
		}
	}

	public int getMinute() {
		return minute;
	}

	public void setMinute(int minute) {
		// if (0 <= minute && minute <= 59)
		// this.minute = minute;

		if (minute < 0) {
			this.minute = 0;
		} else if (59 < minute) {
	//		this.minute = 59;
			this.minute = minute % 60;
			setHour(this.hour + minute /60);
		} else {
			this.minute = minute;
		}
	}

	public int getSecond() {
		return second;
	}

	public void setSecond(int second) {
		// if (0 <= second && second <= 59)
		// this.second = second;

		if (second < 0) {
			this.second = 0;
		} else if (59 < second) {
		//	this.second = 59;
			this.second = second % 60;
			setMinute(this.minute + second /60);
		} else {
			this.second = second;
		}
//		if (second == 60) {
//			this.second = 0;
//			this.minute = minute + 1;
//		}
//		if (minute == 60) {
//			this.minute = 0;
//			this.hour = hour + 1;
//		}
	}

	String getTime() {
		return hour + ":" + minute + ":" + second;
	}

	void clock() { // 1초마다 시간 증가 출력 메서드 (외부에 사용할 메서드 )
		while (true) {
			System.out.println(getTime());
			stop(500);
			setSecond(second + 1);
		}
	}

	private void stop(int interval) { //클래스 외부에서 안보이도록 private를 씀
		try {
			Thread.sleep(interval);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
