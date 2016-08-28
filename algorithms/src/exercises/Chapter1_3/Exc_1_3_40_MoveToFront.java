package exercises.Chapter1_3;

/**
 * Created by Bas on 28-8-2016.
 * 1.3.40 Move-to-front. Read in a sequence of characters from standard input and
 maintain the characters in a linked list with no duplicates. When you read in a previously
 unseen character, insert it at the front of the list. When you read in a duplicate
 character, delete it from the list and reinsert it at the beginning. Name your program
 MoveToFront: it implements the well-known move-to-front strategy, which is useful for
 caching, data compression, and many other applications where items that have been
 recently accessed are more likely to be reaccessed.

 Instead of std input, use an insert function for easier testing/lazyness
 */
public class Exc_1_3_40_MoveToFront <Item> {

    private Node frontNode;

    private void Insert(Item item) {
        Node tempNode = frontNode;
        Node newNode = new Node();
        newNode.item = item;

        while (tempNode != null) {
            // delete from list.
            if (tempNode.item == item) {
                // first check exception case if its the last node in the list
                if (tempNode.next == null) {
                    tempNode = null;
                } else {
                    tempNode.item = tempNode.next.item;
                    tempNode.next = tempNode.next.next;
                }
            }
            tempNode = tempNode.next;
        }
        newNode.next = frontNode;
        frontNode = newNode;
    }



    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node tempNode = frontNode;

        while (tempNode != null) {
            sb.append(tempNode.item);
            tempNode = tempNode.next;
        }
        return sb.toString();
    }

    private class Node {
        public Node next;
        public Item item;
    }

}
