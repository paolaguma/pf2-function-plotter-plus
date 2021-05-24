import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import javax.swing.JTextField;


/**
 * The RangePanel is a part of the "GUI".
 * It shows the minimum and maximum value visible along the x-axis
 * in two text fields, and the user can update those values by
 * entering them into the text field and pressing ENTER.
 */
public final class RangePanel extends JPanel {

    private static final int CHARS_IN_TEXTFIELD = 6;
    
    private final Range range;
    private final JTextField minField;
    private final JTextField maxField;
    
    
    /**
     * Create a new RangePanel that allows a user
     * to see and edit the given Range.
     * @param range The model for this GUI component
     */
    public RangePanel(final Range range) {
        super();
        this.range = range;

        setLayout(new BorderLayout());
        minField = new JTextField(CHARS_IN_TEXTFIELD);
        add(minField, BorderLayout.WEST);
        maxField = new JTextField(CHARS_IN_TEXTFIELD);
        add(maxField, BorderLayout.EAST);
        
        // register listeners
        range.addRangeListener(new RangeListener() {
            public void rangeChanged(final Range range) {
                updateView();
            }
        });
        minField.addActionListener(new ActionListener() {
            public void actionPerformed(final ActionEvent ev) {
                // GUI changed: update model
                // we allow users to enter an expression in the min field!
                range.setMin(evaluate(minField.getText()));
            }
        });
        maxField.addActionListener(new ActionListener() {
            public void actionPerformed(final ActionEvent ev) {
                // GUI changed: update model
                // we allow users to enter an expression in the max field!
                range.setMax(evaluate(maxField.getText()));
            }
        });
        
        // set GUI's initial state based on state of given model
        updateView();
    }
    
    /**
     * Evaluate the given expression.
     * This allows us to enter lower and upper range bounds
     * in the form of expressions instead of just literals.
     * @param text An expression
     * @return The value the expression evaluated to
     */
    private double evaluate(final String text) {
        final Parser parser = new ArithParser();
        try {
            final Node parsedExpression = parser.parse(text);
            System.out.println(parsedExpression.toString());
            final Program program = new Program();
            parsedExpression.compile(program);
            final VariableTable variableTable = new VariableTable();
            return program.dExecute(variableTable);
        } catch (Exception ex) {
            // TODO error handling
        }
        return 0; // error
    }
    
    /**
     * Update the textfields for the upper and lower range bounds
     * based on the data stored in the model (the Range object).
     */
    private void updateView() {
        minField.setText("" + range.getMin());
        maxField.setText("" + range.getMax());
    }
    
}
