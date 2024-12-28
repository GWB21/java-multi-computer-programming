package prac;

class JoinThr {
    public static void main(String s[]) {
        MyThread1 Thread_a;
        MyThread2 Thread_b;
        Thread_a = new MyThread1();
        Thread_b = new MyThread2(Thread_a);                 //joining!
        System.out.println("Starting the threads...");
        Thread_a.start();
        Thread_b.start();
    }
}
