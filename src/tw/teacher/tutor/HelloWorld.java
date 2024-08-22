package tw.teacher.tutor;

//定義類別名稱，public(全世界，類似一個開方入口) class為主類別只會有一個且必須與檔名一樣
public class HelloWorld { 
	//程式執行進度入點，public 存取修飾字指開放；static 靜態記憶體位置；void指main 方法return的資料型別需要先定義，此指沒有回傳；[]參數皆被視為字串，所以使用字串陣列；args字串陣列的名稱(自行定義)
	public static void main(String[] args) {
		//system使用者作業系統，out的輸出
		System.out.println("Hello World");
	}
}
