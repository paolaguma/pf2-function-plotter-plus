import java.util.HashMap;
import java.util.Map;


/**
 * A table of variables
 * (a map from variable names to variable values).
 */
public class VariableTable {
    
    private final Map<String,Double> variables;
    
    
    /**
     * Create a new empty variable table.
     */
    public VariableTable() {
        variables = new HashMap<String,Double>();
    }
    
    /**
     * Get the value of the variable with the given name.
     * @param name The name of the variable.
     * @return The Integer value of the variable with the given name.
     */
    public Integer getInt(final String name) {
        return variables.get(name).intValue();
    }


    /**
     * Get the value of the variable with the given name.
     * @param name The name of the variable.
     * @return The Double value of the variable with the given name.
     */
    public Double getDouble(final String name) {
        return variables.get(name);
    }
    
    
    /**
     * Set the Int value of the variable with the given name.
     * @param name The name of the variable.
     * @param value The new value of the variable.
     */
    public void iset(final String name, final Integer value) {
        variables.put(name, value.doubleValue());
    }

    /**
     * Set the value of the variable with the given name.
     * @param name The name of the variable.
     * @param value The new value of the variable.
     */
    public void dset(final String name, final Double value) {
        variables.put(name, value);
    }


    
}