package com.student.model;

public class Student implements Comparable<Student> {
    String name;
    String code;
    int age;
    String gender;
    double score1;
    double score2;
    double score3;
    double score4;
    double average;

    public Student(String name, String code, int age, String gender) {
        this.name = name;
        this.code = code;
        this.age = age;
        this.gender = gender;
        this.score1 = 0;
        this.score2 = 0;
        this.score3 = 0;
        this.score4 = 0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setScore1(double score1) {
        this.score1 = score1;
    }

    public void setScore2(double score2) {
        this.score2 = score2;
    }

    public void setScore3(double score3) {
        this.score3 = score3;
    }

    public void setScore4(double score4) {
        this.score4 = score4;
    }

    public double getAverage() {
        if (score1 == 0 || score2 == 0 || score3 == 0 || score4 == 0) {
            return 0;
        } else {
            this.average  = (score1 + score2 + score3 * 2 + score4 * 3)/ 7;
            return average;
        }
    }

    public String getClassified() {
        if (getAverage() <= 10 && getAverage() >= 8.5) {
            return "Great";
        } else if (getAverage() >= 7) {
            return "Rather";
        } else if (getAverage() >= 5.5) {
            return "Medium";
        } else if (getAverage() >= 4) {
            return "Weak";
        } else if (getAverage() > 0) {
            return "Least";
        } else {
            return "Not yet";
        }
    }

    @Override
    public String toString() {
        return name + "," + code + "," + age + "," + gender + "," + score1 + "," + score2 + "," + score3 + "," + score4 + "," + getAverage() + "," + getClassified() + "\n";
    }

    @Override
    public int compareTo(Student student) {
        return this.getName().compareTo(student.getName());
    }
}
