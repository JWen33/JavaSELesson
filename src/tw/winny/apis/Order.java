package tw.winny.apis;

import java.util.ArrayList;
import java.util.List;

public class Order {
	private int OrderNumber;
	private List<Coffee> coffeeList;
	private int totalPrice;

	
	public Order(int OrderNumber) {
		this.OrderNumber = OrderNumber;
		this.coffeeList = new ArrayList<>();
		this.totalPrice = 0;
	}
	
	public void addCoffee(Coffee coffee) {
		coffeeList.add(coffee);
		caculateTotalPrize();
	}
	
	public void caculateTotalPrize() {
		totalPrice = 0;
		for (Coffee coffee : coffeeList) {
			totalPrice = totalPrice + coffee.getprice() * OrderNumber;
		}
	}
	
	public String getOrderInfo() {
		StringBuffer info = new StringBuffer("訂單編號" + OrderNumber + "：");
		for (Coffee coffee : coffeeList) {
			info.append(coffee.getInfo());
		}
		info.append(" Total $" + totalPrice);
		return info.toString();
	} 
}
