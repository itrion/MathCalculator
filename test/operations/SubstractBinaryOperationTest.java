package operations;

import calculators.NumberCalculator;
import core.Operator;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import nodes.operations.BinaryOperation;
import nodes.types.Double;
import nodes.types.Integer;
import static org.junit.Assert.*;
import org.junit.BeforeClass;
import org.junit.Test;
import org.reflections.Reflections;

public class SubstractBinaryOperationTest {

    @BeforeClass
    public static void init(){
        Reflections reflections = new Reflections("calculators");
        Set<Class<? extends NumberCalculator>> calculators = reflections.getSubTypesOf(NumberCalculator.class);
        for (Class<? extends NumberCalculator> calculator : calculators)
            try {
                calculator.newInstance();
            } catch (InstantiationException | IllegalAccessException ex) {
                Logger.getLogger(AddBinaryOperationTest.class.getName()).log(Level.SEVERE, null, ex);
            }
    }

    @Test
    public void substractRDoubleDoubleReturnsDouble(){
        final BinaryOperation binaryOperation = new BinaryOperation();
        binaryOperation.setLeftChild(new Double(3.0));
        binaryOperation.setRightChild(new Double(2.0));
        binaryOperation.setOperator(Operator.SUBSTRACT);
        assertEquals(Double.class, binaryOperation.evaluate().getClass());
    }

    @Test
    public void substractRDoubleIntegerReturnsDouble(){
        final BinaryOperation binaryOperation = new BinaryOperation();
        binaryOperation.setLeftChild(new Double(3.0));
        binaryOperation.setRightChild(new Integer(2));
        binaryOperation.setOperator(Operator.SUBSTRACT);
        assertEquals(Double.class, binaryOperation.evaluate().getClass());
    }

    @Test
    public void substractRIntegerDoubleReturnsDouble(){
        final BinaryOperation binaryOperation = new BinaryOperation();
        binaryOperation.setLeftChild(new Integer(3));
        binaryOperation.setRightChild(new Double(2.0));
        binaryOperation.setOperator(Operator.SUBSTRACT);
        assertEquals(Double.class, binaryOperation.evaluate().getClass());
    }

    @Test
    public void substractIntegerIntegerReturnsInteger(){
        final BinaryOperation binaryOperation = new BinaryOperation();
        binaryOperation.setLeftChild(new Integer(3));
        binaryOperation.setRightChild(new Integer(2));
        binaryOperation.setOperator(Operator.SUBSTRACT);
        assertEquals(Integer.class, binaryOperation.evaluate().getClass());
    }
}