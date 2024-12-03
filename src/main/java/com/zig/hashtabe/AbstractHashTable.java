package com.zig.hashtabe;

public abstract class AbstractHashTable<T> {
    public final static int PUT_OK = 1; // успешно
    public final static int PUT_ERR = 2; // хэш-таблица заполнена
    public final static int PUT_ERR_COLLISION = 3; // ошибка механизма разрешения коллизий

    public final static int REMOVE_OK = 1; // успешно
    public final static int REMOVE_ERR = 2; // в хэш-таблице нет value

    // констуктор
    // создана пустая хэш-таблица размером size
    public AbstractHashTable(int size) {}

    // команды
    // предусловие: в хэш-таблице есть своободное место
    // постуловие: в хэш-таблицу добавлен value
    public abstract void put(T value);

    // предусловие: хэш-таблица содержит value
    // постусловие: из-хэштаблицы удалено value
    public abstract void remove(T value);

    // запросы
    // проверка наличия value
    public abstract boolean get(T value);

    // дополнительные запросы
    // возвращает количество элементов в хэш-таблице
    public abstract int size();

    // статус команды put
    public abstract int getPutStatus(); // успешно; хэш-таблица заполнена

    // статус команды remove
    public abstract int getRemoveStatus(); // успешно; в хэш-таблице нет value
}