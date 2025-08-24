package Lists.L2.Exs.ParkingLot;

import java.sql.SQLOutput;
import java.util.Scanner;

public class Main {
    static ParkingLot parkingLot = new ParkingLot(1.0f);
    static Scanner kIn = new Scanner(System.in);

    public static void main(String[] args) {
        int option;

        do {
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
                    parkingLot.vehicleEntry(model, plate);
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
                    do {
                        System.out.println("""
                                Client Section:
                                1. Register Client
                                2. Update Client
                                3. Delete Client
                                4. Search Client
                                9. Exit""");
                        option = kIn.nextInt();
                        kIn.nextLine();

                        switch (option) {
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
                        }
                    } while (option != 9);

                }
                case 4 -> parkingLot.showVehicles();
                case 5 -> parkingLot.showClients();
                case 6 -> {
                    System.out.println("Enter month (1-12):");
                    int month = kIn.nextInt();
                    kIn.nextLine();
                    System.out.println("Total earnings by month: $" + parkingLot.totalEarningsByMonth(month));
                }
            }
        } while (option != 9);


        kIn.close();
    }
        static Client searchClientInterface () {
            System.out.println("""
                    Search by:
                    1. CPF
                    2. Name""");

            int searchOption = kIn.nextInt();
            kIn.nextLine();

            Client c = null;

            switch (searchOption) {
                case 1 -> {
                    int cpf = kIn.nextInt();
                    kIn.nextLine();
                    c = parkingLot.findClient(cpf);
                }
                case 2 -> {
                    String name = kIn.nextLine();
                    c = parkingLot.findClient(name);
                }
            }

            if (c == null) {
                System.out.println("Client not found.");
                return null;
            } else {
                return c;
            }
        }

}
