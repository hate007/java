import java.util.Random;

class RandomNumberGenerator implements Runnable {
    public void run() {
        Random random = new Random();
        try {
            while (true) {
                int randomNumber = random.nextInt(100);
                System.out.println("Generated Random Number: " + randomNumber);
                if (randomNumber % 2 == 0) {
                    synchronized (s7q1.squareCalculator) {
                        s7q1.number = randomNumber;
                        s7q1.squareCalculator.notify();
                    }
                } else {
                    synchronized (s7q1.cubeCalculator) {
                        s7q1.number = randomNumber;
                        s7q1.cubeCalculator.notify();
                    }
                }
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class SquareCalculator implements Runnable {
    public void run() {
        try {
            while (true) {
                synchronized (s7q1.squareCalculator) {
                    s7q1.squareCalculator.wait();
                    System.out.println("Square of " + s7q1.number + ": " + (s7q1.number * s7q1.number));
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class CubeCalculator implements Runnable {

    public void run() {
        try {
            while (true) {
                synchronized (s7q1.cubeCalculator) {
                    s7q1.cubeCalculator.wait();
                    System.out.println("Cube of " + s7q1.number + ": " + (s7q1.number * s7q1.number * s7q1.number));
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

public class s7q1 {
    public static int number;
    public static final Object squareCalculator = new Object();
    public static final Object cubeCalculator = new Object();

    public static void main(String[] args) {
        Thread randomNumberGeneratorThread = new Thread(new RandomNumberGenerator());
        Thread squareCalculatorThread = new Thread(new SquareCalculator());
        Thread cubeCalculatorThread = new Thread(new CubeCalculator());

        randomNumberGeneratorThread.start();
        squareCalculatorThread.start();
        cubeCalculatorThread.start();
    }
}
