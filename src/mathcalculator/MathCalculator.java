package mathcalculator;

import calculators.NumberCalculator;
import core.Operator;
import core.OperatorList;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.reflections.Reflections;
import parsers.InfixParser;

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
        InfixParser parser = new InfixParser("354+201*5");
        OperatorList operators = new OperatorList();
        operators.add(Operator.ADD);
        operators.add(Operator.DIVIDE);
        operators.add(Operator.MULTIPLY);
        operators.add(Operator.SUBSTRACT);
        parser.setOperators(operators);
        parser.parse();
    }
}
