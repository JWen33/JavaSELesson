package tw.winny.apis;

public class Student {
	private String name;
	private int ch, eng, math, sci;
	
	public Student(String name, int ch, int eng, int math, int sci) {
		this.name = name;
		this.ch = ch;
		this.eng = eng;
		this.math = math;
		this.sci = sci;
	}
	
	public String getName() {
		return name;
	}
	
	public int getChinese() {
		return ch;
	}
	
	public int getEnglish() {
		return eng;
	}
	
	public int getMath() {
		return math;
	}
	
	public int getScience() {
		return sci;
	}
	
	public int getGrsdeSum() {
		return ch + eng + math + sci;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return name + "同學：國文成績" + ch + "、英文成績" + eng + "、數學成績" + math + "、自然成績" + sci;
	}
	
}
