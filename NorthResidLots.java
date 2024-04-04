import java.util.Scanner;

public class NorthResidLots {

    public static void printAvailableLotNR(){
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
                        juniperLot19();
                        break;
                    case "2":
                        //Send to Garica Hall Lot 23
                        garicaLot23();
                        break;
                    case "3":
                        //Send to Garica Hall Lot 22 Behind Lot 23
                        garicaLot22();
                        break;
                    case "4":
                        //Send to Pinon Hall Lot 27
                        pinonLot27();
                        break;
                    case "5":
                        //Send to Track Lot 100S
                        trackLot100S();
                        break;
                    case "6":
                        //Send to Satellite Lot 100
                        allPermitLot.satelliteLot100();
                        break;
                    case "7":
                        //Send to Rent Frow Lot 48
                        allPermitLot.rentFrowLot48();
                        break;
                    case "8":
                        //Send to Skeens Lot 4
                        allPermitLot.skeensLot4();
                        break;
                    case "9":
                        //Send to Chamisa Village Lot 38
                        allPermitLot.chamisaVillageLot38();
                        break;
                    case "10":
                        //Send to Horseshoe Lot
                        allPermitLot.horseshoeLot();
                        break;
                    case "11":
                        System.out.println("Exiting to main menu...");
                        return;
                    default:
                        System.out.println("Invalid option. Please select a number between 1 and 11.");
                        break;
                }
            }
        }
    }

    public static void juniperLot19(){
        System.out.println("Hello welcome to the Juniper parking lot");
    }

    public static void garicaLot23(){
        System.out.println("Hello welcome to the Front Garica parking lot");
    }

    public static void garicaLot22(){
        System.out.println("Hello welcome to the Back Garica parking lot");
    }
    
    public static void pinonLot27(){
        System.out.println("Hello welcome to the Pinon parking lot");  
    }

    public static void trackLot100S(){
        System.out.println("Hello welcome to the Track parking lot");  
    }
}
