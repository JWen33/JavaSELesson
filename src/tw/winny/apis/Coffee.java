package tw.winny.apis;

public class Coffee {
	private String coffeeName;
	private String cupSize;
	private int price;
	
	
	public Coffee(String coffeeName, String cupSize, int price) {
		this.coffeeName = coffeeName;
		this.cupSize = cupSize;
		this.price = price;
	}
	
	public String getCoffeeName() {
		return coffeeName;
	}
	
	public String getcupSize() {
		return cupSize;
	}
	
	public int getprice() {
		return price;
	}
	
	public String getInfo() {
		return coffeeName + cupSize + "：" + price + "元";
	}

}
