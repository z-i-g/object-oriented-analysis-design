package com.zig;

import com.zig.stack.AbstractBoundedStack;
import com.zig.stack.BoundedStack;

public class Main {
    public static void main(String[] args) {
        BoundedStack<Integer> boundedStack = new BoundedStack<>(4);

        boundedStack.push(1);
        boundedStack.push(2);
        boundedStack.push(3);
        boundedStack.push(4);
        boundedStack.push(5);

        if (boundedStack.get_push_status() == AbstractBoundedStack.PUSH_OK) {
            int x = boundedStack.peek().get();
            System.out.println(x);
        }

        System.out.println(boundedStack.get_peek_status() == AbstractBoundedStack.PEEK_OK);


    }
}