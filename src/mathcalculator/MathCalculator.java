package mathcalculator;

import calculators.NumberCalculator;
import core.Operator;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import nodes.operations.BinaryOperation;
import org.reflections.Reflections;

public class MathCalculator {

    static{
        try {
            Reflections reflections = new Reflections("calculators");
            Set<Class<? extends NumberCalculator>> calculators = reflections.getSubTypesOf(NumberCalculator.class);
            for(Class calculator:calculators)
                calculator.newInstance();
        } catch (InstantiationException | IllegalAccessException ex) {
            Logger.getLogger(MathCalculator.class.getName()).log(Level.SEVERE, null, ex);
        }
            
    }
    public static void main(String[] args){
        BinaryOperation binaryOperation = new BinaryOperation();
        binaryOperation.setOperator(Operator.ADD);
        binaryOperation.setLeftChild(new nodes.types.Double(2.0));
        binaryOperation.setRightChild(new nodes.types.Double(1.0));
        System.out.println(binaryOperation.evaluate().getValue());
    }
}
