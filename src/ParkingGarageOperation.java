public class ParkingGarageOperation {
    public static void main(String[] args) {
        ParkingGarage parkingGarage = new ParkingGarage(10);
        for (int i = 1; i <= 40; i++) {
            Car car = new Car("Car" + i, parkingGarage);
        }
    }
}