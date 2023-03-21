import java.time.LocalDate;
import java.util.Date;
import java.util.Random;

public class RailTrip {
    private String fromLocation;
    private String toLocation;
    private int numOfAvailableFirstClassSeats;
    private int numOfAvailableRegularSeats;
    private int railTripId;

    private LocalDate tripDate;

    public RailTrip() {
        this.railTripId = new Random().nextInt(10000);
    }


    public LocalDate getTripDate() {
        return tripDate;
    }

    public void setTripDate(LocalDate tripDate) {
        this.tripDate = tripDate;
    }

    public String getFromLocation() {
        return fromLocation;
    }

    public void setFromLocation(String fromLocation) {
        this.fromLocation = fromLocation;
    }

    public String getToLocation() {
        return toLocation;
    }

    public void setToLocation(String toLocation) {
        this.toLocation = toLocation;
    }

    public int getNumOfAvailableFirstClassSeats() {
        return numOfAvailableFirstClassSeats;
    }

    public void setNumOfAvailableFirstClassSeats(int numOfAvailableFirstClassSeats) {
        this.numOfAvailableFirstClassSeats = numOfAvailableFirstClassSeats;
    }

    public int getNumOfAvailableRegularSeats() {
        return numOfAvailableRegularSeats;
    }

    public void setNumOfAvailableRegularSeats(int numOfAvailableRegularSeats) {
        this.numOfAvailableRegularSeats = numOfAvailableRegularSeats;
    }

    public int getRailTripId() {
        return railTripId;
    }



    public RailTrip(String fromLocation, String toLocation) {
        this.fromLocation = fromLocation;
        this.toLocation = toLocation;
        this.railTripId = new Random().nextInt(10000);
        this.numOfAvailableFirstClassSeats = 30;
        this.numOfAvailableRegularSeats = 70;
        this.tripDate = LocalDate.of(2022,11,23);
    }

    public RailTrip(String fromLocation, String toLocation,int numOfAvailableFirstClassSeats,int numOfAvailableRegularSeats, LocalDate tripDate) {
        this.fromLocation = fromLocation;
        this.toLocation = toLocation;
        this.railTripId = new Random().nextInt(10000);
        this.numOfAvailableFirstClassSeats = numOfAvailableFirstClassSeats;
        this.numOfAvailableRegularSeats = numOfAvailableRegularSeats;
        this.tripDate = tripDate;
    }

    public boolean reserveSeats(int type,int numberOfSeats){
        if (type == 0 && numberOfSeats > numOfAvailableRegularSeats) {
            return false;
        }
        else if (type == 1 && numberOfSeats > numOfAvailableFirstClassSeats){
            return false;
        }
        else if (type == 0 && numberOfSeats <= numOfAvailableRegularSeats ){
            numOfAvailableRegularSeats -= numberOfSeats;
            return true;
        }
        else if (type == 1 && (numberOfSeats <= numOfAvailableFirstClassSeats)){
            numOfAvailableFirstClassSeats -= numberOfSeats;
            return true;
        }
        else {
            return false;
        }

    }

    public boolean releaseSeats(int type, int numberOfSeats){
        if (type == 0){
            numOfAvailableRegularSeats += numberOfSeats;
        }
        else if (type == 1) {
            numOfAvailableFirstClassSeats += numberOfSeats;
        }
        return true;
    }

    public String getRailTripInfo(){
        return "RailTrip{" +
                "fromLocation='" + fromLocation + '\'' +
                ", toLocation='" + toLocation + '\'' +
                ", numOfAvailableFirstClassSeats=" + numOfAvailableFirstClassSeats +
                ", numOfAvailableRegularSeats=" + numOfAvailableRegularSeats +
                ", railTripId=" + railTripId +
                ", tripDate=" + tripDate +
                '}';
    }

}