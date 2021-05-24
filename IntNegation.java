/**
 * An integer IntNegation (e.g., -5, or -x).
 */
public class IntNegation extends IntUnaryNode {
        
    /**
     * Create a new IntNegation node.
     * @param child the operand we will negate
     */
    public IntNegation(final Node child) {
        super(child);
    }
    
    @Override
    public Instruction instruction() {
        return new INEG();
    }
    
}
