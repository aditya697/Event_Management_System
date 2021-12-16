import javax.swing.*;
import java.awt.*;
import javax.swing.border.EmptyBorder;

public class Home extends JPanel {
    JLabel ons, mssg_of_date, quote, quote1,quote2, author,announcement, first_announcement, second_announcement, third_announcement, heading, overview;

    public static void main(String[] args) {
        new Home().setVisible(true);
    }

    public Home() {
        setBounds(100, 100, 890, 550);
        setBorder(new EmptyBorder(5, 5, 5, 5));
        setLayout(null);

        //top
        heading = new JLabel("Welcome " + LoggedInUser.getUser().getUsername() + " !");
        heading.setFont(new Font("Comic Sans MS", Font.BOLD, 25));
        heading.setBounds(300, 20, 500, 40);
        add(heading);

        //right
        overview = new JLabel("Overview");
        overview.setBounds(45, 70, 450, 25);
        overview.setFont(new Font("Comic Sans MS", Font.BOLD, 25));
        add(overview);

        JPanel panel = new JPanel();
        panel.setBackground(new Color(237, 236, 237));
        panel.setBounds(40, 120, 310, 300);
        add(panel);
        panel.setLayout(null);

        JPanel panel_1 = new JPanel();
        panel_1.setBounds(0, 0, 310, 50);
        panel.add(panel_1);
        panel_1.setBackground( new Color(182, 227, 249));
        panel_1.setLayout(null);

//        JButton btnNewButton_1 = new JButton("New button");
//        btnNewButton_1.setBounds(206, 25, 85, 21);
//        panel_1.add(btnNewButton_1);

        mssg_of_date = new JLabel("Message Of the Day");
        mssg_of_date.setBounds(40, 17, 345, 20);
        mssg_of_date.setFont(new Font("Comic Sans MS",Font.BOLD ,15));
        panel_1.add(mssg_of_date);

        ons = new JLabel("Om! Nama Shivaya");
        ons.setBounds(25, 66, 200, 40);
        ons.setFont(new Font("Comic Sans MS",Font.BOLD ,22));
        ons.setForeground(new Color(245, 136, 64));
        panel.add(ons);

        quote = new JLabel("An event shouldn't be just");
        quote.setBounds(38, 115, 450, 25);
        quote.setFont(new Font("Comic Sans MS",Font.BOLD ,16));
        panel.add(quote);

        quote1 = new JLabel("an experiential thing, it");
        quote1.setBounds(38, 140, 450, 25);
        quote1.setFont(new Font("Comic Sans MS",Font.BOLD ,16));
        panel.add(quote1);

        quote2 = new JLabel("should be an emotional thing!");
        quote2.setBounds(38, 170, 450, 25);
        quote2.setFont(new Font("Comic Sans MS",Font.BOLD ,16));
        panel.add(quote2);

        author = new JLabel("-Amit Kalantri, Wealth of Words");
        author.setBounds(20, 230, 450, 25);
        author.setFont(new Font("Comic Sans MS",Font.BOLD ,13));
        panel.add(author);

        //left
        announcement = new JLabel("Today's announcements");
        announcement.setBounds(416, 170, 296, 40);
        add(announcement);

        JPanel panel_3 = new JPanel();
        panel_3.setBounds(416, 200, 317, 170);
        add(panel_3);
        panel_3.setLayout(null);

        first_announcement = new JLabel("★ All the event are listed in event details.");
        first_announcement.setBounds(5, 35, 450, 13);
        panel_3.add(first_announcement);

        second_announcement = new JLabel("★ All the upcoming are listed in upcoming events.");
        second_announcement.setBounds(5, 67, 450, 13);
        panel_3.add(second_announcement);

        third_announcement = new JLabel("★ All the current event are available in current events.");
        third_announcement.setBounds(5, 103, 450, 13);
        panel_3.add(third_announcement);

        ImageIcon img = new ImageIcon("icons/Home.png");
        JLabel background = new JLabel();
        background.setIcon(img);
        background.setBounds(0, 0, 1366, 550);
        add(background);

    }
}