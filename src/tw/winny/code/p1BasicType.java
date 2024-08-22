package tw.winny.code;

import java.util.Random;

public class p1BasicType {
	/*
	 * 假設有一個氣象站每天會記錄一天中的天氣狀況，天氣狀況包括：晴天、陰天、雨天和雪天。請你模擬一個月（30天）的天氣狀況，並統計每種天氣出現的次數。
	 * 
	 * 要求： 使用 for 迴圈模擬30天的天氣記錄。 使用陣列來存儲每種天氣的出現次數。 打印每種天氣出現的次數。
	 */
	public static void main(String[] args) {
		int[] weatherCounts = new int[4];
		System.out.println(weatherCounts[0]);
		String[] weathertypes = { "晴天", "陰天", "雨天", "下雪" };

		for (int i = 0; i < 30; i++) {
			int weather = (int) (Math.random() * 4);
			weatherCounts[weather]++;
		}

		for (int i = 0; i < weatherCounts.length; i++) {
			System.out.printf("%s出現%d次\n", weathertypes[i], weatherCounts[i]);
		}
		
		
		
		/*
		 * 假設有一個班級的學生成績記錄，成績範圍是0到100。請你模擬30個學生的成績，並統計不同分數段（0-59, 60-69, 70-79, 80-89, 90-100）的學生人數。
		 * 
		 * 要求： 使用 for 迴圈生成30個隨機成績。 使用陣列來存儲每個分數段的人數。 打印每個分數段的學生人數。
		 */
		int[] grade = new int[5];
		String[] gradeInterval = { "0-59", "60-69", "70-79", "80-89", "90-100" };
		Random rand = new Random();
		
		for(int i = 0; i < 30; i++) {
			int scroe = rand.nextInt(101);
;			if (scroe < 60) {
				grade[0]++;
			} else if (scroe < 60) {
				grade[0]++;
			} else if (scroe < 70) {
				grade[1]++;
			} else if (scroe < 80) {
				grade[2]++;
			} else if (scroe < 90) {
				grade[3]++;
			} else {
				grade[4]++;
			}		
			
		}
		for (int i = 0; i < grade.length; i++) {
			System.out.printf("成績%s分有%d人\n", gradeInterval[i], grade[i]);
		}
	}
	

}
