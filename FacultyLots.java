import java.util.Scanner;
import java.io.File;
import java.util.Map;

public class FacultyLots {
// Prints the menu for parking lot selection and handles user input to direct to the chosen lot.
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
                        System.out.println("Exiting to the main menu...\n\n");
                        NMSUEZParking.main(null);
                    default:
                        System.out.println("Invalid option. Please select a number between 1 and 10.");
                        break;
                }
            }
        }
    }

    // Method to manage parking in Science Hall Lot 58
    public static void scienceHallLot58(User user, Map<String, User> userDatabase){
        System.out.println("Hello, welcome to the Science Hall parking lot!");
        Scanner scanner = new Scanner(System.in);
        int[] scienceHallLot = new int[100]; // Adjust the size of the array as necessary
        String currentPark = user.getCurrentParkAt();
        String aggieID = user.getAggieID();
        File file = new File("ScienceHallLot58.txt");

        // Check if the user is currently registered in a parking spot.
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
                    scienceHallLot58(user, userDatabase); 
                    break;
            }
        } 
        else {
            // Collecting the data of parking lot
            scienceHallLot = ParkingLot.sendParkinglotInfo(file, scienceHallLot);
            ParkingLot.displayAvailable(scienceHallLot);
            System.out.println("Which parking spot do you want to park?");
            int userCount = scanner.nextInt();

            // Asking user to input the correct parking number
            while (userCount > scienceHallLot.length || userCount < 1 || scienceHallLot[userCount - 1] == 1) {
                System.out.println("The parking number is invalid. Please enter a new parking spot.\n\n");
                ParkingLot.displayAvailable(scienceHallLot);
                userCount = scanner.nextInt();
            }

            // Change the parking Info
            ParkingLot.changeParkingToUnavailable(file, scienceHallLot, userCount);

            // Change user Info
            user.setCurrentParkAt("Science Hall Lot 58");
            user.setCurrentParkNumAt(userCount);
            userDatabase.replace(aggieID, user);
            User.changeUserInfo(user, userDatabase);

            NMSUEZParking.showUserMenu(scanner, userDatabase, user.getAggieID(), user);
        }
        scanner.close();
    }

    // Method to manage parking in Corbett Lot 17
    public static void corbettLot17(User user, Map<String, User> userDatabase) {
        System.out.println("Hello, welcome to the Corbett parking lot!");
        Scanner scanner = new Scanner(System.in);
        int[] corbettLot = new int[100]; // Change the size of the array as necessary
        String currentPark = user.getCurrentParkAt();
        String aggieID = user.getAggieID();
        File file = new File("CorbettLot17.txt");

        // Check if the user is currently registered in a parking spot.
        if (!currentPark.equals("")) {
            System.out.println("You are currently registered as parked.");
            System.out.println("Do you want to park in a new parking spot? (yes/no)");
            String userInput = scanner.nextLine();

            switch (userInput) {
                case "yes":
                    System.out.println("You have chosen to park in a new parking spot.");
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
                    corbettLot17(user, userDatabase);
                    break;
            }
        } 
        else {
            // Collecting the data of parking lot
            corbettLot = ParkingLot.sendParkinglotInfo(file, corbettLot);
            ParkingLot.displayAvailable(corbettLot);
            System.out.println("Which parking spot do you want to park?");
            int userCount = scanner.nextInt();

            // Asking user to input the correct parking number
            while (userCount > corbettLot.length || userCount < 1 || corbettLot[userCount - 1] == 1) {
                System.out.println("The parking number is invalid. Please enter a new parking spot.\n\n");
                ParkingLot.displayAvailable(corbettLot);
                userCount = scanner.nextInt();
            }

            // Change the parking info
            ParkingLot.changeParkingToUnavailable(file, corbettLot, userCount);

            // Update user info
            user.setCurrentParkAt("Corbett Lot 17");
            user.setCurrentParkNumAt(userCount);
            userDatabase.replace(aggieID, user);
            User.changeUserInfo(user, userDatabase);

            NMSUEZParking.showUserMenu(scanner, userDatabase, user.getAggieID(), user);
        }
        scanner.close();
    }


    // Method to manage parking in Zuhl Library Lot 45
    public static void libarayLot45(User user, Map<String, User> userDatabase) {
        System.out.println("Hello, welcome to the Zuhl Library parking lot!");
        Scanner scanner = new Scanner(System.in);
        int[] libraryLot = new int[100]; // Change the size of the array as necessary
        String currentPark = user.getCurrentParkAt();
        String aggieID = user.getAggieID();
        File file = new File("LibraryLot45.txt");

        // Check if the user is currently registered in a parking spot.
        if (!currentPark.equals("")) {
            System.out.println("You are currently registered as parked.");
            System.out.println("Do you want to park in a new parking spot? (yes/no)");
            String userInput = scanner.nextLine();

            switch (userInput) {
                case "yes":
                    System.out.println("You have chosen to park in a new parking spot.");
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
                    libarayLot45(user, userDatabase);
                    break;
            }
        } 
        else {
            // Collecting the data of parking lot
            libraryLot = ParkingLot.sendParkinglotInfo(file, libraryLot);
            ParkingLot.displayAvailable(libraryLot);
            System.out.println("Which parking spot do you want to park?");
            int userCount = scanner.nextInt();

            // Asking user to input the correct parking number
            while (userCount > libraryLot.length || userCount < 1 || libraryLot[userCount - 1] == 1) {
                System.out.println("The parking number is invalid. Please enter a new parking spot.\n\n");
                ParkingLot.displayAvailable(libraryLot);
                userCount = scanner.nextInt();
            }

            // Change the parking info
            ParkingLot.changeParkingToUnavailable(file, libraryLot, userCount);

            // Update user info
            user.setCurrentParkAt("Zuhl Library Lot 45");
            user.setCurrentParkNumAt(userCount);
            userDatabase.replace(aggieID, user);
            User.changeUserInfo(user, userDatabase);

            NMSUEZParking.showUserMenu(scanner, userDatabase, user.getAggieID(), user);
        }
        scanner.close();
    }
}