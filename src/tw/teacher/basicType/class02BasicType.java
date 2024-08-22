package tw.teacher.basicType;

import java.util.Scanner; //除了java.lang這個類別以外的都需要import，可以透過 ALT+/可以快速帶入

public class class02BasicType {

	public static void main(String[] args) {
		// TODO Auto-generated method stub 先定義可以再找回欲執行的程式
		
		//input
		Scanner scanner = new Scanner(System.in); //參考API的語法 // new 關鍵字後面的引數必須是類名，並且類名的後面必須是一組構造方法引數(必須帶括號)
		// println會換行 print不會換行
		System.out.print("a = ");
		int a = scanner.nextInt();
//		System.out.println(a);
		System.out.print("b = ");
		int b = scanner.nextInt();

		//op...
		int r = a + b;
		
		//output format(格式化) d十進位
		System.out.printf("%d + %d = %d\n", a, b, r);
		System.out.printf("%d - %d = %d\n", a, b, a - b);
		System.out.printf("%d * %d = %d\n", a, b, a * b);
		System.out.printf("%d / %d = %d\n", a, b, a / b);
		System.out.printf("%d %% %d = %d\n", a, b, a % b);
		System.out.printf("%d / %d = %d...%d", a, b, a / b, a % b);
	}

}
