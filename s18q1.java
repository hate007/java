public class s18q1 {
    public static void main(String[] args) {
        Thread thread = new Thread(new MyRunnable(), "MY THREADD");

        thread.setPriority(7);
        thread.start();

        System.out.println("Main Thread - Name: " + Thread.currentThread().getName() + ", Priority: " + Thread.currentThread().getPriority());
        System.out.println("Created Thread - Name: " + thread.getName() + ", Priority: " + thread.getPriority());
    }

    static class MyRunnable implements Runnable {
        public void run() {
            System.out.println("Thread is running...");
        }
    }
}
