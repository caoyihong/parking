package com.lipengchao.parking.controller;

import com.lipengchao.parking.entity.UserInfo;
import com.lipengchao.parking.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

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
}
