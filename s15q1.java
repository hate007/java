public class s15q1 {
    public static void main(String[] args) {

        Thread thread = new Thread(new Runnable() {
            public void run(){
            System.out.println("Thread Name: " + Thread.currentThread().getName());
            System.out.println("Thread Priority: " + Thread.currentThread().getPriority());
            }
        });
        thread.setName("MYThread");
        thread.setPriority(Thread.MAX_PRIORITY);
        thread.start();
    }
}
