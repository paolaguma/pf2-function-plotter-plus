/**
 * An integer IntSubtraction.
 */
public class DoubleSubtraction extends DoubleBinaryNode {
    
    /**
     * Create a new IntSubtraction node.
     * @param leftChild the left operand
     * @param rightChild the right operand
     */
    public DoubleSubtraction(final Node leftChild, final Node rightChild) {
        super(leftChild, rightChild);
    }

    @Override
    public Instruction instruction() {
        return new DSUB();
    }

    @Override
    public String toString() {
        return super.toString("-");
    }
    
}
