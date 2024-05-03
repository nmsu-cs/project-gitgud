import java.io.*;
import java.util.*;

public class Search {
    public static void SearchParkingLot(User user,  Map<String, User> userDatabase){
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("\nThank you for Logging in, How can we help you?");
        System.out.println("1. Juniper Lot"); 
        System.out.println("2. Garica Lot 23");
        System.out.println("3. Garica Lot 22");
        System.out.println("4. Pinon Lot");
        System.out.println("5. Track Lot 100S"); 
        System.out.println("6. O'Donald Lot");
        System.out.println("7. Bookstore Lot");
        System.out.println("8. Satellite Lot");
        System.out.println("9. Rent Frow Lot"); 
        System.out.println("10. Skeens Lot");
        System.out.println("11. Chamisa Village Lot");
        System.out.println("12. Horseshoe Lot");
        System.out.println("13. Science Hall lot");
        System.out.println("14. Corbett lot");
        System.out.println("15. Zuhl Libaray lot");
        System.out.println("16. Exit to Main Menu");
        System.out.print("Please select an option (1-16): ");
        String choice = scanner.nextLine().trim();

        switch (choice) {
            case "1":
                searchJuniperLot19(user, userDatabase);
                break;

            case "2":
                searchGaricaLot23(user, userDatabase);
                break;

            case "3":
                searchGaricaLot22(user, userDatabase);
                break;

            case "4":
                searchPinonLot27(user, userDatabase);
                break;

            case "5":
                searchTrackLot100S(user, userDatabase);
                break;

            case "6":
                searchODonaldParking55(user, userDatabase);
                break;

            case "7":
                searchBookstoreLot16(user, userDatabase);
                break;

            case "8":
                searchSatelliteLot100(user, userDatabase);
                break;

            case "9":
                searchRentFrowLot48(user, userDatabase);
                break;

            case "10":
                searchSkeensLot4(user, userDatabase);
                break;

            case "11":
                searchChamisaVillageLot38(user, userDatabase);
                break;

            case "12":
                searchHorseshoeLot(user, userDatabase);
                break; 

             case "13":
                searchScienceHallLot58(user, userDatabase);
                break;

            case "14":
                searchCorbettLot17(user, userDatabase);
                break;

            case "15":
                searchLibarayLot45(user, userDatabase);
                break;

            case "16":
                System.out.println("Exiting to main menu...");
                System.out.println();
                System.out.println();
                NMSUEZParking.main(null);
                break; 
            
            default:
                System.out.println("Invalid option. Please select a number between 1 and 9.");
                break;
        }
        
        NMSUEZParking.showUserMenu(scanner, userDatabase, user.getAggieID() , user);
        scanner.close();
     }

  
     public static void searchJuniperLot19(User user,  Map<String, User> userDatabase){
        System.out.println("Hello welcome to the  Searching Juniper parking lot");
        File file = new File("juniperLot.txt");
        int[] juniperLot = new int[250];

        //get the parking Information
        juniperLot = ParkingLot.sendParkinglotInfo(file, juniperLot);

        //Display parking infomation
        ParkingLot.displayAvailable(juniperLot);
     }
    

     public static void searchGaricaLot23(User user,  Map<String, User> userDatabase){
        System.out.println("Hello welcome to the  Searching Garcia 23 parking lot");
        File file = new File("garicaLot23.txt");
        int[] garicaLot23 = new int[100];

        //get the parking Information
        garicaLot23 = ParkingLot.sendParkinglotInfo(file, garicaLot23);

        //Display parking infomation
        ParkingLot.displayAvailable(garicaLot23);
     }
    

     public static void searchGaricaLot22(User user,  Map<String, User> userDatabase){
        System.out.println("Hello welcome to the  Searching Garcia 22 parking lot");
        File file = new File("garicaLot22.txt");
        int[] garicaLot22 = new int[150];

        //get the parking Information
        garicaLot22 = ParkingLot.sendParkinglotInfo(file, garicaLot22);

        //Display parking infomation
        ParkingLot.displayAvailable(garicaLot22);
     }


     public static void searchPinonLot27(User user,  Map<String, User> userDatabase){
        System.out.println("Hello welcome to the  Searching Pinon 27 parking lot");
        File file = new File("pinonLot27.txt");
        int[] pinonLot27 = new int[400];

        //get the parking Information
        pinonLot27 = ParkingLot.sendParkinglotInfo(file, pinonLot27);

        //Display parking infomation
        ParkingLot.displayAvailable(pinonLot27);
     }
    

     public static void searchTrackLot100S(User user,  Map<String, User> userDatabase){
        System.out.println("Hello welcome to the  Searching Track parking lot");
        File file = new File("TrackLot100S.txt");
        int[] trackLot= new int[100];

        //get the parking Information
        trackLot = ParkingLot.sendParkinglotInfo(file, trackLot);

        //Display parking infomation
        ParkingLot.displayAvailable(trackLot);
     }
    

     public static void searchODonaldParking55(User user,  Map<String, User> userDatabase){
        System.out.println("Hello welcome to the  Searching O'Donald parking lot");
        File file = new File("ODonaldLot55.txt");
        int[] oDonaldLot= new int[100];

        //get the parking Information
        oDonaldLot = ParkingLot.sendParkinglotInfo(file, oDonaldLot);

        //Display parking infomation
        ParkingLot.displayAvailable(oDonaldLot);
     }
     

     public static void searchBookstoreLot16(User user,  Map<String, User> userDatabase){
        System.out.println("Hello welcome to the  Searching Bookstore parking lot");
        File file = new File("BookstoreLot16.txt");
        int[] bookstoreLot= new int[100];

        //get the parking Information
        bookstoreLot = ParkingLot.sendParkinglotInfo(file, bookstoreLot);

        //Display parking infomation
        ParkingLot.displayAvailable(bookstoreLot);
     }
     

     public static void searchSatelliteLot100(User user,  Map<String, User> userDatabase){
        System.out.println("Hello welcome to the  Searching Satellite Lot 100 parking lot");
        File file = new File("SatelliteLot100.txt");
        int[] satelliteLot = new int[100];

        //get the parking Information
        satelliteLot = ParkingLot.sendParkinglotInfo(file, satelliteLot);

        //Display parking infomation
        ParkingLot.displayAvailable(satelliteLot);

     }
    

     public static void searchRentFrowLot48(User user,  Map<String, User> userDatabase){
        System.out.println("Hello welcome to the  Searching Rent Frow parking lot");
        File file = new File("RentFrowLot48.txt");
        int[] rentFrowLot  = new int[100];

        //get the parking Information
        rentFrowLot  = ParkingLot.sendParkinglotInfo(file, rentFrowLot );

        //Display parking infomation
        ParkingLot.displayAvailable(rentFrowLot );

     }
 

     public static void searchSkeensLot4(User user,  Map<String, User> userDatabase){
        System.out.println("Hello welcome to the  Searching Skeens parking lot");
        File file = new File("SkeensLot4.txt");
        int[] skeensLot  = new int[100];

        //get the parking Information
        skeensLot  = ParkingLot.sendParkinglotInfo(file, skeensLot );

        //Display parking infomation
        ParkingLot.displayAvailable(skeensLot );

     }
   
     public static void searchChamisaVillageLot38(User user,  Map<String, User> userDatabase){
        System.out.println("Hello welcome to the  Searching Chamisa Village parking lot");
        File file = new File("ChamisaVillageLot38.txt");
        int[] chamisaVillageLot = new int[100];

        //get the parking Information
        chamisaVillageLot = ParkingLot.sendParkinglotInfo(file, chamisaVillageLot );

        //Display parking infomation
        ParkingLot.displayAvailable(chamisaVillageLot );
     }
   
     public static void searchHorseshoeLot(User user,  Map<String, User> userDatabase){
        System.out.println("Hello welcome to the  Searching Horseshoe parking lot");
        File file = new File("HorseshoeLot.txt");
        int[] horseshoeLot = new int[100];

        //get the parking Information
        horseshoeLot = ParkingLot.sendParkinglotInfo(file, horseshoeLot );

        //Display parking infomation
        ParkingLot.displayAvailable(horseshoeLot );
     }
    
     public static void searchScienceHallLot58(User user,  Map<String, User> userDatabase){
        System.out.println("Hello welcome to the  Searching Science Hall parking lot");
        File file = new File("ScienceHallLot58.txt");
        int[] scienceHallLot = new int[100];

        //get the parking Information
        scienceHallLot = ParkingLot.sendParkinglotInfo(file, scienceHallLot);

        //Display parking infomation
        ParkingLot.displayAvailable(scienceHallLot );
     }
     
     public static void searchCorbettLot17(User user,  Map<String, User> userDatabase){
        System.out.println("Hello welcome to the  Searching Corbett parking lot");
        File file = new File("CorbettLot17.txt");
        int[] corbettLot = new int[100];

        //get the parking Information
        corbettLot = ParkingLot.sendParkinglotInfo(file, corbettLot);

        //Display parking infomation
        ParkingLot.displayAvailable(corbettLot );
     }

     public static void searchLibarayLot45(User user,  Map<String, User> userDatabase){
        System.out.println("Hello welcome to the  Searching Zuhl Library parking lot");
        File file = new File("LibraryLot45.txt");
        int[] libraryLot  = new int[100];

        //get the parking Information
        libraryLot  = ParkingLot.sendParkinglotInfo(file, libraryLot);

        //Display parking infomation
        ParkingLot.displayAvailable(libraryLot);
     }
}
