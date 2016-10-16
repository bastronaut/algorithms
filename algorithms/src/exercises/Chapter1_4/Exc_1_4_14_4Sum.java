package exercises.Chapter1_4;

/**
 * Develop an algorithm for the 4sum problem
 * 4 sum problem: are there a combination of elements in an array
 * arrays that sum up to 0?
 *
 * The array is sorted
 * The array contain ints
 * The array does not contain duplicates
 *
 * approach: add the first 3 elements, then binary search for the
 * negative of that element
 */
public class Exc_1_4_14_4Sum {

    private int[] sortedArray;
    public Exc_1_4_14_4Sum(int[] sortedArray) {
        this.sortedArray = sortedArray;
    }

    public int count4Sum() {
        return 0;
    }
}
