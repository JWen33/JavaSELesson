package tw.winny.code;

import tw.winny.apis.Coffee;
import tw.winny.apis.CoffeeShop;

public class MyCoffeeShop {

	public static void main(String[] args) {
		Coffee myCoffee = new Coffee("拿鐵", "大杯", 100);
		System.out.println(myCoffee);
		CoffeeShop myCoffeeShop = new CoffeeShop();

	}

}
