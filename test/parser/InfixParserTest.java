package parser;

import core.Node;
import core.Operator;
import core.OperatorList;
import junit.framework.Assert;
import nodes.operations.BinaryOperation;
import nodes.types.Double;
import nodes.types.Integer;
import org.junit.Test;
import parsers.InfixParser;

public class InfixParserTest {

    @Test
    public void emptyOperationTest() {
        InfixParser parser = getParser("");
        Node parse = parser.parse();
        Assert.assertEquals(null, parse);
    }

    @Test
    public void simpleAddTest() {
        InfixParser parser = getParser("3+2");
        Node result = parser.parse();
        Assert.assertTrue(result instanceof BinaryOperation);
        BinaryOperation operation = (BinaryOperation) result;
        Assert.assertEquals(Operator.ADD.getName(), operation.getOperator().getName());
        Assert.assertEquals(Integer.class, operation.getLeftChild().getClass());
        Assert.assertEquals(Integer.class, operation.getRightChild().getClass());
        Assert.assertEquals(3, operation.getLeftChild().evaluate().getValue());
        Assert.assertEquals(2, operation.getRightChild().evaluate().getValue());
        Assert.assertEquals(5, operation.evaluate().getValue());
    }

    @Test
    public void simpleSubstractTest() {
        InfixParser parser = getParser("3-2");
        Node result = parser.parse();
        Assert.assertTrue(result instanceof BinaryOperation);
        BinaryOperation operation = (BinaryOperation) result;
        Assert.assertEquals(Operator.SUBSTRACT.getName(), operation.getOperator().getName());
        Assert.assertEquals(Integer.class, operation.getLeftChild().getClass());
        Assert.assertEquals(Integer.class, operation.getRightChild().getClass());
        Assert.assertEquals(3, operation.getLeftChild().evaluate().getValue());
        Assert.assertEquals(2, operation.getRightChild().evaluate().getValue());
        Assert.assertEquals(1, operation.evaluate().getValue());
    }

    @Test
    public void simpleMultiplyTest() {
        InfixParser parser = getParser("3*2");
        Node result = parser.parse();
        Assert.assertTrue(result instanceof BinaryOperation);
        BinaryOperation operation = (BinaryOperation) result;
        Assert.assertEquals(Operator.MULTIPLY.getName(), operation.getOperator().getName());
        Assert.assertEquals(Integer.class, operation.getLeftChild().getClass());
        Assert.assertEquals(Integer.class, operation.getRightChild().getClass());
        Assert.assertEquals(3, operation.getLeftChild().evaluate().getValue());
        Assert.assertEquals(2, operation.getRightChild().evaluate().getValue());
        Assert.assertEquals(6, operation.evaluate().getValue());
    }

    @Test
    public void simpleDivideTest() {
        InfixParser parser = getParser("3/2");
        Node result = parser.parse();
        Assert.assertTrue(result instanceof BinaryOperation);
        BinaryOperation operation = (BinaryOperation) result;
        Assert.assertEquals(Operator.DIVIDE.getName(), operation.getOperator().getName());
        Assert.assertEquals(Integer.class, operation.getLeftChild().getClass());
        Assert.assertEquals(Integer.class, operation.getRightChild().getClass());
        Assert.assertEquals(3, operation.getLeftChild().evaluate().getValue());
        Assert.assertEquals(2, operation.getRightChild().evaluate().getValue());
        Assert.assertEquals(1.5, operation.evaluate().getValue());
    }

    @Test
    public void integerTest() {
        InfixParser parser = getParser("3");
        Node parse = parser.parse();
        Assert.assertEquals(Integer.class, parse.getClass());
    }

    @Test
    public void doubleTest() {
        InfixParser parser = getParser("3.0");
        Node parse = parser.parse();
        Assert.assertEquals(Double.class, parse.getClass());
    }

    @Test
    public void sumMultiplyTest() {
        InfixParser parser = getParser("3+4*2");
        BinaryOperation parse = (BinaryOperation) parser.parse();
        Assert.assertEquals(Operator.ADD.getName(), parse.getOperator().getName());
        Assert.assertEquals(Operator.MULTIPLY.getName(), ((BinaryOperation) parse.getRightChild()).getOperator().getName());
        Assert.assertEquals(11, parse.evaluate().getValue());
    }

    @Test
    public void multiplySumTest() {
        InfixParser parser = getParser("4*2+3");
        BinaryOperation parse = (BinaryOperation) parser.parse();
        Assert.assertEquals(Operator.ADD.getName(), parse.getOperator().getName());
        Assert.assertEquals(Operator.MULTIPLY.getName(), ((BinaryOperation) parse.getLeftChild()).getOperator().getName());
        Assert.assertEquals(11, parse.evaluate().getValue());
    }

    @Test
    public void sumDivideTest() {
        InfixParser parser = getParser("3+4/2");
        BinaryOperation parse = (BinaryOperation) parser.parse();
        Assert.assertEquals(Operator.ADD.getName(), parse.getOperator().getName());
        Assert.assertEquals(Operator.DIVIDE.getName(), ((BinaryOperation) parse.getRightChild()).getOperator().getName());
        Assert.assertEquals(5.0, parse.evaluate().getValue());
    }

    @Test
    public void DivideSumTest() {
        InfixParser parser = getParser("4/2+3");
        BinaryOperation parse = (BinaryOperation) parser.parse();
        Assert.assertEquals(Operator.ADD.getName(), parse.getOperator().getName());
        Assert.assertEquals(Operator.DIVIDE.getName(), ((BinaryOperation) parse.getLeftChild()).getOperator().getName());
        Assert.assertEquals(5.0, parse.evaluate().getValue());
    }

    @Test
    public void substractMultiplyTest() {
        InfixParser parser = getParser("3-4*2");
        BinaryOperation parse = (BinaryOperation) parser.parse();
        Assert.assertEquals(Operator.SUBSTRACT.getName(), parse.getOperator().getName());
        Assert.assertEquals(Operator.MULTIPLY.getName(), ((BinaryOperation) parse.getRightChild()).getOperator().getName());
        Assert.assertEquals(-5, parse.evaluate().getValue());
    }

    @Test
    public void multiplySubstractTest() {
        InfixParser parser = getParser("4*2-3");
        BinaryOperation parse = (BinaryOperation) parser.parse();
        Assert.assertEquals(Operator.SUBSTRACT.getName(), parse.getOperator().getName());
        Assert.assertEquals(Operator.MULTIPLY.getName(), ((BinaryOperation) parse.getLeftChild()).getOperator().getName());
        Assert.assertEquals(5, parse.evaluate().getValue());
    }

    @Test
    public void substractDivideTest() {
        InfixParser parser = getParser("3-4/2");
        BinaryOperation parse = (BinaryOperation) parser.parse();
        Assert.assertEquals(Operator.SUBSTRACT.getName(), parse.getOperator().getName());
        Assert.assertEquals(Operator.DIVIDE.getName(), ((BinaryOperation) parse.getRightChild()).getOperator().getName());
        Assert.assertEquals(1.0, parse.evaluate().getValue());
    }

    @Test
    public void divideSubstractTest() {
        InfixParser parser = getParser("4/2-3");
        BinaryOperation parse = (BinaryOperation) parser.parse();
        Assert.assertEquals(Operator.SUBSTRACT.getName(), parse.getOperator().getName());
        Assert.assertEquals(Operator.DIVIDE.getName(), ((BinaryOperation) parse.getLeftChild()).getOperator().getName());
        Assert.assertEquals(-1.0, parse.evaluate().getValue());
    }

    @Test
    public void doubleIntegerTest() {
        InfixParser parser = getParser("3.5+2");
        BinaryOperation node = (BinaryOperation) parser.parse();
        Assert.assertEquals(5.5, node.evaluate().getValue());
    }

    @Test
    public void integerDoubleTest() {
        InfixParser parser = getParser("2-3.5");
        BinaryOperation node = (BinaryOperation) parser.parse();
        Assert.assertEquals(-1.5, node.evaluate().getValue());
    }

    private OperatorList getOpeartorList() {
        OperatorList operators = new OperatorList();
        operators.add(Operator.ADD);
        operators.add(Operator.DIVIDE);
        operators.add(Operator.MULTIPLY);
        operators.add(Operator.SUBSTRACT);
        return operators;
    }

    private InfixParser getParser(String text) {
        InfixParser parser = new InfixParser(text);
        parser.setOperators(getOpeartorList());
        return parser;
    }
}
