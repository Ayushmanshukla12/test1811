package com;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.util.List;

public class MainApp {
    static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws SQLException, IOException {
        DaoImpl dao = new DaoImpl();

        boolean flag = true;
        while (flag) {

            System.out.println("1-For adding new student");
            System.out.println("2-For updating student");
            System.out.println("3-For findingAll");
            System.out.println("4-For finding by id");
            System.out.println("5-For delete by id");
            System.out.println("6-For deleting all");
            System.out.println("Enter the option you want");
            int choice = Integer.parseInt(bufferedReader.readLine());
            switch (choice) {
                case 1:
                    System.out.println("enter the student id");
                    int id = Integer.parseInt(bufferedReader.readLine());
                    System.out.println("Enter the student name");
                    String name = bufferedReader.readLine();
                    Student student = new Student(id,name);
                    dao.save(student);
                    break;

                case 2:
                    System.out.println("enter the student id");
                    int id1 = Integer.parseInt(bufferedReader.readLine());
                    System.out.println("Enter the student name");
                    String name1 = bufferedReader.readLine();
                    Student student1 = new Student(id1,name1);
                    dao.save(student1);
                    break;

                case 3:
                    List<Student> students = dao.findAll();
                    System.out.println(students.size());
                    System.out.println("The list of the students is as follows");
                    students.stream().forEach(System.out::println);
                    break;

                case 4:
                    System.out.println("Enter the id of the student you want to find information of");
                    int id2 = Integer.parseInt(bufferedReader.readLine());
                    Student student2 = dao.findById(id2);
                    System.out.println("The student is " + student2);
                    break;

                case 5:
                    System.out.println("Enter the id of the student you want to delete");
                    int id3 = Integer.parseInt(bufferedReader.readLine());
                    dao.deleteById(id3);
                    break;

                case 6:
                    System.out.println("Delete all the information");
                    dao.deleteAll();
                    break;

            }

        }
    }
}


