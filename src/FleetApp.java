import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FleetApp {
    private List<Vehicle> vehicles = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);
    public void run(){
        boolean running = true;
        while(running){
            printMenu();
            System.out.println("choose from the menu");
            int choice= scanner.nextInt();
            if (choice == 1) {
                printAllVehicles();
            } else if (choice == 2) {
                addNewCar();
            } else if (choice == 3) {
                addNewBus();
            } else if (choice == 4) {
                showTotalInsuranceFees();
            } else if (choice == 5) {
                showVehiclesOlderThanNYears();
            } else if (choice == 6) {
                performServiceForAll();
            } else if (choice == 7) {
                System.out.println("Exiting the program");
                running = false;
            } else {
                System.out.println("Incorrect menu item");
            }
        }
    }
    private void printMenu() {
        System.out.println("\nFleet Management System");
        System.out.println("1. Print all vehicles");
        System.out.println("2. Add new car");
        System.out.println("3. Add new bus");
        System.out.println("4. Show total yearly insurance fees");
        System.out.println("5. Show vehicles older than N years");
        System.out.println("6. Perform service for all vehicles");
        System.out.println("7. Quit");
    }
    private void printAllVehicles() {
        if (vehicles.isEmpty()) {
            System.out.println("No vehicles in the fleet");
            return;
        }
        for (int i = 0; i < vehicles.size(); i++) {
            System.out.println(vehicles.get(i));
        }
    }
    private void addNewCar() {
        System.out.println("Enter the model: ");
        String model = scanner.nextLine();
        System.out.println("Enter the year of release: ");
        int year = scanner.nextInt();
        System.out.println("Enter the base price: ");
        double basePrice = scanner.nextDouble();
        System.out.println("Enter the number of doors: ");
        int doors = scanner.nextInt();

        Car car = new Car(model, year, basePrice, doors);
        vehicles.add(car);

        System.out.println("The car has been added");
    }
    private void addNewBus() {
        System.out.println("Enter the model: ");
        String model = scanner.nextLine();
        System.out.println("Enter the year of release: ");
        int year = scanner.nextInt();
        System.out.println("Enter the base price: ");
        double basePrice = scanner.nextDouble();
        System.out.println("Enter the number of capacity: ");
        int capacity = scanner.nextInt();
        Bus bus = new Bus(model, year, basePrice, capacity);
        vehicles.add(bus);
        System.out.println("The bus has been added");
    }
    private void showTotalInsuranceFees() {
        double total = 0;

        for (int i = 0; i < vehicles.size(); i++) {
            total += vehicles.get(i).calculateInsuranceFee();
        }

        System.out.println("General annual insurance: " + total);
    }
    private void showVehiclesOlderThanNYears() {
        System.out.println("Enter the current year:");
        int currentYear = scanner.nextInt();
        System.out.println("Enter N:");
        int n = scanner.nextInt();

        boolean found = false;

        for (int i = 0; i < vehicles.size(); i++) {
            Vehicle v = vehicles.get(i);
            if (v.getage(currentYear) > n) {
                System.out.println(v);
                found = true;
            }
        }

        if (!found) {
            System.out.println("There are no such vehicles");
        }

    }
    private void performServiceForAll() {
        for (int i = 0; i < vehicles.size(); i++) {
            Vehicle v = vehicles.get(i);

            if (v instanceof Servicable) {
                Servicable s = (Servicable) v;
                s.performService();
            }
        }
    }

}
