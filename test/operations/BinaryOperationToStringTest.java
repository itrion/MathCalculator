package operations;

import core.Node;
import core.Operator;
import junit.framework.Assert;
import nodes.Constant;
import nodes.operations.BinaryOperation;
import org.junit.Test;
import org.mockito.Mockito;
import static org.mockito.Mockito.*;

public class BinaryOperationToStringTest {

    @Test
    public void testToStringFromAdd() {
        BinaryOperation add = new BinaryOperation();
        add.setOperator(Operator.ADD);
        add.setLeftChild(new Constant(new types.Integer(2)));
        add.setRightChild(new Constant(new types.Integer(3)));
        Assert.assertEquals("2+3", add.toString());
    }

    @Test
    public void testToStringFromSubstract() {
        BinaryOperation add = new BinaryOperation();
        add.setOperator(Operator.SUBSTRACT);
        add.setLeftChild(new Constant(new types.Integer(2)));
        add.setRightChild(new Constant(new types.Integer(3)));
        Assert.assertEquals("2-3", add.toString());
    }

    @Test
    public void testToStringFromMultiply() {
        BinaryOperation add = new BinaryOperation();
        add.setOperator(Operator.MULTIPLY);
        add.setLeftChild(new Constant(new types.Integer(2)));
        add.setRightChild(new Constant(new types.Integer(3)));
        Assert.assertEquals("2*3", add.toString());
    }

    @Test
    public void testToStringFromDivide() {
        BinaryOperation add = new BinaryOperation();
        add.setOperator(Operator.DIVIDE);
        add.setLeftChild(new Constant(new types.Integer(2)));
        add.setRightChild(new Constant(new types.Integer(3)));
        Assert.assertEquals("2/3", add.toString());
    }

    @Test
    public void testOperationWithPrecedence() {
        BinaryOperation operation = new BinaryOperation();
        operation.setOperator(Operator.DIVIDE);
        operation.setLeftChild(getMockedLeftChild());
        operation.setRightChild(getMockedRightChild());
        Assert.assertEquals("(2+3)/2", operation.toString());
    }

    private Node getMockedLeftChild() {
        BinaryOperation leftChild = Mockito.mock(BinaryOperation.class);
        when(leftChild.toString()).thenReturn("2+3");
        return leftChild;
    }

    private Node getMockedRightChild() {
        Constant rightChild = Mockito.mock(Constant.class);
        when(rightChild.toString()).thenReturn("2");
        return rightChild;
    }
}