package threads;

public class JoinTest {
    public static void main(String[] args) {
        MyThread thread_0 = new MyThread();
        MyThread thread_1 = new MyThread(thread_0);
        thread_1.start();
        thread_0.start();
        System.out.println("Programa terminado");
    }
}

class MyThread extends Thread {

    public MyThread() {
        t = null;
    }

    public MyThread(Thread thread) {
        t = thread;
    }

    public void run() {
        if (t != null) {
            try {
                t.join();
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
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
    private Thread t;
}