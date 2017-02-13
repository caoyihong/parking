package com.lipengchao.parking.dao;

import com.lipengchao.parking.entity.Carport;
import com.lipengchao.parking.entity.CarportExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CarportMapper {
    int countByExample(CarportExample example);

    int deleteByExample(CarportExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Carport record);

    int insertSelective(Carport record);

    List<Carport> selectByExample(CarportExample example);

    Carport selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Carport record, @Param("example") CarportExample example);

    int updateByExample(@Param("record") Carport record, @Param("example") CarportExample example);

    int updateByPrimaryKeySelective(Carport record);

    int updateByPrimaryKey(Carport record);
}