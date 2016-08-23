package exercises.Chapter1_3;

/**
 * 1.3.38  Delete kth element. Implement a class that supports the following API:
 public class    generalizedQueue<Item>
 generalizedQueue() create an empty queue
 boolean isEmpty() is the queue empty?
 void insert(Item x) add an item
 Item delete(int k) delete and return the kth least recently inserted item
 S
 First, develop an implementation that uses an array implementation, and then develop one
 that uses a linked-list implementation.
 Note : the algorithms and data structures that we introduce in Chapter 3 make it possible
 to develop an implementation that can guarantee that both insert() and delete() take time
 proportional to the logarithm of the number of items in the queue—see Exercise 3.5.27.

 */
interface Exc_1_3_38_GeneralizedQDeleteInterface <Item> {
    boolean isEmpty();
    void insert(Item x);
    Item delete(int k);
}
