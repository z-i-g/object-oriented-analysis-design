package com.zig.ooapfirst.dynarray;

public abstract class AbstractDynArray<T> {
    public static final int INSERT_OK = 1;
    public static final int INSERT_ERR = 2;

    public static final int REMOVE_OK = 1;
    public static final int REMOVE_ERR = 2;

    public static final int GET_ITEM_OK = 1;
    public static final int GET_ITEM_ERR = 2;

    public static final int NIL_STATUS = 0;

    // конструктор
    // постусловие: создан новый пустой динамический массив емкостью 16
    public AbstractDynArray(Class clz) {
    }

    // команды
    // постусловие: изменился размер массива с копированием текущих значений
    public abstract void makeArray(int new_capacity);

    // постусловие: в конец массива добавлен элмент
    public abstract void append(T itm);

    // предусловие: index внаходится в допустимых пределах
    // постусловие: в массив добавлен элмент в index-позицию
    public abstract void insert(T itm, int index);

    // предусловие: index внаходится в допустимых пределах
    // постусловие: удален элемент из index-позиции
    public abstract void remove(int index);

    // постусловие: удалены все элементы в массиве
    public abstract void clear();

    // запросы
    // предусловие: index находится в допустимых пределах
    public abstract T getItem(int index);

    // дополнительные запросы
    // возвращает количество элементов в массиве
    public abstract int size();
}