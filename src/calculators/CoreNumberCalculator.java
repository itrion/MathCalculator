package calculators;

import annotations.Operation;
import java.lang.reflect.Method;
import java.util.HashMap;
import types.Double;
import types.Integer;

public class CoreNumberCalculator implements NumberCalculator {

    private static final HashMap<String, Method> methods;

    static {
        methods = new HashMap<>();
        for (Method method : CoreNumberCalculator.class.getDeclaredMethods()) {
            if (method.isAnnotationPresent(Operation.class)){
                methods.put(getMethodSignature(method), method);
            }
                
        }
    }

    public static Method getMethod(String signature){
        return methods.get(signature);
    }

    private static String getMethodSignature(Method method){
        String signature="";
        signature += method.getName();
        for (Class classs :method.getParameterTypes())
            signature += classs.getSimpleName();
        return signature;
    }

    @Operation
    @Override
    public Double add(Double a, Double b){
        return new Double(a.getValue() + b.getValue());
    }

    @Operation
    @Override
    public Double add(Double a, Integer b){
        return new Double(a.getValue() + b.getValue());
    }

    @Operation
    @Override
    public Double add(Integer a, Double b){
        return new Double(a.getValue() + b.getValue());
    }

    @Operation
    @Override
    public Integer add(Integer a, Integer b){
        return new Integer(a.getValue() - b.getValue());
    }

    @Operation
    @Override
    public Double substract(Double a, Double b){
        return new Double(a.getValue() - b.getValue());
    }

    @Operation
    @Override
    public Double substract(Double a, Integer b){
        return new Double(a.getValue() - b.getValue());
    }

    @Operation
    @Override
    public Double substract(Integer a, Double b){
        return new Double(a.getValue() - b.getValue());
    }

    @Operation
    @Override
    public Integer substract(Integer a, Integer b){
        return new Integer(a.getValue() - b.getValue());
    }

    @Operation
    @Override
    public Double multiply(Double a, Double b){
        return new Double(a.getValue() * b.getValue());
    }

    @Operation
    @Override
    public Double multiply(Double a, Integer b){
        return new Double(a.getValue() * b.getValue());
    }

    @Operation
    @Override
    public Double multiply(Integer a, Double b){
        return new Double(a.getValue() * b.getValue());
    }

    @Operation
    @Override
    public Integer multiply(Integer a, Integer b){
        return new Integer(a.getValue() * b.getValue());
    }

    @Operation
    @Override
    public Double divide(Double a, Double b){
        return new Double(a.getValue() / b.getValue());
    }

    @Operation
    @Override
    public Double divide(Double a, Integer b){
        return new Double(a.getValue() / b.getValue());
    }

    @Operation
    @Override
    public Double divide(Integer a, Double b){
        return new Double(a.getValue() / b.getValue());
    }

    @Operation
    @Override
    public Integer divide(Integer a, Integer b){
        return new Integer(a.getValue() / b.getValue());
    }

    @Override
    public HashMap getMap(){
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
