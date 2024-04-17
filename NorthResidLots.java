import java.util.Scanner;
import java.io.*;
import java.io.File;
// import java.util.HashMap;
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
                        trackLot100S(user, userDatabase);
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
                        return;
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
        int parkingSlotNum = 1;
        int[] juniperLot = new int[250]; 

        File file = new File("juniperLot.txt");

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
        else {   
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
        System.out.println("Which parking do you want to park?");
        int userCount = scanner.nextInt();

        //Asking user to input the correct parking number
        while(userCount > juniperLot.length || userCount < 0 || juniperLot[userCount-1] == 1){
            System.out.println("The parking number is invaild please entered new parking spot");
            System.out.println();
            System.out.println();
            ParkingLot.displayAvaible(juniperLot);
            userCount = scanner.nextInt();
        }

        //If the user input the correct parking then read the file until find the parking number in the file.
        //It will change the number to 1 (Unavaible) in the array
        //delete the whole file then reprint the whole
        if(userCount < juniperLot.length || userCount > 0 || juniperLot[userCount-1] == 0){
            try (Scanner fileScanner = new Scanner(file)) {

                //This scan the file and and input in the array
                while (fileScanner.hasNextLine()) {
                    String line = fileScanner.nextLine();
                    String[] parts = line.split(",");
                    if (parts.length == 2) {
                        int i = Integer.parseInt(parts[0]);
                        // System.out.println("The slot number: " + i + " available " + juniperLot[i-1]);
                      
                        if (userCount == i){
                           juniperLot[i - 1] = 1;
                            file.delete();
                            try (PrintWriter writer = new PrintWriter(new FileWriter("juniperLot.txt"))) {
                                for(int j = 0; j < juniperLot.length; j++){
                                    writer.println( parkingSlotNum + "," + juniperLot[j]);
                                    parkingSlotNum++;
                                }
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }//end of inner if
                    }//end of out if
                }//end of while
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
        user.setCurrentParkAt("Juniper Lot");
        user.setCurrentParkNumAt(userCount);

        System.out.println(user);
        String aggieID = user.getAggieID();
        userDatabase.replace(aggieID, user);
        System.out.println(userDatabase);
        User.changeUserInfo(user, userDatabase);


       
        scanner.close();
    }

    public static void garicaLot23(User user, Map<String, User> userDatabase){
        System.out.println("Hello welcome to the Front Garica parking lot");
    }

    public static void garicaLot22(User user, Map<String, User> userDatabase){
        System.out.println("Hello welcome to the Back Garica parking lot");
    }
    
    public static void pinonLot27(User user, Map<String, User> userDatabase){
        System.out.println("Hello welcome to the Pinon parking lot");  
    }

    public static void trackLot100S(User user, Map<String, User> userDatabase){
        System.out.println("Hello welcome to the Track parking lot");  
    }
}
