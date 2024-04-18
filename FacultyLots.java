import java.util.Scanner;
import java.io.*;
import java.io.File;
// import java.util.HashMap;
import java.util.Map;

public class FacultyLots {
    public static void printAvailableLotFAC(User user, Map<String, User> userDatabase){
        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {
                System.out.println("\nThank you for Finding Parking, Which parking do you want to park?");
                System.out.println("1. Science Hall lot 58"); 
                System.out.println("2. Corbett lot 17");
                System.out.println("3. Zuhl Libaray lot 45");
                System.out.println("4. Track Lot 100S");
                System.out.println("5. Satellite Lot 100");
                System.out.println("6. Rent Frow Lot 48");
                System.out.println("7. Skeens Lot 4");
                System.out.println("8. Chamisa Village Lot 38");
                System.out.println("9. Horseshoe Lot");
                System.out.println("10. Exit to Main Menu");
                System.out.print("Please select an option (1-10): ");
                String choice = scanner.nextLine().trim();

                switch (choice) {
                    case "1":
                        //Send to Juniper Hall Lot 19 
                        scienceHallLot58(user, userDatabase);
                        break;
                    case "2":
                        //Send to Garica Hall Lot 23
                        corbettLot17(user, userDatabase);
                        break;
                    case "3":
                        //Send to Garica Hall Lot 22 Behind Lot 23
                        libarayLot45(user, userDatabase);
                        break;
                    case "4":
                        //Send to Track Lot 100S
                        allPermitLot.trackLot100S(user, userDatabase);
                        break;
                    case "5":
                        //Send to Satellite Lot 100
                        allPermitLot.satelliteLot100(user, userDatabase);
                        break;
                    case "6":
                        //Send to Rent Frow Lot 48
                        allPermitLot.rentFrowLot48(user, userDatabase);
                        break;
                    case "7":
                        //Send to Skeens Lot 4
                        allPermitLot.skeensLot4(user, userDatabase);
                        break;
                    case "8":
                        //Send to Chamisa Village Lot 38
                        allPermitLot.chamisaVillageLot38(user, userDatabase);
                        break;
                    case "9":
                        //Send to Horseshoe Lot
                        allPermitLot.horseshoeLot(user, userDatabase);
                        break;
                    case "10":
                        System.out.println("Exiting to main menu...");
                        System.out.println();
                        System.out.println();
                        NMSUEZParking.main(null);
                    default:
                        System.out.println("Invalid option. Please select a number between 1 and 10.");
                        break;
                }
            }
        }
    }

    //Purpose in this 
    public static void scienceHallLot58(User user, Map<String, User> userDatabase){
        System.out.println("Hello welcome to the Science Hall parking lot");
    }

    public static void corbettLot17(User user, Map<String, User> userDatabase){
        System.out.println("Hello welcome to the Corbett parking lot");
    }

    public static void libarayLot45(User user, Map<String, User> userDatabase){
        System.out.println("Hello welcome to the Zuhl Libaray parking lot");
    }
}
