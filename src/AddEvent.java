import javax.swing.*;
import javax.swing.border.CompoundBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Arrays;

public class AddEvent extends JPanel implements ActionListener {

    JLabel event_name,start_date,end_date,contact_no,price_of_event,number_of_guests,description,error_msg_contactno,error_msg_price,error_msg_guests;
    JTextField event_name_field, start_date_field, end_date_field, contact_no_field, price_field, no_of_guests_field;
    JTextArea description_field;
    JButton start_date_calender, end_date_calender, add;

    public AddEvent() {
        setBounds(100, 100, 890, 550);
        setLayout(null);

        event_name = new JLabel("Event Name");
        event_name.setForeground(Color.BLACK);
        event_name.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
        event_name.setBounds(200, 51, 90, 22);
        add(event_name, BorderLayout.CENTER);

        start_date = new JLabel("Start Date");
        start_date.setForeground(Color.BLACK);
        start_date.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
        start_date.setBounds(200, 84, 120, 22);
        add(start_date);

        ImageIcon start_calendar_icon = new ImageIcon("icons/Calendar.png");
        start_date_calender = new JButton(start_calendar_icon);
        start_date_calender.addActionListener(this);
        start_date_calender.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
        start_date_calender.setBounds(500, 90, 15, 15);
        add(start_date_calender);

        end_date = new JLabel("End Date");
        end_date.setForeground(Color.BLACK);
        end_date.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
        end_date.setBounds(210, 117, 120, 22);
        add(end_date);

        ImageIcon end_calendar_icon = new ImageIcon("icons/Calendar.png");
        end_date_calender = new JButton(end_calendar_icon);
        end_date_calender.addActionListener(this);
        end_date_calender.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
        end_date_calender.setBounds(500, 123, 15, 15);
        add(end_date_calender);

        contact_no = new JLabel("Contact No");
        contact_no.setForeground(Color.BLACK);
        contact_no.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
        contact_no.setBounds(200, 150, 90, 22);
        add(contact_no);

        price_of_event = new JLabel("Price of Event");
        price_of_event.setForeground(Color.BLACK);
        price_of_event.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
        price_of_event.setBounds(190, 183, 130, 22);
        add(price_of_event);

        number_of_guests = new JLabel("Number of Guests");
        number_of_guests.setForeground(Color.BLACK);
        number_of_guests.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
        number_of_guests.setBounds(165, 216, 140, 22);
        add(number_of_guests);

        description = new JLabel("Description");
        description.setForeground(Color.BLACK);
        description.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
        description.setBounds(200, 249, 140, 22);
        add(description);

        event_name_field = new JTextField();
        event_name_field.setForeground(Color.BLACK);
        event_name_field.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
        event_name_field.setBounds(300, 54, 198, 20);
        add(event_name_field);
        event_name_field.setColumns(10);

        start_date_field = new JTextField();
        start_date_field.setForeground(new Color(47, 79, 79));
        start_date_field.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
        start_date_field.setColumns(10);
        start_date_field.setBounds(300, 87, 198, 20);
        add(start_date_field);

        end_date_field = new JTextField();
        end_date_field.setForeground(new Color(47, 79, 79));
        end_date_field.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
        end_date_field.setColumns(10);
        end_date_field.setBounds(300, 120, 198, 20);
        add(end_date_field);

        contact_no_field = new JTextField();
        contact_no_field.setForeground(new Color(47, 79, 79));
        contact_no_field.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
        contact_no_field.setColumns(10);
        contact_no_field.setBounds(300, 153, 198, 20);
        add(contact_no_field);

        error_msg_contactno = new JLabel();
        error_msg_contactno.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
        error_msg_contactno.setBounds(490, 153, 240, 22);

        contact_no_field.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent ke) {
                if ((ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9') || ke.getKeyChar() == KeyEvent.VK_BACK_SPACE) {
                    contact_no_field.setEditable(true);
                    error_msg_contactno.setText("");
                } else {
                    contact_no_field.setEditable(false);
                    error_msg_contactno.setText("* Enter only numeric digits(0-9)");
                    error_msg_contactno.setForeground(Color.red);
                }
            }
        });
        add(error_msg_contactno);

        price_field = new JTextField();
        price_field.setForeground(new Color(47, 79, 79));
        price_field.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
        price_field.setColumns(10);
        price_field.setBounds(300, 186, 198, 20);
        add(price_field);

        error_msg_price = new JLabel();
        error_msg_price.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
        error_msg_price.setBounds(490, 186, 240, 22);

        price_field.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent ke) {
                if ((ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9') || ke.getKeyChar() == KeyEvent.VK_BACK_SPACE) {
                    price_field.setEditable(true);
                    error_msg_price.setText("");
                } else {
                    price_field.setEditable(false);
                    error_msg_price.setText("* Enter only numeric digits(0-9)");
                    error_msg_price.setForeground(Color.red);
                }
            }
        });
        add(error_msg_price);

        no_of_guests_field = new JTextField();
        no_of_guests_field.setForeground(new Color(47, 79, 79));
        no_of_guests_field.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
        no_of_guests_field.setColumns(10);
        no_of_guests_field.setBounds(300, 219, 198, 20);
        add(no_of_guests_field);

        error_msg_guests = new JLabel();
        error_msg_guests.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
        error_msg_guests.setBounds(490, 219, 240, 22);

        no_of_guests_field.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent ke) {
                if ((ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9') || ke.getKeyChar() == KeyEvent.VK_BACK_SPACE) {
                    no_of_guests_field.setEditable(true);
                    error_msg_guests.setText("");
                } else {
                    no_of_guests_field.setEditable(false);
                    error_msg_guests.setText("* Enter only numeric digits(0-9)");
                    error_msg_guests.setForeground(Color.red);
                }
            }
        });
        add(error_msg_guests);

        description_field = new JTextArea();
        description_field.setForeground(new Color(47, 79, 79));
        description_field.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
        description_field.setColumns(10);
        description_field.setBorder(new LineBorder(new Color(47, 79, 79)));
        description_field.setBounds(300, 252, 198, 70);
        add(description_field);

        add = new JButton("Add");
        add.addActionListener(this);
        add.setBorder(new CompoundBorder(new LineBorder(new Color(128, 128, 128)), null));
        add.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
        add.setBounds(280, 340, 100, 33);
        add.setBackground(new Color(255, 206, 69));
        add.setForeground(Color.BLACK);
        add(add);

        setBorder(new TitledBorder(new LineBorder(new Color(138, 43, 226), 2), "Add Event", TitledBorder.LEADING,
                TitledBorder.TOP, null, new Color(0, 0, 255)));

        ImageIcon image = new ImageIcon("icons/Addevents.png");
        JLabel background = new JLabel();
        background.setIcon(image);
        background.setBounds(0, 0, 1366, 550);
        add(background);
    }

    public void actionPerformed(ActionEvent ae){
        try{
            if(ae.getSource() == start_date_calender) {
                setBounds(180,10,850,500);
                start_date_field.setText(new DatePicker(this).setPickedDate());
            }
            if(ae.getSource() == end_date_calender) {
                setBounds(180,10,850,500);
                end_date_field.setText(new DatePicker(this).setPickedDate());
            }
            if(ae.getSource() == add) {
                Event event = new Event();
                System.out.println("Event Creation");
                int event_created = event.AddEvent(event_name_field.getText(),
                        start_date_field.getText(), end_date_field.getText(), Integer.parseInt(contact_no_field.getText()), Integer.parseInt(price_field.getText()),
                        Integer.parseInt(no_of_guests_field.getText()), description_field.getText());
                System.out.println(event_created + " records inserted");
                if (event_created > 0) {
                    JOptionPane.showMessageDialog(null, "Added Event Successfully.");
                    setVisible(false);
                } else
                    JOptionPane.showMessageDialog(null, "Could not Add Event.");
            }
        } catch(Exception e) {
            System.out.println(Arrays.toString(e.getStackTrace()));
        }

    }
}
