public class SubtractionWrapper extends BinaryWrapperNode {

    /**
     * Constructor for SubstractionWrapper.
     * @param left a node
     * @param right a node
     */
    public SubtractionWrapper(final Node left, final Node right) {
        super(left, right);
        wrap(getChildrenType() != Type.DOUBLE
                ? new IntSubtraction(leftChild, rightChild)
                : new DoubleSubtraction(leftChild, rightChild));
    }


}
