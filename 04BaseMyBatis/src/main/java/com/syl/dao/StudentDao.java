package com.syl.dao;

import com.syl.bean.Student;
import org.apache.ibatis.annotations.Param;

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

    /**
     * 动态查询
     */

    /**
     *  01.用户传递一个Student对象  但是我们不知道用户对那些属性赋了值
     */
    List<Student> selectStudentsByIf(Student student);
    /**
     * 02.where 标签 替换where 1=1
     */
    List<Student> selectStudentsByWhere(Student student);
    /**
     * 03.choose标签
     *  当我们的年龄不为空 按照年龄查询
     *  当我们的姓名不为空 按照姓名查询
     *  如果都会空 执行一个标签otherwise
     */
    List<Student> selectStudentsByChoose(Student student);
    /**
     * 04.foreach 遍历数组
     */
    List<Student> selectStudentsByForeachArray(int [] nums);
    /**
     * 05.foreach 遍历集合
     */
    List<Student> selectStudentsByForeachList(List<Integer> nums);
    /**
     * 06.foreach 遍历对象集合
     */
    List<Student> selectStudentsByForeachStudent(List<Student> students);
    /**
     * 07.foreach 遍历Map集合
     */
    List<Student> selectStudentsByForeachMap(@Param("myMap") Map<String,Object> map);
}
