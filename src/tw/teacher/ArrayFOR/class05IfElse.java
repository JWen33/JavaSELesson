package tw.teacher.ArrayFOR;

public class class05IfElse {

	public static void main(String[] args) {
		int year = 2024;
		boolean isLeap;

		if (year % 4 == 0) {
			if (year % 100 == 0) {
				if (year % 400 == 0) {
					isLeap = true; // 29天
				} else {
					isLeap = false; // 28天
				}
			} else {
				isLeap = true;
			}

		} else {
			isLeap = false;
		}
		System.out.printf("%d年為%s年", year, isLeap ? "閏" : "平");
		
		

		if (year % 400 == 0 || (year % 4 == 0 && year % 100 != 0)) { //另一種寫法
		} else {
		}
	}

}
