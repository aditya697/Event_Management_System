import java.awt.*;
import javax.swing.*;

public class Loading extends JFrame implements Runnable {

    JProgressBar progressBar;
    JLabel EventManagement, please_wait,image;
    int s;
    Thread thread;

    public static void main(String[] args) {
        new Loading().setVisible(true);
    }

    public void setUploading() {
        setVisible(false);
        thread.start();
    }

    public void run() {
        try {
            for (int i = 0; i < 200; i++) {
                s = s + 1;
                int m = progressBar.getMaximum();
                int v = progressBar.getValue();
                if (v < m) {
                    progressBar.setValue(progressBar.getValue() + 1);
                } else {
                    i = 201;
                    setVisible(false);
                    new DashBoard().setVisible(true);
                }
                Thread.sleep(60);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Loading() {

        super("Loading");
        thread = new Thread(this);

        setBounds(100, 100, 890, 550);
        setLayout(null);

        image = new JLabel(new ImageIcon("icons/Loading.png"));
        image.setBounds(0,0,1366,350);
        setContentPane(image);

        EventManagement = new JLabel("Event Management System");
        EventManagement.setForeground(new Color(72, 209, 204));
        EventManagement.setFont(new Font("Comic Sans MS", Font.BOLD, 35));
        EventManagement.setBounds(100, 6, 1000, 50);
        add(EventManagement);

        progressBar = new JProgressBar();
        progressBar.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
        progressBar.setStringPainted(true);
        progressBar.setBounds(270, 235, 300, 25);
        add(progressBar);

        please_wait = new JLabel("Please Wait....");
        please_wait.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
        please_wait.setForeground(new Color(160, 82, 45));
        please_wait.setBounds(270, 190, 150, 20);
        add(please_wait);

        setUploading();
    }
}
