import java.util.*;

public class s16q1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TreeSet<String> colorSet = new TreeSet<>();
        System.out.print("How many colors would you like to add? ");
        int numberOfColors = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i < numberOfColors; i++) {
            System.out.print("Enter a color: ");
            String color = scanner.nextLine();
            colorSet.add(color);
        }

        System.out.println("\nColors in TreeSet (Ascending Order):");
        for (String color : colorSet) {
            System.out.println(color);
        }
        scanner.close();
    }
}
