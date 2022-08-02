package com.charlize.test;

import com.charlize.mapper.StudentMapper;
import com.charlize.pojo.Student;
import javafx.beans.binding.MapExpression;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MybatisTest {


    @Test
    public void testSelectAllStudent() throws IOException {
        //1.加载mybatis的核心配置文件，获取sqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //2.获取sqlSession对象，执行sql
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //3.1获取StudentMapper接口的代理对象
        StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);

        List<Student> students = studentMapper.selectAllStudent();

        System.out.println(students);
        //4.释放资源
        sqlSession.close();
    }

        @Test
        public void testSelectBysNo() throws IOException {
            //1.加载mybatis的核心配置文件，获取sqlSessionFactory
            String resource = "mybatis-config.xml";
            InputStream inputStream = Resources.getResourceAsStream(resource);
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

            //2.获取sqlSession对象，执行sql
            SqlSession sqlSession = sqlSessionFactory.openSession();

            //3.1获取StudentMapper接口的代理对象
            StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);


            int sno = 170101;
            Student student = studentMapper.selectById(sno);
            System.out.println(student);
            //4.释放资源
            sqlSession.close();
    }
    @Test
    public void testSelectBysCondition() throws IOException {
        //1.加载mybatis的核心配置文件，获取sqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //2.获取sqlSession对象，执行sql
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //3.1获取StudentMapper接口的代理对象
        StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
        //List<Student> students = studentMapper.selectByCondition(30, "%宁%");


/*        Student student = new Student();
        student.setAge(30);
        student.setsName("%宁%");
        List<Student> students = studentMapper.selectByCondition(student);*/

        Map map = new HashMap();
        map.put("age", 30);
        map.put("sName", "%宁%");

        List<Student> students = studentMapper.selectByCondition(map);

        System.out.println(students);

        //4.释放资源
        sqlSession.close();
    }








}
