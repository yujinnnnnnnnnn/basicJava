package Test;

import java.util.ArrayList;

public class ArrayClassScore {

	public static void main(String[] args) {
		/*
		 * 우리반 모두의 국어, 영어, 수학, 사회, 과학, Oracle, Java 점수를
		 * 0 ~ 100까지 랜덤으로 생성해주시고, 아래와 같이 출력해주세요.
		 * 
		 * 			국어		영어		수학		사회		과학		Oracle	Java	합계		평균		석차
		 * 홍길동		90		90		90		90		90		90		90		630		90.00	1
		 * 홍길동		90		90		90		90		90		90		90		630		90.00	1
		 * 홍길동		90		90		90		90		90		90		90		630		90.00	1
		 * 홍길동		90		90		90		90		90		90		90		630		90.00	1
		 * 홍길동		90		90		90		90		90		90		90		630		90.00	1
		 * 과목합계	450		450		450		450		450		450		450
		 * 과목평균	90.00	90.00	90.00	90.00	90.00	90.00	90.00
		 */

		ArrayList<String> name = new ArrayList<>();
		name.add("강유진");
		name.add("강지수");
		name.add("심선주");
		name.add("김수연");
		name.add("고시현");
		ArrayList<String> sub = new ArrayList<>();
		sub.add("국어");
		sub.add("영어");
		sub.add("수학");
		sub.add("사회");
		sub.add("과학");
		sub.add("oracle");
		sub.add("java");
		
		ArrayList<ArrayList<Integer>> score = new ArrayList<>();
		ArrayList<Integer> nameSum = new ArrayList<>();
		ArrayList<Integer> nameAvg = new ArrayList<>();
		ArrayList<Integer> subSum = new ArrayList<>();
		ArrayList<Integer> subAvg = new ArrayList<>();
		ArrayList<Integer> rank = new ArrayList<>();
		
		for (int i = 0; i < name.size(); i++) {
			ArrayList<Integer>score2 =new ArrayList<>();
			for (int j = 0; j < sub.size(); j++) {
				score2.add((int)(Math.random()*101)); 
			}
		}
		
	}

}
