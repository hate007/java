import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.Scanner;

public class s23q2 {

    public static void main(String[] args) {

        ArrayList<String> studentNames = new ArrayList<>();

        for (String arg : args) {
            studentNames.add(arg);
        }

        System.out.println("\nDisplaying student names using Iterator:");
        Iterator<String> iterator = studentNames.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        System.out.println("\nDisplaying student names using ListIterator (forward):");
        ListIterator<String> listIterator = studentNames.listIterator();
        while (listIterator.hasNext()) {
            System.out.println(listIterator.next());
        }

        System.out.println("\nDisplaying student names using ListIterator (backward):");
        
        while (listIterator.hasPrevious()) {
            System.out.println(listIterator.previous());
        }
    }
}
