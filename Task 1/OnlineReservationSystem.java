import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class OnlineReservationSystem {
    private Map<String, String> users; // Store username-password pairs
    private Map<String, Reservation> reservations; // Store reservation data

    public OnlineReservationSystem() {
        users = new HashMap<>();
        reservations = new HashMap<>();
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("------------------------------------------------");
            System.out.println("----- WELCOME TO ONLINE RESERVATION SYSTEM -----");
            System.out.println("------------------------------------------------");
            System.out.println("Please Select an Option:\n");
            System.out.println("1. Login");
            System.out.println("2. Register");
            System.out.println("3. Exit");
            System.out.println("------------------------------------------------");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    login(scanner);
                    break;
                case 2:
                    register(scanner);
                    break;
                case 3:
                    System.out.println("------------------------------------------------");
                    System.out.println("\nExiting...");
                    System.out.println("\nThank You! Please Visit Again...");
                    System.out.println("------------------------------------------------");
                    scanner.close();
                    return;
                default:
                    System.out.println("------------------------------------------------");
                    System.out.println("\nInvalid choice. Please try again...");
                    break;
            }
            System.out.println();
        }
    }

    private void register(Scanner scanner) {
        System.out.println("------------------------------------------------");
        System.out.println("--------------- REGISTRATION PAGE --------------");
        System.out.println("------------------------------------------------");
        System.out.print("Enter username: ");
        String username = scanner.nextLine();

        if (users.containsKey(username)) {
            System.out.println("\nUsername already exists. Try again.");
            return;
        }

        System.out.print("Enter password: ");
        String password = scanner.nextLine();
        users.put(username, password);
        System.out.println("\nRegistration successful. You can now log in.");
    }

    private void login(Scanner scanner) {
        System.out.println("------------------------------------------------");
        System.out.println("------------------ LOGIN PAGE ------------------");
        System.out.println("------------------------------------------------");
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        if (users.containsKey(username) && users.get(username).equals(password)) {
            System.out.println("\nLogin successful.");
            showReservationMenu(scanner, username);
        } else {
            System.out.println("\nInvalid username or password.");
        }
    }

    private void showReservationMenu(Scanner scanner, String username) {
        while (true) {
            System.out.println("------------------------------------------------");
            System.out.println("-------------- RESERVATION MENU -----------------");
            System.out.println("------------------------------------------------");
            System.out.println("Please Select an Option:\n");
            System.out.println("1. Make a reservation");
            System.out.println("2. Cancel a reservation");
            System.out.println("3. Logout");
            System.out.println("------------------------------------------------");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    makeReservation(scanner, username);
                    break;
                case 2:
                    cancelReservation(scanner, username);
                    break;
                case 3:
                    System.out.println("------------------------------------------------");
                    System.out.println("\nLogging out...");
                    return;
                default:
                    System.out.println("------------------------------------------------");
                    System.out.println("\nInvalid choice. Try again.");
                    break;
            }
            System.out.println();
        }
    }

    private void makeReservation(Scanner scanner, String username) {
        System.out.println("------------------------------------------------");
        System.out.println("------------ MAKE A RESERVATION ---------------");
        System.out.println("------------------------------------------------");
        System.out.print("Enter your name: ");
        String name = scanner.nextLine();
        System.out.print("Enter your age: ");
        int age = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter train number: ");
        String trainNumber = scanner.nextLine();
        System.out.print("Enter train name: ");
        String trainName = scanner.nextLine();
        System.out.print("Enter class type (e.g., Economy, Business): ");
        String classType = scanner.nextLine();
        System.out.print("Enter date of journey (MM/DD/YYYY): ");
        String dateOfJourney = scanner.nextLine();
        System.out.print("Enter destination: ");
        String destination = scanner.nextLine();
    
        // Generate a unique PNR number (e.g., using a timestamp)
        String pnr = Long.toString(System.currentTimeMillis());
    
        Reservation reservation = new Reservation(name, age, trainNumber, trainName, classType, dateOfJourney, destination);
        reservations.put(pnr, reservation);
    
        System.out.println("\nReservation created successfully.");
        System.out.println("Your PNR number is: " + pnr);
    
        // Display a summary of the reservation
        System.out.println("\nReservation Summary:");
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Train Number: " + trainNumber);
        System.out.println("Train Name: " + trainName);
        System.out.println("Class Type: " + classType);
        System.out.println("Date of Journey: " + dateOfJourney);
        System.out.println("Destination: " + destination);
    }
    

    private void cancelReservation(Scanner scanner, String username) {
        System.out.println("------------------------------------------------");
        System.out.println("----------- CANCEL A RESERVATION ---------------");
        System.out.println("------------------------------------------------");
        System.out.print("Enter PNR number for cancellation: ");
        String pnr = scanner.nextLine();

        if (reservations.containsKey(pnr)) {
            reservations.remove(pnr);
            System.out.println("\nReservation with PNR " + pnr + " has been cancelled.");
        } else {
            System.out.println("\nNo reservation found with PNR " + pnr);
        }
    }

    public static void main(String[] args) {
        OnlineReservationSystem system = new OnlineReservationSystem();
        system.run();
    }
}

class Reservation {
    private String name;
    private int age;
    private String trainNumber;
    private String trainName;
    private String classType;
    private String dateOfJourney;
    private String destination;

    public Reservation(String name, int age, String trainNumber, String trainName, String classType, String dateOfJourney, String destination) {
        this.name = name;
        this.age = age;
        this.trainNumber = trainNumber;
        this.trainName = trainName;
        this.classType = classType;
        this.dateOfJourney = dateOfJourney;
        this.destination = destination;
    }
}
