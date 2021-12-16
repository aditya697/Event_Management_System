import javax.swing.table.TableModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDAO {
    Connection connection = DatabaseConnection.getConnection();
    public boolean login(User user) throws SQLException {
        PreparedStatement ps= connection.prepareStatement("select * from account where username=? and password=?");
        ps.setString(1,user.getUsername());
        ps.setString(2,user.getPassword());
        ResultSet res = ps.executeQuery();
        return res.next();
    }

    public int signup(User user) throws SQLException {
        PreparedStatement ps = connection.prepareStatement("insert into account(username, name, password, sec_q, sec_ans) values(?, ?, ?, ?, ?)");
        ps.setString(1, user.getUsername());
        ps.setString(2, user.getName());
        ps.setString(3, user.getPassword());
        ps.setString(4, user.getSec_q());
        ps.setString(5, user.getSec_a());
        return ps.executeUpdate();
    }
    public User getUser(String username) throws SQLException {
        String sql = "select * from account where username=?";
        PreparedStatement st = connection.prepareStatement(sql);
        st.setString(1, username);
        ResultSet rs = st.executeQuery();
        User user = new User();
        user.setUsername(username);
        while (rs.next()) {
            user.setName(rs.getString("name"));
            user.setSec_q(rs.getString("sec_q"));
            user.setPassword(rs.getString("password"));
            user.setSec_a(rs.getString("sec_ans"));
        }
        return user;
    }

    public int updateUser(String username, String name, String password, String sec_a) throws SQLException {
        PreparedStatement ps = connection.prepareStatement("update account set name=?,password = ?,sec_ans = ? where username=?");
        ps.setString(4, username);
        ps.setString(1, name);
        ps.setString(2, password);
        ps.setString(3, sec_a);
        return ps.executeUpdate();
    }
    public TableModel getusers(String name) throws SQLException{
        String sql = "select * from account where username like ?";
        PreparedStatement st = connection.prepareStatement(sql);
        st.setString(1, "%" + name + "%");
        ResultSet rs = st.executeQuery();
        return DbUtils.resultSetToTableModel(rs);
    }
    public int deleteUser(String name) throws SQLException {
        String sql = "delete from account where username like ?";
        PreparedStatement st = connection.prepareStatement(sql);
        st.setString(1, "%" + name + "%");
        return st.executeUpdate();
    }
    public List getusernames() throws  SQLException{
        String sql = "select username from account";
        PreparedStatement st = connection.prepareStatement(sql);
        ResultSet rs = st.executeQuery();
        ArrayList names = new ArrayList();
        while (rs.next()) {
            names.add(rs.getString("username"));
        }
        return names;
    }
}
