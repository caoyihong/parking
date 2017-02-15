package com.lipengchao.parking.service;

import com.lipengchao.parking.dao.CarMapper;
import com.lipengchao.parking.dao.CarportMapper;
import com.lipengchao.parking.dao.ParkingInfoMapper;
import com.lipengchao.parking.entity.Carport;
import com.lipengchao.parking.entity.ParkingInfo;
import com.lipengchao.parking.entity.ParkingInfoExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2017/2/15.
 */
@Service
public class CarService {

    @Autowired
    CarMapper carMapper;
    @Autowired
    CarportMapper carportMapper;
    @Autowired
    ParkingInfoMapper parkingInfoMapper;

//    停车
    public Integer parking(Long carId, Long carPortId){
        Carport carport = carportMapper.selectByPrimaryKey(carPortId);
        if (carport == null || carport.getStatus().intValue() == 1){//该车位不可用(被占用)
            return 2;
        }
//        将车位信息设为已使用
        carport.setStatus((byte)1);
        carport.setUpdateTime(new Date());
        carportMapper.updateByPrimaryKeySelective(carport);
//        添加一条停车信息并开始计费
        ParkingInfo parkingInfo = new ParkingInfo();
        parkingInfo.setCarId(carId);
        parkingInfo.setCarportId(carPortId);
        parkingInfo.setArriveTime(new Date());
        parkingInfo.setStatus((byte)1);
        parkingInfoMapper.insertSelective(parkingInfo);
        return 1;
    }
//    取车
    public ParkingInfo taking(Long carId, Long carPortId){
        Carport carport = new Carport();
        carport.setId(carId);
        carport.setStatus((byte)0);//将车位状态设为空
        carportMapper.updateByPrimaryKeySelective(carport);
        ParkingInfoExample parkingInfoExample = new ParkingInfoExample();
        ParkingInfoExample.Criteria criteria = parkingInfoExample.createCriteria();
        criteria.andCarIdEqualTo(carId);
        criteria.andCarportIdEqualTo(carPortId);
        criteria.andStatusEqualTo((byte)1);
        List<ParkingInfo> list = parkingInfoMapper.selectByExample(parkingInfoExample);
        ParkingInfo parkingInfo = new ParkingInfo();
        if (list != null && list.size() > 0){
            parkingInfo = list.get(0);
        }else {
            System.out.println("停车信息为空...");
            return null;
        }
        parkingInfo.setLeaveTime(new Date());
        Long duration = parkingInfo.getArriveTime().getTime() - parkingInfo.getLeaveTime().getTime();
        parkingInfo.setDuration(duration);
        parkingInfo.setExpense(duration/360000);//一小时10块钱
        parkingInfo.setStatus((byte)2);//计费结束
        parkingInfoMapper.updateByPrimaryKeySelective(parkingInfo);//更新停车信息
        return parkingInfo;
    }
}
