
package tw.teacher.OOP;

import tw.teacher.apis.Bike; //有宣告用選的會自動跳出來

public class class12ObjectOriented {

	public static void main(String[] args) {
		Bike myBike = new Bike(); // 完成初始化。該物件中的屬性也會有一個預設的值
		Bike urBike = new Bike();
		System.out.println(myBike.getSpeed()); //一開始選不到是因為speed沒有設置存取修飾字public
		
		myBike.upSpeed();myBike.upSpeed();myBike.upSpeed();myBike.upSpeed();
		myBike.downSpeed();
		System.out.println(myBike.getSpeed());
		
		System.out.println("----");
		System.out.println(urBike.getSpeed());
		urBike.upSpeed();
		System.out.println(urBike.getSpeed());
		
		for (int i = 0; i < 11; i++) {
			myBike.upSpeed();
		}
		
//		myBike.speed = 10;
		System.out.println(myBike.getSpeed());
	}

}
