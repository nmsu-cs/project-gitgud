import java.util.Scanner;
import java.io.File;
import java.util.Map;

public class NorthResidLots {

    public static void printAvailableLotNR(User user, Map<String, User> userDatabase){
        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {
                System.out.println("\nThank you for Finding Parking, Which parking do you want to park?");
                System.out.println("1. Juniper Hall Lot 19"); 
                System.out.println("2. Garica Hall Lot 23");
                System.out.println("3. Garica Hall Lot 22 Behind Lot 23");
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
                        //Send to Garica Hall Lot 23
                        garicaLot23(user, userDatabase);
                        break;
                    case "3":
                        //Send to Garica Hall Lot 22 Behind Lot 23
                        garicaLot22(user, userDatabase);
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
                        System.out.println("Exiting to main menu...");
                        System.out.println();
                        System.out.println();
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
        System.out.println("Hello welcome to the Juniper parking lot");
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
                    juniperLot19(user, userDatabase);
                    break;
            }
        }
        else{
            //Collecting the data of parkingLot
            juniperLot = ParkingLot.sendParkinglotInfo(file, juniperLot);
            ParkingLot.displayAvaible(juniperLot);
            System.out.println("Which parking spot do you want to park?");
            int userCount = scanner.nextInt();

            //Asking user to input the correct parking number
            while(userCount > juniperLot.length || userCount < 0 || juniperLot[userCount-1] == 1){
                System.out.println("The parking number is invaild please entered new parking spot");
                System.out.println();
                System.out.println();
                ParkingLot.displayAvaible(juniperLot);
                userCount = scanner.nextInt();
            }
            //Change the parking Info
            ParkingLot.changeParkingToUnavaible(file, juniperLot, userCount);
            
            //Change user Info
            user.setCurrentParkAt("Juniper Lot");
            user.setCurrentParkNumAt(userCount);
            userDatabase.replace(aggieID, user);
            User.changeUserInfo(user, userDatabase);

            NMSUEZParking.showUserMenu(scanner = new Scanner(System.in), userDatabase, user.getAggieID() , user);
            scanner.close();
        }//end of else
    }

    public static void garicaLot23(User user, Map<String, User> userDatabase){
        System.out.println("Hello welcome to the Front Garica parking lot");
        Scanner scanner = new Scanner(System.in);
        int[] garicaLot23 = new int[150];
        String currentPark = user.getCurrentParkAt();
        String aggieID = user.getAggieID();
        File file = new File("garicaLot23.txt");
        
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
                    garicaLot23(user, userDatabase);
                    break;
            }
        }
        else{
            //Collecting the data of parkingLot
            garicaLot23 = ParkingLot.sendParkinglotInfo(file, garicaLot23);
           
            ParkingLot.displayAvaible(garicaLot23);
            System.out.println("Which parking do you want to park?");
            int userCount = scanner.nextInt();

            //Asking user to input the correct parking number
            while(userCount > garicaLot23.length || userCount < 0 || garicaLot23[userCount-1] == 1){
                System.out.println("The parking number is invaild please entered new parking spot");
                System.out.println();
                System.out.println();
                ParkingLot.displayAvaible(garicaLot23);
                userCount = scanner.nextInt();
            }
            //Change the parking Info
            ParkingLot.changeParkingToUnavaible(file, garicaLot23, userCount);
            
            //Change user Info
            user.setCurrentParkAt("Garica Lot 23");
            user.setCurrentParkNumAt(userCount);
            userDatabase.replace(aggieID, user);
            User.changeUserInfo(user, userDatabase);

            scanner.close();
        }//end of else
    }

    public static void garicaLot22(User user, Map<String, User> userDatabase){
        System.out.println("Hello welcome to the Back Garica parking lot");
    }
    
    public static void pinonLot27(User user, Map<String, User> userDatabase){
        System.out.println("Hello welcome to the Pinon parking lot");  
    }
}
