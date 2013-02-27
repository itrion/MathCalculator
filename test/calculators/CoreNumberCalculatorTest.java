package calculators;

import static org.junit.Assert.*;
import org.junit.Test;

public class CoreNumberCalculatorTest {

    private CoreNumberCalculator createCoreNumberCalculator(){
        return new CoreNumberCalculator();
    }

    @Test
    public void addDoubleDouble(){
        assertEquals(3.0, createCoreNumberCalculator().add(1.0, 2.0), 0.001);
    }

    @Test
    public void addDoubleInteger(){
        assertEquals(3.0, createCoreNumberCalculator().add(1.0, 2), 0.001);
    }

    @Test
    public void addIntegerDouble(){
        assertEquals(3.0, createCoreNumberCalculator().add(1, 2.0), 0.001);
    }

    @Test
    public void addIntegerIntger(){
        assertEquals(3, createCoreNumberCalculator().add(1, 2), 0.001);
    }

    @Test
    public void substractDoubleDouble(){
        assertEquals(-1.0, createCoreNumberCalculator().substract(1.0, 2.0), 0.001);
    }

    @Test
    public void substractDoubleInteger(){
        assertEquals(-1.0, createCoreNumberCalculator().substract(1.0, 2), 0.001);
    }

    @Test
    public void substractIntegerDouble(){
        assertEquals(-1.0, createCoreNumberCalculator().substract(1, 2.0), 0.001);
    }

    @Test
    public void substractIntegerIntger(){
        assertEquals(-1, createCoreNumberCalculator().substract(1, 2), 0.001);
    }
}