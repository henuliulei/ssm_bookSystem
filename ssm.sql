/*
 Navicat Premium Data Transfer

 Source Server         : mq_ai
 Source Server Type    : MySQL
 Source Server Version : 80018
 Source Host           : localhost:3306
 Source Schema         : ssm

 Target Server Type    : MySQL
 Target Server Version : 80018
 File Encoding         : 65001

 Date: 27/04/2021 14:52:47
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for book
-- ----------------------------
DROP TABLE IF EXISTS `book`;
CREATE TABLE `book`  (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `book_name` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '书名',
  `price` float(5, 2) NOT NULL COMMENT '价格',
  `num` int(10) NOT NULL DEFAULT 10 COMMENT '总数',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of book
-- ----------------------------
INSERT INTO `book` VALUES (1, 'Havana', 19.00, 10);
INSERT INTO `book` VALUES (2, '大宅门', 19.32, 10);
INSERT INTO `book` VALUES (3, '西游记', 19.10, 10);

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int(8) NOT NULL AUTO_INCREMENT,
  `username` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户名',
  `password` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '密码',
  `email` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '邮箱',
  `mobile` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '电话',
  `role` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '普通用户',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 87 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (58, 'test211', '123', '123@qq.com', '15517032333', '普通用户');
INSERT INTO `user` VALUES (70, 'test211111', '123', '123@qq.com', '15517032333', '管理员');
INSERT INTO `user` VALUES (77, 'test1', '123', '123@qq.com', '15517032333', '管理员');
INSERT INTO `user` VALUES (78, 'test11', '123', '123@qq.com', '15517032333', '普通用户');
INSERT INTO `user` VALUES (79, 'test111', '123', '123@qq.com', '15517032333', '普通用户');
INSERT INTO `user` VALUES (80, 'te1st111', '123', '123@qq.com', '15517032333', '普通用户');
INSERT INTO `user` VALUES (81, 'te11st111', '123', '123@qq.com', '15517032333', '普通用户');
INSERT INTO `user` VALUES (87, 'admin', '123', '123@qq.com', '15517032333', '普通用户');
INSERT INTO `user` VALUES (88, 'admin1', '123', '123@qq.com', '15517032333', '普通用户');

SET FOREIGN_KEY_CHECKS = 1;
