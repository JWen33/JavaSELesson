package tw.winny.code;

import java.util.HashMap;
import tw.winny.apis.Student;

public class GradeSystem {
	private HashMap<String, Student> students; // String是指以學生姓名作為key，然後student是指自訂一類別的student，該物件包含所有學生資訊

	public GradeSystem() {
		students = new HashMap<String, Student>();
	}

	public void addStudent(Student student) {
		students.put(student.getName(), student); // key是透過方法獲取的學生名稱，value則是student這個物件
	}

	public Student getStudentGrade(String name) { //
		return students.get(name);
	}

	public void printAllGrades() {
		for (Student student : students.values()) {
			System.out.println(student);
			System.out.println();
		}
	}

	// 主執行程式
	public static void main(String[] args) {
		GradeSystem myGradeSystem = new GradeSystem();

		Student student1 = new Student("Alice", 90, 85, 88, 92);
		Student student2 = new Student("Bob", 78, 82, 85, 80);
		Student student3 = new Student("Charlie", 92, 90, 91, 93);

		myGradeSystem.addStudent(student1);
		myGradeSystem.addStudent(student2);
		myGradeSystem.addStudent(student3);

		String name = "Alice";
		Student foundStudent = myGradeSystem.getStudentGrade(name);
		// 打印出找到的學生資訊
		if (foundStudent != null) {
			System.out.println("找到學生的成績資訊：");
			System.out.println(foundStudent);
		} else {
			System.out.println("找不到該名為 " + name + " 的學生");
		}

//	        myGradeSystem.printAllGrades();
	}

}
