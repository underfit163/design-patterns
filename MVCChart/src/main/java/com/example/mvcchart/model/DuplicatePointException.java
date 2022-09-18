package com.example.mvcchart.model;

public class DuplicatePointException extends Exception {
    public DuplicatePointException(double x) {
        super("Аргумент функции повторяется " + x);
    }
}
