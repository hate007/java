import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class s17q2 implements Runnable {
    volatile boolean running = false;
    JTextField textField;
    JButton startButton;

    public s17q2(JTextField textField, JButton startButton) {
        this.textField = textField;
        this.startButton = startButton;

        startButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (!running) {
                    running = true;
                    startButton.setText("Stop");
                    new Thread(s17q2.this).start();
                } else {
                    running = false;
                    startButton.setText("Start");
                }
            }
        });
    }

    public void run() {
        for (int i = 1; i <= 100 && running; i++) {
            final int currentValue = i;
            try {
                SwingUtilities.invokeAndWait(new Runnable() {
                    public void run() {
                        textField.setText(String.valueOf(currentValue));
                    }
                });
                Thread.sleep(500);
            } catch (InterruptedException ie) {
                ie.printStackTrace();
            } catch (Exception e) { 
                e.printStackTrace(); 
            }
        }
        running = false;
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Number Display");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 150);

        JTextField textField = new JTextField();
        textField.setEditable(false);
        frame.add(textField, BorderLayout.CENTER);

        JButton startButton = new JButton("Start");
        frame.add(startButton, BorderLayout.SOUTH);

        new s17q2(textField, startButton);

        frame.setVisible(true);
    }
}
