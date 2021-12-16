import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class LoginUser extends JFrame implements ActionListener{

    JTextField username_field;
    JPasswordField password_Field;
    JButton login, signup, forgot_password;
    JLabel username, password, image;

    public LoginUser() {
        setTitle("Login/SignUp");
        setBounds(100, 100, 890, 550);
        setLayout(null);

        image = new JLabel(new ImageIcon("icons/Login_Page.jpg"));
        image.setBounds(0,0,1366,350);
        setContentPane(image);

        username = new JLabel("Username --> ");
        username.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
        username.setBounds(240, 124, 95, 24);
        username.setForeground(Color.black);
        add(username);

        password = new JLabel("Password --> ");
        password.setFont(new Font("Comic Sans MS", Font.BOLD, 13));
        password.setBounds(240, 159, 95, 24);
        password.setForeground(Color.black);
        add(password);

        username_field = new JTextField();
        username_field.setFont(new Font("Comic Sans MS", Font.BOLD, 13));
        username_field.setBounds(330, 128, 157, 20);
        add(username_field);

        password_Field = new JPasswordField();
        password_Field.setFont(new Font("Comic Sans MS", Font.BOLD, 13));
        password_Field.setBounds(330, 163, 157, 20);
        add(password_Field);

        login = new JButton("Login");
        login.addActionListener(this);
        login.setForeground(Color.black);
        login.setBackground(Color.green);
        login.setFont(new Font("Comic Sans MS", Font.BOLD, 13));
        login.setBounds(250, 210, 103, 25);
        add(login);

        signup = new JButton("SignUp");
        signup.addActionListener(this);
        signup.setForeground(Color.black);
        signup.setBackground(Color.CYAN);
        signup.setFont(new Font("Comic Sans MS", Font.BOLD, 13));
        signup.setBounds(380, 210, 103, 25);
        add(signup);

        forgot_password = new JButton("Forgot Password");
        forgot_password.addActionListener(this);
        forgot_password.setForeground(Color.black);
        forgot_password.setBackground(new Color(247, 136, 18));
        forgot_password.setFont(new Font("Comic Sans MS", Font.BOLD, 13));
        forgot_password.setBounds(280, 251, 169, 30);
        add(forgot_password);
    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == login){
            try{
                User user = new User();
                boolean isValidUser = user.login(username_field.getText(), password_Field.getText());
                if (isValidUser) {
                    LoggedInUser.setUser(username_field.getText());
                    this.setVisible(false);
                    Loading load = new Loading();
                    load.setVisible(true);
                } else
                    JOptionPane.showMessageDialog(null, "Invalid Login...!.");
            }catch(Exception e){
                System.out.println(e.getMessage());
            }
        }
        if(ae.getSource() == signup){
            setVisible(false);
            SignUp signup = new SignUp();
            signup.setVisible(true);
        }
        if(ae.getSource() == forgot_password){
            setVisible(false);
            Forgot forgot = new Forgot();
            forgot.setVisible(true);
        }
    }
    public static void main(String[] args) {
        new LoginUser().setVisible(true);
    }
}


