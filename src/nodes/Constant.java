package nodes;

import core.Node;
import core.Type;

public class Constant<T extends Type> implements Node{
    private Type<T> constant;

    public Constant(T constant) {
        this.constant = constant;
    }

    public T getValue() {
        return constant.getValue();
    }

    
    @Override
    public Type<T> evaluate() {
        return constant;
    }
    
}
