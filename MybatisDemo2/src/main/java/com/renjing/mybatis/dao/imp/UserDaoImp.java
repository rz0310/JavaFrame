package com.renjing.mybatis.dao.imp;

import com.renjing.mybatis.dao.UserDao;
import com.renjing.mybatis.po.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class UserDaoImp implements UserDao {
    private SqlSessionFactory sqlSessionFactory;

    public UserDaoImp(SqlSessionFactory sqlSessionFactory) {
        this.sqlSessionFactory = sqlSessionFactory;
    }

    @Override
    public User findUserById(Integer id) {
//        开启一个会话
        SqlSession sqlSession = sqlSessionFactory.openSession();
//        执行操作
        User user = sqlSession.selectOne("userMapper.findUserById",id);
//        提交事务
        sqlSession.commit();
//        关闭资源
        sqlSession.close();
        return user;
    }

    @Override
    public void insertUser(User user) throws IOException {
        //        开启一个会话
        SqlSession sqlSession = sqlSessionFactory.openSession();
//        执行操作
        sqlSession.insert("userMapper.findUserById",user);
//        提交事务
        sqlSession.commit();
//        关闭资源
        sqlSession.close();
    }

    @Override
    public void deleteUser(Integer id) throws IOException {
//        开启一个会话
        SqlSession sqlSession = sqlSessionFactory.openSession();
//        执行操作
        sqlSession.delete("userMapper.findUserById",id);
//        提交事务
        sqlSession.commit();
//        关闭资源
        sqlSession.close();
    }
    /*@Override
    public User findUserById(int id) throws IOException {
        User user = null;
//        加载配置文件，转换成输入流
        InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
//        根据配置文件的输入流构造一个sql会话工厂
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
//        打开一个会话
        SqlSession session = sqlSessionFactory.openSession();
//        查询单个对象，指定参数为3
        user = session.selectOne("userMapper.findUserById",id);
//        关闭会话
        session.close();
        return user;
    }
    public void findUserById(int id) throws IOException {
//        mybatis配置文件
        String resource = "mybatis-config.xml";
//        得到配置文件流
        InputStream inputStream = Resources.getResourceAsStream(resource);
//        创建会话工厂，传入mybatis的配置文件信息
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
//        通过工厂得到sqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();
//        通过sqlSession操作数据库
//        第一个参数：映射文件中statement的id，等于namespace+"."+statement的id
//        第二个参数：指定和映射文件中所匹配的parameterType类型的参数
//        sqlSession.selectOne结果是与映射文件中所匹配的resultType类型的对象
        User user = sqlSession.selectOne("userMapper.findUserById",1);
        System.out.println(user);
//        释放资源
        sqlSession.close();
    }

    @Override
    public void findUserByName(String name) throws IOException {
//        mybatis配置文件
        String resource = "mybatis-config.xml";
//        得到配置文件流
        InputStream inputStream = Resources.getResourceAsStream(resource);
//        创建会话工厂，传入mybatis的配置文件信息
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
//        通过工厂得到sqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();
//        list中的user和映射文件中的resultType所指定的类型一致
        List<Object> list = sqlSession.selectList("userMapper.findUserByName", name);
        System.out.println(list);
        sqlSession.close();
    }

    @Override
    public void insertUser(User user) throws IOException {
//        mybatis配置文件
        String resource = "mybatis-config.xml";
//        得到配置文件流
        InputStream inputStream = Resources.getResourceAsStream(resource);
//        创建会话工厂，传入mybatis的配置文件信息
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
//        通过工厂得到sqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();
        sqlSession.insert("userMapper.insertUser",user);

//        提交事务
        sqlSession.commit();
//        关闭会话
        sqlSession.close();
    }

    @Override
    public void deleteUser(Integer id) throws IOException {
//        mybatis配置文件
        String resource = "mybatis-config.xml";
//        得到配置文件流
        InputStream inputStream = Resources.getResourceAsStream(resource);
//        创建会话工厂，传入mybatis的配置文件信息
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
//        通过工厂得到sqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();
//        执行操作
        sqlSession.delete("userMapper.deleteUser", id);
//        提交事务
        sqlSession.commit();
//        关闭会话
        sqlSession.close();
    }

    @Override
    public void updateUser(User user) throws IOException {
//        mybatis配置文件
        String resource = "mybatis-config.xml";
//        得到配置文件流
        InputStream inputStream = Resources.getResourceAsStream(resource);
//        创建会话工厂，传入配置文件流
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
//        通过工厂得到会话
        SqlSession sqlSession = sqlSessionFactory.openSession();
//        执行操作
        sqlSession.update("userMapper.updateUser", user);
//        提交事务
        sqlSession.commit();
//        关闭会话
        sqlSession.close();
    }*/

}
