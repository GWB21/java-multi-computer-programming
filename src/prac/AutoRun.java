package prac;//public class prac.AutoRun implements Runnable{
//    public prac.AutoRun(){
//        new Thread(this).start();
//    }
//
//    @Override
//    public void run() {
//        System.out.println("prac.AutoRun.run()");
//    }
//}
//class prac.Main {
//    public static void main(String[] args) {
//        prac.AutoRun AutoRunt1 = new prac.AutoRun();
//        System.out.println("InsideMain()");
//    }
//}

class AutoRun implements Runnable {
    private Thread _me;
    public AutoRun() {
        _me = new Thread(this);
        _me.start();
    }

    @Override
    public void run() {
        if(_me == Thread.currentThread())
            System.out.println("prac.AutoRun.run()");
    }
}
class Main {
    public static void main(String[] args) {
        AutoRun t1 = new AutoRun();
        t1.run();
        System.out.println("InsideMain()");
    }
}