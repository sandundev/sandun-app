package com.sandun.java8;

interface Formula {
    double calculate(int a);

    default double sqrt(int a) {
        return Math.sqrt(a);
    }
    default double sqrtx(int a) {
        return Math.sqrt(a);
    }
}