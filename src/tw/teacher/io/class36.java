package tw.teacher.io;

public class class36 {

	public static void main(String[] args) {
		Bird b1 = new Bird();
		try {
			b1.setLeg(9);			
		} catch (Exception e) {
			System.out.println("u srue?");
		}
	}

}

class Bird{
	private int leg; // 預設0
	
	void setLeg(int leg) throws Exception { // 事先告知會有例外，讓呼叫者處理
		if (leg >= 0 && leg <= 2) {
			this.leg = leg;			
		} else { // 如果超出範圍，把彈性交給呼叫者處理
			throw new Exception(); // 有告知可以不用處理，把彈性交給呼叫者處理
		}
	}
}
