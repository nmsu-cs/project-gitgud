import java.io.*;
import java.util.*;

public class removeParkinglot {

    public static void RemoveParkingLot(User user,  Map<String, User> userDatabase,String currentPark, int currentNumSlot){
    
        switch (currentPark) {
            case "Juniper Lot":
                removeJuniperLot19(user, userDatabase, currentPark, currentNumSlot);
                break;

            case "Garica Lot 23":
                removeGaricaLot23(user, userDatabase, currentPark, currentNumSlot);
                break;

            case "Garica Lot 22":
                removeGaricaLot22(user, userDatabase, currentPark, currentNumSlot);
                break;

            case "Pinon Lot":
                removePinonLot27(user, userDatabase, currentPark, currentNumSlot);
                break;

            case "Track Lot 100S":
                removeTrackLot100S(user, userDatabase, currentPark, currentNumSlot);
                break;

            case "O'Donald Lot":
                removeODonaldParking55(user, userDatabase, currentPark, currentNumSlot);
                break;

            case "Bookstore Lot":
                removeBookstoreLot16(user, userDatabase, currentPark, currentNumSlot);
                break;

            case "Satellite Lot":
                removeSatelliteLot100(user, userDatabase, currentPark, currentNumSlot);
                break;

            case "Rent Frow Lot":
                removeRentFrowLot48(user, userDatabase, currentPark, currentNumSlot);
                break;

            case "Skeens Lot":
                removeSkeensLot4(user, userDatabase, currentPark, currentNumSlot);
                break;

            case "Chamisa Village Lot":
                removeChamisaVillageLot38(user, userDatabase, currentPark, currentNumSlot);
                break;

            case "Horseshoe Lot":
                removeHorseshoeLot(user, userDatabase, currentPark, currentNumSlot);
                break; 

             case "Science Hall lot":
                removeScienceHallLot58(user, userDatabase, currentPark, currentNumSlot);
                break;

            case "Corbett lot":
                removeCorbettLot17(user, userDatabase, currentPark, currentNumSlot);
                break;

            case "Zuhl Libaray lot":
                removeLibarayLot45(user, userDatabase, currentPark, currentNumSlot);
                break; 
            
            default:
                System.out.println("Invalid option. Please select a number between 1 and 9.");
                break;
        }
     }

     public static void removeJuniperLot19(User user,  Map<String, User> userDatabase,String currentPark, int currentNumSlot) {
        File file = new File("juniperLot.txt");
        int[] juniperLot = new int[250];

        //adds the infomation to array
        juniperLot = ParkingLot.sendParkinglotInfo(file, juniperLot);
        
        //Change the parking lot to avaible
        ParkingLot.changeParkingToAvaible(file, juniperLot, currentNumSlot);
            
     }
     public static void removeGaricaLot23(User user,  Map<String, User> userDatabase,String currentPark, int currentNumSlot) {
        File file = new File("garicaLot23.txt");
        int[] garicaLot23 = new int[150];

        //adds the infomation to array
        garicaLot23 = ParkingLot.sendParkinglotInfo(file, garicaLot23);
        
        //Change the parking lot to avaible
        ParkingLot.changeParkingToAvaible(file, garicaLot23, currentNumSlot);
            
     }
     public static void removeGaricaLot22(User user,  Map<String, User> userDatabase,String currentPark, int currentNumSlot) {
        
     }
     public static void removePinonLot27(User user,  Map<String, User> userDatabase,String currentPark, int currentNumSlot) {
        
     }
     public static void removeODonaldParking55(User user,  Map<String, User> userDatabase,String currentPark, int currentNumSlot) {
        
     }
     public static void removeBookstoreLot16(User user,  Map<String, User> userDatabase,String currentPark, int currentNumSlot) {
        
     }
     public static void removeTrackLot100S(User user,  Map<String, User> userDatabase,String currentPark, int currentNumSlot) {
        
     }
     public static void removeSatelliteLot100(User user,  Map<String, User> userDatabase,String currentPark, int currentNumSlot) {
        
     }
     public static void removeRentFrowLot48(User user,  Map<String, User> userDatabase,String currentPark, int currentNumSlot) {
        
     }
     public static void removeSkeensLot4(User user,  Map<String, User> userDatabase,String currentPark, int currentNumSlot) {
        
     }
     public static void removeChamisaVillageLot38(User user,  Map<String, User> userDatabase,String currentPark, int currentNumSlot) {
        
     }
     public static void removeHorseshoeLot(User user,  Map<String, User> userDatabase,String currentPark, int currentNumSlot) {
        
     }
     public static void removeScienceHallLot58(User user,  Map<String, User> userDatabase,String currentPark, int currentNumSlot) {
        
     }
     public static void removeCorbettLot17(User user,  Map<String, User> userDatabase,String currentPark, int currentNumSlot) {
        
     }
     public static void removeLibarayLot45(User user,  Map<String, User> userDatabase,String currentPark, int currentNumSlot) {
        
     }
 
    
}
