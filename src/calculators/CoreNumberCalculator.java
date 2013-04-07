package calculators;

import annotations.Operation;
import types.Double;
import types.Integer;

public class CoreNumberCalculator extends Calculator {

    @Operation
    public Double add(Double a, Double b) {
        return new Double(a.getValue() + b.getValue());
    }

    @Operation
    public Double add(Double a, Integer b) {
        return new Double(a.getValue() + b.getValue());
    }

    @Operation
    public Double add(Integer a, Double b) {
        return new Double(a.getValue() + b.getValue());
    }

    @Operation
    public Integer add(Integer a, Integer b) {
        return new Integer(a.getValue() + b.getValue());
    }

    @Operation
    public Double substract(Double a, Double b) {
        return new Double(a.getValue() - b.getValue());
    }

    @Operation
    public Double substract(Double a, Integer b) {
        return new Double(a.getValue() - b.getValue());
    }

    @Operation
    public Double substract(Integer a, Double b) {
        return new Double(a.getValue() - b.getValue());
    }

    @Operation
    public Integer substract(Integer a, Integer b) {
        return new Integer(a.getValue() - b.getValue());
    }

    @Operation
    public Double multiply(Double a, Double b) {
        return new Double(a.getValue() * b.getValue());
    }

    @Operation
    public Double multiply(Double a, Integer b) {
        return new Double(a.getValue() * b.getValue());
    }

    @Operation
    public Double multiply(Integer a, Double b) {
        return new Double(a.getValue() * b.getValue());
    }

    @Operation
    public Integer multiply(Integer a, Integer b) {
        return new Integer(a.getValue() * b.getValue());
    }

    @Operation
    public Double divide(Double a, Double b) {
        return new Double(a.getValue() / b.getValue());
    }

    @Operation
    public Double divide(Double a, Integer b) {
        return new Double(a.getValue() / b.getValue());
    }

    @Operation
    public Double divide(Integer a, Double b) {
        return new Double(a.getValue() / b.getValue());
    }

    @Operation
    public Double divide(Integer a, Integer b) {
        return new Double(java.lang.Double.valueOf(a.getValue()) / java.lang.Double.valueOf(b.getValue()));
    }
}
