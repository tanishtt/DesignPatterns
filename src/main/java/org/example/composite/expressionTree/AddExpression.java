package org.example.composite.expressionTree;

public class AddExpression extends BinaryExpression{

    protected AddExpression(Expression left, Expression right) {
        super(left, right);
    }

    @Override
    public double evaluate() {
        return left.evaluate() + right.evaluate();
    }

    @Override
    public String print() {
        return "("+left.print()+" + "+right.print()+")";
    }
}
