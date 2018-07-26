CREATE TABLE `prefix_member` (
  `uid` bigint(20) unsigned NOT NULL,
  `employee_id` char(20) DEFAULT NULL COMMENT '',
  `gender` tinyint(1) unsigned DEFAULT NULL COMMENT '',
  `nickname` varchar(40) NOT NULL DEFAULT '' COMMENT '',
  `uname` varchar(40) NOT NULL DEFAULT '' COMMENT '',
  `passwd` varchar(40) DEFAULT NULL,
  `email` varchar(40) DEFAULT '',
  `portrait` varchar(160) DEFAULT '' COMMENT '',
  `big_portrait` varchar(160) DEFAULT '' COMMENT '',
  `phone` char(11) DEFAULT NULL COMMENT '',
  `reg_time` int(10) unsigned NOT NULL COMMENT '',
  `login_num` int(10) unsigned NOT NULL DEFAULT '0',
  `last_login` int(10) unsigned NOT NULL,
  `last_ip` varchar(50) NOT NULL,
  `is_supper` tinyint(3) DEFAULT '0' COMMENT '',
  `timeline` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `union_id` varchar(32) DEFAULT NULL,
  UNIQUE KEY `uid` (`uid`),
  KEY `index` (`uname`,`passwd`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT COMMENT='';