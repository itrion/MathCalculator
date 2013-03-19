package operations;

import core.Operator;
import nodes.operations.BinaryOperation;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class DivideBinaryOperationTest {

    @Test
    public void divideRDoubleDoubleReturnsDouble(){
        final BinaryOperation binaryOperation = new BinaryOperation();
        binaryOperation.setLeftChild(new nodes.types.Double(3.0));
        binaryOperation.setRightChild(new nodes.types.Double(2.0));
        binaryOperation.setOperator(Operator.DIVIDE);
        assertEquals(nodes.types.Double.class, binaryOperation.evaluate().getClass());
    }

    @Test
    public void divideRDoubleIntegerReturnsDouble(){
        final BinaryOperation binaryOperation = new BinaryOperation();
        binaryOperation.setLeftChild(new nodes.types.Double(3.0));
        binaryOperation.setRightChild(new nodes.types.Integer(2));
        binaryOperation.setOperator(Operator.DIVIDE);
        assertEquals(nodes.types.Double.class, binaryOperation.evaluate().getClass());
    }

    @Test
    public void divideRIntegerDoubleReturnsDouble(){
        final BinaryOperation binaryOperation = new BinaryOperation();
        binaryOperation.setLeftChild(new nodes.types.Integer(3));
        binaryOperation.setRightChild(new nodes.types.Double(2.0));
        binaryOperation.setOperator(Operator.DIVIDE);
        assertEquals(nodes.types.Double.class, binaryOperation.evaluate().getClass());
    }

    @Test
    public void divideIntegerIntegerReturnsInteger(){
        final BinaryOperation binaryOperation = new BinaryOperation();
        binaryOperation.setLeftChild(new nodes.types.Integer(3));
        binaryOperation.setRightChild(new nodes.types.Integer(2));
        binaryOperation.setOperator(Operator.DIVIDE);
        assertEquals(nodes.types.Double.class, binaryOperation.evaluate().getClass());
    }
}
