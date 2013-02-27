package core;
//TODO Search a better name for calculator

import calculators.CoreNumberCalculator;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.logging.Level;
import java.util.logging.Logger;
import types.Double;

public class Calculator {
    private static Calculator instance = null;

    public static Calculator getInstance(){
        if (instance != null) return instance;
        else return instance = new Calculator();
    }

    public static Type solve(Operator operator, Type[] parameters){
        try {
            final String signature = getSignature(operator,parameters);
            Method operationMethod = CoreNumberCalculator.getMethod(signature);
            return (Type) operationMethod.invoke(new CoreNumberCalculator(), (Object[]) parameters);
        } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException ex) {
            Logger.getLogger(Calculator.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    private static String getSignature(Operator operator, Type[] parameters){
        String signature = operator.getName();
        for (Type type:parameters)
            signature += type.getName();
        return signature;
    }
}
