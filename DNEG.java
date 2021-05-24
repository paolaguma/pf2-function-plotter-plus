public class DNEG implements Instruction {

    @Override
    public void execute(final Storage storage) {
        final OperandStack stack = storage.getOperandStack();
        stack.dpush(-stack.dpop());
    }

    @Override
    public String toString() {
        return "DNEG";
    }
}
