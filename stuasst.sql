/*
SQLyog Professional v12.08 (64 bit)
MySQL - 8.0.18 : Database - stuasst
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`stuasst` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;

USE `stuasst`;

/*Table structure for table `s_admin` */

DROP TABLE IF EXISTS `s_admin`;

CREATE TABLE `s_admin` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT 'id',
  `name` varchar(255) DEFAULT NULL COMMENT '名字',
  `username` varchar(255) DEFAULT NULL COMMENT '用户名',
  `password` varchar(255) DEFAULT NULL COMMENT '密码',
  `userFace` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '头像',
  `enabled` tinyint(1) DEFAULT '1' COMMENT '是否启用',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `s_admin` */

insert  into `s_admin`(`id`,`name`,`username`,`password`,`userFace`,`enabled`) values (1,'系统管理员','admin','$2a$10$kMiEaKxQPMLxN2aLmJoErufsJHpRyrx4IdLMcsWAgFU2S2OoszXSW','https://ss0.bdstatic.com/70cFvHSh_Q1YnxGkpoWK1HF6hhy/it/u=2871119264,233376496&fm=26&gp=0.jpg',1),(2,'何淑华','bing','$2a$10$AG7skrpZrWvJZerB3xRBMOZKrIrng5jqMJvdoU8tA3sdMpflkwm/i','$2a$10$AG7skrpZrWvJZerB3xRBMOZKrIrng5jqMJvdoU8tA3sdMpflkwm/i',1);

/*Table structure for table `s_admin_role` */

DROP TABLE IF EXISTS `s_admin_role`;

CREATE TABLE `s_admin_role` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT 'id',
  `adminId` int(11) DEFAULT NULL COMMENT '用户id',
  `rid` int(11) DEFAULT NULL COMMENT '权限id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=69 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='管理员角色中间表';

/*Data for the table `s_admin_role` */

insert  into `s_admin_role`(`id`,`adminId`,`rid`) values (1,1,1),(2,2,2);

/*Table structure for table `s_menu` */

DROP TABLE IF EXISTS `s_menu`;

CREATE TABLE `s_menu` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT 'id',
  `url` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT 'url',
  `path` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT 'path',
  `component` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '组件',
  `name` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '菜单名',
  `iconCls` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '图标',
  `keepAlive` tinyint(1) DEFAULT NULL COMMENT '是否保持激活',
  `requireAuth` tinyint(1) DEFAULT NULL COMMENT '是否要求权限',
  `parentId` int(11) DEFAULT NULL COMMENT '父id',
  `enabled` tinyint(1) DEFAULT NULL COMMENT '是否启用',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='菜单表';

/*Data for the table `s_menu` */

insert  into `s_menu`(`id`,`url`,`path`,`component`,`name`,`iconCls`,`keepAlive`,`requireAuth`,`parentId`,`enabled`) values (1,'/',NULL,NULL,'所有',NULL,NULL,NULL,NULL,1),(2,'/','/home','Home','课表管理','fa fa-user-circle-o',NULL,1,1,1),(3,'/','/home','Home','文档管理','fa fa-address-card-o',NULL,1,1,1),(4,'/','/home','Home','工具管理','fa fa-bar-chart',NULL,1,1,1),(5,'/','/home','Home','系统管理','fa fa-windows',NULL,1,1,1),(6,'/timetable/show/**','/tab/show','TabShow','个人课表',NULL,NULL,1,2,1),(7,'/document/show/**','/doc/show','DocShow','个人文档',NULL,NULL,1,3,1),(8,'/tool/tally/**','/too/tally','TooTally','记账本',NULL,NULL,1,4,1),(9,'/system/config/**','/sys/config','SysConfig','系统管理',NULL,NULL,1,5,1),(10,'/system/log/**','/sys/log','SysLog','操作日志管理',NULL,NULL,1,5,1),(11,'/system/admin/**','/sys/admin','SysAdmin','操作员管理',NULL,NULL,1,5,1),(12,'/system/data/**','/sys/data','SysData','备份恢复数据库',NULL,NULL,1,5,1),(13,'/system/init/**','/sys/init','SysInit','初始化数据库',NULL,NULL,1,5,1);

/*Table structure for table `s_menu_role` */

DROP TABLE IF EXISTS `s_menu_role`;

CREATE TABLE `s_menu_role` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT 'id',
  `mid` int(11) DEFAULT NULL COMMENT '菜单id',
  `rid` int(11) DEFAULT NULL COMMENT '权限id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=365 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='菜单角色中间表';

/*Data for the table `s_menu_role` */

insert  into `s_menu_role`(`id`,`mid`,`rid`) values (1,1,2),(2,2,2),(3,3,2),(4,4,2),(5,5,2),(6,6,2),(7,7,2),(8,8,2),(9,9,1),(10,10,1),(11,11,1),(12,12,1),(13,13,1);

/*Table structure for table `s_role` */

DROP TABLE IF EXISTS `s_role`;

CREATE TABLE `s_role` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT 'id',
  `name` varchar(20) DEFAULT NULL COMMENT '名称',
  `nameZh` varchar(60) DEFAULT NULL COMMENT '角色名称',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='角色表';

/*Data for the table `s_role` */

insert  into `s_role`(`id`,`name`,`nameZh`) values (1,'ROLE_admin','系统管理员'),(2,'ROLE_user','普通用户');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
