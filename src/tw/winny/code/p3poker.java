package tw.winny.code;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class p3poker {

	public static void main(String[] args) {
		/*
		 * 假設你在朋友聚會上進行一場撲克牌遊戲。每位玩家會得到5張牌，並且每張牌的花色和數字是隨機的。請你模擬這個發牌過程，並將每位玩家的牌按花色和數字進行排序，
		 * 最後打印每位玩家的牌。
		 * 
		 * 要求： 
		 * 使用 ArrayList 來表示牌組。 使用 Collections.shuffle() 來洗牌。 將牌發給4位玩家，每位玩家5張牌。
		 * 將每位玩家的牌按花色和數字排序。 打印每位玩家的牌。
		 */
		
		// 初始化排組
		String[] suits = {"黑桃", "紅心", "方塊", "梅花"};
		String[] values = {"A", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};
		ArrayList<String> poker = new ArrayList<String>();
		
		for (String suit : suits) {
			for (String value : values) {
				poker.add(suit + value);
			}
		}
//		System.out.println(poker);
		
		// 洗牌
		Collections.shuffle(poker);
		System.out.println(poker);
		
		// 發牌
		List<String>[] player = new List[4];
		for (int i = 0; i < 4; i++) {
			player[i] = new ArrayList<String>();
		}
//		System.out.println(player[1]);
		
		for (int i = 0; i < 20; i++) {
			player[i % 4].add(poker.get(i));
		}
//		System.out.println(player[0]);
	
		// 理牌&攤牌
		for (int i = 0; i < 4; i++) {
			Collections.sort(player[i]);
			System.out.printf("第%d位玩家的牌為%2s\n", i +1, player[i]);
		}
		
		
		

	}

}
