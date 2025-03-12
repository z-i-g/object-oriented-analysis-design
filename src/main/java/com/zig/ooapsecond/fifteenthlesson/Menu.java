package com.zig.ooapsecond.fifteenthlesson;

public class Menu {
//    вместо поля, расширяем Menu с соответсвующим типом
//    private String type;

//    public void print() {
//        if ("Russian".equals(type))
//        ...
//        if ("Italian".equals(type))
//        ...
//    }

    public void print() {

    }
}

class RussianMenu extends Menu {
    @Override
    public void print() {
        System.out.println("Russian menu");
    }
}

class ItalianMenu extends Menu {
    @Override
    public void print() {
        System.out.println("Italian menu");
    }
}