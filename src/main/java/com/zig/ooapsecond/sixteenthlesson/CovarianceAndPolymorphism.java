package com.zig.ooapsecond.sixteenthlesson;

import java.util.List;

public class CovarianceAndPolymorphism {

    public void test() {
        Restaurant restaurant = new Restaurant();

        restaurant.polymorphismExecute(new ItalianMenu());

        restaurant.covarianceExecute(List.of(new ItalianMenu()));
    }
}

class Restaurant {
    void polymorphismExecute(Menu menu) {
        menu.print();
    }

    <T> void covarianceExecute(List<T> menu) {}
}

class Menu {
    public void print() {}
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