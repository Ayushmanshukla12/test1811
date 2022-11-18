package com;

import java.sql.SQLException;
import java.util.List;

public interface dao {
    List<Student> findAll() throws SQLException;
    public Student findById(int id) throws SQLException;
    public void saveStudent(Student student) throws SQLException;
    public void deleteById(int id) throws SQLException;
    public void deleteAll() throws SQLException;
    public void save(Student student) throws SQLException;
}
