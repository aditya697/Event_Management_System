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

class DeleteUsers extends JPanel implements ActionListener{

    JTable table;
    JTextField search_field;
    JButton search, delete;
    JLabel delete_user, user_name;

    public static void main(String[] args) {
        new DeleteUsers().setVisible(true);
    }

    public void display_events() {
        try {
            User user = new User();
            table.setModel(Objects.requireNonNull(user.getusers(search_field.getText())));
            table.setRowHeight(30);
            table.getColumnModel().getColumn(0).setPreferredWidth(5);
            table.getColumnModel().getColumn(1).setPreferredWidth(30);
            table.getColumnModel().getColumn(2).setPreferredWidth(40);
            table.getColumnModel().getColumn(3).setPreferredWidth(20);
            table.getColumnModel().getColumn(4).setPreferredWidth(20);
        } catch (Exception ignored) {}
    }

    public DeleteUsers() {
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

        delete = new JButton("Delete");
        delete.addActionListener(this);
        delete.setForeground(Color.BLACK);
        delete.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
        delete.setBorder(new LineBorder(Color.BLACK, 2, true));
        delete.setBounds(680, 75, 138, 33);
        add(delete);

        delete_user = new JLabel("Delete User");
        delete_user.setForeground(Color.BLACK);
        delete_user.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 30));
        delete_user.setBounds(300, 15, 400, 47);
        add(delete_user);

        search_field = new JTextField();
        search_field.setBorder(new LineBorder(Color.BLACK, 2, true));
        search_field.setForeground(Color.BLACK);
        search_field.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 17));
        search_field.setBounds(185, 75, 320, 33);
        add(search_field);

        user_name = new JLabel("User Name :");
        user_name.setForeground(Color.BLACK);
        user_name.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
        user_name.setBounds(50, 75, 150, 33);
        add(user_name);

        ImageIcon img = new ImageIcon("icons/DeleteUsers.png");
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

            if(ae.getSource() == delete){
                JDialog.setDefaultLookAndFeelDecorated(true);
                int response = JOptionPane.showConfirmDialog(null, "Do you want to continue?", "Confirm",
                        JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                if(response == JOptionPane.YES_OPTION) {
                    int column = 0;
                    int row = table.getSelectedRow();
                    String value = table.getModel().getValueAt(row, column).toString();
                    System.out.println(row);
                    System.out.println(value);
                    user.deleteuser(search_field.getText());
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

