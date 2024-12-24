package org.apache.lizhan;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @Author lz
 * @company JYYH
 * @Date 2024/12/24 20:15
 * @Description TODO
 * @packageName org.apache.lizhan
 * @className: Start
 * @Version 1.0
 */
public class Start {


  public static void main(String[] args) throws IOException {


    //1、读取全局配置文件的文件流
    InputStream is = Resources.getResourceAsStream("mybatis-config.xml");

    //2、读取文件中的配置创建SqlSessionFactory对象
//    SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
//    SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(is);
    SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);

    //3、通过SqlSessionFactory对象 获取SqlSession
    SqlSession sqlSession = sqlSessionFactory.openSession();


    //4、执行sql
    List<Integer> userCount = sqlSession.selectList("org.apache.lizhan.mapper.UserMapper.selectUser");


    System.out.println(userCount);

  }
}
