package com.zsitking;

import com.zsitking.entity.Student;
import com.zsitking.utils.MybatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.io.IOException;

public class MybatisTest {
    @Test
    public void Test1() throws IOException {
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        String sqlId = "com.zsitking.dao.StudentDao.addStudent";//全限定名称或mybatis命名空间(包名+类名+.+SQL唯一标识名)
        int addResult = sqlSession.insert(sqlId, new Student(1311, "王五", "1231312@qq.com", 30));//查询全部集合数据
        System.out.println(addResult);
        sqlSession.close();//关闭数据流
    }
}
