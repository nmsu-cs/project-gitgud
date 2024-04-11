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

    public static void sendFileUpdate(){
        
    }


    public static int[][] scanParkingLot(){
        int [][] parkingLot = new int [40][2];

        return parkingLot;
    }

    
    public static void printAvailableLot(User user){
        
    }
}
