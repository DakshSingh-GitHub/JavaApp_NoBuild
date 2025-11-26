package learn.dsa;

import java.util.ArrayList;
import java.util.LinkedList;

// In java, ArrayLists are preferred for faster access over the contents, they are useful where we have to store large datasets, with a very rare use of insertion and deletion
// Linked Lists use doubly linked lists, nodes joined with pointers, because of these pointers, LinkedLists are larger load on memory, but are preferred in cases where we prefer addition and deletion of records to be faster

// Use ArrayList when you need fast lookups and iteration.
// Use LinkedList when you need frequent insertions/deletions.

public class CollectionClasses {
    public static void main(String[] args) {
        // ArrayList Example
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(10);
        arrayList.add(20);
        System.out.println(arrayList.get(1)); // Fast O(1)

        // LinkedList Example
        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.add(10);
        linkedList.add(20);
        linkedList.addFirst(5); // Efficient O(1)
        System.out.println(linkedList.get(1)); // Slower O(n)
    }
}
