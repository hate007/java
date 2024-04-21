public class s6q2 implements Runnable {

    static volatile int counter = 0;
    static Object lock = new Object();
    String[] lights = {"GREEN", "ORANGE", "RED"};
    String colour;

    public s6q2(String colour) {
        this.colour = colour;
    }

    @Override
    public void run() {
        try {
            synchronized (lock) {
                while (true) {
                    while (!lights[counter % lights.length].equals(colour)) lock.wait();
                    System.out.println(colour);
                    counter++;
                    Thread.sleep(1000);
                    lock.notifyAll();
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Thread(new s6q2("GREEN")).start();
        new Thread(new s6q2("ORANGE")).start();
        new Thread(new s6q2("RED")).start();
    }
}
