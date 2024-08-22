package tw.teacher.Interface;

import java.util.LinkedList;
import java.util.List;

public class class31List {

	public static void main(String[] args) {
		List<String> times = new LinkedList<String>(); // 反過來顯示
		times.add(0, "10:20:30");
		times.add(0, "10:20:38");
		times.add(0, "10:20:41");
		times.add(0, "10:20:43");
		times.add(0, "10:20:50");
		System.out.println("-----");
		
		for (String time : times) {
			System.out.println(time);
		}
		
		// 如果使用for loop去改寫
	}

}
