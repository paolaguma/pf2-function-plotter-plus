import java.util.ArrayList;


/**
 * A Cursor represents a point along the x-axis.
 * Its position is mutable.
 */
public final class Cursor {

    private final ArrayList<CursorListener> listeners;
    private double x;
    
    /**
     * Create a new Cursor at the given x-coordinate.
     * @param initialX The initial position of the cursor.
     */
    public Cursor(final double initialX) {
        listeners = new ArrayList<CursorListener>();
        this.x = initialX;
    }

    /**
     * Return the current position along the x-coordinate of this Cursor.
     * @return the current position
     */
    public final double getX() {
        return x;
    }
    
    /**
     * Set the position of the Cursor to the given x-coordinate.
     * @param x The new x-coordinate of this Cursor.
     */
    public final void setX(final double x) {
        this.x = x;
        fireCursorChanged();
    }
    
    //--- listener management
    /**
     * Register the given CursorListener,
     * so it will be notified whenever this Cursor changes.
     * @param li The CursorListener to register
     */
    public final void addCursorListener(final CursorListener li) {
        listeners.add(li);
    }
    
    /**
     * Unregister the given CursorListener,
     * so it will not be notified anymore whenever this Cursor changes.
     * @param li The CursorListener to unregister
     */
    public final void removeCursorListener(final CursorListener li) {
        listeners.remove(li);
    }
    
    /**
     * Notify all registered CursorListeners that this Cursor has changed.
     */
    private void fireCursorChanged() {
        for (final CursorListener li : listeners) {
            li.cursorChanged(this);
        }
    }
    
}
