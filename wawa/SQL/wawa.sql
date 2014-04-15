/*
SQLyog v10.2 
MySQL - 5.0.96-community-nt : Database - wawa
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`wawa` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `wawa`;

/*Table structure for table `t_answer` */

DROP TABLE IF EXISTS `t_answer`;

CREATE TABLE `t_answer` (
  `id` int(8) NOT NULL auto_increment,
  `account` int(8) NOT NULL COMMENT '用户ID',
  `questionid` int(8) NOT NULL COMMENT '问题ID',
  `answer` varchar(1024) NOT NULL COMMENT '回答内容',
  `createtime` varchar(64) NOT NULL COMMENT '创建时间',
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Table structure for table `t_baby` */

DROP TABLE IF EXISTS `t_baby`;

CREATE TABLE `t_baby` (
  `id` int(8) NOT NULL auto_increment COMMENT '主键ID',
  `account` varchar(8) NOT NULL COMMENT '关联用户ID',
  `realname` varchar(16) default NULL COMMENT '真实姓名',
  `nickname` varchar(16) NOT NULL COMMENT '乳名',
  `sex` int(1) default NULL COMMENT '性别 1：男 2：女',
  `birthday` varchar(16) default NULL COMMENT '生日',
  `animal` int(2) default NULL COMMENT '生肖 1：鼠……',
  `horoscopes` int(2) default NULL COMMENT '星座 1：水瓶……',
  `homeplace` varchar(32) default NULL COMMENT '出生地',
  `createtime` timestamp NULL default NULL COMMENT '创建时间',
  `updatetime` timestamp NULL default NULL COMMENT '更新时间',
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Table structure for table `t_question` */

DROP TABLE IF EXISTS `t_question`;

CREATE TABLE `t_question` (
  `id` int(8) NOT NULL auto_increment COMMENT 'ID',
  `account` int(8) NOT NULL COMMENT '用户ID',
  `question` varchar(512) NOT NULL COMMENT '问题描述',
  `questiontype` int(2) NOT NULL COMMENT '问题种类',
  `tag` varchar(64) default NULL COMMENT '问题标签',
  `questionstate` int(2) NOT NULL COMMENT '1：回答中 2：关闭',
  `createtime` varchar(64) NOT NULL COMMENT '提问时间',
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Table structure for table `t_resource` */

DROP TABLE IF EXISTS `t_resource`;

CREATE TABLE `t_resource` (
  `id` int(8) NOT NULL auto_increment COMMENT 'id',
  `account` int(8) NOT NULL COMMENT '用户id',
  `resourcename` varchar(32) NOT NULL COMMENT '用户资源路径',
  `resourcetype` int(2) NOT NULL COMMENT '资源类型 1：图片 2:视频',
  `createtime` varchar(64) NOT NULL COMMENT '创建时间',
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Table structure for table `t_user` */

DROP TABLE IF EXISTS `t_user`;

CREATE TABLE `t_user` (
  `id` int(8) NOT NULL auto_increment COMMENT '用户ID',
  `account` varchar(32) NOT NULL COMMENT '用户名称',
  `password` varchar(32) NOT NULL COMMENT '密码',
  `acctp` int(2) NOT NULL default '1' COMMENT '1:普通客户',
  `realname` varchar(16) default NULL COMMENT '真实姓名',
  `nickname` varchar(16) default NULL COMMENT '昵称',
  `title` int(2) default NULL COMMENT '称谓 1：爸爸 2：妈妈 3：爷爷 4：奶奶 5：外公：6 外婆 7：叔叔 8：阿姨 9：哥哥 10：姐姐',
  `email` varchar(64) default NULL COMMENT '邮件',
  `mobile` varchar(32) default NULL COMMENT '电话',
  `qq` varchar(32) default NULL COMMENT 'QQ号码',
  `weixin` varchar(32) default NULL COMMENT '微信号码',
  `weibotp` int(2) default NULL COMMENT '微博类型 1:新浪 2：腾讯',
  `weibo` varchar(32) default NULL COMMENT '微博号码',
  `birthday` varchar(32) default NULL COMMENT '生日',
  `address` varchar(64) default NULL COMMENT '通讯地址',
  `createtime` timestamp NULL default NULL COMMENT '注册时间',
  `updatetime` timestamp NULL default NULL COMMENT '更新时间',
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
