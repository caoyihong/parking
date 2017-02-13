package com.lipengchao.parking.service;

import com.lipengchao.parking.dao.UserInfoMapper;
import com.lipengchao.parking.entity.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * Created by teli on 2017/2/13.
 */
@Service
public class UserService {

    @Autowired
    UserInfoMapper userInfoMapper;

    public void insertUser(UserInfo userInfo){
        userInfoMapper.insertSelective(userInfo);
    }

    public UserInfo getUserById(Long userId){
        UserInfo userInfo = userInfoMapper.selectByPrimaryKey(userId);
        return userInfo;
    }
}
