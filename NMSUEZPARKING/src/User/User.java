package User;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;
import java.util.Scanner;
import java.util.StringJoiner;

public class User {
    private String aggieID;
    private String fullName;
    private boolean hasParkingPermit;
    private String parkingPermitType;

    public User(String aggieID,String fullName, boolean hasParkingPermit, String parkingPermitType) {
        this.aggieID = aggieID;
        this.fullName = fullName;
        this.hasParkingPermit = hasParkingPermit;
        this.parkingPermitType = parkingPermitType;
    }
    public String getAggieID() {
        return aggieID;
    }

    public void setAggieID(String aggieID) {
        this.aggieID = aggieID;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public boolean getHasParkingPermit() {
        return hasParkingPermit;
    }

    public void setHasParkingPermit(boolean hasParkingPermit) {
        this.hasParkingPermit = hasParkingPermit;
    }

    public String getParkingPermitType() {
        return parkingPermitType;
    }
    public void setParkingPermitType(String parkingPermitType) {
        this.parkingPermitType = parkingPermitType;
    }

    @Override
    public String toString() {
        return fullName + "," + hasParkingPermit + "," + parkingPermitType;
    }

    // Method to loadUserData
    public static void loadUserData(Map<String, User> userDatabase) {
        File file = new File("user_data.txt");
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

    public String toCSV(){
        StringJoiner joiner = new StringJoiner(",");
        joiner.add(aggieID);
        joiner.add(fullName);
        joiner.add(Boolean.toString(hasParkingPermit));
        joiner.add(parkingPermitType);
        return joiner.toString();
    }

    // Saves user to file
    public static void saveUserToFile(User user, String filename) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename, true))) {
                    writer.write(user.toCSV());
                    writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }   


}