package Lists.L2.Exs.ParkingLot;

import java.util.ArrayList;

public class ParkingLot {

    private final float hourlyRate;
    private ArrayList<Vehicle> vehicles = new ArrayList<>();
    private ArrayList<Client> clients = new ArrayList<>();

    public ParkingLot(float hourlyRate) {
        this.hourlyRate = hourlyRate;
    }

    public void vehicleEntry(String model, String plate, Date entryDate, Client client) {
        Vehicle v = new Vehicle(model, plate, entryDate, client);
        v.setParked(true);
        vehicles.add(v);
        System.out.println("Vehicle registered successfully with ID: " + v.getCode());
    }

    public void vehicleExit(String plate, Date exitDate) {

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
        v.setExit(exitDate);
        float cost = calculateCost(v, hourlyRate);
        v.setCost(cost);
        v.setParked(false);

        System.out.println("Vehicle exit recorded. Total cost: $" + cost);
    }

    public void registerClient(String name, int cpf) {
        Client c = new Client(cpf, name);
        clients.add(c);
        System.out.println("Client registered successfully with CPF: " + c.getCpf());
    }

    /**
     * The cost is calculated based on the difference between entry and exit times in hour multiplied by the hourly rate.
     * If the vehicle is still parked, the current time is used as the exit time.
     * @param v vehicle
     * @param hourlyRate hourly rate
     * @return cost
     */
    float calculateCost(Vehicle v, float hourlyRate) {
        int diff;
        Date entry = v.getEntry();
        Date exit = v.getExit();
        Client client = v.getClient();

        diff = exit == null ? entry.difference(new Date(true)) : entry.difference(exit);
        if (client != null) {
            System.out.println("Client identified. Applying 10% discount.");
            diff = (int) (diff * 0.9);
        }
        return ((float) diff / 3600) * hourlyRate;
    }

    void showParkedVehicles(){
        if(vehicles.isEmpty()){
            System.out.println("No vehicles registered.");
            return;
        }
        System.out.println("\n------------------------------------------------------------\n");
        System.out.println("PARKED VEHICLES: \n");
        for(Vehicle v : vehicles){
            if (v.isParked()) System.out.println(v.toString());
        }
        System.out.println("\n-----------------------------------------------------------\n");
    }

    void showAllVehicles(){
        if(vehicles.isEmpty()){
            System.out.println("No vehicles registered.");
            return;
        }
        System.out.println("\n------------------------------------------------------------\n");
        System.out.println("ALL VEHICLES: \n");
        for(Vehicle v : vehicles){
            System.out.println(v.toString());
        }
        System.out.println("\n-----------------------------------------------------------\n");
    }

    Client getClientByCpf(int cpf){
        if(clients.isEmpty()){
            return null;
        }
        for(Client c : clients){
            if(c.getCpf() == cpf){
                return c;
            }
        }
        return null;
    }

    Client getClientByName(String name){
        if(clients.isEmpty()){
            return null;
        }
        for(Client c : clients){
            if(c.getName().equalsIgnoreCase(name)){
                return c;
            }
        }
        return null;
    }

    void removeClientByCpf(int cpf){
        if(clients.isEmpty()){
            System.out.println("No clients registered.");
            return;
        }
        Client c = null;
        for(Client client : clients){
            if(client.getCpf() == cpf){
                c = client;
                break;
            }
        }
        if(c == null){
            System.out.println("Client not found.");
            return;
        }
        clients.remove(c);
        System.out.println("Client removed successfully.");
    }

    void showClients(){
        if(clients.isEmpty()){
            System.out.println("No clients registered.");
            return;
        }
        System.out.println("\n------------------------------------------------------------\n");
        System.out.println("REGISTERED CLIENTS: \n");
        for(Client c : clients){
            System.out.println(c.toString());
        }
        System.out.println("\n-----------------------------------------------------------\n");
    }

    float getRevenue(int month){
        float total = 0;
        for(Vehicle v : vehicles){
            if(!v.isParked() && v.getExit() != null && v.getExit().getMonth() == month){
                total += v.getCost();
            }
        }
        System.out.println("\n------------------------------------------------------------\n");
        System.out.println("TOTAL EARNING IN MONTH " + month + ": R$" + total);
        System.out.println("\n-----------------------------------------------------------\n");
        return total;

    }

    public float getHourlyRate() {
        return hourlyRate;
    }

    public ArrayList<Vehicle> getVehicles() {
        return vehicles;
    }

    public void setVehicles(ArrayList<Vehicle> vehicles) {
        this.vehicles = vehicles;
    }

    public ArrayList<Client> getClients() {
        return clients;
    }

    public void setClients(ArrayList<Client> clients) {
        this.clients = clients;
    }
}
