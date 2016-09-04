package exercises.Chapter1_3;

/**
 Copy a stack. Create a new constructor for the linked-list implementation of
 Stack so that
 Stack<Item> t = new Stack<Item>(s);
 makes t a reference to a new and independent copy of the stack s
 */
public class Exc_1_3_42_CopyStack <Item> {

    private Node topstackNode;
    private int N;

    public Exc_1_3_42_CopyStack() {

    }

    public Exc_1_3_42_CopyStack(Exc_1_3_42_CopyStack stackToCopy) {

        // easiest way to copy a stack: use two stacks
        Exc_1_3_42_CopyStack<Item> tempCopy = new Exc_1_3_42_CopyStack();

        // lazy casting for exercise purposes
        while (!stackToCopy.isEmpty()) {
            tempCopy.push((Item) stackToCopy.pop());
        }
        while (!tempCopy.isEmpty()) {
            Item tempItem = tempCopy.pop();
            Node newNode = new Node();
            newNode.item = tempItem ;
            if (!isEmpty()) {
                newNode.next = topstackNode;
            }
            topstackNode = newNode;
            N++;

            // reset original stack
            stackToCopy.push(tempItem);
        }

    }

    public Item pop() {
        if (isEmpty()) {
            throw new NullPointerException("stack is empty");
        }
        Item returnItem = topstackNode.item;
        topstackNode = topstackNode.next;
        N--;
        return returnItem;
    }

    public void push(Item item) {
        Node newNode = new Node();
        newNode.item = item;
        if (!isEmpty()) {
            newNode.next = topstackNode;
        }
        topstackNode = newNode;
        N++;
    }

    public int size() {
        return N;
    }

    public boolean isEmpty() {
        return N == 0;
    }

    private class Node {
        Item item;
        Node next;

        // will only be used for ints for excercise so thisll do
        public String toString() {
            return item.toString();
        }
    }
}
