package com.zig.ooapfirst.dynarray;

import java.lang.reflect.Array;

public class DynArray<T> extends AbstractDynArray<T> {
    public T [] array;
    public int count;
    public int capacity;
    Class clazz;

    private int insertStatus;
    private int removeStatus;
    private int getItemStatus;

    public DynArray(Class clz) {
        super(clz);
        clazz = clz;
        clear();
    }

    // команды
    public void makeArray(int new_capacity) {
        T[] tempArray = array;
        array = (T[]) Array.newInstance(this.clazz, new_capacity);
        if (count > 0) {
            System.arraycopy(tempArray, 0, array, 0, count);
        }
        capacity = new_capacity;
    }

    public void append(T itm) {
        if (capacity == count) {
            makeArray(capacity * 2);
        }
        array[count] = itm;
        count++;
    }

    public void insert(T itm, int index) {
        if (index > count || index < 0) {
            insertStatus = INSERT_ERR;
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + count);
        }
        if (capacity == count) {
            makeArray(capacity * 2);
        }
        if (count != index) {
            for (int i = index; i <= count; i++) {
                T temp = array[i];
                array[i] = itm;
                itm = temp;
            }
        } else {
            array[index] = itm;
        }
        count++;
        insertStatus = INSERT_OK;
    }

    public void remove(int index) {
        if (index < 0 || index >= count) {
            removeStatus = REMOVE_ERR;
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + count);
        }
        if (index == count - 1) {
            array[index] = null;
        } else {
            for (int i = index; i <= count; i++) {
                array[i] = array[i + 1];
            }
        }
        count--;
        if ((double)capacity/count > 2) {
            int newCapacity = (int) (capacity/1.5);
            makeArray(Math.max(newCapacity, 16));
        }
        removeStatus = REMOVE_OK;
    }

    public void clear() {
        count = 0;
        makeArray(16);
        insertStatus = NIL_STATUS;
        removeStatus = NIL_STATUS;
        getItemStatus = NIL_STATUS;
    }

    // запросы
    public T getItem(int index) {
        if (index > count || index < 0) {
            getItemStatus = GET_ITEM_ERR;
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + count);
        }
        getItemStatus = GET_ITEM_OK;
        return array[index];
    }

    // дополнительные запросы
    public int size() {
        return array.length;
    }
}