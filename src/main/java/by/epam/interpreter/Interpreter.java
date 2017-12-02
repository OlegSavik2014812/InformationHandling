package by.epam.interpreter;

import by.epam.interpreter.impl.*;

import java.util.ArrayList;

public class Interpreter {

    private static final String EXPRESSION_SPLIT = "\\s+";

    private ArrayList<AbstractMathExpression> listExpression;

    public Interpreter() {
        listExpression = new ArrayList<>();
    }

    private void parse(String expression) {
        for (String lexeme : expression.split(EXPRESSION_SPLIT)) {

            char temp = lexeme.charAt(0);
            switch (temp) {
                case '+': {
                    listExpression.add(new TerminalExpressionPlus());
                    break;
                }
                case '-': {
                    listExpression.add(new TerminalExpressionMinus());
                    break;
                }
                case '*': {
                    listExpression.add(new TerminalExpressionMultiply());
                    break;
                }
                case '/': {
                    listExpression.add(new TerminalExpressionDivide());
                    break;
                }
                default: {
                    listExpression.add(
                            new NonterminalExpressionNumber(Double.parseDouble(lexeme)));
                }
            }

        }
    }

    public Number calculate(String expression) {
        parse(expression);
        Context context = new Context();
        for (AbstractMathExpression mathExpression : listExpression) {
            mathExpression.interpret(context);
        }
        return context.popValue();
    }
}

