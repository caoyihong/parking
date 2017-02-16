package com.lipengchao.parking.controller;

import com.lipengchao.parking.service.ParkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * Created by Administrator on 2017/2/15.
 */
@Controller
@RequestMapping("/park")
public class ParkController {

    @Autowired
    ParkService parkService;

    @RequestMapping("/parkInfo")
    public String parkInfo(HttpServletRequest request, Model model){
        String strParkId = request.getParameter("parkId");
        Long parkId = 1l;
        if (parkId != null){
            parkId = Long.valueOf(strParkId);
        }
        Map parkInfo = parkService.parkInfo(parkId);
        model.addAttribute("parkInfo", parkInfo);
        return "park/parkInfo";
    }
}
