package org.example.composite.expressionTree;

public class DivideExpression extends BinaryExpression {
    protected DivideExpression(Expression left, Expression right) {
        super(left, right);
    }

    @Override
    public double evaluate() {
        if(right.evaluate() == 0){
            throw new ArithmeticException("divide by zero.");
        }
        return left.evaluate() / right.evaluate();
    }

    @Override
    public String print() {
        return "("+left.print()+" / "+right.print()+")";
    }
}
