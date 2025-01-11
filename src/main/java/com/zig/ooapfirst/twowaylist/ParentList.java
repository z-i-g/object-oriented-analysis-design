package com.zig.ooapfirst.twowaylist;

public abstract class ParentList<T> {
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

  public static final int FIND_OK = 1; // следующий найден
  public static final int FIND_ERR = 2; // следующий не найден

  public static final int NIL = 0; // команда ещё не вызывалась

  private int putRightStatus; // статус команды put_right()
  private int putLeftStatus; // статус команды put_left()
  private int removeStatus; // статус команды remove()
  private int replaceStatus; // статус команды replace()
  private int headStatus; // статус команды is_head()
  private int tailStatus; // статус команды is_tail()
  private int rightStatus; // статус запроса right()
  private int getStatus; // статус команды get()
  private int findStatus; // статус команды find()

  protected Node head;
  private Node tail;
  protected Node cursor;

  // конструктор
  // постусловие: создан новый пустой список
  public ParentList() {
    putRightStatus = NIL;
    putLeftStatus = NIL;
    removeStatus = NIL;
    replaceStatus = NIL;
    headStatus = NIL;
    tailStatus = NIL;
    rightStatus = NIL;
    getStatus = NIL;
    findStatus = NIL;
  }

  // команды:
  // предусловие: список не пустой
  // постусловие: курсор в начале списка
  public void head() {
    if (cursor == null) {
      headStatus = HEAD_ERR;
      return;
    }
    cursor = head;
    headStatus = HEAD_OK;
  }

  // предусловие: список не пустой
  // постусловие: курсор в конце списка
  public void tail() {
    if (cursor == null) {
      tailStatus = TAIL_ERR;
      return;
    }
    cursor = tail;
    tailStatus = TAIL_OK;
  }

  // предусловие: правее курсора есть элемент;
  // постусловие: курсор сдвинут вправо
  public void right() {
    if (cursor == null || cursor.next == null) {
      rightStatus = RIGHT_ERR;
      return;
    }
    cursor = cursor.next;
    rightStatus = RIGHT_OK;
  }

  // предусловие: список не пустой;
  // постусловие: в список добавлен новый узел следом за текущим с заданным значением
  public void put_right(T value) {
    if (cursor == null) {
      putRightStatus = PUT_RIGHT_ERR;
      return;
    }

    Node<T> newNode = new Node<>(value);
    if (cursor.next == null) {
      tail = newNode;
      cursor.next = tail;
      return;
    }

    newNode.next = cursor.next;
    cursor.next = newNode;
    putRightStatus = PUT_RIGHT_OK;
  }

  // предусловие: список не пустой;
  // постусловие: в список добавлен новый узел перед текущим с заданным значением
  public void put_left(T value) {
    if (cursor == null) {
      putLeftStatus = PUT_LEFT_ERR;
      return;
    }

    Node<T> newNode = new Node<>(value);
    newNode.next = cursor;
    newNode.prev = cursor.prev;
    cursor.prev = newNode;

    if (cursor == head) {
      head = newNode;
    }
    putLeftStatus = PUT_LEFT_OK;
  }

  // предусловие: список не пустой;
  // постусловие: из списка удалён текущий узел,
  // курсор смещается к правому соседу, если он есть,
  // в противном случае курсор смещается к левому соседу,
  // если он есть
  public void remove() {
    if (cursor == null) {
      removeStatus = REMOVE_ERR;
      return;
    }
    var nextNode = cursor.next;
    var prevNode = cursor.prev;
    if (cursor == head) {
      cursor = nextNode;
      head = nextNode;
    }
    if (cursor == tail) {
      cursor = prevNode;
      tail = prevNode;
    }
    nextNode.prev = prevNode;
    prevNode.next = nextNode;
    removeStatus = REMOVE_OK;
  }

  // постусловие: список пустой
  public void clear() {
    head = null;
    tail = null;
    cursor = null;
  }

  // постусловие: в хвост списка добавлен новый узел с заданным значением
  public void add_tail(T value) {
    var currentCursor = cursor;
    cursor = tail;
    put_left(value);
    cursor = currentCursor;
  }

  // предусловие: список не пустой
  // постусловие: удалены все узлы с заданным значением
  public void removeAll(T value) {
    var currentCursor = cursor;
    cursor = head;
    while (cursor != null) {
      if(cursor.value == value) {
        remove();
      }
      cursor = cursor.next;
    }
    cursor = currentCursor;
  }

  // предусловие: список не пустой
  // постусловие: текущее значение узла заменено на заданное
  public void replace(T value) {
    if (cursor == null) {
      replaceStatus = REPLACE_ERR;
      return;
    }
    cursor.value = value;
    replaceStatus = REPLACE_OK;
  }

  // постусловие: курсор указывает на следующий узел с искомым значением
  public void find(T value) {
    if (cursor == null) {
      findStatus = FIND_ERR;
      return;
    }
    var currentCursor = cursor;
    while (cursor != null) {
      if(cursor.value == value) {
        break;
      }
      cursor = cursor.next;
    }
    if(cursor == null) {
      cursor = currentCursor;
    }
    findStatus = FIND_OK;
  }

  // запросы
  // предусловие: список не пустой
  public Node get() {
    if (cursor == null) {
      getStatus = GET_ERR;
    } else {
      getStatus = GET_OK;
    }
    return cursor;
  }

  public boolean is_head() {
    if (head == null) {
      headStatus = HEAD_ERR;
      return false;
    }
    headStatus = HEAD_OK;
    return head == cursor;
  }

  public boolean is_tail() {
    if (head == null) {
      tailStatus = TAIL_ERR;
      return false;
    }
    tailStatus = TAIL_OK;

    return head == tail;
  }

  public boolean is_value() {
    return cursor != null;
  }

  // возвращает текущее количество элементов
  public int size() {
    int n = 0;
    Node node = head;
    while (node != null) {
      n++;
      node = node.next;
    }
    return n;
  }

  // дополнительные запросы:
  public int get_head_status() {
    return headStatus;
  }

  public int get_tail_status() {
    return tailStatus;
  }

  public int get_right_status() {
    return rightStatus;
  }

  public int get_put_right_status() {
    return putRightStatus;
  }

  public int get_put_left_status() {
    return putLeftStatus;
  }

  public int get_remove_status() {
    return removeStatus;
  }

  public int get_replace_status() {
    return replaceStatus;
  }

  public int get_find_status() {
    return findStatus;
  }

  public int get_get_status() {
    return getStatus;
  }

  protected Node findPrevious() {
    Node node = head;
    while (node != null) {
      if (node.next == cursor) {
        return node;
      }
      node = node.next;
    }
    return null;
  }

  static class Node<T> {
    public T value;
    public Node next;
    public Node prev;

    public Node(T value) {
      this.value = value;
      next = null;
    }
  }
}

class TwoWayList<T> extends ParentList<T> {
  public static final int LEFT_ERR = 1;
  public static final int LEFT_OK = 2; // левее нет элемента

  private int leftStatus; // статус запроса left()

  public TwoWayList() {
    super();
    leftStatus = NIL;
  }

  // предусловие: левее курсора есть элемент;
  // постусловие: курсор сдвинут на один узел влево
  public void left() {
    if (head == null) {
      leftStatus = LEFT_ERR;
      return;
    }

    Node prevNode = findPrevious();
    if (prevNode == null) {
      leftStatus = LEFT_ERR;
      return;
    }

    cursor = prevNode;
    leftStatus = LEFT_OK;
  }

  public int get_left_status() {return leftStatus;}
}