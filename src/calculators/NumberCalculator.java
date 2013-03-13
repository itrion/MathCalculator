package calculators;

import nodes.types.Double;
import nodes.types.Integer;

public interface NumberCalculator extends Calculator{
    public Double add(Double a, Double b);
    public Double add(Double a, Integer b);
    public Double add(Integer a, Double b);
    public Integer add(Integer a, Integer b);
    
    public Double substract(Double a, Double b);
    public Double substract(Double a, Integer b);
    public Double substract(Integer a, Double b);
    public Integer substract(Integer a, Integer b);
    
    public Double multiply(Double a, Double b);
    public Double multiply(Double a, Integer b);
    public Double multiply(Integer a, Double b);
    public Integer multiply(Integer a, Integer b);
    
    public Double divide(Double a, Double b);
    public Double divide(Double a, Integer b);
    public Double divide(Integer a, Double b);
    public Integer divide(Integer a, Integer b);
}
