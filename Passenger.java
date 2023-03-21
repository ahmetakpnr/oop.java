import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Passenger {
    private String name;
    private String adress;
    private String phoneNumber;
    private List<Reservation> reservations;
    private int password;
    private int accountId;

    public int getAccountId() {
        return accountId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public List<Reservation> getReservations() {
        return reservations;
    }

    public void setReservations(List<Reservation> reservations) {
        this.reservations = reservations;
    }

    public int getPassword() {
        return password;
    }

    public void setPassword(int password) {
        this.password = password;
    }

    public Passenger(String name, String adress, String phoneNumber, int password) {
        this.name = name;
        this.adress = adress;
        this.phoneNumber = phoneNumber;
        this.reservations = new ArrayList<>();
        this.password = password;
        this.accountId = new Random().nextInt(10000);
    }

    public Passenger() {
        this.accountId = new Random().nextInt(1000,10000);
        this.reservations = new ArrayList<>();
    }

    public Reservation findReservation(int reservationId){
        for (Reservation reservation : reservations) {
            if (reservation.getReservationId() == reservationId) {
                return reservation;
            }
        }
        return null;
    }

    public int newReservation(RailTrip railTrip,int numberOfSeats,int type){
        Reservation newReservation = new Reservation(railTrip,numberOfSeats,type);
        if(newReservation.approveReservation()){
            reservations.add(newReservation);
            System.out.println("Your reservation has been created with id:" + newReservation.getReservationId() );
            return newReservation.getReservationId();
        }
        return -1;
    }

    public boolean cancelReservation(int reservationCode){
        for (int x = 0; x < reservations.size(); x++){
            if (reservations.get(x).getReservationId() == reservationCode){
                reservations.get(x).cancelReservation();
                reservations.remove(x);

                return true;
            }
        }
        System.out.println("Reservation not found.");
        return false;
    }

    public void printListOfReservations(){

        System.out.print(Arrays.toString(reservations.toArray()));
    }

    @Override
    public String toString() {
        return "Passenger{" +
                "name='" + name + '\'' +
                ", adress='" + adress + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", reservations=" + reservations.toString() +
                ", password=" + password +
                ", accountId=" + accountId +
                '}';
    }
}