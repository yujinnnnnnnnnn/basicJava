package g_oop2;

public abstract class Animal {

	public static void main(String[] args) {
		Dog d = new Dog();
		d.sound();
	}
	void run(){
		System.out.println("달려간다~~");
	}
	
	abstract void sound();
	
}


class Dog extends Animal{

	@Override
	void sound() {
		System.out.println("멍멍");
	}
	
}
class  Cat extends Animal{

	@Override
	void sound() {
		System.out.println("냐옹");
	}
	
}
class Tiger extends Animal{

	@Override
	void sound() {
		System.out.println("어흥");
	}
	
}