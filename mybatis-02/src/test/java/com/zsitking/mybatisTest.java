package com.zsitking;

import com.zsitking.dao.StudentDao;
import com.zsitking.dao.impl.StudentDaoImpl;
import com.zsitking.entity.Student;
import org.junit.Test;

import java.util.List;

public class mybatisTest {
    @Test
    public void test1(){
        StudentDao studentDao = new StudentDaoImpl();
        List<Student> list =  studentDao.selectAll();
        for (Student s: list) {
            System.out.println(s);
        }
    }
    @Test
    public void test2(){
        StudentDao studentDao = new StudentDaoImpl();
        int result =  studentDao.addStudent( new Student(13154, "王五", "1231312@qq.com", 30));
        System.out.println(result);
    }
}
