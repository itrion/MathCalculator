package operations;

import core.Operator;
import nodes.Constant;
import nodes.operations.BinaryOperation;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class MultiplyBinaryOpeationTest {

    @Test
    public void addRDoubleDoubleReturnsDouble(){
        final BinaryOperation binaryOperation = new BinaryOperation();
        binaryOperation.setLeftChild(new Constant(new types.Double(3.0)));
        binaryOperation.setRightChild(new Constant(new types.Double(2.0)));
        binaryOperation.setOperator(Operator.MULTIPLY);
        assertEquals(types.Double.class, binaryOperation.evaluate().getClass());
    }

    @Test
    public void addRDoubleIntegerReturnsDouble(){
        final BinaryOperation binaryOperation = new BinaryOperation();
        binaryOperation.setLeftChild(new Constant(new types.Double(3.0)));
        binaryOperation.setRightChild(new Constant(new types.Integer(2)));
        binaryOperation.setOperator(Operator.MULTIPLY);
        assertEquals(types.Double.class, binaryOperation.evaluate().getClass());
    }

    @Test
    public void addRIntegerDoubleReturnsDouble(){
        final BinaryOperation binaryOperation = new BinaryOperation();
        binaryOperation.setLeftChild(new Constant(new types.Integer(3)));
        binaryOperation.setRightChild(new Constant(new types.Double(2.0)));
        binaryOperation.setOperator(Operator.MULTIPLY);
        assertEquals(types.Double.class, binaryOperation.evaluate().getClass());
    }

    @Test
    public void addIntegerIntegerReturnsInteger(){
        final BinaryOperation binaryOperation = new BinaryOperation();
        binaryOperation.setLeftChild(new Constant(new types.Integer(3)));
        binaryOperation.setRightChild(new Constant(new types.Integer(2)));
        binaryOperation.setOperator(Operator.MULTIPLY);
        assertEquals(types.Integer.class, binaryOperation.evaluate().getClass());
    }
}
