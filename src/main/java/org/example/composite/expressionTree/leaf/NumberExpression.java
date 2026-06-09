package org.example.composite.expressionTree.leaf;

import org.example.composite.expressionTree.Expression;

public class NumberExpression implements Expression {
    private final double value;

    public NumberExpression(double value) {
        this.value = value;
    }

    @Override
    public double evaluate() {
        return value;
    }

    @Override
    public String print() {
        return String.valueOf(value);
    }
}
