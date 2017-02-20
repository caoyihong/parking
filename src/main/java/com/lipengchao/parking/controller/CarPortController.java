package com.lipengchao.parking.controller;

import com.lipengchao.parking.service.CarPortService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

/**
 * Created by Administrator on 2017/2/15.
 */
@Controller
@RequestMapping("/carPort")
public class CarPortController {

    @Autowired
    CarPortService carPortService;
    /**
     * 指定的车位信息:若该车位
     * @param carPortId
     * @param model
     * @return
     */
    @RequestMapping("/carPortInfo/{carPortId}")
    public String carPortInfo(@PathVariable("carPortId") Long carPortId, Model model){
        Map map = carPortService.getCarPortInfo(carPortId);
        model.addAttribute("carPortInfo", map);
        return "";
    }
}
