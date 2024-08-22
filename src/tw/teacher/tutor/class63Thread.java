package tw.teacher.tutor;

import java.util.Timer;
import java.util.TimerTask;

public class class63Thread {

	public static void main(String[] args) {
		Timer timer = new Timer(); // 加進true背景自動死掉，前景
		timer.schedule(new MyTask(), 0, 1 * 1000); // 要取消任務才會結束
		timer.schedule(new StopTask(timer), 10 * 1000);
		System.out.println("Main");
		

	}

}

class MyTask extends TimerTask {
	private int i;
	@Override
	public void run() { // 時間到要做
		System.out.println(i++);
		
	}
}

class StopTask extends TimerTask {
	private Timer timer;
	public StopTask(Timer timer) {
		this.timer = timer;
	}
	@Override
	public void run() {
		timer.purge();
		timer.cancel();
		timer = null; 
	}
}

