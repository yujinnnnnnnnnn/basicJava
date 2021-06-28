package e_oop.score;

public class Score {

	public static void main(String[] args) {
		Student[] students = new Student[10];             
		String[] subjects = { "국어", "영어", "수학" };
		
		for (int i = 0; i < subjects.length; i++) {
			System.out.print("\t" + subjects[i]);
		}
		System.out.println("\t합계\t평균\t석차");
		//
		for (int i = 0; i < students.length; i++) {
			Student student = new Student();    //변수 선언 & 초기화

			student.name = "학생 " + (i + 1);
			student.rank = 1;
			student.kor = (int) (Math.random() * 101);
			student.eng = (int) (Math.random() * 101);
			student.math = (int) (Math.random() * 101);
			student.sum = student.kor + student.eng + student.math;
			student.avg = Math.round(student.sum / 3.0 * 100) / 100.0;
			
			
			students[i] = student;
				
		}
		for (int i = 0; i < subjects.length; i++) {
			students[i].sum = students[i].kor + students[i].eng + students[i].math;
			students[i].avg = Math.round(students[i].sum / 3.0 * 100) / 100.0;
		}
	
		//석차 & 정렬 
		for (int i = 0; i < students.length; i++) {
			for (int j = 0; j < students.length; j++) {
				if (students[i].sum < students[j].sum) {
					students[i].rank++;
				}
			}
		}
		for (int i = 0; i < students.length -1; i++) {
			int min = i;
			for (int j = i+1; j < students.length; j++) {
				if(students[min].rank > students[j].rank){
					min = j;
				}
			}
			Student temp = students[min];
			students[min] = students[i];
			students[i] = temp;	   	   
		}
		
		int[] subSum = new int [3];
		for (int i = 0; i < students.length; i++) {
			subSum[0] += students[i].kor;
			subSum[1] += students[i].eng;
			subSum[2] += students[i].math;
		}
		
		double[] subAvg = new double[3];
		for (int i = 0; i < subAvg.length; i++) {
			subAvg[i] = Math.round((double)subSum[i] /students.length * 100) /100.0;
		}
		
		for (int i = 0; i < students.length; i++) {
			System.out.println(students[i].name + "\t" + students[i].kor + "\t"
					+ students[i].eng + "\t" + students[i].math + "\t"
					+ students[i].sum + "\t" + students[i].avg + "\t"
					+ students[i].rank);
		}
		System.out.print("과목합계");
		for (int i = 0; i < subSum.length; i++) {
			System.out.print("\t" + subSum[i]);
		}
		System.out.print("\n과목평균");
		for (int i = 0; i < subSum.length; i++) {
			System.out.print("\t" + subAvg[i]);
		}
	}
}
