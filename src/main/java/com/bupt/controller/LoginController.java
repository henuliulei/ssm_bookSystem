package com.bupt.controller;

import com.bupt.pojo.Book;
import com.bupt.pojo.Pagination;
import com.bupt.pojo.User;
import com.bupt.service.LoginService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Controller

//@ResponseBody
public class LoginController {

    @Resource(name = "LoginServiceImpl")
    private LoginService loginService;

    @CrossOrigin
    @ResponseBody
    @PostMapping("/login/{username}/{password}")
    public String judgeLogin1(@PathVariable("username") String username, @PathVariable("password") String password) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        int i = loginService.loginNum(username, password);
        String str = String.valueOf(i);
        String s = objectMapper.writeValueAsString(str);
        return s;
    }

    @CrossOrigin
    @ResponseBody
    @PostMapping("/register/{username}/{password}/{password1}/{email}/{mobile}")
    public String register(@PathVariable("username") String username, @PathVariable("password") String password, @PathVariable("password1") String password1, @PathVariable("email") String email, @PathVariable("mobile") String mobile) throws JsonProcessingException {

        String msg = "";
        if (!password.equals(password1)) {
            msg = "注册失败，密码不一致";
            return msg;
        }
        int num = loginService.UserNum(username);
        if (num > 0) {
            msg = "注册失败，已有该用户";
            return msg;
        }
        if (num == 0 && password.equals(password1)) {
            int i = loginService.addUser(username, password, email, mobile);
            System.out.println(i);
            if (i > 0) {
                msg = "注册成功";
                return msg;
            }
        }
        return "注册失败";
    }

    @CrossOrigin
    @ResponseBody
    @GetMapping("/users/{query}/{pagenum}/{pagesize}")
    public String getUserList(@PathVariable("query") String query, @PathVariable("pagenum") int pagenum, @PathVariable("pagesize") int pagesize) throws JsonProcessingException {

        ObjectMapper objectMapper = new ObjectMapper();
        Pagination pagination = new Pagination();
        ArrayList<User> users = new ArrayList<>();
        System.out.println(query + pagenum + pagesize);
        String like = "";

        like = "%" + query + "%";

        int start = (pagenum - 1) * pagesize;
        int offset = pagesize;

        pagination.setLike(like);
        pagination.setStart(start);
        pagination.setOffest(offset);
        System.out.println(pagination);
        users = (ArrayList<User>) this.loginService.getUserList(pagination);
        String s = objectMapper.writeValueAsString(users);
        System.out.println(users);
        return s;

    }

    @CrossOrigin
    @ResponseBody
    @GetMapping("/usersall/{pagenum}/{pagesize}")
    public String getUserListAll(@PathVariable("pagenum") int pagenum, @PathVariable("pagesize") int pagesize) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        ArrayList<User> users = new ArrayList<>();
        int start = (pagenum - 1) * pagesize;
        int offset = pagesize;
        System.out.println(start + " " + offset);

        users = (ArrayList<User>) this.loginService.getUserListAll(start, offset);
        System.out.println("查询成功");
        System.out.println(users);
        String s = objectMapper.writeValueAsString(users);

        return s;
    }

    @CrossOrigin
    @ResponseBody
    @GetMapping("/userstotal/{query}")
    public int getUserListNum(@PathVariable("query") String query) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        int total;
        Pagination pagination = new Pagination();
        ;
        String like = "";
        if (query != " ") {
            like = "%" + query + "%";
        } else {
            like = "";
        }

        pagination.setLike(like);

        System.out.println(pagination);
        if (like.equals("")) {

        } else {
            total = this.loginService.getUserListNum(pagination);
            System.out.println(total);
            return total;
        }
        return -1;
    }

    @CrossOrigin
    @ResponseBody
    @GetMapping("/usersalltotal")
    public int getUserListAllNum() throws JsonProcessingException {
        int total;
        total = this.loginService.getUserListAllNum();
        System.out.println(total);
        return total;
    }

    @CrossOrigin
    @ResponseBody
    @GetMapping("/getuserbyname/{username}")
    public User getUserByName(@PathVariable("username") String username) {
        User userByName = this.loginService.getInfoByName(username);
        System.out.println(userByName);
        return userByName;
    }

    @CrossOrigin
    @ResponseBody
    @PutMapping("/updateuserbyname/{username}/{password}/{email}/{mobile}")
    public int updateUserByName(@PathVariable("username") String username, @PathVariable("password") String password, @PathVariable("email") String email, @PathVariable("mobile") String mobile) {
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        user.setEmail(email);
        user.setMobile(mobile);
        int i = this.loginService.updateUserByName(user);
        return i;
    }

    @CrossOrigin
    @ResponseBody
    @DeleteMapping("/deleteuserbyname/{username}/{pagenum}/{pagesize}")
    public String deleteUserByName(@PathVariable("username") String name, @PathVariable("pagenum") int pagenum, @PathVariable("pagesize") int pagesize) throws JsonProcessingException {

        System.out.println(name);
        int i = this.loginService.deleteUserByName(name);
        ObjectMapper objectMapper = new ObjectMapper();

        ArrayList<User> users = new ArrayList<>();
        int start = (pagenum - 1) * pagesize;
        int offset = pagesize;

        if (i == 1) {
            users = (ArrayList<User>) this.loginService.getUserListAll(start, offset);

        }
        String s = objectMapper.writeValueAsString(users);
        return s;
    }

    @CrossOrigin
    @ResponseBody
    @PutMapping("/updateuserbyname/{username}/{role}")
    public int updateRoleByName(@PathVariable("username") String username, @PathVariable("role") String role) {
        int i = this.loginService.updateRoleByName(username, role);
        return i;
    }

    @CrossOrigin
    @ResponseBody
    @GetMapping("/getAllBook/{pagenum}/{pagesize}")
    public List<Book> getAllBook(@PathVariable("pagenum") int pagenum, @PathVariable("pagesize") int pagesize) {

        ArrayList<Book> books;
        int start = (pagenum - 1) * pagesize;
        int offset = pagesize;
        books = (ArrayList<Book>) this.loginService.getAllBook(start, offset);
        return books;
    }

    @CrossOrigin
    @ResponseBody
    @GetMapping("/getBookNum")
    public int getBookListAllNum() throws JsonProcessingException {
        int total;
        total = this.loginService.getBookListAllNum();
        return total;
    }


}
