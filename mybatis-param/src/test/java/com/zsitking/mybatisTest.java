package com.zsitking;

import com.zsitking.dao.StudentDao;
import com.zsitking.entity.Student;
import com.zsitking.utils.MybatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

public class mybatisTest {
    @Test
    public void test1() {
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);
        Student student = dao.selectStudentById(134);
        System.out.println(student);
    }

    @Test
    public void test2() {

    }
}
