public class I2D implements Instruction {
    
    @Override
    public void execute(final Storage storage) {
        final OperandStack stack = storage.getOperandStack();
        final int val = stack.ipop();
        stack.dpush(val);
    }
    
    @Override
    public String toString() {
        return "I2D";
    }
}
