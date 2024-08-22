package tw.teacher.Interface;

import java.util.LinkedHashSet;

public class class29interfaceSet {

	public static void main(String[] args) {
		LinkedHashSet<String> names = new LinkedHashSet<>();
		System.out.println(names.add("Loe")); // 回傳布林，判斷是否有沒有重複
		names.add("Mark");
		names.add("Ian");
		names.add("Mark"); // 遇到一樣進不來
		names.add("Mark");
		System.out.println("----");
		
		for (String name : names) {
			System.out.println(name);
		}
		
	}

}
