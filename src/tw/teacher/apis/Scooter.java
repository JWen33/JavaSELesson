package tw.teacher.apis;


// 設計物件
public class Scooter extends Bike {
	private int gear; //gear屬性
	private String color;
	
	// 重要，建構式不是在產生物件實體!!new才是在記憶體中設置物件實體
	//建構式通常放在屬性跟方法之間，不需要傳回值，名稱要與類別名稱一模一樣的方法，通常用來進行物件的初始化，一次姓
	public Scooter() {  // 這個註解調會影響子，// 原因java中所有的類別一定會有建構式，如果沒有定義時，編譯器會將沒有傳參數的建構式拿來用
		System.out.println("Scooter()");
		color = "yellow";
	}
	
	public Scooter(String color) {  // 這個註解不會影響子元素，// 原因java中所有的類別一定會有建構式，如果沒有定義時，編譯器會將沒有傳參數的建構式拿來用
		System.out.println("Scooter(String)");
		this.color = color;
	}
	
	public void changerGear(int gear) { //gear變數
		if (gear >= 0 && gear <= 4) {
			this.gear = gear; //表示自己(if中的)
		}
	}

	@Override // 目前沒有作用，此僅提示是改寫
	public void upSpeed() { //改寫內容再大括號李
		super.upSpeed(); // super是指呼叫父類別(java永遠只有一個，其他語言可能會有多個)的物件實體，這段可以不用寫
		if (gear > 0) {
			speed = speed < 1? 1 : speed * 1.9;			
		}
	}
	
	public String getColor() { // 物件基本型別初始化都是null，所以需要建構是去做初始化
		return color;
	}
	
}
