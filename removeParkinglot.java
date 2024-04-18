import java.io.*;
import java.util.*;

public class removeParkinglot {

    public static void RemoveParkingLot(User user,  Map<String, User> userDatabase,String currentPark, int currentNumSlot){
    
        switch (currentPark) {
            case "Juniper Lot":
                removeJuniperLot19(user, userDatabase, currentPark, currentNumSlot);
                break;

            case "Garica Lot 23":
                removeGaricaLot23(user, userDatabase, currentPark, currentNumSlot);
                break;

            case "Garica Lot 22":
                removeGaricaLot22(user, userDatabase, currentPark, currentNumSlot);
                break;

            case "Pinon Lot":
                removePinonLot27(user, userDatabase, currentPark, currentNumSlot);
                break;

            case "Track Lot 100S":
                removeTrackLot100S(user, userDatabase, currentPark, currentNumSlot);
                break;

            case "O'Donald Lot":
                removeODonaldParking55(user, userDatabase, currentPark, currentNumSlot);
                break;

            case "Bookstore Lot":
                removeBookstoreLot16(user, userDatabase, currentPark, currentNumSlot);
                break;

            case "Satellite Lot":
                removeSatelliteLot100(user, userDatabase, currentPark, currentNumSlot);
                break;

            case "Rent Frow Lot":
                removeRentFrowLot48(user, userDatabase, currentPark, currentNumSlot);
                break;

            case "Skeens Lot":
                removeSkeensLot4(user, userDatabase, currentPark, currentNumSlot);
                break;

            case "Chamisa Village Lot":
                removeChamisaVillageLot38(user, userDatabase, currentPark, currentNumSlot);
                break;

            case "Horseshoe Lot":
                removeHorseshoeLot(user, userDatabase, currentPark, currentNumSlot);
                break; 

             case "Science Hall lot":
                removeScienceHallLot58(user, userDatabase, currentPark, currentNumSlot);
                break;

            case "Corbett lot":
                removeCorbettLot17(user, userDatabase, currentPark, currentNumSlot);
                break;

            case "Zuhl Libaray lot":
                removeLibarayLot45(user, userDatabase, currentPark, currentNumSlot);
                break; 
            
            default:
                System.out.println("Invalid option. Please select a number between 1 and 9.");
                break;
        }
     }

     public static void removeJuniperLot19(User user,  Map<String, User> userDatabase,String currentPark, int currentNumSlot) {
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
            System.out.println("Parking lot was restarted");
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

        //If the user input the correct parking then read the file until find the parking number in the file.
            //It will change the number to 1 (Unavaible) in the array
            //delete the whole file then reprint the whole
            if(file.exists()){
                try (Scanner fileScanner = new Scanner(file)) {
                    parkingSlotNum = 1;

                    //This scan the file and and input in the array
                    while (fileScanner.hasNextLine()) {
                        String line = fileScanner.nextLine();
                        String[] parts = line.split(",");
                        if (parts.length == 2) {
                            int i = Integer.parseInt(parts[0]);
                            // System.out.println("The slot number: " + i + " available " + juniperLot[i-1]);
                        
                            if (currentNumSlot == parkingSlotNum){
                            juniperLot[i - 1] = 0;
                            parkingSlotNum = 1;
                                file.delete();
                                try (PrintWriter writer = new PrintWriter(new FileWriter("juniperLot.txt"))) {
                                    for(int j = 0; j < juniperLot.length; j++){
                                        writer.println( parkingSlotNum + "," + juniperLot[j]);
                                        parkingSlotNum++;
                                    }
                                    System.out.println("Parking has been removed");
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                            }//end of inner if
                        }//end of out if
                        parkingSlotNum++;
                    }//end of while
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }
            
     }
     public static void removeGaricaLot23(User user,  Map<String, User> userDatabase,String currentPark, int currentNumSlot) {
        
     }
     public static void removeGaricaLot22(User user,  Map<String, User> userDatabase,String currentPark, int currentNumSlot) {
        
     }
     public static void removePinonLot27(User user,  Map<String, User> userDatabase,String currentPark, int currentNumSlot) {
        
     }
     public static void removeODonaldParking55(User user,  Map<String, User> userDatabase,String currentPark, int currentNumSlot) {
        
     }
     public static void removeBookstoreLot16(User user,  Map<String, User> userDatabase,String currentPark, int currentNumSlot) {
        
     }
     public static void removeTrackLot100S(User user,  Map<String, User> userDatabase,String currentPark, int currentNumSlot) {
        
     }
     public static void removeSatelliteLot100(User user,  Map<String, User> userDatabase,String currentPark, int currentNumSlot) {
        
     }
     public static void removeRentFrowLot48(User user,  Map<String, User> userDatabase,String currentPark, int currentNumSlot) {
        
     }
     public static void removeSkeensLot4(User user,  Map<String, User> userDatabase,String currentPark, int currentNumSlot) {
        
     }
     public static void removeChamisaVillageLot38(User user,  Map<String, User> userDatabase,String currentPark, int currentNumSlot) {
        
     }
     public static void removeHorseshoeLot(User user,  Map<String, User> userDatabase,String currentPark, int currentNumSlot) {
        
     }
     public static void removeScienceHallLot58(User user,  Map<String, User> userDatabase,String currentPark, int currentNumSlot) {
        
     }
     public static void removeCorbettLot17(User user,  Map<String, User> userDatabase,String currentPark, int currentNumSlot) {
        
     }
     public static void removeLibarayLot45(User user,  Map<String, User> userDatabase,String currentPark, int currentNumSlot) {
        
     }
 
    
}
