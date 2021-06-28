package d_array;

import java.util.Arrays;
import java.util.Scanner;


public class RandomStudents {

	public static void main(String[] args) {
		//입력한 숫자만큼 우리반 학생들중 랜덤으로 뽑아서 출력하는 프로그램을 만들어주세요.
		
		String[] students = new String[]{"강유진", "강지수", "곽재우", "구본성", "권수연", "김보영", "김소희",
				"김지수", "백지혜", "송유경", "신희철", "심선주", "오수연", "윤희중", "이경준",
					"이석호", "이승구", "이여강", "이영민", "이영우", "이용석", "이정범", "최기문", "최소은", "최윤지"};		
		Scanner s = new Scanner(System.in);
		
		System.out.println("몇명 뽑을까요?");
		int count = Integer.parseInt(s.nextLine());
		
		String[] pick = new String[count]; //pick 배열안에 들어갔는지 안들어갔는지 확인
		int pickCount = 0;
		
 		do {
 			int random = (int)(Math.random() * students.length); //랜덤한 인덱스를 뽑아줌
 			boolean flag = true;
 			for(int i = 0; i < pick.length; i++){//뽑힌사람들이 있는 사람중에서
 				if(students[random].equals(pick[i])){//같은 사람이 있는 경우
 					flag = false;//변수의 값은 바꿔주는거 
 				}
 			}
 			if(flag){//여기서 변수의 값을 확인해서
 				pick[pickCount++] = students[random];//몇명뽑았나
 			}
 		}while(pickCount < count); //뽑은사람이 뽑은 사람만큼 됐을때 빠져나옴
		
		System.out.println(Arrays.toString(pick));
	}

}
