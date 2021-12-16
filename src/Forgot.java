import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.event.*;

public class Forgot extends JFrame implements ActionListener{

    JTextField username_field, name_field, sec_que_field, answer_field, password_field;
    JButton search, retrieve, back;
    JLabel username, name, security_question, answer, password,image;

    public static void main(String[] args) {
        new Forgot().setVisible(true);
    }

    public Forgot() {
        setTitle("Forgot");
        setBounds(100, 100, 890, 550);
        JPanel contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setBackground(Color.WHITE);
        contentPane.setLayout(null);

        image = new JLabel(new ImageIcon("icons/Forgot.png"));
        image.setBounds(0,0,1366,350);
        setContentPane(image);

        username = new JLabel("Username");
        username.setFont(new Font("Comic Sans MS", Font.BOLD, 13));
        username.setBounds(109, 83, 87, 29);
        add(username);

        name = new JLabel("Name");
        name.setFont(new Font("Comic Sans MS", Font.BOLD, 13));
        name.setBounds(109, 122, 75, 21);
        add(name);

        security_question = new JLabel("Your Security Question");
        security_question.setFont(new Font("Comic Sans MS", Font.BOLD, 13));
        security_question.setBounds(109, 154, 156, 27);
        add(security_question);

        answer = new JLabel("Answer");
        answer.setFont(new Font("Comic Sans MS", Font.BOLD, 13));
        answer.setBounds(109, 192, 104, 21);
        add(answer);

        password = new JLabel("Password");
        password.setFont(new Font("Comic Sans MS", Font.BOLD, 13));
        password.setBounds(109, 224, 104, 21);
        add(password);

        username_field = new JTextField();
        username_field.setFont(new Font("Comic Sans MS", Font.BOLD, 13));
        username_field.setForeground(new Color(105, 105, 105));
        username_field.setBounds(277, 88, 139, 20);
        add(username_field);
        username_field.setColumns(10);

        name_field = new JTextField();
        name_field.setEditable(false);
        name_field.setFont(new Font("Comic Sans MS", Font.BOLD, 13));
        name_field.setForeground(new Color(165, 42, 42));
        name_field.setColumns(10);
        name_field.setBounds(277, 123, 139, 20);
        add(name_field);

        sec_que_field = new JTextField();
        sec_que_field.setEditable(false);
        sec_que_field.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
        sec_que_field.setForeground(new Color(72, 61, 139));
        sec_que_field.setColumns(10);
        sec_que_field.setBounds(277, 161, 221, 20);
        add(sec_que_field);

        answer_field = new JTextField();
        answer_field.setFont(new Font("Comic Sans MS", Font.BOLD, 13));
        answer_field.setForeground(new Color(205, 92, 92));
        answer_field.setColumns(10);
        answer_field.setBounds(277, 193, 139, 20);
        add(answer_field);

        password_field = new JTextField();
        password_field.setEditable(false);
        password_field.setFont(new Font("Comic Sans MS", Font.BOLD, 13));
        password_field.setForeground(new Color(50, 205, 50));
        password_field.setColumns(10);
        password_field.setBounds(277, 225, 139, 20);
        add(password_field);

        search = new JButton("Search");
        search.addActionListener(this);
        search.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
        search.setBounds(428, 83, 80, 29);
        search.setBackground(Color.ORANGE);
        search.setForeground(Color.BLACK);
        add(search);

        retrieve = new JButton("Retrieve");
        retrieve.addActionListener(this);
        retrieve.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
        retrieve.setBounds(426, 188, 85, 29);
        retrieve.setBackground(Color.GREEN);
        retrieve.setForeground(Color.BLACK);
        add(retrieve);

        back = new JButton("Back");
        back.addActionListener(this);
        back.setFont(new Font("Comic Sans MS", Font.BOLD, 13));
        back.setBounds(233, 270, 101, 29);
        back.setBackground(new Color(255, 206, 69));
        back.setForeground(Color.BLACK);
        add(back);
    }

    public void actionPerformed(ActionEvent ae){
        try{
            User user = new User();
            if(ae.getSource() == search){
                user = user.getuser(username_field.getText());
                name_field.setText(user.getName());
                sec_que_field.setText(user.getSec_q());
            }
            if(ae.getSource() == retrieve){
                user = user.getuser(username_field.getText());
                // check the answer provided is correct then only set password
                String ans = answer_field.getText();
                if(ans.equals(user.getSec_a())) {
                    password_field.setText(user.getPassword());
                }
                else {
                    JOptionPane.showMessageDialog(null, "You Entered Wrong answer");
                    answer_field.setText("");
                }

            }
            if(ae.getSource() == back){
                this.setVisible(false);
                new LoginUser().setVisible(true);
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}

