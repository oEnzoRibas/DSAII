package Lists.L2.Exs.ParkingLot;

import java.sql.SQLOutput;
import java.util.Scanner;

public class Main {
    static ParkingLot parkingLot = new ParkingLot(1.0f);
    static Scanner kIn = new Scanner(System.in);

    public static void main(String[] args) {
        int option;

        do {
            System.out.println("\n-----------------------------------------------------------\n");
            System.out.println("Welcome to the Parking Lot System Press 9 to exit");
            do {
                System.out.println("""
                        Menu:
                        1. Vehicle Entry
                        2. Vehicle Exit
                        3. Client Section
                        4. List Vehicles
                        5. List Clients
                        6. Total Earnings by Month
                        9. Exit""");
                option = kIn.nextInt();
                kIn.nextLine();
            } while (option != 9 && (option < 1 || option > 6));

            switch (option) {
                case 1 -> {
                    System.out.println("Enter vehicle model:");
                    String model = kIn.nextLine();
                    System.out.println("Enter vehicle plate:");
                    String plate = kIn.nextLine();
                    System.out.println("Enter entry hour:");
                    int hour = kIn.nextInt();
                    System.out.println("Enter entry minute:");
                    int minute = kIn.nextInt();
                    System.out.println("Enter entry second:");
                    int second = kIn.nextInt();
                    System.out.println(""" 
                            Identify client?
                            1. Yes
                            2. No""");
                    int identify = kIn.nextInt();
                    kIn.nextLine();

                    if (identify == 1) {
                        System.out.println("Search for client:");
                        Client c = searchClientInterface();
                        if (c != null) {
                            parkingLot.vehicleEntry(model, plate, hour, minute, second, c);
                        } else {
                            System.out.println("Client not found. Proceeding without client association.");
                        }
                    }else {
                        parkingLot.vehicleEntry(model, plate, hour, minute, second);
                    }
                }
                case 2 -> {
                    System.out.println("Enter vehicle plate:");
                    String plate = kIn.nextLine();
                    System.out.println("Enter exit hour:");
                    int hour = kIn.nextInt();
                    System.out.println("Enter exit minute:");
                    int minute = kIn.nextInt();
                    System.out.println("Enter exit second:");
                    int second = kIn.nextInt();
                    parkingLot.vehicleExit(plate, hour, minute, second);
                }
                case 3 -> {
                    int optionClient = 0;
                    do {
                        System.out.println("""
                                Client Section:
                                1. Register Client
                                2. Update Client
                                3. Delete Client
                                4. Search Client
                                9. Exit""");
                        optionClient = kIn.nextInt();
                        kIn.nextLine();

                        switch (optionClient) {
                            case 1 -> {
                                System.out.println("Enter client CPF:");
                                int cpf = kIn.nextInt();
                                kIn.nextLine();
                                System.out.println("Enter client name:");
                                String name = kIn.nextLine();
                                parkingLot.registerClient(cpf, name);
                            }
                            case 2 -> {
                                System.out.println("Which client do you want to update?");
                                Client c = searchClientInterface();
                                System.out.println("Enter new name for the client:");
                                assert c != null;
                                c.name = kIn.nextLine();
                                System.out.println("Client updated successfully.");
                            }
                            case 3 -> {
                                System.out.println("Which client do you want to delete?");
                                Client c = searchClientInterface();
                                if (c != null) {
                                    parkingLot.deleteClient(c);
                                    System.out.println("Client deleted successfully.");
                                }
                            }
                            case 4 -> {
                                System.out.println("Which client do you want to search?");
                                Client c = searchClientInterface();
                                if (c != null) {
                                    System.out.println(c.getClientInfo());
                                }
                            }
                            case 9 -> System.out.println("Exiting Client Section.");
                            default -> System.out.println("Invalid option.");
                        }
                    } while (optionClient != 9);

                }
                case 4 -> parkingLot.showVehicles();
                case 5 -> parkingLot.showClients();
                case 6 -> {
                    System.out.println("Enter month (1-12):");
                    int month = kIn.nextInt();
                    kIn.nextLine();
                    System.out.println("Total earnings by month: $" + parkingLot.totalEarningsByMonth(month));
                }
                case 9 -> System.out.println("Exiting system. Goodbye!");
                default -> System.out.println("Invalid Option!");
            }
        } while (option != 9);


        kIn.close();
    }

    static Client searchClientInterface() {
        System.out.println("""
                Search by:
                1. CPF
                2. Name""");

        int searchOption = kIn.nextInt();
        kIn.nextLine();

        Client c = null;

        switch (searchOption) {
            case 1 -> {
                System.out.println("Enter client CPF:");
                int cpf = kIn.nextInt();
                kIn.nextLine();
                c = parkingLot.findClient(cpf);
            }
            case 2 -> {
                System.out.println("Enter client name:");
                String name = kIn.nextLine();
                c = parkingLot.findClient(name);
            }
            default -> System.out.println("Invalid option.");
        }
        return c;
    }
}
