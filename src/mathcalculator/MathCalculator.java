package mathcalculator;

import core.Operator;
import nodes.BinaryOperation;

public class MathCalculator {

    public static void main(String[] args){
        BinaryOperation binaryOperation = new BinaryOperation();
        binaryOperation.setOperator(Operator.ADD);
        binaryOperation.setLeftChild(new types.Double(2.0));
        binaryOperation.setRightChild(new types.Double(1.0));
        System.out.println(binaryOperation.evaluate().getValue());
    }
}
