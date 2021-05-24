public class IntMultiplication extends IntBinaryNode {

    /**
     * Creates a new IntMultiplication Node.
     * @param leftChild a Node
     * @param rightChild a Node
     */
    public IntMultiplication(final Node leftChild, final Node rightChild) {
        super(leftChild, rightChild);
    }

    @Override
    public Instruction instruction() {
        return new IMUL();
    }

    @Override
    public String toString() {
        return super.toString("*");
    }
}

