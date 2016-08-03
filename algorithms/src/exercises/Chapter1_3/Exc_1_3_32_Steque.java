package exercises.Chapter1_3;

/**
 * 1.3.32      Steque. A stack-ended queue or steque is a data type
 * that supports push, pop, and enqueue. Articulate an API for this ADT.
 * Develop a linked-list-based implementation.
 *
 * API:
 *
 * A stack with a enqueue operation that adds a node at the beginning of the stack
 *
 * Item pop()
 * void push(Item)
 * void enqueue(Item)
 * boolean isEmpty()
 * int size()
 */
public class Exc_1_3_32_Steque <Item> {

    private int N;
    private Node bottomStequeNode;
    private Node topStequeNode;

    public void push(Item item) {
        Node newTopStequeNode = new Node();
        newTopStequeNode.item = item;
        newTopStequeNode.next = topStequeNode;
        if (isEmpty()) {
            bottomStequeNode = newTopStequeNode;
        } else {
            topStequeNode.previous = newTopStequeNode;
        }
        topStequeNode = newTopStequeNode;
        N++;
    }

    public void enqueue(Item item) {
        Node newBottomStequeNode = new Node();
        newBottomStequeNode.item = item;
        if (isEmpty()) {
            topStequeNode = newBottomStequeNode;
        } else {
            newBottomStequeNode.previous = bottomStequeNode;
            bottomStequeNode.next = newBottomStequeNode;
        }
        bottomStequeNode = newBottomStequeNode;
        N++;
    }

    public Item pop() {
        if (isEmpty()) {
            throw new NullPointerException("steque is empty");
        }
        Item returnItem = topStequeNode.item;
        topStequeNode = topStequeNode.next;
        if (topStequeNode == null) {
            bottomStequeNode = null;
        }
        N--;
        return returnItem;
    }

    public boolean isEmpty() {
        return topStequeNode == null;
    }

    public int size() {
        return N;
    }

    public String toString() {
        Node node = topStequeNode;
        StringBuilder sb = new StringBuilder();

        while (node != null) {
            sb.append(node);
            node = node.next;
        }
        return sb.toString();
    }

    private class Node {
        Item item;
        Node next;
        Node previous;

        public String toString() {
            return String.valueOf(this.item);
        }
    }
}
