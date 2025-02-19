package com.zig.ooapsecond.eighthlesson;

public class CovarianceAndContravariance {
}

// пример ковариантности
class Animal {
    public Animal reproduce() {
        return new Animal();
    }
}

class Dog extends Animal {
    // можно вернуть подтип класса родителя в переопределенном методе
    @Override public Dog reproduce() {
        return new Dog();
    }
}

// контравариантность при наследовании в моем понимании невозможна
// но можно использовать контравариантностные коллекции List<? super Animal>