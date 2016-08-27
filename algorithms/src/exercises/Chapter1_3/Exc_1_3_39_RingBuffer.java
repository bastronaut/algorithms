package exercises.Chapter1_3;

/**
 Ring buffer. A ring buffer, or  circular queue, is a FIFO data structure
 of a ﬁxed size N. It is useful for transferring data between asynchronous
 processes or for storing log ﬁles. When the buffer is empty, the consumer
 waits until data is deposited; when the buffer is full, the producer waits
 to deposit data. Develop an API for a RingBuffer and an implementation that
 uses an array representation (with circular wrap-around).

 Translated: a ring buffer is a fixed size collection, where
 the end is linked to the beginning. Whenever an item is written
 when the 'end' is reached, it simply restarts and writes at the beginning.
 However, if this value has not yet been read, it will throw an exception   

 API:

 void deposit
 item read

 Throw an exception whenever rules of ringbuffer is full or empty
 */
public class Exc_1_3_39_RingBuffer<Item> {

    private final int RBSIZE = 4;
    private int front = 0;
    private int rear = 0;
    private int N;

    Item[] ringBuffer = (Item[]) new Object[RBSIZE];


    Exc_1_3_39_RingBuffer(Item[] inititems) {
        for (int i = 0; i < RBSIZE; i++) {
            try {
                ringBuffer[i] = inititems[i];
                front++;
            } catch (Exception e) {
                // in case less inititems are given than RBSIZE
                break;
            }
        }
    }

    public void deposit(Item item) {
        if (front-rear > RBSIZE-1) {
            throw new RuntimeException("The buffer is full");
        }
        ringBuffer[front%RBSIZE] = item;
        front++;
    }

    public Item read() {
        if (rear == front) {
            throw new RuntimeException("The buffer is empty");
        }
        Item returnItem = ringBuffer[rear%RBSIZE];
        ringBuffer[rear%RBSIZE] = null;
        rear++;
        return returnItem;
    }

    public int size() {
        return N;
    }

    public String toString() {
        System.out.println("ok to string");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < RBSIZE; i++) {
            sb.append(ringBuffer[(rear + i) % RBSIZE]);
        }
        return sb.toString();
    }



}
