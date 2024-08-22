package tw.teacher.poker;

import java.util.Arrays;

public class PokerV1P1 {

	public static void main(String[] args) {

		// 洗牌
		int[] poker = new int[52];
		for (int i = 0; i < poker.length; i++) {
			int temp = (int) (Math.random() * 52);

			boolean isRepeat = false;
			for (int j = 0; j < i; j++) {
				if (temp == poker[j]) {
					isRepeat = true;
					
					break;
				}
			}
			if (!isRepeat) {
				poker[i] = temp;
				System.out.printf("%d ", poker[i]);
			} else {
				i--;
			}
		}
		System.out.println("\n--------");
		//驗算
		for (int a : poker) {
			System.out.printf("%d ", a);
		}
		System.out.println("\n--------");
		
		
		// 發牌(有四位玩家，每個人要有13張牌，要有兩層陣列)
		int[][] players = new int[4][13];
		
		for (int i = 0; i < poker.length; i++) {
			players[i % 4][i / 4] = poker[i];
		}
		//檢查
		for (int card : players[0]) {
			System.out.printf("%d ", card);
		}
		System.out.println("\n--------");
		
		
		String[] suits = {"黑桃", "紅心", "方塊", "梅花"};
		String[] values = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "k"};
		// 攤牌 + 理牌
		for (int[] player : players) {
			
			Arrays.sort(player);
			
			for (int card : player) {
				System.out.printf("%s%s ", suits[card / 13], values[card % 13]);
			}
			System.out.println();
		}
		

	}

}
