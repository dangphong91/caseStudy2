package com.student.data;

import com.student.model.Student;

import java.io.*;
import java.util.*;

public class FileCSV {
    private final File file;
    private  ArrayList<Student> list;
    private final String HEADER = "Name,Code,Age,Gender,Score1,Score2,Score3,Score4,Average,Classified";

    public FileCSV(File file) {
        this.file = file;
    }

    public ArrayList<Student> getList() {
        return list;
    }

    public void read(){
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try {
            list = new ArrayList<>();
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            String line;
            while ((line = br.readLine()) != null) {
                if (line.equals(HEADER)) {
                    continue;
                }
                String[] st = line.split(",");
                System.out.printf("|    %-14s|%14s    |%8s      |       %-9s|%9s     |%9s     |%9s     |%9s     |  %-19s|    %-11s|", (Object[]) st);
                System.out.println();
                Student student = new Student(st[0], st[1], Integer.parseInt(st[2]), st[3]);
                student.setScore1(Double.parseDouble(st[4]));
                student.setScore2(Double.parseDouble(st[5]));
                student.setScore3(Double.parseDouble(st[6]));
                student.setScore4(Double.parseDouble(st[7]));
                list.add(student);
            }
            br.close();
            fr.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void write() {
        try {
            FileWriter fw = new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.append(HEADER);
            bw.append("\n");
            for (Student st :
                    list) {
                bw.append(st.toString());
            }
            bw.close();
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
