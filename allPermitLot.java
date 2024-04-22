import java.util.Scanner;
import java.io.File;
import java.util.Map;

public class allPermitLot {

    // Method to manage parking in Satellite Lot 100
    public static void satelliteLot100(User user, Map<String, User> userDatabase) {
        System.out.println("Hello, welcome to the Satellite parking lot!");
        Scanner scanner = new Scanner(System.in);
        int[] satelliteLot = new int[100]; // Adjust the size of the array as necessary
        String currentPark = user.getCurrentParkAt();
        String aggieID = user.getAggieID();
        File file = new File("SatelliteLot100.txt");

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
                    break;
                default:
                    System.out.println("Invalid input. Please enter 'yes' or 'no'.");
                    satelliteLot100(user, userDatabase);
                    break;
            }
        }
        else {
            // Collecting the data of parking lot
            satelliteLot = ParkingLot.sendParkinglotInfo(file, satelliteLot);
            ParkingLot.displayAvailable(satelliteLot);
            System.out.println("Which parking spot do you want to park?");
            int userCount = scanner.nextInt();

            // Asking user to input the correct parking number
            while (userCount > satelliteLot.length || userCount < 1 || satelliteLot[userCount - 1] == 1) {
                System.out.println("The parking number is invalid. Please enter a new parking spot.\n\n");
                ParkingLot.displayAvailable(satelliteLot);
                userCount = scanner.nextInt();
            }

            // Change the parking Info
            ParkingLot.changeParkingToUnavailable(file, satelliteLot, userCount);

            // Change user Info
            user.setCurrentParkAt("Satellite Lot 100");
            user.setCurrentParkNumAt(userCount);
            userDatabase.replace(aggieID, user);
            User.changeUserInfo(user, userDatabase);
        }
        scanner.close();
    }

    // Method to manage parking in Rent Frow Lot 48
    public static void rentFrowLot48(User user, Map<String, User> userDatabase) {
        System.out.println("Hello, welcome to the Rent Frow parking lot!");
        Scanner scanner = new Scanner(System.in);
        int[] rentFrowLot = new int[100]; // Adjust the size of the array as necessary
        String currentPark = user.getCurrentParkAt();
        String aggieID = user.getAggieID();
        File file = new File("RentFrowLot48.txt");
    
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
                    break;
                default:
                    System.out.println("Invalid input. Please enter 'yes' or 'no'.");
                    rentFrowLot48(user, userDatabase);
                    break;
            }
        } 
        else {
            // Collecting the data of parking lot
            rentFrowLot = ParkingLot.sendParkinglotInfo(file, rentFrowLot);
            ParkingLot.displayAvailable(rentFrowLot);
            System.out.println("Which parking spot do you want to park?");
            int userCount = scanner.nextInt();
    
            // Asking user to input the correct parking number
            while (userCount > rentFrowLot.length || userCount < 1 || rentFrowLot[userCount - 1] == 1) {
                System.out.println("The parking number is invalid. Please enter a new parking spot.\n\n");
                ParkingLot.displayAvailable(rentFrowLot);
                userCount = scanner.nextInt();
            }
    
            // Change the parking info
            ParkingLot.changeParkingToUnavailable(file, rentFrowLot, userCount);
    
            // Update user info
            user.setCurrentParkAt("Rent Frow Lot 48");
            user.setCurrentParkNumAt(userCount);
            userDatabase.replace(aggieID, user);
            User.changeUserInfo(user, userDatabase);
        }
        scanner.close();
    }
    
    // Method to manage parking in Skeens Lot 4
    public static void skeensLot4(User user, Map<String, User> userDatabase) {
        System.out.println("Hello, welcome to the Skeens parking lot!");
        Scanner scanner = new Scanner(System.in);
        int[] skeensLot = new int[100]; // Adjust the size of the array as necessary
        String currentPark = user.getCurrentParkAt();
        String aggieID = user.getAggieID();
        File file = new File("SkeensLot4.txt");

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
                    break;
                default:
                    System.out.println("Invalid input. Please enter 'yes' or 'no'.");
                    skeensLot4(user, userDatabase);
                    break;
            }
        } 
        else {
            // Collecting the data of parking lot
            skeensLot = ParkingLot.sendParkinglotInfo(file, skeensLot);
            ParkingLot.displayAvailable(skeensLot);
            System.out.println("Which parking spot do you want to park?");
            int userCount = scanner.nextInt();

            // Asking user to input the correct parking number
            while (userCount > skeensLot.length || userCount < 1 || skeensLot[userCount - 1] == 1) {
                System.out.println("The parking number is invalid. Please enter a new parking spot.\n\n");
                ParkingLot.displayAvailable(skeensLot);
                userCount = scanner.nextInt();
            }

            // Change the parking Info
            ParkingLot.changeParkingToUnavailable(file, skeensLot, userCount);

            // Change user Info
            user.setCurrentParkAt("Skeens Lot 4");
            user.setCurrentParkNumAt(userCount);
            userDatabase.replace(aggieID, user);
            User.changeUserInfo(user, userDatabase);
        }
        scanner.close();
    }

    // Method to manage parking in Horseshoe Lot
    public static void horseshoeLot(User user, Map<String, User> userDatabase) {
        System.out.println("Hello, welcome to the Horseshoe parking lot!");
        Scanner scanner = new Scanner(System.in);
        int[] horseshoeLot = new int[100]; // Adjust the size of the array as necessary
        String currentPark = user.getCurrentParkAt();
        String aggieID = user.getAggieID();
        File file = new File("HorseshoeLot.txt");

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
                    break;
                default:
                    System.out.println("Invalid input. Please enter 'yes' or 'no'.");
                    horseshoeLot(user, userDatabase);
                    break;
            }
        } 
        else {
            // Collecting the data of parking lot
            horseshoeLot = ParkingLot.sendParkinglotInfo(file, horseshoeLot);
            ParkingLot.displayAvailable(horseshoeLot);
            System.out.println("Which parking spot do you want to park?");
            int userCount = scanner.nextInt();

            // Asking user to input the correct parking number
            while (userCount > horseshoeLot.length || userCount < 1 || horseshoeLot[userCount - 1] == 1) {
                System.out.println("The parking number is invalid. Please enter a new parking spot.\n\n");
                ParkingLot.displayAvailable(horseshoeLot);
                userCount = scanner.nextInt();
            }

            // Change the parking Info
            ParkingLot.changeParkingToUnavailable(file, horseshoeLot, userCount);

            // Change user Info
            user.setCurrentParkAt("Horseshoe Lot");
            user.setCurrentParkNumAt(userCount);
            userDatabase.replace(aggieID, user);
            User.changeUserInfo(user, userDatabase);
        }
        scanner.close();
    }

    // Method to manage parking in Chamisa Village Lot 38
    public static void chamisaVillageLot38(User user, Map<String, User> userDatabase) {
        System.out.println("Hello, welcome to the Chamisa Village parking lot!");
        Scanner scanner = new Scanner(System.in);
        int[] chamisaVillageLot = new int[100]; // Adjust the size of the array as necessary
        String currentPark = user.getCurrentParkAt();
        String aggieID = user.getAggieID();
        File file = new File("ChamisaVillageLot38.txt");

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
                    break;
                default:
                    System.out.println("Invalid input. Please enter 'yes' or 'no'.");
                    chamisaVillageLot38(user, userDatabase);
                    break;
            }
        } 
        else {
            // Collecting the data of the parking lot
            chamisaVillageLot = ParkingLot.sendParkinglotInfo(file, chamisaVillageLot);
            ParkingLot.displayAvailable(chamisaVillageLot);
            System.out.println("Which parking spot do you want to park?");
            int userCount = scanner.nextInt();

            // Asking the user to input the correct parking number
            while (userCount > chamisaVillageLot.length || userCount < 1 || chamisaVillageLot[userCount - 1] == 1) {
                System.out.println("The parking number is invalid. Please enter a new parking spot.\n\n");
                ParkingLot.displayAvailable(chamisaVillageLot);
                userCount = scanner.nextInt();
            }

            // Change the parking information
            ParkingLot.changeParkingToUnavailable(file, chamisaVillageLot, userCount);

            // Update user information
            user.setCurrentParkAt("Chamisa Village Lot 38");
            user.setCurrentParkNumAt(userCount);
            userDatabase.replace(aggieID, user);
            User.changeUserInfo(user, userDatabase);
        }
        scanner.close();
    }

    // Method to manage parking in Track Lot 100S
    public static void trackLot100S(User user, Map<String, User> userDatabase) {
        System.out.println("Hello, welcome to the Track parking lot!");
        Scanner scanner = new Scanner(System.in);
        int[] trackLot = new int[100]; // Adjust the size of the array as necessary
        String currentPark = user.getCurrentParkAt();
        String aggieID = user.getAggieID();
        File file = new File("TrackLot100S.txt");

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
                    break;
                default:
                    System.out.println("Invalid input. Please enter 'yes' or 'no'.");
                    trackLot100S(user, userDatabase);
                    break;
            }
        } 
        else {
            // Collecting the data of the parking lot
            trackLot = ParkingLot.sendParkinglotInfo(file, trackLot);
            ParkingLot.displayAvailable(trackLot);
            System.out.println("Which parking spot do you want to park?");
            int userCount = scanner.nextInt();

            // Asking the user to input the correct parking number
            while (userCount > trackLot.length || userCount < 1 || trackLot[userCount - 1] == 1) {
                System.out.println("The parking number is invalid. Please enter a new parking spot.\n\n");
                ParkingLot.displayAvailable(trackLot);
                userCount = scanner.nextInt();
            }

            // Change the parking information
            ParkingLot.changeParkingToUnavailable(file, trackLot, userCount);

            // Update user information
            user.setCurrentParkAt("Track Lot 100S");
            user.setCurrentParkNumAt(userCount);
            userDatabase.replace(aggieID, user);
            User.changeUserInfo(user, userDatabase);
            scanner.close();
        }
    }
}
