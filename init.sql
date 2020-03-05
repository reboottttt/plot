/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50727
Source Host           : localhost:3306
Source Database       : ailnep

Target Server Type    : MYSQL
Target Server Version : 50727
File Encoding         : 65001

Date: 2019-11-26 11:49:25
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for `assignview`
-- ----------------------------
DROP TABLE IF EXISTS `assignview`;
CREATE TABLE `assignview` (
  `checkMember` varchar(255) DEFAULT NULL COMMENT '标图人员',
  `userId` varchar(255) DEFAULT NULL COMMENT '任务编号',
  `pictureNumber` int(255) DEFAULT NULL COMMENT '图片数量',
  `sampleName` varchar(255) DEFAULT NULL COMMENT '图片样本名称',
  `startTime` datetime DEFAULT NULL COMMENT '创建时间',
  `imgpath` varchar(255) DEFAULT NULL,
  `acceptedList` longtext,
  `assignStatus` varchar(255) DEFAULT NULL,
  `accuracy` varchar(255) DEFAULT NULL,
  `assignDir` varchar(255) DEFAULT NULL,
  `gmtCreate` datetime DEFAULT NULL,
  `assignNumber` int(11) DEFAULT NULL,
  `assignTime` datetime DEFAULT NULL,
  `rejectReason` varchar(255) DEFAULT NULL,
  `reviewStatus` varchar(255) DEFAULT NULL,
  `uapId` int(11) NOT NULL AUTO_INCREMENT,
  `passStatus` int(11) DEFAULT NULL,
  `plotNum` int(200) DEFAULT NULL,
  `reviewOpinion` varchar(255) DEFAULT NULL,
  `assignStatusZHCN` varchar(255) DEFAULT NULL,
  `assignDate` datetime DEFAULT NULL,
  `filename` varchar(255) DEFAULT NULL,
  `finalPicturePath` varchar(255) DEFAULT NULL,
  `picturePath` varchar(255) DEFAULT NULL,
  `thumbnailPath` varchar(255) DEFAULT NULL,
  `uuid` varchar(255) DEFAULT NULL,
  `taskName` varchar(255) DEFAULT NULL,
  `typeId` varchar(255) DEFAULT NULL,
  `sampleId` int(11) DEFAULT NULL,
  `uardId` int(255) DEFAULT NULL,
  `fileListUrl` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`uapId`)
) ENGINE=InnoDB AUTO_INCREMENT=184 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of assignview
-- ----------------------------

-- ----------------------------
-- Table structure for `assignview2`
-- ----------------------------
DROP TABLE IF EXISTS `assignview2`;
CREATE TABLE `assignview2` (
  `id` int(255) NOT NULL AUTO_INCREMENT COMMENT '样本id',
  `checkMember` varchar(255) DEFAULT NULL COMMENT '标图人员',
  `assignStatus` varchar(255) DEFAULT NULL COMMENT '图片状态（1-新任务（分配未标注），2-审核通过（只有这个状态才能下载），3-提交待审核（标注待审核））',
  `pictureNumber` int(255) DEFAULT NULL COMMENT '图片数量',
  `sampleName` varchar(255) DEFAULT NULL COMMENT '图片样本名称',
  `fileListUrl` varchar(255) DEFAULT NULL COMMENT '下载路径',
  `assignTime` datetime(6) DEFAULT NULL,
  `startTime` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of assignview2
-- ----------------------------

-- ----------------------------
-- Table structure for `component`
-- ----------------------------
DROP TABLE IF EXISTS `component`;
CREATE TABLE `component` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `typename` varchar(255) DEFAULT NULL,
  `typecode` varchar(255) DEFAULT NULL,
  `componentname` varchar(255) DEFAULT NULL,
  `componentcode` varchar(255) DEFAULT NULL,
  `dtid` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=159 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of component
-- ----------------------------

-- ----------------------------
-- Table structure for `defect`
-- ----------------------------
DROP TABLE IF EXISTS `defect`;
CREATE TABLE `defect` (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `dtid` varchar(100) DEFAULT NULL COMMENT '部件ID',
  `did` varchar(100) DEFAULT NULL COMMENT '缺陷id',
  `name` varchar(255) DEFAULT NULL COMMENT '缺陷名称',
  `defect_code` varchar(255) DEFAULT NULL COMMENT '缺陷编码',
  `code` varchar(255) DEFAULT NULL COMMENT '总编码（类别code+部件code+缺陷code），是一个8位数字字符串，用来定位具体缺陷。',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=87 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of defect
-- ----------------------------

-- ----------------------------
-- Table structure for `imguploadinfo`
-- ----------------------------
DROP TABLE IF EXISTS `imguploadinfo`;
CREATE TABLE `imguploadinfo` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `imgPath` varchar(255) DEFAULT NULL COMMENT 'zip存储路径',
  `sampleName` varchar(255) DEFAULT NULL COMMENT '样本库名称',
  `pictureNumber` int(20) DEFAULT NULL COMMENT '图片个数',
  `checkMember` varchar(255) DEFAULT NULL COMMENT '标图员',
  `acceptedList` varchar(255) DEFAULT NULL COMMENT '图片路径数组',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=89 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of imguploadinfo
-- ----------------------------

-- ----------------------------
-- Table structure for `label`
-- ----------------------------
DROP TABLE IF EXISTS `label`;
CREATE TABLE `label` (
  `id` varchar(255) NOT NULL,
  `labelName` varchar(50) NOT NULL,
  `typeId` varchar(255) NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `gmtCreate` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of label
-- ----------------------------

-- ----------------------------
-- Table structure for `plotrelation`
-- ----------------------------
DROP TABLE IF EXISTS `plotrelation`;
CREATE TABLE `plotrelation` (
  `id` int(11) NOT NULL,
  `dtid` varchar(255) DEFAULT NULL,
  `did` varchar(255) DEFAULT NULL,
  `plotData` varchar(255) DEFAULT NULL,
  `code` varchar(255) DEFAULT NULL,
  `uapId` varchar(255) DEFAULT NULL,
  `uardId` int(255) DEFAULT NULL,
  `picturePath` varchar(255) DEFAULT NULL,
  `thumbnailPath` varchar(255) DEFAULT NULL,
  `finalPicturePath` varchar(255) DEFAULT NULL,
  `assignStatus` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of plotrelation
-- ----------------------------

-- ----------------------------
-- Table structure for `plotsize`
-- ----------------------------
DROP TABLE IF EXISTS `plotsize`;
CREATE TABLE `plotsize` (
  `finalPicturePath` longtext,
  `uardId` int(200) NOT NULL AUTO_INCREMENT,
  `filename` longtext,
  `size` varchar(255) DEFAULT NULL,
  `plotData` longtext,
  `uapId` varchar(255) DEFAULT NULL,
  `picturePath` longtext,
  `thumbnailPath` longtext,
  `checkMember` varchar(255) DEFAULT NULL,
  `uuid` varchar(255) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`uardId`)
) ENGINE=InnoDB AUTO_INCREMENT=363 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of plotsize
-- ----------------------------

-- ----------------------------
-- Table structure for `property`
-- ----------------------------
DROP TABLE IF EXISTS `property`;
CREATE TABLE `property` (
  `id` varchar(255) NOT NULL,
  `propertyName` varchar(255) NOT NULL,
  `labelId` varchar(255) NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `gmtCreate` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of property
-- ----------------------------

-- ----------------------------
-- Table structure for `samplelist`
-- ----------------------------
DROP TABLE IF EXISTS `samplelist`;
CREATE TABLE `samplelist` (
  `sampleId` int(11) NOT NULL AUTO_INCREMENT COMMENT '样本库唯一ID',
  `imgPath` longtext COMMENT '样本库zip存放路径',
  `sampleName` varchar(255) DEFAULT NULL COMMENT '样本名称',
  `pictureNumber` longtext COMMENT '样本数',
  `acceptedList` longtext COMMENT '样本库图片路径集',
  `startTime` datetime DEFAULT NULL COMMENT '样本库创建时间',
  `uuid` varchar(255) DEFAULT NULL COMMENT '唯一UUID',
  `key_name` varchar(255) DEFAULT NULL COMMENT '上传人员ID',
  `zip_uuid` varchar(255) DEFAULT NULL,
  `checkMember` varchar(255) DEFAULT NULL,
  `isAssign` int(11) DEFAULT NULL,
  PRIMARY KEY (`sampleId`)
) ENGINE=InnoDB AUTO_INCREMENT=438 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of samplelist
-- ----------------------------

-- ----------------------------
-- Table structure for `sys_adhocservice_url`
-- ----------------------------
DROP TABLE IF EXISTS `sys_adhocservice_url`;
CREATE TABLE `sys_adhocservice_url` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `url` varchar(255) NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_adhocservice_url
-- ----------------------------
INSERT INTO `sys_adhocservice_url` VALUES ('1', 'aiVoice', 'ws://106.14.166.51:8889', '语音识别');

-- ----------------------------
-- Table structure for `sys_permission`
-- ----------------------------
DROP TABLE IF EXISTS `sys_permission`;
CREATE TABLE `sys_permission` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `funcName` varchar(50) NOT NULL,
  `realName` varchar(50) NOT NULL,
  `url` varchar(225) NOT NULL,
  `type` int(5) NOT NULL,
  `leaf` tinyint(1) NOT NULL,
  `parentId` int(11) NOT NULL,
  `icon` varchar(255) DEFAULT NULL,
  `order` int(11) NOT NULL,
  `menuCode` varchar(255) DEFAULT NULL,
  `note` varchar(50) DEFAULT NULL,
  `gmtCreate` datetime NOT NULL,
  `gmtUpdate` datetime DEFAULT NULL,
  `creator` varchar(225) DEFAULT NULL,
  `creatorName` varchar(50) DEFAULT NULL,
  `operator` varchar(225) DEFAULT NULL,
  `operatorName` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_permission
-- ----------------------------
INSERT INTO `sys_permission` VALUES ('1', 'OperationManagement', '运营管理', '/OperationManagement', '1', '0', '-1', 'OperationManagement', '1', 'OPERATION_MANAGEMENT', '运营管理', '2019-11-11 09:59:13', '2019-11-11 09:59:17', '1', 'admin', '1', 'admin');
INSERT INTO `sys_permission` VALUES ('2', 'UserManagement', '用户管理', '/UserManagement', '2', '1', '1', 'UserManagement', '1', 'OPERATION_MANAGEMENT_USER_MANAGEMENT', '用户管理', '2019-11-11 10:01:13', '2019-11-11 10:01:17', '1', 'admin', '1', 'admin');
INSERT INTO `sys_permission` VALUES ('3', 'RoleManagement', '角色管理', '/RoleManagement', '2', '1', '1', 'RoleManagement', '1', 'OPERATION_MANAGEMENT_ROLE_MANAGEMENT', '角色管理', '2019-11-11 10:02:36', '2019-11-11 10:02:39', '1', 'admin', '1', 'admin');
INSERT INTO `sys_permission` VALUES ('4', 'SampleManagement', '样本库管理', '/SampleManagement', '1', '0', '-1', 'SampleManagement', '1', 'SampleManagement', '样本库管理', '2019-11-11 10:04:46', '2019-11-11 10:04:49', '1', 'admin', '1', 'admin');
INSERT INTO `sys_permission` VALUES ('6', 'PictureManagement', '图片管理', '/PictureManagement', '2', '1', '4', 'PictureManagement', '1', 'SAMPLE_MANAGEMENT_PICTURE_MANAGEMENT', '图片管理', '2019-11-11 10:09:40', '2019-11-11 10:09:43', '1', 'admin', '1', 'admin');
INSERT INTO `sys_permission` VALUES ('7', 'SampleReview', '样本校验', '/SampleReview', '2', '1', '4', 'SampleReview', '1', 'SAMPLE_MANAGEMENT_SAMPLE_REVIEW', '样本校验', '2019-11-11 10:11:51', '2019-11-11 10:11:57', '1', 'admin', '1', 'admin');
INSERT INTO `sys_permission` VALUES ('8', 'LabelSample', '样本标注', '/LabelSample', '2', '1', '4', 'LabelSample', '1', 'SAMPLE_MANAGEMENT_LABEL_SAMPLE', '样本标注', '2019-11-11 10:13:07', '2019-11-11 10:13:09', '1', 'admin', '1', 'admin');
INSERT INTO `sys_permission` VALUES ('9', 'GatewayService', '网关服务', '/GatewayService', '1', '0', '-1', 'GatewayService', '1', 'GatewayService', '网关服务', '2019-11-11 10:15:14', '2019-11-11 10:15:16', '1', 'admin', '1', 'admin');
INSERT INTO `sys_permission` VALUES ('10', 'GatewayManagement', '网关管理', '/GatewayManagement', '2', '1', '9', 'GatewayManagement', '1', 'GATEWAY_SERVICE_GATEWAY_MANAGEMENT', '网关管理', '2019-11-11 10:18:43', '2019-11-11 10:18:46', '1', 'admin', '1', 'admin');
INSERT INTO `sys_permission` VALUES ('11', 'AccessManagement', '鉴权管理', '/AccessManagement', '2', '1', '9', 'AccessManagement', '1', 'GATEWAY_SERVICE_ACCESS_MANAGEMENT', '鉴权管理', '2019-11-11 10:27:28', '2019-11-11 10:27:31', '1', 'admin', '1', 'admin');
INSERT INTO `sys_permission` VALUES ('12', 'ModelManagement', '模型管理', '/ModelManagement', '1', '0', '-1', 'ModelManagement', '1', 'ModelManagement', '模型管理', '2019-11-13 15:39:59', '2019-11-13 15:40:02', '1', 'admin', '1', 'admin');
INSERT INTO `sys_permission` VALUES ('13', 'BasicModel', '模型', '/BasicModel', '2', '1', '12', 'BasicModel', '1', 'MODEL_MANAGEMENT_BASIC_MODEL', '模型', '2019-11-13 15:42:42', '2019-11-13 15:42:45', '1', 'admin', '1', 'admin');
INSERT INTO `sys_permission` VALUES ('14', 'Mirroring', '镜像', '/Mirroring', '2', '1', '12', 'Mirroring', '1', 'MODEL_MANAGEMENT_MIRRORING', '镜像', '2019-11-13 15:44:05', '2019-11-13 15:44:08', '1', 'admin', '1', 'admin');
INSERT INTO `sys_permission` VALUES ('15', 'Ad-hocservice', 'AI体验', '/Ad-hocservice', '1', '0', '-1', 'Ad-hocservice', '1', 'Ad-hocservice', '即席服务', '2019-11-18 09:40:25', '2019-11-18 09:40:28', '1', 'admin', '1', 'admin');
INSERT INTO `sys_permission` VALUES ('16', 'FACE_RECOGNITION', '人脸识别', '/FACE_RECOGNITION', '2', '1', '15', 'FACE_RECOGNITION', '1', 'FACE_RECOGNITION', '人脸识别', '2019-11-18 09:41:47', '2019-11-18 09:41:49', '1', 'admin', '1', 'admin');
INSERT INTO `sys_permission` VALUES ('17', 'OPTICAL_CHARACTER_RECOGNITION', '文字识别', '/OPTICAL_CHARACTER_RECOGNITION', '2', '1', '15', 'OPTICAL_CHARACTER_RECOGNITION', '1', 'OPTICAL_CHARACTER_RECOGNITION', '文字识别', '2019-11-18 09:42:59', '2019-11-18 09:43:02', '1', 'admin', '1', 'admin');
INSERT INTO `sys_permission` VALUES ('18', 'VOICE_RECOGNITION', '语音识别', '/VOICE_RECOGNITION', '2', '1', '15', 'VOICE_RECOGNITION', '1', 'VOICE_RECOGNITION', '语音识别', '2019-11-18 09:44:03', '2019-11-18 09:44:06', '1', 'admin', '1', 'admin');
INSERT INTO `sys_permission` VALUES ('19', 'TypeManagement', '类型管理', '/TypeManagement', '2', '1', '4', 'TypeManagement', '1', 'SAMPLE_MANAGEMENT_TYPE_MANAGEMENT', '类型管理', '2019-11-21 16:05:12', '2019-11-21 16:05:16', '1', 'admin', '1', 'admin');
INSERT INTO `sys_permission` VALUES ('20', 'LabelManagement', '标签管理', '/LabelManagement', '2', '1', '4', 'LabelManagement', '1', 'SAMPLE_MANAGEMENT_LABEL_MANAGEMENT', '标签管理', '2019-11-21 16:06:49', '2019-11-21 16:06:52', '1', 'admin', '1', 'admin');
INSERT INTO `sys_permission` VALUES ('21', 'Download', '样本下载', '/Download', '2', '1', '4', 'Download', '1', 'SAMPLE_MANAGEMENT_SAMPLE_DOWNLOAD', '样本下载', '2019-11-21 16:08:24', '2019-11-21 16:08:27', '1', 'admin', '1', 'admin');
INSERT INTO `sys_permission` VALUES ('22', 'PropertyManagement', '属性管理', '/PropertyManagement', '2', '1', '4', 'PropertyManagement', '1', 'SAMPLE_MANAGEMENT_PROPERTY_MANAGEMENT', '属性管理', '2019-11-22 14:38:02', '2019-11-22 14:38:05', '1', 'admin', '1', 'admin');
INSERT INTO `sys_permission` VALUES ('23', 'SampleUpload', '样本上传', '/SampleUpload', '2', '1', '4', 'SampleUpload', '1', 'SAMPLE_LIBRABRY_UPLOAD', '样本上传', '2019-11-26 11:48:44', '2019-11-26 11:48:48', '1', 'admin', '1', 'admin');

-- ----------------------------
-- Table structure for `sys_role`
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `description` varchar(50) DEFAULT NULL,
  `isUpload` int(11) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `gmtCreate` datetime NOT NULL,
  `gmtUpdate` datetime DEFAULT NULL,
  `creator` varchar(225) DEFAULT NULL,
  `creatorName` varchar(50) DEFAULT NULL,
  `operator` varchar(225) DEFAULT NULL,
  `operatorName` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_role
-- ----------------------------
INSERT INTO `sys_role` VALUES ('1', '超级管理员', '超级管理员', '1', '1', '2019-11-05 09:48:00', '2019-11-22 14:47:50', '1', 'admin', '1', 'admin');
INSERT INTO `sys_role` VALUES ('2', '分图用户', '分图用户', '1', '1', '2019-11-05 10:54:53', '2019-11-12 16:46:15', '1', 'admin', '1', 'admin');
INSERT INTO `sys_role` VALUES ('3', '标图用户', '标图用户', '1', '1', '2019-11-11 09:56:45', '2019-11-23 17:56:05', '1', 'admin', '1', 'admin');

-- ----------------------------
-- Table structure for `sys_role_permission`
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_permission`;
CREATE TABLE `sys_role_permission` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `role` int(11) NOT NULL,
  `permission` int(11) NOT NULL,
  `writes` tinyint(4) NOT NULL,
  `description` varchar(50) DEFAULT NULL,
  `gmtUpdate` datetime DEFAULT NULL,
  `gmtCreate` datetime NOT NULL,
  `creator` varchar(225) DEFAULT NULL,
  `creatorName` varchar(50) DEFAULT NULL,
  `operator` varchar(225) DEFAULT NULL,
  `operatorName` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=455 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_role_permission
-- ----------------------------
INSERT INTO `sys_role_permission` VALUES ('83', '2', '4', '0', null, null, '2019-11-12 16:46:15', null, null, null, null);
INSERT INTO `sys_role_permission` VALUES ('84', '2', '5', '0', null, null, '2019-11-12 16:46:15', null, null, null, null);
INSERT INTO `sys_role_permission` VALUES ('85', '2', '6', '0', null, null, '2019-11-12 16:46:15', null, null, null, null);
INSERT INTO `sys_role_permission` VALUES ('86', '2', '7', '0', null, null, '2019-11-12 16:46:15', null, null, null, null);
INSERT INTO `sys_role_permission` VALUES ('87', '2', '8', '0', null, null, '2019-11-12 16:46:15', null, null, null, null);
INSERT INTO `sys_role_permission` VALUES ('401', '1', '1', '1', null, null, '2019-11-22 14:47:50', null, null, null, null);
INSERT INTO `sys_role_permission` VALUES ('402', '1', '2', '1', null, null, '2019-11-22 14:47:50', null, null, null, null);
INSERT INTO `sys_role_permission` VALUES ('403', '1', '3', '1', null, null, '2019-11-22 14:47:50', null, null, null, null);
INSERT INTO `sys_role_permission` VALUES ('404', '1', '9', '1', null, null, '2019-11-22 14:47:50', null, null, null, null);
INSERT INTO `sys_role_permission` VALUES ('405', '1', '10', '1', null, null, '2019-11-22 14:47:50', null, null, null, null);
INSERT INTO `sys_role_permission` VALUES ('406', '1', '11', '1', null, null, '2019-11-22 14:47:50', null, null, null, null);
INSERT INTO `sys_role_permission` VALUES ('407', '1', '12', '1', null, null, '2019-11-22 14:47:50', null, null, null, null);
INSERT INTO `sys_role_permission` VALUES ('408', '1', '13', '1', null, null, '2019-11-22 14:47:50', null, null, null, null);
INSERT INTO `sys_role_permission` VALUES ('409', '1', '14', '1', null, null, '2019-11-22 14:47:50', null, null, null, null);
INSERT INTO `sys_role_permission` VALUES ('410', '1', '15', '1', null, null, '2019-11-22 14:47:50', null, null, null, null);
INSERT INTO `sys_role_permission` VALUES ('411', '1', '16', '1', null, null, '2019-11-22 14:47:50', null, null, null, null);
INSERT INTO `sys_role_permission` VALUES ('412', '1', '17', '1', null, null, '2019-11-22 14:47:50', null, null, null, null);
INSERT INTO `sys_role_permission` VALUES ('413', '1', '18', '1', null, null, '2019-11-22 14:47:50', null, null, null, null);
INSERT INTO `sys_role_permission` VALUES ('414', '1', '4', '1', null, null, '2019-11-22 14:47:50', null, null, null, null);
INSERT INTO `sys_role_permission` VALUES ('415', '1', '6', '1', null, null, '2019-11-22 14:47:50', null, null, null, null);
INSERT INTO `sys_role_permission` VALUES ('416', '1', '7', '1', null, null, '2019-11-22 14:47:50', null, null, null, null);
INSERT INTO `sys_role_permission` VALUES ('417', '1', '8', '1', null, null, '2019-11-22 14:47:50', null, null, null, null);
INSERT INTO `sys_role_permission` VALUES ('418', '1', '19', '1', null, null, '2019-11-22 14:47:50', null, null, null, null);
INSERT INTO `sys_role_permission` VALUES ('419', '1', '20', '1', null, null, '2019-11-22 14:47:50', null, null, null, null);
INSERT INTO `sys_role_permission` VALUES ('420', '1', '21', '1', null, null, '2019-11-22 14:47:50', null, null, null, null);
INSERT INTO `sys_role_permission` VALUES ('421', '1', '22', '1', null, null, '2019-11-22 14:47:50', null, null, null, null);
INSERT INTO `sys_role_permission` VALUES ('444', '5', '17', '1', null, null, '2019-11-23 14:13:38', null, null, null, null);
INSERT INTO `sys_role_permission` VALUES ('445', '5', '18', '0', null, null, '2019-11-23 14:13:38', null, null, null, null);
INSERT INTO `sys_role_permission` VALUES ('446', '4', '12', '1', null, null, '2019-11-23 14:28:13', null, null, null, null);
INSERT INTO `sys_role_permission` VALUES ('447', '4', '13', '1', null, null, '2019-11-23 14:28:13', null, null, null, null);
INSERT INTO `sys_role_permission` VALUES ('448', '4', '14', '1', null, null, '2019-11-23 14:28:13', null, null, null, null);
INSERT INTO `sys_role_permission` VALUES ('449', '4', '15', '1', null, null, '2019-11-23 14:28:13', null, null, null, null);
INSERT INTO `sys_role_permission` VALUES ('450', '4', '16', '0', null, null, '2019-11-23 14:28:13', null, null, null, null);
INSERT INTO `sys_role_permission` VALUES ('451', '4', '17', '1', null, null, '2019-11-23 14:28:13', null, null, null, null);
INSERT INTO `sys_role_permission` VALUES ('452', '4', '18', '0', null, null, '2019-11-23 14:28:13', null, null, null, null);
INSERT INTO `sys_role_permission` VALUES ('453', '3', '6', '1', null, null, '2019-11-23 17:56:05', null, null, null, null);
INSERT INTO `sys_role_permission` VALUES ('454', '3', '8', '1', null, null, '2019-11-23 17:56:05', null, null, null, null);

-- ----------------------------
-- Table structure for `sys_user`
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
  `id` varchar(225) NOT NULL,
  `name` varchar(50) NOT NULL,
  `account` varchar(50) NOT NULL,
  `password` varchar(255) NOT NULL,
  `mobile` varchar(11) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `onlineStatus` int(11) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `gmtCreate` datetime NOT NULL,
  `gmtUpdate` datetime DEFAULT NULL,
  `creator` varchar(225) DEFAULT NULL,
  `creatorName` varchar(50) DEFAULT NULL,
  `operator` varchar(225) DEFAULT NULL,
  `operatorName` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES ('1', 'admin', 'aiadmin', 'k9a0Ah2PBzaeoCUw12QKPYorC0F8t17Gl2I081LuegaKjaCvk/b8mGGas0zzTra81sEs1FlYKaAeU3EQDVBYgk3NIAnozEvt+nfUq6E/qh0OvEiX7wa6cEnuqqNDCNbUApfQIJz6x60sbBd3wejUFVRBTD9mf/FxRW+cyoiT304=', '13253315890', 'ai@qq.com', null, null, '2019-11-08 10:43:53', '2019-11-05 09:49:36', '1', 'admin', '1', 'admin');

-- ----------------------------
-- Table structure for `sys_user_role`
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_role`;
CREATE TABLE `sys_user_role` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `user` varchar(225) NOT NULL,
  `role` int(11) NOT NULL,
  `gmtCreate` datetime DEFAULT NULL,
  `gmtUpdate` datetime DEFAULT NULL,
  `creator` varchar(225) DEFAULT NULL,
  `creatorName` varchar(50) DEFAULT NULL,
  `operator` varchar(225) DEFAULT NULL,
  `operatorName` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=70 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_user_role
-- ----------------------------
INSERT INTO `sys_user_role` VALUES ('1', '1', '1', '2019-11-08 10:43:53', null, null, null, null, null);

-- ----------------------------
-- Table structure for `type`
-- ----------------------------
DROP TABLE IF EXISTS `type`;
CREATE TABLE `type` (
  `id` varchar(255) NOT NULL,
  `typeName` varchar(50) NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `gmtCreate` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of type
-- ----------------------------

-- ----------------------------
-- Table structure for `users`
-- ----------------------------
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
  `id` varchar(200) NOT NULL COMMENT '用户id',
  `account` varchar(255) DEFAULT NULL COMMENT '当前用户',
  `name` varchar(255) DEFAULT NULL COMMENT '标图人员',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of users
-- ----------------------------