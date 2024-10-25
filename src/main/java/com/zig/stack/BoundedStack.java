package com.zig.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class BoundedStack<T> extends AbstractBoundedStack<T> {

    private List<T> stack; // основное хранилище стека
    private final int defaultCapacity = 32; // размер стека по умолчанию
    private final int capacity; // размер стека при указании размера, по умолчанию defaultSize
    private int peek_status; // статус запроса peek()
    private int pop_status; // статус команды pop()
    private int push_status; // статус команды push()

    // конструктор с размером стека по умолчанию
    public BoundedStack() {
        capacity = defaultCapacity;
        clear();
    }

    // конструктор с указанным размером стека
    public BoundedStack(int stackSize) {
        if (stackSize <= 0)
            stackSize = defaultCapacity;
        capacity = stackSize;
        clear();
    }

    // команды:
    public void push(T value) {
        push_status = PUSH_ERR;
        if (size() < capacity) {
            stack.add(value);
            push_status = PUSH_OK;
        }
    }

    public void pop() {
        pop_status = POP_ERR;
        if (size() > 0) {
            stack.remove(size() - 1);
            pop_status = POP_OK;
        }
    }

    public void clear() {
        stack = new ArrayList<>(capacity); // пустой список/стек

//        начальные статусы для предусловий peek() и pop()
        peek_status = PEEK_NIL;
        pop_status = POP_NIL;
        push_status = PUSH_NIL;
    }

    // запросы:
    public Optional<T> peek() {
        Optional<T> result = Optional.empty();
        peek_status = PEEK_ERR;
        if (size() > 0) {
            result = Optional.of(stack.get(size() - 1));
            peek_status = PEEK_OK;
        }
        return result;
    }

    public int size() {
        return stack.size();
    }


    // запросы статусов
    public int get_pop_status() {
        return pop_status;
    }

    public int get_peek_status() {
        return peek_status;
    }

    public int get_push_status() {
        return push_status;
    }
}
