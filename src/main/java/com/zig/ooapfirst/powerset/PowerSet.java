package com.zig.ooapfirst.powerset;

import java.util.Hashtable;

public class PowerSet<T> extends ParentHashTable<T> {
    Hashtable<String, T> hashTable;

    private int intersectionStatus;
    private int unionStatus;
    private int differenceStatus;
    private int isSubsetStatus;

    public PowerSet(int sz, int stp) {
        super(sz, stp);
        hashTable = new Hashtable<>(sz);
    }

    // запросы
    public PowerSet<T> intersection(PowerSet<T> set2)
    {
        PowerSet<T> result = new PowerSet(size, step);
        for (T str: set2.hashTable.values()) {
            if (this.hashTable.contains(str))
                result.put(str);
        }
        return result;
        // пересечение текущего множества и set2
    }

    public PowerSet<T> union(PowerSet<T> set2)
    {
        PowerSet<T> result = new PowerSet(size, step);
        if (set2.size() == 0 && this.size() == 0)
            return result;

        if (set2.size() == 0) {
            for (T str: this.hashTable.values()) {
                result.put(str);
            }
            return result;
        }

        if (this.size() == 0) {
            for (T str: set2.hashTable.values()) {
                result.put(str);
            }
            return result;
        }

        for (T str: set2.hashTable.values()) {
            result.put(str);
        }
        for (T str: this.hashTable.values()) {
            result.put(str);
        }
        return result;
        // объединение текущего множества и set2
    }

    public PowerSet<T> difference(PowerSet<T> set2)
    {
        PowerSet<T> result = new PowerSet(size, step);
        if (set2.size() == 0 && this.size() == 0)
            return result;

        if (set2.size() == 0) {
            for (T str: this.hashTable.values()) {
                result.put(str);
            }
            return result;
        }

        if (this.size() == 0) {
            return result;
        }
        for (T str: this.hashTable.values()) {
            if (!set2.hashTable.contains(str))
                result.put(str);
        }
        return result;
        // разница текущего множества и set2
    }

    public boolean isSubset(PowerSet<T> set2)
    {
        if (set2.size() == 0) {
            return true;
        }

        if (this.size() == 0) {
            return false;
        }

        if (set2.size() > this.size())
            return false;

        for (T str: set2.hashTable.values()) {
            if (!this.hashTable.contains(str))
                return false;
        }
        return true;
        // возвращает true, если set2 есть
        // подмножество текущего множества,
        // иначе false
    }
}