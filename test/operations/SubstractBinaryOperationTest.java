package operations;

import core.Operator;
import nodes.operations.BinaryOperation;
import nodes.types.Double;
import nodes.types.Integer;
import static org.junit.Assert.*;
import org.junit.Test;

public class SubstractBinaryOperationTest {

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