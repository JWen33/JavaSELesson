package tw.teacher.OOP;

public class class20Inheritance {
	// 多型觀念
	public static void main(String[] args) {
		class201 obj1 = new class201();
		class201 obj2 = new class202();
		class201 obj3 = new class203();
		att(obj1);
		att(obj2);
		att(obj3);
	}

	static void att(class201 obj) { // 只要是怪物都可以攻擊，要實作方法的時候怪物有各自的攻擊方法
		obj.m1();
	}
}

class class201 {
	void m1() {System.out.println("class201:m1()");}
}
class class202 extends class201{
	void m1() {System.out.println("class202:m1()");}
}
class class203 extends class201{
	void m1() {System.out.println("class203:m1()");}
}
