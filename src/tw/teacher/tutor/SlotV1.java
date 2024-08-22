package tw.teacher.tutor;

public class SlotV1 {

	public static void main(String[] args) {
		
		String[] symbol = {"豬", "貓", "狗", "牛"};
		
		
		String[] result = new String[3];
		for (int i = 0; i < 3; i++) {
			int rand = (int)(Math.random() * (symbol.length));
			result[i] = symbol[rand];
			
//			System.out.println(symbol[rand]);
		}
		System.out.printf("[%s, %s, "
				+ "%s]", result[0], result[1], result[2]);
		System.out.println("\n-----");
		
		if (result[0].equals(result[1]) && result[1].equals(result[2])) {
			System.out.println("Congrat! You get a line.");
		} else {
			System.out.println("Try again!");
			
		}
 	}

}

