package User;

import java.util.HashMap;
import java.util.Map;

public class UserDataLoader {
    
    // Map to store user data (Aggie ID as key, User object as value)
    private static Map<String, User> userDatabase = new HashMap<>();

    // Method to load user data into the user database map
    public static void loadUserData() {
        // Load user data from file or any other data source
        // Populate the user database map with user objects
        // Example:
        userDatabase.put("123456789", new User("123456789", "John Doe", true, "Faculty"));
        userDatabase.put("987654321", new User("987654321", "Jane Smith", false, ""));
        // You can load user data from a file using User.loadUserData(userDatabase);
    }

    // Getter method to access the user database map from other classes
    public static Map<String, User> getUserDatabase() {
        return userDatabase;
    }

    // Method to add a new user to the user database
    public static void addUser(User newUser) {
        userDatabase.put(newUser.getAggieID(), newUser);
        // Optionally, you can save the updated user data to a file here
    }


}
