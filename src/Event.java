import javax.swing.table.TableModel;
import java.sql.SQLException;
import java.text.ParseException;

public class Event {
    private String event_name;
    private String start_date;
    private String end_date;
    private int price;
    private int guestcount;
    private int contactno;
    private String description;
    EventDAO eventDAO = new EventDAO();

    public String getEvent_name() {
        return event_name;
    }

    public void setEvent_name(String event_name) {
        this.event_name = event_name;
    }

    public String getStart_date() {
        return start_date;
    }

    public void setStart_date(String start_date) {
        this.start_date = start_date;
    }

    public String getEnd_date() {
        return end_date;
    }

    public void setEnd_date(String end_date) {
        this.end_date = end_date;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getGuestcount() {
        return guestcount;
    }

    public void setGuestcount(int guestcount) {
        this.guestcount = guestcount;
    }

    public int getContactno() {
        return contactno;
    }

    public void setContactno(int contactno) {
        this.contactno = contactno;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int AddEvent(String event_name, String start_date, String end_date, int contactno, int price, int guestcount,  String description) throws SQLException, ParseException {
        Event event = new Event();
        event.setEvent_name(event_name);
        event.setStart_date(start_date);
        event.setEnd_date(end_date);
        event.setPrice(price);
        event.setGuestcount(guestcount);
        event.setContactno(contactno);
        event.setDescription(description);
        return eventDAO.addEvent(event);
    }
    public TableModel getevents() throws SQLException{
        return eventDAO.getevents();
    }
    public TableModel getevents(String name) throws SQLException{
        return eventDAO.getevents(name);
    }
    public int deletevents(String event_id){
        try
        {
            return eventDAO.deleteevents(event_id);
        }
        catch (SQLException ex)
        {
            System.out.println(ex.getMessage());
        }
        return 0;
    }
    public int updatevents(String name){
        try
        {
            return eventDAO.updateevents(name);
        }
        catch (SQLException ex)
        {
            System.out.println(ex.getMessage());
        }
        return 0;
    }
    public int registerevents(int event_id,int numseats,int amount_paid) {
        try
        {
            return eventDAO.registerevents(event_id, numseats, amount_paid);
        }
        catch (SQLException ex)
        {
            System.out.println(ex.getMessage());
        }
        return 0;
    }
    public TableModel getupcomingevents(String name) throws SQLException{
        return eventDAO.getupcomingevents(name);
    }
    public TableModel registeredevents(String eventname) throws  SQLException{
        return eventDAO.registeredevents(eventname);
    }
    public TableModel getcurrentevents(String name) throws SQLException{
        return eventDAO.getcurrentevents(name);
    }
    public TableModel getoldevents(String name) throws SQLException{
        return eventDAO.getoldevents(name);
    }
    public TableModel getcapacity(String name) throws SQLException{
        return eventDAO.getcapacity(name);
    }
    public TableModel allregisteredevents() throws SQLException{
        return eventDAO.allregisteredevents();
    }
}

