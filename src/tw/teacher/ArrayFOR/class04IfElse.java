package tw.teacher.ArrayFOR;

public class class04IfElse {

	public static void main(String[] args) {
		// API中static +數學，與物件無關可以直接使用，前面使用的scanner則需要物件
		double temp = Math.random(); // 0.0 ~ 1.0(不含)
		System.out.println(temp);
		int score = (int)(temp * 101); //轉換int優先權比較高，運算式記得要加()，常數一定要說得出意義，此處為從0開始到100的整數，共有101個
//		int score = (int)(temp * 40) +30; 
		System.out.println(score);
		
		if (score >= 90) { //打前括號會自行帶入後面括號
			System.out.println("A");
		} else if (score >= 80) {
			System.out.println("B");
		} else if (score >= 70) {
			System.out.println("C");
		} else if (score >= 60) {
			System.out.println("D");
		} else {
			System.out.println("E");
		}
	}

}
