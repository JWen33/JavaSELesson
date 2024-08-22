package tw.teacher.io;

public class class38 {

	public static void main(String[] args) {
		m1();
		System.out.println("Game Over");
	}
	
	static void m1() { 
		System.out.println("1");
		int[] a = {1, 2, 3, 4};
		
		try {
			System.out.println(a[10]);	
			System.out.println("上面沒有例外才印出這訊息");
//			return; 
		} catch (Exception e) {
			System.out.println(e);
//			return; 
		} finally {
			System.out.println("f"); // 確保整個區塊的結尾，會在return之前就執行，後面的OK就不會執行
		}
		System.out.println("OK");
	}

}
