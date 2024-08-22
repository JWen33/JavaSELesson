package tw.teacher.io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class class51 {

	public static void main(String[] args) {
		class513 obj = new class513();
		
		try {
			ObjectOutputStream oout = new ObjectOutputStream(new FileOutputStream("dir1/test.ok"));
			
			oout.writeObject(obj);
			oout.flush();
			oout.close();
			System.out.println("OK");
			System.out.println("-----");
			
			//解序列化，序列化是針對屬性，如果父元素已經可解序列，子類別都不需要，但如我只有子類別可序列化，父元素則會初始化
			// 類別之外，元素(屬性)也可要可序列化
			ObjectInputStream oin = new ObjectInputStream(new FileInputStream("dir1/test.ok"));
			oin.readObject();
			oin.close();
			System.out.println("OK2");
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
	}

}

class class511 implements Serializable {
	class511 () {System.out.println("class511()");}
}
class class512 extends class511 {
	class512 () {System.out.println("class512()");}
}
class class513 extends class512 {
	class513 () {System.out.println("class513()");}
}

