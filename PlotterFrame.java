import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;


/**
 * The main frame of the Function Plotter application.
 * The "GUI".
 * The "GUI" knows the "model", it depends on the "model",
 * and it cannot exist without the "model".
 * The "model" of a PlotterFrame is a Plot.
 */
public final class PlotterFrame extends JFrame {

    /**
     * Create a new PlotterFrame for the given Plot.
     * @param plot The model to show.
     */
    public PlotterFrame(final Plot plot) {
        super();
        setTitle("Function Plotter");
        setLayout(new BorderLayout());
        final JTextField expressionField = new JTextField(plot.getFunction().getExpression());
        add(expressionField, BorderLayout.NORTH);

        final PlotCanvas pv = new PlotCanvas(plot);
        final ShadeCanvas sv = new ShadeCanvas(plot);
        
        // creating the panel and adding the Canvases
        final JPanel panel = new JPanel(new BorderLayout());
        panel.add(pv, BorderLayout.CENTER);
        panel.add(sv, BorderLayout.SOUTH);

        // adding panel to this
        add(panel, BorderLayout.CENTER);
        add(new RangePanel(plot.getRange()), BorderLayout.SOUTH);
        
        // register listeners
        expressionField.addActionListener(new ActionListener() {
            public void actionPerformed(final ActionEvent ev) {
                // called when user presses ENTER key in expressionField
                final String text = expressionField.getText();
                plot.getFunction().setExpression(text);
            }
        });
        pack();
    }
    
}