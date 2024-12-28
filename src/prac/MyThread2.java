package prac;//class ThreadDemo {
//    public static void main (String [] args) {
//        MyThread mt = new MyThread();
//        mt.start();
//        for (int i = 0; i < 50; i++)
//            System.out.println("i =" + i + ", i * i = " + i * i);
//    }
//}
//
//class ThreadDemo2 {
//    public static void main (String [] args) {
//        MyThread mt2 = new MyThread();
//        mt2.start();
//    }
//}
//
//class MyThread extends Thread {
//    public void run() {
//        for (int count = 1, row = 1; row < 20; row++, count++) {
//            for (int i = 0; i < count; i++)
//                System.out.print("*");
//            System.out.print("\n");
//        }
//    }
//}

//class prac.AutoRun implements Runnable {
//    public prac.AutoRun() {
//        new Thread(this).start();
//    }
//    public void run() {
//        System.out.println("MyRunnable.run()"); // define run()
//    }
//    //other methods and data for this class
//}
//
//class prac.Main {
//    public static void main(String [] args) {
//        prac.AutoRun AutoRunt1 = new prac.AutoRun();
//        System.out.println("InsideMAin()");
//
//    }
//}

//class prac.AutoRun implements Runnable {
//    private Thread _me;
//    public prac.AutoRun() {
//        _me = new Thread(this);
//        _me.start();
//    }
//
//    public void run() {
//        if(_me != Thread.currentThread()) {
//            System.out.println("prac.AutoRun.run()");
//        }
//    }
//}
//
//class prac.Main {
//    public static void main(String[] args) {
//        prac.AutoRun t1 = new prac.AutoRun();
//        t1.run();
//        System.out.println("InsideMain()");
//    }
//}

class MyThread2 extends Thread {
    private final Thread wait4me;          //내가 어떤 private 스레드를 생성해요. => joining하는걸 생각해서 받아와서 자기한테 저장하려고 하는거지 뭐.

    MyThread2(Thread target) {
        super();                //target 스레드의 run 메소드를 받으려고 쓴거겠지. 근데 super 없어도 다 받아지는거 아닌가? 뭘까? 아 자기도 똑같이 run한다는건가.
        wait4me = target;       //내가 만들어둔 wait4me 스레드에다가 할당하고~
    }

    @Override       // super로 가져온거 오버라이드 하는거죠?
    public void run() {
        super.run(); //상속 받은 스레드의 run 메소드 실행 => Thread0 메소드 실행한다는것
        System.out.println(getName() + " is waiting for " + wait4me.getName() + "..."); //아 지금 그니까 상속받은 애 먼저 하고 있는거니까 내가 지금 얘 기다리고 있어요~ 라고 말하는거네.
        try {
            wait4me.join();                                        //여기서 이제 join했어~ 그럼 Thread 0 끝나기 전까지 기다림
        } catch (InterruptedException e) {                          //항상 join같이 interrupted Exception이 발생할 가능성이 있는 경우에는 자바에서 try catch를 강제하고 있음.
            throw new RuntimeException(e);
        }
        System.out.println(wait4me.getName() + " has finished...");     //이제 thread-0가 끝났으니. join때문에 잠시 대기상태였다는거죠? 아 그니까 non runnable 상태인데 다른애들이 얘를 그냥 shutdown시키면 error나는건가
        for (int i = 0; i < 4; i++) {                                   //아 근데 join은 point to point communication이라서~~~~~~~~ 아~~~ ㅈㄴ 행복하다 ㅋㅋㅋ 알아가는게.. 내가 이해하고 있다는게 신기하잖아 걍
            try {
                sleep(500);                                         //이제 스레드1 세상이야~ 너의 꿈을 펼치렴. 근데 sleep도 대기상태로 만드는거라서 interrupted error 날 수 있는거구나? 지린다
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Hello there, from " + getName());
        }
    }
}
