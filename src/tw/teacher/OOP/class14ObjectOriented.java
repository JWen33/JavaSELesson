package tw.teacher.OOP;

import tw.teacher.apis.Bike;
import tw.teacher.apis.Car;
import tw.teacher.apis.Scooter;

public class class14ObjectOriented {

	public static void main(String[] args) {
		Scooter s1 = new Scooter("black"); // 同時也做出了腳踏車實體，只是沒有呼叫
		System.out.println(s1.getColor());
		
	
		Bike b1 = new Bike(); // 可以呼叫建構式去初始化。只執行這個的時候 => Bike()
		
		
		Car c1 = new Car(); // 只有執行這行時 => Bike() Scooter()，所有的上層元素都會被呼叫
		
		
	}

}
