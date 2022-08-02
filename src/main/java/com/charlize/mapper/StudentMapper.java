package com.charlize.mapper;

import com.charlize.pojo.Student;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;
public interface StudentMapper {


    List<Student> selectAllStudent();
    Student selectById(int sNo);

    /**
     * 三种参数传递方式
     */
    /*List<Student> selectByCondition(@Param("age") int age, @Param("sName") String sName);*/
    //List<Student>  selectByCondition(Student student);
    List<Student>  selectByCondition(Map map);









}
