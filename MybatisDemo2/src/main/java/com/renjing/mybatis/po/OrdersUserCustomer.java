package com.renjing.mybatis.po;

public class OrdersUserCustomer extends Orders {
    /*添加用户属性：user.username、user.password*/
    private String username;
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "OrdersUserCustomer{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
