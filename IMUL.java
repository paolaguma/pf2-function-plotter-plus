public class IMUL extends Instruction {
    
    @Override
    public void execute(final Storage storage) {
        final OperandStack stack = storage.getOperandStack();
        stack.push(stack.pop() * stack.pop());
    }
    
    @Override
    public String toString() {
        return "IMUL";
    }
}
