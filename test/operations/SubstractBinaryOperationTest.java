package operations;

import core.Operator;
import nodes.Constant;
import nodes.operations.BinaryOperation;
import static org.junit.Assert.*;
import org.junit.Test;
import types.Double;
import types.Integer;

public class SubstractBinaryOperationTest {

    @Test
    public void substractRDoubleDoubleReturnsDouble(){
        final BinaryOperation binaryOperation = new BinaryOperation();
        binaryOperation.setLeftChild(new Constant(new Double(3.0)));
        binaryOperation.setRightChild(new Constant(new Double(2.0)));
        binaryOperation.setOperator(Operator.SUBSTRACT);
        assertEquals(Double.class, binaryOperation.evaluate().getClass());
    }

    @Test
    public void substractRDoubleIntegerReturnsDouble(){
        final BinaryOperation binaryOperation = new BinaryOperation();
        binaryOperation.setLeftChild(new Constant(new Double(3.0)));
        binaryOperation.setRightChild(new Constant(new Integer(2)));
        binaryOperation.setOperator(Operator.SUBSTRACT);
        assertEquals(Double.class, binaryOperation.evaluate().getClass());
    }

    @Test
    public void substractRIntegerDoubleReturnsDouble(){
        final BinaryOperation binaryOperation = new BinaryOperation();
        binaryOperation.setLeftChild(new Constant(new Integer(3)));
        binaryOperation.setRightChild(new Constant(new Double(2.0)));
        binaryOperation.setOperator(Operator.SUBSTRACT);
        assertEquals(Double.class, binaryOperation.evaluate().getClass());
    }

    @Test
    public void substractIntegerIntegerReturnsInteger(){
        final BinaryOperation binaryOperation = new BinaryOperation();
        binaryOperation.setLeftChild(new Constant(new Integer(3)));
        binaryOperation.setRightChild(new Constant(new Integer(2)));
        binaryOperation.setOperator(Operator.SUBSTRACT);
        assertEquals(Integer.class, binaryOperation.evaluate().getClass());
    }
}