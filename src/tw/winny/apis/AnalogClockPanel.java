package tw.winny.apis;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JPanel;

public class AnalogClockPanel extends JPanel implements Runnable {
	private int hour, minutes, centerX, centerY, clockR;
	private double second;
	private Calendar cal;
	private Thread clockThread;

	public AnalogClockPanel() {
//		setBackground(Color.LIGHT_GRAY);
		clockThread = new Thread(this);
		clockThread.start();

	}

	private void updateTime() {
		cal = Calendar.getInstance();
		hour = cal.get(Calendar.HOUR_OF_DAY);
		minutes = cal.get(Calendar.MINUTE);
		second = cal.get(Calendar.SECOND) + cal.get(Calendar.MILLISECOND) / 1000.0;
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;
		centerX = getWidth() / 2;
		centerY = getHeight() / 2;
		clockR = Math.min(centerX, centerY) - 10;
		g2d.setColor(Color.BLACK);
		g2d.drawOval(centerX - clockR, centerY - clockR, clockR * 2, clockR * 2);

		updateTime();
		drawTicks(g2d);

		drawHand(g2d, centerX, centerY, (hour % 12 + minutes / 60.0) * 30, clockR * 0.4, 6, Color.BLACK);
		drawHand(g2d, centerX, centerY, ((minutes + second) / 60.0) * 6, clockR * 0.6, 3, Color.BLACK);
		drawHand(g2d, centerX, centerY, (second / 60.0) * 360, clockR * 0.65, 1, Color.YELLOW);

	}

	private void drawHand(Graphics2D g2d, int x, int y, double angle, double length, int width, Color color) {
		double radian = Math.toRadians(angle - 90); // 原本為水平，為了要仿照實際的時鐘從12垂直開始
		int endX = x + (int) (length * Math.cos(radian));
		int endY = y + (int) (length * Math.sin(radian));
		g2d.setStroke(new BasicStroke(width));
		g2d.setColor(color);
		g2d.drawLine(x, y, endX, endY);
	}

	private void drawTicks(Graphics2D g2d) {
		int tickLength;
		int xA, yA, xB, yB;
		int radius = clockR - 10;

		for (int i = 1; i < 60; i++) {
			double angle = Math.toRadians(i * 6 - 90);
			if (i % 5 == 0) {
				tickLength = (int) (radius * 0.15); // 较长的小时刻度
				g2d.setStroke(new BasicStroke(2));
			} else {
				tickLength = (int) (radius * 0.08); // 较短的分钟刻度
				g2d.setStroke(new BasicStroke(1));
				
				

				xA = centerX + (int) ((radius - tickLength) * Math.cos(angle));
				yA = centerY + (int) ((radius - tickLength) * Math.sin(angle));
				xB = centerX + (int) (radius * Math.cos(angle));
				yB = centerY + (int) (radius * Math.sin(angle));

				g2d.drawLine(xA, yA, xB, yB);
			}
		}
	}

	@Override
	public void run() {
		while (true) {
			repaint();
			try {
				Thread.sleep(50);
			} catch (Exception e) {
				System.out.println(e);
			}
		}

	}
}
