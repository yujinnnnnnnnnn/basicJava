package Test.cla;

import java.util.Arrays;

public class TestAlba {
	
	// 옷가게 알바
	// 주문받기 위해 필요한것은 ?
	// 주문 후 사장님께 드려야하는 것

	// 주문하기
	String[] order() {
		System.out.println("찾으시는 상품 있으신가요??");
		return new String[] { "자켓", "블루종" };
	}

	// 옷찾기 위해 필요한것? 옷
	// 옷드리고 사장님께 줘야할 것? 없음
	void select(String[] outer){
		System.out.println("찾으시는 상품 여기 드릴게요");
	}
	
	//계산하기위해 필요한것 (찾았던 상품)
	//계산하고 난후 사장님께 드릴것 (없음)
	
	void pay(String[] order){
		System.out.println("총 6만원입니다 감사합니다.");
	}
	
}
