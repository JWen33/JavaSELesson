package tw.teacher.tutor;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Iterator;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import tw.teacher.apis.MyClock;
import tw.teacher.apis.Mypanel;
import tw.teacher.apis.MypanelV2;

public class MySign extends JFrame implements ActionListener, ChangeListener {
	private MypanelV2 mypanel; // 另外好好創作panel物件
	private JButton clear, undo, redo, color, saveObj, loadObj, saveJEPG;
	private JSlider lineWidth;
	private MyClock myclock;

	public MySign() {
		super("Sigh App");

		mypanel = new MypanelV2();
		setLayout(new BorderLayout());
		add(mypanel, BorderLayout.CENTER);

		clear = new JButton("Clear");
		undo = new JButton("Undo");
		redo = new JButton("Redo");
		color = new JButton("color");
		lineWidth = new JSlider(1, 20, 4);
		saveObj = new JButton("Save Object");
		loadObj = new JButton("Load Object");
		saveJEPG = new JButton("Save Object");
		myclock = new MyClock();
		
		JPanel top = new JPanel(new FlowLayout());
		top.add(clear);
		top.add(undo);
		top.add(redo);
		top.add(color);
		top.add(lineWidth);
		top.add(saveObj);
		top.add(loadObj);
		top.add(myclock);
		add(top, BorderLayout.NORTH);

		setSize(640, 480);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		initEvent();
	}

	// 針對元件處理事件(按下按鈕要做的事)
	private void initEvent() {
		clear.addActionListener(new ActionListener() {
			// 普通類別也可以用這種方式實作，每個按鈕各自做什麼事情
			@Override
			public void actionPerformed(ActionEvent e) {
				mypanel.clear();
			}
		});
		undo.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				mypanel.undo();
			}
		});
		redo.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				mypanel.redo();
			}
		});
		color.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				changeColor();
			}
		});
		lineWidth.addChangeListener(new ChangeListener() {
			
			@Override
			public void stateChanged(ChangeEvent e) {
				if (e.getSource() == lineWidth) {
					changeLineWidth();
				}
			}
		});
		saveObj.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				saveObject();
			}
		});
		loadObj.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				loadObject();
			}
		});
		saveJEPG.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					mypanel.saveJEPG();
					System.out.println("Save Success");
				} catch (Exception e1) {
					System.out.println(e1);
				}
				
			}
		});
		

	}

	private void changeColor() {
		Color newColor = JColorChooser.showDialog(null, "Choose Color", mypanel.getColor());
		if (newColor != null) {
			mypanel.setColor(newColor);
		}
	}
	
	private void changeLineWidth() {
		float width = lineWidth.getValue();
			mypanel.setLineWidth(width);
	}

	private void saveObject() {
		JFileChooser jfc = new JFileChooser();
		if (jfc.showSaveDialog(this) == JFileChooser.APPROVE_OPTION) {
			File file = jfc.getSelectedFile();
			try {
				mypanel.saveLines(file);
				JOptionPane.showMessageDialog(null, "Save Success");
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Save Failure");;
			}
		}
	}

	private void loadObject() {
		JFileChooser jfc = new JFileChooser();
		if (jfc.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
			
			File file = jfc.getSelectedFile();
			try {
				mypanel.loadLines(file);
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Load Failure");
			}
			
		}
	}

	public static void main(String[] args) {
		new MySign();
	}

	@Override
	public void stateChanged(ChangeEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}	

}

// 將滑桿放進去調整字體大小
