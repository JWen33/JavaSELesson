package tw.teacher.io;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

import tw.teacher.apis.Student;

public class class50 {

	public static void main(String[] args) {
		try {
			FileInputStream fin = new FileInputStream("dir1/student.score");
			ObjectInputStream oin = new ObjectInputStream(fin);
			
			Object obj = oin.readObject();
			Student s1 = (Student)obj;		
			System.out.println(s1);
			System.out.println(s1.sum());
			System.out.println(s1.avg());
			
//			if (obj instanceof Student) {
//				System.out.println("Yes");
//			}
			
			oin.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
