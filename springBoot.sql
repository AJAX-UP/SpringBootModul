/*
Navicat MySQL Data Transfer

Source Server         : 5.7mysql
Source Server Version : 50722
Source Host           : localhost:3306
Source Database       : test

Target Server Type    : MYSQL
Target Server Version : 50722
File Encoding         : 65001

Date: 2018-07-26 16:12:34
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for prefix_member
-- ----------------------------
DROP TABLE IF EXISTS `prefix_member`;
CREATE TABLE `prefix_member` (
  `uid` bigint(20) unsigned NOT NULL,
  `employee_id` char(20) DEFAULT NULL,
  `gender` tinyint(1) unsigned DEFAULT NULL,
  `nickname` varchar(40) NOT NULL DEFAULT '',
  `uname` varchar(40) NOT NULL DEFAULT '',
  `passwd` varchar(40) DEFAULT NULL,
  `email` varchar(40) DEFAULT '',
  `portrait` varchar(160) DEFAULT '',
  `big_portrait` varchar(160) DEFAULT '',
  `phone` char(11) DEFAULT NULL,
  `reg_time` int(10) unsigned NOT NULL,
  `login_num` int(10) unsigned NOT NULL DEFAULT '0',
  `last_login` int(10) unsigned NOT NULL,
  `last_ip` varchar(50) NOT NULL,
  `is_supper` tinyint(3) DEFAULT '0',
  `timeline` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `union_id` varchar(32) DEFAULT NULL,
  UNIQUE KEY `uid` (`uid`),
  KEY `index` (`uname`,`passwd`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;