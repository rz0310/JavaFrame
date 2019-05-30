package com.mybatis.domain;

import java.util.List;

/*User实体类的包装类*/
public class UserQueryVo {
    private User user;

    private List list;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List getList() {
        return list;
    }

    public void setList(List list) {
        this.list = list;
    }
}
