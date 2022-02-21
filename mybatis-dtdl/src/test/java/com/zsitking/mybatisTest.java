package com.zsitking;

import com.zsitking.dao.StudentDao;
import com.zsitking.entity.Student;
import com.zsitking.utils.MybatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class mybatisTest {
    @Test
    public void test1() {
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);
        List<Student> list = dao.selectAll();
        System.out.println(list);
    }

    @Test
    public void test2() {
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);
        int a = dao.addStudent(new Student(134, "王56", "1231312@qq.com", 30));
        sqlSession.commit();
        sqlSession.close();
        System.out.println(a);
    }
}
