import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Tests Bst class
 * 
 * @author JonathanThomas
 * @version 4/9/16
 */
public class BstTest {

    /**
     * Tests tree size method, inserts, getElement, maximum element, preOrdered
     */
    @Test
    public void test() {
        Bst tree = new Bst();
        assertEquals(null, tree.maximumElement());
        assertEquals("{}", tree.preorderString());
        // tree.insert("f");
        // tree.removeElementWithKey("f");
        // assertEquals(0,tree.size());

        tree.insert("f");
        tree.insert("b");
        tree.insert("d");
        tree.insert("g");
        tree.insert("z");
        tree.insert("a");
        assertEquals(6, tree.size());
        assertEquals("z", tree.elementWithKey("z"));
        assertEquals(null, tree.elementWithKey("y"));
        assertEquals("z", tree.maximumElement());
        assertEquals("{f, b, a, d, g, z}", tree.preorderString());
        assertEquals(3, tree.height());
        tree.removeElementWithKey("g");
        tree.insert("d");
        assertEquals(5, tree.size());
        tree.removeElementWithKey("b");
        assertEquals(4, tree.size());
        tree.removeElementWithKey("f");
        tree.removeElementWithKey("d");
        assertEquals(2, tree.size());
        tree.removeElementWithKey("y");
        assertEquals(2, tree.size());
        tree.removeElementWithKey("a");
        tree.removeElementWithKey("z");
        assertEquals(0, tree.size());

        tree.insert("f");
        tree.insert("b");
        tree.insert("d");
        tree.insert("g");
        tree.insert("z");
        tree.insert("a");
        tree.insert("c");
        tree.insert("e");

        tree.removeElementWithKey("b");

    }

}
