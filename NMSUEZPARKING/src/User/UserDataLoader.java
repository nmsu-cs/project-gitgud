package User;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class UserDataLoader {
    
    // Map to store user data (Aggie ID as key, User object as value)
    private static Map<String, User> userDatabase = new HashMap<>();

    // Method to load user data into the user database map
    public static void loadUserData(Map<String, User> userDatabase) {
        File file = new File("project-gitgud/user_data.txt");
        if (file.exists()) {
            try (Scanner fileScanner = new Scanner(file)) {
                while (fileScanner.hasNextLine()) {
                    String line = fileScanner.nextLine();
                    String[] parts = line.split(",");
                    if (parts.length == 4) {
                        String aggieID = parts[0];
                        String fullName = parts[1];
                        boolean hasParkingPermit = Boolean.parseBoolean(parts[2]);
                        String parkingPermitType = parts[3];
                        userDatabase.put(aggieID, new User(aggieID, fullName, hasParkingPermit, parkingPermitType));
                    }

                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
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
