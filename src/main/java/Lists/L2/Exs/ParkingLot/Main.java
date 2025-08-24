package Lists.L2.Exs.ParkingLot;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ParkingLot lot = new ParkingLot(1.0f);
        ParkingLotUI ui = new ParkingLotUI(lot);
        ui.start();
    }
}