public class Car extends Thread{
    private final ParkingGarage parkingGarage;
    public Car(String name, ParkingGarage p) {
        super(name);
        this.parkingGarage = p;
        start();
    }
    public void run() {
        while (true) {
            try{
                sleep((int)(Math.random() * 10000));
            } catch (InterruptedException e) {}
            parkingGarage.enter();
            System.out.println(getName() + ": entered");
            try {
                sleep((int)(Math.random() * 20000));
            } catch (InterruptedException e){}
            parkingGarage.leave();
            System.out.println(getName() + ": left");
        }
    }
}
