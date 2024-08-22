package tw.teacher.Interface;

import java.util.HashMap;
import java.util.Set;

public class class32HashMap {

	public static void main(String[] args) {
		HashMap<String, Object> map = new HashMap<>(); // 沒有迭代，不能用for each
		map.put("name", "Leo");
		map.put("Age", 39);
		map.put("gender", true);
		map.put("Height", "185.2");
		System.out.println(map.get("Age"));
		System.out.println(map.get("---"));
		
		Set<String> keys = map.keySet();
		for (String key : keys) {
			System.out.printf("%s => %s\n", key, map.get(key));
		}
		
	}

}
