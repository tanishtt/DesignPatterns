package org.example.composite.expressionTree.unary;

import org.example.composite.expressionTree.Expression;

public abstract class UnaryExpression implements Expression {
    protected final Expression expression;
    public UnaryExpression(Expression expression){
        this.expression=expression;
    }
}
