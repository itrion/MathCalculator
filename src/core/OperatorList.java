package core;

import java.util.ArrayList;

public class OperatorList extends ArrayList<Operator>{
    
    public boolean hasOperator (String symbol){
        for (Operator operator:this)
            if (operator.getSymbol().equals(symbol)) return true;
        return false;
    }
    
    public Operator getOperatorBySymbol (String symbol){
        for (Operator operator:this)
            if(operator.getSymbol().equals(symbol)) return operator;
        return null;
    }
    
    public Operator getOperatorByName (String name){
        for (Operator operator:this)
            if(operator.getName().equals(name)) return operator;
        return null;
    }
}
