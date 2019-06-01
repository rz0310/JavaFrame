package com.renjing.mybatis.mapper;

/*mapper接口，相当于dao，用户管理
*
* 开发规范：
* (1)在mapper.xml中namespace等于mapper的接口地址。
* (2)com.renjing.mybatis.mapper.java接口中的方法名与mapper.xml中statement的id一致。
* (3)com.renjing.mybatis.mapper.java接口中的方法的输入参数类型与mapper.xml中statement的ParameterType一致。
* (4)com.renjing.mybatis.mapper.java接口中的方法的返回值类型与mapper.xml中statement的ResultType类型一致。
* */

import com.renjing.mybatis.po.User;
import com.renjing.mybatis.po.UserCustomer;
import com.renjing.mybatis.po.UserQueryVo;

import java.util.List;
/*
* 系统框架中，dao层的代码是被业务层公用的。
* 即使mapper接口只有一个参数，可以使用包装类型的pojo满足不同的业务方法满足不同的业务方法的需求。
*
* 注意：持久层方法的参数可以是包装类型(map等)，service方法中建议不要使用包装类型(不利于业务层的可扩展)
* */
public interface UserMapper {
//    根据id查找
    public User findUserById(Integer id);
//    根据id查找使用resultMap作为输出类型
    public User findUserByIdResultMap(int id);
//    根据name查找，支持模糊查询
    public List<User> findUserByName(String name);
//    根据username和password模糊查询
    public List<UserCustomer> findUserList(UserQueryVo userQueryVo);
    public Integer findUserCount(UserQueryVo userQueryVo);
//    插入用户
    public boolean insertUser(User user);
//    根据id删除用户
    public boolean deleteUser(int id);
}
