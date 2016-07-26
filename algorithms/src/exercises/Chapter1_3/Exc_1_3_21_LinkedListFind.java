package exercises.Chapter1_3;

/**
 1.3.21 Write a method find() that takes a linked list and
 a string key as arguments and returns true if some node in
 the list has key as its item ﬁeld, false otherwise.

 Solution is simple traversal of linkedlist (worst case N time).
 Doing this anyway to practise implementing Linked List without
 peeking at previous implementations
 */
public class Exc_1_3_21_LinkedListFind<Item> {

    private int N;
    private Node topStackNode;

    public void push(Item item) {
        Node tempTopStackNode = new Node();
        tempTopStackNode.item = item;
        tempTopStackNode.next = topStackNode;
        topStackNode = tempTopStackNode;
        N++;
    }

    public Item pop() {
        if (isEmpty()) {
            throw new NullPointerException();
        }
        Item returnItem = topStackNode.item;
        topStackNode = topStackNode.next;
        N--;
        return returnItem;
    }

    public boolean isEmpty() {
        return topStackNode == null;
    }

    public int size() {
        return N;
    }

    public boolean find(Exc_1_3_21_LinkedListFind<Item> LinkedList, String key) {
        Node tempTopStackNode = topStackNode;
        boolean found = false;
        while (tempTopStackNode != null) {
            if (key.equals(tempTopStackNode.item)) {
                found = true;
            }
            tempTopStackNode = tempTopStackNode.next;
        }
        return found;
    }

    private class Node {
        private Item item;
        private Node next;
    }


}
