public class ILOAD implements Instruction {

    private final String var;

    /**
     * Creates a new ILOAD Instruction.
     * @param var a String
     */
    public ILOAD(final String var) {
        super();
        this.var = var;
    }

    @Override
    public void execute(final Storage storage) {
        final OperandStack stack = storage.getOperandStack();
        final VariableTable variableTable = storage.getVariableTable();
        final int xValue = variableTable.getInt(var);
        stack.ipush(xValue);
    }
    
    /**
     * Returns a String representing the node.
     * @return a String representing the node.
     */
    public String toString() {
        return "ILOAD " + var;
    }
}
