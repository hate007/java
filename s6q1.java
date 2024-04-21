import java.util.*;

public class s6q1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of integers: ");
        int n = scanner.nextInt();
        TreeSet<Integer> numbers = new TreeSet<>();
        System.out.println("Enter the integers:");
        for (int i = 0; i < n; i++) {
            int num = scanner.nextInt();
            numbers.add(num);
        }

        System.out.println("Integers in sorted order:");
        for (int num : numbers) {
            System.out.println(num);
        }

        System.out.print("Enter the integer to search: ");
        int searchNum = scanner.nextInt();
        if (numbers.contains(searchNum)) {
            System.out.println("The integer " + searchNum + " is present in the collection.");
        } else {
            System.out.println("The integer " + searchNum + " is not present in the collection.");
        }
        scanner.close();
    }
}
