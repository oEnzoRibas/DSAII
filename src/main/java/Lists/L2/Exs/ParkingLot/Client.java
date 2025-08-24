package Lists.L2.Exs.ParkingLot;

public class Client {
    protected int cpf;
    protected String name;
    protected Date dateRegistration;

    public Client(int cpf, String name) {
        this.cpf = cpf;
        this.name = name;
        this.dateRegistration = new Date(true);
    }

    public String getClientInfo() {
        return "Client \n CPF: " + cpf + "\n Name: " + name + "\n Date of Registration: " + dateRegistration.getDate();
    }

    public int getCpf() {
        return cpf;
    }

    public String getName() {
        return name;
    }

    public Date getDateRegistration() {
        return dateRegistration;
    }
}
