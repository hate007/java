import javax.swing.*;
import java.awt.*;
public class s4q1 implements Runnable {
    private JLabel label;
    private boolean visible = true;

    public void run() {
        JFrame frame = new JFrame("Blinking Text");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(400,200));
        label = new JLabel("Blinking Text", SwingConstants.CENTER);
        frame.add(label, BorderLayout.CENTER);
        frame.pack();
        frame.setVisible(true);

        Thread blinkThread = new Thread(new Runnable() {
            public void run() {
                try {
                    while (true) {
                        visible = !visible;
                        label.setVisible(visible);
                        Thread.sleep(500);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        blinkThread.start();
    }

    public static void main(String[] args) {
        Thread blink = new Thread(new s4q1());
        blink.start();
    }
}
