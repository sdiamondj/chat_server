/*
 Navicat Premium Data Transfer

 Source Server         : 本地mysql
 Source Server Type    : MySQL
 Source Server Version : 80012
 Source Host           : localhost:3306
 Source Schema         : chat

 Target Server Type    : MySQL
 Target Server Version : 80012
 File Encoding         : 65001

 Date: 24/12/2019 10:24:59
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for chat_session
-- ----------------------------
DROP TABLE IF EXISTS `chat_session`;
CREATE TABLE `chat_session`  (
  `session_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NULL DEFAULT NULL,
  `session_content` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `time` timestamp(6) NULL DEFAULT NULL,
  `talker_id` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`session_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of chat_session
-- ----------------------------
INSERT INTO `chat_session` VALUES (2, 1, 'asdsaasd', '2019-12-23 19:25:26.000000', 3);
INSERT INTO `chat_session` VALUES (3, 1, 'dfdfd', '2019-12-23 19:25:46.000000', 2);
INSERT INTO `chat_session` VALUES (4, 1, 'xxxxxx', '2019-12-23 21:10:42.000000', 6);

-- ----------------------------
-- Table structure for chat_users
-- ----------------------------
DROP TABLE IF EXISTS `chat_users`;
CREATE TABLE `chat_users`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `account` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `password` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `gender` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `picture` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `description` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `test`(`account`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of chat_users
-- ----------------------------
INSERT INTO `chat_users` VALUES (1, 'sdj', '1234', NULL, NULL, '1', NULL);
INSERT INTO `chat_users` VALUES (2, 'rly', '1234', NULL, NULL, '2', NULL);
INSERT INTO `chat_users` VALUES (3, 'baba', '1234', NULL, NULL, '3', 'babababa');
INSERT INTO `chat_users` VALUES (6, 'postman', '1234', NULL, 'test', '4', NULL);
INSERT INTO `chat_users` VALUES (7, 'postman222', '1234', NULL, 'test', '5', NULL);
INSERT INTO `chat_users` VALUES (10, 'postman333', '1234', NULL, NULL, '6', NULL);
INSERT INTO `chat_users` VALUES (11, '5476485463748547', 'sdlfkmjeap;logvjmfoeldjgmfo', NULL, NULL, NULL, NULL);
INSERT INTO `chat_users` VALUES (12, 'eduedy', 'uoghoggho', NULL, NULL, NULL, NULL);
INSERT INTO `chat_users` VALUES (13, 'iutgoiu', 'hpohpug', NULL, NULL, NULL, NULL);
INSERT INTO `chat_users` VALUES (14, '564164168541', '4196848964', NULL, NULL, NULL, NULL);
INSERT INTO `chat_users` VALUES (15, '136521563', '03613652', NULL, NULL, NULL, NULL);
INSERT INTO `chat_users` VALUES (16, '44556565', 'fftrreedf', NULL, NULL, NULL, NULL);
INSERT INTO `chat_users` VALUES (17, '123123', '123123', NULL, NULL, NULL, NULL);
INSERT INTO `chat_users` VALUES (18, '123456', '123456', NULL, NULL, NULL, NULL);

SET FOREIGN_KEY_CHECKS = 1;
