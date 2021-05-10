package com.student.presentation;

import com.student.services.StudentManager;

import java.io.File;

public class Main {
    public static void main(String[] args) {
        File file1 = new File("sv.csv");
        StudentManager list1 = new StudentManager(file1);
        list1.run();
    }
}
