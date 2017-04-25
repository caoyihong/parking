package com.lipengchao.parking.service;

import com.lipengchao.parking.dao.UserInfoMapper;
import com.lipengchao.parking.entity.UserInfo;
import com.lipengchao.parking.entity.UserInfoExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


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
    public void userRegister(String userName, String password){
        UserInfo userInfo = new UserInfo();
        userInfo.setUserName(userName);
        userInfo.setPassword(password);
        userInfoMapper.insertSelective(userInfo);
    }
    public UserInfo userLogin(String userName, String password, Integer height, Integer weight){
        UserInfoExample userInfoExample = new UserInfoExample();
        UserInfoExample.Criteria criteria = userInfoExample.createCriteria();
        criteria.andUserNameEqualTo(userName);
        criteria.andPasswordEqualTo(password);
        List<UserInfo> userInfos = userInfoMapper.selectByExample(userInfoExample);
        if (userInfos != null && userInfos.size() > 0){
            UserInfo userInfo = userInfos.get(0);
            if (height != null || weight != null){
                UserInfo updateUser = new UserInfo();
                updateUser.setId(userInfo.getId());
                if (height != null){
                    userInfo.setHeight(height);
                    updateUser.setHeight(height);
                }
                if (weight != null){
                    userInfo.setWeight(weight);
                    updateUser.setWeight(weight);
                }
                userInfoMapper.updateByPrimaryKeySelective(updateUser);//更新身高体重
            }
            return userInfo;
        }else {
            return null;
        }
    }
}
