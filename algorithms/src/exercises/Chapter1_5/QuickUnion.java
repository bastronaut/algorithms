package exercises.Chapter1_5;

/**
 * Created by Bas on 16-10-2016.
 *
 * similar to quickfind in the data structure, except the values are
 * interpreted differently: the values are 'links' to one another.
 *  The data forms a tree structure. In order to check whether items
 *  are in the same component, check until you reach the rootcomponent.
 *  If they are shared, union is not required. Otherwise, connect one
 *  of the root compomenents to the other/
 *
 *
 * Parent-> child link
 *
 */
public class QuickUnion implements UnionFind {

    private int n;
    private int[] nodeComponents;

    // init self referencing nodes
    public QuickUnion(int nrOfNodes) {
        nodeComponents = new int[nrOfNodes];
        for (int i =0; i< nrOfNodes; i++) {
            nodeComponents[i] = i;
        }
    }

    @Override
    public void union(int p, int q) {

    }

    // search for the root node recursively
    @Override
    public int find(int p) {
        if (nodeComponents[p] == p) {
            return p;
        } else {
            return find(p);
        }
    }

    @Override
    public boolean isConnected(int p, int q) {
        if (find(p) == find(q)) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public int count() {
        return n;
    }
}
