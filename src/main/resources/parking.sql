/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50621
Source Host           : 127.0.0.1:3306
Source Database       : parking

Target Server Type    : MYSQL
Target Server Version : 50621
File Encoding         : 65001

Date: 2017-02-26 19:31:53
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_car
-- ----------------------------
DROP TABLE IF EXISTS `t_car`;
CREATE TABLE `t_car` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) NOT NULL,
  `car_name` varchar(50) CHARACTER SET utf8 NOT NULL,
  `info` varchar(200) CHARACTER SET utf8 DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `enabled` tinyint(4) DEFAULT '1',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of t_car
-- ----------------------------
INSERT INTO `t_car` VALUES ('1', '1', 'BMW-X5', '豪华配置', '2017-02-16 14:41:08', '2017-02-16 14:41:11', '1');
INSERT INTO `t_car` VALUES ('2', '1', '奥迪A8', '尊享融化', '2017-02-16 14:42:38', '2017-02-16 14:42:41', '1');
INSERT INTO `t_car` VALUES ('3', '1', '悍马H2', '没有我去不了的地方', '2017-02-15 14:43:39', '2017-02-16 14:43:43', '1');
INSERT INTO `t_car` VALUES ('4', '1', '奔驰S600', '商务标配', '2017-02-16 14:45:53', '2017-02-16 14:45:55', '1');

-- ----------------------------
-- Table structure for t_carport
-- ----------------------------
DROP TABLE IF EXISTS `t_carport`;
CREATE TABLE `t_carport` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `park_id` bigint(20) DEFAULT NULL,
  `info` varchar(200) CHARACTER SET utf8 DEFAULT NULL,
  `status` tinyint(4) DEFAULT '0' COMMENT '0 未占用 1 已使用',
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `enabled` tinyint(4) DEFAULT '1',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of t_carport
-- ----------------------------
INSERT INTO `t_carport` VALUES ('1', '1', '车位1', '0', '2017-02-16 17:31:13', '2017-02-16 17:31:15', '1');
INSERT INTO `t_carport` VALUES ('2', '1', '车位2', '0', '2017-02-16 17:31:50', '2017-02-16 17:31:52', '1');
INSERT INTO `t_carport` VALUES ('3', '1', '车位3', '0', '2017-02-16 17:32:18', '2017-02-16 17:32:20', '1');
INSERT INTO `t_carport` VALUES ('4', '1', '车位4', '0', '2017-02-16 17:32:39', '2017-02-16 17:32:41', '1');
INSERT INTO `t_carport` VALUES ('5', '1', '车位5', '0', '2017-02-16 17:32:55', '2017-02-16 17:32:57', '1');
INSERT INTO `t_carport` VALUES ('6', '1', '车位6', '0', '2017-02-16 17:33:44', '2017-02-16 17:33:47', '1');
INSERT INTO `t_carport` VALUES ('7', '1', '车位7', '0', '2017-02-16 17:33:44', '2017-02-16 17:33:47', '1');
INSERT INTO `t_carport` VALUES ('8', '1', '车位8', '0', '2017-02-16 17:33:44', '2017-02-16 17:33:47', '1');
INSERT INTO `t_carport` VALUES ('9', '1', '车位9', '0', '2017-02-16 17:33:44', '2017-02-16 17:33:47', '1');
INSERT INTO `t_carport` VALUES ('10', '1', '车位10', '0', '2017-02-16 17:33:44', '2017-02-16 17:33:47', '1');
INSERT INTO `t_carport` VALUES ('11', '1', '车位11', '0', '2017-02-16 17:33:44', '2017-02-16 17:33:47', '1');
INSERT INTO `t_carport` VALUES ('12', '1', '车位12', '0', '2017-02-16 17:33:44', '2017-02-16 17:33:47', '1');
INSERT INTO `t_carport` VALUES ('13', '1', '车位13', '0', '2017-02-16 17:33:44', '2017-02-16 17:33:47', '1');
INSERT INTO `t_carport` VALUES ('14', '1', '车位14', '0', '2017-02-16 17:33:44', '2017-02-16 17:33:47', '1');
INSERT INTO `t_carport` VALUES ('15', '1', '车位15', '0', '2017-02-16 17:33:44', '2017-02-16 17:33:47', '1');
INSERT INTO `t_carport` VALUES ('16', '1', '车位16', '0', '2017-02-16 17:33:44', '2017-02-16 17:33:47', '1');
INSERT INTO `t_carport` VALUES ('17', '1', '车位17', '0', '2017-02-16 17:33:44', '2017-02-16 17:33:47', '1');
INSERT INTO `t_carport` VALUES ('18', '1', '车位18', '0', '2017-02-16 17:33:44', '2017-02-16 17:33:47', '1');
INSERT INTO `t_carport` VALUES ('19', '1', '车位19', '0', '2017-02-16 17:33:44', '2017-02-16 17:33:47', '1');
INSERT INTO `t_carport` VALUES ('20', '1', '车位20', '0', '2017-02-16 17:33:44', '2017-02-16 17:33:47', '1');

-- ----------------------------
-- Table structure for t_park
-- ----------------------------
DROP TABLE IF EXISTS `t_park`;
CREATE TABLE `t_park` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `park_name` varchar(50) CHARACTER SET utf8 DEFAULT NULL,
  `info` varchar(200) CHARACTER SET utf8 DEFAULT NULL,
  `park_num` int(20) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `enabled` tinyint(4) DEFAULT '1',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of t_park
-- ----------------------------
INSERT INTO `t_park` VALUES ('1', '李鹏超的停车场', '视野宽阔，专人管理，您的不二选择。停车收费10元/小时', '20', '2017-02-16 14:39:35', '2017-02-16 14:39:39', '1');

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
-- Records of t_parkinginfo
-- ----------------------------

-- ----------------------------
-- Table structure for t_userinfo
-- ----------------------------
DROP TABLE IF EXISTS `t_userinfo`;
CREATE TABLE `t_userinfo` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(50) CHARACTER SET utf8 NOT NULL,
  `password` varchar(50) CHARACTER SET utf8 NOT NULL,
  `telephone` varchar(20) CHARACTER SET utf8 DEFAULT NULL,
  `sex` tinyint(4) DEFAULT NULL,
  `account` bigint(20) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `enabled` tinyint(4) DEFAULT '1',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of t_userinfo
-- ----------------------------
INSERT INTO `t_userinfo` VALUES ('1', '李鹏超', '123', '13188888888', '1', '100000', '2017-02-16 14:46:38', '2017-02-16 14:46:40', '1');
