package org.example.composite.expressionTree;

public class MinExpression extends BinaryExpression{
    protected MinExpression(Expression left, Expression right) {
        super(left, right);
    }

    @Override
    public double evaluate() {
        return Math.min(left.evaluate(), right.evaluate());
    }

    @Override
    public String print() {
        return "MIN("+left.print()+","+right.print()+")";
    }
}
