package com.zsitking;

import com.zsitking.entity.Student;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * 测试Mybatis连接数据库
 */
public class MyApp {
    public static void main(String[] args) throws IOException {
        String config = "mybatis-config.xml";//target/classes编译目录下的mybatis主配置文件
        InputStream in = Resources.getResourceAsStream(config);//通过流方式读取数据库参数信息
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(in);//数据流传入SQL会话工程处理
        SqlSession sqlSession = factory.openSession();//开启SQL会话
        String sqlId = "com.zsitking.dao.StudentDao"+"."+"selectAllData";//全限定名称或mybatis命名空间(包名+类名+.+SQL唯一标识名)
        List<Student> students = sqlSession.selectList(sqlId);//查询全部集合数据
        for (Student stu: students) {//循环遍历
            System.out.println(stu);//打印java对象
        }
        sqlSession.close();//关闭数据流
    }
}
