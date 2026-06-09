package org.example.composite.expressionTree;

public class MultiplyExpression extends BinaryExpression{
    protected MultiplyExpression(Expression left, Expression right) {
        super(left, right);
    }

    @Override
    public double evaluate() {
        return left.evaluate() * right.evaluate();
    }

    @Override
    public String print() {
        return "("+left.print()+" * "+right.print()+")";
    }
}
