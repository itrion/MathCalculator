package core;

import calculators.Calculator;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.reflections.Reflections;

public class CalculatorFinder {

    private static CalculatorFinder instance = null;
    private static HashMap<String, Method> registeredCalculators;

    static {
        try {
            Reflections reflections = new Reflections("calculators");
            Set<Class<? extends Calculator>> calculators = reflections.getSubTypesOf(Calculator.class);
            for (Class calculator : calculators)
                calculator.newInstance();
        } catch (InstantiationException | IllegalAccessException ex) {
            Logger.getLogger(CalculatorFinder.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static CalculatorFinder getInstance() {
        if (instance != null) return instance;
        else return instance = new CalculatorFinder();

    }

    public Type solve(Operator operator, Type[] parameters) {
        try {
            final String signature = getSignature(operator, parameters);
            Method operationMethod = getOperationMethod(signature);
            return (Type) operationMethod.invoke(operationMethod.getDeclaringClass().newInstance(), (Object[]) parameters);
        } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException | InstantiationException ex) {
            Logger.getLogger(CalculatorFinder.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    private String getSignature(Operator operator, Type[] parameters) {
        String signature = operator.getName();
        for (Type type : parameters)
            signature += type.getName();
        return signature;
    }

    public void registerMethod(String signature, Method method) {
        if (registeredCalculators == null)
            registeredCalculators = new LinkedHashMap<>();
        registeredCalculators.put(signature, method);
    }

    private Method getOperationMethod(String signature) {
        return registeredCalculators.get(signature);
    }
}
