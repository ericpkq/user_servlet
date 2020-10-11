package com.cs.service;

import com.cs.entity.User;

import java.util.List;

public interface UserService {

    //查询数据的总记录数
    public int findByCountUser()throws Exception;

    //分页方法
    public List<User> findByPageUserInfo(int pageNo, int pageSize) throws Exception;

    //根据id查询
    public User findByUserIDi(int id) throws Exception;

    //根据id删除
    public boolean delUser(int id)throws Exception;

    //根据id修改
    public boolean updateUser(User us) throws Exception;
}
