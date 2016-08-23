package exercises.Chapter1_3;

/**
 * 1.3.38  Delete kth element. Implement a class that supports the following API:
 public class    generalizedQueue<Item>
 generalizedQueue() create an empty queue
 boolean isEmpty() is the queue empty?
 void insert(Item x) add an item
 Item delete(int k) delete and return the kth least recently inserted item

 First, develop an implementation that uses an array implementation, and then develop one
 that uses a linked-list implementation.
 Note : the algorithms and data structures that we introduce in Chapter 3 make it possible
 to develop an implementation that can guarantee that both insert() and delete() take time
 proportional to the logarithm of the number of items in the queue—see Exercise 3.5.27.

array implementation:
  elements are added to the end of the array, which is pointed to by backQueue (and receives +1)
  the kth element to delete is simply index k. all the elements are then moved by 1 index
  to the front of the queue
 */
public class Exc_1_3_38_GeneralizedQDeleteKLinkedList<Item> implements Exc_1_3_38_GeneralizedQDeleteInterface<Item> {

    private int N;
    private Node frontNode;
    private Node backNode;

    @Override
    public boolean isEmpty() {
        return N == 0;
    }

    @Override
    public void insert(Item item) {
        Node newBackNode = new Node();
        newBackNode.item = item;

        if (isEmpty()) {
            frontNode = newBackNode;
        } else {
            backNode.next = newBackNode;
        }
        backNode = newBackNode;
        N++;
    }

    // Has to keep memory of the previous node, and set the reference to next
    // on the previous node to the one after it to ensure a deletion from the LL
    @Override
    public Item delete(int k) {
        Node tempPrevNode = new Node();
        Node tempNextNode = frontNode;
        if (N < k) {
            throw new NullPointerException("there is no Kth element in the LL");
        }
        for (int i = 0; i < k; i++) {
            tempPrevNode = tempNextNode;
            tempNextNode = tempNextNode.next;
        }
        Item returnItem = tempNextNode.item;
        // exception case for removing the front node
        if (k == 0 ) {
            frontNode = frontNode.next;
        } else if (k == N-1) {
            // exception case for changing the back node
            tempPrevNode.next = null;
            backNode = tempPrevNode;
        } else {
            tempPrevNode.next = tempNextNode.next;
            tempNextNode = null;
        }
        N--;
        return returnItem;
    }

    public String toString() {
        Node newFrontNode = frontNode;
        StringBuilder sb = new StringBuilder();
        while (newFrontNode != null) {
            sb.append(newFrontNode);
            newFrontNode = newFrontNode.next;
        }
        System.out.println(sb.toString());
        return sb.toString();
    }

    private class Node {
        Item item;
        Node next;

        public String toString() {
            return item.toString();
        }
    }
}
