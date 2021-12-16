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

public class CurrentEvents extends JPanel implements ActionListener{

    JTable table;
    JTextField search_field;
    JButton search, upcoming_events;
    JLabel current_events, event_name;
    JTabbedPane tab_panel;

    public void display_events() {
        try {
            Event event = new Event();
            table.setModel(Objects.requireNonNull(event.getcurrentevents(search_field.getText())));
            table.setRowHeight(30);
            table.getColumnModel().getColumn(0).setPreferredWidth(5);
            table.getColumnModel().getColumn(1).setPreferredWidth(30);
            table.getColumnModel().getColumn(2).setPreferredWidth(5);
            table.getColumnModel().getColumn(3).setPreferredWidth(5);
            table.getColumnModel().getColumn(4).setPreferredWidth(40);
            table.getColumnModel().getColumn(5).setPreferredWidth(40);
            table.getColumnModel().getColumn(6).setPreferredWidth(70);
        } catch (Exception ignored) {}
    }

    public CurrentEvents(JTabbedPane tabs) {
        tab_panel = tabs;
        setBounds(100, 100, 890, 550);
        setBorder(new EmptyBorder(5, 5, 5, 5));
        setLayout(null);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(79, 133, 771, 282);
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

        search = new JButton("Search");
        search.addActionListener(this);
        search.setBorder(new LineBorder(Color.BLACK, 2, true));
        search.setForeground(Color.BLACK);
        search.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
        search.setBounds(564, 89, 138, 33);
        add(search);

        upcoming_events = new JButton("Upcoming Events");
        upcoming_events.addActionListener(this);
        upcoming_events.setForeground(Color.BLACK);
        upcoming_events.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
        upcoming_events.setBorder(new LineBorder(Color.BLACK, 2, true));
        upcoming_events.setBounds(712, 89, 138, 33);
        add(upcoming_events);

//        current_events = new JLabel("Current Events");
//        current_events.setForeground(new Color(107, 142, 35));
//        current_events.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 30));
//        current_events.setBounds(300, 15, 400, 47);
//        add(current_events);

        search_field = new JTextField();
        search_field.setBorder(new LineBorder(Color.BLACK, 2, true));
        search_field.setForeground(Color.BLACK);
        search_field.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 17));
        search_field.setBounds(189, 89, 357, 33);
        add(search_field);

        event_name = new JLabel("Event Name : ");
        event_name.setForeground(Color.BLACK);
        event_name.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
        event_name.setBounds(50, 89, 150, 33);
        add(event_name);

        ImageIcon img = new ImageIcon("icons/CurrentEvents.png");
        JLabel background = new JLabel();
        background.setIcon(img);
        background.setBounds(0, 0, 1366, 550);
        add(background);
    }

    public void actionPerformed(ActionEvent ae){
        try{
            Event event = new Event();
            if( ae.getSource() == search){
                table.setModel(Objects.requireNonNull(event.getcurrentevents(search_field.getText())));
            }

            if(ae.getSource() == upcoming_events){
                if(Objects.equals(LoggedInUser.getUser().getUsername(), "Admin")){
                    tab_panel.setSelectedIndex(6);
                    tab_panel.requestFocus();
                    search_field.setText("");
                }
                else {
                    tab_panel.setSelectedIndex(1);
                    tab_panel.requestFocus();
                }
            }
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}
