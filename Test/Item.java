package Test;

public class Item {
	String name;
	int hp;
	int att;
	int def;

	Item(String name, int hp, int att, int def) {
		this.name = name;
		this.hp = hp;
		this.att = att;
		this.def = def;
	}

	String itemInfo() {
		String info = name + " :";
		if (0 < hp)
			info += " 체력+" + hp;
		if (0 < att)
			info += " 공격+" + att;
		if (0 < def)
			info += " 방어+" + def;
		return info;
	}
}
