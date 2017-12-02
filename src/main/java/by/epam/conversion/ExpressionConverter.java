package by.epam.conversion;

import java.util.ArrayDeque;

public class ExpressionConverter {
    private static final String NUMBER_REGEX = "^\\d+\\.?\\d*$";
    private static final String STACK_CAP = "";
    private static final String PLUS = "+";
    private static final String MINUS = "-";
    private static final String DIVIDE = "/";
    private static final String MULTIPLY = "*";
    private static final String LEFT_SCOPE = "(";
    private static final String RIGHT_SCOPE = ")";
    private static final String SPACE = " ";
    private static final String END = "$";
    private static final String DOT_REGEX = " \\. ";
    private static final String DOT = ".";
    private static final String START_MINUS = "  -";
    private static final String START_ZERO_MINUS = "0 -";
    private static final String SCOPE_MINUS = "\\( -";
    private static final String SCOPE_ZERO_MINUS = "( 0 -";

    private ExpressionConverter() {
    }

    public static String convertToInfix(String expr) {
        StringBuilder result = new StringBuilder().append(SPACE).append(SPACE);
        char[] chars = expr.toCharArray();
        int number = 0;
        boolean previousWasNumber = false;
        boolean prevAlpha = false;
        for (Character character : chars) {
            if (Character.isDigit(character)) {
                if (previousWasNumber) {
                    number = number * 10 + Character.getNumericValue(character);
                } else {
                    number = Character.getNumericValue(character);
                    previousWasNumber = true;
                }
            } else {
                if (previousWasNumber) {
                    result.append(String.valueOf(number)).append(SPACE);
                    previousWasNumber = false;
                }
                if (Character.isLetter(character)) {
                    result.append(String.valueOf(character));
                    prevAlpha = true;
                } else {
                    if (prevAlpha) {
                        result.append(SPACE);
                        prevAlpha = false;
                    }
                    result.append(String.valueOf(character)).append(SPACE);
                }
            }
        }
        if (previousWasNumber) {
            result.append(String.valueOf(number));
        }
        String infix = result.toString().replaceAll(START_MINUS, START_ZERO_MINUS).replaceAll(SCOPE_MINUS, SCOPE_ZERO_MINUS).replaceAll(DOT_REGEX, DOT).trim().concat(SPACE).concat(END);
        return infix;
    }

    public static String convertToPostfix(String expression) {
        expression = convertToInfix(expression);
        String[] operands = expression.split(SPACE);
        ArrayDeque<String> stack = new ArrayDeque<>();
        StringBuilder result = new StringBuilder();
        String stackTop;
        boolean converted = false;
        boolean failed = false;
        int i = 0;
        while (!converted) {
            if (!stack.isEmpty()) {
                stackTop = stack.peek();
            } else {
                stackTop = STACK_CAP;
            }
            if (operands[i].matches(NUMBER_REGEX)) {
                result.append(operands[i]).append(" ");
                i++;
            }
            switch (operands[i]) {
                case PLUS:
                case MINUS:
                    if (STACK_CAP.equals(stackTop) || LEFT_SCOPE.equals(stackTop)) {
                        stack.push(operands[i]);
                        i++;
                    } else if (PLUS.equals(stackTop) || MINUS.equals(stackTop) || MULTIPLY.equals(stackTop) || DIVIDE.equals(stackTop)) {
                        result.append(stack.pop()).append(SPACE);
                        stack.push(operands[i]);
                        i++;
                    } else {
                        failed = true;
                    }
                    break;
                case MULTIPLY:
                case DIVIDE:
                    if (STACK_CAP.equals(stackTop) || LEFT_SCOPE.equals(stackTop) || PLUS.equals(stackTop) || MINUS.equals(stackTop)) {
                        stack.push(operands[i]);
                        i++;
                    } else if (MULTIPLY.equals(stackTop) || DIVIDE.equals(stackTop)) {
                        result.append(stack.pop()).append(SPACE);
                        stack.push(operands[i]);
                        i++;
                    } else {
                        failed = true;
                    }
                    break;
                case LEFT_SCOPE:
                    stack.push(operands[i]);
                    i++;
                    break;
                case RIGHT_SCOPE:
                    while (!stack.peek().equals(LEFT_SCOPE)) {
                        result.append(stack.pop()).append(SPACE);
                    }
                    stack.pop();
                    i++;
                    break;
                case END:
                    if (STACK_CAP.equals(stackTop)) {
                        converted = true;
                    } else if (PLUS.equals(stackTop) || MINUS.equals(stackTop) || MULTIPLY.equals(stackTop) || DIVIDE.equals(stackTop)) {
                        result.append(stack.pop()).append(SPACE);
                    } else {
                        failed = true;
                    }
                    break;
                default:
                    failed = true;
            }
            if (failed) {
                break;
            }
        }
        if (converted) {
            return result.toString().trim();
        } else {
            return String.valueOf(1);
        }
    }
}