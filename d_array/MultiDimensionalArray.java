package d_array;

import java.util.Arrays;

public class MultiDimensionalArray {

	public static void main(String[] args) {
		//2차원
		int[][] array2;
		
		//3차원
		int[][][] array3;
		
		int[][] arr = new int[2][3]; // 일반적인 방법 //
		/*
		 * 변수 = 주소1(100번지)
		 * 
		 * 100번지
		 * {주소2(200번지), 주소3(300번지)}
		 * 
		 * 200번지
		 * {0, 0, 0}
		 * 
		 * 300번지
		 * {0, 0, 0}
		 * 
		 */
		
		int arr2[][] = new int[][]{{1,2,3}, {4,5,6}}; // 초기화방법(1)
		int[] arr3[] = {{1,2,3}, {4,5,6}, {7,8,9}}; // 초기화방법(2)
		// 타입뒤에있든 위치에 상관없이 배열 선언 가능 2차원으로 
		// 초기화방법(3)
		int[][] arr4 = new int[3][]; // 가변 배열 사용하려면 2차원배열을 만들어서 사용해야됨
		arr4[0] = new int[3];
		arr4[1] = new int[4];
		arr4[2] = new int[10];
		
//		System.out.println(arr[0][1]);
		
//		arr[0] = 10; // 값을 저장할 수 없다. 1차원엔 저장할 수 없음
		arr[0] = new int[5]; //배열을 저장해야 한다.
		arr[0][0] = 10;
		arr[0][1] = 20;
		arr[1][0] = 100;
		arr[1][1] = 200;
		
//		System.out.println(arr.length); //1차원
//		System.out.println(arr[0].length);//2차원 배열의 길이
		
		for(int i = 0; i < arr.length; i++){//1차원 배열을 만들어줄 
			for(int j = 0; j < arr[i].length; j++){//2차원 배열을 만들어줌
				System.out.println(arr[i][j]);
			}
		}
		
		int[][] scores = new int[3][5]; //1차원 [3]학생의 수 2차원[5] 과목
		int[] sum = new int[scores.length];
		double[] avg = new double[scores.length];
		for(int i = 0; i < scores.length; i++){
			for(int j = 0; j < scores[i].length; j++){
				scores[i][j] = (int)(Math.random() * 101);
			}
			System.out.println(Arrays.toString(scores[i]));
		}
		for(int i = 0; i < scores.length; i++){// 학생을 돌리기위한 for문
			for(int j = 0; j < scores[i].length; j++){// 과목을 돌리기위한 for문
				sum[i] += scores[i][j];
				
			}
			avg[i] = (double) sum[i] / scores[i].length;
		}
		
		for(int i = 0; i < sum.length; i++){
			System.out.println(i+1 + "번째학생" + " 합계는 : " + sum[i] + " 평균은 : " + avg[i]);
		}
		
		
		
		
	}

}
