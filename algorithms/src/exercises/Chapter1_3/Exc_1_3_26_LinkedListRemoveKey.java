package exercises.Chapter1_3;

/**
 * 1.3.26 Write a method remove() that takes a linked list and a string key as arguments
 and removes all of the nodes in the list that have key as its item field.

 made into a function that belongs to this class; instead of taking a linkedlist as argument
 just use the instantiated object's linkedlist
 */
public class Exc_1_3_26_LinkedListRemoveKey <Item> {

    int N;
    Node topStackNode;

    public Item pop() {
        if (isEmpty()) {
            throw new NullPointerException("the LL is empty");
        }
        Item returnItem = topStackNode.item;
        topStackNode = topStackNode.next;
        N--;
        return returnItem;
    }

    public void push(Item item) {
        Node newTopStackNode = new Node();
        newTopStackNode.item = item;
        newTopStackNode.next = topStackNode;
        topStackNode = newTopStackNode;
        N++;
    }

    public int size() {
        return N;
    }

    public boolean isEmpty() {
        return topStackNode == null;
    }

    private class Node {
        Item item;
        Node next;
    }

    public void remove(String key) {
        if (isEmpty()) {
            throw new NullPointerException("linked list is empty");
        }
        Node tempTopStackNode = topStackNode;

        // Removing a node: we pass the node.item from the next node into the node,
        // and set node.next 1 node forward. A - B - C - D: remove B:
        // A - C - C - D ->  A - C - D , with references removed to the initial C
        // Will not work for node D, so requires a null check
        while (tempTopStackNode != null) {
            if (tempTopStackNode.item.equals(key)) {

                if (tempTopStackNode.next == null) {
                    tempTopStackNode = null;
                } else {
                    tempTopStackNode.item = tempTopStackNode.next.item;
                    tempTopStackNode.next = tempTopStackNode.next.next;
                }
            } else {
                tempTopStackNode = tempTopStackNode.next;
            }
        }

    }

    public String toString() {
        Node tempTopStackNode = topStackNode;
        StringBuilder sb = new StringBuilder();

        while (tempTopStackNode != null) {
            sb.append(tempTopStackNode.item+ "; ");
            tempTopStackNode = tempTopStackNode.next;
        }
        return sb.toString();

    }

}
