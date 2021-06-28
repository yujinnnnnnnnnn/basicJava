package e_oop.restaurant;

import java.util.Arrays;

public class Alba {
	
	//메서드
	
	//주문하기 
	//주문받기 위해 필요한것? 없음 (파라미터)
	//주문받은 후 보스에게 줄 것? 주문서 (리턴)
	String[] order(){             
		System.out.println("주문하시겠습니까");
		return new String[]{"탕수육", "짜장면"};
	}
	//서빙하기 위해 필요한것? 음식  
	//서빙 후 보스에게 줄것 ? 없음
	void serving(String[] foods){
		System.out.println("주문하신 " + Arrays.toString(foods) + " 나왔습니다. 맛있게 드세요");
	}
	//계산하기 위해 필요한 것? 계산서 
	//계산 후 보스에게 줄 것? 없음
	void pay(String[] order){
		System.out.println("2만원 입니다.");
	}
}
