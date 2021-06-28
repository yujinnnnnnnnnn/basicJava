package g_oop2.test;

import g_oop2.AccessModifier;

public class AccessTest extends AccessModifier {

	public static void main(String[] args) {
		
		AccessModifier am = new AccessModifier();
		
		System.out.println(am.publicVar);
		am.publicMethod();
		
//		System.out.println(am.protectedVar); //access modifier 를 통해서 상속받아서 쓸 수 없음 따라서 access test에서 사용해야함
//		am.protectedMethod();
		
//		System.out.println(am.defaultVar);
//		am.defaultMethod();
		
	//	System.out.println(am.privateVar);  //다른 클래스에선 사용 불가능
	//	am.privateMethod();
		
		AccessTest at = new AccessTest();
		
		System.out.println(at.protectedVar);
		at.protectedMethod();

	}

}
