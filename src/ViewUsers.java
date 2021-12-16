import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Objects;

public class ViewUsers extends JPanel implements ActionListener {

    JTable table;
    JTextField search_field;
    JButton search, home;
    JLabel user_name;
    JTabbedPane tab_panel;

    public void display_events() {
        try {
            User user = new User();
            table.setModel(Objects.requireNonNull(user.getusers(search_field.getText())));
            table.getColumnModel().getColumn(0).setPreferredWidth(5);
            table.getColumnModel().getColumn(1).setPreferredWidth(30);
            table.getColumnModel().getColumn(2).setPreferredWidth(40);
            table.getColumnModel().getColumn(3).setPreferredWidth(20);
            table.getColumnModel().getColumn(4).setPreferredWidth(20);
            table.setRowHeight(30);
        } catch (Exception ignored) {}
    }

    public ViewUsers(JTabbedPane tabs) {
        tab_panel = tabs;
        setBounds(100, 100, 890, 550);
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

        home = new JButton("Back to home");
        home.addActionListener(this);
        home.setForeground(Color.BLACK);
        home.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
        home.setBorder(new LineBorder(Color.BLACK, 2, true));
        home.setBounds(680, 75, 138, 33);
        add(home);

        search_field = new JTextField();
        search_field.setBorder(new LineBorder(Color.BLACK, 2, true));
        search_field.setForeground(Color.BLACK);
        search_field.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 17));
        search_field.setBounds(185, 75, 320, 33);
        add(search_field);

        user_name = new JLabel("User Name : ");
        user_name.setForeground(Color.BLACK);
        user_name.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
        user_name.setBounds(50, 75, 150, 33);
        add(user_name);

        ImageIcon img = new ImageIcon("icons/UserDetails.png");
        JLabel background = new JLabel();
        background.setIcon(img);
        background.setBounds(0, 0, 1366, 550);
        add(background);
    }

    public void actionPerformed(ActionEvent ae){
        try{
            User user = new User();
            if( ae.getSource() == search){
                table.setModel(Objects.requireNonNull(user.getusers(search_field.getText())));
            }
            if(ae.getSource() == home){
                tab_panel.setSelectedIndex(0);
                tab_panel.requestFocus();
            }
        }
        catch(Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
