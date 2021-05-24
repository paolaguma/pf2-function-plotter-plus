public class DivisionWrapper extends BinaryWrapperNode {

    /**
     * Constructor for DivisionWrapper.
     * @param left a Node
     * @param right a Node
     */
    public DivisionWrapper(final Node left, final Node right) {
        super(left, right);
        wrap(getChildrenType() != Type.DOUBLE
                ? new IntDivision(leftChild, rightChild)
                : new DoubleDivision(leftChild, rightChild));
    }
}
