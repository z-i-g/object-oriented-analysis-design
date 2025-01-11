package com.zig;

import com.zig.ooapsecond.inheritance.Bicycle;
import com.zig.ooapsecond.inheritance.Car;
import com.zig.ooapsecond.inheritance.Engine;
import com.zig.ooapsecond.inheritance.Transport;

public class Main {
    public static void main(String[] args) {
        Transport transport = new Car(new Engine());
        transport.drive();

        transport = new Bicycle();
        transport.drive();
    }
}