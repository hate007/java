import java.util.*;

public class s3q2 {
    public static void main(String[] args) {
        LinkedList<String> stringList = new LinkedList<>();
        stringList.add("Aman");
        stringList.add("Abhishek");
        stringList.add("Shruti");
        stringList.add("Saurabh");
        System.out.println("Original List: " + stringList);
        stringList.removeFirst();
        System.out.println("List after deleting the first element: " + stringList);
        
        System.out.println("List contents in reverse order:");
        ListIterator<String> iterator = stringList.listIterator(stringList.size());
        while (iterator.hasPrevious()) {
            System.out.println(iterator.previous());
        }
    }
}
