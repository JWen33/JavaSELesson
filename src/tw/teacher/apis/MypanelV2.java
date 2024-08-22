package tw.teacher.apis;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.LinkedList;

import javax.imageio.ImageIO;
import javax.swing.DebugGraphics;
import javax.swing.JPanel;

public class MypanelV2 extends JPanel {
	private LinkedList<Line> lines, recycle; // 將線放進list才會有很多條線
	private Color nowColor;
	private float lineWidth;

	public MypanelV2() {
		setBackground(Color.LIGHT_GRAY);

		lines = new LinkedList<>();
		recycle = new LinkedList<>();
		nowColor = Color.BLACK;
		lineWidth = 4f;
		// 如果會一直用到，直接建立在建構式中，讓建立出的物件實體都能有這個功能
		MyListener myListener = new MyListener();

		addMouseListener(myListener);
		addMouseMotionListener(myListener);
	}

	// inner calss 直接存取外部類別的屬性與方法
	private class MyListener extends MouseAdapter {
		@Override
		public void mousePressed(MouseEvent e) {
			recycle.clear(); // 將垃圾桶清光才不會有redo了好久以前去除的線
			Line line = new Line(nowColor, lineWidth);
			Point point = new Point(e.getX(), e.getY()); // 產生新起始點
			line.addPoint(point);
			lines.add(line); // 加入新的線

		}

		@Override
		public void mouseDragged(MouseEvent e) {
			Point point = new Point(e.getX(), e.getY());
			lines.getLast().addPoint(point);
			repaint();
		}
	}

	@Override
	protected void paintComponent(Graphics g) { // 只是改寫非呼叫，當要顯示是內容時(需要時)會自動被呼叫，Graphics 抽象類別，但已經傳遞物件實體g了
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g; // 有用到才會需要轉型， 像是要下面要設定粗細的時候就要打開
		for (Line line : lines) {

			g2d.setColor(line.getColor());
			g2d.setStroke(new BasicStroke(line.getWidth()));

			for (int i = 1; i < line.size(); i++) {
				Point p0 = line.getPoint(i - 1);
				Point p1 = line.getPoint(i);
				g2d.drawLine(p0.getX(), p0.getY(), p1.getX(), p1.getY());
			}
		}

	}

	public void clear() {
		lines.clear(); // 清除後台的線
		repaint(); // 真正去除畫板上的線讓使用者看到
	}

	public void undo() {
		if (lines.size() > 0) {
			recycle.add(lines.removeLast() /* 清除線 */ );
			repaint();
		}
	}

	public void redo() {
		if (recycle.size() > 0) {
			lines.add(recycle.removeLast()); // 清除線
			repaint();
		}

	}

	public Color getColor() {
		return nowColor;
	}

	public void setColor(Color color) {
		nowColor = color;
	}

	public float getLineWidth() {
		return lineWidth;
	}

	public void setLineWidth(float width) {
		lineWidth = width;
	}
	
	public void saveLines(File saveFile) throws Exception { // 例外不在這個類別方法處理，讓外部去處理
		ObjectOutputStream oout = new ObjectOutputStream(new FileOutputStream(saveFile));
		
		oout.writeObject(lines);
		oout.flush();
		oout.close();
	}

	public void loadLines(File loadFile) throws Exception { // 自動關閉語法，不是try catch，所以還是要將例外拋出去
		try (ObjectInputStream oin = new ObjectInputStream(new FileInputStream(loadFile))){
			Object obj = oin.readObject();
			lines = (LinkedList<Line>)obj;
			repaint();
		}
	}
	
	public void saveJEPG() throws Exception { // bufferimage 去取得 graphic 後將想畫的畫在 graphic上面，在利用bufferimage去存取
		BufferedImage img = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_BGR); // Jpanel元件自己會知道寬高
		Graphics g = img.getGraphics();
		paint(g);
		
		ImageIO.write(img, "jpg", new File("dir1/newJpg.jpg"));
	}
}



