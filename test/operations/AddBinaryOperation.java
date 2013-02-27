package operations;
import nodes.BinaryOperation;
import types.Double;
import static org.junit.Assert.*;
import org.junit.Test;
public class AddBinaryOperation {
    @Test
    public void addBinaryOperation(){
        final BinaryOperation binaryOperation = new BinaryOperation();
        binaryOperation.setLeftChild(new Double(3.0));
        binaryOperation.setRightChild(new Double(2.0));
        assertEquals(Double.class, binaryOperation.evaluate());
    }

    public AddBinaryOperation(){
    }
}