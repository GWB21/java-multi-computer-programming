public class ParkingGarage {
    private int places;
    public ParkingGarage(int places) {
        if (places < 0){
            places = 0;
        }
        this.places = places;
    }
    public synchronized void enter() {
        while (places == 0) {
            try {
                wait();
            } catch (InterruptedException e) {
                System.out.println("빈 곳 생성됨");}
        }
        places--;
    }
    public synchronized void leave() {
        places++;
        notify();
    }
}

