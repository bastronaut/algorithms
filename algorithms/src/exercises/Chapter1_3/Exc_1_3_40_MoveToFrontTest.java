package exercises.Chapter1_3;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * 1.3.40 Move-to-front. Read in a sequence of characters from standard input and
 maintain the characters in a linked list with no duplicates. When you read in a previously
 unseen character, insert it at the front of the list. When you read in a duplicate
 character, delete it from the list and reinsert it at the beginning. Name your program
 MoveToFront: it implements the well-known move-to-front strategy, which is useful for
 caching, data compression, and many other applications where items that have been
 recently accessed are more likely to be reaccessed.

 Instead of std input, use an insert function for easier testing/lazyness
 */
public class Exc_1_3_40_MoveToFrontTest {

    @Test
    public void testInsert() {
        Exc_1_3_40_MoveToFront MTF = new Exc_1_3_40_MoveToFront();

    }
}