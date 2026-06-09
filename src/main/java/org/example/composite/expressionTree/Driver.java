package org.example.composite.expressionTree;

import org.example.composite.expressionTree.leaf.NumberExpression;
import org.example.composite.expressionTree.leaf.VariableExpression;
import org.example.composite.expressionTree.unary.NegateExpression;
import org.example.composite.expressionTree.unary.PostDecrementExpression;

import java.util.Map;

public class Driver {
    public static void main(String[] args) {
        Expression expression =
                new DivideExpression(

                        new MultiplyExpression(

                                new AddExpression(
                                        new NumberExpression(10),
                                        new NumberExpression(20)
                                ),

                                new SubtractExpression(
                                        new NumberExpression(30),
                                        new NumberExpression(5)
                                )
                        ),

                        new NumberExpression(5)
                );
        System.out.println(expression.print()+" : "+expression.evaluate());

        Expression exp =
                new MaxExpression(
                        new NumberExpression(10),
                        new NumberExpression(20)
                );

        System.out.println(exp.print()+" : "+exp.evaluate());

        Expression exp2 =
                new NegateExpression(
                        new NumberExpression(10)
                );

        System.out.println(exp2.print()+" : "+exp2.evaluate());

        Expression exp3 =
                new PostDecrementExpression(
                        new NumberExpression(10)
                );

        System.out.println(exp3.print()+" : "+exp3.evaluate());

        Map<String, Double> variables = Map.of(
                "x", 10.0,
                "y", 20.0,
                "z", 5.0
        );

        Expression exp4 =
                new MultiplyExpression(

                        new AddExpression(
                                new VariableExpression("x", variables),
                                new VariableExpression("y", variables)
                        ),

                        new VariableExpression("z", variables)
                );

        System.out.println(exp4.print()+" : "+exp4.evaluate());

    }
}
