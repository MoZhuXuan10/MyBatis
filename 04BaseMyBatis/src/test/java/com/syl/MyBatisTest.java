package com.syl;

import com.syl.bean.Student;
import com.syl.dao.StudentDao;
import com.syl.util.SessionFactoryUtil;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
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
//使用map 查询 姓名中带  嘿 ，年龄大于1 的 学生信息
@Test
public  void  testMap(){
    //创建一个map
    Map<String,Object> map=new HashMap<String, Object>();
    map.put("stuName","嘿");
    map.put("stuAge",1);
    List<Student> students = dao.selectStduentsByMap(map);
    log.debug(students);
}
    //使用map 查询 姓名中带  嘿 ，年龄大于1并且id 大于呼啦id的 学生信息
    @Test
    public  void  testMap2(){
        //创建一个map
        Map<String,Object> map=new HashMap<String, Object>();
        map.put("stuName","嘿");
        map.put("stuAge",1);
        /**
         *  id大于呼啦id
         *  模拟一个呼啦！ 应该是从数据库中查询
         */
        Student stu=new Student();
        stu.setId(1);
        stu.setName("小白");
        map.put("student",stu);
        //执行sql
        List<Student>  students=dao.selectStduentsByMap(map);
        log.debug(students);
    }
    @Test
    public  void  testCondition(){
        /**
         * 模拟从前台获取用户的输入
         * 嘿和1都是 用户前台的输入
         */
        List<Student> students = dao.selectStduentsByCondition("嘿", 1);
        log.debug(students);
    }
    //使用map 查询 姓名中带  嘿 ，年龄大于1 的 学生信息
    @Test
    public void testIf(){
        Student  student=new Student();
        //01.用户什么属性都没有赋值
        //02.用户传递了name       student.setName("嘿");
        //03.用户传递了age         student.setAge(1);
        //04.name和age都进行了赋值
        student.setName("嘿");
        student.setAge(1);
        List<Student> students = dao.selectStudentsByIf(student);
        log.debug(students);
    }
    /**
     * 使用where
     */
    @Test
    public  void  testWhere(){
        Student  student=new Student();
        //01.用户什么属性都没有赋值
        //02.用户传递了name       student.setName("嘿");
        //03.用户传递了age         student.setAge(1);
        //04.name和age都进行了赋值
        student.setName("嘿");
        student.setAge(1);
        List<Student> students = dao.selectStudentsByWhere(student);
        log.debug(students);
    }
    /**
     * choose的使用
     */
    @Test
    public void testChoose(){
        Student  student=new Student();
        //01.name属性不为空 按照name查询 student.setName("嘿");
        //02. age属性不为空 按照age查询 student.setAge(1);
        //03.两个属性都有值  student.setName("嘿");    student.setAge(1);
        //04.两个属性都没有值
        List<Student> students = dao.selectStudentsByChoose(student);
        log.debug(students);
    }
    /**
     * foreach 遍历数组
     */
    @Test
    public  void  testArrayForeach(){
        int [] nums={1,2,3};
        List<Student> students = dao.selectStudentsByForeachArray(nums);
        log.debug(students);
    }
    /**
     * foreach 遍历List
     */
    @Test
    public  void  testListForeach(){
        List<Integer> list=new ArrayList<Integer>();
        list.add(1);
        list.add(2);
        list.add(3);
        List<Student> students = dao.selectStudentsByForeachList(list);
        log.debug(students);
    }
    /**
     * foreach 遍历对象集合
     */
    @Test
    public  void  testStudentForeach(){
        List<Student> list=new ArrayList<Student>();
        list.add(new Student(1));
        list.add(new Student(2));
        list.add(new Student(3));
        List<Student> students = dao.selectStudentsByForeachStudent(list);
        log.debug(students);
    }
    /**
     * foreach 遍历Map集合
     */
    @Test
    public  void  testMapForeach(){
        Map<String, Object> map=new HashMap<String, Object>();
        map.put("1","object1");
        map.put("2","object2");
        map.put("3","object3");
        List<Student> students = dao.selectStudentsByForeachMap(map);
        log.debug(students);
    }
}
