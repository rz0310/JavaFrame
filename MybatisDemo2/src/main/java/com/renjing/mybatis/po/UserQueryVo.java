package com.renjing.mybatis.po;

import java.util.List;

/*
包装类型
* */
public class UserQueryVo {
//    添加一个用来保存id属性的集合
    private List<Integer> idList;

//    在这里包装需要的查询条件

//    用户查询条件
    private UserCustomer userCustomer;

    public List<Integer> getIdList() {
        return idList;
    }

    public void setIdList(List<Integer> idList) {
        this.idList = idList;
    }

    public UserCustomer getUserCustomer() {
        return userCustomer;
    }

    public void setUserCustomer(UserCustomer userCustomer) {
        this.userCustomer = userCustomer;
    }

    //    可以包装其他的查询条件，订单、商品

}
