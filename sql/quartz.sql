/*
Navicat MySQL Data Transfer

Source Server         : localtion
Source Server Version : 50722
Source Host           : localhost:3306
Source Database       : quartz

Target Server Type    : MYSQL
Target Server Version : 50722
File Encoding         : 65001

Date: 2021-01-28 15:01:41
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for cron
-- ----------------------------
DROP TABLE IF EXISTS `cron`;
CREATE TABLE `cron` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '表主键',
  `send_time` varchar(6) DEFAULT NULL COMMENT '发送时间',
  `status` int(2) DEFAULT NULL COMMENT '状态(0：停止使用，1：使用)',
  `cron_str` varchar(255) DEFAULT NULL COMMENT '表达式',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of cron
-- ----------------------------
INSERT INTO `cron` VALUES ('20', '08:15', '0', '0/2 * * * * ?');

-- ----------------------------
-- Table structure for job
-- ----------------------------
DROP TABLE IF EXISTS `job`;
CREATE TABLE `job` (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT '任务id',
  `job_name` varchar(100) DEFAULT NULL COMMENT '任务名称',
  `bean_name` varchar(100) DEFAULT NULL COMMENT 'bean名称',
  `method_name` varchar(100) DEFAULT NULL COMMENT '方法名称',
  `method_params` varchar(255) DEFAULT NULL COMMENT '方法参数',
  `cron_expression` varchar(255) NOT NULL COMMENT 'cron表达式',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  `status` tinyint(1) NOT NULL DEFAULT '0' COMMENT '状态(1正常 0暂停)',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of job
-- ----------------------------
INSERT INTO `job` VALUES ('1', null, 'test', 'test', 'test', '0/2 * * * * ?', 'test', '0', '2021-01-27 17:53:07', null);
