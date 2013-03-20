package types;

import core.Type;

public class Integer extends Type<java.lang.Integer> {

    public Integer(java.lang.Integer value) {
        super(value);
    }

    @Override
    public String getName() {
        return "Integer";
    }
}
