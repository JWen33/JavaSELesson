package tw.teacher.basicType;

import tw.teacher.apis.Bike;

public class class16String {

	public static void main(String[] args) {
		String s1 = new String(); //長度固定
		System.out.println(s1.length());
		
		byte[] b1 = {97, 98, 99, 100}; //轉換常用
		String s2 = new String(b1);
		System.out.println(s2.length());
		System.out.println(s2); // 呼叫String物件時，會使用toString()，已改寫的方法
		
		Bike b2 = new Bike();
		System.out.println(b2); // @2ff4acd0記憶體位置，與陣列相似
		
		int c = 12;
		System.out.println(c);
		
		Object obj1 = new Object();
		System.out.println(obj1);
		
		String s3 = "Brad"; // 出現""會在記憶底中的string pool中創建一個Brad物件實體
		System.out.println(s3);
		String s4 = "Brad"; // 從現有的記憶體中撈Brad物件實體，所以記憶體位置一樣
		String s5 = new String("Brad"); // 產生新的記憶體位置(新的物件實體)
		String s6 = new String("Brad"); 
		System.out.println(s3 == s4);  // 從現有的記憶體中撈Brad物件實體，所以記憶體位置一樣
		System.out.println(s3 == s5);  
		System.out.println(s5 == s6);  		
		System.out.println("------");
		
		System.out.println(s3.equals(s4));
		System.out.println(s3.equals(s5));
		System.out.println(s3.equals(s6));
		System.out.println(s5.equals(s6));
		
		System.out.println("Brad".charAt(0));  //雙引號即字串物件可以直接叫方法
		
		System.out.println(s3.concat("hello")); //產生新物件實體
		System.out.println(s3);
		
		//安全性 StringBuffer > StringBulider ； 效能 StringBuffer < StringBulider
	}

}




