package com.zig.powerset;

import com.zig.hashtabe.AbstractHashTable;

public class ParentHashTable<T> extends AbstractHashTable<T> {
    public int size;
    public int step;
    public T [] slots;

    private int putStatus;
    private int removeStatus;

    // конструктор
    public ParentHashTable(int sz, int stp) {
        super(sz);
        size = sz;
        step = stp;
        slots = (T[]) new Object[size];
        for(int i=0; i<size; i++) slots[i] = null;
    }

    private int hashFun(T value) {
        return Math.abs(value.hashCode() % size);
        // всегда возвращает корректный индекс слота
    }

    private int seekSlot(T value)
    {
        int slotIndex = hashFun(value);
        if (slots[slotIndex] == null)
            return slotIndex;

        for (int i = 0; i < size; i++) {
            if (slotIndex + step >= size) {
                slotIndex = size - (slotIndex + step);
                slotIndex = Math.abs(slotIndex);
            } else {
                slotIndex = slotIndex + step;
            }
            if (slots[slotIndex] == null)
                return slotIndex;
        }
        return -1;
    }


    // команды
    // предусловие: в хэш-таблице есть своободное место
    // постуловие: в хэш-таблицу добавлен value
    public void put(T value) {
        int slotIndex = seekSlot(value);
        if (seekSlot(value) == -1 && size > slots.length) {
            putStatus = PUT_ERR_COLLISION;
            return;
        }
        if (seekSlot(value) == -1) {
            putStatus = PUT_ERR;
            return;
        }
        putStatus = PUT_OK;
        slots[slotIndex] = value;
    }

    // предусловие: хэш-таблица содержит value
    // постусловие: из-хэштаблицы удалено value
    public void remove(T value) {
        int index = seekSlot(value);
        if (index == -1) {
            removeStatus = REMOVE_ERR;
            return;
        }
        removeStatus = REMOVE_OK;
        slots[index] = null;
    }

    // запросы
    // проверка наличия value
    public boolean get(T value) {
        int slotIndex = seekSlot(value);
        return slots[slotIndex] == value;
    }

    // дополнительные запросы
    // возвращает количество элементов в хэш-таблице
    public int size() {
        return slots.length;
    }

    // статус команды put
    public int getPutStatus() {
        return putStatus;
    }

    // статус команды remove
    public int getRemoveStatus() {
        return removeStatus;
    }
}