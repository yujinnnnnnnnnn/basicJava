package f_game;

public class Item {
	String name;
	int hp; //체력 
	int mp; //스킬
	int att; //공격력
	int def; //방어력
	
	//생성자  변수 초기화
	Item(String name, int hp, int mp, int att, int def){
		this.name = name;
		this.hp = hp;
		this.mp = mp;
		this.att = att;
		this.def =def;
	}
	//아이템 정보 리턴 메서드 
	String itemInfo(){
		String info = name + " :";
		if(0 < hp) info += " 채력+" + hp;
		if(0 < mp) info += " 마나+" + mp;
		if(0 < att) info += " 공격+" + att;
		if(0 < def) info += " 방어+" + def;
		return info;
	}
}
