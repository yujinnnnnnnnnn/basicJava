package c_statement;

import java.util.Scanner;


public class Baseball {

	public static void main(String[] args) {
		/*
		 * 123 1~9 사이의 3개의 숫자
		 * 135 자리수가 같으면 스트라이크 자리수가다르면 볼 하나는 아예 없으면 아웃
		 * 1S 1B 1O
		 * 
		 * 
		 * 768 : 1S 0B 2O
		 * 743 : 0S 1B 2O
		 * 543 : 0S 1B 2O
		 * 924 : 1S 1B 1O
		 * 461 : 1S 0B 2O
		 * 963 : 0S 0B 3O
		 * 524 : 1S 1B 1O
		 * 254 : 0S 2B 1O
		 * 219 : 0S 1B 2O
		 * 164 : 0S 1B 2O
		 * 428 : 3S
		 */
		
		
		
		int random = (int)(Math.random() * 9) + 1;
		int random1 = (int)(Math.random() * 9) + 1;
		int random2 = (int)(Math.random() * 9) + 1;
		
		while(random == random1 || random1 == random2 
				||random2 == random){
			random = (int)(Math.random() * 9) + 1;
			random1 = (int)(Math.random() * 9) + 1;
			random2 = (int)(Math.random() * 9) + 1;
		}
		System.out.print(random);
		System.out.print(random1);
		System.out.println(random2);
			
		Scanner sc = new Scanner(System.in);
		int num = 0;
		int num1 = 0;
		int num2 = 0;
		
		
		int st = 0;
		int ball = 0;
		int out = 0;
		
		do{
			System.out.println("첫번째 숫자>");
			num = Integer.parseInt(sc.nextLine());
			System.out.println("두번째 숫자>");
			num1 = Integer.parseInt(sc.nextLine());
			System.out.println("세번째 숫자>");
			num2 = Integer.parseInt(sc.nextLine());
			
			if (num == random ){
				st++;
			}else if (num == random1 || num == random2){
				
				ball++;
				
			}else {
				
				out++;
			}
			if (num1 == random1 ){
				st++;
			}else if (num1 == random || num1 == random2){
				
				ball++;
				
			}else {
				
				out++;
			}
			
			if (num2 == random2 ){
				
				st++;
				
			}else if (num2 == random || num2 == random1){
				
				ball++;
				
			}else {
				
				out++;
			}
			
			System.out.println(st + "S " + ball + "B " + out + "O" );
			
			st = 0;
			ball = 0;
			out = 0;
			
			
		}while(num != random || num1 != random1 || num2 != random2);
		
		System.out.println("정답입니다.");
		

		//선생님 
		
		int a1 = 0;
		int a2 = 0;
		int a3 = 0;
		
		do{
			a1 = (int)(Math.random() * 9) + 1;
			a2 = (int)(Math.random() * 9) + 1;
			a3 = (int)(Math.random() * 9) + 1;
		}while(a1 == a2 || a1 == a3 || a2 == a3);
		
		Scanner s = new Scanner(System.in);
		int count = 0;
		while(true){
			System.out.println("3자리 숫자>");
			int input = Integer.parseInt(s.nextLine());
			int i3 = input % 10;
			input /= 10;
			int i2 = input % 10;
			input /= 10;
			int i1 = input % 10;
			input /= 10;
			
			int strike = 0;
			int bal = 0;
			int ou = 0;
			
			if(a1 == i1) strike++;
			if(a1 == i1) strike++;
			if(a1 == i1) strike++;
			
			if(a1 == i2 || a1 == i3) bal++;
			if(a1 == i1 || a2 == i3) bal++;
			if(a1 == i1 || a3 == i2) bal++;
			
			ou = 3 - strike - ball;
			
			System.out.println(++count + "차 시도(" + i1 + i2 + i3 + ") : "
									+ strike + "S " + bal + "B " + ou + "O");
			
			System.out.println("---------------------------");
			if(strike == 3){
				System.out.println("정답입니다!!");
				break;
			}
		}
		
		
		
		
		
		
	
	}

}
















