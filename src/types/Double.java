package types;

import core.Type;

public class Double extends Type<java.lang.Double>{

    public Double(java.lang.Double value){
        super(value);
    }
    
    @Override
    public String getName(){
        return "Double";
    }
}
