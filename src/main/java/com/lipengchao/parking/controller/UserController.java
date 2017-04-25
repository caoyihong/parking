package com.lipengchao.parking.controller;

import com.lipengchao.parking.entity.UserInfo;
import com.lipengchao.parking.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by teli on 2017/2/13.
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/showUser")
    public String showUserList(HttpServletRequest request, Model model){
        Long userId = Long.parseLong(request.getParameter("userId"));
        UserInfo userInfo = userService.getUserById(userId);
        model.addAttribute("user", userInfo);
        return "showUser";
    }

    @ResponseBody
    @RequestMapping("/userRegister")
    public void userRegister(String userName, String password) throws Exception{
        try{
            userService.userRegister(userName, password);
        }catch (Exception e){
            throw new Exception("服务器出错，请稍后重试");
        }
    }
    @ResponseBody
    @RequestMapping("/userLogin")
    public UserInfo userLogin(String userName, String password, Integer height, Integer weight) throws Exception{
        try{
            UserInfo userInfo = userService.userLogin(userName,password, height, weight);
            if (userInfo == null){
                throw new Exception("账号不存在");
            }
            return userInfo;
        }catch (Exception e){
            throw new Exception("账号或密码错误");
        }
    }
}
