import java.util.ArrayList;


/**
 * The Function is the most important part of the "model" 
 * in our function plotter application.
 * The "model" does not know anything about the "GUI".
 * It could exist without "GUI" (e.g., for a command-line interface).
 */
public final class Function {

    private final ArrayList<FunctionListener> listeners;
    private String expressionText;
    private Program program;
    
    /**
     * Create a Function based on the given expression.
     * @param expressionText The expression (a function of x).
     */
    public Function(final String expressionText) {
        listeners = new ArrayList<>();
        setExpression(expressionText);
    }
    
    /**
     * Change the expression underlying this Function.
     * @param expressionText The new expression (a function of x).
     */
    public final void setExpression(final String expressionText) {
        this.expressionText = expressionText;
        final Parser parser = new ArithParser();
        final Node parsedExpression = parser.parse(expressionText);
        program = new Program();
        parsedExpression.compile(program);
        fireFunctionChanged();
    }
    
    /**
     * Get the expression defining this function.
     * @return the expression.
     */
    public final String getExpression() {
        return expressionText;
    }
    
    /**
     * Evaluate the function at the given x.
     * @param x The value in which to evaluate the function.
     * @return the value of the function in the given x.
     */
    public final double compute(final double x) {
        final VariableTable variableTable = new VariableTable();
        //TODO: if your language supports doubles, remove this cast
        final int value = (int)x;
        variableTable.set("x", value);
        return program.execute(variableTable);
    }
    
    //--- listener management

    /**
     * Adds a new function listener.
     * @param li a Function Listener
     */
    public void addFunctionListener(final FunctionListener li) {
        listeners.add(li);
    }

    /**
     * Removes a function listener.
     * @param li a Function Listener
     */
    public void removeFunctionListener(final FunctionListener li) {
        listeners.remove(li);
    }
    
    private void fireFunctionChanged() {
        for (final FunctionListener fi : listeners) {
            fi.functionChanged(this);
        }
    }
}