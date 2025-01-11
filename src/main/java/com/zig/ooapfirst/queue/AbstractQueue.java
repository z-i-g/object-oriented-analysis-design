package com.zig.ooapfirst.queue;

public abstract class AbstractQueue<T> {
    public final static int DEQUEUE_OK = 1;
    public final static int DEQUEUE_ERR = 2;

    public final static int PEEK_OK = 1;
    public final static int PEEK_ERR = 2;

    // констуктор
    // постуловие: создана новая пустая очередь
    public AbstractQueue() {
    }

    // команды
    // постуловие: добавлен элемент item в конец оцереди
    public abstract void enqueue(T item);

    // пердусловие: очередь не пуста
    // постуловие: элмент удален из головы очереди
    public abstract void dequeue();

    // запросы
    // предусловие: очередь не пуста
    public abstract T peek();

    // дополнительные запросы
    // возвращает текущий размер очереди
    public abstract int size();

    // запросы статусов
    public abstract int getDequeueStatus(); // успешно; очередь пуста
    public abstract int getPeekStatus(); // успешно; очередь пуста
}