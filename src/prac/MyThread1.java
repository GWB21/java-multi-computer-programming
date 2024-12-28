package prac;

class MyThread1 extends Thread {
    public void run() {
        System.out.println(getName() + " is running...");   //스레드의 이름을 리턴하면서 지금 무슨 스레드가 돌아가고 있는지 알려주는것.
        for (int i = 0; i < 4; i++) {                       //thread1이 하는건 500밀리초동안 쉬면서 4번 print하는것임. 자기가 "나 지금 돌아가고 있어요~~"라고 명시적으로 말해주면서
            try {
                sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Hello there, from " + getName());
        }
    }
}
