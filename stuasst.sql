/*
 Navicat Premium Data Transfer

 Source Server         : 新连接
 Source Server Type    : MySQL
 Source Server Version : 80018
 Source Host           : localhost:3306
 Source Schema         : stuasst

 Target Server Type    : MySQL
 Target Server Version : 80018
 File Encoding         : 65001

 Date: 13/03/2022 11:51:35
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for s_admin
-- ----------------------------
DROP TABLE IF EXISTS `s_admin`;
CREATE TABLE `s_admin`  (
  `id` int(11) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT 'id',
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '名字',
  `username` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '用户名',
  `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '密码',
  `userFace` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '头像',
  `enabled` tinyint(1) NULL DEFAULT 1 COMMENT '是否启用',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of s_admin
-- ----------------------------
INSERT INTO `s_admin` VALUES (1, '系统管理员', 'admin', '$2a$10$0hdceu/BmebQFSkoOkMgz.URNXxViDC5d2NV1pC.8T9k.tKzl1E8a', 'http://192.168.194.128:8888/group1/M00/00/00/wKjCgGIqEfeAYZq5AAAT8HUMf-U026.jpg', 1);
INSERT INTO `s_admin` VALUES (2, '何淑华', 'bing', '$2a$10$AG7skrpZrWvJZerB3xRBMOZKrIrng5jqMJvdoU8tA3sdMpflkwm/i', 'https://ss0.bdstatic.com/70cFvHSh_Q1YnxGkpoWK1HF6hhy/it/u=2871119264,233376496&fm=26&gp=0.jpg', 1);
INSERT INTO `s_admin` VALUES (4, '123', '123', '$2a$10$3FNgCqMl1i4m3vQpC/k/yOKedmurofXG8Kmh6klGPqMxQ2MmzLrCC', 'http://192.168.194.128:8888/group1/M00/00/00/wKjCgGIqEfeAYZq5AAAT8HUMf-U026.jpg', 1);
INSERT INTO `s_admin` VALUES (5, '111', '111', '$2a$10$d43k4IcTEkgkqIBn4OSn3uisccrzRwCS4Wj2S0fXnShDN96Ockk.C', 'http://192.168.194.128:8888/group1/M00/00/00/wKjCgGIqEfeAYZq5AAAT8HUMf-U026.jpg', 1);
INSERT INTO `s_admin` VALUES (6, '333', '333', '$2a$10$tRGIFf5V9IHu1uzXbajzgeiv4H/W6XEYTax77iL8zF474bjgDVWaq', 'http://192.168.194.128:8888/group1/M00/00/00/wKjCgGIqEfeAYZq5AAAT8HUMf-U026.jpg', 1);

-- ----------------------------
-- Table structure for s_admin_course
-- ----------------------------
DROP TABLE IF EXISTS `s_admin_course`;
CREATE TABLE `s_admin_course`  (
  `id` int(11) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT 'id',
  `adminId` int(11) NULL DEFAULT NULL COMMENT '用户id',
  `cid` int(11) NULL DEFAULT NULL COMMENT '课程id',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 35 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of s_admin_course
-- ----------------------------
INSERT INTO `s_admin_course` VALUES (1, 1, 1);
INSERT INTO `s_admin_course` VALUES (4, 1, 14);
INSERT INTO `s_admin_course` VALUES (6, 1, 16);
INSERT INTO `s_admin_course` VALUES (29, 1, 39);
INSERT INTO `s_admin_course` VALUES (35, 1, 45);
INSERT INTO `s_admin_course` VALUES (36, 1, 46);

-- ----------------------------
-- Table structure for s_admin_document
-- ----------------------------
DROP TABLE IF EXISTS `s_admin_document`;
CREATE TABLE `s_admin_document`  (
  `id` int(11) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT 'id',
  `adminId` int(11) NULL DEFAULT NULL COMMENT '用户id',
  `did` int(11) NULL DEFAULT NULL COMMENT '文件id',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 39 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of s_admin_document
-- ----------------------------
INSERT INTO `s_admin_document` VALUES (10, 1, 11);
INSERT INTO `s_admin_document` VALUES (11, 1, 12);
INSERT INTO `s_admin_document` VALUES (38, 1, 39);
INSERT INTO `s_admin_document` VALUES (39, 1, 40);
INSERT INTO `s_admin_document` VALUES (40, 4, 41);

-- ----------------------------
-- Table structure for s_admin_role
-- ----------------------------
DROP TABLE IF EXISTS `s_admin_role`;
CREATE TABLE `s_admin_role`  (
  `id` int(11) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT 'id',
  `adminId` int(11) NULL DEFAULT NULL COMMENT '用户id',
  `rid` int(11) NULL DEFAULT NULL COMMENT '权限id',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 71 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '管理员角色中间表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of s_admin_role
-- ----------------------------
INSERT INTO `s_admin_role` VALUES (4, 4, 2);
INSERT INTO `s_admin_role` VALUES (5, 5, 2);
INSERT INTO `s_admin_role` VALUES (6, 6, 2);
INSERT INTO `s_admin_role` VALUES (79, 1, 2);
INSERT INTO `s_admin_role` VALUES (80, 1, 1);
INSERT INTO `s_admin_role` VALUES (83, 2, 2);

-- ----------------------------
-- Table structure for s_admin_tally
-- ----------------------------
DROP TABLE IF EXISTS `s_admin_tally`;
CREATE TABLE `s_admin_tally`  (
  `id` int(11) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT 'id',
  `adminId` int(11) NULL DEFAULT NULL COMMENT '用户id',
  `tid` int(11) NULL DEFAULT NULL COMMENT '账单id',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 21 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of s_admin_tally
-- ----------------------------
INSERT INTO `s_admin_tally` VALUES (1, 1, 1);
INSERT INTO `s_admin_tally` VALUES (2, 1, 3);
INSERT INTO `s_admin_tally` VALUES (8, 1, 9);
INSERT INTO `s_admin_tally` VALUES (9, 1, 10);
INSERT INTO `s_admin_tally` VALUES (10, 1, 11);
INSERT INTO `s_admin_tally` VALUES (11, 1, 12);
INSERT INTO `s_admin_tally` VALUES (12, 1, 13);
INSERT INTO `s_admin_tally` VALUES (13, 1, 16);
INSERT INTO `s_admin_tally` VALUES (16, 1, 19);
INSERT INTO `s_admin_tally` VALUES (17, 1, 20);
INSERT INTO `s_admin_tally` VALUES (18, 1, 21);
INSERT INTO `s_admin_tally` VALUES (21, 1, 24);
INSERT INTO `s_admin_tally` VALUES (22, 4, 25);

-- ----------------------------
-- Table structure for s_course
-- ----------------------------
DROP TABLE IF EXISTS `s_course`;
CREATE TABLE `s_course`  (
  `id` int(11) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT 'id',
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '课程名称',
  `teacher` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '授课教师',
  `address` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '教室',
  `weeks` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '课程周数',
  `tabNo` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '课程所在节数',
  `tabWeek` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '课程星期数',
  `color` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '颜色',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 45 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of s_course
-- ----------------------------
INSERT INTO `s_course` VALUES (1, '高等数学', '张三', 'G101', '1,2', '1,2', '1', '#FF0000');
INSERT INTO `s_course` VALUES (14, '英语', '李四', 'E111', '1', '3,4', '2', '#FF0000');
INSERT INTO `s_course` VALUES (16, '政治', '王五', 'A123', '1,2', '5,6', '1', '#FF0000');
INSERT INTO `s_course` VALUES (39, '计算机基础', '赵六', 'E123', '1,3', '1,2,3', '3', '#FF0000');
INSERT INTO `s_course` VALUES (45, '111', '111', '111', '111', '111', '111', '111');
INSERT INTO `s_course` VALUES (46, '高等数学', '张三', 'B123', '1,2,3,4', '3,4,5,6,7,8,9,10', '4', '#FF0000');

-- ----------------------------
-- Table structure for s_document
-- ----------------------------
DROP TABLE IF EXISTS `s_document`;
CREATE TABLE `s_document`  (
  `id` int(11) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT 'id',
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '文件名',
  `type` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '文件类型',
  `path` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '文件路径',
  `size` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '文件大小',
  `time` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '上传时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 40 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of s_document
-- ----------------------------
INSERT INTO `s_document` VALUES (11, 'timg.jpg', '.jpg', 'http://192.168.194.128:8888/group1/M00/00/00/wKjCgGIo39eAML5lAAGkzvh2Cko141.jpg', '0.10MB', '2022-03-10 01:11:51');
INSERT INTO `s_document` VALUES (12, '1.docx', '.docx', 'http://192.168.194.128:8888/group1/M00/00/00/wKjCgGIo9hqAHBIsAAAlqfRFM7A23.docx', '0.01MB', '2022-03-10 02:46:50');
INSERT INTO `s_document` VALUES (39, '1.jpg', '.jpg', 'http://192.168.194.128:8888/group1/M00/00/00/wKjCgGIq6HGAIf3YAAEwLlTF50s929.jpg', '0.07MB', '2022-03-11 14:13:05');
INSERT INTO `s_document` VALUES (40, '新建文本文档.txt', '.txt', 'http://192.168.194.128:8888/group1/M00/00/00/wKjCgGIq6RuAbujUAAACKerMEcs551.txt', '0.00MB', '2022-03-11 14:15:55');
INSERT INTO `s_document` VALUES (41, 'Snipaste_2022-03-12_20-14-44.jpg', '.jpg', 'http://192.168.194.128:8888/group1/M00/00/00/wKjCgGIszwCAOGV9AABL2MS5wkk860.jpg', '0.02MB', '2022-03-13 00:49:04');

-- ----------------------------
-- Table structure for s_menu
-- ----------------------------
DROP TABLE IF EXISTS `s_menu`;
CREATE TABLE `s_menu`  (
  `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT 'id',
  `url` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT 'url',
  `path` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT 'path',
  `component` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '组件',
  `name` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '菜单名',
  `iconCls` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '图标',
  `parentId` int(11) NULL DEFAULT NULL COMMENT '父id',
  `enabled` tinyint(1) NULL DEFAULT NULL COMMENT '是否启用',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 14 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '菜单表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of s_menu
-- ----------------------------
INSERT INTO `s_menu` VALUES (1, '/', NULL, NULL, '所有', NULL, NULL, 1);
INSERT INTO `s_menu` VALUES (2, '/', '/home', 'Home', '课表管理', 'fa fa-graduation-cap', 1, 1);
INSERT INTO `s_menu` VALUES (3, '/', '/home', 'Home', '文件管理', 'fa fa-folder-open', 1, 1);
INSERT INTO `s_menu` VALUES (4, '/', '/home', 'Home', '工具管理', 'fa fa-wrench', 1, 1);
INSERT INTO `s_menu` VALUES (5, '/', '/home', 'Home', '系统管理', 'fa fa-windows', 1, 1);
INSERT INTO `s_menu` VALUES (6, '/course/show/**', '/cou/show', 'CouShow', '个人课表', NULL, 2, 1);
INSERT INTO `s_menu` VALUES (7, '/document/show/**', '/doc/show', 'DocShow', '个人文档', NULL, 3, 1);
INSERT INTO `s_menu` VALUES (8, '/tool/tally/**', '/too/tally', 'TooTally', '记账本', NULL, 4, 1);
INSERT INTO `s_menu` VALUES (9, '/system/admin/**', '/sys/admin', 'SysAdmin', '操作员管理', NULL, 5, 1);

-- ----------------------------
-- Table structure for s_menu_role
-- ----------------------------
DROP TABLE IF EXISTS `s_menu_role`;
CREATE TABLE `s_menu_role`  (
  `id` int(11) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT 'id',
  `mid` int(11) NULL DEFAULT NULL COMMENT '菜单id',
  `rid` int(11) NULL DEFAULT NULL COMMENT '权限id',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 365 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '菜单角色中间表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of s_menu_role
-- ----------------------------
INSERT INTO `s_menu_role` VALUES (1, 6, 2);
INSERT INTO `s_menu_role` VALUES (2, 7, 2);
INSERT INTO `s_menu_role` VALUES (3, 8, 2);
INSERT INTO `s_menu_role` VALUES (4, 9, 1);

-- ----------------------------
-- Table structure for s_role
-- ----------------------------
DROP TABLE IF EXISTS `s_role`;
CREATE TABLE `s_role`  (
  `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT 'id',
  `name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '名称',
  `nameZh` varchar(60) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '角色名称',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '角色表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of s_role
-- ----------------------------
INSERT INTO `s_role` VALUES (1, 'ROLE_admin', '系统管理员');
INSERT INTO `s_role` VALUES (2, 'ROLE_user', '普通用户');

-- ----------------------------
-- Table structure for s_tab
-- ----------------------------
DROP TABLE IF EXISTS `s_tab`;
CREATE TABLE `s_tab`  (
  `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `beginDate` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '开课时间',
  `allWeek` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '总周数',
  `allTime` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '每天总节数',
  `everyTimes` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '每节课时间',
  `adminId` int(11) NULL DEFAULT NULL COMMENT '用户id',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of s_tab
-- ----------------------------
INSERT INTO `s_tab` VALUES (1, '2022/03/02', '30', '10', '8:20-9:05,9:15-10:00,10:25-11:10,11:20-12:05,14:00-14:45,14:55-15:40,16:00-16:45,16:55-17:40,18:40-19:25,19:35-20:20', 123);
INSERT INTO `s_tab` VALUES (6, '2022/03/02', '20', '10', '8:20-9:05,9:15-10:00,10:25-11:10,11:20-12:05,14:00-14:45,14:55-15:40,16:00-16:45,16:55-17:40,18:40-19:25,19:35-20:20', 1);

-- ----------------------------
-- Table structure for s_tally
-- ----------------------------
DROP TABLE IF EXISTS `s_tally`;
CREATE TABLE `s_tally`  (
  `id` int(11) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT 'id',
  `date` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '账单日期',
  `type` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '类型',
  `remark` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '备注',
  `money` float(10, 2) NULL DEFAULT NULL COMMENT '金额',
  `isIncome` tinyint(1) NULL DEFAULT 1 COMMENT '是否为收入',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 24 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of s_tally
-- ----------------------------
INSERT INTO `s_tally` VALUES (1, '2022-03-06', '食品餐饮', '早餐', 10.00, 0);
INSERT INTO `s_tally` VALUES (3, '2022-03-02', '食品餐饮', '晚餐', 12.50, 0);
INSERT INTO `s_tally` VALUES (9, '2022-03-01', '居家生活', '水费', 0.50, 0);
INSERT INTO `s_tally` VALUES (10, '2022-03-01', '工资', '一月', 10000.00, 1);
INSERT INTO `s_tally` VALUES (11, '2022-03-01', '借入', '小明', 10000.00, 1);
INSERT INTO `s_tally` VALUES (12, '2022-03-01', '工资', '二月', 10000.00, 1);
INSERT INTO `s_tally` VALUES (13, '2022-03-01', '休闲娱乐', '虚拟充值', 5.00, 0);
INSERT INTO `s_tally` VALUES (16, '2022-02-28', '其他', '', 0.10, 0);
INSERT INTO `s_tally` VALUES (19, '2022-02-28', '其他', '', 10.20, 1);
INSERT INTO `s_tally` VALUES (20, '2022-01-29', '食品餐饮', '早餐', 10.00, 0);
INSERT INTO `s_tally` VALUES (21, '2022-01-29', '食品餐饮', '午餐', 10.00, 0);
INSERT INTO `s_tally` VALUES (24, '2022-03-01', '其他', '', 0.20, 1);
INSERT INTO `s_tally` VALUES (25, '2022-03-01', '借入', '张三', 1000.00, 1);

-- ----------------------------
-- Procedure structure for addAdmin
-- ----------------------------
DROP PROCEDURE IF EXISTS `addAdmin`;
delimiter ;;
CREATE PROCEDURE `addAdmin`(IN name VARCHAR(255),IN username VARCHAR(255),IN password VARCHAR(255),IN userFace VARCHAR(255),IN enabled TINYINT(1),OUT result INT,OUT reId INT)
BEGIN
	#Routine body goes here...
	INSERT INTO s_admin	SET name=name,username=username,password=password,userFace=userFace,enabled=enabled;
	SELECT last_insert_id() INTO reId;
	SELECT ROW_COUNT() INTO result;
END
;;
delimiter ;

-- ----------------------------
-- Procedure structure for addCourse
-- ----------------------------
DROP PROCEDURE IF EXISTS `addCourse`;
delimiter ;;
CREATE PROCEDURE `addCourse`(IN couName VARCHAR(255),IN teacher VARCHAR(255),IN address VARCHAR(255),IN weeks VARCHAR(255),IN tabNo VARCHAR(255),IN tabWeek VARCHAR(255),IN color VARCHAR(255),OUT result INT,OUT reId INT)
BEGIN
	#Routine body goes here...
	INSERT INTO s_course SET name=couName,teacher=teacher,address=address,weeks=weeks,tabNo=tabNo,tabWeek=tabWeek,color=color;
	SELECT last_insert_id() INTO reId;
	SELECT ROW_COUNT() INTO result;
END
;;
delimiter ;

-- ----------------------------
-- Procedure structure for adddocument
-- ----------------------------
DROP PROCEDURE IF EXISTS `adddocument`;
delimiter ;;
CREATE PROCEDURE `adddocument`(IN name VARCHAR(255),IN type VARCHAR(255),IN path VARCHAR(255),IN size VARCHAR(255),IN time VARCHAR(255),OUT result INT,OUT reId INT)
BEGIN
	#Routine body goes here...
	INSERT INTO s_document	SET name=name,type=type,path=path,size=size,time=time;
	SELECT last_insert_id() INTO reId;
	SELECT ROW_COUNT() INTO result;
END
;;
delimiter ;

-- ----------------------------
-- Procedure structure for addTab
-- ----------------------------
DROP PROCEDURE IF EXISTS `addTab`;
delimiter ;;
CREATE PROCEDURE `addTab`(IN beginDate VARCHAR(255),IN allWeek VARCHAR(255),IN allTime VARCHAR(255),IN everyTimes VARCHAR(255),IN adminId INT,OUT result INT)
BEGIN
	#Routine body goes here...
	INSERT INTO s_tab SET beginDate=beginDate,allWeek=allWeek,allTime=allTime,everyTimes=everyTimes,adminId=adminId;
	SELECT ROW_COUNT() INTO result;
END
;;
delimiter ;

-- ----------------------------
-- Procedure structure for addTally
-- ----------------------------
DROP PROCEDURE IF EXISTS `addTally`;
delimiter ;;
CREATE PROCEDURE `addTally`(IN date VARCHAR(255),IN type VARCHAR(255),IN remark VARCHAR(255),IN money FLOAT(10,2),IN isIncome TINYINT(1),OUT result INT,OUT reId INT)
BEGIN
	#Routine body goes here...
	INSERT INTO s_tally SET date=date,type=type,remark=remark,money=money,isIncome=isIncome;
	SELECT last_insert_id() INTO reId;
	SELECT ROW_COUNT() INTO result;
END
;;
delimiter ;

-- ----------------------------
-- Procedure structure for delCourse
-- ----------------------------
DROP PROCEDURE IF EXISTS `delCourse`;
delimiter ;;
CREATE PROCEDURE `delCourse`(IN cid INT,OUT result INT)
BEGIN
	#Routine body goes here...
	DELETE FROM s_course WHERE id=cid;
	SELECT ROW_COUNT() INTO result;
END
;;
delimiter ;

-- ----------------------------
-- Procedure structure for delDocument
-- ----------------------------
DROP PROCEDURE IF EXISTS `delDocument`;
delimiter ;;
CREATE PROCEDURE `delDocument`(IN did INT,OUT result INT)
BEGIN
	#Routine body goes here...
	DELETE FROM s_document WHERE id=did;
	SELECT ROW_COUNT() INTO result;
END
;;
delimiter ;

-- ----------------------------
-- Procedure structure for delTab
-- ----------------------------
DROP PROCEDURE IF EXISTS `delTab`;
delimiter ;;
CREATE PROCEDURE `delTab`(IN tid INT,OUT result INT)
BEGIN
	#Routine body goes here...
	DELETE FROM s_tab WHERE id=tid;
	SELECT ROW_COUNT() INTO result;
END
;;
delimiter ;

-- ----------------------------
-- Procedure structure for delTally
-- ----------------------------
DROP PROCEDURE IF EXISTS `delTally`;
delimiter ;;
CREATE PROCEDURE `delTally`(IN tid INT,OUT result INT)
BEGIN
	#Routine body goes here...
	DELETE FROM s_tally WHERE id=tid;
	SELECT ROW_COUNT() INTO result;
END
;;
delimiter ;

SET FOREIGN_KEY_CHECKS = 1;
