package com.syl;

import com.syl.bean.Student;
import com.syl.dao.StudentDao;
import com.syl.util.SessionFactoryUtil;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.Map;


public class MyBatisTest {

    StudentDao dao=null;
    SqlSession session=null;
    Logger log=Logger.getLogger(MyBatisTest.class);

    /**
     * 在所有的test测试方法执行之前 都要执行的操作
     */
    @Before
    public void before(){
        //获取session
        session= SessionFactoryUtil.getSession();
        dao=session.getMapper(StudentDao.class);//获取执行的类对象
    }
    @After
    public void after(){
        if(session!=null){
            session.close();
        }
    }

    /**
     * 新增学生信息到数据库
     */

    @Test
    public   void  testAddStudent(){
        Student student=new Student(2,"春天");
        //log.debug("insert之前学生的编号："+student.getId());
        dao.addStudent(student);
        session.commit();
        /**
         * 我们现在的新增对象中 只有age和name
         * id是mysql数据库给我们生成的
         * 你没有去mysql数据库中查询！
         * id肯定沒值！
         */
        //log.debug("insert之后学生的编号："+student.getId());
    }
/**
 * 我们需要新增对象之后，接着对这个对象进行操作
 * 上面的新增方法能实现吗？
 * 怎么办？
 * 有一种方式 是在insert节点中新增一个selectkey节点
 * 在我们新增完对象之后，连接没有立即放回连接池中，
 * 而是接着查询数据库中 刚刚插入数据的id
 * 这样id我们就能获取了！
 */
@Test
    public void addStudentByCache(){
    Student student=new Student(11,"呼啦");
    log.debug("insert之前学生的编号:"+student.getId());
    dao.addStudentByCache(student);
    log.debug("insert之后学生的编号:"+student.getId());
    session.commit();
}
/**
 * 删除
 */
@Test
    public void delStudent(){
       dao.deleteStudent(10);
       session.commit();
}
/**
 * 修改
 */
@Test
    public void updateStudent(){
       Student student=new Student(3,1,"呼啦");
       dao.updateStudent(student);
       log.debug("修改之后的学生信息:"+student);
       session.commit();
}
/**
 * 查询所有 返回list
 */
@Test
    public void  listStudent(){
    List<Student> students=dao.selectAllStudents();
    log.debug(students);
}
/**
 * 查询所有,返回map
 */
@Test
    public void mapStudent(){
    List<Map<String,Object>> maps = dao.selectAllByMap();
    log.debug(maps);
}
/**
 * 根据id查询Student,返回Student对象
 */
@Test
    public void selectStudentById(){
    Student student = dao.selectStudentById(1);
    //获取一个对象
    log.debug(student);
}
/**
 * 根据姓名模糊查询
 */
@Test
    public void selectStudentByName(){
    List<Student> students = dao.selectByName("呼");
    //获取一个对象
    log.debug(students);
}
}
