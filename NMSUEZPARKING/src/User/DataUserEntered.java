/*
 * Creating this class so that login data from the user can be transfered over to different controllers
 */

 package User;

 public class DataUserEntered {
     private static final DataUserEntered instance = new DataUserEntered();
 
     private String aggieID;
     private String fullName;
     private boolean hasParkingPermit;
     private String parkingPermitType;
 
     // Getter and Setter methods
     public String getAggieID() {
         return aggieID;
     }
 
     public void setAggieID(String aggieID) {
         this.aggieID = aggieID;
     }
 
     public String getFullName() {
         return fullName;
     }
 
     public void setFullName(String fullName) {
         this.fullName = fullName;
     }
 
     public boolean isHasParkingPermit() {
         return hasParkingPermit;
     }
 
     public void setHasParkingPermit(boolean hasParkingPermit) {
         this.hasParkingPermit = hasParkingPermit;
     }
 
     public String getParkingPermitType() {
         return parkingPermitType;
     }
 
     public void setParkingPermitType(String parkingPermitType) {
         this.parkingPermitType = parkingPermitType;
     }
 
     private DataUserEntered(){}
 
     public static DataUserEntered getInstance(){
         return instance;
     }
 
     
 }
 