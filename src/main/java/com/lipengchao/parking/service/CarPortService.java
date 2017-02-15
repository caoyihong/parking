package com.lipengchao.parking.service;

import com.lipengchao.parking.dao.CarMapper;
import com.lipengchao.parking.dao.CarportMapper;
import com.lipengchao.parking.dao.ParkingInfoMapper;
import com.lipengchao.parking.entity.Car;
import com.lipengchao.parking.entity.Carport;
import com.lipengchao.parking.entity.ParkingInfo;
import com.lipengchao.parking.entity.ParkingInfoExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/2/15.
 */
@Service
public class CarPortService {

    @Autowired
    CarportMapper carportMapper;
    @Autowired
    ParkingInfoMapper parkingInfoMapper;
    @Autowired
    CarMapper carMapper;

//    获取指定车位信息 若该车位停车 则显示该车信息
    public Map getCarPortInfo(Long carPortId){
        Carport carport =  carportMapper.selectByPrimaryKey(carPortId);
        Map result = new HashMap();
        result.put("id",carport.getId());
        result.put("info",carport.getInfo());
        result.put("status", carport.getStatus());
        if (carport.getStatus().intValue() == 1){
            ParkingInfoExample parkingInfoExample = new ParkingInfoExample();
            ParkingInfoExample.Criteria criteria = parkingInfoExample.createCriteria();
            criteria.andCarportIdEqualTo(carPortId);
            criteria.andStatusEqualTo((byte)1);
            List<ParkingInfo> parkingInfos = parkingInfoMapper.selectByExample(parkingInfoExample);
            ParkingInfo parkingInfo = parkingInfos.get(0);
            parkingInfo.setLeaveTime(new Date());
            Long duration = parkingInfo.getArriveTime().getTime() - parkingInfo.getLeaveTime().getTime();
            parkingInfo.setDuration(duration);
            parkingInfo.setExpense(duration/360000);//截止当前时间 供展示使用
            Car car = carMapper.selectByPrimaryKey(parkingInfo.getCarId());

            result.put("arriveTime", parkingInfo.getArriveTime());
            result.put("duration", parkingInfo.getDuration());
            result.put("expense", parkingInfo.getExpense());
            result.put("carName", car.getCarName());
            result.put("carInfo", car.getInfo());
        }
        return result;
    }
}
