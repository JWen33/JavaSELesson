package tw.teacher.tutor;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class GuessNumber extends JFrame implements ActionListener { //implements ActionListener 對外宣告(有考證照可以使用)，我有時做哪些介面，僅宣告尚未有實作
	private JTextField input;
	private JButton guess;
	private JTextArea log;
	private String answer;
	private int counter;

	public GuessNumber() { // 處裡版面
		super("猜數字遊戲");
		
		input = new JTextField();
		guess = new JButton("猜");
		log = new JTextArea();
		
		input.setFont(new Font(null, Font.BOLD, 36));
		
		setLayout(new BorderLayout()); // 配置好後就不需要所以使用區域變數
		
		JPanel top = new JPanel(new BorderLayout()); // 配置上方的輸入籃框與按鈕，隔間後就不需要所以使用區域變數
		top.add(guess, BorderLayout.EAST);
		top.add(input, BorderLayout.CENTER); // 剩下給input
		
		add(top, BorderLayout.NORTH);
		add(log, BorderLayout.CENTER);
		
		setSize(640,480);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		init(); //初始動作
		initEvent();
	}
	
	private void init() {
		answer = createAnswer(3);
		counter = 0;
		log.setText("");
//		System.out.println(answer);
	}
	
	private void initEvent() { // 內部使用的方法
		guess.addActionListener(this);
	}
	
	private String createAnswer(int d) {
		final int nums = 10;
		int[] poker = new int[nums];

		for (int i = 0; i < poker.length; i++) {
			poker[i] = i;
		}

		for (int i = nums - 1; i > 0; i--) {
			int rand = (int) (Math.random() * (i + 1));
			// poker[rand] <=> poker[i]
			int temp = poker[rand];
			poker[rand] = poker[i]; 
			poker[i] = temp;
		}
		
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < d; i++) {
			sb.append(poker[i]);
		}
		
		return sb.toString();
	}
	
	public static void main(String[] args) {
		new GuessNumber();
	}

	@Override
	public void actionPerformed(ActionEvent e) { // 真正的按下按鈕的監聽實作
		String g =input.getText();
		if (!g.matches("\\d{3}")) {
			JOptionPane.showMessageDialog(null, "請輸入三位數字");
			input.setText("");
		}
		
		counter++;
		
		String result = checkAB(g, answer);
		log.append(String.format("%d. %s=> %s\n", counter, g, result));
		
		input.setText("");
		
		if (result.equals("3A0B")) {
			JOptionPane.showMessageDialog(null, "Win!");
			init();
		} else if (counter == 10) {
			JOptionPane.showMessageDialog(null, "Lose!" + answer);
			init();
		}
		
	}
	
	private static String checkAB(String g, String a) { 
		int A = 0, B = 0;
		
		for (int i = 0; i < a.length(); i++) {
			if (g.charAt(i) == a.charAt(i)){
				A++;
			} else if (a.indexOf(g.charAt(i)) != -1) {
				B++;
			}
		}
		return String.format("%dA%dB", A, B);
	}

	
	// 擴充檢驗輸入的是數字且字數也對OK
	// 開新局OK
	// 輸入錯誤不要加入log!!
}



