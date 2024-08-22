package tw.teacher.tutor;

import org.mindrot.BCrypt;

public class class66BCrypt {

	public static void main(String[] args) {
		String password = "123456";
		String newpassword = BCrypt.hashpw(password, BCrypt.gensalt());
		System.out.println(newpassword);
		int len = newpassword.length();
		System.out.println(len);
		if (BCrypt.checkpw("123456", newpassword)) {
			System.out.println("OK");
		} else {
			System.out.println("xx");
		}
	}

}
