public class DDIV implements Instruction {

    @Override
    public void execute(final Storage storage) {
        final OperandStack stack = storage.getOperandStack();
        stack.dpush((1 / stack.dpop()) * stack.dpop());
    }

    @Override
    public String toString() {
        return "DDIV";
    }
    
}
