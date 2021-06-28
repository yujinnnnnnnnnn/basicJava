package Test;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import e_oop.ScanUtil;

public class Board {

	public static void main(String[] args) {
		ArrayList<HashMap<String, Object>> boardList = new ArrayList<>();
		SimpleDateFormat format = new SimpleDateFormat("yy-mm-dd");
		
		while(true){
			System.out.println("---------------------------------");
			System.out.println("번호\t제목\t작성자\t작성일");
			System.out.println("---------------------------------");
			for (int i = boardList.size() -1; i >= 0; i--) {
				HashMap<String,Object> board = boardList.get(i);
				System.out.println(board.get("번호") +  "\t"+ board.get("제목") + "\t" + 
								board.get("작성자") + "\t" + format.format(board.get("작성일"))); 
			}
			System.out.println("---------------------------------");
			System.out.println("1. 조회\t2. 등록\t3. 종료");
			System.out.println("입력>");
			int input = ScanUtil.nextInt();
			
			switch(input){
			case 1:
				read(boardList);
				break;
			case 2:
				insert(boardList);
				break;
			case 3:
				System.out.println("프로그램이 종료되었습니다.");
				System.exit(3);
			}
		}

	}

	static void read(ArrayList<HashMap<String, Object>> boardList){
		System.out.println("게시글번호 입력 >");
		int input = ScanUtil.nextInt();
		
		HashMap<String, Object> board = null;
		for(int i = 0; i < boardList.size(); i++) {
			if((Integer)boardList.get(i).get("번호") == input){
				board = boardList.get(i);
				break;
			}
		}
		System.out.println("-------------------------------");
		System.out.println("번호 \t:" + board.get("번호"));
		System.out.println("작성자\t:" + board.get("작성자"));
		System.out.println("작성일\t:" + board.get("작성일"));
		System.out.println("제목\t" + board.get("제목"));
		System.out.println("내용\t" + board.get("내용"));
		System.out.println("-------------------------------");
		System.out.println("1. 수정 \t2. 삭제\t3. 목록");
		System.out.println("입력>");
		int input2 = ScanUtil.nextInt();
		
		switch(input2){
		case 1:
			update(board);
			break;
		case 2:
			delete(boardList,board);
			break;
		case 3:
			break;
		}
	}
	
	static void update(HashMap<String, Object> board){
		System.out.println("제목 >");
		String input = ScanUtil.nextLine();
		System.out.println("내용 > ");
		String input2 = ScanUtil.nextLine();
		
		board.put("제목", input);
		board.put("내용", input2);
		
		System.out.println("수정되었습니다.");
	}

	static void delete(ArrayList<HashMap<String, Object>> boardList, HashMap<String,Object> board){
		for (int i = 0; i < boardList.size(); i++) {
			if(boardList.get(i).get("번호") == board.get("번호")){
				boardList.remove(i);
				System.out.println("삭제완료");
				break;
			}
		}
	}
	
	static void insert(ArrayList<HashMap<String, Object>> boardList){
		System.out.println("제목>");
		String input = ScanUtil.nextLine();
		System.out.println("내용>");
		String input2 = ScanUtil.nextLine();
		System.out.println("이름>");
		String input3 = ScanUtil.nextLine();
		
		int maxnum = 0;
		for (int i = 0; i < boardList.size(); i++) {
			int boardno = (Integer)boardList.get(i).get("번호");
			if(maxnum < boardno){
				maxnum = boardno;
			}
		}
		HashMap<String, Object> temp = new HashMap<>();
		temp.put("번호", maxnum + 1);
		temp.put("제목", input);
		temp.put("내용", input2);
		temp.put("작성자", input3);
		temp.put("작성일", new Date());
		
		boardList.add(temp);
		System.out.println("게시물 등록이 완료되었습니다");
	}
}
