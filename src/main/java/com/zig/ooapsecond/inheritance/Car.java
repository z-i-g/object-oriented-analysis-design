package com.zig.ooapsecond.inheritance;

// Car is-a Transport
public class Car extends Transport {
    // композиция (Car has-a Engine)
    private Engine engine;

    public Car(Engine engine) {
        this.engine = engine;
    }

    // переопределенный метод в наследнике
    // полиморфизм
    @Override
    public void drive() {
        engine.start();
        System.out.println("The car is coming");
    }
}