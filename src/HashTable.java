public class HashTable {
    // use Tree and TreeNode classes from previous lab, they are going to be used for collision resolution

    // hash table for DataItem class

    public static int collisions = 0;
    private final Tree[] hashTable = new Tree[1000]; // limited to 1000 for this lab, but there are 10000 data items so probing will be used (binary trees)

    // number of items in the hash table
    public HashTable() {

    }

    public void add(DataItem item) {
        // get the hash code for the data item
        int hashCode = item.hashCode();
        // get the index for the hash code
        int index = hashCode % hashTable.length;
        // if the index is empty, create a tree, add the data item to the tree, and add the tree to the hash table
        if (hashTable[index] == null) {
            Tree tree = new Tree();
            tree.add(item);
            hashTable[index] = tree;
        } else {
            // if the index is not empty, add the data item to the tree
            hashTable[index].add(item);
            collisions++;
        }
    }

    public DataItem get(String word) {
        // get the hash code for the data item
        int hashCode = DataItem.hashCode(word);
        // get the index for the hash code
        int index = hashCode % hashTable.length;
        // if the index is empty, return null
        if (hashTable[index] == null) {
            return null;
        } else {
            // get the data item from the tree use Tree.search(), convert the word to a DataItem, and return the data item
            TreeNode searched = hashTable[index].search(new DataItem(0, word));
            if (searched == null) {
                return null;
            } else {
                return (DataItem) searched.getValue();
            }

        }
    }

}
