package Test.cla;

import java.util.Arrays;

public class Boss {

	public static void main(String[] args) {
		
		TestAlba alva = new TestAlba();
		
		String[] order =  alva.order();
		System.out.println(Arrays.toString(order));
		
		String[] outer = {"선택된 자켓","선택된 블루종"};
		alva.select(outer);
		
		alva.pay(order);
		
	}

}
