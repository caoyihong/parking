package com.lipengchao.parking.dao;

import com.lipengchao.parking.entity.Park;
import com.lipengchao.parking.entity.ParkExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ParkMapper {
    int countByExample(ParkExample example);

    int deleteByExample(ParkExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Park record);

    int insertSelective(Park record);

    List<Park> selectByExample(ParkExample example);

    Park selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Park record, @Param("example") ParkExample example);

    int updateByExample(@Param("record") Park record, @Param("example") ParkExample example);

    int updateByPrimaryKeySelective(Park record);

    int updateByPrimaryKey(Park record);
}