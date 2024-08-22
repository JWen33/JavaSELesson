package tw.winny.code;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

public class TimerApp extends JFrame {
    private TimerPanel mypanel;
    
    public TimerApp() {
        setTitle("Timer APP");
        mypanel = new TimerPanel();
        setLayout(new BorderLayout());
        add(mypanel, BorderLayout.CENTER);
        
        setSize(640, 480);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }   
    
    private class TimerPanel extends JPanel {
        private JLabel timeLabel;
        private JButton start;
        private JButton stop;
        private Timer timer;
        private int seconds = 0;
        
        public TimerPanel() {
            setLayout(new GridBagLayout()); // 使用 GridBagLayout
            
            GridBagConstraints gbc = new GridBagConstraints();
            gbc.insets = new Insets(10, 10, 10, 10); // 添加邊距
            
            // 設置 timeLabel 到正中央
            timeLabel = new JLabel("00:00");
            timeLabel.setHorizontalAlignment(JLabel.CENTER);
            gbc.gridx = 0;
            gbc.gridy = 0;
            gbc.gridwidth = 2; // 佔據兩列
            gbc.weightx = 1.0; // 水平方向上擴展
            gbc.fill = GridBagConstraints.HORIZONTAL; // 填滿水平方向
            
            add(timeLabel, gbc);
            
            // 設置 start 按鈕
            start = new JButton("Start");
            gbc.gridy = 1;
            gbc.gridwidth = 1; // 只佔據一列
            gbc.weightx = 0; // 不擴展
            gbc.fill = GridBagConstraints.NONE; // 不填滿
            
            add(start, gbc);
            
            // 設置 stop 按鈕
            stop = new JButton("Stop");
            gbc.gridx = 1; // 第二列
            add(stop, gbc);
            
            start.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    startTime();
                }
            });
            
            stop.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    stopTime();
                }
            });
        }
        
        private void startTime() {
            if (timer != null && timer.isRunning()) {
                return; // 如果計時器正在運行，不啟動新的計時器
            }
            seconds = 0; // 重置秒數
            timer = new Timer(1000, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    seconds++;
                    updateTimeLabel();
                }
            });
            timer.start(); // 開始計時器
        }

        private void stopTime() {
            if (timer != null) {
                timer.stop(); // 停止計時器
            }
        }
        
        private void updateTimeLabel() {
            int minutes = seconds / 60;
            int secs = seconds % 60;
            timeLabel.setText(String.format("%02d:%02d", minutes, secs)); // 更新顯示時間
        }
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new TimerApp();
            }
        });
    }
}
