package operations;

import core.Operator;
import nodes.operations.BinaryOperation;
import nodes.types.Double;
import nodes.types.Integer;
import static org.junit.Assert.*;
import org.junit.Test;

public class AddBinaryOperationTest {

    @Test
    public void addRDoubleDoubleReturnsDouble(){
        final BinaryOperation binaryOperation = new BinaryOperation();
        binaryOperation.setLeftChild(new Double(3.0));
        binaryOperation.setRightChild(new Double(2.0));
        binaryOperation.setOperator(Operator.ADD);
        assertEquals(Double.class, binaryOperation.evaluate().getClass());
    }

    @Test
    public void addRDoubleIntegerReturnsDouble(){
        final BinaryOperation binaryOperation = new BinaryOperation();
        binaryOperation.setLeftChild(new Double(3.0));
        binaryOperation.setRightChild(new Integer(2));
        binaryOperation.setOperator(Operator.ADD);
        assertEquals(Double.class, binaryOperation.evaluate().getClass());
    }

    @Test
    public void addRIntegerDoubleReturnsDouble(){
        final BinaryOperation binaryOperation = new BinaryOperation();
        binaryOperation.setLeftChild(new Integer(3));
        binaryOperation.setRightChild(new Double(2.0));
        binaryOperation.setOperator(Operator.ADD);
        assertEquals(Double.class, binaryOperation.evaluate().getClass());
    }

    @Test
    public void addIntegerIntegerReturnsInteger(){
        final BinaryOperation binaryOperation = new BinaryOperation();
        binaryOperation.setLeftChild(new Integer(3));
        binaryOperation.setRightChild(new Integer(2));
        binaryOperation.setOperator(Operator.ADD);
        assertEquals(Integer.class, binaryOperation.evaluate().getClass());
    }
}