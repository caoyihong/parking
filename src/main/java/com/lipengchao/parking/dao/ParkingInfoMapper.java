package com.lipengchao.parking.dao;

import com.lipengchao.parking.entity.ParkingInfo;
import com.lipengchao.parking.entity.ParkingInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ParkingInfoMapper {
    int countByExample(ParkingInfoExample example);

    int deleteByExample(ParkingInfoExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ParkingInfo record);

    int insertSelective(ParkingInfo record);

    List<ParkingInfo> selectByExample(ParkingInfoExample example);

    ParkingInfo selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ParkingInfo record, @Param("example") ParkingInfoExample example);

    int updateByExample(@Param("record") ParkingInfo record, @Param("example") ParkingInfoExample example);

    int updateByPrimaryKeySelective(ParkingInfo record);

    int updateByPrimaryKey(ParkingInfo record);
}