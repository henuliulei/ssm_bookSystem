package com.bupt.service;

import com.bupt.dao.LoginMapper;
import com.bupt.pojo.Book;
import com.bupt.pojo.Pagination;
import com.bupt.pojo.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

@Component("LoginServiceImpl")
public class LoginServiceImpl implements LoginService {

    @Resource(name = "loginMapper")
    private LoginMapper loginMapper;

    public void setLoginMapper(LoginMapper loginMapper) {
        this.loginMapper = loginMapper;
    }

    @Override
    public int loginNum(@Param("username") String username, @Param("password") String password) {
        return this.loginMapper.loginNum(username, password);
    }

    @Override
    public int addUser(@Param("username") String username, @Param("password") String password, @Param("email") String email, @Param("mobile") String mobile) {
        return this.loginMapper.addUser(username, password, email, mobile);
    }

    @Override
    public int UserNum(String username) {
        return this.loginMapper.UserNum(username);
    }

    @Override
    public List<User> getUserList(Pagination pagination) {
        return this.loginMapper.getUserList(pagination);
    }

    @Override
    public List<User> getUserListAll(@Param("start") int start, @Param("offset") int offset) {
        return this.loginMapper.getUserListAll(start, offset);
    }

    @Override
    public int getUserListNum(Pagination pagination) {
        return this.loginMapper.getUserListNum(pagination);
    }

    @Override
    public int getUserListAllNum() {
        return this.loginMapper.getUserListAllNum();
    }

    @Override
    public User getInfoByName(@Param("username") String username) {
        return this.loginMapper.getInfoByName(username);
    }

    @Override
    public int updateUserByName(User user) {

        return this.loginMapper.updateUserByName(user);
    }

    @Override
    public int deleteUserByName(String name) {
        return this.loginMapper.deleteUserByName(name);
    }

    @Override
    public int updateRoleByName(String name, String role) {
        return this.loginMapper.updateRoleByName(name, role);
    }

    @Override
    public List<Book> getAllBook(@Param("start") int start, @Param("offset") int offset) {
        System.out.println("start" + start);
        System.out.println("offset" + offset);
        return this.loginMapper.getAllBook(start, offset);
    }

    @Override
    public int getBookListAllNum() {
        return this.loginMapper.getBookListAllNum();
    }
}
