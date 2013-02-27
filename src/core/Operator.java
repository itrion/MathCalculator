package core;

public class Operator {
    public static final Operator ADD = new Operator("add", "+");
    public static final Operator SUBSTRACT = new Operator("substract", "-");
    
    private String name;
    private String symbol;

    private Operator(String name, String symbol){
        this.name = name;
        this.symbol = symbol;
    }

    public String getName(){
        return name;
    }

    public String getSymbol(){
        return symbol;
    }
}
