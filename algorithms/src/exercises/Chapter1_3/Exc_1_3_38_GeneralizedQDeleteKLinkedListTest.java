package exercises.Chapter1_3;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by BSijtsma on 23-08-2016.
 */
public class Exc_1_3_38_GeneralizedQDeleteKLinkedListTest {
    @Test
    public void insert() throws Exception {
        Exc_1_3_38_GeneralizedQDeleteKLinkedList<Integer> GQ = new Exc_1_3_38_GeneralizedQDeleteKLinkedList();
        GQ.insert(1);
        GQ.insert(2);
        GQ.insert(3);
        GQ.insert(4);
        GQ.toString();
    }

    @Test
    public void delete() throws Exception {
        Exc_1_3_38_GeneralizedQDeleteKLinkedList<Integer> GQ = new Exc_1_3_38_GeneralizedQDeleteKLinkedList();
        GQ.insert(1);
        GQ.insert(2);
        GQ.insert(3);
        GQ.insert(4);

        GQ.delete(0);
        GQ.toString();
    }

}