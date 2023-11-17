import java.util.Scanner;

class User {
    private String username;
    private String password;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public boolean authenticate(String enteredUsername, String enteredPassword) {
        return this.username.equals(enteredUsername) && this.password.equals(enteredPassword);
    }
}

class Reservation {
    private String trainNumber;
    private String classType;
    private String date;
    private String from;
    private String to;

    public Reservation(String trainNumber, String classType, String date, String from, String to) {
        this.trainNumber = trainNumber;
        this.classType = classType;
        this.date = date;
        this.from = from;
        this.to = to;
    }

    public void makeReservation() {
        System.out.println("Reservation successful!");
    }

    public void cancelReservation(String PNR) {
        System.out.println("Reservation with PNR " + PNR + " canceled.");
    }
}

public class OnlineReservationSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        User user = new User("user123", "pass123"); 
        Reservation reservation;

        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        if (user.authenticate(username, password)) {
            System.out.println("Welcome to the Online Reservation System");
            System.out.println("1. Make a reservation");
            System.out.println("2. Cancel a reservation");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter train number: ");
                    String trainNumber = scanner.next();
                    System.out.print("Enter class type: ");
                    String classType = scanner.next();
                    System.out.print("Enter date: ");
                    String date = scanner.next();
                    System.out.print("Enter 'from' location: ");
                    String from = scanner.next();
                    System.out.print("Enter 'to' destination: ");
                    String to = scanner.next();

                    reservation = new Reservation(trainNumber, classType, date, from, to);
                    reservation.makeReservation();
                    break;
                case 2:
                    scanner.nextLine(); 
                    System.out.print("Enter PNR number to cancel the reservation: ");
                    String pnr = scanner.nextLine();
                    reservation = new Reservation("", "", "", "", ""); 
                    reservation.cancelReservation(pnr);
                    break;
                    
                default:
                    System.out.println("Invalid choice.");
            }
        } else {
            System.out.println("Authentication failed. Access denied.");
        }

        scanner.close();
    }
}
