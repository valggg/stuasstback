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

 Date: 25/02/2022 00:47:49
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
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of s_admin
-- ----------------------------
INSERT INTO `s_admin` VALUES (1, '系统管理员', 'admin', '$2a$10$kMiEaKxQPMLxN2aLmJoErufsJHpRyrx4IdLMcsWAgFU2S2OoszXSW', 'https://ss0.bdstatic.com/70cFvHSh_Q1YnxGkpoWK1HF6hhy/it/u=2871119264,233376496&fm=26&gp=0.jpg', 1);
INSERT INTO `s_admin` VALUES (2, '何淑华', 'bing', '$2a$10$AG7skrpZrWvJZerB3xRBMOZKrIrng5jqMJvdoU8tA3sdMpflkwm/i', '$2a$10$AG7skrpZrWvJZerB3xRBMOZKrIrng5jqMJvdoU8tA3sdMpflkwm/i', 1);

-- ----------------------------
-- Table structure for s_admin_course
-- ----------------------------
DROP TABLE IF EXISTS `s_admin_course`;
CREATE TABLE `s_admin_course`  (
  `id` int(11) NOT NULL COMMENT 'id',
  `adminId` int(11) NULL DEFAULT NULL COMMENT '用户id',
  `cid` int(11) NULL DEFAULT NULL COMMENT '课程id',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of s_admin_course
-- ----------------------------
INSERT INTO `s_admin_course` VALUES (1, 1, 1);

-- ----------------------------
-- Table structure for s_admin_role
-- ----------------------------
DROP TABLE IF EXISTS `s_admin_role`;
CREATE TABLE `s_admin_role`  (
  `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT 'id',
  `adminId` int(11) NULL DEFAULT NULL COMMENT '用户id',
  `rid` int(11) NULL DEFAULT NULL COMMENT '权限id',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 69 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '管理员角色中间表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of s_admin_role
-- ----------------------------
INSERT INTO `s_admin_role` VALUES (1, 1, 1);
INSERT INTO `s_admin_role` VALUES (2, 2, 2);

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
  `coord` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '坐标',
  `color` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '颜色',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of s_course
-- ----------------------------
INSERT INTO `s_course` VALUES (1, '高等数学', '张三', '第一教学楼101', '1，2', '1，1', 'red');

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
  `keepAlive` tinyint(1) NULL DEFAULT NULL COMMENT '是否保持激活',
  `requireAuth` tinyint(1) NULL DEFAULT NULL COMMENT '是否要求权限',
  `parentId` int(11) NULL DEFAULT NULL COMMENT '父id',
  `enabled` tinyint(1) NULL DEFAULT NULL COMMENT '是否启用',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 29 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '菜单表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of s_menu
-- ----------------------------
INSERT INTO `s_menu` VALUES (1, '/', NULL, NULL, '所有', NULL, NULL, NULL, NULL, 1);
INSERT INTO `s_menu` VALUES (2, '/', '/home', 'Home', '课表管理', 'fa fa-user-circle-o', NULL, 1, 1, 1);
INSERT INTO `s_menu` VALUES (3, '/', '/home', 'Home', '文档管理', 'fa fa-address-card-o', NULL, 1, 1, 1);
INSERT INTO `s_menu` VALUES (4, '/', '/home', 'Home', '工具管理', 'fa fa-bar-chart', NULL, 1, 1, 1);
INSERT INTO `s_menu` VALUES (5, '/', '/home', 'Home', '系统管理', 'fa fa-windows', NULL, 1, 1, 1);
INSERT INTO `s_menu` VALUES (6, '/course/showTab/**', '/cou/showTab', 'CouShowTab', '个人课表', NULL, NULL, 1, 2, 1);
INSERT INTO `s_menu` VALUES (7, '/document/showDoc/**', '/doc/showDoc', 'DocShowDoc', '个人文档', NULL, NULL, 1, 3, 1);
INSERT INTO `s_menu` VALUES (8, '/tool/tally/**', '/too/tally', 'TooTally', '记账本', NULL, NULL, 1, 4, 1);
INSERT INTO `s_menu` VALUES (9, '/system/config/**', '/sys/config', 'SysConfig', '系统管理', NULL, NULL, 1, 5, 1);
INSERT INTO `s_menu` VALUES (10, '/system/log/**', '/sys/log', 'SysLog', '操作日志管理', NULL, NULL, 1, 5, 1);
INSERT INTO `s_menu` VALUES (11, '/system/admin/**', '/sys/admin', 'SysAdmin', '操作员管理', NULL, NULL, 1, 5, 1);
INSERT INTO `s_menu` VALUES (12, '/system/data/**', '/sys/data', 'SysData', '备份恢复数据库', NULL, NULL, 1, 5, 1);
INSERT INTO `s_menu` VALUES (13, '/system/init/**', '/sys/init', 'SysInit', '初始化数据库', NULL, NULL, 1, 5, 1);
INSERT INTO `s_menu` VALUES (14, '/system/basic/**', '/sys/basic', 'SysBasic', '基础信息设置', NULL, NULL, 1, 5, 1);

-- ----------------------------
-- Table structure for s_menu_role
-- ----------------------------
DROP TABLE IF EXISTS `s_menu_role`;
CREATE TABLE `s_menu_role`  (
  `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT 'id',
  `mid` int(11) NULL DEFAULT NULL COMMENT '菜单id',
  `rid` int(11) NULL DEFAULT NULL COMMENT '权限id',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 365 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '菜单角色中间表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of s_menu_role
-- ----------------------------
INSERT INTO `s_menu_role` VALUES (2, 2, 2);
INSERT INTO `s_menu_role` VALUES (3, 3, 2);
INSERT INTO `s_menu_role` VALUES (4, 4, 2);
INSERT INTO `s_menu_role` VALUES (6, 6, 2);
INSERT INTO `s_menu_role` VALUES (7, 7, 2);
INSERT INTO `s_menu_role` VALUES (8, 8, 2);
INSERT INTO `s_menu_role` VALUES (9, 9, 1);
INSERT INTO `s_menu_role` VALUES (10, 10, 1);
INSERT INTO `s_menu_role` VALUES (11, 11, 1);
INSERT INTO `s_menu_role` VALUES (12, 12, 1);
INSERT INTO `s_menu_role` VALUES (13, 13, 1);
INSERT INTO `s_menu_role` VALUES (14, 14, 1);
INSERT INTO `s_menu_role` VALUES (15, 2, 1);
INSERT INTO `s_menu_role` VALUES (16, 3, 1);
INSERT INTO `s_menu_role` VALUES (17, 4, 1);
INSERT INTO `s_menu_role` VALUES (18, 5, 1);
INSERT INTO `s_menu_role` VALUES (19, 6, 1);

-- ----------------------------
-- Table structure for s_role
-- ----------------------------
DROP TABLE IF EXISTS `s_role`;
CREATE TABLE `s_role`  (
  `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT 'id',
  `name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '名称',
  `nameZh` varchar(60) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '角色名称',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 14 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '角色表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of s_role
-- ----------------------------
INSERT INTO `s_role` VALUES (1, 'ROLE_admin', '系统管理员');
INSERT INTO `s_role` VALUES (2, 'ROLE_user', '普通用户');

SET FOREIGN_KEY_CHECKS = 1;
