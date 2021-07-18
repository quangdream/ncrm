/*
 Navicat Premium Data Transfer

 Source Server         : 139.180.211.113
 Source Server Type    : MySQL
 Source Server Version : 80021
 Source Host           : 139.180.211.113:3306
 Source Schema         : example

 Target Server Type    : MySQL
 Target Server Version : 80021
 File Encoding         : 65001

 Date: 17/07/2021 09:14:33
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for DATABASECHANGELOG
-- ----------------------------
DROP TABLE IF EXISTS `DATABASECHANGELOG`;
CREATE TABLE `DATABASECHANGELOG`  (
  `ID` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `AUTHOR` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `FILENAME` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `DATEEXECUTED` datetime(0) NOT NULL,
  `ORDEREXECUTED` int(0) NOT NULL,
  `EXECTYPE` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `MD5SUM` varchar(35) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `DESCRIPTION` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `COMMENTS` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `TAG` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `LIQUIBASE` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `CONTEXTS` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `LABELS` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `DEPLOYMENT_ID` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for DATABASECHANGELOGLOCK
-- ----------------------------
DROP TABLE IF EXISTS `DATABASECHANGELOGLOCK`;
CREATE TABLE `DATABASECHANGELOGLOCK`  (
  `ID` int(0) NOT NULL,
  `LOCKED` bit(1) NOT NULL,
  `LOCKGRANTED` datetime(0) NULL DEFAULT NULL,
  `LOCKEDBY` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`ID`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for app_params
-- ----------------------------
DROP TABLE IF EXISTS `app_params`;
CREATE TABLE `app_params`  (
  `id` bigint(0) NOT NULL AUTO_INCREMENT,
  `app_type` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `app_code` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `app_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 11 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of app_params
-- ----------------------------
INSERT INTO `app_params` VALUES (1, 'holistic Walks', 'synthesizing payment PCI', 'Auto Loan Account');
INSERT INTO `app_params` VALUES (2, 'calculate Maldives bleeding-edge', 'Ecuador Specialist Paradigm', 'input RSS');
INSERT INTO `app_params` VALUES (3, '24/365', 'solid state', 'Computers optimizing');
INSERT INTO `app_params` VALUES (4, 'Ville matrix', 'Hat Product', 'Surinam Dollar');
INSERT INTO `app_params` VALUES (5, 'multi-byte Soap dynamic', 'Avon', 'orchid solid state Implementation');
INSERT INTO `app_params` VALUES (6, 'web-enabled JSON Awesome Concrete Shoes', 'Syrian Arab Republic', '6th generation California');
INSERT INTO `app_params` VALUES (7, 'wireless info-mediaries Unbranded', 'Sports', 'Small');
INSERT INTO `app_params` VALUES (8, 'calculate', 'CSS', 'optimal');
INSERT INTO `app_params` VALUES (9, 'quantify Chief override', 'wireless Gorgeous Handcrafted Granite Keyboard', 'Facilitator');
INSERT INTO `app_params` VALUES (10, 'Chair Salad Polarised', 'Multi-lateral payment', 'Public-key');


-- ----------------------------
-- Table structure for category
-- ----------------------------
DROP TABLE IF EXISTS `category`;
CREATE TABLE `category`  (
  `id` bigint(0) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `code` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `des` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 11 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of category
-- ----------------------------
INSERT INTO `category` VALUES (1, 'Table', NULL, 'projection Versatile');
INSERT INTO `category` VALUES (2, 'Integration', NULL, 'bypassing SCSI applications');
INSERT INTO `category` VALUES (3, 'e-commerce', NULL, 'Fresh');
INSERT INTO `category` VALUES (4, 'transmitting XML orchestrate', NULL, 'Nevada enterprise Belarussian Ruble');
INSERT INTO `category` VALUES (5, 'fuchsia', NULL, 'Soap Chad Regional');
INSERT INTO `category` VALUES (6, 'architectures red', NULL, 'Dominica');
INSERT INTO `category` VALUES (7, 'Program Identity', NULL, 'fresh-thinking Designer');
INSERT INTO `category` VALUES (8, 'array', NULL, 'Chicken violet');
INSERT INTO `category` VALUES (9, 'Home Loan Account deposit', NULL, 'HDD');
INSERT INTO `category` VALUES (10, 'pink Investor', NULL, 'compress');

-- ----------------------------
-- Table structure for databasechangelog
-- ----------------------------
DROP TABLE IF EXISTS `databasechangelog`;
CREATE TABLE `databasechangelog`  (
  `ID` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `AUTHOR` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `FILENAME` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `DATEEXECUTED` datetime(0) NOT NULL,
  `ORDEREXECUTED` int(0) NOT NULL,
  `EXECTYPE` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `MD5SUM` varchar(35) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `DESCRIPTION` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `COMMENTS` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `TAG` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `LIQUIBASE` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `CONTEXTS` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `LABELS` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `DEPLOYMENT_ID` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for databasechangeloglock
-- ----------------------------
DROP TABLE IF EXISTS `databasechangeloglock`;
CREATE TABLE `databasechangeloglock`  (
  `ID` int(0) NOT NULL,
  `LOCKED` bit(1) NOT NULL,
  `LOCKGRANTED` datetime(0) NULL DEFAULT NULL,
  `LOCKEDBY` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`ID`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of databasechangeloglock
-- ----------------------------
INSERT INTO `databasechangeloglock` VALUES (1, b'0', NULL, NULL);

-- ----------------------------
-- Table structure for jhi_authority
-- ----------------------------
DROP TABLE IF EXISTS `jhi_authority`;
CREATE TABLE `jhi_authority`  (
  `name` varchar(50) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL,
  PRIMARY KEY (`name`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of jhi_authority
-- ----------------------------
INSERT INTO `jhi_authority` VALUES ('ROLE_ADMIN');
INSERT INTO `jhi_authority` VALUES ('ROLE_USER');

-- ----------------------------
-- Table structure for jhi_persistent_audit_event
-- ----------------------------
DROP TABLE IF EXISTS `jhi_persistent_audit_event`;
CREATE TABLE `jhi_persistent_audit_event`  (
  `event_id` bigint(0) NOT NULL AUTO_INCREMENT,
  `principal` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `event_date` timestamp(0) NULL DEFAULT NULL,
  `event_type` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`event_id`) USING BTREE,
  INDEX `idx_persistent_audit_event`(`principal`, `event_date`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 194 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for jhi_persistent_audit_evt_data
-- ----------------------------
DROP TABLE IF EXISTS `jhi_persistent_audit_evt_data`;
CREATE TABLE `jhi_persistent_audit_evt_data`  (
  `event_id` bigint(0) NOT NULL,
  `name` varchar(150) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `value` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`event_id`, `name`) USING BTREE,
  INDEX `idx_persistent_audit_evt_data`(`event_id`) USING BTREE,
  CONSTRAINT `fk_evt_pers_audit_evt_data` FOREIGN KEY (`event_id`) REFERENCES `jhi_persistent_audit_event` (`event_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for jhi_user
-- ----------------------------
DROP TABLE IF EXISTS `jhi_user`;
CREATE TABLE `jhi_user`  (
  `id` bigint(0) NOT NULL AUTO_INCREMENT,
  `login` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `password_hash` varchar(60) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `first_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `last_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `email` varchar(191) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `image_url` varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `activated` bit(1) NOT NULL,
  `lang_key` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `activation_key` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `reset_key` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `created_by` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `created_date` timestamp(0) NULL DEFAULT NULL,
  `reset_date` timestamp(0) NULL DEFAULT NULL,
  `last_modified_by` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `last_modified_date` timestamp(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `ux_user_login`(`login`) USING BTREE,
  UNIQUE INDEX `ux_user_email`(`email`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 12 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of jhi_user
-- ----------------------------
INSERT INTO `jhi_user` VALUES (1, 'system', '$2a$10$mE.qmcV0mFU5NcKh73TZx.z4ueI/.bDWbj0T1BYyqP481kGGarKLG', 'System', 'System', 'system@localhost', '', b'1', 'vi', NULL, NULL, 'system', NULL, NULL, 'system', NULL);
INSERT INTO `jhi_user` VALUES (2, 'anonymoususer', '$2a$10$j8S5d7Sr7.8VTOYNviDPOeWX8KcYILUVJBsYV83Y5NtECayypx9lO', 'Anonymous', 'User', 'anonymous@localhost', '', b'1', 'vi', NULL, NULL, 'system', NULL, NULL, 'system', NULL);
INSERT INTO `jhi_user` VALUES (3, 'admin', '$2a$10$gSAhZrxMllrbgj/kkK9UceBPpChGWJA7SYIb1Mqo.n5aNLq1/oRrC', 'Administrator', 'Administrator', 'admin@localhost', '', b'1', 'vi', NULL, NULL, 'system', NULL, NULL, 'system', NULL);
INSERT INTO `jhi_user` VALUES (4, 'user', '$2a$10$gSAhZrxMllrbgj/kkK9UceBPpChGWJA7SYIb1Mqo.n5aNLq1/oRrC', 'User', 'User', 'user@localhost', '', b'1', 'vi', NULL, NULL, 'system', NULL, NULL, 'system', NULL);

-- ----------------------------
-- Table structure for jhi_user_authority
-- ----------------------------
DROP TABLE IF EXISTS `jhi_user_authority`;
CREATE TABLE `jhi_user_authority`  (
  `user_id` bigint(0) NOT NULL,
  `authority_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  PRIMARY KEY (`user_id`, `authority_name`) USING BTREE,
  INDEX `fk_authority_name`(`authority_name`) USING BTREE,
  CONSTRAINT `fk_user_id` FOREIGN KEY (`user_id`) REFERENCES `jhi_user` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of jhi_user_authority
-- ----------------------------
INSERT INTO `jhi_user_authority` VALUES (1, 'ROLE_ADMIN');
INSERT INTO `jhi_user_authority` VALUES (3, 'ROLE_ADMIN');
INSERT INTO `jhi_user_authority` VALUES (1, 'ROLE_USER');
INSERT INTO `jhi_user_authority` VALUES (3, 'ROLE_USER');
INSERT INTO `jhi_user_authority` VALUES (4, 'ROLE_USER');

SET FOREIGN_KEY_CHECKS = 1;
