package tw.winny.code;

import javax.swing.*;
import java.awt.*;

public class test extends JFrame {
    public test() {
        setTitle("Button and JPanel in JFrame");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JButton button = new JButton("Click Me");
        add(button, BorderLayout.NORTH);

        JPanel panel = new CustomPanel();
        add(panel, BorderLayout.CENTER);

        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new test());
    }
}

class CustomPanel extends JPanel {
    public CustomPanel() {
        // Customize panel as needed
    }
}