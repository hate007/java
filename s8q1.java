public class s8q1 {

    static int counter = 0;

    static class PrintText implements Runnable {
        String text;
        int times;
        int num;
        int i = 0;
        static Object lock = new Object();
        static int totalTime=0;

        public PrintText(String text, int times, int num) {
            this.text = text;
            this.times = times;
            this.num = num;
            totalTime +=times;
        }

        public void run() {
            while(i < totalTime){
                synchronized (lock) {
                    while (num != s8q1.counter) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    if(i<=times)
                    System.out.println(text + ": Times " + i);
                    i++;
                    s8q1.counter = (s8q1.counter + 1) % 3;
                    lock.notifyAll();
                    if(i<=times){
                        try {
                            Thread.sleep(500);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    
                }
            }
        }
    }

    public static void main(String[] args) {

        Thread thread1 = new Thread(new PrintText("COVID19", 10, 0));
        Thread thread2 = new Thread(new PrintText("LOCKDOWN2020", 20, 1));
        Thread thread3 = new Thread(new PrintText("VACCINATED2021", 30, 2));

        thread1.start();
        thread2.start();
        thread3.start();
    }
}