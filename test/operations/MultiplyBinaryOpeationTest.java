package operations;

import calculators.NumberCalculator;
import core.Operator;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import nodes.BinaryOperation;
import static org.junit.Assert.assertEquals;
import org.junit.BeforeClass;
import org.junit.Test;
import org.reflections.Reflections;

public class MultiplyBinaryOpeationTest {

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
    public void addRDoubleDoubleReturnsDouble(){
        final BinaryOperation binaryOperation = new BinaryOperation();
        binaryOperation.setLeftChild(new types.Double(3.0));
        binaryOperation.setRightChild(new types.Double(2.0));
        binaryOperation.setOperator(Operator.MULTIPLY);
        assertEquals(types.Double.class, binaryOperation.evaluate().getClass());
    }

    @Test
    public void addRDoubleIntegerReturnsDouble(){
        final BinaryOperation binaryOperation = new BinaryOperation();
        binaryOperation.setLeftChild(new types.Double(3.0));
        binaryOperation.setRightChild(new types.Integer(2));
        binaryOperation.setOperator(Operator.MULTIPLY);
        assertEquals(types.Double.class, binaryOperation.evaluate().getClass());
    }

    @Test
    public void addRIntegerDoubleReturnsDouble(){
        final BinaryOperation binaryOperation = new BinaryOperation();
        binaryOperation.setLeftChild(new types.Integer(3));
        binaryOperation.setRightChild(new types.Double(2.0));
        binaryOperation.setOperator(Operator.MULTIPLY);
        assertEquals(types.Double.class, binaryOperation.evaluate().getClass());
    }

    @Test
    public void addIntegerIntegerReturnsInteger(){
        final BinaryOperation binaryOperation = new BinaryOperation();
        binaryOperation.setLeftChild(new types.Integer(3));
        binaryOperation.setRightChild(new types.Integer(2));
        binaryOperation.setOperator(Operator.MULTIPLY);
        assertEquals(types.Integer.class, binaryOperation.evaluate().getClass());
    }
}
