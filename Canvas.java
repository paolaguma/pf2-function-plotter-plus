import javax.swing.JComponent;


public class Canvas  extends JComponent {

    protected final Function function;
    protected final Range range;
    
    /**
     * Create a new ShadeCanvas presenting the given Plot.
     * @param plot The Plot to render
     */
    public Canvas(final Plot plot) {
        super();
        this.function = plot.getFunction();
        this.range = plot.getRange();

        addFunctionRangeListeners();
    }

    private void addFunctionRangeListeners() {
        function.addFunctionListener(new FunctionListener() {
            public void functionChanged(final Function function) {
                repaint();
            }
        });
        range.addRangeListener(new RangeListener() {
            public void rangeChanged(final Range range) {
                repaint();
            }
        });
    }
    

}
