package tw.teacher.io;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class class42 {

	public static void main(String[] args) {
		String mesg = "Hello, 早安\n";
		try {
			FileOutputStream fout = new FileOutputStream("dir1/file3.txt", true); // 採用append模式，true就append
			fout.write(mesg.getBytes());
			fout.flush();
			fout.close();
			System.out.println("OK");
			
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
