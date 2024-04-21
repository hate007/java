import java.util.*;

public class s2q1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of friends: ");
        int n = scanner.nextInt();
        scanner.nextLine();
        HashSet<String> friendsSet = new HashSet<>();
        for (int i = 0; i < n; i++) {
            System.out.print("Enter name " + (i + 1) + ": ");
            String name = scanner.nextLine();
            friendsSet.add(name);
        }
        scanner.close();
        ArrayList<String> sortedFriends = new ArrayList<>(friendsSet);
        Collections.sort(sortedFriends);
        System.out.println("\nFriends in ascending order:");
        for (String friend : sortedFriends) {
            System.out.println(friend);
        }
    }
}

