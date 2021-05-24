public enum FunctionType {

    SIN("SIN",
            new FunctionNode("sin", new FunctionOperation() {
                    @Override
                    public void execute(final Storage storage) {
                        final OperandStack op = storage.getOperandStack();
                        final double a = op.dpop();
                        op.dpush(Math.sin(a));
                    }

                    @Override
                    public String toString() {
                        return "sin";
                    }
            })),
    COS("COS",
            new FunctionNode("cos", new FunctionOperation() {
                @Override
                public void execute(final Storage storage) {
                    final OperandStack op = storage.getOperandStack();
                    final double a = op.dpop();
                    op.dpush(Math.cos(a));
                }

                @Override
                public String toString() {
                    return "cos";
                }
            })),

    SUM("SUM",
            new FunctionNode("sum", new FunctionOperation() {
                @Override
                public void execute(final Storage storage) {
                    final OperandStack op = storage.getOperandStack();
                    final double a = op.dpop();
                    final double b = op.dpop();
                    op.dpush(a + b);
                }

                @Override
                public String toString() {
                    return "sum";
                }
            }));

    //TODO add more functions

    private final String name;
    private final FunctionNode function;


    private FunctionType(final String name, final FunctionNode function) {
        this.name = name;
        this.function = function;
    }

    /**
     * Returns the function.
     * @return the function of an enum Type.
     */
    public FunctionNode getFunction() {
        return function;
    }

    /**
     * Gets the name of the function.
     * @return the String representation of the name.
     */
    public String getName() {
        return name;
    }

    /**
     * Returns a function if it find a match of name.
     * @param name a string name for a function.
     * @return a new FunctionNode, with the same name and functionOperation.
     * @throws Exception throws a FunctionTypeException //TODO implement
     */
    public static FunctionNode stringToFunction(final String name) throws Exception {
        for (final FunctionType func : FunctionType.values()) {
            if (name.equals(func.getName())) {
                final FunctionNode f = func.getFunction();
                return new FunctionNode(f.getName(), f.getFunctionOperation());
            }
        }
        throw new Exception();
    }


}
