import javax.swing.table.TableModel;
import java.sql.SQLException;
import java.util.List;

public class User {
    private String username;
    private String password;
    private String name;
    private String sec_q;
    private String sec_a;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSec_q() {
        return sec_q;
    }

    public void setSec_q(String sec_q) {
        this.sec_q = sec_q;
    }

    public String getSec_a() {
        return sec_a;
    }

    public void setSec_a(String sec_a) {
        this.sec_a = sec_a;
    }

    UserDAO userDAO = new UserDAO();

    public boolean login(String username, String password) throws SQLException {
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        return userDAO.login(user);
    }

    public int signup(String username,  String name, String password, String sec_q, String sec_a) throws SQLException {
        User user = new User();
        user.setUsername(username);
        user.setName(name);
        user.setPassword(password);
        user.setSec_q(sec_q);
        user.setSec_a(sec_a);
        return userDAO.signup(user);
    }
    public User getuser(String username) throws SQLException {
        return userDAO.getUser(username);
    }

    public int updateUser(String username, String name, String password, String sec_a) throws SQLException {
        return userDAO.updateUser(username, name, password, sec_a);
    }

    public int deleteuser(String username) throws SQLException{
        return userDAO.deleteUser(username);
    }
    public TableModel getusers(String name) throws SQLException{
        return userDAO.getusers(name);
    }
    public Boolean isAdmin() {
        return Boolean.FALSE;
    }

    public List getusernames() throws  SQLException{
        return userDAO.getusernames();
    }
}

