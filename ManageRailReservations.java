import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ManageRailReservations {

    List<Passenger> passengers = new ArrayList<>();
    List<RailTrip> railTrips = new ArrayList<>();

    public ManageRailReservations(){

    }

    public RailTrip findRailTripById(int tripId){
        for(RailTrip railTrip: railTrips){
            if (railTrip.getRailTripId() == tripId){
                return railTrip;
            }
        }
        return null;
    }

    public Passenger findPassengerById(int passengerId){
        for(Passenger passenger: passengers){
            if (passenger.getAccountId() == passengerId){
                return passenger;
            }
        }
        return null;
    }

    public void displayOptions(){
        System.out.println("1- Add new Passenger\n2- Add new rail trip\n3- Show all trips\n4- Show all passengers \n5- Add a reservation for an existing passenger\n6- Display a reservation\n7- Cancel a reservation\n0- Quit");
        Scanner sc= new Scanner(System.in);
        int x = sc.nextInt();
        while (x != 0 ){

            if (x == 1){
                Passenger newPassenger = new Passenger();

                System.out.println("Please enter your name: ");
                sc.nextLine();
                newPassenger.setName(sc.nextLine());
                System.out.println("Please enter your address: ");
                newPassenger.setAdress(sc.nextLine());
                System.out.println("Please enter your phone: ");
                newPassenger.setPhoneNumber(sc.nextLine());
                System.out.println("Please enter your password: ");
                newPassenger.setPassword(sc.nextInt());
                passengers.add(newPassenger);
                System.out.println("1- Add new Passenger\n2- Add new rail trip\n3- Show all trips\n4- Show all passengers \n5- Add a reservation for an existing passenger\n6- Display a reservation\n7- Cancel a reservation\n0- Quit");
                x = sc.nextInt();

            }
            else if (x == 2){

                RailTrip newTrip = new RailTrip();
                System.out.println("Please enter destination: ");
                sc.nextLine();
                newTrip.setToLocation(sc.nextLine());
                System.out.println("Please enter departure: ");
                newTrip.setFromLocation(sc.nextLine());
                System.out.println("Please enter number of available regular seats: ");
                newTrip.setNumOfAvailableRegularSeats(sc.nextInt());
                System.out.println("Please enter number of available first class seats: ");
                newTrip.setNumOfAvailableFirstClassSeats(sc.nextInt());
                int year, month, day;
                System.out.println("Please enter year, month, day respectively: ");
                year = sc.nextInt();
                month = sc.nextInt();
                day = sc.nextInt();
                newTrip.setTripDate(LocalDate.of(year,month,day));
                System.out.println("1- Add new Passenger\n2- Add new rail trip\n3- Show all trips\n4- Show all passengers \n5- Add a reservation for an existing passenger\n6- Display a reservation\n7- Cancel a reservation\n0- Quit");
                x = sc.nextInt();
                railTrips.add(newTrip);

            }
            else if (x == 3) {
                for (Passenger passenger: passengers){
                    System.out.println(passenger.toString());
                }
                System.out.println("1- Add new Passenger\n2- Add new rail trip\n3- Show all trips\n4- Show all passengers \n5- Add a reservation for an existing passenger\n6- Display a reservation\n7- Cancel a reservation\n0- Quit");
                x = sc.nextInt();
            }
            else if (x == 4){
                for (RailTrip railTrip:railTrips){
                    System.out.println(railTrip.getRailTripInfo());
                }
                System.out.println("1- Add new Passenger\n2- Add new rail trip\n3- Show all trips\n4- Show all passengers \n5- Add a reservation for an existing passenger\n6- Display a reservation\n7- Cancel a reservation\n0- Quit");
                x = sc.nextInt();
            }
            else if (x == 5){
                System.out.println("Please enter your id: ");
                int id = sc.nextInt();
                System.out.println("Please enter your password: ");
                int password = sc.nextInt();

                for (Passenger passenger: passengers){
                    if (passenger.getAccountId() == id && passenger.getPassword() == password){
                        System.out.println("You have successfully logged in. Please enter the id of the trip you want to make a reservation: ");
                        int rid = sc.nextInt();
                        for (RailTrip railTrip: railTrips){
                            if (railTrip.getRailTripId() == rid){
                                System.out.println("Please enter the number of seats you want to reserve and its type respectively (0 for regular seats, 1 for first class)");
                                int nos,type;
                                nos = sc.nextInt();
                                type = sc.nextInt();
                                passenger.newReservation(railTrip,nos,type);
                            }
                        }
                    }
                }
                System.out.println("1- Add new Passenger\n2- Add new rail trip\n3- Show all trips\n4- Show all passengers \n5- Add a reservation for an existing passenger\n6- Display a reservation\n7- Cancel a reservation\n0- Quit");
                x = sc.nextInt();
            }
            else if (x == 6){
                System.out.println("Please enter your id, and the reservation id you want to see respectively (0 for all reservations):");
                int uid,rid;
                uid = sc.nextInt();
                rid = sc.nextInt();
                for (Passenger passenger: passengers){
                    if (passenger.getAccountId() == uid){
                        if (rid == 0){
                            passenger.printListOfReservations();
                        }
                        else {
                            for (Reservation reservation: passenger.getReservations()){
                                if (reservation.getReservationId() == rid){
                                    System.out.print(reservation.getReservationInfo());
                                }
                            }
                        }
                    }
                }
                System.out.println("1- Add new Passenger\n2- Add new rail trip\n3- Show all trips\n4- Show all passengers \n5- Add a reservation for an existing passenger\n6- Display a reservation\n7- Cancel a reservation\n0- Quit");
                x = sc.nextInt();
            }
            else if (x == 7){
                System.out.println("Please enter your id: ");
                int id = sc.nextInt();
                System.out.println("Please enter your password: ");
                int password = sc.nextInt();
                for (Passenger passenger: passengers){
                    if (passenger.getAccountId() == id && passenger.getPassword() == password){
                        System.out.println("You have successfully logged in. Please enter the id of the reservation you want to cancel: ");
                        int rid = sc.nextInt();
                        passenger.cancelReservation(rid);


                    }
                }
                System.out.println("1- Add new Passenger\n2- Add new rail trip\n3- Show all trips\n4- Show all passengers \n5- Add a reservation for an existing passenger\n6- Display a reservation\n7- Cancel a reservation\n0- Quit");
                x = sc.nextInt();
            }

        }

    }

    public static void main(String[] args) {
        ManageRailReservations object = new ManageRailReservations();
        object.displayOptions();
    }





}
