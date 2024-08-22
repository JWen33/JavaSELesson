package tw.teacher.apis;

import java.util.Random;

public class TWID {
	private String id;
	static String letters = "ABCDEFGHIJKLMNPQRSTUVXYWZIO"; //從區域變數換成類別屬性 => 換報錯 static與物件要分開 => 加上static => 變成屬於物件與static
	
	public TWID() {
		// 第一道敘述句一定是 super() 或是 this()呼叫自己本類別的建構式 
		this(new Random().nextInt(2) == 0);
	}
	public TWID(boolean isMale) {
		this(isMale, letters.charAt(new Random().nextInt(26)));
	}
	public TWID(char area) {
		this(new Random().nextInt(2) == 0, area);
	}
	public TWID(boolean isMale, char area) {
		// super();
		String c1 = new String(new char[] {area});
		StringBuffer sb = new StringBuffer(c1);
		sb.append(isMale? "1":"2");
		for (int i = 0; i < 7; i++) sb.append(new Random().nextInt(10));
		
		for (int i = 0; i < 10; i++) { //用補最後一個數字去判斷是否對
			if (isRight(sb.toString() + i)) {
				id = sb.toString() + i;
				break;
			}
		}
	}
	
//	public TWID(String id) {
//		if (isRight(id)) {
//			this.id = id;
//		}
//	}
	
	//原本想初始化，但回傳可能會非身分證
	private TWID(String id) { //創建一個TWID，要符合isRight才可以創建出NEW ID
		this.id = id;
	}
	
	public static TWID newTWID(String id) {
		if (isRight(id)) {
			return new TWID(id);
		} else {
			return null;  //throw new exception()
		}
	}
		
	public String getID() {
		return id;
	}
	
	
	public boolean isMale() {  // 方法回傳是男生女生
		
		return true;
	}
	
	public boolean area() {  // 方法回傳是哪個地區
		
		return true;
	}
	
	
	// static方法
	public static boolean isRight(String id) { // 對外開放使用public，此id為參數接收用，static與物件無關的方法，想放在哪個類別都可以，但要合乎羅機比較好
		boolean isRight = false;
		

//		if (id.length() == 10) {
//			if (letters.indexOf(id.charAt(0)) != -1) { // 用ASCII code來判斷 或是 使用indexOf
//				if (id.charAt(1) == 1 || id.charAt(1) == 2) { // char基本型別用==來判斷就好
//					if() // 判斷3-10為數字
//				}
//			}
//		} 

		if (id.matches("[A-Z][12][0-9]{8}")) {
			char c1 = id.charAt(0);
			int a12 = letters.indexOf(c1) + 10;
			int a1 = a12 / 10;
			int a2 = a12 / 10;
			
			String s1 = id.substring(1, 2);
			int n1 = Integer.parseInt(s1);
			int n2 = Integer.parseInt(id.substring(2, 3));
			int n3 = Integer.parseInt(id.substring(3, 4));
			int n4 = Integer.parseInt(id.substring(4, 5));
			int n5 = Integer.parseInt(id.substring(5, 6));
			int n6 = Integer.parseInt(id.substring(6, 7));
			int n7 = Integer.parseInt(id.substring(7, 8));
			int n8 = Integer.parseInt(id.substring(8, 9));
			int n9 = Integer.parseInt(id.substring(9, 10));
			
			int sum = a1*1 + a2*9 + n1*8 + n2*7 + n3*6 + n4*5 + n5*4 + n6*3 + n7*2 + n8*1 + n9*1;
			
			isRight = sum % 10 == 0;
			
		}
		return isRight;

			
		
		
		

		// 電話號碼
		

		// 時間

		// 日期

		// ip

	}
}
