package tw.teacher.io;

import java.io.IOException;
import java.io.InvalidClassException;
import java.io.ObjectStreamException;
import java.sql.SQLException;
import java.util.IllegalFormatException;

public class class39 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

// override的時候exception的範圍要比爸爸小
class class391 {
	void m1() throws Exception {
		
	}
}
class class392 extends class391 {
	void m1() throws IOException, SQLException, IllegalFormatException {
		
	}
}