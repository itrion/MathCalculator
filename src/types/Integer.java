package types;

import core.Node;
import core.Type;

public class Integer extends Type<java.lang.Integer> implements Node {

    public Integer(java.lang.Integer value){
        super(value);
    }

    @Override
    public Type evaluate(){
        return this;
    }

    @Override
    public String getName(){
        return "Integer";
    }
}
