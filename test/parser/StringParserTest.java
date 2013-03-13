package parser;

import core.Node;
import core.Operator;
import junit.framework.Assert;
import nodes.operations.BinaryOperation;
import org.junit.Test;
import nodes.types.Integer;
import parsers.StringParser;

public class StringParserTest {
    @Test
    public void addStringParsertTest(){
        StringParser parser = new StringParser("3+2");
        Node result = parser.parse();
        Assert.assertTrue(result instanceof BinaryOperation);
        
        BinaryOperation operation = (BinaryOperation) result;
        Assert.assertEquals(Operator.ADD.getClass(), operation.getOperator().getClass());
        
        
        Assert.assertEquals(Integer.class, operation.getLeftChild().getClass());
        Assert.assertEquals(Integer.class, operation.getRightChild().getClass());
        
        Assert.assertEquals(3, operation.getLeftChild().evaluate().getValue());
        Assert.assertEquals(2, operation.getRightChild().evaluate().getValue());
    }
}
