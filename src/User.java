import java.util.HashMap;
import java.util.Map;

public class User {
    private static final Map<String, User> users = new HashMap<>();
    private final String username;
    private final String password;
    private final boolean isAdmin;

    public User(String username, String password, boolean isAdmin) {
        this.username = username;
        this.password = password;
        this.isAdmin = isAdmin;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public static void addUser(String username, String password, boolean isAdmin) {
        if (!users.containsKey(username)) {
            User newUser = new User(username, password, isAdmin);
            users.put(username, newUser);
        }
    }

    public static Map<String, User> getUsers() {
        return users;
    }
}

