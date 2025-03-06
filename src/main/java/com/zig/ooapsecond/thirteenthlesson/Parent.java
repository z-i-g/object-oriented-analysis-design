package com.zig.ooapsecond.thirteenthlesson;

public class Parent {
    // 1 - метод публичен в родительском и потомке
    public void executeOne() {}

    // 2 - метод публичен в родительском и скрыт в потомке
    // сужать видимость при наследованиив в Java нельзя
    public void executeTwo() {}

    // 3 - метод скрыт в родительском и публичен в потомке
    // если метод не скрыт в родительском, можно расширить видимость в потомках
    void executeThree() {}

    // 4 - метод скрыт в родительском и потомке
    // скрытый метод не будет наследоваться
    private void executeFour() {}
}

class Child extends Parent {
    // 1 - метод публичен в родительском и потомке
    public void executeOne() {
        super.executeOne();
    }

    // 2 - метод публичен в родительском и скрыт в потомке
    // сужать видимость при наследованиив в Java нельзя
//    private void executeTwo() {}

    // 3 - метод скрыт в родительском и публичен в потомке
    // если метод не скрыт в родительском, можно расширить видимость в потомках
    public void executeThree() {
        super.executeThree();
    }

    // 4 - метод скрыт в родительском и потомке
    // скрытый метод не будет наследоваться
    private void executeFour() {}
}