package operations;

import core.Operator;
import nodes.Constant;
import nodes.operations.BinaryOperation;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class DivideBinaryOperationTest {

    @Test
    public void divideRDoubleDoubleReturnsDouble(){
        final BinaryOperation binaryOperation = new BinaryOperation();
        binaryOperation.setLeftChild(new Constant(new types.Double(3.0)));
        binaryOperation.setRightChild(new Constant(new types.Double(2.0)));
        binaryOperation.setOperator(Operator.DIVIDE);
        assertEquals(types.Double.class, binaryOperation.evaluate().getClass());
    }

    @Test
    public void divideRDoubleIntegerReturnsDouble(){
        final BinaryOperation binaryOperation = new BinaryOperation();
        binaryOperation.setLeftChild(new Constant(new types.Double(3.0)));
        binaryOperation.setRightChild(new Constant(new types.Integer(2)));
        binaryOperation.setOperator(Operator.DIVIDE);
        assertEquals(types.Double.class, binaryOperation.evaluate().getClass());
    }

    @Test
    public void divideRIntegerDoubleReturnsDouble(){
        final BinaryOperation binaryOperation = new BinaryOperation();
        binaryOperation.setLeftChild(new Constant(new types.Integer(3)));
        binaryOperation.setRightChild(new Constant(new types.Double(2.0)));
        binaryOperation.setOperator(Operator.DIVIDE);
        assertEquals(types.Double.class, binaryOperation.evaluate().getClass());
    }

    @Test
    public void divideIntegerIntegerReturnsInteger(){
        final BinaryOperation binaryOperation = new BinaryOperation();
        binaryOperation.setLeftChild(new Constant(new types.Integer(3)));
        binaryOperation.setRightChild(new Constant(new types.Integer(2)));
        binaryOperation.setOperator(Operator.DIVIDE);
        assertEquals(types.Double.class, binaryOperation.evaluate().getClass());
    }
}
