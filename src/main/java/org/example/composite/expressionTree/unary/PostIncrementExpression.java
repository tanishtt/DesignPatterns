package org.example.composite.expressionTree.unary;

import org.example.composite.expressionTree.Expression;

public class PostIncrementExpression extends UnaryExpression{
    public PostIncrementExpression(Expression expression) {
        super(expression);
    }

    @Override
    public double evaluate() {
        double temp= expression.evaluate();
        temp++;
        return temp;
    }

    @Override
    public String print() {
        return "("+expression.print()+")++";
    }
}
