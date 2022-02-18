package com.zsitking.dao;

import com.zsitking.entity.Student;

import java.util.List;

/**
 * 接口操作student表
 */
public interface StudentDao {
    //查询student表全部数据
    public List<Student> selectAllData();

    //添加
    public int addStudent(Student student);
}
