package com.charlize;

import com.charlize.mapper.StudentMapper;
import com.charlize.pojo.Student;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class mybatisMapperDemo {
    public static void main(String[] args) throws IOException {
        //1.加载mybatis的核心配置文件，获取sqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //2.获取sqlSession对象，执行sql
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //3.执行sql，需要名称空间和唯一标识
        //List<Student> students = sqlSession.selectList("test.selectAllStudent");
        //3.1获取StudentMapper接口的代理对象
        StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
        List<Student> students = studentMapper.selectAllStudent();

        System.out.println(students);
        //4.释放资源
        sqlSession.close();
    }
}
