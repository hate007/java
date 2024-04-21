import java.util.Random;

class MyThread implements Runnable {
    String threadName;

    public MyThread(String name) {
        this.threadName = name;
    }
    public void run() {
        Random rand = new Random();
        int sleepTime = rand.nextInt(5000);

        System.out.println("Thread " + threadName + " is created.");

        try {
            System.out.println("Thread " + threadName + " will sleep for " + sleepTime + " milliseconds.");
            Thread.sleep(sleepTime);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Thread " + threadName + " is dead.");
    }
}

public class s13q2 {
    public static void main(String[] args) {

        Thread thread1 = new Thread(new MyThread("Thread 1"));
        Thread thread2 = new Thread(new MyThread("Thread 2"));
        Thread thread3 = new Thread(new MyThread("Thread 3"));

        thread1.start();
        thread2.start();
        thread3.start();
    }
}
