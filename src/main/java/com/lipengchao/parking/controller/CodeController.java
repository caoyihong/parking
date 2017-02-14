package com.lipengchao.parking.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by teli on 2017/2/14.
 */
@Controller
@RequestMapping("/code")
public class CodeController {

    /**
     * 获取停车场信息二维码
     * @param request
     */
    @RequestMapping("/parkcode")
    public void parkCode(HttpServletRequest request){

    }
}
