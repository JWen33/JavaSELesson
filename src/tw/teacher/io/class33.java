
package tw.teacher.io;

import java.io.File;

public class class33 {

	public static void main(String[] args) {
		File f1 = new File("d:/dir2");  //java跨所以可以將原本路徑\改成/
		File f2 = new File("./test1");
		
		if (f2.exists()) {
			System.out.println("OK");
		} else {
			System.out.println("XX");
			f2.mkdir(); // 物件被做出來代表示存在的物件實體，所以自己創一個新的資料夾
		}
		
		File nowDir = new File("."); // .表示所在資料夾
		System.out.println(nowDir.getAbsolutePath());
		
		
	}
	

}
