public class NodeLiteral extends Node {
    
    protected final Number value;
    
    /**
     * Create a new NodeLiteral node.
     * @param value the integer doubleValue this node evaluates to
     */
    public NodeLiteral(final Number value) {
        super();
        this.value = value;
    }

    @Override
    public Type getType() {
        return Type.INVALID;
    }

    @Override
    public boolean isConstant() {
        return true;
    }
    
    @Override
    public void compile(final Program p) {
        p.append(instruction());
    }

    /**
     * Returns the JVM instruction of the Node.
     * @return the JVM instruction of the Node.
     */
    public Instruction instruction() {
        return null;
    }

    @Override
    public String toString() {
        return "" + this.value;
    }
    
}