package g_oop2;

public class AccessModifier {

	// 접근제어자 public /
	/*
 * 
 * 	
 */
	public String publicVar = "public : 접근제한이없음"; // 어디에서 누구나
	protected String protectedVar = "protected : 같은 패키지 + 상속받은 클래스에서 접근가능";
	String defaultVar = "default : 같은 패키지에서만 접근가능";
	private String privateVar = "prevate : 클래스 내에서만 접근가능";

	public void publicMethod() {
		System.out.println(publicVar);
	}

	public void protectedMethod() {
		System.out.println(protectedVar);
	}

	void defaultMethod() {
		System.out.println(defaultVar);
	}

	public void privateMethod() {
		System.out.println(privateVar);
	}

	public static void main(String[] args) {
		AccessModifier am = new AccessModifier();

		System.out.println(am.publicVar);
		am.publicMethod();

		System.out.println(am.protectedVar);
		am.protectedMethod();

		System.out.println(am.defaultVar);
		am.defaultMethod();

		System.out.println(am.privateVar);
		am.privateMethod();

		/*
		 * 접근제어자를 사용하는 이유 
		 * - 데이터를보호하기 위해 
		 * - 사용하는데 불필요한 멤버를 숨기기 위해
		 */

		Time t = new Time();
		
		// t.hour 13;
		// t.minute = 59;
		// t.second = -30;

		t.setHour(13);
		t.setMinute(590);
		t.setSecond(-2);
		System.out.println(t.getTime());
		
		t.clock();
		
	}
}
