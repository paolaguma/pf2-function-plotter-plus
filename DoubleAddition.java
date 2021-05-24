/**
 * A Double AdditionWrapper.
 */
public class DoubleAddition extends DoubleBinaryNode {
    
    /**
     * Create a new DoubleAddition node.
     * @param leftChild the left operand
     * @param rightChild the right operand
     */
    public DoubleAddition(final Node leftChild, final Node rightChild) {
        super(leftChild, rightChild);
    }

    @Override
    public Instruction instruction() {
        return new DADD();
    }

    @Override
    public String toString() {
        return super.toString("+");
    }
    
}
