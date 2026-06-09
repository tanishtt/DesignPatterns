package org.example.composite.expressionTree.unary;

import org.example.composite.expressionTree.Expression;

public class NegateExpression extends UnaryExpression{
    public NegateExpression(Expression expression) {
        super(expression);
    }

    @Override
    public double evaluate() {
        return -expression.evaluate();
    }

    @Override
    public String print() {
        return "-("+expression.print()+")";
    }
}
