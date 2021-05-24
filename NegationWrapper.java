public class NegationWrapper extends WrapperNode {

    /**
     * Constructor NegationWraper.
     * @param child a node.
     */
    public NegationWrapper(final Node child) {
        super();
        super.wrap(defineType(child));
    }

    private Node defineType(final Node child) {
        return child.getType() != Type.INT
                ?  new DoubleNegation(child)
                :  new IntNegation(child);
    }
}
