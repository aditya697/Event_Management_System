import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnection {
    static Connection connection = null;

    public static void main(String[] args) {
        getConnection();
    }
    public static Connection getConnection() {
        if (connection!= null){
            return connection;
        }
        String host = "localhost";
        String port = "5432";
        String db_name = "EventManagement";
        String username = "postgres";
        String password = "aditya!2902";
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection("jdbc:postgresql://" + host + ":" + port + "/" + db_name + "", "" + username + "", "" + password + "");
            if (connection != null) {
                System.out.println("Connection OK");
            } else {
                System.out.println("Connection Failed");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return connection;
    }
}