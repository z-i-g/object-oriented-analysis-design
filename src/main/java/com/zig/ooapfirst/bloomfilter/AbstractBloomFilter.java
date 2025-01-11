package com.zig.ooapfirst.bloomfilter;

public abstract class AbstractBloomFilter {

    // конструктор
    // создает фильтр Блюма с битовым массивом длиной fLen
    public AbstractBloomFilter(int fLen) {
    }

    // команды
    // постусловие: в фильтр добавлена строка str1
    public abstract void add(String str1);

    // запросы
    public abstract boolean isValue(String str1);
}