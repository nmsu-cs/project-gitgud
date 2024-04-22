import java.io.*;
import java.util.*;

public class ParkingLot {

    private static int totalSpots;
    private static int currentlyParkedSpots;
    private static String[] usersParked;
    private static String lotName;


    public static String getLotName() {
        return lotName;
    }


    public static int getTotalSpots() {
        return totalSpots;
    }


    public static int getCurrentSpots() {
        return currentlyParkedSpots;
    }


    public static String[] getUsersParked() {
        return usersParked;
    }


    public static void setCurrentSpots(int n) {
        currentlyParkedSpots = n;
    }


    public static void setUsersParked(String[] n) {
        usersParked = n;
    }

    //Create a new parking lot that is completely avaible
    public static int[] createParkingLot(int[] parkingLot){
        //input that all of the spot are avaiable
        for(int i = 0; i < parkingLot.length; i++){
            parkingLot[i] = 0;
        }

        return parkingLot;
    }

//Display all of the avaible parking spot in the area
    public static void displayAvaible(int[] parkingLot){
        int slotNumber = 1;
        int count = 0;

        System.out.println();
        System.out.println("Parking Lot avaiable: ");

        //Goes through the array t print which are avaible
        for(int i = 0; i < parkingLot.length; i++){

            //if it is avaible then will print the number
            if(parkingLot[i] == 0){
                System.out.print(slotNumber);
                count++;

                //will print a , except for the last number
                if(i != (parkingLot.length - 1))
                    System.out.print(", ");

                //will print out a new line and reset the counter
                if(count == 20){
                    System.out.println("");
                    count = 0;
                }//end of if

            }//end of first if
            slotNumber++;
        }//end of for

        System.out.println();
        System.out.println();

    }

//Change the data in the 
    public static boolean userEnterSpot(User user) {
        //Search for an open spot in the array
        for (int i = 0; i<totalSpots; i++) {
            if (usersParked[i] == null) {
                //If an open spot is found, place the user's aggie ID there, add to the counter, and return true.
                usersParked[i] = user.getAggieID();
                currentlyParkedSpots++;
                return true;
            }
        }
        //If the search could not find an open spot, return false.
        return false;
    }


    public static boolean userLeaveSpot(User user) {
        //Search for the specified user's aggie ID
        for (int i = 0; i<totalSpots; i++) {
            if (usersParked[i] == user.getAggieID()) {
                //If the aggie ID is found, remove the user, clear a spot on the counter, and return true.
                usersParked[i] = null;
                currentlyParkedSpots--;
                return true;
            }
        }
        // If the search could not find the specified user, returns false.
        return false;
    }

    public static int[] sendParkinglotInfo(File file, int [] parkingLot){
        int parkingSlotNum = 1;

        //Send if the text file is blank then create a new parking lot and send to the txt file
        if (!file.exists()) {   
            parkingLot = ParkingLot.createParkingLot(parkingLot);
            try (PrintWriter writer = new PrintWriter(new FileWriter(file))) {
                //input the parking Number and avaiable in txt file
                for(int i = 0; i < parkingLot.length; i++){
                    writer.println( parkingSlotNum + "," + parkingLot[i]);
                    parkingSlotNum++;
                }//end of for
            } catch (IOException e) {
                e.printStackTrace();
            }//end of catch
        }//end of if

         //If the file exits that will just read the text file
         else if (file.exists()) {
            try (Scanner fileScanner = new Scanner(file)) {

                //This scan the file and and input in the array
                while (fileScanner.hasNextLine()) {
                    String line = fileScanner.nextLine();
                    String[] parts = line.split(",");
                    //reads if the parts in the file then input in the array
                    if (parts.length == 2) {
                        int i = Integer.parseInt(parts[0]);
                        int available = Integer.parseInt(parts[1]);
                        parkingLot[i-1] = available;
                    }//end of if
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }//end of else

        return parkingLot;
    }

    public static void changeParkingToUnavaible(File file, int [] parkingLot, int parkingNum){
        int parkingSlotNum = 1;
        //If the user input the correct parking then read the file until find the parking number in the file.
            //It will change the number to 1 (Unavaible) in the array
            //delete the whole file then reprint the whole
            if(parkingNum < parkingLot.length || parkingNum > 0 || parkingLot[parkingNum-1] == 0){
                try (Scanner fileScanner = new Scanner(file)) {
                    parkingSlotNum = 1;

                    //This scan the file and and input in the array
                    while (fileScanner.hasNextLine()) {
                        String line = fileScanner.nextLine();
                        String[] parts = line.split(",");
                        if (parts.length == 2) {
                            int i = Integer.parseInt(parts[0]);
                            // System.out.println("The slot number: " + i + " available " + juniperLot[i-1]);
                        
                            if (parkingNum == i){
                            parkingLot[i - 1] = 1;
                                file.delete();
                                try (PrintWriter writer = new PrintWriter(new FileWriter(file))) {
                                    for(int j = 0; j < parkingLot.length; j++){
                                        writer.println( parkingSlotNum + "," + parkingLot[j]);
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
                }//end of catch
            }//end of if
    }//end of changeParkingInfo

    public static void changeParkingToAvaible(File file, int [] parkingLot, int currentNumSlot){
        int parkingSlotNum = 1;
          //If the user input the correct parking then read the file until find the parking number in the file.
            //It will change the number to 0 (vaible) in the array
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
                            parkingLot[i - 1] = 0;
                            parkingSlotNum = 1;
                                file.delete();
                                try (PrintWriter writer = new PrintWriter(new FileWriter(file))) {
                                    for(int j = 0; j < parkingLot.length; j++){
                                        writer.println( parkingSlotNum + "," + parkingLot[j]);
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
}
