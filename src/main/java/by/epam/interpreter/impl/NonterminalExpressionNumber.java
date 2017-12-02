package by.epam.interpreter.impl;


import by.epam.interpreter.AbstractMathExpression;
import by.epam.interpreter.Context;

public class NonterminalExpressionNumber implements AbstractMathExpression {
    private double number;

    public NonterminalExpressionNumber(double number) {
        this.number = number;
    }

    @Override
    public void interpret(Context c) {
        c.pushValue(number);
    }
}
