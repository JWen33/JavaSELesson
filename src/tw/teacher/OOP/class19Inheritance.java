package tw.teacher.OOP;

public class class19Inheritance {

public static void main(String[] args) {
		class191 obj1 = new class191(); // 宣告你需要什麼東西的物件
		obj1.m1(); obj1.m2();
		
		class192 obj2 = new class192();
		obj2.m1(); obj2.m2(); obj2.m3();
		
		class191 obj3 = new class192(); // 192的物件實體是191
		obj3.m1(); obj3.m2(); // 型別轉換，創建時是191，但骨子裡是192
		
		class192 obj4 = (class192)obj3; // 強制轉型，骨子裡是192
		obj4.m1(); obj4.m2(); obj4.m3();
		
//		class192 obj5 = new class193(); // 192 193沒有直系繼承關係，所以不能自動轉型
//		class192 obj5 = (calss191)(new class193()); // 192 193沒有直系繼承關係，所以不能自動轉型，也不能強制轉型
//		class193 obj6 = new class192(); // 192 193沒有直系繼承關係
		
		class191 obj7 = new class192();
//		class193 oj8 = (class193)obj7; // 編譯階段有關係即可以宣告，但執行階段會回報錯誤192不能轉換成193
		
		if (obj7 instanceof Object) { // instanceof是否為物件實體
			System.out.println("Yes1");
		} else {
			System.out.println("No1");			
		}
		if (obj7 instanceof class191) { // instanceof是否為物件實體
			System.out.println("Yes2");
		} else {
			System.out.println("No2");			
		}
		if (obj7 instanceof class192) { // instanceof是否為物件實體
			System.out.println("Yes3");
		} else {
			System.out.println("No3");			
		}
		if (obj7 instanceof class193) { // instanceof是否為物件實體
			System.out.println("Yes4");
		} else {
			System.out.println("No4");			
		}
//		if (obj7 instanceof String) { // 沒關係不能問，會有編譯錯誤
//			System.out.println("Yes4");
//		} else {
//			System.out.println("No4");			
//		}
		
	}

}

class class191 {
	void m1() { // m1方法被呼叫
		System.out.println("class191:m1()");
	}
	void m2() { // m2方法被呼叫
		System.out.println("class191:m2()");
	}
}

class class192 extends class191 {
	void m2() { // m2方法被呼叫
		System.out.println("class192:m2()");
	}
	void m3() {
		System.out.println("class192:m3()");
	}
}
class class193 extends class191 {
	void m2() { // m2方法被呼叫
		System.out.println("class193:m2()");
	}
	void m3() {
		System.out.println("class193:m3()");
	}
}
