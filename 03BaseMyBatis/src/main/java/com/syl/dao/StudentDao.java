package com.syl.dao;

import com.syl.bean.Student;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public interface StudentDao {
    /**
     *   新增
     */
    void  addStudent(Student student);
    /**
     * 新增并且获取新增对象的id
     */
    void addStudentByCache(Student student);
    /**
     * 删除
     */
    void deleteStudent(Serializable id);
    /**
     * 修改
     */
    void updateStudent(Student student);
    /**
     * 查询所有
     */
    List<Student> selectAllStudents();
    /**
     * 查询所有,返回map集合
     */
    List<Map<String, Object>> selectAllByMap();
    /**
     * 查询指定id的学生
     */
    Student selectStudentById(Serializable id);
    /**
     * 根据姓名模糊查询
     */
    List<Student> selectByName(String name);
    /**
     * 如果前台表单中给出的查询条件不能封装成一个对象的时候，
     * 我们可以使用两种方式来解决这个问题！
     *
     * 第一种方式
     *   01.把查询条件 封装成map
     *    使用map 查询 姓名中带  小  并且年龄大于1的学生信息
     *
     *   02.使用map 查询 姓名中带  小 ，年龄大于1 并且id 大于小白id的 学生信息
     */
    List<Student> selectStduentsByMap(Map<String,Object> map);
    /**
     * 第二种方式
     *   查询 姓名中带  小  并且年龄大于1的学生信息
     */
    List<Student> selectStduentsByCondition(String name,int age);
}
