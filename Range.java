import java.util.ArrayList;


/**
 * A Range represents a range of values (from a given minimum to a given maximum).
 * It is mutable and observable
 * (observable means that one can register a listener to get notified of changes).
 */
public final class Range {
    private final ArrayList<RangeListener> listeners;
    private double min;
    private double max;
    
    /**
     * Create a new Range with the given minimum and maximum value.
     * @param min The initial minimum value.
     * @param max The initial maximum value.
     */
    public Range(final double min, final double max) {
        this.min = min;
        this.max = max;
        this.listeners = new ArrayList<>();
    }
    
    /**
     * Return the current minimum value of this Range.
     * @return the current minimum value
     */
    public final double getMin() {
        return min;
    }
    
    /**
     * Set the minimum value of this Range.
     * @param min The new minimum value.
     */
    public final void setMin(final double min) {
        this.min = min;
        fireRangeChanged();
    }
    
    /**
     * Return the current maximum value of this Range.
     * @return the current maximum value
     */
    public final double getMax() {
        return max;
    }
    
    
    /**
     * Set the maximum value of this Range.
     * @param max The new maximum value.
     */
    public final void setMax(final double max) {
        this.max = max;
        fireRangeChanged();
    }
    
    
    /**
     * Get the extent of this Range (the maximum minus the minimum).
     * @return The extent of this Range.
     */
    public final double getExtent() {
        return max - min;
    }
    
    /**
     * Adds a new Range Listener.
     * @param li a RangeListener
     */
    public void addRangeListener(final RangeListener li) {
        listeners.add(li);

    }

    /**
     * Removes a given Range Listener.
     * @param li a Rangelistener
     */
    public void removeRangeListener(final RangeListener li) {
        listeners.remove(li);
    }

    //--- listener management
    private void fireRangeChanged() {
        for (final RangeListener r : listeners) {
            r.rangeChanged(this);
        }
    }
    
}
