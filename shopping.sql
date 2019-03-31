/*
Navicat MySQL Data Transfer

Source Server         : ipms
Source Server Version : 50723
Source Host           : localhost:3306
Source Database       : shopping

Target Server Type    : MYSQL
Target Server Version : 50723
File Encoding         : 65001

Date: 2019-03-31 18:24:43
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for goods
-- ----------------------------
DROP TABLE IF EXISTS `goods`;
CREATE TABLE `goods` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL COMMENT '商品名',
  `publisher_id` bigint(20) NOT NULL COMMENT '发布者Id',
  `price` decimal(19,2) NOT NULL COMMENT '商品价格',
  `summary` varchar(2500) DEFAULT NULL COMMENT '商品摘要信息',
  `description` text COMMENT '商品详细描述信息',
  `graph_name` varchar(255) DEFAULT NULL COMMENT '图片名',
  `graph_source` varchar(100) DEFAULT NULL COMMENT '图片来源',
  `graph_link` varchar(255) DEFAULT NULL COMMENT '图片存储路径',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`id`),
  KEY `id_publisher` (`publisher_id`),
  CONSTRAINT `id_publisher` FOREIGN KEY (`publisher_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COMMENT='商品表';

-- ----------------------------
-- Records of goods
-- ----------------------------
INSERT INTO `goods` VALUES ('1', '阿库娅', '1', '11.22', '阿库娅阿库娅', '阿库娅阿库娅阿库娅阿库娅', '阿库娅.jpg', 'file', '/images/0ad6a011-a58b-4414-9175-7f94c643073f_shoppingProjectImage_阿库娅.jpg', '2019-03-31 18:19:48', '2019-03-31 18:19:48');
INSERT INTO `goods` VALUES ('2', '崩坏学园', '1', '22.22', '崩坏学园图片', '崩坏学园崩坏学园崩坏学园', 'q1106a61.jpg', 'file', '/images/10e4924a-e515-487f-9f58-5abe340af136_shoppingProjectImage_q1106a61.jpg', '2019-03-31 18:22:09', '2019-03-31 18:22:09');
INSERT INTO `goods` VALUES ('3', '丹生谷森夏', '1', '33.23', '333333', '3333333', '03af87ef76c6a7ef24a135d8fdfaaf51f1de668c.jpg', 'file', '/images/61d0994f-8e52-4a9e-a9b7-d12908612fb4_shoppingProjectImage_03af87ef76c6a7ef24a135d8fdfaaf51f1de668c.jpg', '2019-03-31 18:22:36', '2019-03-31 18:22:36');
INSERT INTO `goods` VALUES ('4', '44', '1', '44.44', '44444', '44444444444', '风景2.jpg', 'file', '/images/5682c349-e9f3-4a04-8c23-d7a3233de3c3_shoppingProjectImage_风景2.jpg', '2019-03-31 18:22:56', '2019-03-31 18:22:56');

-- ----------------------------
-- Table structure for hibernate_sequence
-- ----------------------------
DROP TABLE IF EXISTS `hibernate_sequence`;
CREATE TABLE `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of hibernate_sequence
-- ----------------------------
INSERT INTO `hibernate_sequence` VALUES ('1');
INSERT INTO `hibernate_sequence` VALUES ('1');
INSERT INTO `hibernate_sequence` VALUES ('1');
INSERT INTO `hibernate_sequence` VALUES ('1');
INSERT INTO `hibernate_sequence` VALUES ('1');

-- ----------------------------
-- Table structure for order
-- ----------------------------
DROP TABLE IF EXISTS `order`;
CREATE TABLE `order` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) NOT NULL COMMENT '用户Id',
  `goods_id` bigint(20) NOT NULL COMMENT '商品Id',
  `buy_time` datetime NOT NULL COMMENT '购买时间',
  `amount` int(11) NOT NULL COMMENT '购买数量',
  `state` int(5) NOT NULL COMMENT '购买状态',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`id`),
  KEY `id_user_order` (`user_id`),
  KEY `id_goods` (`goods_id`),
  CONSTRAINT `id_goods` FOREIGN KEY (`goods_id`) REFERENCES `goods` (`id`),
  CONSTRAINT `id_user_order` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='订单表';

-- ----------------------------
-- Records of order
-- ----------------------------
INSERT INTO `order` VALUES ('1', '2', '1', '2019-03-31 18:23:15', '4', '1', '2019-03-31 18:23:15', '2019-03-31 18:23:38');
INSERT INTO `order` VALUES ('2', '2', '2', '2019-03-31 18:23:22', '2', '1', '2019-03-31 18:23:22', '2019-03-31 18:23:40');
INSERT INTO `order` VALUES ('3', '2', '3', '2019-03-31 18:23:30', '4', '0', '2019-03-31 18:23:30', '2019-03-31 18:23:30');

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `role_name` varchar(255) NOT NULL COMMENT '用户名',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='角色表';

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES ('1', 'seller', '2019-03-31 18:17:50', '2019-03-31 18:17:50');
INSERT INTO `role` VALUES ('2', 'buyer', '2019-03-31 18:17:57', '2019-03-31 18:17:57');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(255) NOT NULL COMMENT '用户名',
  `password` varchar(255) NOT NULL COMMENT '密码',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='用户表';

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'seller', '981c57a5cfb0f868e064904b8745766f', '2019-03-31 18:18:10', '2019-03-31 18:18:10');
INSERT INTO `user` VALUES ('2', 'buyer', '37254660e226ea65ce6f1efd54233424', '2019-03-31 18:18:10', '2019-03-31 18:18:10');

-- ----------------------------
-- Table structure for user_role
-- ----------------------------
DROP TABLE IF EXISTS `user_role`;
CREATE TABLE `user_role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) NOT NULL COMMENT '用户Id',
  `role_id` bigint(20) NOT NULL COMMENT '角色Id',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`id`),
  KEY `id_user` (`user_id`),
  KEY `id_role` (`role_id`),
  CONSTRAINT `id_role` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`),
  CONSTRAINT `id_user` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='用户角色表';

-- ----------------------------
-- Records of user_role
-- ----------------------------
INSERT INTO `user_role` VALUES ('1', '1', '1', '2019-03-31 18:18:10', '2019-03-31 18:18:10');
INSERT INTO `user_role` VALUES ('2', '2', '2', '2019-03-31 18:18:10', '2019-03-31 18:18:10');
