package com.bupt.dao;

import com.bupt.pojo.Book;
import com.bupt.pojo.Pagination;
import com.bupt.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface LoginMapper {

    //登入验证,
    int loginNum(@Param("username") String username, @Param("password") String password);

    //验证该用户名是否已经注册
    int UserNum(@Param("username") String username);

    //注册新用户
    int addUser(@Param("username") String username, @Param("password") String password, @Param("email") String email, @Param("mobile") String mobile);

    //模糊查寻用户信息
    List<User> getUserList(Pagination pagination);

    //查寻所有用户信息
    List<User> getUserListAll(@Param("start") int start, @Param("offset") int offset);

    //查询满足模糊查询条件的用户数目
    int getUserListNum(Pagination pagination);

    //查询全部用户总数
    int getUserListAllNum();

    //用户页面插入新增用户
    User getInfoByName(String username);

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
