package com.zig.ooapsecond.fourteenthlesson;

public class Vector<T> extends SumService {
    private int size;
    private T[] arr;

    public Vector(int length){
        this.arr = (T[]) new Object[length];
    }

    public Vector<T> sum(Vector<? extends T> addedValue) {
        if (addedValue.size != this.size)
            return null;

        Vector<T> vectorSum = new Vector<>(addedValue.arr.length);

        for (int i = 0; i < arr.length; i++) {
            if (addedValue.arr[i].getClass().isInstance(this)) {
                vectorSum.add((T) ((Vector<T>) arr[i]).sum(((Vector<T>) addedValue.arr[i])));
            } else {
            vectorSum.add((T) sum(this.arr[i], addedValue.arr[i]));
            }
        }
        return vectorSum;
    }

    public void add(T value) {
        if (arr.length != size) {
            arr[size] = value;
            size++;
        }
    }

    public T[] getArr(){
        return arr;
    }
}