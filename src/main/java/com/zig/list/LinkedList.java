package com.zig.list;

// 2.1
public abstract class LinkedList<T> {
    public static final int PUT_RIGHT_OK = 1; // последняя put_right() отработала нормально
    public static final int PUT_RIGHT_ERR = 2; // список пустой

    public static final int PUT_LEFT_OK = 1; // последняя put_left() отработала нормально
    public static final int PUT_LEFT_ERR = 2; // список пустой

    public static final int REMOVE_OK = 1; // последняя remove() отработала нормально
    public static final int REMOVE_ERR = 2; // список пустой

    public static final int REPLACE_OK = 1; // последняя replace() отработала нормально
    public static final int REPLACE_ERR = 2; // список пустой

    public static final int HEAD_OK = 1; // последняя head() отработала нормально
    public static final int HEAD_ERR = 2; // список пустой

    public static final int TAIL_OK = 1; // последняя tail() отработала нормально
    public static final int TAIL_ERR = 2; // список пустой

    public static final int RIGHT_OK = 1; // последняя right() отработала нормально
    public static final int RIGHT_ERR = 2; // правее нету элемента

    public static final int GET_OK = 1; // последняя get() отработала нормально
    public static final int GET_ERR = 2; // список пустой

    public static final int FIND_NIL = 0; // список пуст
    public static final int FIND_OK = 1; // следующий найден
    public static final int FIND_ERR = 2; // следующий не найден


    //конструктор
    //постусловие: создан новый пустой связный список
    protected LinkedList() {}

    // команды:
    // предусловие: список не пустой
    // постусловие: курсор в начале списка
    public abstract void head();

    // предусловие: список не пустой
    // постусловие: курсор в конце списка
    public abstract void tail();

    // предусловие: правее курсора есть элемент;
    // постусловие: курсор сдвинут вправо
    public abstract void right();

    // предусловие: список не пустой;
    // постусловие: в список добавлен новый узел следом за текущим с заданным значением
    public abstract void put_right(T value);

    // предусловие: список не пустой;
    // постусловие: в список добавлен новый узел перед текущим с заданным значением
    public abstract void put_left(T value);

    // предусловие: список не пустой;
    // постусловие: из списка удалён текущий узел,
    // курсор смещается к правому соседу, если он есть,
    // в противном случае курсор смещается к левому соседу,
    // если он есть
    public abstract void remove();

    // постусловие: список пустой
    public abstract void clear();

    // постусловие: в хвост списка добавлен новый узел с заданным значением
    public abstract void add_tail(T value);

    // предусловие: список не пустой
    // постусловие: текущее значение узла заменено на заданное
    public abstract void replace(T value);

    // предусловие: список не пустой
    // постусловие: удалены все узлы с заданным значением
    public abstract void remove_all(T value);

    // постусловие: курсор указывает на следующий узел с искомым значением
    public abstract void find(T value);


    // запросы:
    // предусловие: список не пустой
    public abstract T get();

    public abstract int size();

    public abstract boolean is_head ();
    public abstract boolean is_tail();
    public abstract boolean is_value();

    // дополнительные запросы:
    public abstract int get_head_status(); // возвращает значение HEAD_*
    public abstract int get_tail_status(); // возвращает значение TAIL_*
    public abstract int get_right_status(); // возвращает значение RIGHT_*
    public abstract int get_put_right_status(); // возвращает значение PUT_RIGHT_*
    public abstract int get_put_left_status(); // возвращает значение PUT_LEFT_*
    public abstract int get_add_tail_status(); // возвращает значение ADD_TAIL*
    public abstract int get_remove_status(); // возвращает значение REMOVE_*
    public abstract int get_replace_status(); // возвращает значение REPLACE_*
    public abstract int get_find_status(); // возвращает значение FIND_*
    public abstract int get_remove_all_status(); // возвращает значение REMOVE_ALL_*
    public abstract int get_get_status(); // возвращает значение GET_*
}

// 2.2
// сложность через другие опреация не равна О(1)

// 2.3
// есть возможность реализовать через find(T) и get() с запросом результатов команд
