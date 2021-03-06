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
}
