public interface FunctionOperation extends Instruction {

    @Override
    public abstract void execute(final Storage storage);

    @Override
    public abstract String toString();
}
