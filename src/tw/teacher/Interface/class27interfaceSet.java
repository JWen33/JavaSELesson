package tw.teacher.Interface;

import java.util.HashSet;

import tw.teacher.apis.Bike;

public class class27interfaceSet {

	public static void main(String[] args) {
		HashSet set = new HashSet();
		
		set.add("Hi");
		set.add(12); // 已執行 auto-boxing 12 => new Integer (12) 的物件放進set中
		set.add(12.3);
		set.add(true);
		set.add("Hi");
		set.add(new Bike());
		set.add(12.3);

		System.out.println(set.size());
		System.out.println(set); // toString被改寫所以不會印出記憶體位置而是set中的值
	}

}
