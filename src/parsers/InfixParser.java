package parsers;

import core.Node;
import core.Operator;
import core.OperatorList;
import core.Parser;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;
import nodes.operations.BinaryOperation;

public class InfixParser implements Parser {

    private OperatorList operators;
    private String infixInput;
    private Queue<Node> queue;
    private Stack<Operator> stack;
    private int index;

    public InfixParser(String input) {
        this.infixInput = input;
        this.index = 0;
        this.queue = new ArrayDeque<>();
        this.stack = new Stack<>();
    }

    public OperatorList getOperators() {
        return operators;
    }

    public void setOperators(OperatorList operators) {
        this.operators = operators;
    }

    @Override
    public Node parse() {
        while (index < infixInput.length()) {
            String token = readToken();
            if (isNumber(token))
                addNumberToQueue(token);
            else if (isOperator(token))
                parseOperator(token);
        }
        while (!stack.isEmpty())
            queue.add(getNode(stack.pop()));
        return null;
    }

    private String readToken() {
        String token = Character.toString(infixInput.charAt(index));
        if (!isOperator(token))
            while (index + 1 < infixInput.length() && !isOperator(infixInput.charAt(index + 1)))
                token += infixInput.charAt(++index);
        index++;
        return token;
    }

    private boolean isNumber(String number) {
        try {
            return Integer.valueOf(number) != null;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private boolean isNumber(Character character) {
        return isNumber(character.toString());
    }

    private boolean isOperator(String token) {
        return operators.hasOperator(token);
    }

    private boolean isOperator(Character token) {
        return isOperator(token.toString());
    }

    private void addNumberToQueue(String token) {
        queue.add(new nodes.types.Integer(Integer.valueOf(token)));
    }

    private Operator getOperator(String token) {
        return operators.getOperatorForSymbol(token);
    }

    private Node getNode(Operator popedOperator) {
        return new BinaryOperation();
    }

    private void parseOperator(String token) {
        Operator operator = getOperator(token);
        if (!stack.isEmpty())
            while (stack.peek().getPrecedence() >= operator.getPrecedence())
                queue.add(getNode(stack.pop()));
        stack.push(operator);
    }
}
