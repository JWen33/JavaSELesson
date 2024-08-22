package tw.teacher.io;

public class class37 {

	public static void main(String[] args) {
		class371 obj = new class371();
		
		try {
			obj.m1();
		} catch (Exception e) {

		}
	}

}

class class371 {
	void m1() throws Exception {
		System.out.println("class371:m1()");
		m2();
	}
	void m2() throws Exception {
		System.out.println("class371:m2()");
		m3();
	}
	void m3() throws Exception {
		System.out.println("class371:m3()");
		throw new Exception();
	}
}