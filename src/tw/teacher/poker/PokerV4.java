package tw.teacher.poker;

import java.util.ArrayList;
import java.util.Collections;

public class PokerV4 {

	public static void main(String[] args) {
		ArrayList<Integer> poker = new ArrayList<Integer>();
		for (int i = 0; i < 10; i++)
			poker.add(i);
		Collections.shuffle(poker);

		for (Integer card : poker) {
			System.out.println(card);
		}

	}

	
}
