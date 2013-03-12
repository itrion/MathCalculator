package core;

import calculators.Calculator;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CalculatorFinder {

    private static CalculatorFinder instance = null;
    private static HashMap<String, Class<? extends Calculator>> calculators;

    public static CalculatorFinder getInstance(){
        if (instance != null) return instance;
        else return instance = new CalculatorFinder();

    }

    public Type solve(Operator operator, Type[] parameters){
        try {
            final String signature = getSignature(operator, parameters);
            Method operationMethod = getOperationMethod(signature);
            return (Type) operationMethod.invoke(calculators.get(signature).newInstance(), (Object[]) parameters);
        } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException | InstantiationException ex) {
            Logger.getLogger(CalculatorFinder.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    private String getSignature(Operator operator, Type[] parameters){
        String signature = operator.getName();
        for (Type type : parameters)
            signature += type.getName();
        return signature;
    }

    public void registerCalculator(String signature, Class calculator){
        if (calculators == null) calculators = new LinkedHashMap<>();
        calculators.put(signature, calculator);
    }

    private Method getOperationMethod(String signature){
        try {
            Class<? extends Calculator> calculator = calculators.get(signature);
            Method method = calculator.getMethod("getMethodBySignature", new Class<?>[]{String.class});
            return (Method) method.invoke(calculator.newInstance(), new Object[]{signature});
        } catch (Exception e) {
            Logger.getLogger(CalculatorFinder.class.getName()).log(Level.SEVERE, null, e);
        }
        return null;
    }
}
