package tw.winny.code;

import java.util.ArrayList;
import java.util.Collections;

public class p4HighCard {

	public static void main(String[] args) {
		int numPlayers = 5;
		int cardPerPlayer = 5;
		
		// 洗牌
		ArrayList<Integer> poker = new ArrayList<Integer>();
		for (int i = 0; i < 52; i++) {
			poker.add(i);
		}
		Collections.shuffle(poker);
		System.out.println(poker);
		
		
		// 發牌
		ArrayList<ArrayList<Integer>> players = new ArrayList<>();
		for (int i = 0; i < numPlayers; i++) {
            players.add(new ArrayList<>());
        }
		for (int i = 0; i < numPlayers * cardPerPlayer; i++) {
            players.get(i % numPlayers).add(poker.get(i));
        }
		
//		// 驗證(尚未帶入花色)
//		for (int i = 0; i < numPlayers; i++) {
//			System.out.printf("Player %d: ", i);
//			for (int card : players[i]) {
//				
//				System.out.printf("%02d ", card);
//			}
//			System.out.println();
//		}
		
		// 理牌+攤牌
		String[] suits = {"黑桃", "愛心", "方塊", "梅花"};
		String[] values = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};
		
		for (ArrayList<Integer> player : players) {
			Collections.sort(player);
		}
		for (int i = 0; i < numPlayers; i++) {
			System.out.printf("Player %d: ", i + 1);
			for (int card : players.get(i)) {
				System.out.printf("%2s%s ", suits[card / 13], values[card % 13]);
			}
			System.out.println();
		}
		
		// 挑出最大比大小(前面理牌已經二順序大小排好，只要挑出第一張即可)
		int[] maxCards = new int[numPlayers];
		for (int i = 0; i < numPlayers; i++) {
			int maxCard = players.get(i).get(0);
			for (int card : players.get(i)) {
				if (card < maxCard) {
					maxCard = card;
//					System.out.println(card);					
				}
			}
			maxCards[i] = maxCard;
		}
		
		
		int winner = 0;
		int winningCard = maxCards[0];
		for (int i = 1; i < numPlayers; i++) {
			if (maxCards[i] < winningCard) {
				winner = i;
				winningCard = maxCards[i];
			}
		}
		System.out.printf("Winner is player %d with the card: %s%s", winner + 1, suits[winningCard / 13], values[winningCard % 13]);
	}

}
