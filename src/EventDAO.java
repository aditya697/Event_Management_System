import javax.swing.table.TableModel;
import java.sql.*;

public class EventDAO {
    Connection connection = DatabaseConnection.getConnection();

    public int addEvent(Event event) throws SQLException {
        PreparedStatement ps= connection.prepareStatement("insert into event(name,start_date,end_date,price,guestcount,contactno,description) values(?,?,?,?,?,?,?)");
        ps.setString(1,event.getEvent_name());
        Date date = Date.valueOf(event.getStart_date());
        ps.setDate(2, date);
        Date date1 = Date.valueOf(event.getEnd_date());
        ps.setDate(3, date1);
        ps.setInt(4,event.getPrice());
        ps.setInt(5,event.getGuestcount());
        ps.setInt(6, event.getContactno());
        ps.setString(7, event.getDescription());
        return ps.executeUpdate();
    }
    public TableModel getevents() throws SQLException{
        String sql = "select name,contactno,price,start_date,end_date,description from event";
        PreparedStatement st = connection.prepareStatement(sql);
        ResultSet rs = st.executeQuery();
        return DbUtils.resultSetToTableModel(rs);
    }
    public TableModel getevents(String name) throws SQLException{
        String sql = "select name,contactno,price,start_date,end_date,description from event where name like ?";
        PreparedStatement st = connection.prepareStatement(sql);
        st.setString(1, "%" + name + "%");
        ResultSet rs = st.executeQuery();
        return DbUtils.resultSetToTableModel(rs);
    }

    public int deleteevents(String event_id) throws SQLException {
        String sql = "delete from event_registration where event_id = ?";
        PreparedStatement st = connection.prepareStatement(sql);
        st.setInt(1, Integer.parseInt(event_id));
        return st.executeUpdate();
    }
    public int updateevents(String name) throws SQLException {
        String sql = "update event";
        PreparedStatement st = connection.prepareStatement(sql);
        st.setString(1, "%" + name + "%");
        return st.executeUpdate();
    }
    public int registerevents(int event_id,int numseats,int amount_paid) throws SQLException{
        String username = LoggedInUser.getUser().getUsername();
        PreparedStatement ps = connection.prepareStatement("insert into event_registration(event_id,username,numseats,amount_paid) values(?,?,?,?)");
        ps.setInt(1,event_id);
        ps.setString(2,username);
        ps.setInt(3,numseats);
        ps.setInt(4,amount_paid);
        return ps.executeUpdate();
    }

    public TableModel getupcomingevents(String name) throws SQLException{
        String sql = "select id,name,contactno,price,start_date,end_date,description from event where name like ? and start_date > CURRENT_TIMESTAMP";
        PreparedStatement st = connection.prepareStatement(sql);
        st.setString(1, "%" + name + "%");
        ResultSet rs = st.executeQuery();
        return DbUtils.resultSetToTableModel(rs);
    }
    public TableModel registeredevents(String eventname) throws SQLException{
        String username = LoggedInUser.getUser().getUsername();
        String sql = "select name, username, numseats, amount_paid, registration_date from event_registration, event where event.id = event_registration.event_id and username like ? and name like ?";
        PreparedStatement st = connection.prepareStatement(sql);
        st.setString(1, "%" + username + "%");
        st.setString(2, "%" + eventname + "%");
        ResultSet rs = st.executeQuery();
        return DbUtils.resultSetToTableModel(rs);
    }
    public TableModel allregisteredevents() throws SQLException{
        String sql = "select * from event_registration";
        PreparedStatement st = connection.prepareStatement(sql);
        ResultSet rs = st.executeQuery();
        return DbUtils.resultSetToTableModel(rs);
    }
    public TableModel getcurrentevents(String name) throws SQLException{
        String sql = "select name,contactno,price,guestcount,start_date,end_date,description " +
                "from event where name like ? and start_date < CURRENT_TIMESTAMP and end_date > CURRENT_TIMESTAMP";
        PreparedStatement st = connection.prepareStatement(sql);
        st.setString(1, "%" + name + "%");
        ResultSet rs = st.executeQuery();
        return DbUtils.resultSetToTableModel(rs);
    }
    public TableModel getoldevents(String name) throws SQLException{
        String sql = "select name,contactno,price,start_date,end_date from event where name like ? and end_date < CURRENT_TIMESTAMP";
        PreparedStatement st = connection.prepareStatement(sql);
        st.setString(1, "%" + name + "%");
        ResultSet rs = st.executeQuery();
        return DbUtils.resultSetToTableModel(rs);
    }
    public TableModel getcapacity(String name) throws SQLException{
        String sql = """
                select id, name, guestcount, end_date, sum(numseats), (guestcount - sum(numseats)) as remaining from event,event_registration
                where event.id = event_registration.event_id and event.name like ?
                group by id
                order by start_date""";
        PreparedStatement st = connection.prepareStatement(sql);
        st.setString(1, "%" + name + "%");
        ResultSet rs = st.executeQuery();
        return DbUtils.resultSetToTableModel(rs);
    }
}
