package mathcalculator;

import core.Node;
import core.Operator;
import core.OperatorList;
import parsers.InfixParser;

public class MathCalculator {

    public static void main(String[] args){
        InfixParser parser = new InfixParser("10*10/10+1+1-2");
        OperatorList operators = new OperatorList();
        operators.add(Operator.ADD);
        operators.add(Operator.DIVIDE);
        operators.add(Operator.MULTIPLY);
        operators.add(Operator.SUBSTRACT);
        parser.setOperators(operators);
        Node opeartion = parser.parse();
        System.out.println(opeartion.evaluate().getValue());
    }
}
