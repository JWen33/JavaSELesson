package tw.winny.code;

import javax.swing.JFrame;

import tw.winny.apis.AnalogClockPanel;

public class MyAnalogClock extends JFrame {
	private AnalogClockPanel clockPanel;
	
	public MyAnalogClock() {
		
		clockPanel = new AnalogClockPanel();
		add(clockPanel);
		
		
		
		setSize(640, 480);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	

	public static void main(String[] args) {
		new MyAnalogClock();

	}

}
