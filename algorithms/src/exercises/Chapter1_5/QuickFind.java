package exercises.Chapter1_5;

/**
 * Created by Bas on 16-10-2016.
 *
 * QuickFind is not a very good approach; it seems to be quadratic. Why:
 * you need at least 1 array accesses for each call to find(),
 * and between N+3 and 2N+1 array accessess for each call to union.
 *
 * For N, this requires at least N-1 calls to union, and (N+3)(N-1) ~= N^2
 * array accesses
 *
 */
public class QuickFind implements  UnionFind {

    private int n;
    private int[] nodeComponents;


    public QuickFind() {

    }

    // if p and q do not share the same component, they must be merged. This is done by
    // setting each node in p's component to the component of q (or vice versa)
    public void union(int p, int q) {
        int pComponent = find(p);
        int qComponent = find(q);

        if (pComponent == qComponent) {
            return;
        }
        for (int i = 0; i < nodeComponents.length; i++) {
            if (nodeComponents[i] == pComponent) {
                nodeComponents[i] = qComponent;
            }
        }

    }

    public int find(int p) {
        return nodeComponents[p];
    }

    public boolean isConnected(int p, int q) {
        return find(p) == find(q);
    }

    public int count() {
        return n;
    }
}
