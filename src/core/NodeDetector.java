package core;

import nodes.operations.BinaryOperation;

public class NodeDetector {

    private boolean nodeDetected;
    private String text;
    private Class<BinaryOperation> nodeType;
    private Class<? extends Operator> nodeOperator;

    public NodeDetector(){
        this.nodeDetected = false;
        this.text = "";
    }

    public boolean isNodeDetected(){
        return nodeDetected;
    }

    public void addChar(char ch){
        text += ch;
        nodeDetected = checkNode();
    }

    public void addText(String text){
        this.text += text;
        nodeDetected = checkNode();
    }

    private boolean checkNode(){
        if (text.length() == 1) return checkOneCharNodes();
        return false;
    }

    private boolean checkOneCharNodes(){
        switch (text) {
            case "+":
                nodeType = BinaryOperation.class;
                nodeOperator = Operator.ADD.getClass();
                break;
            case "-":
                nodeType = BinaryOperation.class;
                nodeOperator = Operator.SUBSTRACT.getClass();
                break;
            case "*":
                nodeType = BinaryOperation.class;
                nodeOperator = Operator.MULTIPLY.getClass();
                break;
            case "/":
                nodeType = BinaryOperation.class;
                nodeOperator = Operator.DIVIDE.getClass();
                break;
        }
        return (nodeType != null) ? true : false;
    }

    public String getText(){
        return text;
    }

    public Class<BinaryOperation> getNodeType(){
        return nodeType;
    }

    public Class<? extends Operator> getNodeOperator(){
        return nodeOperator;
    }
}
