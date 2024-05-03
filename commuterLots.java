import java.util.Scanner;
import java.io.File;
import java.util.Map;

public class commuterLots {
// Prints the menu for parking lot selection and handles user input to direct to the chosen lot.
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
                        allPermitLot.trackLot100S(user, userDatabase);
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
                        System.out.println("Exiting to the main menu...\n\n");
                        NMSUEZParking.main(null);
                    default:
                        System.out.println("Invalid option. Please select a number between 1 and 9.");
                        break;
                }
            }
        }  
    }

    // Method to manage parking in O'Donald Lot 55
    public static void ODonaldParking55(User user, Map<String, User> userDatabase) {
        System.out.println("Hello, welcome to the O'Donald parking lot!");
        Scanner scanner = new Scanner(System.in);
        int[] oDonaldLot = new int[100]; // Change the size of the array as necessary
        String currentPark = user.getCurrentParkAt();
        String aggieID = user.getAggieID();
        File file = new File("ODonaldLot55.txt");
    
        //Check if the user is currently register in a parking spot.
        if (!currentPark.equals("")) {
            System.out.println("You are currently registered as parked.");
            System.out.println("Do you want to park in a new parking spot? (yes/no)");
            String userInput = scanner.nextLine();
    
            switch (userInput) {
                case "yes":
                    System.out.println("You have chosen to park in a new parking spot");
                    int numSlotParkedAt = user.getCurrentParkNumAt();
                    user.setCurrentParkAt("");
                    user.setCurrentParkNumAt(0);
    
                    userDatabase.replace(aggieID, user);
                    User.changeUserInfo(user, userDatabase);
    
                    removeParkinglot.RemoveParkingLot(user, userDatabase, currentPark, numSlotParkedAt);
                    break;
                case "no":
                    System.out.println("Thank you for your time!");
                    NMSUEZParking.main(null);
                    break;
                default:
                    System.out.println("Invalid input. Please enter 'yes' or 'no'.");
                    ODonaldParking55(user, userDatabase);
                    break;
            }
        } 
        else {
            //Collecting the data of parkingLot
            oDonaldLot = ParkingLot.sendParkinglotInfo(file, oDonaldLot);
            ParkingLot.displayAvailable(oDonaldLot);
            System.out.println("Which parking spot do you want to park?");
            int userCount = scanner.nextInt();
    
            //Asking user to input the correct parking number
            while (userCount > oDonaldLot.length || userCount < 1 || oDonaldLot[userCount - 1] == 1) {
                System.out.println("The parking number is invalid. Please enter a new parking spot.\n\n");
                ParkingLot.displayAvailable(oDonaldLot);
                userCount = scanner.nextInt();
            }
    
            ParkingLot.changeParkingToUnavailable(file, oDonaldLot, userCount);
    
            user.setCurrentParkAt("O'Donald Lot 55");
            user.setCurrentParkNumAt(userCount);
            userDatabase.replace(aggieID, user);
            User.changeUserInfo(user, userDatabase);
    
            NMSUEZParking.showUserMenu(scanner, userDatabase, user.getAggieID(), user);
        }
        scanner.close();
    }    

    // Method to manage parking in Bookstore Lot 16
    public static void bookstoreLot16(User user, Map<String, User> userDatabase) {
        System.out.println("Hello, welcome to the Bookstore parking lot!");
        Scanner scanner = new Scanner(System.in);
        int[] bookstoreLot = new int[100]; // Change the size of the array as necessary
        String currentPark = user.getCurrentParkAt();
        String aggieID = user.getAggieID();
        File file = new File("BookstoreLot16.txt");
    
        //Check if the user is currently register in a parking spot.
        if (!currentPark.equals("")) {
            System.out.println("You are currently registered as parked.");
            System.out.println("Do you want to park in a new parking spot? (yes/no)");
            String userInput = scanner.nextLine();
    
            switch (userInput) {
                case "yes":
                    System.out.println("You have chosen to park in a new parking spot");
                    int numSlotParkedAt = user.getCurrentParkNumAt();
                    user.setCurrentParkAt("");
                    user.setCurrentParkNumAt(0);
    
                    userDatabase.replace(aggieID, user);
                    User.changeUserInfo(user, userDatabase);
    
                    removeParkinglot.RemoveParkingLot(user, userDatabase, currentPark, numSlotParkedAt);
                    break;
                case "no":
                    System.out.println("Thank you for your time!");
                    NMSUEZParking.main(null);
                    break;
                default:
                    System.out.println("Invalid input. Please enter 'yes' or 'no'.");
                    bookstoreLot16(user, userDatabase);
                    break;
            }
        } else {
            bookstoreLot = ParkingLot.sendParkinglotInfo(file, bookstoreLot);
            ParkingLot.displayAvailable(bookstoreLot);
            System.out.println("Which parking spot do you want to park?");
            int userCount = scanner.nextInt();
    
            while (userCount > bookstoreLot.length || userCount < 0 || bookstoreLot[userCount - 1] == 1) {
                System.out.println("The parking number is invalid. Please enter a new parking spot.\n\n");
                ParkingLot.displayAvailable(bookstoreLot);
                userCount = scanner.nextInt();
            }
    
            ParkingLot.changeParkingToUnavailable(file, bookstoreLot, userCount);
    
            user.setCurrentParkAt("Bookstore Lot 16");
            user.setCurrentParkNumAt(userCount);
            userDatabase.replace(aggieID, user);
            User.changeUserInfo(user, userDatabase);
    
            NMSUEZParking.showUserMenu(scanner, userDatabase, user.getAggieID(), user);
        }
        scanner.close();
    }
}