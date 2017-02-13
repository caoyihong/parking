/*
Navicat MySQL Data Transfer

Source Server         : 119
Source Server Version : 50713
Source Host           : 192.168.1.119:3306
Source Database       : parking

Target Server Type    : MYSQL
Target Server Version : 50713
File Encoding         : 65001

Date: 2017-02-10 11:05:08
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_car
-- ----------------------------
DROP TABLE IF EXISTS `t_car`;
CREATE TABLE `t_car` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) NOT NULL,
  `car_name` varchar(50) NOT NULL,
  `info` varchar(200) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `enabled` tinyint(4) DEFAULT '1',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Table structure for t_carport
-- ----------------------------
DROP TABLE IF EXISTS `t_carport`;
CREATE TABLE `t_carport` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `park_id` bigint(20) DEFAULT NULL,
  `info` varchar(200) DEFAULT NULL,
  `status` tinyint(4) DEFAULT '0',
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `enabled` tinyint(4) DEFAULT '1',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Table structure for t_park
-- ----------------------------
DROP TABLE IF EXISTS `t_park`;
CREATE TABLE `t_park` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `park_name` varchar(50) DEFAULT NULL,
  `info` varchar(200) DEFAULT NULL,
  `park_num` int(20) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `enabled` tinyint(4) DEFAULT '1',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Table structure for t_parkinginfo
-- ----------------------------
DROP TABLE IF EXISTS `t_parkinginfo`;
CREATE TABLE `t_parkinginfo` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `car_id` bigint(20) NOT NULL,
  `carport_id` bigint(20) NOT NULL,
  `arrive_time` datetime DEFAULT NULL,
  `leave_time` datetime DEFAULT NULL,
  `duration` bigint(50) DEFAULT NULL,
  `expense` bigint(50) DEFAULT NULL,
  `status` tinyint(4) DEFAULT '1' COMMENT '记录停车信息 1 正在停车 2 计费结束',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Table structure for t_userinfo
-- ----------------------------
DROP TABLE IF EXISTS `t_userinfo`;
CREATE TABLE `t_userinfo` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  `telephone` varchar(20) DEFAULT NULL,
  `sex` tinyint(4) DEFAULT NULL,
  `account` bigint(20) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `enabled` tinyint(4) DEFAULT '1',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
