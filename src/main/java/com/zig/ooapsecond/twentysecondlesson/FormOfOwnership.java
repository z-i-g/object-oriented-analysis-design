package com.zig.ooapsecond.twentysecondlesson;

// Есть помещение (Room). Оно может быть арендным, в собственности и т.д.
// Так же оно может быть офисом или кафе.
// Форма собственности была выделена в отдельную иерархию с реализациями.
// Основной реализацией является типы помещений с полей "Форма собственности" через композицию

public interface FormOfOwnership {
}

class Rental implements FormOfOwnership {
}

class PersonalProperty implements FormOfOwnership {
}

interface Room {
}

class Office implements Room {
    private final FormOfOwnership formOfOwnership;

    public Office(FormOfOwnership formOfOwnership) {
        this.formOfOwnership = formOfOwnership;
    }
}