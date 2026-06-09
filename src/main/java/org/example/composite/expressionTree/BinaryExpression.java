package org.example.composite.expressionTree;

public abstract class BinaryExpression implements Expression{
    protected final Expression left;
    protected final Expression right;

    protected BinaryExpression(Expression left, Expression right) {
        this.left = left;
        this.right = right;
    }
}
