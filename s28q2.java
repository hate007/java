public class s28q2 implements Runnable {
    public void run() {
        String threadName = Thread.currentThread().getName();
        System.out.println("Current thread is: " + threadName);
    }

    public static void main(String[] args) {
        Thread thread1 = new Thread(new s28q2(), "DO");
        Thread thread2 = new Thread(new s28q2(), "DA");
        Thread thread3 = new Thread(new s28q2(), "DI");
        thread1.start();
        thread2.start();
        thread3.start();
    }
}
