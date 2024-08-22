package tw.teacher.OOP;

public class class21Inheritance {
	// 由父類別創造多型的概念
	public static void main(String[] args) {
		class211 obj1 = new class211() { // 一次性的使用，當場實作
			void m2() {
				System.out.println("class211:m2()");
			}
		};
		obj1.m1();
		
		class211 obj2 = new class212();
		obj2.m1(); obj2.m2(); // 使用父元素的m1方法 自己的m2方法

		class211 obj3 = new class213();
		obj3.m1(); obj3.m2(); // 使用父元素的m1方法 自己的m2方法
	}

}

abstract class class211 { // 2. 必須對外宣告我是抽象類別
	void m1() {System.out.println("class211:m1()");}
	abstract void m2(); // 直接留給子類別去發揮，沒有實作({實作內容})，abstract 1. 有定義但無實作的抽象的方法 
}

class class212 extends class211 {
	@Override
	void m2() {System.out.println("class212:m2()");}
}
class class213 extends class211 {
	@Override
	void m2() {System.out.println("class212:m3()");}
}