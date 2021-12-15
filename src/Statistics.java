import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Objects;

public class Statistics extends JPanel{

    private final JTable table;
    private final JTable table_1;

    public static void main(String[] args) {
        new Statistics().setVisible(true);
    }

    public void View_Events() {
        try {
            Event event = new Event();
            table.setModel(Objects.requireNonNull((event.getevents())));
            table.setRowHeight(30);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void RegisterEvent() {
        try {
            Connection connection = DatabaseConnection.getConnection();
            String sql = "select * from event_registration";
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            table_1.setModel(Objects.requireNonNull(DbUtils.resultSetToTableModel(rs)));
            table_1.setRowHeight(30);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public Statistics() {
        setBounds(100, 100, 890, 550);
        setBorder(new EmptyBorder(5, 5, 5, 5));
        setLayout(null);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(40, 51, 717, 217);
        add(scrollPane);

        table = new JTable();
        table.setBackground(new Color(224, 255, 255));
        table.setForeground(new Color(128, 128, 0));
        table.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
        scrollPane.setViewportView(table);

        setBorder(new TitledBorder(new LineBorder(new Color(47, 79, 79), 2, true), "Event-Details",
                TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 128, 128)));

        JScrollPane scrollPane_1 = new JScrollPane();
        scrollPane_1.setBounds(40, 316, 717, 217);
        add(scrollPane_1);

        table_1 = new JTable();
        table_1.setBackground(new Color(204, 255, 255));
        table_1.setForeground(new Color(153, 51, 0));
        table_1.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
        scrollPane_1.setViewportView(table_1);

        ImageIcon img = new ImageIcon("icons/Login_Page.jpg");
        JLabel background = new JLabel();
        background.setIcon(img);
        background.setBounds(0, 0, 1366, 550);
        add(background);

        setBorder(new TitledBorder(new LineBorder(new Color(0, 204, 153), 2, true), "Registration-Details",
                TitledBorder.RIGHT, TitledBorder.TOP, null, new Color(0, 102, 51)));

        View_Events();
        RegisterEvent();
    }
}

