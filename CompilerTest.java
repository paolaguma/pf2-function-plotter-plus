import static org.junit.Assert.*;

import java.lang.annotation.Target;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


/**
 * Test compile() of Node subclasses
 * (and toString() of Instruction subclasses).
 * This tests that the compile() methods generate the correct
 * sequence of Instructions.
 */
public class CompilerTest {

    @Test
    public void testIntLiteral() {
        Compiler c = new Compiler();
        Node n = new IntLiteral(5);
        Program p = c.compile(n);
        assertEquals(1, p.getLength());
        assertTrue(p.get(0) instanceof BIPUSH);
        assertEquals(new BIPUSH(5).toString(), p.get(0).toString());
    }

    @Test
    public void testIntNegation() {
        Compiler c = new Compiler();
        Node n = new IntNegation(new IntLiteral(5));
        Program p = c.compile(n);
        assertEquals(2, p.getLength());
        assertTrue(p.get(0) instanceof BIPUSH);
        assertEquals(new BIPUSH(5).toString(), p.get(0).toString());
        assertTrue(p.get(1) instanceof INEG);
    }
    
    @Test
    public void testIntAddition() {
        Compiler c = new Compiler();
        Node n = new IntAddition(new IntLiteral(5), new IntLiteral(6));
        Program p = c.compile(n);
        assertEquals(3, p.getLength());
        assertTrue(p.get(0) instanceof BIPUSH);
        assertEquals(new BIPUSH(5).toString(), p.get(0).toString());
        assertTrue(p.get(1) instanceof BIPUSH);
        assertEquals(new BIPUSH(6).toString(), p.get(1).toString());
        assertTrue(p.get(2) instanceof IADD);
    }
    
    @Test
    public void testIntSubtraction() {
        Compiler c = new Compiler();
        Node n = new IntSubtraction(new IntLiteral(5), new IntLiteral(6));
        Program p = c.compile(n);
        assertEquals(3, p.getLength());
        assertTrue(p.get(0) instanceof BIPUSH);
        assertEquals(new BIPUSH(5).toString(), p.get(0).toString());
        assertTrue(p.get(1) instanceof BIPUSH);
        assertEquals(new BIPUSH(6).toString(), p.get(1).toString());
        assertTrue(p.get(2) instanceof ISUB);
    }

    @Test
    public void testIntMultiplication() {
        Compiler c = new Compiler();
        Node n = new IntMultiplication(new IntLiteral(5), new IntLiteral(6));
        Program p = c.compile(n);
        assertEquals(3, p.getLength());
        assertTrue(p.get(0) instanceof BIPUSH);
        assertEquals(new BIPUSH(5).toString(), p.get(0).toString());
        assertTrue(p.get(1) instanceof BIPUSH);
        assertEquals(new BIPUSH(6).toString(), p.get(1).toString());
        assertTrue(p.get(2) instanceof IMUL);
    }
    
    @Test
    public void testIntDivision() {
        Compiler c = new Compiler();
        Node n = new IntDivision(new IntLiteral(5), new IntLiteral(6));
        Program p = c.compile(n);
        assertEquals(3, p.getLength());
        assertTrue(p.get(0) instanceof BIPUSH);
        assertEquals(new BIPUSH(5).toString(), p.get(0).toString());
        assertTrue(p.get(1) instanceof BIPUSH);
        assertEquals(new BIPUSH(6).toString(), p.get(1).toString());
        assertTrue(p.get(2) instanceof IDIV);
    }

    @Test
    public void testVariable() {
        Compiler c = new Compiler();
        Node n = new IntVariable("x");
        Program p = c.compile(n);
        assertEquals(1, p.getLength());
        assertTrue(p.get(0) instanceof ILOAD);
        assertEquals(new ILOAD("x").toString(), p.get(0).toString());
    }
    
    @Test
    public void testDoubleLiteral() {
        Compiler c = new Compiler();
        Node n = new DoubleLiteral(5);
        Program p = c.compile(n);
        assertEquals(1, p.getLength());
        assertTrue(p.get(0) instanceof BDPUSH);
        assertEquals(new BDPUSH(5).toString(), p.get(0).toString());
    }

    @Test
    public void testDoubleNegation() {
        Compiler c = new Compiler();
        Node n = new DoubleNegation(new DoubleLiteral(5));
        Program p = c.compile(n);
        assertEquals(2, p.getLength());
        assertTrue(p.get(0) instanceof BDPUSH);
        assertEquals(new BDPUSH(5).toString(), p.get(0).toString());
        assertTrue(p.get(1) instanceof DNEG);
    }

    @Test
    public void testDoubleAddition() {
        Compiler c = new Compiler();
        Node n = new DoubleAddition(new DoubleLiteral(5), new DoubleLiteral(6));
        Program p = c.compile(n);
        assertEquals(3, p.getLength());
        assertTrue(p.get(0) instanceof BDPUSH);
        assertEquals(new BDPUSH(5).toString(), p.get(0).toString());
        assertTrue(p.get(1) instanceof BDPUSH);
        assertEquals(new BDPUSH(6).toString(), p.get(1).toString());
        assertTrue(p.get(2) instanceof DADD);
    }

    @Test
    public void testDoubleSubtraction() {
        Compiler c = new Compiler();
        Node n = new DoubleSubtraction(new DoubleLiteral(5), new DoubleLiteral(6));
        Program p = c.compile(n);
        assertEquals(3, p.getLength());
        assertTrue(p.get(0) instanceof BDPUSH);
        assertEquals(new BDPUSH(5).toString(), p.get(0).toString());
        assertTrue(p.get(1) instanceof BDPUSH);
        assertEquals(new BDPUSH(6).toString(), p.get(1).toString());
        assertTrue(p.get(2) instanceof DSUB);
    }

    @Test
    public void testDoubleMultiplication() {
        Compiler c = new Compiler();
        Node n = new DoubleMultiplication(new DoubleLiteral(5), new DoubleLiteral(6));
        Program p = c.compile(n);
        assertEquals(3, p.getLength());
        assertTrue(p.get(0) instanceof BDPUSH);
        assertEquals(new BDPUSH(5).toString(), p.get(0).toString());
        assertTrue(p.get(1) instanceof BDPUSH);
        assertEquals(new BDPUSH(6).toString(), p.get(1).toString());
        assertTrue(p.get(2) instanceof DMUL);
    }

    @Test
    public void testDoubleDivision() {
        Compiler c = new Compiler();
        Node n = new DoubleDivision(new DoubleLiteral(5), new DoubleLiteral(6));
        Program p = c.compile(n);
        assertEquals(3, p.getLength());
        assertTrue(p.get(0) instanceof BDPUSH);
        assertEquals(new BDPUSH(5).toString(), p.get(0).toString());
        assertTrue(p.get(1) instanceof BDPUSH);
        assertEquals(new BDPUSH(6).toString(), p.get(1).toString());
        assertTrue(p.get(2) instanceof DDIV);
    }

    @Test
    public void testDoubleVariable() {
        Compiler c = new Compiler();
        Node n = new DoubleVariable("x");
        Program p = c.compile(n);
        assertEquals(1, p.getLength());
        assertTrue(p.get(0) instanceof DLOAD);
        assertEquals(new DLOAD("x").toString(), p.get(0).toString());
    }

    @Test
    public void testDoubleToInt() {
        Compiler c = new Compiler();
        Node n = new DoubleToInt(new DoubleLiteral(5.3));
        Program p = c.compile(n);
        assertEquals(2, p.getLength());
        assertTrue(p.get(0) instanceof BDPUSH);
        assertTrue(p.get(1) instanceof D2I);
        assertEquals(new D2I().toString(), p.get(1).toString());
    }

    @Test
    public void testIntToDouble() {
        Compiler c = new Compiler();
        Node n = new IntToDouble(new IntLiteral(5));
        Program p = c.compile(n);
        assertEquals(2, p.getLength());
        assertTrue(p.get(0) instanceof BIPUSH);
        assertTrue(p.get(1) instanceof I2D);
        assertEquals(new I2D().toString(), p.get(1).toString());
    }

}
