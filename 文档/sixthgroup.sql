/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50096
Source Host           : localhost:3306
Source Database       : sixthgroup

Target Server Type    : MYSQL
Target Server Version : 50096
File Encoding         : 65001

Date: 2015-12-04 22:08:19
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for academy
-- ----------------------------
DROP TABLE IF EXISTS `academy`;
CREATE TABLE `academy` (
  `acad_id` int(11) NOT NULL auto_increment,
  `acad_name` varchar(255) default NULL,
  PRIMARY KEY  (`acad_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of academy
-- ----------------------------
INSERT INTO `academy` VALUES ('1', '计算机科学与技术学院');

-- ----------------------------
-- Table structure for diary
-- ----------------------------
DROP TABLE IF EXISTS `diary`;
CREATE TABLE `diary` (
  `diar_id` int(11) NOT NULL auto_increment,
  `diar_user` int(11) default NULL,
  `diar_content` varchar(255) default NULL,
  `diar_time` datetime default NULL,
  PRIMARY KEY  (`diar_id`),
  KEY `fk_user` (`diar_user`),
  CONSTRAINT `fk_user` FOREIGN KEY (`diar_user`) REFERENCES `user` (`user_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of diary
-- ----------------------------
INSERT INTO `diary` VALUES ('1', '1', 'hello world', '2015-11-03 20:35:06');

-- ----------------------------
-- Table structure for grade
-- ----------------------------
DROP TABLE IF EXISTS `grade`;
CREATE TABLE `grade` (
  `grad_id` int(11) NOT NULL auto_increment,
  `grad_name` varchar(255) default NULL,
  `grad_academy` int(11) default NULL,
  `grad_counselor` int(11) default NULL,
  `grad_monitor` int(11) default NULL,
  PRIMARY KEY  (`grad_id`),
  KEY `fk_counselor` (`grad_counselor`),
  KEY `fk_monitor` (`grad_monitor`),
  KEY `fk_academy1` (`grad_academy`),
  CONSTRAINT `fk_academy1` FOREIGN KEY (`grad_academy`) REFERENCES `academy` (`acad_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_counselor` FOREIGN KEY (`grad_counselor`) REFERENCES `user` (`user_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_monitor` FOREIGN KEY (`grad_monitor`) REFERENCES `user` (`user_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of grade
-- ----------------------------
INSERT INTO `grade` VALUES ('1', '卓软1301', null, null, null);
INSERT INTO `grade` VALUES ('2', '卓计1301', null, null, null);
INSERT INTO `grade` VALUES ('3', '软件1301', null, null, null);
INSERT INTO `grade` VALUES ('4', '软件1302', null, null, null);
INSERT INTO `grade` VALUES ('5', '软件1303', null, null, null);
INSERT INTO `grade` VALUES ('6', '软件1304', null, null, null);

-- ----------------------------
-- Table structure for historystudent
-- ----------------------------
DROP TABLE IF EXISTS `historystudent`;
CREATE TABLE `historystudent` (
  `hist_id` int(11) NOT NULL auto_increment,
  `hist_studentid` int(11) default NULL,
  `hist_count` int(11) default NULL COMMENT '第几次的班会',
  PRIMARY KEY  (`hist_id`),
  KEY `fk_student` (`hist_studentid`),
  CONSTRAINT `fk_student` FOREIGN KEY (`hist_studentid`) REFERENCES `student` (`stud_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of historystudent
-- ----------------------------
INSERT INTO `historystudent` VALUES ('1', '1', '5');
INSERT INTO `historystudent` VALUES ('2', '4', '1');

-- ----------------------------
-- Table structure for operationlog
-- ----------------------------
DROP TABLE IF EXISTS `operationlog`;
CREATE TABLE `operationlog` (
  `oplo_id` int(11) NOT NULL auto_increment,
  `oplo_peopleid` int(11) default NULL,
  `oplo_content` varchar(255) default NULL,
  `oplo_time` datetime default NULL,
  PRIMARY KEY  (`oplo_id`),
  KEY `fk_people` (`oplo_peopleid`),
  CONSTRAINT `fk_people` FOREIGN KEY (`oplo_peopleid`) REFERENCES `user` (`user_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of operationlog
-- ----------------------------
INSERT INTO `operationlog` VALUES ('1', '1', '我在测试', '2015-11-18 21:32:27');
INSERT INTO `operationlog` VALUES ('2', '1', '我还是在测试', '2015-11-03 21:32:39');

-- ----------------------------
-- Table structure for power
-- ----------------------------
DROP TABLE IF EXISTS `power`;
CREATE TABLE `power` (
  `powe_id` int(11) NOT NULL auto_increment,
  `powe_name` varchar(255) default NULL,
  PRIMARY KEY  (`powe_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of power
-- ----------------------------
INSERT INTO `power` VALUES ('1', '学生');
INSERT INTO `power` VALUES ('2', '辅导员');

-- ----------------------------
-- Table structure for specialinfo
-- ----------------------------
DROP TABLE IF EXISTS `specialinfo`;
CREATE TABLE `specialinfo` (
  `spin_id` int(11) NOT NULL auto_increment,
  `spin_studentid` int(11) default NULL,
  `spin_classno` int(11) default NULL COMMENT '特殊信息分类号',
  PRIMARY KEY  (`spin_id`),
  KEY `fk_student1` (`spin_studentid`),
  KEY `fk_classno` (`spin_classno`),
  CONSTRAINT `fk_classno` FOREIGN KEY (`spin_classno`) REFERENCES `specialinfoclass` (`spcl_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_student1` FOREIGN KEY (`spin_studentid`) REFERENCES `student` (`stud_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of specialinfo
-- ----------------------------

-- ----------------------------
-- Table structure for specialinfoclass
-- ----------------------------
DROP TABLE IF EXISTS `specialinfoclass`;
CREATE TABLE `specialinfoclass` (
  `spcl_id` int(11) NOT NULL auto_increment,
  `spcl_name` varchar(255) default NULL,
  PRIMARY KEY  (`spcl_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of specialinfoclass
-- ----------------------------

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student` (
  `stud_id` int(11) NOT NULL auto_increment,
  `stud_gradeid` int(11) default NULL COMMENT '班级',
  `stud_name` varchar(255) default NULL,
  `stud_sex` varchar(255) default NULL,
  `stud_age` varchar(255) default NULL,
  `stud_tel` varchar(255) default NULL,
  `stud_qq` int(11) default NULL,
  `stud_address` varchar(255) default NULL,
  `stud_idcard` varchar(255) default NULL,
  `stud_num` int(11) default NULL,
  `stud_bron` date default NULL,
  `stud_banknum` int(11) default NULL,
  `stud_nation` varchar(255) default NULL,
  `stud_dorimitory` varchar(255) default NULL,
  PRIMARY KEY  (`stud_id`),
  KEY `fk_grade` (`stud_gradeid`),
  CONSTRAINT `fk_grade` FOREIGN KEY (`stud_gradeid`) REFERENCES `grade` (`grad_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES ('1', null, 'swl', null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `student` VALUES ('2', null, 'wang', null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `student` VALUES ('3', null, 'li', null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `student` VALUES ('4', null, 'zhao', null, null, null, null, null, null, null, null, null, null, null);

-- ----------------------------
-- Table structure for teacher
-- ----------------------------
DROP TABLE IF EXISTS `teacher`;
CREATE TABLE `teacher` (
  `teac_id` int(11) NOT NULL auto_increment,
  `teac_academy` int(11) default NULL,
  `teac_name` varchar(255) default NULL,
  `teac_sex` varchar(255) default NULL,
  `teac_age` int(11) default NULL,
  `teac_tel` int(11) default NULL,
  `teac_qq` int(11) default NULL,
  PRIMARY KEY  (`teac_id`),
  KEY `fk_academy` (`teac_academy`),
  CONSTRAINT `fk_academy` FOREIGN KEY (`teac_academy`) REFERENCES `academy` (`acad_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of teacher
-- ----------------------------

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `user_id` int(11) NOT NULL auto_increment,
  `user_name` varchar(255) default NULL,
  `user_password` varchar(255) default NULL,
  `user_power` int(11) default NULL,
  PRIMARY KEY  (`user_id`),
  KEY `fk_power` (`user_power`),
  CONSTRAINT `fk_power` FOREIGN KEY (`user_power`) REFERENCES `power` (`powe_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'swl', '123', '1');
INSERT INTO `user` VALUES ('5', 'swll', '123', '1');
