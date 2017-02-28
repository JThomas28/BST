/**
 * Binary search tree ADT
 * 
 * @author JonathanThomas
 * @version 3/23/16
 */
@SuppressWarnings("rawtypes")
public interface BstADT {
    /**
     * Inserts the given comparable into the tree
     * 
     * @param item
     *            - comparable to insert
     */
    public void insert(Comparable item);

    /**
     * Returns element associated with the given key
     * 
     * @param key
     *            - is comparable object to be used as a key
     * @return the element associated with the tree if it is in tree, false
     *         otherwise
     */
    public Comparable elementWithKey(Comparable key);

    /**
     * Remove from the tree the element associated with the given key. If the
     * tree is empty, nothing is done.
     * 
     * @param key
     *            - is the string associated with the element to be removed
     */
    public void removeElementWithKey(String key);

    /**
     * Get the preorder traversal of this Bst.
     * 
     * @return a string representing the preorder traversal
     */
    public String preorderString();

    /**
     * Retrieve the maximum element from the Bst.
     * 
     * @return maximum element in the tree
     */
    public Comparable maximumElement();

    /**
     * Determines height of the tree
     * 
     * @return the height of the tree
     */
    public int height();

    /**
     * Determines number of nodes in the tree
     * 
     * @return number of nodes in tree
     */
    public int size();
}
