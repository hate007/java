import java.util.Scanner;

public class s23q1 implements Runnable {
    String inputString;

    public s23q1(String inputString) {
        this.inputString = inputString;
    }

    public void run() {
        for (char c : inputString.toCharArray()) {
            if (isVowel(c)) {
                System.out.println("Vowel found: " + c);
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    System.err.println("Thread interrupted: " + e.getMessage());
                }
            }
        }
        System.out.println("Finished displaying vowels.");
    }

    boolean isVowel(char c) {
        return "AEIOUaeiou".indexOf(c) != -1;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String userInput = scanner.nextLine();

        s23q1 vowelDisplay = new s23q1(userInput);

        Thread thread = new Thread(vowelDisplay);
        thread.start();
    }
}
