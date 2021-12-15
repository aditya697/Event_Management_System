import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class EventManagementSystem extends JFrame implements ActionListener{

    JLabel heading;
    JLabel image;
    JButton next;

    public EventManagementSystem() {
        setTitle("Event Management System");
        setBounds(100,100,890,550);
        setLayout(null);

        image = new JLabel(new ImageIcon("icons/Event_Management.png"));
        image.setBounds(0,0,1366,350);
        setContentPane(image);

        next = new JButton("Next");
        next.addActionListener(this);
        next.setBackground(Color.DARK_GRAY);
        next.setForeground(Color.BLACK);
        next.setFont(new Font("Comic Sans MS",Font.BOLD ,15));
        next.setBounds(675,440,150,40);
        add(next);

//        heading = new JLabel("Event Management System");
//        heading.setForeground(Color.DARK_GRAY);
//        heading.setBounds(180,10,1300,100);
//        heading.setFont(new Font("Comic Sans MS",Font.BOLD ,40));
//        add(heading);
    }

    public void actionPerformed(ActionEvent ae){
        new LoginUser().setVisible(true);
        this.setVisible(false);
    }

    public static void main(String[] args) {
        EventManagementSystem window = new EventManagementSystem();
        window.setVisible(true);
    }
}
