/*
 Navicat Premium Data Transfer

 Source Server         : localhost_3306
 Source Server Type    : MySQL
 Source Server Version : 80017
 Source Host           : localhost:3306
 Source Schema         : hrms

 Target Server Type    : MySQL
 Target Server Version : 80017
 File Encoding         : 65001

 Date: 30/05/2020 10:02:10
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for appraise
-- ----------------------------
DROP TABLE IF EXISTS `appraise`;
CREATE TABLE `appraise`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `eid` int(11) NULL DEFAULT NULL,
  `appDate` date NULL DEFAULT NULL COMMENT '考评日期',
  `appResult` enum('优','良','合格','不合格') CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '考评结果',
  `appContent` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '考评内容',
  `remark` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `eid`(`eid`) USING BTREE,
  CONSTRAINT `appraise_ibfk_1` FOREIGN KEY (`eid`) REFERENCES `emp` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '评估' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of appraise
-- ----------------------------
INSERT INTO `appraise` VALUES (1, 1, '2018-08-07', '优', '', '');
INSERT INTO `appraise` VALUES (2, 4, '2018-08-07', '良', '', '');

-- ----------------------------
-- Table structure for contract
-- ----------------------------
DROP TABLE IF EXISTS `contract`;
CREATE TABLE `contract`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '合同编号',
  `workID` char(8) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '工号',
  `contractTerm` double NULL DEFAULT NULL COMMENT '合同期限',
  `beginContract` date NULL DEFAULT NULL COMMENT '合同起始日期',
  `endContract` date NULL DEFAULT NULL COMMENT '合同终止日期',
  `contractContent` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '合同内容',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `workID`(`workID`) USING BTREE,
  CONSTRAINT `contract_ibfk_1` FOREIGN KEY (`workID`) REFERENCES `emp` (`workID`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '合同' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of contract
-- ----------------------------
INSERT INTO `contract` VALUES (1, 'sdf4215', 10, '2011-07-05', '2021-08-07', 'xxxxxxxxxxxxxxxxxxxxx');
INSERT INTO `contract` VALUES (2, 'sdf7425', 5, '2015-07-09', '2020-12-09', '');
INSERT INTO `contract` VALUES (3, 'sdf5437', 6, '2017-05-10', '2023-05-10', '');

-- ----------------------------
-- Table structure for dept
-- ----------------------------
DROP TABLE IF EXISTS `dept`;
CREATE TABLE `dept`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '名称',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '部门' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of dept
-- ----------------------------
INSERT INTO `dept` VALUES (1, '行政部');
INSERT INTO `dept` VALUES (2, '财务部');
INSERT INTO `dept` VALUES (3, '质量管理部');
INSERT INTO `dept` VALUES (4, '营销部');
INSERT INTO `dept` VALUES (5, '营运部');
INSERT INTO `dept` VALUES (6, '研发部');
INSERT INTO `dept` VALUES (7, '运维部');
INSERT INTO `dept` VALUES (8, '人事部');
INSERT INTO `dept` VALUES (9, '客户服务部');

-- ----------------------------
-- Table structure for emp
-- ----------------------------
DROP TABLE IF EXISTS `emp`;
CREATE TABLE `emp`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '员工编号',
  `name` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '员工姓名',
  `age` int(10) NULL DEFAULT NULL COMMENT '年龄',
  `gender` char(4) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '性别',
  `birthday` date NULL DEFAULT NULL COMMENT '出生日期',
  `IDCard` char(18) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '身份证号',
  `wedlock` enum('已婚','未婚','离异') CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '婚姻状况',
  `nationId` int(8) NULL DEFAULT NULL COMMENT '民族',
  `nativePlace` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '籍贯',
  `email` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '邮箱',
  `phone` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '电话号码',
  `address` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '联系地址',
  `deptId` int(11) NOT NULL COMMENT '所属部门',
  `posId` int(11) NOT NULL COMMENT '职位ID',
  `degree` enum('博士','硕士','本科','大专','高中','初中','小学','其他') CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '最高学历',
  `school` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '毕业院校',
  `edate` date NULL DEFAULT NULL COMMENT '入职日期',
  `workState` enum('在职','离职') CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '在职' COMMENT '在职状态',
  `workID` char(8) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '工号',
  `conversionTime` date NULL DEFAULT NULL COMMENT '转正日期',
  `workAge` int(11) NULL DEFAULT NULL COMMENT '工龄',
  `notWorkDate` date NULL DEFAULT NULL COMMENT '离职日期',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `deptId`(`deptId`) USING BTREE,
  INDEX `posId`(`posId`) USING BTREE,
  INDEX `nationId`(`nationId`) USING BTREE,
  INDEX `workId`(`workID`) USING BTREE,
  CONSTRAINT `emp_ibfk_1` FOREIGN KEY (`nationId`) REFERENCES `nation` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `emp_ibfk_2` FOREIGN KEY (`deptId`) REFERENCES `dept` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `emp_ibfk_3` FOREIGN KEY (`posId`) REFERENCES `position` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 14 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '员工' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of emp
-- ----------------------------
INSERT INTO `emp` VALUES (1, '张三', 35, '男', '1985-07-08', '456321754215896354', '已婚', 1, '湖南', 'zhangsan@163.com', '17452135841', 'dsadsfvgbnh', 1, 1, '博士', '湘潭大学', '2010-07-01', '在职', 'sdf4215', NULL, NULL, NULL);
INSERT INTO `emp` VALUES (2, '李四', 36, '男', '1984-04-06', '489653214754123586', '已婚', 1, '湖北', 'lisi@163.com', '13564721547', 'cwdhetdm', 1, 1, '博士', '', NULL, '在职', 'sdf7425', NULL, NULL, NULL);
INSERT INTO `emp` VALUES (3, '张强', 28, '男', '1993-08-05', '542135874521578945', '已婚', 1, '江苏', 'zhangqiang@163.com', '14785426357', 'xxxxxxxxxxxxxxx', 3, 12, '博士', '', NULL, '在职', 'sdf5437', NULL, NULL, NULL);
INSERT INTO `emp` VALUES (4, '李宇', 28, '男', '1992-04-09', '', '已婚', 1, '', '', '17548963254', 'xxxxxxxxx', 3, 3, '博士', '', NULL, '在职', 'sdf8452', NULL, NULL, NULL);
INSERT INTO `emp` VALUES (5, '李雯', 25, '女', '1996-07-09', '', '已婚', 1, '', '', '13526541234', 'xxxxxxxxx', 4, 2, '博士', '', NULL, '在职', 'sdf7854', NULL, NULL, NULL);
INSERT INTO `emp` VALUES (6, '王思达', 37, '男', '1983-01-06', '452136198301066985', '已婚', 1, '', '', '17452136854', 'sjngvbc', 5, 16, '大专', '', NULL, '在职', 'sdf4217', NULL, NULL, NULL);
INSERT INTO `emp` VALUES (7, '赵芳', 29, '女', '1991-07-06', '458712354621586324', '未婚', 1, '', '', '13542687942', 'tfgcvggh', 2, 9, '大专', '', NULL, '在职', 'sdf7845', NULL, NULL, NULL);
INSERT INTO `emp` VALUES (8, '邹好', 26, '女', '1994-06-04', '', '已婚', 1, '', '', '16542314785', 'ghskcbwhe', 4, 18, '高中', '', NULL, '在职', 'sdf7496', NULL, NULL, NULL);
INSERT INTO `emp` VALUES (9, '李韵', 34, '男', '1986-03-16', '', '已婚', 1, '', '', '14523147852', 'wsdfgefv', 1, 3, '博士', '', NULL, '在职', 'sdf5780', NULL, NULL, NULL);
INSERT INTO `emp` VALUES (10, '王桂芳', 39, '女', '1981-06-05', '', '已婚', 1, '', '', '18452369785', 'wsdfvvefvcs', 2, 8, '大专', '', NULL, '在职', 'sdf3456', NULL, NULL, NULL);
INSERT INTO `emp` VALUES (11, '洪强国', 43, '男', '1977-09-26', '', '已婚', 1, '', '', '15236987452', 'dfnxv4rt', 7, 21, '大专', '', NULL, '在职', 'sdf5221', NULL, NULL, NULL);
INSERT INTO `emp` VALUES (13, '刘安福', 45, '男', '1975-08-06', '', '已婚', 1, '', '', '15236984521', 'sdg7hhbb', 1, 1, '大专', '', NULL, '在职', 'sdf7894', NULL, NULL, NULL);
INSERT INTO `emp` VALUES (14, '李芳', 27, '女', '1993-02-04', '', '已婚', 1, '', '', '15423578541', 'sdfebe', 2, 10, '本科', '', NULL, '在职', 'sdf7854', NULL, NULL, NULL);

-- ----------------------------
-- Table structure for emprp
-- ----------------------------
DROP TABLE IF EXISTS `emprp`;
CREATE TABLE `emprp`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `eid` int(11) NULL DEFAULT NULL COMMENT '员工编号',
  `rpDate` date NULL DEFAULT NULL COMMENT '奖罚日期',
  `rpType` enum('奖','罚') CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '奖罚类型',
  `rpReason` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '奖罚原因',
  `rpPoint` int(11) NULL DEFAULT NULL COMMENT '奖罚分(满分100)',
  `remark` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `eid`(`eid`) USING BTREE,
  CONSTRAINT `emprp_ibfk_1` FOREIGN KEY (`eid`) REFERENCES `emp` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '员工奖惩情况' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of emprp
-- ----------------------------
INSERT INTO `emprp` VALUES (1, 1, '2018-09-08', '罚', '迟到', 95, '');
INSERT INTO `emprp` VALUES (3, 2, '2019-07-06', '罚', '早退', 95, '');

-- ----------------------------
-- Table structure for empsalary
-- ----------------------------
DROP TABLE IF EXISTS `empsalary`;
CREATE TABLE `empsalary`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `eid` int(11) NULL DEFAULT NULL COMMENT '员工编号',
  `sid` int(11) NULL DEFAULT NULL COMMENT '薪资账套编号',
  `sal` double(11, 2) NULL DEFAULT NULL COMMENT '员工工资',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `eid`(`eid`) USING BTREE,
  INDEX `empsalary_ibfk_2`(`sid`) USING BTREE,
  CONSTRAINT `empsalary_ibfk_1` FOREIGN KEY (`eid`) REFERENCES `emp` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `empsalary_ibfk_2` FOREIGN KEY (`sid`) REFERENCES `salary` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '员工工资' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of empsalary
-- ----------------------------
INSERT INTO `empsalary` VALUES (1, 1, 1, 7000.00);
INSERT INTO `empsalary` VALUES (2, 2, 2, 8000.00);
INSERT INTO `empsalary` VALUES (3, 4, 1, 8000.00);

-- ----------------------------
-- Table structure for emptrain
-- ----------------------------
DROP TABLE IF EXISTS `emptrain`;
CREATE TABLE `emptrain`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `eid` int(11) NULL DEFAULT NULL COMMENT '员工编号',
  `trainDate` date NULL DEFAULT NULL COMMENT '培训日期',
  `trainContent` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '培训内容',
  `remark` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `pid`(`eid`) USING BTREE,
  CONSTRAINT `employeetrain_ibfk_1` FOREIGN KEY (`eid`) REFERENCES `emp` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '员工培训' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of emptrain
-- ----------------------------
INSERT INTO `emptrain` VALUES (1, 1, '2017-08-05', 'xxxxx', '');
INSERT INTO `emptrain` VALUES (3, 4, '2018-09-04', 'xxxxxxx', '');

-- ----------------------------
-- Table structure for nation
-- ----------------------------
DROP TABLE IF EXISTS `nation`;
CREATE TABLE `nation`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 56 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '民族' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of nation
-- ----------------------------
INSERT INTO `nation` VALUES (1, '汉族');
INSERT INTO `nation` VALUES (2, '蒙古族');
INSERT INTO `nation` VALUES (3, '回族');
INSERT INTO `nation` VALUES (4, '藏族');
INSERT INTO `nation` VALUES (5, '维吾尔族');
INSERT INTO `nation` VALUES (6, '苗族');
INSERT INTO `nation` VALUES (7, '彝族');
INSERT INTO `nation` VALUES (8, '壮族');
INSERT INTO `nation` VALUES (9, '布依族');
INSERT INTO `nation` VALUES (10, '朝鲜族');
INSERT INTO `nation` VALUES (11, '满族');
INSERT INTO `nation` VALUES (12, '侗族');
INSERT INTO `nation` VALUES (13, '瑶族');
INSERT INTO `nation` VALUES (14, '白族');
INSERT INTO `nation` VALUES (15, '土家族');
INSERT INTO `nation` VALUES (16, '哈尼族');
INSERT INTO `nation` VALUES (17, '哈萨克族');
INSERT INTO `nation` VALUES (18, '傣族');
INSERT INTO `nation` VALUES (19, '黎族');
INSERT INTO `nation` VALUES (20, '傈僳族');
INSERT INTO `nation` VALUES (21, '佤族');
INSERT INTO `nation` VALUES (22, '畲族');
INSERT INTO `nation` VALUES (23, '高山族');
INSERT INTO `nation` VALUES (24, '拉祜族');
INSERT INTO `nation` VALUES (25, '水族');
INSERT INTO `nation` VALUES (26, '东乡族');
INSERT INTO `nation` VALUES (27, '纳西族');
INSERT INTO `nation` VALUES (28, '景颇族');
INSERT INTO `nation` VALUES (29, '柯尔克孜族');
INSERT INTO `nation` VALUES (30, '土族');
INSERT INTO `nation` VALUES (31, '达斡尔族');
INSERT INTO `nation` VALUES (32, '仫佬族');
INSERT INTO `nation` VALUES (33, '羌族');
INSERT INTO `nation` VALUES (34, '布朗族');
INSERT INTO `nation` VALUES (35, '撒拉族');
INSERT INTO `nation` VALUES (36, '毛难族');
INSERT INTO `nation` VALUES (37, '仡佬族');
INSERT INTO `nation` VALUES (38, '锡伯族');
INSERT INTO `nation` VALUES (39, '阿昌族');
INSERT INTO `nation` VALUES (40, '普米族');
INSERT INTO `nation` VALUES (41, '塔吉克族');
INSERT INTO `nation` VALUES (42, '怒族');
INSERT INTO `nation` VALUES (43, '乌孜别克族');
INSERT INTO `nation` VALUES (44, '俄罗斯族');
INSERT INTO `nation` VALUES (45, '鄂温克族');
INSERT INTO `nation` VALUES (46, '崩龙族');
INSERT INTO `nation` VALUES (47, '保安族');
INSERT INTO `nation` VALUES (48, '裕固族');
INSERT INTO `nation` VALUES (49, '京族');
INSERT INTO `nation` VALUES (50, '塔塔尔族');
INSERT INTO `nation` VALUES (51, '独龙族');
INSERT INTO `nation` VALUES (52, '鄂伦春族');
INSERT INTO `nation` VALUES (53, '赫哲族');
INSERT INTO `nation` VALUES (54, '门巴族');
INSERT INTO `nation` VALUES (55, '珞巴族');
INSERT INTO `nation` VALUES (56, '基诺族');

-- ----------------------------
-- Table structure for position
-- ----------------------------
DROP TABLE IF EXISTS `position`;
CREATE TABLE `position`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '职位名称',
  `did` int(11) NULL DEFAULT NULL COMMENT '部门id',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `name`(`name`) USING BTREE,
  INDEX `pos_ibfk_1`(`did`) USING BTREE,
  CONSTRAINT `pos_ibfk_1` FOREIGN KEY (`did`) REFERENCES `dept` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 23 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '职位' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of position
-- ----------------------------
INSERT INTO `position` VALUES (1, '行政总监', 1);
INSERT INTO `position` VALUES (2, '行政经理', 1);
INSERT INTO `position` VALUES (3, '行政主管', 1);
INSERT INTO `position` VALUES (4, '行政专员', 1);
INSERT INTO `position` VALUES (5, '行政助理', 1);
INSERT INTO `position` VALUES (6, '统计员', 2);
INSERT INTO `position` VALUES (7, '财务经理', 2);
INSERT INTO `position` VALUES (8, '财务主管', 2);
INSERT INTO `position` VALUES (9, '财务专员', 2);
INSERT INTO `position` VALUES (10, '财务助理', 2);
INSERT INTO `position` VALUES (11, '质量检验员', 3);
INSERT INTO `position` VALUES (12, '质量测试员', 3);
INSERT INTO `position` VALUES (13, '认证工程师', 3);
INSERT INTO `position` VALUES (14, '认证审核员', 3);
INSERT INTO `position` VALUES (15, '销售总监', 4);
INSERT INTO `position` VALUES (16, '销售经理', 4);
INSERT INTO `position` VALUES (17, '销售主管', 4);
INSERT INTO `position` VALUES (18, '销售代表', 4);
INSERT INTO `position` VALUES (19, '营运总监', 5);
INSERT INTO `position` VALUES (20, '营运总监助理', 5);
INSERT INTO `position` VALUES (21, '营运经理', 5);
INSERT INTO `position` VALUES (22, '市场推广经理', 5);
INSERT INTO `position` VALUES (23, '商场经理', 5);

-- ----------------------------
-- Table structure for salary
-- ----------------------------
DROP TABLE IF EXISTS `salary`;
CREATE TABLE `salary`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `basicSalary` int(11) NULL DEFAULT NULL COMMENT '基本工资',
  `bonus` int(11) NULL DEFAULT NULL COMMENT '奖金',
  `lunchSalary` int(11) NULL DEFAULT NULL COMMENT '午餐补助',
  `trafficSalary` int(11) NULL DEFAULT NULL COMMENT '交通补助',
  `allSalary` int(11) NULL DEFAULT NULL COMMENT '应发工资',
  `pensionBase` int(11) NULL DEFAULT NULL COMMENT '养老金基数',
  `pensionPer` double NULL DEFAULT NULL COMMENT '养老金比率',
  `medicalBase` int(11) NULL DEFAULT NULL COMMENT '医疗基数',
  `medicalPer` double NULL DEFAULT NULL COMMENT '医疗保险比率',
  `accumulationFundBase` int(11) NULL DEFAULT NULL COMMENT '公积金基数',
  `accumulationFundPer` double NULL DEFAULT NULL COMMENT '公积金比率',
  `name` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '工资账套' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of salary
-- ----------------------------
INSERT INTO `salary` VALUES (1, 4000, 4000, 800, 500, NULL, 2000, 0.07000000029802322, 2000, 0.07000000029802322, 2000, 0.07000000029802322, '营销部工资账套');
INSERT INTO `salary` VALUES (2, 2000, 3000, 400, 1000, NULL, 2000, 0.07000000029802322, 2000, 0.07000000029802322, 2000, 0.07000000029802322, '人事部工资账套');
INSERT INTO `salary` VALUES (3, 5000, 3000, 500, 500, NULL, 4000, 0.07000000029802322, 4000, 0.07000000029802322, 4000, 0.07000000029802322, '运维部工资账套');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `username` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户名',
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '密码',
  `email` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '邮箱',
  `enabled` int(1) NULL DEFAULT NULL COMMENT '状态：1启用、0禁用',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `UK_kpubos9gc2cvtkb0thktkbkes`(`email`) USING BTREE,
  UNIQUE INDEX `username`(`username`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '系统用户' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, 'admin', '123456', 'admin@163.com', 1);
INSERT INTO `user` VALUES (2, 'lmj', '123456', 'lmj@163.com', 0);

SET FOREIGN_KEY_CHECKS = 1;
