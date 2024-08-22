package tw.teacher.apis;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class GamePanel extends JPanel {
	private BufferedImage ballImg;
	private int ballX, ballY, ballW, ballH, viewW, viewH, dx, dy;
	private Timer timer;
	
	public GamePanel() {
		
		setBackground(Color.LIGHT_GRAY);
		try {
			ballImg =  ImageIO.read(new File("dir1/volleyball.png"));
			ballW = ballImg.getWidth();
			ballH = ballImg.getHeight();
		} catch (IOException e) {
			System.out.println(e);
		}
		
		addMouseListener(new MyListener());
		
		timer = new Timer(); // 一個專案通常就一個timer
		timer.schedule(new BallTask(), 1 *1000, 30); // 一秒之後開始，每隔0.03秒執行一次BallTask()
		
		ballX = ballY = 1;
		dx = dy = 4;
	}
	
	// 做遊戲時，會將所有圖片素材放在同一個file圖檔，一次讀進來之後，再利用程式去切割要的圖片
	// 影像顯示
	@Override
	protected void paintComponent(Graphics g) { // 使用者看到的版面，盡量在裡面處理版面就好，不要在這裡才抓圖片檔案，要在版面處理之前就完成讀圖片
		super.paintComponent(g);
		viewW = getWidth(); // 因為畫面中的東西都是在paintComponent，所以要在這裡取得寬高，不能放在建構式
		viewH = getHeight();
//		System.out.println(viewW + ":" + viewH); // 確認有取得寬高
		g.drawImage(ballImg, ballX, ballY, null); // 有的話就畫出匯入的檔案
	}
	
	// 內部類別讓球會動
	private class BallTask extends TimerTask {
		@Override
		public void run() {
			if (ballX <= 0 || ballX + ballW >= viewW) {
				dx *= -1; // 撞到牆要改變方向
			}
			if (ballY <= 0 || ballY + ballH >= viewH) {
				dy *= -1; // 撞到牆要改變方向
			}
			
			ballX += dx;
			ballY += dy;
			repaint(); // 頻率隨著變更，(球移動就叫你看球)*N，應該要是球動自己的，時間到才看球，就是FPS，螢幕更新頻率的概念
		}
	}
	
	
	private class MyListener extends MouseAdapter {
		@Override
		public void mouseClicked(MouseEvent e) {
			
			ballX = e.getX() - (int)(ballW/2.0); // 滑鼠點的位置變成ballX的參數
			ballY = e.getY() - (int)(ballH/2.0);
			repaint();
		}
	}
	
	
	
}


