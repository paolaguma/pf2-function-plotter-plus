public class WrapperNode extends  Node {

    private Node child;

    /**
     * A node which wraps a node.
     */
    public WrapperNode() {
        super();
        child = null;
    }

    @Override
    public Type getType() {
        return child.getType();
    }

    @Override
    public boolean isConstant() {
        return child.isConstant();
    }

    @Override
    public void compile(final Program p) {
        child.compile(p);
    }

    @Override
    public String toString() {
        // to be implemented in subclasses
        return child.toString();
    }

    protected Node castToDouble(final Node n) {
        return new IntToDouble(n);
    }

    protected Node castToInt(final Node n) {
        return new DoubleToInt(n);
    }

    protected void wrap(final Node child) {
        this.child = child;
    }

}
