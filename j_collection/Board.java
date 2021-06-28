package j_collection;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import e_oop.ScanUtil;

public class Board {

	public static void main(String[] args) {

		ArrayList<HashMap<String, Object>> table = new ArrayList<>();
		SimpleDateFormat format = new SimpleDateFormat("yy-MM-dd");
		// 목록
		while (true) {
			System.out
					.println("■□■□■□■□■□■□■□■□■□■□■□■□■□■□■□■□■□■□■□■□■□■□■□■□■□■□■□■□□■");
			System.out.println("                           Q&A");
			System.out
					.println("■□■□■□■□■□■□■□■□■□■□■□■□■□■□■□■□■□■□■□■□■□■□■□■□■□■□■□■□□■");
			System.out.println("번호\t제목\t\t작성자\t작성일");
			System.out
					.println("-----------------------------------------------------------");

			for (int i = table.size() -1; i >= 0; i--) {
				HashMap<String, Object> row = table.get(i);
				System.out.println(row.get("번호") + "\t" + row.get("제목") + "  \t"
						+ row.get("작성자") + "\t" + format.format(row.get("작성일")));

			}
			System.out
					.println("-----------------------------------------------------------");
			System.out.println("1. 조회\t\t2. 등록 \t\t3. 종료");
			System.out.println(">>>");
			int input = ScanUtil.nextInt();

			switch (input) {
			case 1:
				read(table);
				break;
			case 2:
				insert(table);
				break;
			case 3:
				System.out.println("종료되었습니다.");
				System.out.println(3);
				break;
			}
		}
	}

	static void read(ArrayList<HashMap<String, Object>> table) {

		System.out.println("조회할 번호를 입력하세요>");
		int input = ScanUtil.nextInt();

		HashMap<String, Object> row = null;
		for (int i = 0; i < table.size(); i++) {
			if ((Integer) table.get(i).get("번호") == input) {
				row = table.get(i);
				break;
			}
		}
		System.out.println("번호 : " + row.get("번호"));
		System.out.println("제목 : " + row.get("제목"));
		System.out.println("내용 : " + row.get("내용"));
		System.out.println("작성자 : " + row.get("작성자"));
		System.out.println("작성일 : " + row.get("작성일"));
		System.out.println("------------------------------");
		System.out.println("1. 수정\t\t2. 삭제\t\t3. 목록으로 돌아가기");
		System.out.println(">>>");
		int input2 = ScanUtil.nextInt();

		switch (input2) {
		case 1:
			update(row);
			break;
		case 2:
			delete(table, row);
			break;
		case 3:
			break;
		}
	}

	static void update(HashMap<String, Object> row) {
		System.out.println("수정할 제목을 입력해주세요 >");
		String input = ScanUtil.nextLine();
		System.out.println("수정할 내용을 입력해주세요 >");
		String input2 = ScanUtil.nextLine();

		row.put("제목", input);
		row.put("내용", input2);

		System.out.println("수정되었습니다");
	}

	static void delete(ArrayList<HashMap<String, Object>>table, HashMap<String, Object> row){
		for (int i = 0; i < table.size(); i++) {
			if(table.get(i).get("번호") == row.get("번호")){
				table.remove(i);
				System.out.println("삭제되었습니다.");
				break;
			}
		}
	}
	
	static void insert(ArrayList<HashMap<String, Object>> table){
		System.out.println("제목을 입력하세요 >");
		String input = ScanUtil.nextLine();
		System.out.println("내용을 입력하세요 >");
		String input2 = ScanUtil.nextLine();
		System.out.println("이름을 입력하세요 >");
		String input3 = ScanUtil.nextLine();
		
		int maxnum = 0;
		for (int i = 0; i < table.size(); i++) {
			int boardno = (Integer)table.get(i).get("번호");
			if(maxnum < boardno){
				maxnum = boardno;
			}
		}
		
		HashMap<String, Object> temp = new HashMap<>();
		temp.put("번호", maxnum +1);
		temp.put("제목", input);
		temp.put("내용", input2);
		temp.put("작성자", input3);
		temp.put("작성일", new Date());
		table.add(temp);
		System.out.println("게시물 등록이 완료되었습니다.");
	}
}