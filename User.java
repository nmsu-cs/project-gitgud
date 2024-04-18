import java.util.Map;
import java.io.*;
import java.util.*;

public class User {
    private String aggieID;
    private String fullName;
    private boolean hasParkingPermit;
    private String parkingPermitType;
    private String currentParkAt;
    private int currentParkNumAt;

    public User(){
        aggieID = "";
        fullName = "";
        hasParkingPermit = false;
        parkingPermitType = "";
        currentParkAt = "";
        currentParkNumAt = 0;
    }

    public User(String aggieID,String fullName, boolean hasParkingPermit, String parkingPermitType, String currentParkAt, int currentParkNumAt) {
        this.aggieID = aggieID;
        this.fullName = fullName;
        this.hasParkingPermit = hasParkingPermit;
        this.parkingPermitType = parkingPermitType;
        this.currentParkAt = currentParkAt;
        this.currentParkNumAt = currentParkNumAt;
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

    public String getCurrentParkAt() {
        return currentParkAt;
    }

    public void setCurrentParkAt(String currentParkAt) {
        this.currentParkAt = currentParkAt;
    }

    public int getCurrentParkNumAt() {
        return currentParkNumAt;
    }

    public void setCurrentParkNumAt(int currentParkNumAt) {
        this.currentParkNumAt = currentParkNumAt;
    }


    @Override
    public String toString() {
        return fullName + "," + hasParkingPermit + "," + parkingPermitType + "," + currentParkAt + "," + currentParkNumAt;
    }

    //Change user information 
    public static void changeUserInfo(User user, Map<String, User> userDatabase){
        File file = new File("user_data.txt");
        String[] Database = new String[100000];
        int i = 0;

        if (file.exists()) {
            try (Scanner fileScanner = new Scanner(file)) {
                while (fileScanner.hasNextLine()) {
                    String line = fileScanner.nextLine();
                    String[] parts = line.split(",");
                    String aggieID = parts[0];
                    if(aggieID.equals(user.getAggieID()))
                        Database[i] = (user.getAggieID() + "," + user.getFullName() + "," + user.getHasParkingPermit()
                        + "," + user.getParkingPermitType() + "," + user.getCurrentParkAt() + "," + user.getCurrentParkNumAt());
                       
                    else 
                       Database[i] = line; 
                       
                    i++;
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
        file.delete();
        try (PrintWriter writer = new PrintWriter(new FileWriter("user_data.txt"))) {
            for (int p = 0; p < i; p++ ) {
                writer.println(Database[p]);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
