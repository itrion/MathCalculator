package calculators;

import static org.junit.Assert.*;
import org.junit.Test;
import types.Double;
import types.Integer;

public class CoreNumberCalculatorTest {

    private CoreNumberCalculator createCoreNumberCalculator(){
        return new CoreNumberCalculator();
    }

    @Test
    public void addDoubleDouble(){
        assertEquals(6.0, (double)createCoreNumberCalculator().add(new Double(2.0), new Double(4.0)).getValue(), 0.001);
    }

    @Test
    public void addDoubleInteger(){
        assertEquals(6.0, (double)createCoreNumberCalculator().add(new Double(2.0), new Integer(4)).getValue(), 0.001);
    }

    @Test
    public void addIntegerDouble(){
        assertEquals(6.0, (double)createCoreNumberCalculator().add(new Integer(2), new Double(4.0)).getValue(), 0.001);
    }

    @Test
    public void addIntegerIntger(){
        assertEquals(6, (int)createCoreNumberCalculator().add(new Integer(2), new Integer(4)).getValue(), 0.001);
    }
    
    @Test
    public void substractDoubleDouble(){
        assertEquals(-2.0, (double) createCoreNumberCalculator().substract(new Double(2.0), new Double(4.0)).getValue(), 0.001);
    }

    @Test
    public void substractDoubleInteger(){
        assertEquals(-2.0, (double) createCoreNumberCalculator().substract(new Double(2.0), new Integer(4)).getValue(), 0.001);
    }

    @Test
    public void substractIntegerDouble(){
        assertEquals(-2.0, (double) createCoreNumberCalculator().substract(new Integer(2), new Double(4.0)).getValue(), 0.001);
    }

    @Test
    public void substractIntegerIntger(){
        assertEquals(-2, (int) createCoreNumberCalculator().substract(new Integer(2), new Integer(4)).getValue(), 0.001);
    }
}