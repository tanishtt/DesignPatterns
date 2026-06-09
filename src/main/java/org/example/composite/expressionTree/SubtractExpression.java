package org.example.composite.expressionTree;

public class SubtractExpression extends BinaryExpression{
    protected SubtractExpression(Expression left, Expression right) {
        super(left, right);
    }

    @Override
    public double evaluate() {
        return left.evaluate() - right.evaluate();
    }

    @Override
    public String print() {
        return "("+left.print()+" - "+right.print()+")";
    }
}
