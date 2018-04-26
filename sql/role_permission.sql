/*
Navicat MySQL Data Transfer

Source Server         : weixueqiang
Source Server Version : 50633
Source Host           : localhost:3306
Source Database       : test

Target Server Type    : MYSQL
Target Server Version : 50633
File Encoding         : 65001

Date: 2018-04-26 11:51:04
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for role_permission
-- ----------------------------
DROP TABLE IF EXISTS `role_permission`;
CREATE TABLE `role_permission` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `role_id` int(11) DEFAULT NULL,
  `permission_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_role_p_P` (`permission_id`),
  KEY `fkkkk` (`role_id`),
  CONSTRAINT `fk_role_p_P` FOREIGN KEY (`permission_id`) REFERENCES `permission` (`id`),
  CONSTRAINT `fkkkk` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of role_permission
-- ----------------------------
INSERT INTO `role_permission` VALUES ('1', '1', '1');
INSERT INTO `role_permission` VALUES ('2', '1', '2');
INSERT INTO `role_permission` VALUES ('3', '1', '3');
INSERT INTO `role_permission` VALUES ('4', '1', '4');
INSERT INTO `role_permission` VALUES ('5', '1', '5');
INSERT INTO `role_permission` VALUES ('6', '1', '6');
INSERT INTO `role_permission` VALUES ('7', '1', '7');
INSERT INTO `role_permission` VALUES ('8', '1', '8');
INSERT INTO `role_permission` VALUES ('9', '2', '5');
INSERT INTO `role_permission` VALUES ('10', '2', '6');
INSERT INTO `role_permission` VALUES ('11', '2', '7');
INSERT INTO `role_permission` VALUES ('12', '2', '8');
INSERT INTO `role_permission` VALUES ('13', '2', '1');
INSERT INTO `role_permission` VALUES ('14', '2', '2');
INSERT INTO `role_permission` VALUES ('15', '2', '3');
SET FOREIGN_KEY_CHECKS=1;
