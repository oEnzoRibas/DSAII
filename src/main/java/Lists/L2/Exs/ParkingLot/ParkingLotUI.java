package Lists.L2.Exs.ParkingLot;

import java.util.Scanner;

public class ParkingLotUI {
    private ParkingLot parkingLot;
    private Scanner scanner;

    public ParkingLotUI(ParkingLot parkingLot) {
        this.parkingLot = parkingLot;
        this.scanner = new Scanner(System.in);
    }

    public void start() {
        while (true) {
            System.out.println("\n-----------------------------------------------------------\n");
            System.out.println("Welcome to the Parking Lot System");
            System.out.println("Select an option:");

            System.out.println("1. Clients Section");
            System.out.println("2. Vehicle Entry");
            System.out.println("3. Vehicle Exit");
            System.out.println("4. Show Clients");
            System.out.println("5. Show Vehicles");
            System.out.println("6. Show Revenue");
            System.out.println("9. Clear Screen");
            System.out.println("0. Exit");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    clientMenu();
                    break;
                case "2":
                    vehicleEntryMenu();
                    break;
                case "3":
                    vehicleExitMenu();
                    break;
                case "4":
                    parkingLot.showClients();
                    break;
                case "5":
                    parkingLot.showVehicles();
                    break;
                case "6":
                    revenueMenu();
                    break;
                case "9":
                    clearScreen();
                    break;
                case "0":
                    exit();
                default:
                    System.out.println("Invalid option");
            }
        }
    }

    private void clientMenu() {
        System.out.println("1. Add Client");
        if (!parkingLot.getClients().isEmpty()) {
            System.out.println("2. Update Client");
            System.out.println("3. Delete Client");
        }
        System.out.println("0. Back");

        String choice = scanner.nextLine();

        switch (choice) {
            case "1":
                addClient();
                break;
            case "2":
                updateClient();
                break;
            case "3":
                deleteClient();
                break;
            case "0":
                return;
            default:
                System.out.println("Invalid option");
        }
    }

    private void addClient() {
        System.out.print("Enter client name: ");
        String name = scanner.nextLine();
        System.out.print("Enter client CPF: ");
        int cpf = Integer.parseInt(scanner.nextLine());
        parkingLot.registerClient(name, cpf);
    }

    private void updateClient() {
        System.out.print("Enter client CPF: ");
        int cpf = Integer.parseInt(scanner.nextLine());
        Client c = parkingLot.getClientByCpf(cpf);
        if (c == null) {
            System.out.println("Client not found.");
            return;
        }
        System.out.print("New name: ");
        c.setName(scanner.nextLine());
    }

    private void deleteClient() {
        System.out.print("Enter client CPF: ");
        int cpf = Integer.parseInt(scanner.nextLine());
        parkingLot.removeClientByCpf(cpf);
    }

    private void vehicleEntryMenu() {
        System.out.print("Model: ");
        String model = scanner.nextLine();
        System.out.print("Plate: ");
        String plate = scanner.nextLine();

        Date entryDate;
        System.out.println("Use current date and time? (y/n)");
        String dateChoice = scanner.nextLine();

        entryDate = dateChoice.equalsIgnoreCase("y") ? new Date(true) : customDateMenu();

        System.out.println("Is there a client associated? (y/n)");
        String resp = scanner.nextLine();

        if (resp.equalsIgnoreCase("y")) {
            System.out.print("Enter client CPF: ");
            int cpf = Integer.parseInt(scanner.nextLine());
            Client c = parkingLot.getClientByCpf(cpf);
            if (c != null) {
                parkingLot.vehicleEntry(model, plate, entryDate, c);
            } else {
                System.out.println("Client not found. Registering vehicle without client.");
                parkingLot.vehicleEntry(model, plate, entryDate, null);
            }
        } else {
            parkingLot.vehicleEntry(model, plate, entryDate, null);
        }
    }

    private void vehicleExitMenu() {
        System.out.print("Enter vehicle plate: ");
        String plate = scanner.nextLine();
        System.out.println("Use current date and time? (y/n)");
        String dateChoice = scanner.nextLine();
        Date exitDate = dateChoice.equalsIgnoreCase("y") ? new Date(true) : customDateMenu();

        parkingLot.vehicleExit(plate, exitDate);
    }

    private void revenueMenu() {
        System.out.println("Enter Month (1-12):");
        int month = Integer.parseInt(scanner.nextLine());

        System.out.printf("--- Revenue Report of %s---", Date.getMonthName(month));
        System.out.println("Total Revenue: R$" + parkingLot.getRevenue(month));
    }

    private Date customDateMenu() {
        System.out.print("Enter hour (0-23): ");
        int hour = Integer.parseInt(scanner.nextLine());
        System.out.print("Enter minute (0-59): ");
        int minute = Integer.parseInt(scanner.nextLine());
        System.out.print("Enter second (0-59): ");
        int second = Integer.parseInt(scanner.nextLine());

        return new Date(hour, minute, second);
    }

    private void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    private void exit(){
        System.out.println("ahh, it over... My sun, it's setting... it's dark, so dark...");
        scanner.close();
        System.exit(0);
    }


}
