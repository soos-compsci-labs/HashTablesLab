public class Tree<anyType extends Comparable<anyType>> {
    private TreeNode myRoot;

    public Tree() {
        myRoot = null;
    }

    public void add(anyType x) {
        myRoot = addHelper(myRoot, x);
    }


    private TreeNode addHelper(TreeNode root, anyType x) {
        if (root == null) {
            root = new TreeNode(x);
            return root;
        }
        // if x is less than root, add it to the left subtree
        if (x.compareTo((anyType) root.getValue()) < 0) {
            root.setLeft(addHelper(root.getLeft(), x));
        }
        // if x is greater than root, add it to the right subtree
        else if (x.compareTo((anyType) root.getValue()) > 0) {
            root.setRight(addHelper(root.getRight(), x));
        }
        //************************************************************
        return root;
    }

    public void remove(anyType x) {
        myRoot = removeHelper(myRoot, x);
    }

    private TreeNode removeHelper(TreeNode root, anyType x) {
        //************COMPLETE THIS METHOD*****************************
        // if root is null, return null
        if (root == null) {
            return null;
        }
        // if x is less than root, remove it from the left subtree
        if (x.compareTo((anyType) root.getValue()) < 0) {
            root.setLeft(removeHelper(root.getLeft(), x));
        }
        // if x is greater than root, remove it from the right subtree
        else if (x.compareTo((anyType) root.getValue()) > 0) {
            root.setRight(removeHelper(root.getRight(), x));
        }
        // if x is equal to root, remove it
        else {
            // if root has no children, return null
            if (root.getLeft() == null && root.getRight() == null) {
                return null;
            }
            // if root has one child, return the child
            else if (root.getLeft() == null) {
                return root.getRight();
            } else if (root.getRight() == null) {
                return root.getLeft();
            }
            // if root has two children, replace root with the smallest value in the right subtree
            else {
                TreeNode temp = root.getRight();
                // getting the maximum value in the left subtree
                while (temp.getRight() != null) {
                    temp = temp.getRight();
                }
                root.setValue(temp.getValue());
                root.setLeft(removeHelper(root.getLeft(), (anyType) temp.getValue()));
            }
        }
        //************************************************************
        return root;
    }

    public TreeNode search(anyType x) {
        return searchHelper(myRoot, x);
    }

    private TreeNode searchHelper(TreeNode root, anyType x) {
        //************COMPLETE THIS METHOD*****************************
        // if root is null, return null
        if (root == null) {
            return null;
        }
        // if x is less than root, search the left subtree
        if (x.compareTo((anyType) root.getValue()) < 0) {
            return searchHelper(root.getLeft(), x);
        }
        // if x is greater than root, search the right subtree
        else if (x.compareTo((anyType) root.getValue()) > 0) {
            return searchHelper(root.getRight(), x);
        }
        // if x is equal to root, return root
        else {
            return root;
        }
    }
}