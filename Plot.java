/**
 * The Plot is the "model" of this application.
 * It is an immutable class that
 * points to the two mutable and observable parts of the "model":
 * 1) a Function, and
 * 2) a Range (along the x-axis, over which the function should be plotted).
 */
public final class Plot {

    private final Function function;
    private final Range range;
    private final Cursor cursor;
    
    
    /**
     * Create a new Plot of the given Function, with the given Range and Cursor.
     * @param function The Function to plot
     * @param range The Range (on the x-axis) over which to plot
     * @param cursor The Cursor denoting a point on the x-axis
     */
    public Plot(final Function function, final Range range, final Cursor cursor) {
        this.function = function;
        this.range = range;
        this.cursor = cursor;
    }
    
    /**
     * Get the Function of this Plot.
     * @return this Plot's Function
     */
    public final Function getFunction() {
        return function;
    }
    
    /**
     * Get the Range of this Plot.
     * @return this Plot's Range
     */
    public final Range getRange() {
        return range;
    }
    
    /**
     * Get the Cursor of this Plot.
     * @return this Plot's Cursor
     */
    public final Cursor getCursor() {
        return cursor;
    }
    
}
