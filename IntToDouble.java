public class IntToDouble extends DoubleUnaryNode {

    /**
     * Creates an IntToDouble object.
     * @param child a Node
     */
    public IntToDouble(final Node child) {
        super(child);
    }

    @Override
    public Instruction instruction() {
        return new I2D();
    }

    @Override
    public String toString() {
        return "double " + child.toString();
    }

}
