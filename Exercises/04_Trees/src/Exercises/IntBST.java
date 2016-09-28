/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exercises;

import java.util.*;

/**
 *
 * @author duclt
 */
class IntBST {

    IntBSTNode root;

    public IntBST() {
        root = null;
    }

    public void clear() {
        root = null;
    }

    public void visit(IntBSTNode p) {
        if (p != null) {
            System.out.print(p.key + " ");
        }
    }

    public IntBSTNode RecursionSearch(IntBSTNode p, int el) {
        if (p == null) {
            return null;
        } else if (p.key == el) {
            return p;
        } else if (p.key > el) {
            return RecursionSearch(p.left, el);
        } else {
            return RecursionSearch(p.right, el);
        }
    }

    public void BreathFirst() {
        if (root == null) {
            System.out.println("No tree");
            return;
        }

        IntBSTNode p = root;
        Queue<IntBSTNode> queue = new LinkedList();
        queue.offer(p);
        while (queue.isEmpty() == false) {
            p = queue.poll();
            visit(p);
            if (p.left != null) {
                queue.offer(p.left);
            }
            if (p.right != null) {
                queue.offer(p.right);
            }
        }
    }

    public void Preorder(IntBSTNode p) {
        if (p != null) {
            visit(p);
            Preorder(p.left);
            Preorder(p.right);
        }
    }

    public void Inorder(IntBSTNode p) {
        if (p != null) {
            Inorder(p.left);
            visit(p);
            Inorder(p.right);
        }
    }

    public void Postorder(IntBSTNode p) {
        if (p != null) {
            Postorder(p.left);
            visit(p);
            Postorder(p.right);
        }
    }

    public IntBSTNode Search(IntBSTNode p, int el) {
        boolean Found = false;
        while (p != null && Found == false) {
            if (el == p.key) {
                Found = true;
            } else if (el < p.key) {
                p = p.left;
            } else {
                p = p.right;
            }
        }
        return p;
    }

    public IntBSTNode Search(int el) {
        return Search(root, el);
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

    public void deleteByMerging(int el) {
        IntBSTNode tmp, node, p = root, prev = null;
        while (p != null && p.key != el) { // find the node p
            prev = p; // with element el;
            if (p.key < el) {
                p = p.right;
            } else {
                p = p.left;
            }
        }
        node = p;
        if (p != null && p.key == el) {
            if (node.right == null) // node has no right child: its left
            {
                node = node.left; // child (if any) is attached to its 
            } // parent;
            else if (node.left == null) // node has no left child: its right
            {
                node = node.right; // child is attached to its parent;
            } else {  // be ready for merging subtrees;
                tmp = node.left; // 1. move left
                while (tmp.right != null) // 2. and then right as far as
                {
                    tmp = tmp.right; // possible;
                }
                tmp.right
                        = // 3. establish the link between
                        node.right;  // the rightmost node of the left
                // subtree and the right subtree;
                node = node.left; // 4.
            }
            if (p == root) {
                root = node;
            } else if (prev.left == p) {
                prev.left = node;
            } else {
                prev.right = node; // 5.
            }
        } else if (root != null) {
            System.out.println("key " + el + " is not in the tree");
        } else {
            System.out.println("the tree is empty");
        }
    }

    public void deleteByCopying(int el) {
        IntBSTNode node, p = root, prev = null;
        while (p != null && p.key != el) { // find the node p
            prev = p;  // with element el;
            if (p.key < el) {
                p = p.right;
            } else {
                p = p.left;
            }
        }
        node = p;
        if (p != null && p.key == el) {
            if (node.right == null) // node has no right child;
            {
                node = node.left;
            } else if (node.left == null) // no left child for node;
            {
                node = node.right;
            } else {
                IntBSTNode tmp = node.left; // node has both children;
                IntBSTNode previous = node; // 1.
                while (tmp.right != null) {  // 2. find the rightmost
                    previous = tmp;  // position in the
                    tmp = tmp.right;  // left subtree of node;
                }
                node.key = tmp.key; // 3. overwrite the reference 
                // of the key being deleted;
                if (previous == node) // if node's left child's
                {
                    previous.left = tmp.left; // right subtree is null;
                } else {
                    previous.right = tmp.left; // 4.
                }
            }
            if (p == root) {
                root = node;
            } else if (prev.left == p) {
                prev.left = node;
            } else {
                prev.right = node;
            }
        } else if (root != null) {
            System.out.println("key " + el + " is not in the tree");
        } else {
            System.out.println("the tree is empty");
        }
    }

    //Exercise 2a
    public int CountNode(IntBSTNode p) {
        if (p == null) {
            return 0;
        } else {
            return CountNode(p.left) + CountNode(p.right) + 1;
        }
    }

    //Exercise 2a - Non-recursive using BFS
    public int CountNode() {
        IntBSTNode p = root;
        int count = 0;
        Queue<IntBSTNode> queue = new LinkedList();
        queue.offer(p);
        while (queue.isEmpty() == false) {
            p = queue.poll();
            count++;
            if (p.left != null) {
                queue.offer(p.left);
            }
            if (p.right != null) {
                queue.offer(p.right);
            }
        }
        return count;
    }

    //Exercise 2b
    public int CountLeaves(IntBSTNode p) {
        if (p != null) {
            if (p.left == null && p.right == null) {
                return 1;
            } else {
                return CountLeaves(p.left) + CountLeaves(p.right);
            }
        }
        return 0;
    }

    //Exercise 2b - Using non-recursive BFS
    public int CountLeaves() {
        IntBSTNode p = root;
        int count = 0;
        Queue<IntBSTNode> queue = new LinkedList();
        queue.offer(p);
        while (queue.isEmpty() == false) {
            p = queue.poll();
            if (p.left != null) {
                queue.offer(p.left);
            }
            if (p.right != null) {
                queue.offer(p.right);
            }
            if (p.left == null && p.right == null) {
                count++;
            }
        }
        return count;
    }

    //Exercise 2c
    public int CountRightChildren(IntBSTNode p) {
        if (p != null) {
            if (p.right != null) {
                return CountRightChildren(p.right) + 1 + CountRightChildren(p.left);
            }
            if (p.left != null) {
                return CountRightChildren(p.right) + CountRightChildren(p.left);
            }
        }
        return 0;
    }

    //Exercise 2c - Using non-recursive
    public int CountRightChildren() {
        IntBSTNode p = root;
        int count = 0;
        Queue<IntBSTNode> queue = new LinkedList();
        queue.offer(p);
        while (queue.isEmpty() == false) {
            p = queue.poll();
            if (p.left != null) {
                queue.offer(p.left);
            }
            if (p.right != null) {
                queue.offer(p.right);
                count++;
            }
        }
        return count;
    }

    //Exercise 2d
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

    //Exercise 2d - Using non-recursive
    public int findHeight() {
        IntBSTNode p = root;
        int height = 0;
        Queue<IntBSTNode> queue = new LinkedList();
        queue.offer(p);
        queue.offer(null);
        while (queue.isEmpty() == false) {
            p = queue.poll();
            if (p == null) {
                if (queue.isEmpty() == false) {
                    queue.offer(null);
                }
                height++;
            } else {
                if (p.left != null) {
                    queue.offer(p.left);
                }
                if (p.right != null) {
                    queue.offer(p.right);
                }
            }
        }
        return height;
    }

    //Exercise 2e
    public void deleteLeaves(IntBSTNode p, IntBSTNode parent) {
        if (CountLeaves(root) == 1) {
            root = null;
            return;
        }
        if (p != null) {
            if (p.left == null && p.right == null) {
                if (parent.left == p) {
                    parent.left = null;
                }
                if (parent.right == p) {
                    parent.right = null;
                }
            } else {
                parent = p;
                deleteLeaves(p.left, parent);
                deleteLeaves(p.right, parent);
            }
        }
    }

    //Exercise 2e - Using non-recursive
    public void deleteLeaves() {
        if (CountLeaves() == 1) {
            root = null;
            return;
        }

        IntBSTNode p = root;
        Queue<IntBSTNode> queue = new LinkedList();
        ArrayList<IntBSTNode> parents = new ArrayList<>();

        queue.offer(p);
        while (queue.isEmpty() == false) {
            p = queue.poll();
            if (p.left != null || p.right != null) {
                parents.add(p);
            }
            if (p.left != null) {
                queue.offer(p.left);
            }
            if (p.right != null) {
                queue.offer(p.right);
            }
            if (p.left == null && p.right == null) {
                for (IntBSTNode parent : parents) {
                    if (parent.left == p) {
                        parent.left = null;
                        break;
                    }
                    if (parent.right == p) {
                        parent.right = null;
                        break;
                    }
                }
            }
        }
    }

    //Exercise 3
    public static boolean isPerfectBalanced() {

    }

    //Exercise 4\
    public static boolean isBST() {

    }

}
