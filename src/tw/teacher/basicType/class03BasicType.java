package tw.teacher.basicType;

public class class03BasicType {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// float, double 
		float var1 = 10;
		System.out.println(var1);
		float var2 = 10.1f; //預設為double，加上f即可
		double var3 = 12.3;
		
		// boolean
		boolean var4 = true; //記憶體佔1bit，不是儲存，沒有0與非0，僅有布林來做邏輯判斷
		
		//char
		char c1 = 'a'; // 佔有空間2^16，永遠為正，0~65535，也可以用數學運算但意義不大，應用不常見，97-a/98-b/.....(編碼儲存數字，以字元呈現)
		char c2 = 65;
		char c3 = '資';
		System.out.println(c1);
		System.out.println(c2);
		System.out.println(c3);
	}

}
