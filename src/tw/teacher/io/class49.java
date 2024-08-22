package tw.teacher.io;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

import tw.teacher.apis.Student;

public class class49 {

	public static void main(String[] args) {
		Student s1 = new Student("Leo", 77, 85, 57);
		System.out.println(s1);
		System.out.println(s1.sum());
		System.out.println(s1.avg());
		s1.getBike().upSpeed();
		s1.getBike().upSpeed();
		s1.getBike().upSpeed();
		System.out.println(s1.getBike().getSpeed());
		
		// 物件序列化
		// 要先有串流
		try {
			FileOutputStream fout = new FileOutputStream("dir1/student.score");	// new有產生檔案
			ObjectOutputStream oout = new ObjectOutputStream(fout);
			
			oout.writeObject(s1); //成功會寫在外部檔案中 // 出現錯誤不能被序列化，回到student宣告可序列化
			
			oout.flush(); // 可以不用有自動關閉
			oout.close();
			
		} catch (Exception e) {
			System.out.println(e);
		}

	}

}
