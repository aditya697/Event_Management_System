import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;

public class ViewProfile extends JPanel {

    JTextField username_field, name_field, password_field, sec_que_field, sec_answer_field;
    JLabel username, name, password, security_question, answer;

    public static void main(String[] args) {
        new ViewProfile().setVisible(true);
    }

    public void displayProfile() {
        try {
            String username = LoggedInUser.getUser().getUsername();
            User user = new User();
            user = user.getuser(username);
            username_field.setText(user.getUsername());
            name_field.setText(user.getName());
            password_field.setText(user.getPassword());
            sec_que_field.setText(user.getSec_q());
            sec_answer_field.setText(user.getSec_a());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public ViewProfile() {
        setBounds(100, 100, 890, 550);
        setBorder(new EmptyBorder(5, 5, 5, 5));
        setLayout(null);

        username = new JLabel("Username :");
        username.setForeground(Color.BLACK);
        username.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
        username.setBounds(99, 86, 92, 26);
        add(username);

        name = new JLabel("Name :");
        name.setForeground(Color.BLACK);
        name.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
        name.setBounds(99, 123, 92, 26);
        add(name);

        password = new JLabel("Password :");
        password.setForeground(Color.BLACK);
        password.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
        password.setBounds(99, 160, 92, 26);
        add(password);

        security_question = new JLabel("Security Question :");
        security_question.setForeground(Color.BLACK);
        security_question.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
        security_question.setBounds(99, 197, 140, 26);
        add(security_question);

        answer = new JLabel("Answer :");
        answer.setForeground(Color.BLACK);
        answer.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
        answer.setBounds(99, 234, 92, 26);
        add(answer);

        username_field = new JTextField();
        username_field.setEditable(false);
        username_field.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
        username_field.setBounds(265, 91, 148, 20);
        add(username_field);
        username_field.setColumns(10);

        name_field = new JTextField();
        name_field.setEditable(false);
        name_field.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
        name_field.setColumns(10);
        name_field.setBounds(265, 128, 148, 20);
        add(name_field);

        password_field = new JTextField();
        password_field.setEditable(false);
        password_field.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
        password_field.setColumns(10);
        password_field.setBounds(265, 165, 148, 20);
        add(password_field);

        sec_que_field = new JTextField();
        sec_que_field.setEditable(false);
        sec_que_field.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
        sec_que_field.setColumns(10);
        sec_que_field.setBounds(265, 205, 148, 20);
        add(sec_que_field);

        sec_answer_field = new JTextField();
        sec_answer_field.setEditable(false);
        sec_answer_field.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
        sec_answer_field.setColumns(10);
        sec_answer_field.setBounds(265, 242, 148, 20);
        add(sec_answer_field);

        ImageIcon img = new ImageIcon("icons/ViewProfile.png");
        JLabel background = new JLabel();
        background.setIcon(img);
        background.setBounds(0, 0, 1366, 550);
        add(background);
    }
}

