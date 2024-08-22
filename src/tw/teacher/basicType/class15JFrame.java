package tw.teacher.basicType;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class class15JFrame extends JFrame{
	private JButton b1, b2, b3;
	
	public class15JFrame() { // 視窗開發原則通常是將式窗內元素設置好才顯示
		b1 = new JButton("B1");
		b2 = new JButton("B2");
		b3 = new JButton("B3");
		
		setLayout(new FlowLayout());
		add(b1); add(b2); add(b3);
		
		
		setSize(640, 480);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		new class15JFrame(); // 

	}
}

