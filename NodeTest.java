import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;


/**
 * Tests toString(), isConstant(), and getType() of Node subclasses.
 */
public class NodeTest {
    // abstract class testing
    @Test 
    public void testNode() {
        // we don't have the keyword abstract in the Node implementation.
        // tests work.
        Node e = new Node();
        assertTrue(e.isConstant());
        assertEquals("?", e.toString());
        assertEquals(Type.INVALID, e.getType());
        e.compile(null);
    }

    @Test
    public void testLiteral() {
        Node e = new Literal(5);
        assertTrue(e.isConstant());
        assertEquals("5", e.toString());
        assertEquals(Type.INT, e.getType());
    }

    @Test
    public void testNegation() {
        Node e = new Negation(new Literal(5));
        assertTrue(e.isConstant());
        assertEquals("(-5)", e.toString());
        assertEquals(Type.INT, e.getType());
    }

    // Addition Tests
    @Test
    public void testAdditionLiteralLiteral() {
        Node e = new Addition(new Literal(5), new Literal(6));
        assertTrue(e.isConstant());
        assertEquals("(5+6)", e.toString());
        assertEquals(Type.INT, e.getType());
    }

    @Test
    public void testAdditionLiteralVariable() {
        Node e = new Addition(new Literal(5), new Variable("y"));
        assertFalse(e.isConstant());
        assertEquals("(5+y)", e.toString());
        assertEquals(Type.INT, e.getType());
    }

    @Test
    public void testAdditionVariableVariable() {
        Node e = new Addition(new Variable("x"), new Variable("y"));
        assertFalse(e.isConstant());
        assertEquals("(x+y)", e.toString());
        assertEquals(Type.INT, e.getType());
    }
    
    // Substraction Tests

    @Test
    public void testSubtractionLiteralLiteral() {
        Node e = new Subtraction(new Literal(5), new Literal(6));
        assertTrue(e.isConstant());
        assertEquals("(5-6)", e.toString());
        assertEquals(Type.INT, e.getType());
    }

    @Test
    public void testSubtractionLiteralVariable() {
        Node e = new Subtraction(new Literal(5), new Variable("y"));
        assertFalse(e.isConstant());
        assertEquals("(5-y)", e.toString());
        assertEquals(Type.INT, e.getType());
    }

    @Test
    public void testSubtractionVariableVariable() {
        Node e = new Subtraction(new Variable("x"), new Variable("y"));
        assertFalse(e.isConstant());
        assertEquals("(x-y)", e.toString());
        assertEquals(Type.INT, e.getType());
    }
    
    // Multiplication tests
    @Test
    public void testMultiplicationLiteralLiteral() {
        Node e = new Multiplication(new Literal(5), new Literal(6));
        assertTrue(e.isConstant());
        assertEquals("(5*6)", e.toString());
        assertEquals(Type.INT, e.getType());
    }

    @Test
    public void testMultiplicationLiteralVariable() {
        Node e = new Multiplication(new Literal(5), new Variable("y"));
        assertFalse(e.isConstant());
        assertEquals("(5*y)", e.toString());
        assertEquals(Type.INT, e.getType());
    }

    @Test
    public void testMultiplicationVariableVariable() {
        Node e = new Multiplication(new Variable("x"), new Variable("y"));
        assertFalse(e.isConstant());
        assertEquals("(x*y)", e.toString());
        assertEquals(Type.INT, e.getType());
    }

    // Division Tests
    @Test
    public void testDivisionLiteralLiteral() {
        Node e = new Division(new Literal(5), new Literal(6));
        assertTrue(e.isConstant());
        assertEquals("(5/6)", e.toString());
        assertEquals(Type.INT, e.getType());
    }

    @Test
    public void testDivisionLiteralVariable() {
        Node e = new Division(new Literal(5), new Variable("y"));
        assertFalse(e.isConstant());
        assertEquals("(5/y)", e.toString());
        assertEquals(Type.INT, e.getType());
    }

    @Test
    public void testDivisionVariableVariable() {
        Node e = new Division(new Variable("x"), new Variable("y"));
        assertFalse(e.isConstant());
        assertEquals("(x/y)", e.toString());
        assertEquals(Type.INT, e.getType());
    }

    @Test
    public void testVariable() {
        Node e = new Variable("x");
        assertFalse(e.isConstant());
        assertEquals("x", e.toString());
        assertEquals(Type.INT, e.getType());
    }
    
}
