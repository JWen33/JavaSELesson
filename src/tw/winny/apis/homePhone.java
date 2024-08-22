package tw.winny.apis;

import java.util.Random;

public class homePhone {

	private String homePhone;
	private String areaCode;
	private static String[] validAreaCodes = {"02", "03", "04", "05", "06", "07", "08"};

	public homePhone() {
		this("0000000000");
	}

	public homePhone(String homePhone) {
		if (isRight(homePhone)) {
			this.homePhone = homePhone;
			this.areaCode = homePhone.substring(0, 2);

		} else {
			System.out.println("Invalid Phone Number!");
		}
	}

	public String gethomephone() {
		return homePhone;
	}

	public String getareaCode() {
		return areaCode;
	}

	public String getareaName() {
		switch (areaCode) {
		case "02": return "Taipei";
		case "03": return "Touyoun";
		case "04": return "Taichung";
		case "05": return "Tainan";
		default: return "Unknown";
		}
		
	}
	
	// 自動生成電話號碼
//	public static homePhone newhomePhone() {
//		Random rand = new Random();
//		String areaCode = validAreaCodes[rand.nextInt(validAreaCodes.length)];
//		int numberLength = 
//		
//	}
	
	
	public static boolean isRight(String homePhone) {
		
		
		boolean isRight = false;
		
		if (homePhone.matches("(^0[2-8])(\\d{7,8})")) {
			String areaCode = homePhone.substring(2);
			for (String validAreaCode : validAreaCodes) {
				if (homePhone.startsWith(validAreaCode)) {
					isRight = true;
					break;
				}
			}	
		}
		return isRight;
	}
}





