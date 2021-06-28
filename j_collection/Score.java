package j_collection;

import java.util.ArrayList;

public class Score {

   public static void main(String[] args) {
	   /*
		 * 우리반 모두의 국어, 영어, 수학, 사회, 과학, Oracle, Java 점수를
		 * 0 ~ 100까지 랜덤으로 생성해주시고, 아래와 같이 출력해주세요.
		 * 
		 * 			국어		영어		수학		사회		과학		Oracle	Java	합계		평균		석차
		 * 홍길동		90		90		90		90		90		90		90		630		90.00	1
		 * 홍길동		90		90		90		90		90		90		90		630		90.00	1
		 * 홍길동		90		90		90		90		90		90		90		630		90.00	1
		 * 홍길동		90		90		90		90		90		90		90		630		90.00	1
		 * 홍길동		90		90		90		90		90		90		90		630		90.00	1
		 * 과목합계	450		450		450		450		450		450		450
		 * 과목평균	90.00	90.00	90.00	90.00	90.00	90.00	90.00
		 */

      // System.out.println("이름\t국어\t영어\t수학\t사회\t과학\toracle\tjava\t합계\t평균\t석차");
      ArrayList<String> name = new ArrayList<>();
      name.add(new String("강유진"));
      name.add("강지수");
      name.add("곽재우");
      name.add("구본성");
      name.add("권수연");
      name.add("김보영");
      name.add("김소회");
      name.add("김지수");
      name.add("백지혜");
      name.add("송유경");
      name.add("신희철");
      name.add("심선주");
      name.add("오수연");
      name.add("윤희중");
      name.add("이여강");
      name.add("이영민");
      name.add("이영우");
      name.add("이용석");
      name.add("이정범");
      name.add("최기문");
      name.add("최소은");
      name.add("최윤지");

      ArrayList<String> sub = new ArrayList<>();
      sub.add(new String("국어"));
      sub.add("영어");
      sub.add("수학");
      sub.add("사회");
      sub.add("과학");
      sub.add("oracle");
      sub.add("java");

      //점수 2차원
      ArrayList<ArrayList<Integer>> score = new ArrayList<>();

      for (int i = 0; i < name.size(); i++) {
         ArrayList<Integer> score2 = new ArrayList<>(); // 빈값으로 해주어야 하기때문에 i가
                                             // 돌때마다 생성을 해줌
         for (int j = 0; j < sub.size(); j++) {
            int ran = (int) (Math.random() * 101);
            score2.add(ran);
         }
         score.add(score2);
      }
      // System.out.println(score);

      // 출력

//      for (int i = 0; i < score.size(); i++) {
//         ArrayList<Integer> score3 = score.get(i);
//         for (int j = 0; j < score3.size(); j++) {
//            // System.out.print(score3.get(j) + "\t");
//         }
//         // System.out.println();
      

      // 합계/평균
      ArrayList<Integer> nameSum = new ArrayList<>();
      ArrayList<Double> nameAvg = new ArrayList<>();

      for (int i = 0; i < name.size(); i++) {
         int sum = 0;
         double avg = 0;
         for (int j = 0; j < sub.size(); j++) {
            sum += score.get(i).get(j);
         }
         nameSum.add(sum);
         avg = Math.round((double) nameSum.get(i) / sub.size() * 100) / 100.0;
         nameAvg.add(avg);
      }

      ArrayList<Integer> subSum = new ArrayList<>();
      ArrayList<Double> subAvg = new ArrayList<>();
      for (int i = 0; i < sub.size(); i++) {
         int sum2 = 0;
         double avg2 = 0;
         for (int j = 0; j < name.size(); j++) {
            sum2 += score.get(j).get(i);
         }
         subSum.add(sum2); //순서대로 추가가 되기 때문에 (i, sum)을 굳이안해도됨 / 특정자리에 추가하고싶을경우만 (i, sum)사용
         avg2 = Math.round((double) subSum.get(i) / name.size() * 100) / 100.0;
         subAvg.add(avg2);
      }
      for (int i = 0; i < name.size(); i++) {
         for (int j = 0; j < sub.size(); j++) {
         }
      }
      
      ArrayList<Integer> rank = new ArrayList<>();
      for (int i = 0; i < name.size(); i++) {
         rank.add(1);
         for (int j = 0; j < name.size(); j++) {
            if (nameSum.get(i) < nameSum.get(j)) {
               rank.set(i, rank.get(i) + 1);
            }
         }
      }
//      System.out.println(rank);
      // 석차
      for (int i = 0; i < name.size() - 1; i++) {
         int min = i;
         for (int j = i + 1; j < name.size(); j++) {
            if (nameSum.get(j) > nameSum.get(min)) {
               min = j;
            }
         }
         ArrayList<Integer> temp = score.get(i); // temp = new ArrayList<>() 를 안해준 이유 : score.get(i)가  temp변수에 들어오게 되면 new ArrayList<>()는 없어지기 때문에 바로 적어도 무방
         score.set(i, score.get(min));
         score.set(min, temp);

         int temp2 = nameSum.get(i);
         nameSum.set(i, nameSum.get(min));
         nameSum.set(min, temp2);

         double temp3 = nameAvg.get(i);
         nameAvg.set(i, nameAvg.get(min));
         nameAvg.set(min, temp3);

         int temp4 = rank.get(i);
         rank.set(i, rank.get(min));
         rank.set(min, temp4);

         String temp5 = name.get(i);
         name.set(i, name.get(min));
         name.set(min, temp5);
      }

      for (int i = 0; i < sub.size(); i++) {
         System.out.print("\t" + sub.get(i));
      }
      System.out.println("\t합계\t평균\t석차");
      for (int i = 0; i < name.size(); i++) {
         System.out.print(name.get(i) + "\t");
         for (int j = 0; j < sub.size(); j++) {
            System.out.print(score.get(i).get(j) + "\t");
         }
         System.out.println(nameSum.get(i) + "\t" + nameAvg.get(i) + "\t"
               + rank.get(i));
      }
      System.out.print("과목합계\t");
      for (int i = 0; i < subSum.size(); i++) {
         System.out.print(subSum.get(i) + "\t");
      }
      System.out.println();

      System.out.print("과목평균\t");
      for (int i = 0; i < subAvg.size(); i++) {
         System.out.print(subAvg.get(i) + "\t");
      }
   }
}