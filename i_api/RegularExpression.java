package i_api;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegularExpression {

	public static void main(String[] args) {
		
		/*
		 * 정규표현식 : 문자열의 패턴을 검사하는 표현식(회원가입시 자주 사용 [아이디 /비번 조건])
		 * 
		 * ^ 	뒷 문자로 시작
		 * $	앞문자로 시작
		 * . 	임의의 문자 (줄바꿈 제외)
		 * *	앞문자가 0개 이상
		 * + 	앞문자가 1개 이상
		 * ? 	앞문자가 없거나 1개 
		 * [] 	문자의 집합이나 범위 ([a-z] : a부터 z까지,[^a-z]:a부터z가 아닌것)
		 * {} 	앞문자의 개수 ({2}: 2개,{2,4}: 2개 이상 4개 이하 -> 2,4사이에 띄어쓰기 있음 안됨)
		 * ()	그룹화 (1개의 문자처럼 인식)
		 * | 	OR연산
		 * \s 	공백, 탭, 줄바꿈
		 * \w	알파벳이나 숫자
		 * \W	알파벳이나 숫자가 아닌문자
		 * \d	숫자
		 * \D	숫자가 아닌 문자
		 * (?i)	뒷문자의 대소문자 구분안함
		 * \    정규표현식에서 사용되는 특수문자표현
		 */
		

//		String str = "abc123";
//		String regex = "abc123"; //정규표현식 위에 문자열과 같이 만들면 그 문자열만 통과시킬 수 있음
//		String regex = "[a-z]{3}[0-9]{1,3}"; //정규표현식 / 갯수가 다르지 않으면 통과됨 
//		String regex = "[a-z0-9]+"; //여러개중 한글자 []의 갯수의 1개이상이 온다 /영문자 대소문자, 특수문자가 아닌경우 통과
//		String regex = "\\w*"; //알파벳이나 숫자가 0개 이상온다 \\-> 문자열 안에 \를 넣고 싶을 때 
//		String regex = ".*"; //어떤 문자열이 와도 통과(줄바꿈 제외)
		//밑으로 갈수록 넓은 표현이 가능 (어느정도 범위가 있는 것이 좋음) 
		
//		Pattern p = Pattern.compile(regex);
//		Matcher m = p.matcher(str);  //패턴을 검사하고 싶은 파라미터를 넣어줌
//		System.out.println(m.matches());
		
	/*
		 * 아이디, 전화번호, 이메일주소의 유효성을 검사하는 정규표현식을 만들어주세요.
		 */
	
		
// 아이디
		String str1 = "rkddbwlskd";
		String re = "[a-z0-9_-]{5,20}";
		
		Pattern id = Pattern.compile(re);
		Matcher m = id.matcher(str1);
		System.out.println(m.matches());
//전화번호
		String str2 = "01028718442";
		String regex2 = "^0\\d{1,3}-\\d{3,4}-\\d{4}";
		
		Pattern pa = Pattern.compile(regex2);
		Matcher m2 = pa.matcher(str2);
		System.out.println(m2.matches());

//이메일 주소 [a-z0-9_-]{5,20}@[a-zA-Z]+\\.(?i)(com|net|org|([a-z]{2}\\.kr))$
		
	}

}











