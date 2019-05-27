<%@ page import="java.io.InputStream" %>
<%@ page import="org.apache.ibatis.io.Resources" %>
<%@ page import="org.apache.ibatis.session.SqlSessionFactory" %>
<%@ page import="org.apache.ibatis.session.SqlSessionFactoryBuilder" %>
<%@ page import="org.apache.ibatis.session.SqlSession" %>
<%@ page import="com.mybatis.dao.IUserDao" %>
<%@ page import="com.mybatis.domain.User" %>
<%@ page import="java.util.List" %>
<html>
<body>
<h2>Hello World!</h2>
<%
    String resource = "SqlMapConfig.xml";
    InputStream inputStream = Resources.getResourceAsStream(resource);
    SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    SqlSession sqlSession = sqlSessionFactory.openSession();
    IUserDao userDao = sqlSession.getMapper(IUserDao.class);
    List<User> userList = userDao.findAll();
    System.out.println(userList);
    inputStream.close();
    sqlSession.close();
%>
</body>
</html>
