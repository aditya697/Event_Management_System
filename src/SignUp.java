import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.border.*;

public class SignUp extends JFrame implements ActionListener{

    JTextField username_field,name_field;
    JPasswordField password_field;
    JComboBox security_question;
    JTextField answer_field;
    JButton signup, back;
    JLabel username, name, password, SecurityQuestion, answer, image;
    JLabel error_msg_username;
    ArrayList usernames = new ArrayList();

    public static void main(String[] args) {
        new SignUp().setVisible(true);
    }

    public SignUp() {
        setTitle("Sign Up");
        setBounds(100, 100, 890, 550);
        JPanel contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setBackground(Color.WHITE);
        contentPane.setLayout(null);

        image = new JLabel(new ImageIcon("icons/Signup.png"));
        image.setBounds(0,0,1366,350);
        setContentPane(image);

        username = new JLabel("Username :");
        username.setForeground(Color.DARK_GRAY);
        username.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
        username.setBounds(305, 100, 92, 26);
        add(username);

        name = new JLabel("Name :");
        name.setForeground(Color.DARK_GRAY);
        name.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
        name.setBounds(334, 137, 92, 26);
        add(name);

        password = new JLabel("Password :");
        password.setForeground(Color.DARK_GRAY);
        password.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
        password.setBounds(312, 174, 92, 26);
        add(password);

        SecurityQuestion = new JLabel("Security Question :");
        SecurityQuestion.setForeground(Color.DARK_GRAY);
        SecurityQuestion.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
        SecurityQuestion.setBounds(250, 211, 140, 26);
        add(SecurityQuestion);

        answer = new JLabel("Answer :");
        answer.setForeground(Color.DARK_GRAY);
        answer.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
        answer.setBounds(325, 248, 92, 26);
        add(answer);

        username_field = new JTextField();
        username_field.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
        username_field.setColumns(10);
        username_field.setBounds(400, 102, 148, 20);
        add(username_field);

        try {
            User user = new User();
            usernames = (ArrayList) user.getusernames();
            System.out.println(usernames);
        } catch (SQLException exp) {
            System.out.println(exp.getMessage());
        }

        error_msg_username = new JLabel();
        error_msg_username.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
        error_msg_username.setBounds(560, 102, 240, 22);

        username_field.addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent ke) {
                System.out.println("Checking username");
                System.out.println(username_field.getText());
                if(usernames.contains(username_field.getText())) {
                    error_msg_username.setText("Username already exists");
                    error_msg_username.setForeground(Color.red);
                }
                else
                {
                    error_msg_username.setText("");
                    error_msg_username.setText("Username looks good");
                    error_msg_username.setForeground(Color.GREEN);
                }
            }
        });
        add(error_msg_username);

        name_field = new JTextField();
        name_field.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
        name_field.setColumns(10);
        name_field.setBounds(400, 139, 148, 20);
        add(name_field);

        password_field = new JPasswordField();
        password_field.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
        password_field.setColumns(10);
        password_field.setBounds(400, 176, 148, 20);
        add(password_field);

        JProgressBar progressBar = new JProgressBar(0,5);
        progressBar.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
        progressBar.setStringPainted(true);
        progressBar.setBounds(560, 176, 150, 20);
        progressBar.setString("");

        password_field.addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent ke) {
                String text = password_field.getText();
                int count=0, isupper=0, islower=0, isnumeric=0, isspecial=0;
                for (int i = 0; i < text.length(); i++) {
                    char c = text.charAt(i);
                    if (Character.isUpperCase(c)) {
                        isupper = 1;
                    } else {
                        if (Character.isLowerCase(c)) {
                            islower = 1;
                        } else {
                            if (Character.isDigit(c)) {
                                isnumeric = 1;
                            } else {
                                if (c == '!' || c == '@' || c == '#' || c == '%' || c == '*' || c == '$') {
                                    isspecial = 1;
                                }
                            }
                        }
                    }
                }
                if (text.length() >= 8) {
                    count += 1;
                }
                count += isupper + islower + isnumeric + isspecial;
                if (text.length() < 1) {
                    progressBar.setValue(0);
                } else {
                    progressBar.setValue(count);
                }
                if (count == 0 || count == 1) {
                    progressBar.setForeground(Color.RED);
                    progressBar.setString("Poor");
                } else if (count == 2){
                    progressBar.setForeground(Color.YELLOW);
                    progressBar.setString("Avg");
                }else if (count == 3){
                    progressBar.setForeground(Color.GREEN);
                    progressBar.setString("Good");
                }else if (count == 4){
                    progressBar.setForeground(Color.BLUE);
                    progressBar.setString("Excellent");
                }
            }
        });
        add(progressBar);

        security_question = new JComboBox();
        security_question.setModel(new DefaultComboBoxModel(new String[] { "Your NickName?", "Your Lucky Number?",
                "Your child SuperHero?", "Your childhood Name ?" }));
        security_question.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
        security_question.setBounds(400, 213, 148, 20);
        add(security_question);

        answer_field = new JTextField();
        answer_field.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
        answer_field.setColumns(10);
        answer_field.setBounds(400, 250, 148, 20);
        add(answer_field);

        signup = new JButton("Sign Up");
        signup.addActionListener(this);
        signup.setFont(new Font("Comic Sans MS", Font.BOLD, 13));
        signup.setBounds(310, 300, 100, 30);
        signup.setBackground(Color.GREEN);
        signup.setForeground(Color.BLACK);
        add(signup);

        back = new JButton("Back");
        back.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                setVisible(false);
                LoginUser login = new LoginUser();
                login.setVisible(true);
            }
        });
        back.setFont(new Font("Comic Sans MS", Font.BOLD, 13));
        back.setBounds(450, 300, 100, 30);
        back.setBackground(Color.ORANGE);
        back.setForeground(Color.BLACK);
        add(back);
    }

    public void actionPerformed(ActionEvent ae){
        try{
            User user = new User();
            int usersCreated = user.signup(username_field.getText(),
                    name_field.getText(),
                    password_field.getText(),
                    (String) security_question.getSelectedItem(), answer_field.getText());
            System.out.println(usersCreated + " records inserted");
            if (usersCreated > 0) {
                JOptionPane.showMessageDialog(null, "Created User Successfully.");
                setVisible(false);
                new LoginUser().setVisible(true);
            } else
                JOptionPane.showMessageDialog(null, "Could not Create User.");
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}
