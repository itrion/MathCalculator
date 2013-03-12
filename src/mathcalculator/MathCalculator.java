package mathcalculator;

import calculators.NumberCalculator;
import core.Operator;
import java.util.Set;
import nodes.BinaryOperation;
import org.reflections.Reflections;

public class MathCalculator {

    static{
        Reflections reflections = new Reflections("MathCalculator");
        Set<Class<? extends NumberCalculator>> calculators = reflections.getSubTypesOf(NumberCalculator.class);
        //for(NumberCalculator calculator:calculators)
            
    }
    public static void main(String[] args){
        BinaryOperation binaryOperation = new BinaryOperation();
        binaryOperation.setOperator(Operator.ADD);
        binaryOperation.setLeftChild(new types.Double(2.0));
        binaryOperation.setRightChild(new types.Double(1.0));
        System.out.println(binaryOperation.evaluate().getValue());
    }
}
