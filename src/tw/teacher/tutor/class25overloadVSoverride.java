package tw.teacher.tutor;

public class class25overloadVSoverride {
	// overload vs override
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

class class251 {
	void m1() {}
	void m1(int a) {}
	public int m1(double a) {return 1;}
	int m2() {return 1;}
	Object m3() {return "";}
}

class class252 extends class251 {
	// 方法名稱參數型別一樣 => override，在基本型別、包含void都要要與爸爸一模一樣，子類別只要發揚光大就不會編譯錯誤
	int m2() {
		return 1;
	} 
	
	String m3() { // String is a object ，子類別只要發揚光大就不會編譯錯誤
		return "";
	}
	
}