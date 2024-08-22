package tw.teacher.tutor;

public class class62Thread {

	public static void main(String[] args) { // main thread中再建立一個thread
		MyThread mt1 = new MyThread("A");
		MyThread mt2 = new MyThread("B");
		MyRunnable mr1 = new MyRunnable("C");
		Thread t1 = new Thread(mr1);
		// 啟動生命 => 開始等候，等CPU隨機挑選來叫你執行，所以每次的順序都不同，沒有再保證時間的精準度，只保證此程序全部執行完成
		mt1.start(); 
		mt2.start();
		
		t1.start();
		System.out.println("OK");
		
	}

}

//生命特徵只有一個，只能跑一次
class MyThread extends Thread {
	private String name;
	
	public MyThread(String name) {
		this.name = name;
	}
	
	@Override 
	public void run() {
		for (int i = 0; i < 20; i++) {
			System.out.printf("%s：%d\n", name, i); // 睡完0.1秒醒來後一樣要到等候區，等待FPC隨機呼叫，所以有時侯是A先有時候是B先
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// 目前純粹再睡覺所以不會發生例外
			}
		}
	}
	
}

class MyRunnable implements Runnable{ // 一個已設計好的類別若已經繼承了其他父類別，而無法再繼承 Thread 類別時，則可以「實作 Runnable 介面」間接達成執行緒的設計

	private String name;
	
	public MyRunnable(String name) {
		this.name = name;
	}
	
	@Override 
	public void run() {
		for (int i = 0; i < 20; i++) {
			System.out.printf("%s：%d\n", name, i); // 睡完0.1秒醒來後一樣要到等候區，等待FPC隨機呼叫，所以有時侯是A先有時候是B先
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// 目前純粹再睡覺所以不會發生例外
			}
		}
	}
	
}
	
