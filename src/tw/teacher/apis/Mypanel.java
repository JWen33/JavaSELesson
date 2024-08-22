package tw.teacher.apis;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.LinkedList;

import javax.swing.DebugGraphics;
import javax.swing.JPanel;

public class Mypanel extends JPanel {
	private LinkedList<LinkedList<Point>> lines; // 將線放進list才會有很多條線

	public Mypanel() {
		setBackground(Color.LIGHT_GRAY);

		lines = new LinkedList<>();

		// 如果會一直用到，直接建立在建構式中，讓建立出的物件實體都能有這個功能
		MyListener myListener = new MyListener();

		addMouseListener(myListener);
		addMouseMotionListener(myListener);
	}

	// inner calss 直接存取外部類別的屬性與方法
	private class MyListener extends MouseAdapter {
		@Override
		public void mousePressed(MouseEvent e) {
			LinkedList<Point> line = new LinkedList<>(); // 產生一條新的線

			Point point = new Point(e.getX(), e.getY()); // 產生新起始點
			line.add(point);

			lines.add(line); // 加入新的線

		}

		@Override
		public void mouseDragged(MouseEvent e) {
			Point point = new Point(e.getX(), e.getY());
			lines.getLast().add(point);

			repaint();
		}
	}

	@Override
	protected void paintComponent(Graphics g) { // 只是改寫非呼叫，當要顯示是內容時(需要時)會自動被呼叫，Graphics 抽象類別，但已經傳遞物件實體g了
		super.paintComponent(g);

		Graphics2D g2d = (Graphics2D) g; // 有用到才會需要轉型， 像是要下面要設定粗細的時候就要打開

		g2d.setColor(Color.YELLOW);
		g2d.setStroke(new BasicStroke(4));

		for (LinkedList<Point> line : lines) {

			for (int i = 1; i < line.size(); i++) {
				Point p0 = line.get(i - 1);
				Point p1 = line.get(i);
				g2d.drawLine(p0.getX(), p0.getY(), p1.getX(), p1.getY());
			}
		}

//		if (g instanceof DebugGraphics) {
//			System.out.println("1");
//		} else if (g instanceof Graphics2D) { // 骨子裡是2D物件實體
//			System.out.println("2");
//		} else {
//			System.out.println("3");
//		}
//		
//		System.out.println("OK"); //驗證畫面顯示的迴船
	}

}
