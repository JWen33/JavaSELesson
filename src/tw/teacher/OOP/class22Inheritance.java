package tw.teacher.OOP;

public class class22Inheritance {

	public static void main(String[] args) {
		 class221 obj1 = new class222();
		 class223 obj2 = new class222();
		 class222 obj3 = new class222();
		 obj1.m1();;
		 obj2.m4();
		 obj3.m2(); obj3.m3();
	}

}

interface class221 { // 定義介面，沒有實作(後續有新版本預設)
	void m1();
	void m2();
}
interface class223 { // 定義介面，沒有實作(後續有新版本預設)
	void m3();
	void m4();
}
class class222 implements class221, class223 {
	public void m1() {}
	public void m2() {}
	public void m3() {}
	public void m4() {}
}