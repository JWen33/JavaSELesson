package tw.teacher.tutor;

import java.util.Random;

import tw.teacher.apis.TWID;

public class class17ID {

	public static void main(String[] args) {
//		System.out.println(TWID.isRight("B222616944"));
//		
//		Random rand = new Random();
//		System.out.println(rand.nextInt(2));
		
		
		TWID id1 = new TWID();
		TWID id2 = new TWID(false);
		TWID id3 = new TWID('B');
		TWID id4 = new TWID(true, 'Y');
		TWID id5 = TWID.newTWID("B222616944");
		
		System.out.println(id1.getID());
		System.out.println(id2.getID());
		System.out.println(id3.getID());
		System.out.println(id4.getID());
		System.out.println(id5);
		
	}

}


