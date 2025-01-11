package com.zig.ooapfirst.deque;

import java.util.LinkedList;

public abstract class ParentQueue<T> {
    protected final LinkedList<T> innerStorage;

    private int removeFrontStatus;
    private int getStatus;

    public final static int REMOVE_FRONT_OK = 1;
    public final static int REMOVE_FRONT_ERR = 2;

    public final static int GET_OK = 1;
    public final static int GET_ERR = 2;

    // конструктор, создана новая пустая очередь
    public ParentQueue()
    {
        innerStorage = new LinkedList<>();
    }

    // команды
    // постусловие: в хвост очереди добавлен элемент
    public void addTail(T item)
    {
        innerStorage.addLast(item);
    }

    // предусловие: очередь не пуста
    // постусловие: из головы очереди удален элемент
    public void removeFront()
    {
        if (innerStorage.isEmpty()) {
            removeFrontStatus = REMOVE_FRONT_ERR;
        }
        innerStorage.remove(0);
        removeFrontStatus = REMOVE_FRONT_OK;
    }

    // запросы
    // предусловие: очередь не пуста
    public T get() {
        if (innerStorage.isEmpty()) {
            getStatus = GET_ERR;
            return null;
        }
        getStatus = GET_OK;
        return innerStorage.get(0);
    }

    // дополнительные запросы
    // возвращает текущий размер очереди
    public int size()
    {
        return innerStorage.size();
    }

    // статусы команд
    // успешно; очередь пуста
    public int getRemoveFrontStatus() {
        return removeFrontStatus;
    }

    // успешно; очередь пуста
    public int getGetStatus() {
        return getStatus;
    }
}