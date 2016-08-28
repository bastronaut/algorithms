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

    public void insert(Item item) {
        Node newNode = new Node();
        newNode.item = item;

        removeIfExists(item);

        newNode.next = frontNode;
        frontNode = newNode;
    }


    public void removeIfExists(Item item) {
        if (frontNode == null) {
            return;
        } else {
            Node tempNode = frontNode;

            while (tempNode != null) {
                if (tempNode.item == item) {
                    // check for exception case if its last node in list
                    if (tempNode.next == null) {
                        tempNode.item = null;
                        tempNode = null;
                        break;
                    } else {
                        tempNode.item = tempNode.next.item;
                        tempNode.next = tempNode.next.next;
                    }
                }
                tempNode = tempNode.next;
            }
        }
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

        public String toString() {
            return item.toString();
        }
    }

}
