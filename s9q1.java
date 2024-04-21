import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class s9q1 {
    static int PANEL_WIDTH = 400;
    static int PANEL_HEIGHT = 400;
    static int BALL_SIZE = 50;

    static class MovingBallPanel extends JPanel {
        int y = 0;

        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.setColor(Color.RED);
            g.fillOval(PANEL_WIDTH / 2 - BALL_SIZE / 2, y, BALL_SIZE, BALL_SIZE);
        }

        public void moveBall() {
            y += 5; 
            if (y > PANEL_HEIGHT) {
                y = 0;
            }
            repaint();
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Moving Ball");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(PANEL_WIDTH, PANEL_HEIGHT);

        MovingBallPanel panel = new MovingBallPanel();

        JButton startButton = new JButton("Start");
        startButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Timer timer = new Timer(10, new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        panel.moveBall();
                    }
                });
                timer.start();
            }
        });

        frame.add(panel, BorderLayout.CENTER);
        frame.add(startButton, BorderLayout.SOUTH);
        frame.setVisible(true);
    }
}