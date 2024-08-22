package tw.teacher.tutor;

import java.util.concurrent.CountDownLatch;

public class class64Thread {
	
	
	public static void main(String[] args) {
		Store store = new Store();
		Producer p = new Producer(store);
		Consumer c1 = new Consumer(store, "Mark");
		Consumer c2 = new Consumer(store, "Leo");
		Consumer c3 = new Consumer(store, "Alice");
		p.start();
		c1.start();
		c2.start();
		c3.start();

	}

}

class Store {
	private int qty; // 庫存
	private int max; // 貨架可放最大
	
	Store() { // 初始化
		max = 10;
	}
	
	// 鎖定 等候 通知
	synchronized void add(int add) throws InterruptedException { // synchronized鎖定，一次一個人進貨
		System.out.printf("準備要進貨：%d\n", add);
		while (qty + add > max) {
			wait();
		}
		qty += add;
		System.out.printf("完成進貨：%d, 目前庫存量： %d\n", add, qty);
		notify(); // 此時就可以換下一個進貨
		
	}
	
	synchronized void buy(int buy, String name) throws InterruptedException {
		System.out.printf("%s想買：%d\n", name, buy);
		while (qty < buy) {
			wait();
		}
		qty -= buy;
		System.out.printf("完成賣出：%d(%s), 目前庫存量： %d\n", buy, name, qty);
		notify(); // 沒有保證先後順序，依CPU自己決定
	}
	
}

class Producer extends Thread {
	private Store store;
	public Producer(Store store) {
		this.store = store;
	}
	
	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			try {
				store.add(5);
				Thread.sleep(200);
			} catch (InterruptedException e) {
				System.out.println(e);
			}
		}
	}
	
}

class Consumer extends Thread {
	public Store store;
	private String name;
	public Consumer(Store store, String name) {
		this.store = store;
		this.name = name;
	}
	
	@Override
	public void run() {
		try {
			store.buy((int)(Math.random() * 3) + 1, name);
		} catch (InterruptedException e) {
			System.out.println(e);
		}
	}
}









