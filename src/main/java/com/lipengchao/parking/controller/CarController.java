package com.lipengchao.parking.controller;

import com.lipengchao.parking.entity.ParkingInfo;
import com.lipengchao.parking.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Administrator on 2017/2/15.
 */
@Controller
@RequestMapping("/car")
public class CarController {

    @Autowired
    CarService carService;
    /**
     * 停车 开始计时
     * @param request
     * @param model
     * @return
     */
    @RequestMapping("/parking")
    public String parking(HttpServletRequest request, Model model){
        Long carPortId = Long.valueOf(request.getParameter("carPortId"));//车位ID
        Long carId = Long.valueOf(request.getParameter("carId"));//车ID
        Integer result = carService.parking(carId, carPortId);
        model.addAttribute("result", result);
        return "success";
    }

    /**
     * 取车
     * @param request
     * @param model
     * @return
     */
    @RequestMapping("/taking")
    public String taking(HttpServletRequest request, Model model){
        Long carPortId = Long.valueOf(request.getParameter("carPortId"));//车位id
        Long carId = Long.valueOf(request.getParameter("carId"));//车ID
        ParkingInfo parkingInfo = carService.taking(carId, carPortId);
        model.addAttribute("parkingInfo", parkingInfo);
        return "success";
    }

}
