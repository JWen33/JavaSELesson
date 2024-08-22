package tw.teacher.ArrayFOR;

public class class08For {

	public static void main(String[] args) {
		int p0, p1, p2, p3, p4, p5, p6;
		p0 = p1 = p2 = p3 = p4 = p5 = p6 = 0;
		
		// 進行 100 次隨機數生成並進行統計
		for (int i = 0; i < 100; i++) {
			double temp = Math.random();
			int point = (int)(temp * 6) + 1;
			switch (point) { 
				case 1 : p1++; break;
				case 2 : p2++; break;
				case 3 : p3++; break;
				case 4 : p4++; break;
				case 5 : p5++; break;
				case 6 : p6++; break;
				default: p0++; //如果出現0以外的數字可能是隨機邏輯有錯誤
			}
		}
		
			// 檢查是否有錯誤，並打印結果
			if (p0 > 0) {
				System.out.println("Error");
			} else {
				System.out.printf("%d點出現%d次\n", 1, p1);
				System.out.printf("%d點出現%d次\n", 2, p2);
				System.out.printf("%d點出現%d次\n", 3, p3);
				System.out.printf("%d點出現%d次\n", 4, p4);
				System.out.printf("%d點出現%d次\n", 5, p5);
				System.out.printf("%d點出現%d次\n", 6, p6);
			}
			
			
			
//			if (point == 1) {
//				p1++;
//			} else if (point == 2) {
//				p2++;
//			} else if (point == 3) {
//				p3++;
//			} else if (point == 4) {
//				p4++ = p4 + 1;
//			} else if (point == 5) {
//				p5++;
//			} else if (point == 6) {
//				p6++;
//			}

	}

}
