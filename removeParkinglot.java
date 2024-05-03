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
        File file = new File("garicaLot22.txt");
        int[] garicaLot22 = new int[150];

        //adds the infomation to array
        garicaLot22 = ParkingLot.sendParkinglotInfo(file, garicaLot22);
        
        //Change the parking lot to avaible
        ParkingLot.changeParkingToAvaible(file, garicaLot22, currentNumSlot);
     }

     public static void removePinonLot27(User user,  Map<String, User> userDatabase,String currentPark, int currentNumSlot) {
        File file = new File("pinonLot27.txt");
        int[] pinonLot27 = new int[150];

        //adds the infomation to array
        pinonLot27 = ParkingLot.sendParkinglotInfo(file, pinonLot27);
        
        //Change the parking lot to avaible
        ParkingLot.changeParkingToAvaible(file, pinonLot27, currentNumSlot);
     }

     public static void removeODonaldParking55(User user,  Map<String, User> userDatabase,String currentPark, int currentNumSlot) {
        File file = new File("ODonaldLot55.txt");
        int[] oDonaldLot = new int[100];

        //adds the infomation to array
        oDonaldLot = ParkingLot.sendParkinglotInfo(file, oDonaldLot);
        
        //Change the parking lot to avaible
        ParkingLot.changeParkingToAvaible(file, oDonaldLot, currentNumSlot);
     }

     public static void removeBookstoreLot16(User user,  Map<String, User> userDatabase,String currentPark, int currentNumSlot) {
        File file = new File("BookstoreLot16.txt");
        int[] bookstoreLot = new int[100];

        //adds the infomation to array
        bookstoreLot = ParkingLot.sendParkinglotInfo(file, bookstoreLot);
        
        //Change the parking lot to avaible
        ParkingLot.changeParkingToAvaible(file, bookstoreLot, currentNumSlot);
     }

     public static void removeTrackLot100S(User user,  Map<String, User> userDatabase,String currentPark, int currentNumSlot) {
        File file = new File("TrackLot100S.txt");
        int[] trackLot = new int[100];

        //adds the infomation to array
        trackLot = ParkingLot.sendParkinglotInfo(file, trackLot);
        
        //Change the parking lot to avaible
        ParkingLot.changeParkingToAvaible(file, trackLot, currentNumSlot);
     }

     public static void removeSatelliteLot100(User user,  Map<String, User> userDatabase,String currentPark, int currentNumSlot) {
        File file = new File("SatelliteLot100.txt");
        int[] satelliteLot = new int[100];

        //adds the infomation to array
        satelliteLot = ParkingLot.sendParkinglotInfo(file, satelliteLot);
        
        //Change the parking lot to avaible
        ParkingLot.changeParkingToAvaible(file, satelliteLot, currentNumSlot);
     }

     public static void removeRentFrowLot48(User user,  Map<String, User> userDatabase,String currentPark, int currentNumSlot) {
        File file = new File("RentFrowLot48.txt");
        int[] rentFrowLot = new int[100];

        //adds the infomation to array
        rentFrowLot = ParkingLot.sendParkinglotInfo(file, rentFrowLot);
        
        //Change the parking lot to avaible
        ParkingLot.changeParkingToAvaible(file, rentFrowLot, currentNumSlot);
     }

     public static void removeSkeensLot4(User user,  Map<String, User> userDatabase,String currentPark, int currentNumSlot) {
        File file = new File("SkeensLot4.txt");
        int[] skeensLot = new int[100];

        //adds the infomation to array
        skeensLot = ParkingLot.sendParkinglotInfo(file, skeensLot);
        
        //Change the parking lot to avaible
        ParkingLot.changeParkingToAvaible(file, skeensLot, currentNumSlot);
     }

     public static void removeChamisaVillageLot38(User user,  Map<String, User> userDatabase,String currentPark, int currentNumSlot) {
        File file = new File("ChamisaVillageLot38.txt");
        int[] chamisaVillageLot = new int[100];

        //adds the infomation to array
        chamisaVillageLot = ParkingLot.sendParkinglotInfo(file, chamisaVillageLot);
        
        //Change the parking lot to avaible
        ParkingLot.changeParkingToAvaible(file, chamisaVillageLot, currentNumSlot);
     }

     public static void removeHorseshoeLot(User user,  Map<String, User> userDatabase,String currentPark, int currentNumSlot) {
        File file = new File("HorseshoeLot.txt");
        int[] horseshoeLot = new int[100];

        //adds the infomation to array
        horseshoeLot = ParkingLot.sendParkinglotInfo(file, horseshoeLot);
        
        //Change the parking lot to avaible
        ParkingLot.changeParkingToAvaible(file, horseshoeLot, currentNumSlot);
     }

     public static void removeScienceHallLot58(User user,  Map<String, User> userDatabase,String currentPark, int currentNumSlot) {
        File file = new File("ScienceHallLot58.txt");
        int[] scienceHallLot = new int[100];

        //adds the infomation to array
        scienceHallLot = ParkingLot.sendParkinglotInfo(file, scienceHallLot);
        
        //Change the parking lot to avaible
        ParkingLot.changeParkingToAvaible(file, scienceHallLot, currentNumSlot); 
     }

     public static void removeCorbettLot17(User user,  Map<String, User> userDatabase,String currentPark, int currentNumSlot) {
        File file = new File("CorbettLot17.txt");
        int[] corbettLot = new int[100];

        //adds the infomation to array
        corbettLot = ParkingLot.sendParkinglotInfo(file, corbettLot);
        
        //Change the parking lot to avaible
        ParkingLot.changeParkingToAvaible(file, corbettLot, currentNumSlot);  
     }

     public static void removeLibarayLot45(User user,  Map<String, User> userDatabase,String currentPark, int currentNumSlot) {
        File file = new File("LibraryLot45.txt");
        int[] libraryLot = new int[100];

        //adds the infomation to array
        libraryLot = ParkingLot.sendParkinglotInfo(file, libraryLot);
        
        //Change the parking lot to avaible
        ParkingLot.changeParkingToAvaible(file, libraryLot, currentNumSlot);  
     }
 
    
}
