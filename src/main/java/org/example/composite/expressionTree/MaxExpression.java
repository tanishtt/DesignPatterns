package org.example.composite.expressionTree;

public class MaxExpression extends BinaryExpression{
    protected MaxExpression(Expression left, Expression right) {
        super(left, right);
    }

    @Override
    public double evaluate() {
        return Math.max(left.evaluate(), right.evaluate());
    }

    @Override
    public String print() {
        return "MAX("+left.print()+","+right.print()+")";
    }
}
