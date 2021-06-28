package d_array;

import java.util.Arrays;
import java.util.Scanner;


public class test {

public static void main(String[] args) {
		
		// 입력한 숫자(1~25)만큼 우리반 학생들 중 랜덤으로 뽑아서 출력하는 프로그램을 만들어주세요.
		Scanner s = new Scanner(System.in);
		String[] Students = { "강유진", "강지수", "곽재우", "구본성", "권수연", "김보영", "김소희",
				"김지수", "백지혜", "송유경", "신희철", "심선주", "오수연", "윤희중", "이경준", "이석호",
				"이승구", "이여강", "이영민", "이영우", "이용석", "이정범", "최기문", "최소은", "최윤지" };

		System.out.println("1~25사이의 숫자를 입력해주세요>");
		int num = Integer.parseInt(s.nextLine());
		int[] array;// 선언
		array = new int[num];

		String answer = null;
		int random = 0;

		for (int i = 0; i < num; i++) {//0 1 2 3
			random = (int) (Math.random() * 25) + 1;
			array[i] = random;

			for (int j = 0; j < i; j++) {//0 array[1] == array[0] / array[2] == array[0] array[2] == array[1] /array[3] == array[0] array[3] == array[1] array[3] == array[0-]
				if (array[i] == array[j]) {
					i--;
					break;
				}
				
			}
			
		
		}
		for (int i = 0; i < array.length; i++){
		random = array[i];
		answer = Students[random];
		System.out.println(answer);
		}

	

//		for (int i = 0; i < num; i++) {
//			random = array[i];
//			answer = Students[random];
//			System.out.println(answer);
//		}

	}

}

