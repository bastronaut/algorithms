package exercises.Chapter1_3;

/**
 * 1.3.29 Write a Queue implementation that uses a circular linked list, which is the same
 as a linked list except that no links are null and the value of last.next is first whenever
 the list is not empty. Keep only one Node instance variable (last).
 last is the most recently added node/
 */
public class Exc_1_3_29_CircularLinkedListQueue <Item> {

    int N;
    Node lastNode;

    
    public Exc_1_3_29_CircularLinkedListQueue() {
        N = 0;
        lastNode = null;
    }


    public void enqueue(Item item) {
        Node newNode = new Node();
        newNode.item = item;
        if (isEmpty()) {
            newNode.next = newNode;
        } else {
            newNode.next = lastNode.next;
            lastNode.next = newNode;
        }
        lastNode = newNode;
        N++;
    }


    public Item dequeue() {
        if (isEmpty()) {
            throw new NullPointerException("empty queue");
        }
        Item returnItem = lastNode.next.item;
        if (lastNode.next == lastNode) {
            lastNode = null;
        } else {
            lastNode.next = lastNode.next.next;
        }
        N--;
        return returnItem;
    }


    public boolean isEmpty() {
        return lastNode == null;
    }


    public int size() {
        return N;
    }


    public String printLinkedList() {
        StringBuilder sb = new StringBuilder();
        Node tempNode = lastNode.next;
        for (int i = 0; i < N; i ++) {
            sb.append(tempNode.item + "; ");
            tempNode = tempNode.next;
        }
        return sb.toString();
    }

    private class Node {
        Item item;
        Node next;
    }
}
