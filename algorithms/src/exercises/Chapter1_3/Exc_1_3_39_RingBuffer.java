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
 However, if this value has not yet been read, it will throw an expcetion

 API:

 void deposit
 item read


 wil thwor an exception whenver the new case is done
 */
public class Exc_1_3_39_RingBuffer<Item> {
    private final int RINGBUFFERSIZE = 4;
    Item[] ringBuffer = (Item[]) new Object[RINGBUFFERSIZE];

    Exc_1_3_39_RingBuffer(Item[] inititems) {
        for (int i = 0; i < RINGBUFFERSIZE; i++) {
            try {
                ringBuffer[i] = inititems[i];
            } catch (Exception e) {
                // in case less inititems are given than RINGBUFFERSIZE
                break;
            }
        }
    }

}
