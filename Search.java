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
        scanner.close();
     }

  
     public static void searchJuniperLot19(User user,  Map<String, User> userDatabase){
        System.out.println("Hello welcome to the  Searching Juniper parking lot");
        File file = new File("juniperLot.txt");
        int[] juniperLot = new int[250];
        int parkingSlotNum = 1;

        //If the file exits that will just read the text file
        if (file.exists()) {
            try (Scanner fileScanner = new Scanner(file)) {

                //This scan the file and and input in the array
                while (fileScanner.hasNextLine()) {
                    String line = fileScanner.nextLine();
                    String[] parts = line.split(",");
                    //reads if the parts in the file then input in the array
                    if (parts.length == 2) {
                        int i = Integer.parseInt(parts[0]);
                        int available = Integer.parseInt(parts[1]);
                        juniperLot[i-1] = available;
                    }//end of if
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }

        //Send if the text file is blank then create a new parking lot and send to the txt file
        else if (!file.exists()) {   
            juniperLot = ParkingLot.createParkingLot(juniperLot);
            try (PrintWriter writer = new PrintWriter(new FileWriter("juniperLot.txt"))) {
                //input the parking Number and avaiable in txt file
                for(int i = 0; i < juniperLot.length; i++){
                    writer.println( parkingSlotNum + "," + juniperLot[i]);
                    parkingSlotNum++;
                }//end of for
            } catch (IOException e) {
                e.printStackTrace();
            }//end of catch
        }//end of else

        ParkingLot.displayAvaible(juniperLot);
        NMSUEZParking.main(null);
     }
    
     public static void searchGaricaLot23(User user,  Map<String, User> userDatabase){

     }
    
     public static void searchGaricaLot22(User user,  Map<String, User> userDatabase){

     }
  
     public static void searchPinonLot27(User user,  Map<String, User> userDatabase){

     }
    
     public static void searchTrackLot100S(User user,  Map<String, User> userDatabase){

     }
    
     public static void searchODonaldParking55(User user,  Map<String, User> userDatabase){

     }
     
     public static void searchBookstoreLot16(User user,  Map<String, User> userDatabase){

     }
     
     public static void searchSatelliteLot100(User user,  Map<String, User> userDatabase){

     }
    
     public static void searchRentFrowLot48(User user,  Map<String, User> userDatabase){

     }
 
     public static void searchSkeensLot4(User user,  Map<String, User> userDatabase){

     }
   
     public static void searchChamisaVillageLot38(User user,  Map<String, User> userDatabase){

     }
   
     public static void searchHorseshoeLot(User user,  Map<String, User> userDatabase){

     }
    
     public static void searchScienceHallLot58(User user,  Map<String, User> userDatabase){

     }
     
     public static void searchCorbettLot17(User user,  Map<String, User> userDatabase){

     }

     public static void searchLibarayLot45(User user,  Map<String, User> userDatabase){

     }
}
