package com.zig.ooapsecond.inheritance;

// Bicycle is-a Transport
public class Bicycle extends Transport {

    // переопределенный метод в наследнике
    // полиморфизм
    @Override
    public void drive() {
        System.out.println("The bicycle is coming");
    }
}