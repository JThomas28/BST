/**
 * This class is used to construct, modify, and access binary search tree nodes
 * 
 * @author JonathanThomas
 * @version 4/9/16
 * @param <T>
 *            is the type of comparable
 */
public class BSTNode<T extends Comparable<T>> {

    /**
     * key is the key associated with the value
     */
    T key;

    /**
     * leftNode is the node to the left of the root node
     */
    BSTNode<T> leftNode;

    /**
     * rightNode is the node to the right of the root node
     */
    BSTNode<T> rightNode;

    /**
     * Node constructor. Initializes the key, left, and right nodes
     * 
     * @param keyVal
     *            - value of the key for the node
     * @param ln
     *            - initializes node to the left of the new node to ln
     * @param rn
     *            - initializes node to the right of the new node to rn
     */
    public BSTNode(T keyVal, BSTNode<T> ln, BSTNode<T> rn) {
        key = keyVal;
        leftNode = ln;
        rightNode = rn;
    }

    /**
     * Simple constructor. takes a key value and assigns it to a new node, then
     * initializes the left and right nodes to null using the default
     * constructor
     * 
     * @param keyVal
     *            - value for the key
     */
    public BSTNode(T keyVal) {
        this(keyVal, null, null);
    }

    /**
     * returns the key. used to identify the nodes
     * 
     * @return key - identifying value given to the node
     */
    public T element() {
        return key;
    }

    /**
     * returns the left node
     * 
     * @return leftNode - node to the left of the root
     */
    public BSTNode<T> left() {
        return leftNode;
    }

    /**
     * sets the left node to n
     * 
     * @param n
     *            - node to be assigned to leftNode
     */
    public void setLeft(BSTNode<T> n) {
        leftNode = n;
    }

    /**
     * returns the right node
     * 
     * @return rightNode - node to the right of the root
     */
    public BSTNode<T> right() {
        return rightNode;
    }

    /**
     * sets the right node to n
     * 
     * @param n
     *            - value to be assigned to rightNode
     */
    public void setRight(BSTNode<T> n) {
        rightNode = n;
    }
}
