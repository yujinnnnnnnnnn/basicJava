package defualt_package;

public class Find {

	public static void main(String[] args) {
		
		int[] not_ordered_array ={4, 10, 5, 9, 2, 1, 0, 13, 15};
		
		int index = Find.find_not_ordered_array(not_ordered_array, 0);
		System.out.println("index : " + index);
		
		 index = Find.find_not_ordered_array(not_ordered_array, 20);
		System.out.println("index : " + index);
	
		int[] ordered_array ={0, 1, 2, 3, 4, 5, 9, 13, 15, 20, 30};
		index = Find.find_not_ordered_array(not_ordered_array, 6);
		System.out.println("index : " + index);
		}
	

	//첫번째 인자로 돌어온 벼열에서(정렬이 되지 않은 배열)
	//두번째 인자에 해당하는 값이 있을 경우 : 배열의 인데스를 반환
	//				값이 없을 경우 : -1을 리턴
	public static int find_not_ordered_array(int[]  not_ordered_array, int find ){
		for (int i = 0; i < not_ordered_array.length; i++) {
			if(find == not_ordered_array[i]){
				return i;
			}
		}
		return -1;
	}
}
