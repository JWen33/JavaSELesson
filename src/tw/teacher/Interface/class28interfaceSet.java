package tw.teacher.Interface;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;
import java.util.SortedSet;
import java.util.TreeSet;

public class class28interfaceSet {

	public static void main(String[] args) {
//		HashSet<Integer> power = new HashSet<Integer>();
		TreeSet<Integer> power = new TreeSet<Integer>();
//		set.add(12);
//		set.add(555);
//		set.add(byte(12)); // 沒有自動轉型
//		System.out.println(set);
		
		while (power.size() < 6) {
			power.add(new Random().nextInt(1, 38));
		}
		System.out.println(power);
		System.out.println("------");
		
		Iterator<Integer> it = power.iterator();
		while (it.hasNext()) { // 還有下一個值嗎?
			Integer num = it.next(); // 有的話取出
			System.out.println(num);
			System.out.println("------");
			
			// iterable 都可以直接使用
			for (Integer v : power) {
				System.out.println(v);
			}
			
		}

	}

}
