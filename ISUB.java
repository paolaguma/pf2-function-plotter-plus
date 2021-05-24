/**
 * ISUB subtracts the top value from the second-to-top value
 * of the OperandStack,
 * and ipushes the result back to the OperandStack.
 */
public class ISUB implements Instruction {

    @Override
    public void execute(final Storage storage) {
        final OperandStack stack = storage.getOperandStack();
        stack.ipush(-stack.ipop() + stack.ipop());
    }
        
    @Override
    public String toString() {
        return "ISUB";
    }

}
