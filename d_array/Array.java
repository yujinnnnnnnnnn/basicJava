package d_array;

import java.util.Arrays;

public class Array {

	public static void main(String[] args) {
		/*
		 * 배열
		 * - 여러개의 값을 하나의 변수에 저장해서 사용하는 것이다.
		 * - 참조형 타입이다.
		 * - 인덱스로 값을 구분한다.
		 * - 길이를 변경 할 수 없다.
		 * 
		 */
		
		int[] array; //타입뒤에 대괄호를 붙임 (보통 타입뒤에 붙임 int뒤에) array[]도됨
		array = new int[5]; // 저장할 값의 개수를 정해줌 int의 기본값 0이 5개 들어가 있는 상태
		
		/*
		 * 변수 = 주소(100번지)
		 * 
		 * 100번지
		 * {0, 0, 0, 0, 0} //맨앞이 100번지다 그럼 다음 으로 연속으로 101 102 103 이런식으로 진행됨
		 */
		 
		array = new int[]{1, 2, 3, 4, 5}; //대괄호의 배열의 길이 저장할 값을 정해주는데 {}를 통해서 1,2,3,4,5를 들어간상태 + 배열또한 5개가 된다
		
//		array = {1, 2, 3, 4, 5}; //이방법은 초기화를 할수 없음
		
		int[] array2 = {1, 2, 3, 4, 5}; //선언과 초기화를 동시에 해야됨
		
		System.out.println(array[0]); //인덱스 번호 불러오기
		System.out.println(array[1]); //인덱스 지정 
		System.out.println(array[2]); //인덱스 지정
		System.out.println(array[3]); //인덱스 지정
		System.out.println(array[4]); //인덱스 지정
		
		array[0] = 10; //인덱스에 접근해서 10을 0 인덱스에 넣어줌
		array[1] = 20; //인덱스에 접근해서 20을 1 인덱스에 넣어줌
		array[2] = 30; //인덱스에 접근해서 30을 2 인덱스에 넣어줌
		array[3] = 40; //인덱스에 접근해서 40을 3 인덱스에 넣어줌
		array[4] = 50; //인덱스에 접근해서 50을 4 인덱스에 넣어줌
		
		// 배열 같은경우에는 for문에서 사용가능
		
		for(int i = 0; i < array.length; i++){ // array.length 배열의 길이  배열의 길이가 마지막인덱스보다 1이 큼 그래서 <를 씀
			System.out.println(array[i]);
		}
		
		for(int i= 0; i < array.length; i++){
			array[i] = (i + 1) * 10;
			System.out.println(array[i]);	
		}
		// 10개의 정수를 저장할 수 있는 배열을 선언 및 초기화 해주세요.
		
		int[] arr = new int[10];
		
		// 배열의 모든 인덱스에 1~100사이의 랜덤한 값을 저장해주세요.
		// 방법 이것보다는
//		arr[0] = (int)(Math.random() * 100) + 1;
//		arr[1] = (int)(Math.random() * 100) + 1;
//		arr[2] = (int)(Math.random() * 100) + 1;
//		arr[3] = (int)(Math.random() * 100) + 1;
//		arr[4] = (int)(Math.random() * 100) + 1;
//		arr[5] = (int)(Math.random() * 100) + 1;
//		arr[6] = (int)(Math.random() * 100) + 1;
//		arr[7] = (int)(Math.random() * 100) + 1;
//		arr[8] = (int)(Math.random() * 100) + 1;
//		arr[9] = (int)(Math.random() * 100) + 1;
		// 두번째께 더 좋다
		for(int i = 0; i < arr.length; i++){
			arr[i] = (int)(Math.random() * 100) + 1;
			System.out.println(arr[i]);
		}
		
		//배열에 저장된 모든 값의 합계와 평균을 출력해주세요.
		
		int sum = 0;
		
		
		for (int i = 0; i < arr.length; i++){
			sum += arr[i];				
		} double avg = (double)sum / arr.length;
		
		System.out.println("sum : " + sum + " avg : " + avg);
		
		// 배열에 저장된 값들 중 최소값과 최대값을 출력해주세요.
		System.out.println(Arrays.toString(arr)); //배열에 있는 모든값을 추출할 수 있다.
		// 내가한거
		int min = 0;
		int max = 0;
		
		for (int i = 0; i < arr.length; i++){
			if(arr[i] > max){
				max = arr[i];
			}else {
				min = arr[i];
			}
		}
			System.out.println("최대값 : " + max);
			
			
			for (int i = 0; i < arr.length; i++){
				if(arr[i] < min){
					min = arr[i];
				}
			}
			System.out.println("최소값 : " + min);
		// 쌤이한거
			System.out.println(Arrays.toString(arr));
			
			min = arr[0]; //인덱스 첫번째 값을 저장
			max = arr[0]; //인덱스 첫번재 값을 저장
			
			for (int i = 0; i < arr.length; i++){
				if(arr[i] < min){
					min = arr[i];
				}
				if(max < arr[i]){
					max = arr[i];
				}
			}
			System.out.println("min : " + min + " max : " + max);
			
		int[] shuffle = new int[10];
		for(int i = 0;  i < shuffle.length; i++){
			shuffle[i] = i + 1;
		}
		System.out.println(Arrays.toString(shuffle));
		
		//배열의 값을 섞어주세요
		
	
		for(int i = 0; i < shuffle.length * 10; i++){ //10번을 섞으라는 말 *10에 대해서
		int random = (int)(Math.random() * shuffle.length);
		int temp = shuffle[0]; // 셔플에 인덱스 값이 0인것을 temp에 저장 temp가 인덱스0이됨
		shuffle[0] = shuffle[random]; //셔플 random값을 shuffle[0]에 저장 그럼 셔플은 random이됨
		shuffle[random] = temp; // 셔플 랜덤에 temp즉 인덱스 값이 0인것을 저장 
		
		}
		System.out.println(Arrays.toString(shuffle));
		
		// 1~10 사이의 랜덤값을 500번 생성하고, 각 숫자가 생성된 횟수를 출력해주세요.
		
		int[] count = new int[10];
		for(int i = 0; i < 500; i++){
			int random = (int)(Math.random() * 10) + 1;	
			
//			if(random == 1) count[0]++;
//			if(random == 2) count[1]++;
//			if(random == 3) count[2]++;
			
			count[random - 1] ++; //random은 1부터 시작함으로 인덱스가 0부터 시작해야되기때문에 -1을 해준다
		}
		System.out.println(Arrays.toString(count));
	}
	
}


