package tw.teacher.OOP;

public class class18Inheritance {

	public static void main(String[] args) {
		class183 obj = new class183();
	}


}

class class181 {
	class181() {
		System.out.println("class181()");
	}
}


class class182 extends class181 {
	class182() {
		System.out.println("class182()");
	}
}

class class183 extends class182 {
	class183() {
		this(2);
		System.out.println("class183()");
	}
	
	class183(int a) {
		System.out.println("class183(int)");
	}
	
	class183(String a) {
		System.out.println("class183(String a)");
	}
}
