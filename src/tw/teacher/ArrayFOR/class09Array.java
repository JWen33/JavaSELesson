package tw.teacher.ArrayFOR;

public class class09Array {

	public static void main(String[] args) {
		int[] p = new int[7];

		for (int i = 0; i < 100; i++) {
			double temp = Math.random();
			int point = (int) (temp * 9) + 1;
			if (point >= 1 && point <= 9) {
				p[point > 6? point - 3 : point]++; //遊戲規則如果789將點數將入456
			} else {
				p[0]++;
			}
		}
		if (p[0] > 0) {
			System.out.println("Error");
		} else {
			for (int i = 1; i < p.length; i++)
				System.out.printf("%d點出現%d次\n", i, p[i]);

		}

	}

}
