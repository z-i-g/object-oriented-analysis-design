package com.zig.nativedictionary;

import java.lang.reflect.Array;

public class NativeDictionary<T> extends AbstractNativeDictionary<T> {
    private int size;
    private String [] slots;
    private T [] values;

    private int getStatus;
    private int removeStatus;

    public NativeDictionary(int sz, Class clazz) {
        super(sz);
        size = sz;
        slots = new String[size];
        values = (T[]) Array.newInstance(clazz, this.size);
    }

    public void put(String key, T value) {
        int idx = hashFun(key);
        slots[idx] = key;
        values[idx] = value;
    }

    public void remove(String key) {
        int idx = hashFun(key);
        if (slots[idx].equals(key)) {
            slots[idx] = null;
            values[idx] = null;
            removeStatus = REMOVE_OK;
            return;
        }
        removeStatus = REMOVE_ERR;

    }

    public T get(String key) {
        int idx = hashFun(key);
        if (key.equals(slots[idx])) {
            getStatus = GET_OK;
            return values[idx];
        }
        getStatus = GET_ERR;
        return null;
    }

    public boolean isKey(String key) {
        int idx = hashFun(key);
        return key.equals(slots[idx]);
        // возвращает true если ключ имеется,
        // иначе false
    }

    public int size() {
        return slots.length;
    }

    public int getRemoveStatus() {
        return removeStatus;
    }

    public int getGetStatus() {
        return getStatus;
    }

    private int hashFun(String key) {
        int intVal = 0;
        for (byte b: key.getBytes()) {
            intVal = intVal + b;
        }
        return Math.abs(intVal % size);
    }
}
