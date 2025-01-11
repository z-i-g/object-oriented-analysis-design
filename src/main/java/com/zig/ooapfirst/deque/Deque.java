package com.zig.ooapfirst.deque;

public class Deque<T> extends ParentQueue<T> {
    private int removeTailStatus;
    private int getTailStatus;

    public final static int REMOVE_TAIL_OK = 1;
    public final static int REMOVE_TAIL_ERR = 2;

    public final static int GET_TAIL_OK = 1;
    public final static int GET_TAIL_ERR = 2;


    // конструктор
    // создана новая пустая двустронняя очередь
    public Deque() {
    }

    // команды
    // постусловие: в голову очереди добавлен элемент
    public void addFront(T item) {
        innerStorage.addFirst(item);
    }

    // предусловие: очередь не пуста
    // постусловие: из хвоста очереди удален элмент
    public void removeTail() {
        if (innerStorage.isEmpty()) {
            removeTailStatus = REMOVE_TAIL_ERR;
            return;
        }
        innerStorage.removeLast();
        removeTailStatus = REMOVE_TAIL_OK;
    }


    // запросы:
    // очередь не пуста
    public T getTail() {
        if (innerStorage.isEmpty()) {
            getTailStatus = GET_TAIL_ERR;
            return null;
        }
        getTailStatus = GET_TAIL_OK;
        return innerStorage.getLast();
    }

    // запросы статусов команд
    // успешно; очередь пуста
    public int getRemoveTailStatus() {
        return removeTailStatus;
    }

    // успешно; очередь пуста
    public int getGetTailStatus() {
        return getTailStatus;
    }
}