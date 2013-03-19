package parsers;

import core.Node;
import core.Operator;
import core.OperatorList;
import core.Parser;
import java.util.Stack;
import nodes.operations.BinaryOperation;

public class InfixParser implements Parser {

    private OperatorList operators;
    private String infixInput;
    private Stack<Node> outStack;
    private Stack<Operator> stack;
    private int index;

    public InfixParser(String input) {
        this.infixInput = input;
        this.index = 0;
        this.outStack = new Stack<>();
        this.stack = new Stack<>();
    }

    @Override
    public Node parse() {
        while (index < infixInput.length()) {
            String token = readToken();
            if (isNumber(token))
                addNumberToQueue(toNumber(token));
            else if (isOperator(token))
                parseOperator(token);
        }
        while (!stack.isEmpty())
            outStack.add(getNode(stack.pop()));
        return buildTree();
    }

    private String readToken() {
        String token = Character.toString(infixInput.charAt(index));
        if (!isOperator(token))
            while (keepReadingToken())
                token += infixInput.charAt(++index);
        index++;
        return token;
    }

    public OperatorList getOperators() {
        return operators;
    }

    public void setOperators(OperatorList operators) {
        this.operators = operators;
    }

    private boolean isNumber(String token) {
        return checkInteger(token) || checkDouble(token);
    }

    private boolean isOperator(String token) {
        return operators.hasOperator(token);
    }

    private boolean isOperator(Character token) {
        return isOperator(token.toString());
    }

    private void addNumberToQueue(Node number) {
        outStack.add(number);
    }

    private Operator getOperator(String token) {
        return operators.getOperatorForSymbol(token);
    }

    private Node getNode(Operator popedOperator) {
        BinaryOperation operation = new BinaryOperation();
        operation.setOperator(popedOperator);
        return operation;
    }

    private void parseOperator(String token) {
        Operator operator = getOperator(token);
        if (!stack.isEmpty())
            while (stack.peek().getPrecedence() >= operator.getPrecedence()) {
                outStack.add(getNode(stack.pop()));
                if (stack.isEmpty()) break;
            }
        stack.push(operator);
    }

    private Node buildTree() {
        if (!outStack.isEmpty()) {
            Node node = outStack.pop();
            if (node instanceof BinaryOperation) {
                ((BinaryOperation) node).setRightChild(buildTree());
                ((BinaryOperation) node).setLeftChild(buildTree());
            }
            return node;
        }
        else
            return null;
    }

    private boolean keepReadingToken() {
        if (isEndReached()) return false;
        return !isOperator(infixInput.charAt(index + 1)) || isPoint(infixInput.charAt(index + 1));
    }

    private boolean isEndReached() {
        return index + 1 == infixInput.length();
    }

    private boolean isPoint(char character) {
        return '.' == character;
    }

    private boolean checkInteger(String token) {
        try {
            return Integer.valueOf(token) != null;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private boolean checkDouble(String token) {
       return token.contains(".");
    }

    private Node toNumber(String token) {
        if (checkDouble(token)) return new nodes.types.Double(Double.valueOf(token));
        else return new nodes.types.Integer(Integer.valueOf(token));
    }
}
