package j_collection;

import java.util.ArrayList;
import java.util.Scanner;

public class ArrayListClass {

	public static void main(String[] args) {
		/*
		 * Collections Framework (배열의 길이와 타입이 같아야 사용가능한 단점을 보완할 수 있음) - 다수의 데이터를
		 * 다루기 위한 표준방식 - List - Map - Set - 위 3개는 인터페이스임 (부모역할)
		 * 
		 * ArrayList의 주요 메서드 - boolean add(Object obj) : 마지막 위치에 객체를 추가 후 성공여부를
		 * 반환 - void add(int index, Object obj) : 지정된 위치에 객체를 추가한다 / 인덱스를 지정해서 그
		 * 위치에 저장(저장길이를 벗어난 인덱스에 저장 못함) - Object set(int index, Object obj):
		 * 지정된위치에 객체를 저장후 기존 객체를 반환 (수정) / 기존에 있던 값을 덮어서 수정 / add와의 차이점 : add는
		 * 그다음 인덱스로 밀려나감 - Object get(int index) : 지정된 위치의 객체를 반환 / 파라미터로 인덱스를
		 * 넣어주면 인덱스에 저장된 값을 알수 있음 - int size() : 저장된 객체의 수 반환 (값의 갯수) - Object
		 * remove(int index): 지정된 위치의 객체를 제거 /파라미터의 인덱스에 저장된 값 없어짐 / 값이 없어지면
		 * 뒤에있는 값들이 앞으로 당겨짐/ 지운 값을 반환 - 첫길이 : 0 => 저장한만큼 길이가 늘어남 / 삭제하면 길이가 줄어듬
		 * (저장한 갯수만큼 유지) - 길이가 부족해지면 2배 늘려 기존의 값을 저장함
		 */

		ArrayList sample = new ArrayList();
		// add
		sample.add("abc");
		sample.add(100); // sample에 또한번 저장해줌
		sample.add(new Scanner(System.in)); // 타입 상관없이 저장할 수 있음 => 아무타입을 넣으면
											// 꺼냈을때 예측 불가능

		ArrayList<Integer> list = new ArrayList<>(); // Collection에는 <>안에 타입을
														// 지정할 수 있음 => 제네릭이라고 부름
		list.add(new Integer(10));
		// list.add("abc"); //타입이 맞지않아 컴파일에러뜸
		list.add(20); // integer 와 int 는 같은 데이터 / 기본형타입을 객체로 사용해야할 때 integer라는
						// 클래스를 만들어 사용
		/*
		 * 래퍼 클래스 
		 * 		기본형 			객체
		 *  - byte 			: Byte 
		 *  - short 		: Short 
		 *  - int 			: Integer 
		 *  - long			: Long
		 * - float 			: Float 
		 * - double 		: Double 
		 * - boolean 		: Boolean 
		 * - char 			: Character
		 * -str 			: String
		 *  => 기본형과 객체는 자동형변환 가능
		 *
		 */

		System.out.println(list);

		list.add(1, 30); // (위치 지정 , 값 ) => 기존 20 값은 뒤로 밀려감
		System.out.println(list);

		// set, get
		int before = list.set(2, 40);
		System.out.println("before : " + before); // set은 기존 값을 리턴해줌 (=20)
		System.out.println("after : " + list.get(2)); // 특정 인덱스의 값을 가지고 오고 싶을때
														// 사용
		System.out.println(list);

		for (int i = 0; i < list.size(); i++) {
			System.out.println(i + " : " + list.get(i));
		}
		// remove
		list.remove(1);
		System.out.println(list); // arraylist size : 3 -> 2로 줄어듬
		// list에서 값 여러개 제거 => 앞에서 뒤로가 아닌, 뒤에서 앞으로 범위를 정해야함(제거하면서 앞으로 당겨오기 때문임)/
		// 지운 값을 반환
		for (int i = list.size() - 1; i >= 0; i--) {
			list.remove(i);
		}
		System.out.println(list);

		// list에 1~100사이의 랜덤값을 10개 저장해주세여
		for (int i = 0; i < 10; i++) {
			int ran = (int) (Math.random() * 100) + 1;
			list.add(ran);
		}
		System.out.println(list);

		int sum = 0;
		double avg = 0;

		for (int i = 0; i < list.size(); i++) {
			sum += list.get(i);
		}
		avg = (double) sum / list.size();
		System.out.println("sum : " + sum + " avg : " + avg);

		// 최소값과 최대값을 구해주세요

		int min = list.get(0);
		int max = list.get(0);
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i) < min) {
				min = list.get(i);
			}
			if (list.get(i) > max) {
				max = list.get(i);
			}
		}
		System.out.println(min + " " + max);

		// 정렬
		for (int i = 0; i < list.size() - 1; i++) {
			int min2 = i;
			for (int j = i + 1; j < list.size(); j++) {
				if (list.get(min2) > list.get(j)) {
					min2 = j;
				}
			}
			int temp = list.get(i); // 대입연산자는 무조건 변수여야함
			list.set(i, list.get(min2));
			list.set(min2, temp);
		}
		System.out.println(list);

		// 2차원
		ArrayList<ArrayList<Integer>> list2 = new ArrayList<>();
		// 값 저장
		ArrayList<Integer> list3 = new ArrayList<>();
		list3.add(10);
		list3.add(20);
		list3.add(30);

		list2.add(list3); // list3이라는 변수를 저장한 것이 아닌 안에 담겨있는 arraylist를 저장한 것
		System.out.println(list2);

		list3 = new ArrayList<>(); // 그래서 list3변수를 다시 사용
		list3.add(40);
		list3.add(50);

		list2.add(list3);
		System.out.println(list2);

		// 값 꺼내기
		for (int i = 0; i < list2.size(); i++) {
			ArrayList<Integer> list4 = list2.get(i);
			for (int j = 0; j < list4.size(); j++) {
				System.out.print(list4.get(j) + "\t");
			}
			System.out.println();
		}
		// 2차원에 있는 것 꺼내고 또 꺼내서 사용한것
		// for (int j = 0; j < list2.get(i).size(); j++) {
		// System.out.print(list2.get(i).get(j));

	}
}
