public class LoggedInUser {
    public static User user;
    public static User getUser() {
        return user;
    }
    public static void setUser(String username) {
        if (username.equals("Admin")) {
            user = new AdminUser();
        } else {
            user = new User();
        }
        user.setUsername(username);
    }
}
