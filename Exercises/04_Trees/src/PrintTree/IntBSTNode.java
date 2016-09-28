package PrintTree;

public class IntBSTNode {

    public int key;
    IntBSTNode left;
    IntBSTNode right;
    //boolean pred = false, succ = false;

    public IntBSTNode(int k, IntBSTNode l, IntBSTNode r) {
        key = k;
        left = l;
        right = r;
    }
    
    public IntBSTNode() {
        key = Integer.MAX_VALUE;                
    }
}


