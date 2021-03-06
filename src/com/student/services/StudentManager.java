package com.student.services;

import com.student.dal.*;
import com.student.model.*;

import java.io.*;
import java.util.*;

public class StudentManager {
    private final FileCSV FILECSV;
    private ArrayList<Student> list;
    private final Scanner SC = new Scanner(System.in);

    public StudentManager(File file) {
        this.FILECSV = new FileCSV(file);
    }

    public String importName() {
        String name;
        do {
            System.out.println("Required name is: Firstname Lastname");
            name = SC.nextLine();
        } while (!name.matches("^\\p{L}+\\s+\\p{L}*$"));
        return name;
    }

    public String importCode() {
        String code;
        do {
            System.out.println("Required code is: C0221H1**");
            code = SC.nextLine();
        } while (!code.matches("^C0221H1+\\d{2}$"));
        return code;
    }

    public int importAge() {
        String age;
        do {
            System.out.println("Allowed age range: 20-29");
            age = SC.nextLine();
        } while (!age.matches("^[2]+\\d$"));
        return Integer.parseInt(age);
    }

    public String importGender() {
        String gender;
        do {
            System.out.println("Nam/Nữ");
            gender = SC.nextLine();
        } while (!gender.equals("Nam") && !gender.equals("Nữ"));
        return gender;
    }

    public int find(String code) {
        list = FILECSV.getList();
        for (Student st:
             list) {
            if (st.getCode().equals(code)) {
                System.out.println(st.toString());
                return list.indexOf(st);
            }
        }
        return -1;
    }

    public void addStudent() {
        String name,code,gender;
        int age;
        System.out.println("Code:");
        code = importCode();
        if (find(code) == -1) {
            System.out.println("Name:");
            name = importName();
            System.out.println("Age:");
            age = importAge();
            System.out.println("Gender:");
            gender = importGender();
            Student st = new Student(name, code, age, gender);
            list.add(st);
            FILECSV.write();
            System.out.println("Add success.");
        } else {
            System.out.println("Can't add. Code exists.");
        }
    }

    public void editStudent(String code) {
        String name,gender;
        int age;
        int i = find(code);
        if (i != -1) {
            System.out.println("Name:");
            name = importName();
            System.out.println("Age:");
            age = importAge();
            System.out.println("Gender:");
            gender = importGender();
            list.get(i).setName(name);
            list.get(i).setAge(age);
            list.get(i).setGender(gender);
            FILECSV.write();
            System.out.println("Edit success.");
        } else {
            System.out.println("Can't edit. Code not exists.");
        }
    }

    public String checkScore() {
        String score;
        do {
            System.out.println("Score: 0.0-10.0");
            score = SC.nextLine();
        } while (!score.matches("^[0-9][.][0-9]$") && !score.equals("10.0"));
        return score;
    }

    public void importScore(String code) {
        String score1,score2,score3,score4,yesNo;
        int i = find(code);
        if (i != -1) {
            System.out.println("Score 1:");
            score1 = checkScore();
            list.get(i).setScore1(Double.parseDouble(score1));
            FILECSV.write();
            System.out.println("Import success.");
            System.out.println("Next Import ? Y/N");
            editScore:
            while (true) {
                yesNo = SC.nextLine();
                switch (yesNo) {
                    case "Y":
                        System.out.println("Score 2:");
                        score2 = checkScore();
                        list.get(i).setScore2(Double.parseDouble(score2));
                        FILECSV.write();
                        System.out.println("Import success.");
                        System.out.println("Next Import ? Y/N");
                        while (true) {
                            yesNo = SC.nextLine();
                            switch (yesNo) {
                                case "Y":
                                    System.out.println("Score 3:");
                                    score3 = checkScore();
                                    list.get(i).setScore3(Double.parseDouble(score3));
                                    FILECSV.write();
                                    System.out.println("Import success.");
                                    System.out.println("Next Import ? Y/N");
                                    while (true) {
                                        yesNo = SC.nextLine();
                                        switch (yesNo) {
                                            case "Y":
                                                System.out.println("Score 4:");
                                                score4 = checkScore();
                                                list.get(i).setScore4(Double.parseDouble(score4));
                                                FILECSV.write();
                                                System.out.println("Import success.");
                                                break editScore;
                                            case "N":
                                                break editScore;
                                            default:
                                                System.out.println("Y/N");
                                        }
                                    }
                                case "N":
                                    break editScore;
                                default:
                                    System.out.println("Y/N");
                            }
                        }
                    case "N":
                        break editScore;
                    default:
                        System.out.println("Y/N");
                }
            }
        } else {
            System.out.println("Can't import. Code not exists.");
        }
    }

    public void removeStudent(String code) {
        int i = find(code);
        if (i != -1) {
            list.remove(i);
            FILECSV.write();
            System.out.println("Remove success.");
        }
        else {
            System.out.println("Can't remove. Code not exists.");
        }
    }

    public void sortStudent() {
        list = FILECSV.getList();
        AverageComparator averageComparator = new AverageComparator();
        list.sort(averageComparator);
        FILECSV.write();
        System.out.println("Sort success.");
    }

    public void rankingList() {
        list = FILECSV.getList();
        int count = 1;
        for (int i = 0; i < list.size(); i++) {
            System.out.printf("|  %-12s-  %-8s|",list.get(i).getName(),list.get(i).getClassified());
            if (i == list.size() -1) {
                System.out.println();
                System.out.println(list.get(i).getClassified() + " - " + count);
            } else {
                if (list.get(i).getClassified().equals(list.get(i+1).getClassified())) {
                    count ++;
                } else {
                    System.out.println();
                    System.out.println(list.get(i).getClassified() + " - " + count);
                    count = 1;
                }
            }
        }
    }

    public void readList() {
        FILECSV.read();
    }

    public void menu() {
        for (int i = 0; i < 20; i++) {
            System.out.println();
        }
        System.out.printf("%65s%s"," ","----- STUDENT MANAGEMENT SOFTWARE -----");
        System.out.println("\n");
        for (int i = 0; i < 169; i++) {
            System.out.print("-");
        }
        System.out.println();
        System.out.printf("|%4s%s%5s|"," ","1.Read File"," ");
        System.out.printf("%3s%s%4s|"," ","2.Add Student"," ");
        System.out.printf("%3s%s%3s|"," ","3.Edit Student"," ");
        System.out.printf("%2s%s%2s|"," ","4.Remove Student"," ");
        System.out.printf("%3s%s%3s|"," ","5.Import Score"," ");
        System.out.printf("%3s%s%3s|"," ","6.Sort Student"," ");
        System.out.printf("%3s%s%3s|"," ","7.Ranking List"," ");
        System.out.printf("%3s%s%4s|"," ","X.Exit System"," ");
        System.out.println();
        for (int i = 0; i < 169; i++) {
            System.out.print("-");
        }
        System.out.println();
    }

    public void run() {
        String choice,code;
        while (true) {
            menu();
            choice = SC.nextLine();
            switch (choice) {
                case "1":
                    for (int i = 0; i < 169; i++) {
                        System.out.print("-");
                    }
                    System.out.println();
                    System.out.printf("|%9s%s%10s|"," ","Name"," ");
                    System.out.printf("%7s%s%7s|"," ","Code"," ");
                    System.out.printf("%6s%s%5s|"," ","Age"," ");
                    System.out.printf("%5s%s%5s|"," ","Gender"," ");
                    System.out.printf("%3s%s%4s|"," ","Score 1"," ");
                    System.out.printf("%3s%s%4s|"," ","Score 2"," ");
                    System.out.printf("%3s%s%4s|"," ","Score 3"," ");
                    System.out.printf("%3s%s%4s|"," ","Score 4"," ");
                    System.out.printf("%4s%s%5s|"," ","Average"," ");
                    System.out.printf("%2s%s%3s|"," ","Classified"," ");
                    System.out.println();
                    for (int i = 0; i < 169; i++) {
                        System.out.print("-");
                    }
                    System.out.println();
                    readList();
                    for (int i = 0; i < 169; i++) {
                        System.out.print("-");
                    }
                    System.out.println();
                    System.out.println("Press the enter key to return menu");
                    SC.nextLine();
                    break;
                case "2":
                    System.out.println("Add Student:");
                    addStudent();
                    System.out.println("Press the enter key to return menu");
                    SC.nextLine();
                    break;
                case "3":
                    System.out.println("Edit Student:");
                    System.out.println("Code:");
                    code = importCode();
                    editStudent(code);
                    System.out.println("Press the enter key to return menu");
                    SC.nextLine();
                    break;
                case "4":
                    System.out.println("Remove Student:");
                    System.out.println("Code:");
                    code = importCode();
                    removeStudent(code);
                    System.out.println("Press the enter key to return menu");
                    SC.nextLine();
                    break;
                case "5":
                    System.out.println("Import Score:");
                    System.out.println("Code:");
                    code = importCode();
                    importScore(code);
                    System.out.println("Press the enter key to return menu");
                    SC.nextLine();
                    break;
                case "6":
                    System.out.println("Sort Student:");
                    sortStudent();
                    System.out.println("Press the enter key to return menu");
                    SC.nextLine();
                    break;
                case "7":
                    System.out.println("Ranking List:");
                    rankingList();
                    System.out.println("Press the enter key to return menu");
                    SC.nextLine();
                    break;
                case "X":
                    System.exit(0);
                default:
                    System.out.println("Not now ... Press the enter key to return menu");
                    SC.nextLine();
            }
        }
    }
}
