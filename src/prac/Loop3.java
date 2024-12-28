package prac;

public class Loop3 extends Thread{
    public Loop3(String name) {
        super(name);
    }
    public void run() {
        for (int i = 1; i <= 1000; i++) {
            System.out.println(getName() + "(" + i + ")");
            try {
                sleep(10);
            } catch (InterruptedException e) {
                System.out.println("interrupted");
            }
        }
    }

    public static void main(String[] args) {
        Loop3 t1 = new Loop3("Thread 1");
        Loop3 t2 = new Loop3("Thread 2");
        Loop3 t3 = new Loop3("Thread 3");
        t1.start();
        t2.start();
        t3.start();
    }
}
