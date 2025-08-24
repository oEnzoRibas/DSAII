package Lists.L2.Exs.ParkingLot;

import java.util.ArrayList;

public class ParkingLot {

    private final float hourlyRate;
    private ArrayList<Vehicle> vehicles = new ArrayList<>();
    private ArrayList<Client> clients = new ArrayList<>();

    public ParkingLot(float hourlyRate) {
        this.hourlyRate = hourlyRate;
    }

    public void vehicleEntry( String model, String plate) {
        Date entryDate = new Date(); // data/hora atual
        Vehicle v = new Vehicle(model, plate, entryDate);
        v.setParked(true);
        vehicles.add(v);
        System.out.println("Vehicle registered successfully with ID: " + v.getCode());
    }

    public void vehicleExit(String plate, int hour, int minute, int second) {

        if (vehicles.isEmpty()) {
            System.out.println("No vehicles registered.");
            return;
        }

        Vehicle v = null;

        for (Vehicle vehicle : vehicles) {
            if (vehicle.getPlate().equalsIgnoreCase(plate)) {
                v = vehicle;
                break;
            }
        }

        if (v == null) {
            System.out.println("Vehicle not found.");
            return;
        }

        Date exitDate = new Date(hour, minute, second);
        v.setExit(exitDate);
        float cost = calculateCost(v, hourlyRate);
        v.setCost(cost);
        v.setParked(false);

        System.out.println("Vehicle exit recorded. Total cost: $" + cost);
    }

    public void registerClient(int cpf, String name) {
        Client c = new Client(cpf, name);
        clients.add(c);
        System.out.println("Client registered successfully with CPF: " + c.getCpf());
    }

    float calculateCost(Vehicle v, float hourlyRate) {
        int diff;
        diff = v.exit == null ? v.entry.difference(new Date(true)) : v.entry.difference(v.exit);
        return (float) (diff / 3600) * hourlyRate;
    }

    void showVehicles(){
        if(vehicles.isEmpty()){
            System.out.println("No vehicles registered.");
            return;
        }
        for(Vehicle v : vehicles){
            if (v.isParked) System.out.println(
                    "Vehicle ID: " + v.getCode() +
                            ", Model: " + v.getModel() +
                            ", Plate: " + v.getPlate() +
                            "\n Entry: " + v.getEntry().getDate() + (v.getExit() != null ?
                            ", Exit: " + v.getExit().getDate() : "") +
                            ", Cost: $" + calculateCost(v, hourlyRate));
        }
    }

    Client findClient(int cpf){
        if(clients.isEmpty()){
            System.out.println("No clients registered.");
            return null;
        }
        for(Client c : clients){
            if(c.getCpf() == cpf){
                System.out.println(c.getClientInfo());
                return c;
            }
        }
        System.out.println("Client not found.");
        return null;
    }

    Client findClient(String name){
        if(clients.isEmpty()){
            System.out.println("No clients registered.");
            return null;
        }
        for(Client c : clients){
            if(c.getName().equalsIgnoreCase(name)){
                System.out.println(c.getClientInfo());
                return c;
            }
        }
        System.out.println("Client not found.");
        return null;
    }

    void deleteClient(Client c){
        clients.remove(c);
        System.out.println("Client removed successfully.");
    }

    void showClients(){
        if(clients.isEmpty()){
            System.out.println("No clients registered.");
            return;
        }
        for(Client c : clients){
            System.out.println(c.getClientInfo());
        }
    }

    float totalEarningsByMonth(int month){
        float total = 0;
        for(Vehicle v : vehicles){
            if(!v.isParked && v.getExit() != null && v.getExit().getMonth() == month){
                total += v.getCost();
            }
        }
        System.out.println("Total pago pelos clientes no mês " + month + ": R$" + total);
        return total;
    }
}
