import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class PlotTest {
    
    @Test
    public void testGetFunction() {
        Function f = new Function("1");
        Plot p = new Plot(f, null, null);
        assertSame(f, p.getFunction());
    }
    
    @Test
    public void testGetRange() {
        Range r = new Range(0.0, 0.0);
        Plot p = new Plot(null, r, null);
        assertSame(r, p.getRange());
    }
    
    @Test
    public void testGetCursor() {
        Cursor c = new Cursor(0.0);
        Plot p = new Plot(null, null, c);
        assertSame(c, p.getCursor());
    }
    
}
