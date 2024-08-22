package tw.teacher.io;

public class class35 {

	public static void main(String[] args) {
		int a = 10, b = 0; // 編譯成功但出現了exception
		int[] d = {0, 1, 2, 3};
		
		try {
			int c = a/ b ; // 通常是相依性或相同邏輯才寫同一個例外，再包一個try catch
			System.out.println(c);
			System.out.println(d[2]);
		} catch(ArithmeticException e) {
			System.out.println("Error");
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("Error2");			
		} catch (RuntimeException e) {
			System.out.println("Error3");
		}
		System.out.println("OK");
	}

}
