package com.student.model;

import java.util.Comparator;

public class AverageComparator implements Comparator<Student> {
    @Override
    public int compare(Student o1, Student o2) {
        return Double.compare(o2.getAverage(), o1.getAverage());
    }
}
