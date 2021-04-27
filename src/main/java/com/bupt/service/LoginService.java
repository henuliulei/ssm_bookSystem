package com.bupt.service;

import com.bupt.pojo.Book;
import com.bupt.pojo.Pagination;
import com.bupt.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface LoginService {
    //登入验证
    int loginNum(@Param("username") String username, @Param("password") String password);

    //注册新用户
    int addUser(@Param("username") String username, @Param("password") String password, @Param("email") String email, @Param("mobile") String mobile);

    //验证该用户名是否已经注册
    int UserNum(@Param("username") String username);

    //模糊查寻用户信息
    List<User> getUserList(Pagination pagination);

    //查寻所有用户信息
    List<User> getUserListAll(@Param("start") int start, @Param("offset") int offset);

    //获取查询满足条件的用户的总数
    int getUserListNum(Pagination pagination);

    //查询全部用户总数
    int getUserListAllNum();

    //通过名字更新用户信息
    User getInfoByName(@Param("username") String username);

    //通过名字更新用户信息
    int updateUserByName(User user);

    //通过名字删除用户信息
    int deleteUserByName(String name);

    //通过名字更新用户角色信息
    int updateRoleByName(@Param("username") String name, @Param("role") String role);

    //查询所以书籍信息
    List<Book> getAllBook(@Param("start") int start, @Param("offset") int offset);

    //查询所有书籍数目
    int getBookListAllNum();
}
