package tw.teacher.apis;

public class Car extends Scooter {
	public Car() { // 如果父元素沒有傳參數建構式建構式，可以自己建立一個建構式(不一定要無傳參數)，一定要在第一道
//		super();  // 會報錯
		super("");  // 不會報錯
		System.out.println("Car(int)");
	}

}
