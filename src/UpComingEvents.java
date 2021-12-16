import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.Objects;

class UpComingEvents extends JPanel implements ActionListener {

    JTable table;
    JTextField search_field, amount_paid_field;
    JSpinner num_seats_field;
    JButton search, register;
    JLabel upcoming_events, num_seats, amount_paid, event_name;

    public static void main(String[] args) {
        new UpComingEvents().setVisible(true);
    }

    public void display_events() {
        try {
            Event event = new Event();
            table.setModel(Objects.requireNonNull(event.getupcomingevents(search_field.getText())));
            table.setRowHeight(30);
            table.getColumnModel().getColumn(0).setPreferredWidth(5);
            table.getColumnModel().getColumn(1).setPreferredWidth(30);
            table.getColumnModel().getColumn(2).setPreferredWidth(10);
            table.getColumnModel().getColumn(3).setPreferredWidth(5);
            table.getColumnModel().getColumn(4).setPreferredWidth(20);
            table.getColumnModel().getColumn(5).setPreferredWidth(50);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public UpComingEvents() {
        setBounds(100, 100, 890, 550);
        setBorder(new EmptyBorder(5, 5, 5, 5));
        setLayout(null);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(50, 120, 771, 282);
        add(scrollPane);

        table = new JTable();
        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent arg0) {
                int row = table.getSelectedRow();
                search_field.setText(table.getModel().getValueAt(row, 1).toString());
            }
        });
        table.setBackground(new Color(240, 248, 255));
        table.setForeground(Color.BLACK);
        table.setFont(new Font("Comic Sans MS", Font.BOLD, 16));
        scrollPane.setViewportView(table);

        search = new JButton("Search");
        search.addActionListener(this);
        search.setBorder(new LineBorder(Color.BLACK, 2, true));
        search.setForeground(Color.BLACK);
        search.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
        search.setBounds(530, 75, 138, 33);
        add(search);

        register = new JButton("Register");
        register.addActionListener(this);
        register.setForeground(Color.BLACK);
        register.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
        register.setBorder(new LineBorder(Color.BLACK, 2, true));
        register.setBounds(680, 75, 138, 33);
        add(register);

        upcoming_events = new JLabel("Upcoming Events");
        upcoming_events.setForeground(Color.BLACK);
        upcoming_events.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 30));
        upcoming_events.setBounds(300, 15, 400, 47);
        add(upcoming_events);

        num_seats = new JLabel("Number of seats");
        num_seats.setForeground(new Color(25, 25, 112));
        num_seats.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
        num_seats.setBounds(150, 437, 180, 22);
        add(num_seats);

        amount_paid = new JLabel("Amount Paid");
        amount_paid.setForeground(new Color(25, 25, 112));
        amount_paid.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
        amount_paid.setBounds(420, 437, 102, 22);
        add(amount_paid);

        search_field = new JTextField();
        search_field.setBorder(new LineBorder(Color.BLACK, 2, true));
        search_field.setForeground(Color.BLACK);
        search_field.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 17));
        search_field.setBounds(185, 75, 320, 33);
        add(search_field);

        num_seats_field = new JSpinner();
        num_seats_field.setBorder(new LineBorder(Color.BLACK, 2, true));
        num_seats_field.setForeground(Color.BLACK);
        num_seats_field.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 17));
        num_seats_field.setBounds(270, 437, 70, 20);
        add(num_seats_field);

        amount_paid_field = new JTextField();
        amount_paid_field.setBorder(new LineBorder(Color.BLACK, 2, true));
        amount_paid_field.setForeground(Color.BLACK);
        amount_paid_field.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 17));
        amount_paid_field.setBounds(510, 437, 70, 20);
        add(amount_paid_field);

        event_name = new JLabel("Event Name :");
        event_name.setForeground(Color.BLACK);
        event_name.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
        event_name.setBounds(50, 75, 150, 33);
        add(event_name);

        ImageIcon img = new ImageIcon("icons/UpcomingEvents.png");
        JLabel background = new JLabel();
        background.setIcon(img);
        background.setBounds(0, 0, 1366, 550);
        add(background);
    }

    public void actionPerformed(ActionEvent ae){
        try{
            Event event = new Event();
            if( ae.getSource() == search){
                table.setModel(Objects.requireNonNull(event.getupcomingevents(search_field.getText())));
            }

            if(ae.getSource() == register){
                JDialog.setDefaultLookAndFeelDecorated(true);
                int response = JOptionPane.showConfirmDialog(null, "Do you want to continue?", "Confirm",
                        JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                if(response == JOptionPane.YES_OPTION) {
                    int column = 0;
                    int row = table.getSelectedRow();
                    String value = table.getModel().getValueAt(row, column).toString();
                    System.out.println(row);
                    System.out.println(value);
                    event.registerevents(Integer.parseInt(value),Integer.parseInt(num_seats_field.getValue().toString()),Integer.parseInt(amount_paid_field.getText()));
                    JOptionPane.showMessageDialog(null, "Successfully Registered..!");
                    search_field.setText("");
                    display_events();
                }
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}
