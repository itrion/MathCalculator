package core;

import annotations.Operation;
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

    private static HashMap<String, Method> registeredMethods;

    static {
        registeredMethods = new LinkedHashMap<>();
        Reflections reflections = new Reflections("calculators");
        Set<Class<? extends Calculator>> calculators = reflections.getSubTypesOf(Calculator.class);
        for (Class calculator : calculators)
            registerCalculatorMethods(calculator);
    }

    public static Type solve(Operator operator, Type[] parameters) {
        try {
            String signature = getOperationSignature(operator, parameters);
            Method operationMethod = getOperationMethod(signature);
            return (Type) operationMethod.invoke(operationMethod.getDeclaringClass().newInstance(), (Object[]) parameters);
        } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException | InstantiationException ex) {
            Logger.getLogger(CalculatorFinder.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    private static void registerCalculatorMethods(Class calculator) {
        for (Method method : calculator.getDeclaredMethods())
            if (method.isAnnotationPresent(Operation.class))
                registerMethod(getMethodSignature(method), method);
    }

    private static String getMethodSignature(Method method) {
        String signature = method.getName();
        for (Class classs : method.getParameterTypes())
            signature += classs.getSimpleName();
        return signature;
    }

    private static String getOperationSignature(Operator operator, Type[] parameters) {
        String signature = operator.getName();
        for (Type type : parameters)
            signature += type.getName();
        return signature;
    }

    public static void registerMethod(String signature, Method method) {
        registeredMethods.put(signature, method);
    }

    private static Method getOperationMethod(String signature) {
        return registeredMethods.get(signature);
    }
}
