package tw.teacher.OOP;

import tw.teacher.apis.Scooter;

public class class13ObjectOriented {

	public static void main(String[] args) {
		Scooter s1 = new Scooter(); // 呼叫該類別的建構式
		
		
		
		s1.changerGear(1);
		s1.upSpeed();
		s1.upSpeed();
		s1.upSpeed();
		s1.downSpeed();
		System.out.println(s1.getSpeed());
		
		
		s1.changerGear(3);
		s1.upSpeed();
		s1.upSpeed();
		System.out.println(s1.getSpeed());
		
		System.out.println(s1.getColor());
		
	}

}
