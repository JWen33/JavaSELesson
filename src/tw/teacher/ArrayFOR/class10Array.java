package tw.teacher.ArrayFOR;

public class class10Array {

	public static void main(String[] args) {
		
		int [][] a = new int[3][];
		a[0] = new int[2]; //在a陣列0中在初始化第二個陣列
		a[1] = new int[3]; //在a陣列1中在初始化第二個陣列
		a[2] = new int[4]; //在a陣列2中在初始化第二個陣列
	
		for (int[] a1 : a) {
			for (int v : a1) {
				System.out.print(v + " ");
			}
			System.out.println();
		} 
		
	}

}
