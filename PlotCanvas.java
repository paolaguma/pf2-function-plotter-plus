import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

/**
 * The PlotCanvas is part of the GUI.
 * It is a custom component, which draws itself
 * (in the paintComponent method)
 * and which provides information on how big it would like to be
 * (via the getPreferredSize method).
 */
public final class PlotCanvas extends Canvas {

    private static final Dimension PREFERRED_SIZE = new Dimension(400, 300);
    
    private final Cursor cursor;
    
    
    /**
     * Create a PlotCanvas for the given Plot.
     * @param plot The Plot to show
     */
    public PlotCanvas(final Plot plot) {
        super(plot);
        this.cursor = plot.getCursor();
        
        // register listeners        
        cursor.addCursorListener(new CursorListener() {
            public void cursorChanged(final Cursor cursor) {
                repaint();
            }
        });
        addMouseListener(new MouseAdapter() {
            public void mousePressed(final MouseEvent ev) {
                cursor.setX(xViewToModel(ev.getX()));
            }
        });
        addMouseMotionListener(new MouseMotionAdapter() {
            public void mouseDragged(final MouseEvent ev) {
                cursor.setX(xViewToModel(ev.getX()));
            }
        });
    }
    
    @Override
    public Dimension getPreferredSize() {
        return PREFERRED_SIZE;
    }
    
    @Override
    public void paintComponent(final Graphics g) {
        // fill the background with white
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, getWidth(), getHeight());
        
        // find min and max model y
        final double minModelY = range.getMin();
        final double maxModelY = range.getMax();

        drawAxes(g, minModelY, maxModelY);

        // plot curve
        drawFunction(g, minModelY, maxModelY);
        
        // draw x and y cursor
        drawCursors(g, minModelY, maxModelY);
    }   

    private void drawFunction(final Graphics g, final double minModelY, final double maxModelY) {
        g.setColor(Color.BLUE);
        //iterate through vx(viewX) -> xViewtoModel
        // calculate yModel using function.f(x);
        // plot y to view yModeltoView
        final Graphics2D g2d = (Graphics2D)g;
        int prevX = 0;
        int prevY = 0;
        for (int vx = 0; vx < getWidth(); vx++) {
            
            final double xModel = xViewToModel(vx);
            final double yModel = function.compute(xModel);
            final int vy = yModelToView(yModel, minModelY, maxModelY);
            
            if (vx == 0) {
                prevX = vx;
                prevY = vy;
            }
            g2d.setRenderingHint(
                RenderingHints.KEY_ANTIALIASING, 
                RenderingHints.VALUE_ANTIALIAS_ON);
            g2d.drawLine(prevX, prevY, vx, vy);

            prevX = vx;
            prevY = vy;
        }
    }

    private void drawAxes(final Graphics g, final double minModelY, final double maxModelY) {
        // plot x axis (at y=0)
        g.setColor(Color.GRAY);
        final int viewY0 = yModelToView(0, minModelY, maxModelY);
        g.drawLine(0, viewY0, getWidth(), viewY0);
        
        // plot y axis (x = 0)
        final int viewX0 = xModelToView(0);
        g.drawLine(viewX0, 0, viewX0, getHeight());
    }

    private void drawCursors(final Graphics g, final double minModelY, final double maxModelY) {
        g.setColor(Color.BLACK);
        final int cursorViewX = xModelToView(cursor.getX());
        g.drawLine(cursorViewX, 0, cursorViewX, getHeight());
        g.drawString("x = " + cursor.getX(), cursorViewX + 4, getHeight() - 20);
        // draw y cursor
        final double cursorModelY = function.compute(cursor.getX());
        final int cursorViewY = yModelToView(cursorModelY, minModelY, maxModelY);
        g.drawLine(0, cursorViewY, getWidth(), cursorViewY);
        g.drawString("y = " + cursorModelY, cursorViewX + 4, getHeight() - 4);
    }
    
    private double xViewToModel(final int vx) {
        return ((double)vx) / getWidth() * range.getExtent() + range.getMin();
    }
    
    private int xModelToView(final double x) {
        return (int)((x - range.getMin()) / range.getExtent() * getWidth());

    }
    
    private int yModelToView(final double y, final double minY, final double maxY) {
        return (int)(getHeight() - 1 - (y - minY) / (maxY - minY) * getHeight());
    }
}