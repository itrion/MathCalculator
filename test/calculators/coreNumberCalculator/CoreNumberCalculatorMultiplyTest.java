package calculators.coreNumberCalculator;

import calculators.CoreNumberCalculator;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class CoreNumberCalculatorMultiplyTest {

    private CoreNumberCalculator createCoreNumberCalculator(){
        return new CoreNumberCalculator();
    }

    @Test
    public void multiplyDoubleDouble(){
        assertEquals(8.0, (double)createCoreNumberCalculator().multiply(new types.Double(2.0), new types.Double(4.0)).getValue(), 0.001);
    }

    @Test
    public void multiplyDoubleInteger(){
        assertEquals(8.0, (double)createCoreNumberCalculator().multiply(new types.Double(2.0), new types.Integer(4)).getValue(), 0.001);
    }

    @Test
    public void multiplyIntegerDouble(){
        assertEquals(8.0, (double)createCoreNumberCalculator().multiply(new types.Integer(2), new types.Double(4.0)).getValue(), 0.001);
    }

    @Test
    public void multiplyIntegerIntger(){
        assertEquals(8, (int)createCoreNumberCalculator().multiply(new types.Integer(2), new types.Integer(4)).getValue(), 0.001);
    }
}
