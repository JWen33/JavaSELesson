package tw.teacher.poker;

public class PokerV2 {

	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		
		// 洗牌
		int[] poker = new int[52];
		boolean isRepeat;
		int temp;
		
		for (int i = 0; i < poker.length; i++) {
			
			do {
				temp = (int)(Math.random() * 52);
				
				//檢查機制
				isRepeat = false;
				for (int j = 0; j < i; j++) {
					if (temp == poker[j]) {
						isRepeat = true;
						break;
					}
				}
			}
			while (isRepeat);
			
			poker[i] = temp;
			System.out.println(poker[i]);

		}
		System.out.println("------");
		System.out.println(System.currentTimeMillis() - start);
		
		
		// 發牌
		
		// 攤牌 + 理牌

	}

}
