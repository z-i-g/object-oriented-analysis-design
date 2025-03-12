package com.zig.ooapsecond.fourteenthlesson;

import com.zig.ooapsecond.ninthlesson.Any;

public class SumService<T> extends Any {
    public T sum(T firstValue, T secondValue){
        T sum = null;
        if(firstValue instanceof String)
            sum = sumString(firstValue, secondValue);

        if(firstValue instanceof Integer)
            sum = sumInteger(firstValue, secondValue);

        if (firstValue instanceof Double)
            sum = sumDouble(firstValue, secondValue);

        return sum;
    }

    private T sumString(T firstValue, T secondValue) {
        String castFirstFalue = String.valueOf(firstValue.getClass());
        return (T) (castFirstFalue + secondValue);
    }

    private T sumInteger(T firstValue, T secondValue) {
        Integer sum = ((Integer) (firstValue)) + ((Integer) secondValue);
        return (T) sum;
    }

    private T sumDouble(T firstValue, T secondValue){
        Double doubleFirstValue = (Double) firstValue;
        Double doubleSecondValue = (Double) secondValue;
        return (T) (Double)(doubleFirstValue + doubleSecondValue);
    }
}