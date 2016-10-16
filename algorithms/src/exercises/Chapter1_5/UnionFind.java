package exercises.Chapter1_5;

/**
 * Created by BSijtsma on 12-10-2016.
 * Dynamic connectivity problem:
 *
 * Given an input sequence of pairs of integers, where each integer represents
 * an object of some type, and we are to interpret the pair p q as meaning
 * p is connected to q, filter out all extraneous pairs: (= same equivalence class).
 * In other words: when the program reads a pair, it should write the pair only if the
 * pairs it has seen up until that point do not imply that p is connected to q. Example:
 *
 *    b
 *  /
 * a----c
 *
 * In the exapmle component aboe, if the pair b c was given, it would be filtered our as the
 * two are already have an equialence relation. (Reflexive, symmetric and transitive).
 *
 *
 * The Union Find API:
 *
 * void union(int p, int q) - add a connection between p and q
 * int find(int p) - component identifier for p (0 to N-1)
 * boolean connected(int p, int q) - return true if p and q are in the same component
 * int count() - the number of components
 *
 * we will use an int[] nodecomponents index to store for each index (node) the respective component.
 * This means that initially each seperate node is its own component
 */
public class UnionFind {

    private int n;
    private int[] nodeComponents;

    public UnionFind(int N) {
        this.n = N;
        private int[] nodeComponents = new int[N];
        for (int i = 0; int i < N; i++) {
            nodeComponents[i] = i;
        }
        this.nodeComponents = nodeComponents;
    }

    public void union(int p, int q) {

    }

    public int find(int p) {

    }

    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }

    public int count() {
        return n;
    }

}
