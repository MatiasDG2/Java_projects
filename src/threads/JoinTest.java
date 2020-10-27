package threads;

public class JoinTest {
    public static void main(String[] args) {
        MyThread thread_0 = new MyThread();
        MyThread thread_1 = new MyThread();
        thread_0.start();
        try {
            thread_0.join();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        thread_1.start();
        try {
            thread_1.join();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println("Programa terminado");

    }
}

class MyThread extends Thread {

    public void start() {
        for (int i = 0; i < 15; i++) {
            System.out.println("Thread en ejecución: " + getName());
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
}