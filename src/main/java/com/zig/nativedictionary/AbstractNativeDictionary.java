package com.zig.nativedictionary;

public abstract class AbstractNativeDictionary<T> {
    public final static int GET_OK = 1; // успешно
    public final static int GET_ERR = 2; // в словаре нет элемента по ключу key

    public final static int REMOVE_OK = 1; // успешно
    public final static int REMOVE_ERR = 2; // в словаре нет значения по ключу

    // конструктор
    // создается пустой словарь с размером size
    public AbstractNativeDictionary(int size) {
    }

    // команды
    // постусловие: в словарь добавлен/обновлен элемент по ключу key
    public abstract void put(String key, T value);

    // предусловие: в словаре есть ключ key
    // постусловие: из словаря удален элемент по ключу key
    public abstract void remove(String key);

    // запросы
    // предусловие: в словаре есть ключ key
    public abstract T get(String key);

    // проверка наличия ключа key
    public abstract boolean isKey(String key);

    // возвращает количество значений в словаре
    public abstract int size();

    // запросы статусов команд
    public abstract int getRemoveStatus(); // успешно; в словаре нет ключа key
}