package tw.teacher.poker;

import java.util.Arrays;

public class PokerV3 {

	public static void main(String[] args) {
		// 洗牌
		final int nums = 52;
		int[] poker = new int[nums];

		for (int i = 0; i < poker.length; i++) {
			poker[i] = i;
		}

		for (int i = nums - 1; i > 0; i--) {
			int rand = (int) (Math.random() * (i + 1));
			// poker[rand] <=> poker[i]
			int temp = poker[rand];
			poker[rand] = poker[i];
			poker[i] = temp;
		}

		// 驗算洗牌
		for (int card : poker) {
			System.out.println(card);
		}
		System.out.println("----");

		// 發牌
		int[][] players = new int[4][13];

		for (int i = 0; i < poker.length; i++) { // 利用i去撰寫index的規律
			players[i % 4][i / 4] = poker[i];
		}

		// 驗算發牌
		for (int card : players[0]) {
			System.out.printf("%02d ", card);
		}
		System.out.println("\n----");
		
		//使用字串陣列去做做花色與數字的分配
		String[] suits = { "黑桃", "紅心", "方塊", "梅花" };
		String[] values = { "A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K" };

		// 攤牌 + 理牌
		for (int[] player : players) {
			
			Arrays.sort(player);
			
			for (int card : player) {
				System.out.printf("%2s%2s ", suits[card / 13], values[card % 13]);
			}
			System.out.println();
		}

	}

}
