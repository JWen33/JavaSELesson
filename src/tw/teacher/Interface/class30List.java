package tw.teacher.Interface;

import java.io.File;
import java.util.LinkedList;
import java.util.List;

public class class30List {

	public static void main(String[] args) {
		List list = new LinkedList(); // 沒有泛型(指定型別)，所有物件都可以丟進來
		list.add(123);
		list.add("Leo");
		list.add(12.6);
//		list.add(0, 12.6); // 也可以指定位置插入
//		list.add(5, true); // 會報錯，因為我插入這個true的時候，格子只有4個不可能有5可以用，running Exceptio
		list.add(true);
		list.add(12.6);
		
		list.add(list.remove(2));
		
		System.out.println(list.size());
		System.out.println("----");
		
		for (Object obj : list) { 
			System.out.println(obj); // 各自物件的toString的實作
		}
		
		
	}

}
