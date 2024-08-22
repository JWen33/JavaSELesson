package tw.teacher.tutor;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JFrame;

public class class24Mouse extends JFrame{
	
	public class24Mouse() {
		
//		MyMouseListener mouseListener = new MyMouseListener();
//		addMouseListener(mouseListener); // 如果使用this要寫在定義的建構是裡面
//		addMouseMotionListener(mouseListener); 
		
		MyMouseListenerV2 mouseListener = new MyMouseListenerV2();
		addMouseListener(mouseListener); // 如果使用this要寫在定義的建構是裡面
		addMouseMotionListener(mouseListener); 
		
		setSize(640, 480);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}

	public static void main(String[] args) {
		new class24Mouse();
	}

}
class MyMouseListenerV2 extends MouseAdapter { // MouseAdapter為抽象的方法，挑選想要實作的功能出來就好
	@Override
	public void mousePressed(MouseEvent e) {
		System.out.println("Press");	
	}
	@Override
	public void mouseDragged(MouseEvent e) {
		System.out.println(String.format("%d x %d", e.getX(), e.getY()));
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		System.out.println("Release");	
	}
}

class MyMouseListener implements MouseListener, MouseMotionListener { // 少一個都不行，自定義一個類別

	@Override
	public void mouseClicked(MouseEvent e) {
		System.out.println("Click");
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		System.out.println("Press");	
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		System.out.println("Release");	
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		System.out.println("Drag");
		
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}