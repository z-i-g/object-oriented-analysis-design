package com.zig.ooapsecond.secondlesson;

// Наследник - специализация класса Animal
public class Cat extends Animal {
    private String type;

    @Override
    public void eat() {
        System.out.println("Cat is eating");
    }
}