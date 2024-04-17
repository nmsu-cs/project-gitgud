import java.util.Scanner;
import java.util.Map;

public class commuterLots {

    public static void printAvailableLotCOM(User user,  Map<String, User> userDatabase){
       try (Scanner scanner = new Scanner(System.in)) {
            while (true) {
                System.out.println("\nThank you for Finding Parking, Which parking do you want to park?");
                System.out.println("1. O'Donald Lot 55"); 
                System.out.println("2. Bookstore Lot 16");
                System.out.println("3. Track Lot 100S");
                System.out.println("4. Satellite Lot 100");
                System.out.println("5. Rent Frow Lot 48");
                System.out.println("6. Skeens Lot 4");
                System.out.println("7. Chamisa Village Lot 38");
                System.out.println("8. Horseshoe Lot");
                System.out.println("9. Exit to Main Menu");
                System.out.print("Please select an option (1-9): ");
                String choice = scanner.nextLine().trim();

                switch (choice) {
                    case "1":
                        //Send to ODonald Parking 55
                        ODonaldParking55(user, userDatabase);
                        break;
                    case "2":
                        //Send to Bookstore Lot 16
                        bookstoreLot16(user, userDatabase);
                        break;
                    case "3":
                        //Send to Track Lot 100S
                        trackLot100S(user, userDatabase);
                        break;
                    case "4":
                        //Send to Satellite Lot 100
                        allPermitLot.satelliteLot100(user, userDatabase);
                        break;
                    case "5":
                        //Send to Rent Frow Lot 48
                        allPermitLot.rentFrowLot48(user, userDatabase);
                        break;
                    case "6":
                        //Send to Skeens Lot 4
                        allPermitLot.skeensLot4(user, userDatabase);
                        break;
                    case "7":
                        //Send to Chamisa Village Lot 38
                        allPermitLot.chamisaVillageLot38(user, userDatabase);
                        break;
                    case "8":
                        //Send to Horseshoe Lot
                        allPermitLot.horseshoeLot(user, userDatabase);
                        break;
                    case "9":
                        System.out.println("Exiting to main menu...");
                        return;
                    default:
                        System.out.println("Invalid option. Please select a number between 1 and 9.");
                        break;
                }
            }
        }  

    }

    public static void ODonaldParking55(User user, Map<String, User> userDatabase){
        System.out.println("Hello welcome to the O'Donald parking lot");
    }

    public static void bookstoreLot16(User user,  Map<String, User> userDatabase){
        System.out.println("Hello welcome to the Bookstore parking lot");
    }

    public static void trackLot100S(User user,  Map<String, User> userDatabase){
        System.out.println("Hello welcome to the Track parking lot");

    }

    
}
