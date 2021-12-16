import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Objects;

class OldEvents extends JPanel implements ActionListener {

    JTable table;
    JTextField search_field;
    JButton search, upcoming_events;
    JLabel event_name;
    JTabbedPane tab_panel;

    public void display_events() {
        try {
            Event event = new Event();
            table.setModel(Objects.requireNonNull(event.getoldevents(search_field.getText())));
            table.setRowHeight(30);
            table.getColumnModel().getColumn(0).setPreferredWidth(5);
            table.getColumnModel().getColumn(1).setPreferredWidth(30);
            table.getColumnModel().getColumn(2).setPreferredWidth(40);
            table.getColumnModel().getColumn(3).setPreferredWidth(20);
            table.getColumnModel().getColumn(4).setPreferredWidth(20);
            table.getColumnModel().getColumn(5).setPreferredWidth(50);
            table.getColumnModel().getColumn(6).setPreferredWidth(70);
            table.getColumnModel().getColumn(7).setPreferredWidth(100);
        } catch (Exception ignored) {}
    }

    public OldEvents(JTabbedPane tabs) {
        tab_panel = tabs;
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
        search.setBounds(530, 75, 138, 33);
        add(search);

        upcoming_events = new JButton("Upcoming Events");
        upcoming_events.addActionListener(this);
        upcoming_events.setForeground(Color.BLACK);
        upcoming_events.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
        upcoming_events.setBorder(new LineBorder(Color.BLACK, 2, true));
        upcoming_events.setBounds(680, 75, 138, 33);
        add(upcoming_events);

        search_field = new JTextField();
        search_field.setBorder(new LineBorder(Color.BLACK, 2, true));
        search_field.setForeground(Color.BLACK);
        search_field.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 17));
        search_field.setBounds(185, 75, 320, 33);
        add(search_field);
        search_field.setColumns(10);

        event_name = new JLabel("Event Name :");
        event_name.setForeground(Color.BLACK);
        event_name.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
        event_name.setBounds(50, 75, 150, 33);
        add(event_name);

        ImageIcon img = new ImageIcon("icons/OldEvents.png");
        JLabel background = new JLabel();
        background.setIcon(img);
        background.setBounds(0, 0, 1366, 550);
        add(background);
    }

    public void actionPerformed(ActionEvent ae){
        try{
            Event event = new Event();
            if( ae.getSource() == search){
                table.setModel(Objects.requireNonNull(event.getoldevents(search_field.getText())));
            }
            if(ae.getSource() == upcoming_events){
                tab_panel.setSelectedIndex(6);
                tab_panel.requestFocus();
                search_field.setText("");
                display_events();
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}
