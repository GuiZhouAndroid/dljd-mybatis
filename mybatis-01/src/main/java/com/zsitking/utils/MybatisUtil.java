package com.zsitking.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * Mybatis工具栏
 */
public class MybatisUtil {

    private static SqlSessionFactory factory = null;

    //静态代码块读取Mybatis主配置文件
    static {
        String config = "mybatis-config.xml";//target/classes编译目录下的mybatis主配置文件
        try {
            InputStream in = Resources.getResourceAsStream(config);//通过流方式读取数据库参数信息
            SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
            //数据流传入SQL会话工程处理
            factory = builder.build(in);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static SqlSession getSqlSession() {
        SqlSession sqlSession = null;
        if (factory != null){
            sqlSession = factory.openSession();//非自动事务提交
        }
        return sqlSession;
    }
}
