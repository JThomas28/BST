import java.util.ArrayList;

/**
 * Bst implements the BstADT. Bst essentially creates a binary search tree of
 * BSTNodes
 * 
 * @author JonathanThomas
 * @version 4/9/16
 */
@SuppressWarnings("rawtypes")
public class Bst implements BstADT {
    /**
     * root is the root node of the binary search tree
     */
    private BSTNode root;

    /**
     * treeSize is the size of the binary search tree. Increased each time a new
     * Node is added
     */
    private int treeSize;

    /**
     * keys is an arrayList of the key values of the nodes in a binary tree.
     * Used to make a preOrder string
     */
    private ArrayList<String> keys = new ArrayList<String>();

    /**
     * Helper method used to find the element with the specific key.
     * 
     * @param rt
     *            - root node of tree
     * @param e
     *            - key value. Value we are looking for
     * @return - value of comparable with the key
     */
    @SuppressWarnings("unchecked")
    private Comparable findHelp(BSTNode rt, Comparable e) {
        if (rt == null) {
            return null;
        }
        if (rt.element().compareTo(e) > 0) {
            return findHelp(rt.left(), e);
        }
        else if (rt.element().compareTo(e) == 0) {
            return rt.element();
        }
        else {
            return findHelp(rt.right(), e);
        }
    }

    /**
     * insert helper method. Inserts e into binary tree whose root is n
     * 
     * @param n
     *            - root of tree that the value is being entered in
     * @param e
     *            - value to be entered into the node
     * @return n - root of tree. Tree now has value in it
     */
    @SuppressWarnings("unchecked")
    private BSTNode insertHelp(BSTNode n, Comparable e) {
        if (n == null) {
            treeSize += 1;
            return new BSTNode(e);
        }
        if (n.element().compareTo(e) > 0) {
            n.setLeft(insertHelp(n.left(), e));
        }
        else if (n.element().compareTo(e) < 0) {
            n.setRight(insertHelp(n.right(), e));
        }
        else {
            // duplicate key, don't insert
            return n;
        }
        return n;
    }

    /**
     * helper for preOrder. Goes through tree with root n and adds the keys of
     * the nodes it visits (pre-ordered)
     * 
     * @param n
     *            - root of tree to be preOrdered
     */
    private void preOrderHelp(BSTNode n) {
        if (n == null) {
            return;
        }
        else {
            keys.add(n.element().toString());
            preOrderHelp(n.left());
            preOrderHelp(n.right());
        }
    }

    /**
     * Returns the maximum value in the binary search tree
     * 
     * @param n
     *            - root node of the tree
     * @return maximum value in the tree
     */
    private Comparable maxValNode(BSTNode n) {
        if (n == null) {
            return null;
        }
        else if (n.right() == null) {
            return n.element();
        }
        else {
            return maxValNode(n.right());
        }
    }

    /**
     * helper method to find height of a tree with root n
     * 
     * @param n
     *            - root node of the tree whose height is to be found
     * @return height of the tree
     */
    private int heightHelper(BSTNode n) {
        if (n == null) {
            return 0;
        }
        else {
            return 1 + Math.max(heightHelper(n.left()), 
                    heightHelper(n.right()));
        }
    }

    /**
     * Remove helper method. Removes element whose key matches val
     * 
     * @param n
     *            - root node of tree whose val we are removing
     * @param val
     *            - key to compare to nodes in the tree
     * @return n - root of tree after element removed
     */
    @SuppressWarnings("unchecked")
    private BSTNode removeHelper(BSTNode n, Comparable val) {
        //looking for element
        if (n == null) {
            return n; // Item not found; do nothing
        }
        if (val.compareTo(n.element()) < 0) {
            n.setLeft(removeHelper(n.left(), val));
        }
        else if (val.compareTo(n.element()) > 0) {
            n.setRight(removeHelper(n.right(), val));
        }
        
        //found element
        else if (n.left() != null && n.right() != null) { // Two children
            n.key = findMin(n.right()).element();
            n.setRight(removeHelper(n.right(), n.element()));
        }
        else {
            if (n.left() != null) {
                n = n.left();
                treeSize -= 1;
            }
            else {
                n = n.right();
                treeSize -= 1;
            }
        }
        return n;
    }

    /**
     * Finds minimum value in a tree of root t
     * 
     * @param t
     *            - root of tree whose minimum val is to be found
     * @return minimum value of tree with root t
     */
    private BSTNode findMin(BSTNode t) {
        if (t == null) {
            return null;
        }
        else if (t.left() == null) {
            return t;
        }
        else {
            return findMin(t.left());
        }
    }

    /**
     * Binary search tree constructor. Initializes an empty tree of size 0
     */
    public Bst() {
        this.root = null;
        treeSize = 0;
    }

    /**
     * Implementation of insert method from BstADT
     * 
     * @param item
     *            - item to be inserted into the tree
     */
    public void insert(Comparable item) {
        this.root = insertHelp(this.root, item);
    }

    /**
     * Implementation of elementWithKey method from BstADT
     * 
     * @param key
     *            - key to compare to keys of tree's nodes
     * @return element whose key matches key passed in
     */
    public Comparable elementWithKey(Comparable key) {
        return findHelp(root, key);
    }

    /**
     * Implementation of removeElementWithKey method from BstADT removes element
     * whose key matches key
     * 
     * @param key
     *            - key to be compared
     */
    public void removeElementWithKey(String key) {
        removeHelper(this.root, key);
    }

    /**
     * Implementation of preorderString method from BstADT.
     * 
     * @return preOrdered - string of the keys of the elements in the tree
     *         pre-ordered
     */
    public String preorderString() {
        String preOrdered = "{";
        preOrderHelp(this.root);

        if (keys.size() == 0) {
            return "{}";
        }
        else {
            for (int i = 0; i < keys.size() - 1; i++) {
                preOrdered += keys.get(i) + ", ";
            }
            preOrdered += keys.get(keys.size() - 1);
            return preOrdered + "}";
        }
    }

    /**
     * Implementation of maximumElement method from BstADT
     * 
     * @return maxValue - maximum node in the tree
     */
    public Comparable maximumElement() {
        return maxValNode(root);
    }

    /**
     * Implementation of height method from BstADT
     * 
     * @return height - height of the tree
     */
    public int height() {
        return heightHelper(this.root);
    }

    /**
     * Implementation of size method from BstADT
     * 
     * @return treeSize - size of the tree (number of nodes in the tree)
     */
    public int size() {
        return treeSize;
    }

    // public static void main(String[] args) {
    // Bst tree = new Bst();
    // tree.insert("f");
    // tree.insert("b");
    // tree.insert("d");
    // tree.insert("g");
    // tree.insert("z");
    // tree.insert("a");
    // System.out.println(tree.preorderString());
    // System.out.println(tree.elementWithKey("g"));
    // System.out.println(tree.elementWithKey("y"));
    // System.out.println(tree.size());
    // System.out.println(tree.maximumElement());
    // }
}
