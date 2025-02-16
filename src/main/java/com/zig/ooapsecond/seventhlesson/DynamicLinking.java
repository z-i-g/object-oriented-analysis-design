package com.zig.ooapsecond.seventhlesson;

public class DynamicLinking {
    public static void main(String[] args) {
        Animal animal = new Dog();
        animal.voice(); // использование динамического связывания, вызовется метод voice() у класса Dog
    }
}

abstract class Animal {
    abstract void voice();
}

class Dog extends Animal {
    @Override
    public void voice() {
        System.out.println("I am Dog");
    }
}

class Cat extends Animal {
    @Override
    public void voice() {
        System.out.println("I am Cat");
    }
}