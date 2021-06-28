package d_array;

import java.util.Arrays;

public class Sort {

	public static void main(String[] args) {
		/*
		 * 석차구하기 : 점수를 비교해 작은 점수의 등수를 증가시키는 방식
		 * 선택정렬 : 가장 작은 수 찾아서 앞으로 보내는 방식
		 * 버블정렬 : 바로 뒤의 숫자와 비교해서 큰 수를 뒤로 보내는 방식
		 * 삽입정렬 : 두번째 숫자부터 앞의 숫자들과 비교해서 큰수를 뒤로 밀고 중간에 삽입하는 방식
		 */
		
		
		int[] arr = new int[10];
		
		for(int i = 0; i < arr.length; i++){
			arr[i] = (int)(Math.random() * 100) + 1;
		}
		System.out.println(Arrays.toString(arr));
		
		//석차를 저장할 배열을 만들자
		int[] rank = new int[arr.length];
		for(int i = 0; i < arr.length; i++){
			rank[i] = 1; //그럼 rank[i]의 인덱스가 0부터 arr길이까지 1이됨
		}
		System.out.println(Arrays.toString(rank));
		
		for(int i = 0; i < arr.length; i++){//i가 처음에 0부터입력받고
			for(int j = 0; j < arr.length; j++){// 여기서는 j가 10번 돌음
				if(arr[i] < arr[j]){//i번에 등수가 arr[j]보다 작으면 증가시킨다
					rank[i]++;
				}
			}
		}
		System.out.println(Arrays.toString(rank));
		for(int i = 0; i < arr.length; i++){
			System.out.println(arr[i] + " : " + rank[i] + "등");
		}
		
		
		//선택정렬
		/*
		 * 0,1 1,2 1,3 1,4 1,5 1,6 1,7 1,8 1,9 
		 * 1,2 ~~~
		 */
		
		for(int i = 0; i < arr.length-1; i++){ //i = 0
			int min = i; // 인덱스를 찾아야되므로 인덱스 번호를 입력 min = 0
			for(int j = i+1; j < arr.length; j++){ //j = 1
				if(arr[j] < arr[min]){ //arr[1] < arr[0] 43 < 58
					min = j; // min = 인덱스 1을 저장하게됨
				}
				
			}
			
			int temp = arr[i];
			arr[i] = arr[min];
			arr[min] = temp;
		}
		System.out.println(Arrays.toString(arr));
		
		//버블정렬
		 /*
		  * 0,1 1,2 2,3 3,4 4,5 5,6 6,7 7,8 8,9     0,1 0,1이 9번돈다
		  * 0,1 1,2 2,3 3,4 4,5 5,6 6,7 7,8
		  * 0,1 1,2 2,3 3,4 4,5 5,6 6,7
		  * 0,1 1,2 2,3 3,4 4,5 5,6
		  * 0,1 1,2 2,3 3,4 4,5
		  * 0,1 1,2 2,3 3,4
		  * 0,1 1,2 2,3
		  * 0,1 1,2
		  * 0,1		
		  */
		
		for(int i= 0; i < arr.length - 1; i++){//01 01 9번이 도니까
			boolean flag = true; // 자리가 바꼈는지 안바꼈는지 변수 설정
			for(int j = 0; j < arr.length - 1 - i; j++){//i를빼면 도는숫자가 줄어든다
				if(arr[j] > arr[j + 1]){ //뒤에있는숫자가 j보다 1더 크니까
					int temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
					flag = false;
				}		
			}
			if(flag){
				break;
			}
		}
		System.out.println(Arrays.toString(arr));
	
		/*
		 * 삽입정렬
		 * i j
		 * 1,0
		 * 2,1 2,0
		 * 3,2 3,1 3,0
		 * 4,3 4,2 4,1 4,0
		 * 5,4 5,3 5,2 5,1 5,0
		 * 6,5 6,4 6,3 6,2 6,1 6,0
		 * 7,6 7,5 7,4 7,3 7,2 7,1 7,0
		 * 8,7 8,6 8,5 8,4 8,3 8,2 8,1 8,0
		 * 9,8 9,7 9,6 9,5 9,4 9,3 9,2 9,1 9,0
		 */
		 // 9 7 8      7 9 8
		for(int i = 1; i < arr.length; i++){
			int temp = arr[i]; //i를 임시로 보관 7
			int j = 0;
			for(j = i-1; j >= 0; j--){
				if(temp < arr[j]){//7 < 9 8 < 9
					                        //7
					arr[j+1] = arr[j]; //  9 [J+1] 8 8 -> 9
				} else{
					break;
				}
			}
			arr[j + 1] = temp; //j+1이 빈칸임
		}System.out.println(Arrays.toString(arr));
	
		
	
	}
			
		
}


