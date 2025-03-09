package com.zig;

import com.zig.ooapsecond.fourteenthlesson.Vector;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Vector<Integer> vec1 = new Vector<>(3);
        Vector<Integer> vec2 = new Vector<>(3);

        vec1.add(1);
        vec1.add(2);
        vec1.add(3);

        vec2.add(1);
        vec2.add(2);
        vec2.add(3);

        Vector<Vector<Integer>> vectorVector1 = new Vector<>(3);
        Vector<Vector<Integer>> vectorVector2 = new Vector<>(3);

        vectorVector1.add(vec1);
        vectorVector1.add(vec1);
        vectorVector1.add(vec1);
        vectorVector2.add(vec2);
        vectorVector2.add(vec2);
        vectorVector2.add(vec2);
//
//        List<List<Integer>> lists = new ArrayList<>();


        Vector<Integer> vecSum =  vec1.sum(vec2);

        Vector<Vector<Integer>> vectorVectorSum = vectorVector1.sum(vectorVector2);

        System.out.println(Arrays.toString(vecSum.getArr()));
        System.out.println(Arrays.toString(vectorVectorSum.getArr()));
    }
}