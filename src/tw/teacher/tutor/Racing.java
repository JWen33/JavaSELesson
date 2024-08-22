package tw.teacher.tutor;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Racing extends JFrame {
	private JButton go;
	private JLabel[] lanes;
	private Car[] cars;
	private int rank;

	
	public Racing() {
		super("Racing");
		
		setLayout(new GridLayout(9, 1));
		go = new JButton("GO!"); add(go);
		lanes = new JLabel[8];
		for (int i = 0; i < lanes.length; i++) {
			lanes[i] = new JLabel(String.format("%d. ", (i + 1)));
			add(lanes[i]);
		}
		
		setSize(1024, 480);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		initGame();
	}
	
	private void initGame() {
		go.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				go();
			}
		});
	}
	
	private void go() {
		rank = 0; // 開始之後歸0
		for (int i = 0; i < lanes.length; i++) {
			lanes[i].setText(String.format("%d. ", (i + 1)));
		}
		cars = new Car[8];
		for (int i = 0; i < cars.length; i++) {
			cars[i] = new Car(i);
		}
		for (int i = 0; i < cars.length; i++) {
			cars[i].start();
		}
	}
	

	private class Car extends Thread { // 寫成內部類別
		private int lane; 
		private StringBuffer path;
		Car (int lane) { // 建構式決定要跑在哪個跑道，不能亂跑
			this.lane = lane;
			path = new StringBuffer(String.format("%d. ", (lane + 1)));
			
		}
		@Override
		public void run() {
			for (int i = 0; i < 100; i++) {
				path.append(">");
				if (i == 99) { 
//					path.append(++rank); // 先rank++再印出
					path.append("Winner!!");
				}
				lanes[lane].setText(path.toString()); // StringBuffer的關係要使用toString
				if (i == 99) {
					// 第一名出現大家不要在跑 => 中斷執行緒
					stopGame();
				}
				try {
					Thread.sleep(10 + (int)Math.random() * 100);
				} catch (InterruptedException e) { // 然後就會執行裡面的code
					break;
				}
			}
		}
	}
	
	void stopGame() {
		for (int i = 0; i < cars.length; i++) {
			cars[i].interrupt(); // 執行之後，Interrupted的例外會被拋出，就往上去找InterruptedException e
		}
	}
	
	
	public static void main(String[] args) {
		new Racing();

	}

}



