package com.lipengchao.parking.service;

import com.lipengchao.parking.dao.CarportMapper;
import com.lipengchao.parking.dao.ParkMapper;
import com.lipengchao.parking.entity.Carport;
import com.lipengchao.parking.entity.CarportExample;
import com.lipengchao.parking.entity.Park;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/2/15.
 */
@Service
public class ParkService {

    @Autowired
    ParkMapper parkMapper;
    @Autowired
    CarportMapper carportMapper;
//获取停车场信息及该停车场内车位信息
    public Map parkInfo(Long parkId){
        Park park = parkMapper.selectByPrimaryKey(parkId);
        CarportExample carportExample = new CarportExample();
        CarportExample.Criteria criteria = carportExample.createCriteria();
        criteria.andParkIdEqualTo(parkId);
        List<Carport> carports = carportMapper.selectByExample(carportExample);
        Map<String, Object> result = new HashMap();
        result.put("park", park);
        result.put("carports", carports);
        return result;
    }
}
