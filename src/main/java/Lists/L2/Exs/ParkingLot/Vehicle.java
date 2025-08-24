package Lists.L2.Exs.ParkingLot;

public class Vehicle {
    private static int vehicleCont = 0;
    private int code;
    private String Model;
    private String Plate;
    private Date entry;
    private Date exit = null;
    private float cost = 0;
    private Client client = null;
    private boolean isParked = true;

    public int getCode() {
        return code;
    }

    public String getModel() {
        return Model;
    }

    public void setModel(String model) {
        Model = model;
    }

    public String getPlate() {
        return Plate;
    }

    public void setPlate(String plate) {
        Plate = plate;
    }

    public Date getEntry() {
        return entry;
    }

    public void setEntry(Date entry) {
        this.entry = entry;
    }

    public Date getExit() {
        return exit;
    }

    public void setExit(Date exit) {
        this.exit = exit;
    }

    public float getCost() {
        return cost;
    }

    public void setCost(float cost) {
        this.cost = cost;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public void setParked(boolean isParked) {
        this.isParked = isParked;
    }

    public boolean isParked() {
        return isParked;
    }

    Vehicle(String Model, String Plate, Date entry){
        this.code = ++vehicleCont;
        this.Model = Model;
        this.Plate = Plate;
        this.entry = entry;
    }

    Vehicle(String Model, String Plate, Date entry, Client client){
        this(Model, Plate, entry);
        this.client = client;
    }

    @Override
    public String toString() {
        return "Vehicle ID: " + code +
                ", Model: " + Model +
                ", Plate: " + Plate +
                ", Entry: " + entry.getDate() +
                (exit != null ? ", Exit: " + exit.getDate() : "") +
                ", Cost: $" + cost +
                (isParked ? ", Status: Parked" : ", Status: Exited") +
                (client != null ? "\n Client: " + client.getName() + " (CPF: " + client.getCpf() + ")" : "\n No client associated.");
    }

}
