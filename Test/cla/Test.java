package Test.cla;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

import e_oop.ScanUtil;

public class Test {
	List<Map<String, Object>> checkId;
    do {
       System.out.print("아이디 * (대문자나 소문자, 숫자, 특수기호(_,-)만 사용하여 3~10글자) >");
       memId = ScanUtil.nextLine();

       do {
          memIdRegex = "[a-zA-Z0-9_-]{3,10}";
          a = Pattern.compile(memIdRegex);
          b = a.matcher(memId);
          if (b.matches() == false) {
             System.out.println("대문자나 소문자,숫자, 특수기호(_,-)만 사용하여 3~10글자의 아이디를 입력해주세요.");
             System.out.println("------------------------------------------------------------");
          }
          
          checkId = memDao.checkId(memId);
          
          if (checkId.size() > 0) {
             System.out.println("이미 존재하는 아이디 입니다.");
             System.out.print("아이디 * >");
             memId = ScanUtil.nextLine();
          } else if (checkId.size() == 0 && b.matches() == true) {
             System.out.println("사용가능한 아이디 입니다.");
          }
       } while (checkId.size() > 0);

    } while (b.matches() == false); // do-while문 조건식이 틀릴때 탈출문 빠져나감


    do {
       System.out.print("비밀번호 * (대문자나 소문자, 숫자, 특수기호를 사용하여 8글자 이상) >");
       memPw = ScanUtil.nextLine();
       
       memPwRegex = "^(?=.*[A-Za-z])(?=.*\\d)(?=.*[$@!%*#?&])[A-Za-z\\d$@!%*#?&]{8,}$";
       c = Pattern.compile(memPwRegex);
       d = c.matcher(memPw);

       if (d.matches() == true) {
          System.out.println("비밀번호 확인>");
          checkMemPw = ScanUtil.nextLine();

          do {
             if (checkMemPw.equals(memPw)) {
                System.out.println("비밀번호 확인 완료");
             } else {
                System.out.println("비밀번호가 동일하지 않습니다.");
                System.out.println("비밀번호 확인>");
                checkMemPw = ScanUtil.nextLine();
             }
          } while (!checkMemPw.equals(memPw));

       } else {
          System.out.println("대문자나 소문자, 숫자, 특수기호를 사용하여 8글자 이상의 비밀번호를 입력해주세요.");
       }
    } while (d.matches() == false);
    
    //아이디 중복확인하기
    public List<Map<String, Object>> checkId(String memId) {
       String sql = "SELECT MEM_ID AS CNT FROM AB_MEMBER WHERE MEM_ID = ?";
       List<Object> param = new ArrayList<>();
       param.add(memId);
       return jdbc.selectList(sql, param);
    }
}
