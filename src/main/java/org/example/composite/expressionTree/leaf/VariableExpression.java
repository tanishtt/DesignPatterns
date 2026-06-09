package org.example.composite.expressionTree.leaf;

import org.example.composite.expressionTree.Expression;

import java.util.Map;

public class VariableExpression implements Expression {
    private final String variableName;
    private final Map<String, Double> context;

    public VariableExpression(String variableName, Map<String, Double> context) {
        this.variableName = variableName;
        this.context = context;
    }

    @Override
    public double evaluate() {
        if(!context.containsKey(variableName)){
            throw new RuntimeException("Variable not found "+variableName);
        }
        return context.get(variableName);
    }

    @Override
    public String print() {
        return variableName;
    }
}
