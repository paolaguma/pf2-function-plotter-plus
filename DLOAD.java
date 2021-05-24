public class DLOAD implements Instruction {

    private final String var;

    /**
     * Creates a new ILOAD Instruction.
     * @param var a String
     */
    public DLOAD(final String var) {
        super();
        this.var = var;
    }
    
    @Override
    public void execute(final Storage storage) {
        final OperandStack stack = storage.getOperandStack();
        final VariableTable variableTable = storage.getVariableTable();
        final double xValue = variableTable.getDouble(var);
        stack.dpush(xValue);
    }

    /**
     * Returns a String.
     * @return a String representation of the Node
     */
    public String toString() {
        return "DLOAD " + var;
    }
    
}
