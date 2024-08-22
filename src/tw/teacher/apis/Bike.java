package tw.teacher.apis;

import java.io.Serializable;

//類別(class)是定義物件的屬性(最重要)、方法
// 設計物件
// public(全域) > protected(子類別+相同package) > 沒寫(同package)幾乎不這樣用 > private(只有在類別中可以使用) 可以修飾member(屬性、方法)

public class Bike implements Serializable /*extends Object*/ { //創立一個腳踏車類別，最源頭父元素為Object
//	private double speed;  //具有速度的屬性，改成private後就只能在此使用，屬性是透過(以下)方法來作改變
	
	protected double speed;  //protected繼承的子類別可以使用此屬性
	
	public Bike() { // 定義腳踏車建構式
		System.out.println("Bike()"); 
	}
	
	public void upSpeed() { //提供一個方法去存取(給)屬性
		speed = speed < 1? 1 : speed * 1.4; //隨意撰寫即可
		
	} 
	
	public void downSpeed() { // 再提供一個方法去存取(給)屬性
		speed = speed < 1? 0 : speed * 0.8; //隨意撰寫即可
	}
	
	public double getSpeed() {
		return speed;
	}
	
	@Override
	public String toString() {
		return "This is bike.";
	}
	
}

