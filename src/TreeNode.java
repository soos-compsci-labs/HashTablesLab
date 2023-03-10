public class TreeNode<anyType extends Comparable> {
    private anyType value;  //can be any type of object that implements Comparable
    private TreeNode left;     //points to left subtree
    private TreeNode right;    //points to right subtree

    //constructors
    public TreeNode(anyType v, TreeNode l, TreeNode r) {
        value = v;
        left = l;
        right = r;
    }

    public TreeNode(anyType v) {
        value = v;
        left = null;
        right = null;
    }

    public anyType getValue() //accessor methods
    {
        return value;
    }

    //mutator methods
    public void setValue(anyType v) {
        value = v;
    }

    public TreeNode getLeft() {
        return left;
    }

    public void setLeft(TreeNode l) {
        left = l;
    }

    public TreeNode getRight() {
        return right;
    }

    public void setRight(TreeNode r) {
        right = r;
    }
}


