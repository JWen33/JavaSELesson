package tw.teacher.ArrayFOR;

public class class11XOR {

	public static void main(String[] args) {
		int a = 10, b = 3;
//		int k = a;
//		a = b;
//		b = k;
		
//		a = a + b;
//		b = a - b;
//		a = a - b;
//		System.out.printf("a = %d, b = %d", a, b);
		
		
		a = a ^ b;
		System.out.println(a);
		b = a ^ b;
		System.out.println(b);
		a = a ^ b;
		System.out.println(a);

	}

}
