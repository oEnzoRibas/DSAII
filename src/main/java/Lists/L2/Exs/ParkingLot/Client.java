package Lists.L2.Exs.ParkingLot;

public class Client {
    private int cpf;
    private String name;
    private Date dateRegistration;

    public Client(int cpf, String name) {
        this.cpf = cpf;
        this.name = name;
        this.dateRegistration = new Date(true);
    }

    @Override
    public String toString() {
        return "Client \n CPF: " + cpf + "\n Name: " + name +
                "\n Date of Registration: " + dateRegistration.getDate();
    }

    public int getCpf() {
        return cpf;
    }

    public String getName() {
        return name;
    }

    public void setCpf(int cpf) {
        this.cpf = cpf;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDateRegistration(Date dateRegistration) {
        this.dateRegistration = dateRegistration;
    }

    public Date getDateRegistration() {
        return dateRegistration;
    }
}
