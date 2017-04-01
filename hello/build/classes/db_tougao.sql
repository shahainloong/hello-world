/*
MySQL Data Transfer
Source Host: localhost
Source Database: db_tougao
Target Host: localhost
Target Database: db_tougao
Date: 2012-08-01 13:42:01
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for t_admin
-- ----------------------------
CREATE TABLE `t_admin` (
  `userId` int(11) NOT NULL auto_increment,
  `userName` varchar(50) default NULL,
  `userPw` varchar(50) default NULL,
  PRIMARY KEY  (`userId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for t_gaofei
-- ----------------------------
CREATE TABLE `t_gaofei` (
  `id` int(11) NOT NULL auto_increment,
  `jine` int(11) default NULL,
  `shijian` varchar(111) default NULL,
  `user_id` int(11) default NULL,
  `del` varchar(255) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for t_gaojian
-- ----------------------------
CREATE TABLE `t_gaojian` (
  `id` int(11) NOT NULL auto_increment,
  `title` varchar(50) default NULL,
  `content` text,
  `fujian` varchar(50) default NULL,
  `fujianYuanshiming` varchar(50) default NULL,
  `shijian` varchar(50) default NULL,
  `user_id` int(11) default NULL,
  `zhuanjiashenhebiaozhi` varchar(255) default NULL,
  `zhuanjiashenheyijian` varchar(5000) default NULL,
  `zhubianshenhebiaozhi` varchar(50) default NULL,
  `zhubianshenheyijian` varchar(5000) default NULL,
  `shifoufabiao` varchar(255) default NULL,
  `del` varchar(50) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
CREATE TABLE `t_user` (
  `id` int(11) NOT NULL auto_increment,
  `name` varchar(50) default NULL,
  `sex` varchar(50) default NULL,
  `age` varchar(50) default NULL,
  `tel` varchar(50) default NULL,
  `address` varchar(50) default NULL,
  `loginName` varchar(50) default NULL,
  `loginPw` varchar(50) default NULL,
  `del` varchar(50) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for t_zhuanjia
-- ----------------------------
CREATE TABLE `t_zhuanjia` (
  `id` int(11) NOT NULL auto_increment,
  `name` varchar(50) default NULL,
  `sex` varchar(50) default NULL,
  `age` varchar(50) default NULL,
  `tel` varchar(50) default NULL,
  `address` varchar(50) default NULL,
  `loginName` varchar(50) default NULL,
  `loginPw` varchar(50) default NULL,
  `del` varchar(50) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records 
-- ----------------------------
INSERT INTO `t_admin` VALUES ('1', 'a', 'a');
INSERT INTO `t_gaofei` VALUES ('6', '100', '2012-8-1 11:00:55', '2', 'no');
INSERT INTO `t_gaojian` VALUES ('4', '北京发生特大自然灾害之暴雨', '北京发生特大自然灾害之暴雨', '/upload/1343789838210.doc', '附件.doc', '2012-8-1 10:57:19', '2', 'shenhetongguo', '不错，很好', 'shenhetongguo', '不错，很好', 'fou', 'no');
INSERT INTO `t_gaojian` VALUES ('5', '测试稿件测试稿件', '测试稿件测试稿件', '/upload/1343799628275.doc', '附件.doc', '2012-8-1 13:40:29', '2', 'shenhetongguo', '很好，不错', 'shenhetongguo', '很好，不错', 'fou', 'no');
INSERT INTO `t_user` VALUES ('2', 'liusan', '男', '21', '13555555555', '北京路', 'liusan', '000000', 'no');
INSERT INTO `t_zhuanjia` VALUES ('2', '马六', '男', '21', '13555555555', '北京路', 'maliu', '000000', 'no');
