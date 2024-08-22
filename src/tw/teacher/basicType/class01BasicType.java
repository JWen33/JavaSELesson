package tw.teacher.basicType;

public class class01BasicType {

	public static void main(String[] args) { //在方法中宣告變數，稱為區域變數
		// 整數：byte, short, int, long
		byte var1; // 2^8 => -128 ~ 127
		var1 = 12;
		byte var2 = 123; //變數名稱命名規則(第一個字/二~多個字) [a-zA-Z$_][a-zA-Z0-9$_]*，不使用關鍵字
		byte $$$ = 123;
		System.out.println($$$); //盡量不要$開頭
		short var3 = 1000;// 2^16 => -32767 ~ 32766
		int var4 = 2543549; // 2^32 => -2G ~ 2G-1(電腦語言)
		long var5 = 115315878; // 2^64
		
	}

}
