package Lists.L2.Exs.ParkingLot;

public class Vehicle {
    protected static int vehicleCont = 0;
    protected int code;
    protected String Model;
    protected String Plate;
    protected Date entry;
    protected Date exit = null;
    protected float cost = 0;
    protected Client client = null;
    protected boolean isParked = true;

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

}
