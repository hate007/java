class PrintTextThread extends Thread {
    String text;
    int times;

    public PrintTextThread(String text, int times) {
        this.text = text;
        this.times = times;
    }

    public void run() {
        for (int i = 0; i < times; i++) {
            System.out.println(text + ": Times " + (i+1));

        }
    }
}

public class s8q1s {
    public static void main(String[] args) {
        PrintTextThread thread1 = new PrintTextThread("COVID19", 10);
        PrintTextThread thread2 = new PrintTextThread("LOCKDOWN2020", 20);
        PrintTextThread thread3 = new PrintTextThread("VACCINATED2021", 30);

        thread1.start();
        thread2.start();
        thread3.start();
    }
}