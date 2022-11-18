package com;

import javax.swing.plaf.nimbus.State;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DaoImpl implements dao{
    @Override
    public List<Student> findAll() throws SQLException {
        Connection connection = Factoryprovider.connect();
        Statement statement=connection.createStatement();
        ResultSet resultSet=statement.executeQuery("select * from student");
        List<Student> studentList = new ArrayList<Student>();

        while (resultSet.next()) {
            Student student = new Student();
            student.setId(resultSet.getInt(1));
            student.setName(resultSet.getString(2));
            studentList.add(student);
        }
        return studentList;
    }

    @Override
    public Student findById(int id) throws SQLException {
        Connection connection = Factoryprovider.connect();
        ResultSet resultSet ;
        PreparedStatement preparedStatement = connection.prepareStatement("select * from Student " +
                "where id = ?");
        preparedStatement.setInt(1,id);

        resultSet = preparedStatement.executeQuery();
        Student student = new Student();
        while (resultSet.next()) {
            student.setId(resultSet.getInt(1));
            student.setName(resultSet.getString(2));
        }
        return student;
    }

    @Override
    public void saveStudent(Student student) throws SQLException {
        Connection connection = Factoryprovider.connect();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select * from student");
        if (!resultSet.next()) {
            PreparedStatement preparedStatement = connection.prepareStatement("insert into student values()");
        }
        else {
            PreparedStatement preparedStatement = connection.prepareStatement("update ");
        }
    }

    @Override
    public void deleteById(int id) throws SQLException {
        Connection connection = Factoryprovider.connect();
        Statement statement=connection.createStatement();
        statement.execute("delete from student where id="+id);
    }


    @Override
    public void deleteAll() throws SQLException {
        Connection connection = Factoryprovider.connect();
        Statement statement=connection.createStatement();
        statement.execute("delete from student");
    }

    @Override
    public void save(Student student) throws SQLException {
        Connection connection = Factoryprovider.connect();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select * from student");
        int count=0;
        while (resultSet.next()) {
            if(student.getId()== resultSet.getInt(1)){
                count=1;
                break;
            }
        }
        if(count==0){
            PreparedStatement preparedStatement = connection.prepareStatement("insert into Student values (?,?)");
            preparedStatement.setInt(1, student.getId());
            preparedStatement.setString(2, student.getName());
            preparedStatement.execute();
            System.out.println("added!!");
        }
        else {
            PreparedStatement preparedStatement = connection.prepareStatement("Update Student set name=? where " +
                    "id="+student.getId());
            preparedStatement.setString(1, student.getName());
            preparedStatement.execute();
            System.out.println("updatedd!!");
        }
    }
}
