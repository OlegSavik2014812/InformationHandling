package by.epam.interpreter.impl;

import by.epam.interpreter.AbstractMathExpression;
import by.epam.interpreter.Context;

public class TerminalExpressionPlus implements AbstractMathExpression {
    @Override
    public void interpret(Context c) {
        c.pushValue(c.popValue() + c.popValue());
    }
}
