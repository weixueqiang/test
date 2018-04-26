/*
Navicat MySQL Data Transfer

Source Server         : weixueqiang
Source Server Version : 50633
Source Host           : localhost:3306
Source Database       : test

Target Server Type    : MYSQL
Target Server Version : 50633
File Encoding         : 65001

Date: 2018-04-26 11:51:13
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for permission
-- ----------------------------
DROP TABLE IF EXISTS `permission`;
CREATE TABLE `permission` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `parent_id` int(11) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `sort` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of permission
-- ----------------------------
INSERT INTO `permission` VALUES ('1', null, 'eat', '0');
INSERT INTO `permission` VALUES ('2', '1', 'eat:apple', '01');
INSERT INTO `permission` VALUES ('3', '1', 'eat:rice', '02');
INSERT INTO `permission` VALUES ('4', '1', 'eat:orange', '03');
INSERT INTO `permission` VALUES ('5', null, 'sleep', '2');
INSERT INTO `permission` VALUES ('6', '5', 'sleep:classroom', '21');
INSERT INTO `permission` VALUES ('7', '5', 'sleep:bedroom', '22');
INSERT INTO `permission` VALUES ('8', '5', 'sleep:visitroom', '23');
SET FOREIGN_KEY_CHECKS=1;
