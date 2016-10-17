package PrintTree;

import java.util.*;

class IntBST {

    IntBSTNode root;

    public IntBST() {
        root = null;
    }

    public void Insert(int el) {
        IntBSTNode p = root;
        IntBSTNode parent = null;
        while (p != null) {
            parent = p;
            if (p.key > el) {
                p = p.left;
            } else {
                p = p.right;
            }
        }
        if (root == null) {
            root = new IntBSTNode(el, null, null);
        } else if (parent.key > el) {
            parent.left = new IntBSTNode(el, null, null);
        } else {
            parent.right = new IntBSTNode(el, null, null);
        }
    }

    public void clear() {
        root = null;
    }

    //////////////////////////////////////////////////////////////////
    /* Print tree left rotation */
    public void visit(IntBSTNode p, int indent, int space) {
        if (p != null) {
            for (int i = space; i < indent; i++) {
                System.out.print("-");
            }
            System.out.println((char) p.key);
        }
    }

    public void printRotationLeftByInorder(IntBSTNode p, int indent, int space) {
        if (p != null) {
            indent = indent + space;
            printRotationLeftByInorder(p.right, indent, space);
            visit(p, indent, space);
            printRotationLeftByInorder(p.left, indent, space);
        }
    }

    ///////////////////////////////////////////////////////////
    /*
        Print tree normal using BFS
     */
    public int findHeight(IntBSTNode p) {
        if (p == null) {
            return 0;
        } else {
            int leftHeight = findHeight(p.left);
            int rightHeight = findHeight(p.right);
            if (leftHeight > rightHeight) {
                return leftHeight + 1;
            } else {
                return rightHeight + 1;
            }
        }
    }

    void distanceBetweenLevel(int height) {
        for (int i = 0; i < height; i++) {
            System.out.println("");
        }
    }

    void distanceBetweenNode(int indent) {
        for (int i = 0; i < indent; i++) {
            System.out.print(" ");
        }
    }

    public void printTreeByBFS(int height) {
        IntBSTNode p = root;
        Queue<IntBSTNode> queue = new LinkedList();
        IntBSTNode EmptyNode = new IntBSTNode();
        int indentFromStart = (int) Math.pow(2, height + 1);
        int indent = indentFromStart;

        queue.offer(p);
        queue.offer(null);
        while (queue.isEmpty() == false) {
            p = queue.poll();
            if (p == null) {
                if (queue.isEmpty() == false) {
                    queue.offer(null);
                    distanceBetweenLevel(height);
                    indent = indentFromStart;
                    indentFromStart = (int) indentFromStart / 2;
                    p = queue.poll();
                    System.out.println();
                    distanceBetweenNode(indentFromStart);
                    if (p != EmptyNode) {
                        System.out.print(p.key);
                    } else {
                        System.out.print("");
                    }
                    if (p.left != null) {
                        queue.offer(p.left);
                    }
                    if (p.left == null && p != EmptyNode) {
                        queue.offer(EmptyNode);
                    }

                    if (p.right != null) {
                        queue.offer(p.right);
                    }
                    if (p.right == null && p != EmptyNode) {
                        queue.offer(EmptyNode);
                    }
                }
            } else {
                distanceBetweenNode(indent);
                if (p != EmptyNode) {
                    System.out.print(p.key);
                } else {
                    System.out.print(" ");
                }

                if (p.left != null) {
                    queue.offer(p.left);
                }
                if (p.left == null && p != EmptyNode) {
                    queue.offer(EmptyNode);
                }

                if (p.right != null) {
                    queue.offer(p.right);
                }
                if (p.right == null && p != EmptyNode) {
                    queue.offer(EmptyNode);
                }
            }
        }
    }
}
