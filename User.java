public class User {
    private String fullName;
    private boolean hasParkingPermit;
    private String parkingPermitType;

    public User(String fullName, boolean hasParkingPermit, String parkingPermitType) {
        this.fullName = fullName;
        this.hasParkingPermit = hasParkingPermit;
        this.parkingPermitType = parkingPermitType;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public boolean getHasParkingPermit() {
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

    @Override
    public String toString() {
        return fullName + "," + hasParkingPermit + "," + parkingPermitType;
    }
}
