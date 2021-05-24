/**
 * A DoubleNegation class (e.g., -5, or -x).
 */
public class DoubleNegation extends DoubleUnaryNode {
        
    /**
     * Create a new IntNegation node.
     * @param child the operand we will negate
     */
    public DoubleNegation(final Node child) {
        super(child);
    }
    
    @Override
    public Instruction instruction() {
        return new DNEG();
    }
    
}
