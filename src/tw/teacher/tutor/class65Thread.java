package tw.teacher.tutor;

public class class65Thread {

	public static void main(String[] args) {
		Thread1 t1 = new Thread1();
		Thread2 t2 = new Thread2();
		t1.start(); // 進入等候區
		t2.start(); // 進入等候區
		
		try {
			t1.join(); // t1沒有結束main不會結束，阻塞執行緒，要先完成join的程序，同步的概念
		} catch (InterruptedException e) {
		} 
		
		
		System.out.println("Main Finish!");
	}

}

class Thread1 extends Thread {
	@Override
	public void run() {
		System.err.println("Thread1 start working...");
		try {
			Thread.sleep(3 * 1000); // 模擬執行程序
		} catch (InterruptedException e) {
		}
		System.out.println("Thread1 FINISH!");
	}
}

class Thread2 extends Thread {
	@Override
	public void run() {
		System.err.println("Thread2 start working...");
		try {
			Thread.sleep(5 * 1000);
		} catch (InterruptedException e) {
		}
		System.out.println("Thread2 FINISH!");
	}
}




