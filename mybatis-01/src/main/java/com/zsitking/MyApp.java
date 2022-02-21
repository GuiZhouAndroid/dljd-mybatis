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
//        SqlSession sqlSession = MybatisUtil.getSqlSession();//开启SQL会话，非自动提交事务
//        String sqlId = "com.zsitking.dao.StudentDao.selectAllData";//全限定名称或mybatis命名空间(包名+类名+.+SQL唯一标识名)
//        List<Student> students = sqlSession.selectList(sqlId);//查询全部集合数据
//        for (Student stu: students) {//循环遍历
//            System.out.println(stu);//打印java对象
//        }
//        sqlSession.close();//关闭数据流
        String config = "mybatis-config.xml";
        InputStream in = Resources.getResourceAsStream(config);
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory sessionFactory = builder.build(in);
        SqlSession sqlSession = sessionFactory.openSession(true);
        List<Student> students = sqlSession.selectList("com.zsitking.dao.StudentDao.selectAllData");
        for (Student stu: students) {//循环遍历
            System.out.println(stu);//打印java对象
        }
        sqlSession.close();
    }
}
