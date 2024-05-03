package User;

public class DataUserEntered {
    private static final DataUserEntered instance = new DataUserEntered();

    private String aggieID;
    private String fullName;
    private boolean hasParkingPermit;
    private String parkingPermitType;
    private String selectedParkingSpot; // New field for storing selected parking spot
    private String selectedParkingLot; // New field for storing selected parking lot

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

    // Getter and Setter methods for the new fields
    public String getSelectedParkingSpot() {
        return selectedParkingSpot;
    }

    public void setSelectedParkingSpot(String selectedParkingSpot) {
        this.selectedParkingSpot = selectedParkingSpot;
    }

    public String getSelectedParkingLot() {
        return selectedParkingLot;
    }

    public void setSelectedParkingLot(String selectedParkingLot) {
        this.selectedParkingLot = selectedParkingLot;
    }

    private DataUserEntered() {
    }

    public static DataUserEntered getInstance() {
        return instance;
    }
}
