package learn.dsa;

import java.util.*;

public class Queues {
    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(10);
        queue.add(20);
        queue.add(30);

        IO.println("Queue elements: " + queue);
        IO.println("Removed element: " + queue.remove());
        IO.println("Queue after removal: " + queue);

        queue.add(10);
        IO.println("Queue after adding 10: " + queue);

        IO.println(queue.poll());
        queue.forEach(e -> {System.err.println(e);});
        // Poll removes and returns the head of the queue, or returns null if the queue is empty
        // Difference between remove() and poll() is that remove() throws an exception if the queue is empty
        // So in this case, poll is a safer choice to use because it doesn't throw an exception
        IO.println("Queue after poll: " + queue);
    }
}
