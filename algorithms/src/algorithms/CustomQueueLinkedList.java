package algorithms;

import java.util.Iterator;

/**
 * Created by BSijtsma on 21-07-2016.
 */
public class CustomQueueLinkedList<Item> implements Iterable {

    private Node lastQueueItem;
    private Node firstQueueItem;
    private int n;

    public void enqueue(Item queueItem) {
        Node oldLastQueueItem = lastQueueItem;
        lastQueueItem = new Node();
        lastQueueItem.setItem(queueItem);
        lastQueueItem.setNext(null);

        if (isEmpty()) {
            firstQueueItem = lastQueueItem;
        } else {
            oldLastQueueItem.setNext(lastQueueItem);
        }

        n++;
    }

    public Item dequeue() {
        if (isEmpty()) {
            lastQueueItem = null;
            throw new NullPointerException();
        }
        Item returnItem = firstQueueItem.getItem();
        firstQueueItem = firstQueueItem.getNext();
        n--;
        return returnItem;
    }

    public int size() {
        return n;
    }

    public boolean isEmpty() {
        return firstQueueItem == null;
    }

    private class Node {
        private Item item;
        private Node next;

        public void setItem(Item item) {
            this.item = item;
        }

        public Item getItem() {
            return item;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        public String toString() {
            return "Node: " + item;
        }
    }

    @Override
    public Iterator iterator() {
        return new CustomQueueLinkedListIterator();
    }

    private class CustomQueueLinkedListIterator implements Iterator <Item>{

        private Node currentQueueItem = firstQueueItem;

        @Override
        public boolean hasNext() {
            return currentQueueItem != null;
        }

        @Override
        public Item next() {
            Item returnItem = currentQueueItem.getItem();
            currentQueueItem = currentQueueItem.getNext();
            return returnItem;
        }

        @Override
        public void remove() {}
    }
}
