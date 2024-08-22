package tw.winny.code;

import java.util.Random;

public class p2ForArray {

	public static void main(String[] args) {
		/*
		 * 假設你每天都會使用幾個常用的手機應用，並且每次使用的時間是隨機的。請你模擬30天內的應用使用情況，並統計每個應用的總使用時間。
		 * 
		 * 要求： 使用多維陣列表示每個應用每天的使用時間。 使用 java.util.Random 隨機生成每個應用的每日使用時間（範圍為0到120分鐘）。
		 * 統計並打印每個應用的總使用時間。
		 */
		
		
		
		int[][] appUsage = new int[3][30];
		int[] totalUsage = new int[3];
		Random rand = new Random();
		int days = 30;
		
		for (int day = 0; day < days; day++) {
			for (int i = 0; i < 3; i++) {
				int randTime = rand.nextInt(121);
				appUsage[i][day] = randTime;
				totalUsage[i] = totalUsage[i] + randTime;
			}
		}
		
		for (int app = 0; app < 3; app++) {
			System.out.printf("第%d個app使用了%d小時%d分鐘\n", app + 1, totalUsage[app] / 60, totalUsage[app] % 60);
		}
			

	}

}
