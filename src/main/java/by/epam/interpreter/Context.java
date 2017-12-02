package by.epam.interpreter;

import java.util.ArrayDeque;

public class Context {
    private ArrayDeque<Double> contextValues = new ArrayDeque<>();

    public Double popValue() {
        return contextValues.pop();
    }

    public void pushValue(Double value) {
        contextValues.push(value);
    }

    public int size() {
        return contextValues.size();
    }

    public boolean isEmpty() {
        return contextValues.isEmpty();
    }
}