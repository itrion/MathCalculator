package nodes;

import core.CalculatorFinder;
import core.Node;
import core.Operator;
import core.Type;

public class BinaryOperation implements Node {

    private Node leftChild;
    private Node rightChild;
    private Operator operator;

    public Operator getOperator(){
        return operator;
    }

    public void setOperator(Operator operator){
        this.operator = operator;
    }

    @Override
    public Type evaluate(){
        Type left = leftChild.evaluate();
        Type right = rightChild.evaluate();
        return CalculatorFinder.getInstance().solve(operator, new Type[]{left, right});
    }

    public Node getLeftChild(){
        return leftChild;
    }

    public void setLeftChild(Node leftChild){
        this.leftChild = leftChild;
    }

    public Node getRightChild(){
        return rightChild;
    }

    public void setRightChild(Node rightChild){
        this.rightChild = rightChild;
    }
}
