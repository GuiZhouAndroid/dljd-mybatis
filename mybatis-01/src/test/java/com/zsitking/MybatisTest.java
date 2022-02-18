package com.zsitking;

import com.zsitking.entity.Student;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MybatisTest {
    @Test
    public void Test1() throws IOException {
        String config = "mybatis-config.xml";//target/classes编译目录下的mybatis主配置文件
        InputStream in = Resources.getResourceAsStream(config);//通过流方式读取数据库参数信息
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(in);//数据流传入SQL会话工程处理
        SqlSession sqlSession = factory.openSession(true);//开启SQL会话，自动提交事务
        String sqlId = "com.zsitking.dao.StudentDao"+"."+"addStudent";//全限定名称或mybatis命名空间(包名+类名+.+SQL唯一标识名)
        int addResult = sqlSession.insert(sqlId,new Student(1310,"王五","1231312@qq.com",30));//查询全部集合数据
        System.out.println(addResult);
        sqlSession.close();//关闭数据流
    }
}
