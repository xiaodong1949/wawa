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

/*Data for the table `t_answer` */

/*Table structure for table `t_baby` */

DROP TABLE IF EXISTS `t_baby`;

CREATE TABLE `t_baby` (
  `id` int(8) NOT NULL auto_increment COMMENT '主键ID',
  `userid` int(8) NOT NULL COMMENT '关联用户ID',
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

/*Data for the table `t_baby` */

/*Table structure for table `t_diary` */

DROP TABLE IF EXISTS `t_diary`;

CREATE TABLE `t_diary` (
  `id` int(8) NOT NULL auto_increment,
  `userid` int(8) NOT NULL,
  `title` varchar(512) default NULL,
  `tag` varchar(32) default NULL,
  `content` text,
  `createtime` timestamp NOT NULL default CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP,
  `open` int(1) NOT NULL default '1' COMMENT '0:对外公开；1：好友；2：不公开',
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `t_diary` */

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

/*Data for the table `t_question` */

/*Table structure for table `t_resource` */

DROP TABLE IF EXISTS `t_resource`;

CREATE TABLE `t_resource` (
  `id` int(8) NOT NULL auto_increment COMMENT 'id',
  `userid` int(8) NOT NULL COMMENT '用户id',
  `resourcename` varchar(64) NOT NULL COMMENT '用户资源名称',
  `resourcetype` int(2) NOT NULL COMMENT '资源类型 1：图片 2:视频',
  `ispublic` int(1) NOT NULL default '1' COMMENT '是否公开 0：否 1:是',
  `description` varchar(512) default NULL COMMENT '描述',
  `createtime` timestamp NOT NULL default CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP COMMENT '创建时间',
  `praise` int(8) default '0' COMMENT '赞 个数',
  `resourcest` int(1) default '1' COMMENT '0:删除 1：正常',
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;

/*Data for the table `t_resource` */

insert  into `t_resource`(`id`,`userid`,`resourcename`,`resourcetype`,`ispublic`,`description`,`createtime`,`praise`,`resourcest`) values (4,1,'img/gallery/IMG_0228.JPG',1,1,'gggg','2014-04-15 14:56:14',4,1),(5,1,'img/gallery//IMG_0260.JPG',1,1,'','2014-03-03 11:08:12',0,1),(6,1,'album/1/IMG_0391.PNG',1,1,'','2014-03-03 10:52:55',0,1),(7,1,'album/1/IMG_0238.JPG',1,1,'','2014-03-03 10:53:10',0,1),(8,7,'img\\7\\2.jpg',1,0,'test','2014-04-16 15:54:13',0,0),(9,7,'img\\7\\2.jpg',1,0,'','2014-04-16 16:06:17',0,1),(13,7,'img\\7\\2.jpg',1,0,'','2014-04-16 17:11:45',0,1),(14,7,'img\\7\\2.jpg',1,0,'','2014-04-16 17:41:01',0,1);

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
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

/*Data for the table `t_user` */

insert  into `t_user`(`id`,`account`,`password`,`acctp`,`realname`,`nickname`,`title`,`email`,`mobile`,`qq`,`weixin`,`weibotp`,`weibo`,`birthday`,`address`,`createtime`,`updatetime`) values (6,'中国','1',1,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'2013-12-12 13:56:06',NULL),(7,'真是姓名','aaa',1,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'2013-12-13 14:23:13',NULL);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
