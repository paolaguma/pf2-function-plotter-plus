public class DSUB implements Instruction {

    @Override
    public void execute(final Storage storage) {
        final OperandStack stack = storage.getOperandStack();
        stack.dpush(-stack.dpop() + stack.dpop());
    }

    @Override
    public String toString() {
        return "DSUB";
    }
    
}
