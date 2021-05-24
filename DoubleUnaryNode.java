public class DoubleUnaryNode extends IntUnaryNode {
    /**
     * Create a new DoubleUnaryNode node.
     * @param child the operand we will negate
     */
    public DoubleUnaryNode(final Node child) {
        super(child);
    }

    @Override
    public Type getType() {
        return Type.DOUBLE;
    }
}

