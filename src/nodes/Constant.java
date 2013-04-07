package nodes;

import core.Node;
import core.Type;

public class Constant<T extends Type> implements Node{
    private final int PRECEDENCE = 1;
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

    @Override
    public String toString() {
        return constant.toString();
    }

    @Override
    public int getPrecedence() {
        return PRECEDENCE;
    }
}
