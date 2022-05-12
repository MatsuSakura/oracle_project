/*
 Navicat Premium Data Transfer

 Source Server         : mysql
 Source Server Type    : MySQL
 Source Server Version : 50730
 Source Host           : localhost:3306
 Source Schema         : stumanage

 Target Server Type    : MySQL
 Target Server Version : 50730
 File Encoding         : 65001

 Date: 26/05/2021 22:10:11
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for tb_class
-- ----------------------------
DROP TABLE IF EXISTS `tb_class`;
CREATE TABLE `tb_class`  (
  `classId` int(11) NOT NULL AUTO_INCREMENT,
  `departName` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `specName` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `className` int(11) NOT NULL,
  PRIMARY KEY (`classId`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 13 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_class
-- ----------------------------
INSERT INTO `tb_class` VALUES (1, '计算机学院', '软件工程', 1);
INSERT INTO `tb_class` VALUES (3, '计算机学院', '计算机科学与技术', 2);
INSERT INTO `tb_class` VALUES (5, '艺术设计学院', '服装设计', 1);
INSERT INTO `tb_class` VALUES (6, '自动化学院', '物联网工程', 2);
INSERT INTO `tb_class` VALUES (7, '自动化学院', '物联网工程', 1);
INSERT INTO `tb_class` VALUES (8, '计算机学院', '计算机科学与技术', 1);
INSERT INTO `tb_class` VALUES (9, '政法学院', '法学', 1);
INSERT INTO `tb_class` VALUES (10, '政法学院', '法学', 2);
INSERT INTO `tb_class` VALUES (11, '计算机学院', '软件工程', 2);

-- ----------------------------
-- Table structure for tb_cource
-- ----------------------------
DROP TABLE IF EXISTS `tb_cource`;
CREATE TABLE `tb_cource`  (
  `courceId` int(11) NOT NULL AUTO_INCREMENT,
  `courceName` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `courceHour` float NULL DEFAULT NULL,
  `courceSpecName` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`courceId`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_cource
-- ----------------------------
INSERT INTO `tb_cource` VALUES (1, '大学英语', 2.5, '法学');
INSERT INTO `tb_cource` VALUES (2, '大学物理', 1.5, '物联网工程');
INSERT INTO `tb_cource` VALUES (3, '高等数学', 5, '计算机科学与技术');
INSERT INTO `tb_cource` VALUES (4, 'C语言程序设计', 3, '软件工程');
INSERT INTO `tb_cource` VALUES (5, '数据结构', 3, '软件工程');
INSERT INTO `tb_cource` VALUES (6, '线性代数', 1.5, '物理学');
INSERT INTO `tb_cource` VALUES (7, '大学语文', 1.5, '服装设计');

-- ----------------------------
-- Table structure for tb_depart
-- ----------------------------
DROP TABLE IF EXISTS `tb_depart`;
CREATE TABLE `tb_depart`  (
  `departId` int(11) NOT NULL AUTO_INCREMENT,
  `departName` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`departId`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_depart
-- ----------------------------
INSERT INTO `tb_depart` VALUES (1, '计算机学院');
INSERT INTO `tb_depart` VALUES (3, '艺术设计学院');
INSERT INTO `tb_depart` VALUES (4, '自动化学院');
INSERT INTO `tb_depart` VALUES (5, '政法学院');
INSERT INTO `tb_depart` VALUES (7, '物理学院');

-- ----------------------------
-- Table structure for tb_score
-- ----------------------------
DROP TABLE IF EXISTS `tb_score`;
CREATE TABLE `tb_score`  (
  `scoreId` int(11) NOT NULL AUTO_INCREMENT,
  `stuNumber` int(11) NOT NULL,
  `courceName` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `score` float NULL DEFAULT NULL,
  PRIMARY KEY (`scoreId`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 11 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_score
-- ----------------------------
INSERT INTO `tb_score` VALUES (1, 3001, 'C语言程序设计', 95);
INSERT INTO `tb_score` VALUES (3, 3002, '高等数学', 59);
INSERT INTO `tb_score` VALUES (5, 3004, '高等数学', 96);
INSERT INTO `tb_score` VALUES (7, 3001, '数据结构', 97);
INSERT INTO `tb_score` VALUES (8, 3006, '大学物理', 100);

-- ----------------------------
-- Table structure for tb_spec
-- ----------------------------
DROP TABLE IF EXISTS `tb_spec`;
CREATE TABLE `tb_spec`  (
  `specId` int(11) NOT NULL AUTO_INCREMENT,
  `departName` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `specName` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`specId`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 15 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_spec
-- ----------------------------
INSERT INTO `tb_spec` VALUES (1, '计算机学院', '计算机科学与技术');
INSERT INTO `tb_spec` VALUES (3, '艺术设计学院', '服装设计');
INSERT INTO `tb_spec` VALUES (5, '计算机学院', '软件工程');
INSERT INTO `tb_spec` VALUES (6, '政法学院', '法学');
INSERT INTO `tb_spec` VALUES (7, '自动化学院', '物联网工程');
INSERT INTO `tb_spec` VALUES (14, '计算机学院', '网络工程');

-- ----------------------------
-- Table structure for tb_student
-- ----------------------------
DROP TABLE IF EXISTS `tb_student`;
CREATE TABLE `tb_student`  (
  `stuId` int(11) NOT NULL AUTO_INCREMENT,
  `stuNumber` int(11) NOT NULL,
  `stuName` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `stuDepart` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `stuSpec` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `stuClass` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`stuId`) USING BTREE,
  UNIQUE INDEX `stuNumber_UNIQUE`(`stuNumber`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 15 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_student
-- ----------------------------
INSERT INTO `tb_student` VALUES (1, 3001, '张灵涛', '计算机学院', '软件工程', 1);
INSERT INTO `tb_student` VALUES (4, 3003, '黄昌俊', '计算机学院', '计算机科学与技术', 2);
INSERT INTO `tb_student` VALUES (6, 3002, '卢家豪', '计算机学院', '软件工程', 1);
INSERT INTO `tb_student` VALUES (7, 3004, '徐楷', '自动化学院', '物联网工程', 2);
INSERT INTO `tb_student` VALUES (8, 3005, '郑黄穗', '自动化学院', '物联网工程', 2);
INSERT INTO `tb_student` VALUES (9, 3006, '朱汐月', '物理学院', '物理学', 1);
INSERT INTO `tb_student` VALUES (10, 3007, '张磊', '政法学院', '法学', 1);
INSERT INTO `tb_student` VALUES (11, 3008, '张三', '物理学院', '物理学', 1);
INSERT INTO `tb_student` VALUES (13, 3009, '李四', '艺术设计学院', '服装设计', 1);

-- ----------------------------
-- Table structure for tb_user
-- ----------------------------
DROP TABLE IF EXISTS `tb_user`;
CREATE TABLE `tb_user`  (
  `userId` int(11) NOT NULL AUTO_INCREMENT,
  `userName` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `userPwd` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `userType` int(11) NOT NULL,
  PRIMARY KEY (`userId`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_user
-- ----------------------------
INSERT INTO `tb_user` VALUES (1, 'admin', '', 1);
INSERT INTO `tb_user` VALUES (4, 'test', 'aaa', 2);
INSERT INTO `tb_user` VALUES (5, 'abc', '123', 2);
INSERT INTO `tb_user` VALUES (6, '111', '111', 2);

SET FOREIGN_KEY_CHECKS = 1;
