/**
 * IADD adds the top two values from the OperandStack
 * and ipushes the result back to the OperandStack.
 */
public class IADD implements Instruction {
    
    @Override
    public void execute(final Storage storage) {
        final OperandStack stack = storage.getOperandStack();
        stack.ipush(stack.ipop() + stack.ipop());
    }
    
    
    @Override
    public String toString() {
        return "IADD";
    }
    
}
