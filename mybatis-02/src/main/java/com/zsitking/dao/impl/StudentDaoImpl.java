package com.zsitking.dao.impl;

import com.zsitking.dao.StudentDao;
import com.zsitking.entity.Student;
import com.zsitking.utils.MybatisUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

/**
 * 接口实现类
 */
public class StudentDaoImpl implements StudentDao {

    @Override
    public List<Student> selectAll() {
        //获取SqlSession对象
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        //执行SQL语句
        List<Student> studentList =  sqlSession.selectList("com.zsitking.dao.StudentDao.selectAll");
        //关闭
        sqlSession.close();
        return studentList;
    }

    @Override
    public int addStudent(Student student) {
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        String sqlId = "com.zsitking.dao.StudentDao.addStudent";//全限定名称或mybatis命名空间(包名+类名+.+SQL唯一标识名)
        int addResult = sqlSession.insert(sqlId,student);//查询全部集合数据
        sqlSession.commit();
        sqlSession.close();//关闭数据流
        return addResult;
    }
}
