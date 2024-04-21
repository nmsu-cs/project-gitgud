import java.util.Scanner;
import java.io.File;
import java.util.Map;

public class NorthResidLots {

    public static void printAvailableLotNR(User user, Map<String, User> userDatabase){
        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {
                System.out.println("\nThank you for Finding Parking, Which parking do you want to park?");
                System.out.println("1. Juniper Hall Lot 19"); 
                System.out.println("2. garcia Hall Lot 23");
                System.out.println("3. garcia Hall Lot 22 Behind Lot 23");
                System.out.println("4. Pinon Hall Lot 27");
                System.out.println("5. Track Lot 100S");
                System.out.println("6. Satellite Lot 100");
                System.out.println("7. Rent Frow Lot 48");
                System.out.println("8. Skeens Lot 4");
                System.out.println("9. Chamisa Village Lot 38");
                System.out.println("10. Horseshoe Lot");
                System.out.println("11. Exit to Main Menu");
                System.out.print("Please select an option (1-11): ");
                String choice = scanner.nextLine().trim();

                switch (choice) {
                    case "1":
                        //Send to Juniper Hall Lot 19 
                        juniperLot19(user, userDatabase);
                        break;
                    case "2":
                        //Send to garcia Hall Lot 23
                        garciaLot23(user, userDatabase);
                        break;
                    case "3":
                        //Send to garcia Hall Lot 22 Behind Lot 23
                        garciaLot22(user, userDatabase);
                        break;
                    case "4":
                        //Send to Pinon Hall Lot 27
                        pinonLot27(user, userDatabase);
                        break;
                    case "5":
                        //Send to Track Lot 100S
                        allPermitLot.trackLot100S(user, userDatabase);
                        break;
                    case "6":
                        //Send to Satellite Lot 100
                        allPermitLot.satelliteLot100(user, userDatabase);
                        break;
                    case "7":
                        //Send to Rent Frow Lot 48
                        allPermitLot.rentFrowLot48(user, userDatabase);
                        break;
                    case "8":
                        //Send to Skeens Lot 4
                        allPermitLot.skeensLot4(user, userDatabase);
                        break;
                    case "9":
                        //Send to Chamisa Village Lot 38
                        allPermitLot.chamisaVillageLot38(user, userDatabase);
                        break;
                    case "10":
                        //Send to Horseshoe Lot
                        allPermitLot.horseshoeLot(user, userDatabase);
                        break;
                    case "11":
                        System.out.println("Exiting to the main menu...\n\n");
                        NMSUEZParking.main(null);
                    default:
                        System.out.println("Invalid option. Please select a number between 1 and 11.");
                        break;
                }
            }
        }
    }


    //Purpose in this 
    public static void juniperLot19(User user, Map<String, User> userDatabase){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Hello, Welcome to the Juniper parking lot!");
        int[] juniperLot = new int[250];
        String currentPark = user.getCurrentParkAt();
        String aggieID = user.getAggieID();
        File file = new File("juniperLot.txt");
        
        //Check if the user is currently register in a parking spot.
        if(!currentPark.equals("")){
            System.out.println("You current registered as parked.");
            System.out.println("Do you want to park in a new Parking spot: (yes/no)");
            String userInput = scanner.nextLine();

            switch (userInput) {
                case "yes":
                    System.out.println("You have chose to parked in a new parking spot");
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
                    System.out.println("This is an invalid input. Please enter yes or no");
                    juniperLot19(user, userDatabase);
                    break;
            }
        }
        else {
            //Collecting the data of parkingLot
            juniperLot = ParkingLot.sendParkinglotInfo(file, juniperLot);
            ParkingLot.displayAvailable(juniperLot);
            System.out.println("Which parking spot do you want to park?");
            int userCount = scanner.nextInt();

            //Asking user to input the correct parking number
            while(userCount > juniperLot.length || userCount < 0 || juniperLot[userCount-1] == 1){
                System.out.println("The parking number is invalid. Please enter a new parking spot.\n\n");
                ParkingLot.displayAvailable(juniperLot);
                userCount = scanner.nextInt();
            }
            //Change the parking Info
            ParkingLot.changeParkingToUnavailable(file, juniperLot, userCount);
            
            //Change user Info
            user.setCurrentParkAt("Juniper Lot");
            user.setCurrentParkNumAt(userCount);
            userDatabase.replace(aggieID, user);
            User.changeUserInfo(user, userDatabase);

            NMSUEZParking.showUserMenu(scanner = new Scanner(System.in), userDatabase, user.getAggieID() , user);
            scanner.close();
        }//end of else
    }


    public static void garciaLot23(User user, Map<String, User> userDatabase){
        System.out.println("Hello, welcome to the Front Garcia parking lot!");
        Scanner scanner = new Scanner(System.in);
        int[] garciaLot23 = new int[100];
        String currentPark = user.getCurrentParkAt();
        String aggieID = user.getAggieID();
        File file = new File("garciaLot23.txt");
        
        //Check if the user is currently register in a parking spot.
        if(!currentPark.equals("")){
            System.out.println("You current registered as parked.");
            System.out.println("Do you want to park in a new Parking spot: (yes/no)");
            String userInput = scanner.nextLine();

            switch (userInput) {
                case "yes":
                    System.out.println("You have choice to parked in a new parking spot");
                    int numSlotParkedAt = user.getCurrentParkNumAt();
                    user.setCurrentParkAt("");
                    user.setCurrentParkNumAt(0);

                    userDatabase.replace(aggieID, user);
                    User.changeUserInfo(user, userDatabase);

                    removeParkinglot.RemoveParkingLot(user, userDatabase, currentPark, numSlotParkedAt);
                    break;
                case "no":
                    System.out.println("Thank you for your time! Have have choices no");
                    NMSUEZParking.main(null);
                break;
            
                default:
                    System.out.println("This is an invalid input. Please enter yes or no");
                    garciaLot23(user, userDatabase);
                    break;
            }
        }
        else{
            //Collecting the data of parkingLot
            garciaLot23 = ParkingLot.sendParkinglotInfo(file, garciaLot23);
           
            ParkingLot.displayAvailable(garciaLot23);
            System.out.println("Which parking do you want to park?");
            int userCount = scanner.nextInt();

            //Asking user to input the correct parking number
            while(userCount > garciaLot23.length || userCount < 0 || garciaLot23[userCount-1] == 1){
                System.out.println("The parking number is invalid. Please enter a new parking spot.\n\n");
                ParkingLot.displayAvailable(garciaLot23);
                userCount = scanner.nextInt();
            }
            //Change the parking Info
            ParkingLot.changeParkingToUnavailable(file, garciaLot23, userCount);
            
            //Change user Info
            user.setCurrentParkAt("garcia Lot 23");
            user.setCurrentParkNumAt(userCount);
            userDatabase.replace(aggieID, user);
            User.changeUserInfo(user, userDatabase);

            NMSUEZParking.showUserMenu(scanner = new Scanner(System.in), userDatabase, user.getAggieID() , user);
            scanner.close();
        }//end of else
    }


    public static void garciaLot22(User user, Map<String, User> userDatabase){
        System.out.println("Hello, welcome to the Back Garcia parking lot!");
        Scanner scanner = new Scanner(System.in);
        int[] garciaLot22 = new int[150];
        String currentPark = user.getCurrentParkAt();
        String aggieID = user.getAggieID();
        File file = new File("garciaLot22.txt");
        
        //Check if the user is currently register in a parking spot.
        if(!currentPark.equals("")){
            System.out.println("You current registered as parked.");
            System.out.println("Do you want to park in a new Parking spot: (yes/no)");
            String userInput = scanner.nextLine();

            switch (userInput) {
                case "yes":
                    System.out.println("You have choice to parked in a new parking spot");
                    int numSlotParkedAt = user.getCurrentParkNumAt();
                    user.setCurrentParkAt("");
                    user.setCurrentParkNumAt(0);

                    userDatabase.replace(aggieID, user);
                    User.changeUserInfo(user, userDatabase);

                    removeParkinglot.RemoveParkingLot(user, userDatabase, currentPark, numSlotParkedAt);
                    break;
                case "no":
                    System.out.println("Thank you for your time! Have have choices no");
                    NMSUEZParking.main(null);
                break;
            
                default:
                    System.out.println("This is an invalid input. Please enter yes or no");
                    garciaLot22(user, userDatabase);
                    break;
            }
        }
        else{
            //Collecting the data of parkingLot
            garciaLot22 = ParkingLot.sendParkinglotInfo(file, garciaLot22);
           
            ParkingLot.displayAvailable(garciaLot22);
            System.out.println("Which parking do you want to park?");
            int userCount = scanner.nextInt();

            //Asking user to input the correct parking number
            while(userCount > garciaLot22.length || userCount < 0 || garciaLot22[userCount-1] == 1){
                System.out.println("The parking number is invalid. Please enter a new parking spot.\n\n");
                ParkingLot.displayAvailable(garciaLot22);
                userCount = scanner.nextInt();
            }
            //Change the parking Info
            ParkingLot.changeParkingToUnavailable(file, garciaLot22, userCount);
            
            //Change user Info
            user.setCurrentParkAt("garcia Lot 22");
            user.setCurrentParkNumAt(userCount);
            userDatabase.replace(aggieID, user);
            User.changeUserInfo(user, userDatabase);

            NMSUEZParking.showUserMenu(scanner = new Scanner(System.in), userDatabase, user.getAggieID() , user);
            scanner.close();
        }//end of else
    }
    

    public static void pinonLot27(User user, Map<String, User> userDatabase){
        System.out.println("Hello, welcome to the Pinon parking lot!"); 
        Scanner scanner = new Scanner(System.in);
        int[] pinonLot27 = new int[400];
        String currentPark = user.getCurrentParkAt();
        String aggieID = user.getAggieID();
        File file = new File("pinonLot27.txt");
        
        //Check if the user is currently register in a parking spot.
        if(!currentPark.equals("")){
            System.out.println("You current registered as parked.");
            System.out.println("Do you want to park in a new Parking spot: (yes/no)");
            String userInput = scanner.nextLine();

            switch (userInput) {
                case "yes":
                    System.out.println("You have choice to parked in a new parking spot");
                    int numSlotParkedAt = user.getCurrentParkNumAt();
                    user.setCurrentParkAt("");
                    user.setCurrentParkNumAt(0);

                    userDatabase.replace(aggieID, user);
                    User.changeUserInfo(user, userDatabase);

                    removeParkinglot.RemoveParkingLot(user, userDatabase, currentPark, numSlotParkedAt);
                    break;
                case "no":
                    System.out.println("Thank you for your time! Have have choices no");
                    NMSUEZParking.main(null);
                break;
            
                default:
                    System.out.println("This is an invalid input. Please enter yes or no");
                    pinonLot27(user, userDatabase);
                    break;
            }
        }
        else{
            //Collecting the data of parkingLot
            pinonLot27 = ParkingLot.sendParkinglotInfo(file, pinonLot27);
           
            ParkingLot.displayAvailable(pinonLot27);
            System.out.println("Which parking do you want to park?");
            int userCount = scanner.nextInt();

            //Asking user to input the correct parking number
            while(userCount > pinonLot27.length || userCount < 0 || pinonLot27[userCount-1] == 1){
                System.out.println("The parking number is invalid. Please enter a new parking spot.\n\n");
                ParkingLot.displayAvailable(pinonLot27);
                userCount = scanner.nextInt();
            }
            //Change the parking Info
            ParkingLot.changeParkingToUnavailable(file, pinonLot27, userCount);
            
            //Change user Info
            user.setCurrentParkAt("pinon Lot 22");
            user.setCurrentParkNumAt(userCount);
            userDatabase.replace(aggieID, user);
            User.changeUserInfo(user, userDatabase);

            NMSUEZParking.showUserMenu(scanner = new Scanner(System.in), userDatabase, user.getAggieID() , user);
            scanner.close();
        }//end of else 
    }
}
