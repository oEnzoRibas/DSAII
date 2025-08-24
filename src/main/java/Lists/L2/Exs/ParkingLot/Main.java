package Lists.L2.Exs.ParkingLot;

public class Main {
    private static final float HOURLY_RATE = 1.0f;

    public static void main(String[] args) {


        ParkingLot lot = new ParkingLot(HOURLY_RATE);
        ParkingLotUI ui = new ParkingLotUI(lot);
        ui.start();
    }
}