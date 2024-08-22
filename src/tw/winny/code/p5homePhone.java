package tw.winny.code;

import java.security.DrbgParameters.NextBytes;
import java.util.Scanner;

import tw.winny.apis.homePhone;

public class p5homePhone {

	public static void main(String[] args) {
		homePhone myPhone = new homePhone("0222012368");
		homePhone myPhone2 = new homePhone();

		
//		Scanner homePhone = new Scanner("System.in");
//		String homePhoneNumber = homePhone.next();
		
		System.out.println(myPhone2.gethomephone());
		System.out.println("Phone:" + myPhone.gethomephone());
		System.out.println("Area:" + myPhone.getareaName());
		
	}

}
