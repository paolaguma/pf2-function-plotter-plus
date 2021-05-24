public class AdditionWrapper extends BinaryWrapperNode  {

    /**
     * Constructor for AdditionWrapper.
     * @param left a Node
     * @param right a Node
     */
    public AdditionWrapper(final Node left, final Node right) {
        super(left, right);
        wrap(getChildrenType() != Type.DOUBLE
                ? new IntAddition(leftChild, rightChild)
                : new DoubleAddition(leftChild, rightChild));
    }
}
