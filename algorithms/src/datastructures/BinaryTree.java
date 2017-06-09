package datastructures;

/**
 * Created by BSijtsma on 09-06-2017.
 * A tree data structure in which a node has at most 2 children:
 * left and right, and a data element. Topmost node is the root.
 * terminology:
 * - depth of a node is the nr of edges from root to node
 * - height of a node is nr of edges frmo node to deepest leaf
 * - ful binary tree each noe has exactly zero or two children
 * - complete binary tree is completely filled, exception of bottom
 * which is filled left to right.
 *
 * Traversals:
 * 1. Depth-first
 *  preOrder traversal - parent first, then left and right
 *  inOrder traversal - visit left child then parent, then right child
 *  PostOrder traversal - visit left child, then right, then parent
 *
 * 2. Breadth-first
 * Only 1 kind, level order traversal. Top to bottom and left to right,
 * as if reading a page on a book. 
 * **/
public class BinaryTree {


  private class Node <T> {

    Node left;
    Node right;
    T value;

    private Node(Node left, Node right) {
      this.left = left;
      this.right = right;
    }
  }

}


