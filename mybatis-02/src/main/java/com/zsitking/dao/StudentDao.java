package com.zsitking.dao;

import com.zsitking.entity.Student;

import java.util.List;

public interface StudentDao {

    public List<Student> selectAll();

    //添加
    public int addStudent(Student student);
}
