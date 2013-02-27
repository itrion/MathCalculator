package types;

import core.Node;
import core.Type;

public class Double extends Type<java.lang.Double> implements Node{

    public Double(java.lang.Double value){
        super(value);
    }
    @Override
    public Type evaluate(){
        return this;
    }

    @Override
    public String getName(){
        return "Double";
    }
    
    
}
