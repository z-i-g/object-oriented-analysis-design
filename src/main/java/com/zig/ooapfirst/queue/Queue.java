package com.zig.ooapfirst.queue;

import java.util.LinkedList;
import java.util.List;

public class Queue<T> extends AbstractQueue<T> {
    private final List<T> innerStorage;

    private int dequeueStatus;
    private int peekStatus;
    public Queue() {
        super();
        innerStorage = new LinkedList<>();
    }

    // команды
    // постуловие: добавлен элемент item в конец оцереди
    @Override
    public void enqueue(T item) {
        innerStorage.add(item);
    }

    // пердусловие: очередь не пуста
    // постуловие: элмент удален из головы очереди
    @Override
    public void dequeue() {
        if (innerStorage.isEmpty())
            dequeueStatus = DEQUEUE_ERR;
        innerStorage.remove(0);
        dequeueStatus = DEQUEUE_OK;
    }

    // запросы
    // предусловие: очередь не пуста
    @Override
    public T peek() {
        if (innerStorage.isEmpty()) {
            peekStatus = PEEK_ERR;
            return null;
        }
        peekStatus = PEEK_OK;
        return innerStorage.get(0);
    }

    // дополнительные запросы
    // возвращает текущий размер очереди
    @Override
    public int size() {
        return innerStorage.size();
    }

    // запросы статусов
    @Override
    public int getDequeueStatus() {
        return dequeueStatus;
    }

    @Override
    public int getPeekStatus() {
        return peekStatus;
    }
}