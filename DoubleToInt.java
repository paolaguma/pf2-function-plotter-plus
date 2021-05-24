public class DoubleToInt extends IntUnaryNode {

    /**
     * Constructs a DoubleToInt object.
     * @param child a Node
     */
    public DoubleToInt(final Node child) {
        super(child);
    }

    @Override
    public Instruction instruction() {
        return new D2I();
    }

    @Override
    public String toString() {
        return "int " + child.toString();
    }
}
