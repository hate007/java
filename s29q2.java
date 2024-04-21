import java.util.*;

public class s29q2 {
    public static void main(String[] args) {
        LinkedList<Integer> linkedList = new LinkedList<>();

        linkedList.addFirst(10);
        System.out.println("After adding 10 at first position: " + linkedList);

        linkedList.add(20);
        linkedList.add(30);
        linkedList.add(40);

        System.out.println("LinkedList after adding more elements: " + linkedList);

        if (!linkedList.isEmpty()) {
            linkedList.removeLast();
        }
        System.out.println("After deleting the last element: " + linkedList);

        int size = linkedList.size();
        System.out.println("Size of the LinkedList: " + size);
    }
}
