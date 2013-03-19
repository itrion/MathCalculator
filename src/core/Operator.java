package core;

public class Operator {
    public static final Operator ADD = new Operator("add", "+", 2);
    public static final Operator SUBSTRACT = new Operator("substract", "-", 2);
    public static final Operator DIVIDE = new Operator("divide", "/", 3);
    public static final Operator MULTIPLY = new Operator("multiply", "*", 3);
    
    private String name;
    private String symbol;
    private int precedence;

    public Operator(String name, String symbol, int precedence) {
        this.name = name;
        this.symbol = symbol;
        this.precedence = precedence;
    }
    
    public String getName(){
        return name;
    }

    public String getSymbol(){
        return symbol;
    }

    public int getPrecedence() {
        return precedence;
    }
}
