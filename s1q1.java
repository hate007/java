public class s1q1{
    public static char alphabet = 'A';
    public static void main(String[] args) {
        Thread alphabetThread = new Thread( new Runnable() {
            public void run(){
                while(alphabet<='Z'){
                    System.out.print(alphabet + " ");
                    alphabet++;
                    try{
                        Thread.sleep(2000);
                    }
                    catch(InterruptedException e){
                        e.printStackTrace();
                    }

                }
            }
        });
        alphabetThread.start();
    }
}