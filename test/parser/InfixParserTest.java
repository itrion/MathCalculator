package parser;

import core.Node;
import core.Operator;
import core.OperatorList;
import junit.framework.Assert;
import nodes.operations.BinaryOperation;
import nodes.types.Integer;
import org.junit.Test;
import parsers.InfixParser;

public class InfixParserTest {
    
    @Test
    public void addStringParsertTest(){
        InfixParser parser = new InfixParser("3+2");
        OperatorList operators = new OperatorList();
        operators.add(Operator.ADD);
        operators.add(Operator.DIVIDE);
        operators.add(Operator.MULTIPLY);
        operators.add(Operator.SUBSTRACT);
        parser.setOperators(operators);
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
