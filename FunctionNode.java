
import java.util.ArrayList;

public class FunctionNode extends Node {

    private final String name;
    private final ArrayList<Node> arguments;
    private final FunctionOperation fop;

    /**
     * Creates a new FunctionNode based on the name and Operation.
     * @param name a String name for the function.
     * @param fop the function Operation.
     */
    public FunctionNode(final String name, final FunctionOperation fop) {
        super();
        this.name = name;
        arguments = new ArrayList<>();
        this.fop = fop;
    }

    /**
     * Adds an argument to the function.
     * @param arg an argument node.
     */
    public void addArgument(final Node arg) {
        arguments.add(arg);
    }

    @Override
    public Type getType() {
        for (final Node arg : arguments) {
            if (arg.getType() == Type.DOUBLE) {
                return Type.DOUBLE;
            }
        }

        return Type.INT;
    }

    @Override
    public boolean isConstant() {
        for (final Node arg : arguments) {
            if (!arg.isConstant()) {
                return false;
            }
        }
        return true;
    }

    @Override
    public void compile(final Program p) {
        for (final Node arg : arguments) {
            arg.compile(p);
        }
        p.append(functionOperation());
    }

    //to be overwritten
    private FunctionOperation functionOperation() {
        return fop;
    }


    @Override
    public String toString() {
        // to be implemented in subclasses
        final StringBuilder str = new StringBuilder();
        str.append(name + "(");
        for (final Node arg : arguments) {
            str.append(arg);
            if (arguments.size() > 1) {
                str.append(",");
            }
        }
        if (str.lastIndexOf(",") == str.length() - 1) {
            str.delete(str.length() - 1,str.length());
        }
        str.append(")");
        return str.toString();
    }

    /**
     * Get the functionOperation(what the function does)
     * @return the FunctionOperation of a function.
     */
    public FunctionOperation getFunctionOperation() {
        return fop;
    }

    /**
     * Get the name of the function.
     * @return a String name of a function.
     */
    public String getName() {
        return name;
    }

    /**
     * Removes all the arguments of a function.
     * Deprecated , but might be usefull.
     */
    @Deprecated
    public void removeAllArguments() {
        arguments.removeAll(arguments);
    }
}
