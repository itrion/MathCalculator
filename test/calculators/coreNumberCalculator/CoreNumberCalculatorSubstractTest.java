package calculators.coreNumberCalculator;

import calculators.CoreNumberCalculator;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class CoreNumberCalculatorSubstractTest {

    private CoreNumberCalculator createCoreNumberCalculator(){
        return new CoreNumberCalculator();
    }

    @Test
    public void substractDoubleDouble(){
        assertEquals(-2.0, (double) createCoreNumberCalculator().substract(new nodes.types.Double(2.0), new nodes.types.Double(4.0)).getValue(), 0.001);
    }

    @Test
    public void substractDoubleInteger(){
        assertEquals(-2.0, (double) createCoreNumberCalculator().substract(new nodes.types.Double(2.0), new nodes.types.Integer(4)).getValue(), 0.001);
    }

    @Test
    public void substractIntegerDouble(){
        assertEquals(-2.0, (double) createCoreNumberCalculator().substract(new nodes.types.Integer(2), new nodes.types.Double(4.0)).getValue(), 0.001);
    }

    @Test
    public void substractIntegerIntger(){
        assertEquals(-2, (int) createCoreNumberCalculator().substract(new nodes.types.Integer(2), new nodes.types.Integer(4)).getValue(), 0.001);
    }
}
