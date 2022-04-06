package mapper;

import com.baomidou.mybatisplus.core.MybatisSqlSessionFactoryBuilder;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import config.MybatisPlusConfig;
import data.Student;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Project name(项目名称)：Mybatis_Plus实现查询操作之selectPage
 * Package(包名): mapper
 * Class(测试类名): StudentMapperTest
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/4/6
 * Time(创建时间)： 19:23
 * Version(版本): 1.0
 * Description(描述)： 测试类
 */

class StudentMapperTest
{

    /**
     * Select page.
     * 根据 entity 条件，查询全部记录（并翻页）
     *
     * @throws IOException the io exception
     */
    @Test
    public void selectPage() throws IOException
    {
        String resource = "mybatis-config.xml";
        //读取配置文件mybatis-config.xml
        InputStream config = Resources.getResourceAsStream(resource);
        //根据配置文件构建SqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new MybatisSqlSessionFactoryBuilder().build(config);
        //通过SqlSessionFactory创建SqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();
        StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);

        //current - 当前页
        //size - 每页显示条数
        Page<Student> page = new Page<>(2, 5);

        IPage<Student> selectPage = studentMapper.selectPage(page, null);

        System.out.println(selectPage.getSize());
        System.out.println(selectPage.getPages());
        System.out.println(selectPage.getTotal());
        System.out.println(selectPage.getCurrent());
        List<Student> list = selectPage.getRecords();
        for (Student student : list)
        {
            System.out.print(student);
        }
        System.out.println("一共" + list.size() + "条");

        sqlSession.close();
    }

    /**
     * Select page.
     * 根据 entity 条件，查询全部记录（并翻页）
     *
     * @throws IOException the io exception
     */
    @Test
    public void selectPage1() throws IOException
    {
        String resource = "mybatis-config.xml";
        //读取配置文件mybatis-config.xml
        InputStream config = Resources.getResourceAsStream(resource);
        //根据配置文件构建SqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new MybatisSqlSessionFactoryBuilder().build(config);
        //通过SqlSessionFactory创建SqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();
        StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);


        PageHelper.startPage(4, 5);
        List<Student> studentList = studentMapper.selectList(null);

        PageInfo<Student> pageInfo = new PageInfo<>(studentList);

        System.out.println(pageInfo.getPages());
        System.out.println(pageInfo.getSize());
        System.out.println(pageInfo.getPageNum());
        for (Student student : pageInfo.getList())
        {
            System.out.print(student);
        }
        System.out.println("一共" + pageInfo.getList().size() + "条");
    }
}