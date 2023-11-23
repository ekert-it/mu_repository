package de.ekert.mavendemo.ki;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * corrected class for CountdownTimer.<br>
 * The original had an off-by-one-error and counted one second too much.
 * @author thomase
 *
 */
@SuppressWarnings("serial")
public class CountdownTimerCorrected extends JFrame {
    private int count = 60; // Countdown from 60 seconds
    private JLabel label;
    private Timer timer;
    private double run;
    
    public CountdownTimerCorrected() {
        label = new JLabel(String.valueOf(count), SwingConstants.CENTER);
        timer = new Timer(1000, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	System.out.println(System.currentTimeMillis() - run);
            	count--;
                label.setText(String.valueOf(count));
                if (count == 0) {
                    ((Timer) (e.getSource())).stop();
                    JOptionPane.showMessageDialog(null, "Time's up!");
                    // Perform any action after the countdown is over
                }
            }
        });
        initUI();
    }

    private void initUI() {
        setTitle("Countdown Timer");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        label.setFont(label.getFont().deriveFont(48f));
        add(label);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
        run = System.currentTimeMillis();
        timer.start();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new CountdownTimerCorrected();
            }
        });
    }
}
