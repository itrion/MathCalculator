package nodes.operations;

import core.CalculatorFinder;
import core.Node;
import core.Operator;
import core.Type;
import nodes.Constant;

public class BinaryOperation implements Node {

    private Node leftChild;
    private Node rightChild;
    private Operator operator;

    @Override
    public Type evaluate() {
        Type left = leftChild.evaluate();
        Type right = rightChild.evaluate();
        return CalculatorFinder.solve(operator, new Type[]{left, right});
    }

    public Operator getOperator() {
        return operator;
    }

    public void setOperator(Operator operator) {
        this.operator = operator;
    }

    public Node getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(Node leftChild) {
        this.leftChild = leftChild;
    }

    public Node getRightChild() {
        return rightChild;
    }

    public void setRightChild(Node rightChild) {
        this.rightChild = rightChild;
    }

    @Override
    public int getPrecedence() {
        return operator.getPrecedence();
    }

    @Override
    public String toString() {
        return childToString(leftChild) + operator.getSymbol() + childToString(rightChild);
    }

    private boolean needsBrackets(Node child) {
        return (!(child instanceof Constant) && child.getPrecedence()<getPrecedence());
    }

    private String childToString(Node child) {
        StringBuilder stringBuilder = new StringBuilder(child.toString());
        if (!needsBrackets(child)) return stringBuilder.toString();
        stringBuilder.insert(0, "(");
        stringBuilder.append(")");
        return stringBuilder.toString();

    }
}
