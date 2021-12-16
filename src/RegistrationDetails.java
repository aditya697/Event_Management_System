import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Objects;

public class RegistrationDetails extends JPanel implements ActionListener {

    JTable table;
    JTextField search_field;
    JButton search, delete;
    JLabel event_name, registration_details;

    public static void main(String[] args) {
        new RegistrationDetails().setVisible(true);
    }

    public void display_events() {
        try {
            Event event = new Event();
            if(Objects.equals(LoggedInUser.getUser().getUsername(),"Admin")) {
                table.setModel(Objects.requireNonNull(event.allregisteredevents()));
            }
            else {
                table.setModel(Objects.requireNonNull(event.registeredevents(search_field.getText())));
            }
            table.setRowHeight(30);
            table.getColumnModel().getColumn(0).setPreferredWidth(5);
            table.getColumnModel().getColumn(1).setPreferredWidth(30);
            table.getColumnModel().getColumn(2).setPreferredWidth(40);
            table.getColumnModel().getColumn(3).setPreferredWidth(20);
            table.getColumnModel().getColumn(4).setPreferredWidth(20);
        } catch (Exception ignored) {}
    }

    public RegistrationDetails() {
        setBounds(100, 100, 890, 550);
        setBorder(new EmptyBorder(5, 5, 5, 5));
        setLayout(null);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(79, 133, 771, 288);
        add(scrollPane);

        table = new JTable();
        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent arg0) {
                int row = table.getSelectedRow();
                search_field.setText(table.getModel().getValueAt(row, 0).toString());
            }
        });
        table.setBackground(new Color(240, 248, 255));
        table.setForeground(Color.BLACK);
        table.setFont(new Font("Comic Sans MS", Font.BOLD, 16));
        scrollPane.setViewportView(table);

        registration_details = new JLabel("Registration Details");
        registration_details.setForeground(Color.BLACK);
        registration_details.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 30));
        registration_details.setBounds(300, 15, 400, 47);
        add(registration_details);

        search = new JButton("Search");
        search.addActionListener(this);
        search.setBorder(new LineBorder(Color.BLACK, 2, true));
        search.setForeground(Color.BLACK);
        search.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
        search.setBounds(564, 89, 138, 33);
        add(search);

        delete = new JButton("Delete");
        delete.addActionListener(this);
        delete.setForeground(Color.BLACK);
        delete.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
        delete.setBorder(new LineBorder(Color.BLACK, 2, true));
        delete.setBounds(712, 89, 138, 33);
        add(delete);

        search_field = new JTextField();
        search_field.setBorder(new LineBorder(Color.BLACK, 2, true));
        search_field.setForeground(Color.BLACK);
        search_field.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 17));
        search_field.setBounds(189, 89, 357, 33);
        add(search_field);
        search_field.setColumns(10);

        event_name = new JLabel("Event Name :");
        event_name.setForeground(Color.BLACK);
        event_name.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
        event_name.setBounds(50, 89, 150, 33);
        add(event_name);

        ImageIcon img = new ImageIcon("icons/RegistrationDetails.png");
        JLabel background = new JLabel();
        background.setIcon(img);
        background.setBounds(0, 0, 1366, 550);
        add(background);
    }

    public void actionPerformed(ActionEvent ae){
        try{
            Event event = new Event();
            if( ae.getSource() == search){
                if(Objects.equals(LoggedInUser.getUser().getUsername(),"Admin")) {
                    table.setModel(Objects.requireNonNull(event.allregisteredevents()));
                }
                else {
                    table.setModel(Objects.requireNonNull(event.registeredevents(search_field.getText())));
                }
            }

            if(ae.getSource() == delete){
                JDialog.setDefaultLookAndFeelDecorated(true);
                int response = JOptionPane.showConfirmDialog(null, "Do you want to continue?", "Confirm",
                        JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                System.out.println("Response" + response);
                if(response == JOptionPane.YES_OPTION) {
                    int rs = event.deletevents(search_field.getText());
                    System.out.println(rs);
                    System.out.println(search_field.getText());
                    JOptionPane.showMessageDialog(null, "Successfully Deleted..!");
                    search_field.setText("");
                    display_events();
                }
            }
        }catch(Exception ignored){
        }
    }
}

