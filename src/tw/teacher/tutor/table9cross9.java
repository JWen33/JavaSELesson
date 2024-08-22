package tw.teacher.tutor;

public class table9cross9 {

	public static void main(String[] args) {
		//可以先將要的數字印出來，再將其用變數去代替，盡量不要用常數，可以加大彈性
		final int ROWS = 1; //常數一次給值不變，慣例用全大寫
		final int COLS = 9;
		final int START = 1;
		
		for (int k = 0; k < ROWS; k++) {
			for (int j = 1; j < 10; j++) {
				for (int i = START; i < START + COLS; i++) {
					int newi = i + k * COLS;
					int r = newi * j;
					System.out.printf("%d x %d = %d\t", newi, j, r);
				}
				System.out.println();
			}
			System.out.println("----");
		}

	}

}
