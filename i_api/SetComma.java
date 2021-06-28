package i_api;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import e_oop.ScanUtil;

public class SetComma {

	public static void main(String[] args) {
		// 숫자를 입력받아 입력받은 숫자에 3자리마다 콤마(,)를 붙여 출력해주세요.
		// 1,234,567
		// 포문이 다돌았을 때 마지막에 나오는 , 수 제외하고 출력 / 문자열의 길이는 알고 있음
		System.out.println("숫자 입력 >");
		String input = ScanUtil.nextLine();
		String sum = "";
		int count = 0;
		for (int i = input.length() - 1; 0 <= i; i--) {
			sum = input.charAt(i) + sum;
			count++;
			if (count % 3 == 0 && count != input.length()) {
				sum = "," + sum;
			}
		}
//		if (",".equals(sum.substring(0,1))){  //sum.charAt(0)은 문자열이 아니라 문자여서 false
//			sum = sum.substring(1);
//		}
		System.out.println(sum);
	}
}
