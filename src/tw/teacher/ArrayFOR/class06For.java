package tw.teacher.ArrayFOR;

public class class06For {

	public static void main(String[] args) {
//		for ( 初始化程式區塊只會執行一次 ;; 執行完收尾的敘述句，只要boolean為 true就一定會執行) { //無窮，中間為boolean，沒寫視為true
//			System.out.println("OK");
//		}
		// 基本的 for 迴圈，打印 0 到 9
		for (int i = 0; i < 10; i++) {
			System.out.println(i);
		}
	
		//變數宣告在哪就存在於哪，初始化變數 i
		int i = 0;
		for ( printBrad() ; i < 10; printLine()) {
			System.out.println(i++);
		}
		//System.out.println("----");
		System.out.println(i); // 最後 i 的值為 10
	}
	static void printBrad() {
		System.out.println("Brad");
		printLine();
	}	
	static void printLine() {
		System.out.println("-----");
	}
}
