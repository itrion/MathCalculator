package calculators.coreNumberCalculator;

import calculators.CoreNumberCalculator;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class CoreNumberCalculatorDivideTest {

    private CoreNumberCalculator createCoreNumberCalculator(){
        return new CoreNumberCalculator();
    }

    @Test
    public void divideDoubleDouble(){
        assertEquals(0.5, (double)createCoreNumberCalculator().divide(new nodes.types.Double(2.0), new nodes.types.Double(4.0)).getValue(), 0.001);
    }

    @Test
    public void divideDoubleInteger(){
        assertEquals(0.5, (double)createCoreNumberCalculator().divide(new nodes.types.Double(2.0), new nodes.types.Integer(4)).getValue(), 0.001);
    }

    @Test
    public void divideIntegerDouble(){
        assertEquals(0.5, (double)createCoreNumberCalculator().divide(new nodes.types.Integer(2), new nodes.types.Double(4.0)).getValue(), 0.001);
    }

    @Test
    public void divideIntegerIntger(){
        assertEquals(0, (int)createCoreNumberCalculator().divide(new nodes.types.Integer(2), new nodes.types.Integer(4)).getValue(), 0.001);
    }
}
