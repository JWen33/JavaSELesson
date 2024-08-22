package tw.teacher.ArrayFOR;

public class class07For {

	public static void main(String[] args) {
		int [] ary1;
		ary1 = new int[3]; //需要初始化(new)才可使用，會在記憶體中真正佔有空間，0做為一個基準，偏移1.2...之類找資料速度才會快，初始化整數陣列，長度為 3
		System.out.println(ary1[0]); //整數預設是0
		boolean [] ary2 = new boolean[2]; // 初始化布林值陣列，長度為 2
		System.out.println(ary2[0]); //預設為false
		
		System.out.println(ary1[0]);
		System.out.println(ary1[1]);
		System.out.println(ary1[2]);
		System.out.println(ary1.length);
		ary1[1] = 100;
		ary1[2] = 425;
		//ary1[3] = 756; //編譯時沒有錯誤，執行才錯誤(run time exception)，因為[]中只要是 >=0 的整數都可以
		for (int i = 0; i < ary1.length; i++) {
			System.out.println(ary1[i]);
		}
		System.out.println("-----");
		for (int v : ary1) { //for each的概念，左邊是元素型別的變數，右邊是想尋訪的陣列
			System.out.println(v);
		}
		
	}
}
