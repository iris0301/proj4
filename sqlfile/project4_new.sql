/*
Source Server Version : 50625
Source Host           : localhost:3306
Source Database       : project4

Target Server Type    : MYSQL
Target Server Version : 50625
File Encoding         : 65001

*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for Student
-- ----------------------------
DROP TABLE IF EXISTS `Student`;
CREATE TABLE `Student` (
  `id` INT(11) NOT NULL,
  `name` VARCHAR(255) DEFAULT NULL,
  `address` VARCHAR(255) DEFAULT NULL,
  `status` VARCHAR(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Table structure for Professor
-- ----------------------------
DROP TABLE IF EXISTS `Professor`;
CREATE TABLE `Professor` (
  `id` INT(11) NOT NULL,
  `name` VARCHAR(255) DEFAULT NULL,
  `deptId` VARCHAR(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Table structure for Course
-- ----------------------------
DROP TABLE IF EXISTS `Course`;
CREATE TABLE `Course` (
  `crsCode` VARCHAR(255) NOT NULL,
  `deptId` VARCHAR(255) DEFAULT NULL,
  `crsName` VARCHAR(255) DEFAULT NULL,
  `descr` VARCHAR(255) DEFAULT NULL,
  PRIMARY KEY (`crsCode`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Table structure for Teaching
-- ----------------------------
DROP TABLE IF EXISTS `Teaching`;
CREATE TABLE `Teaching` (
  `crsCode` VARCHAR(255) NOT NULL,
  `semester` VARCHAR(255) NOT NULL,
  `profId` INT(11) NOT NULL,
  PRIMARY KEY (`crsCode`, `semester`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Table structure for Transcript
-- ----------------------------
DROP TABLE IF EXISTS `Transcript`;
CREATE TABLE `Transcript` (
  `studId` INT(11) NOT NULL,
  `crsCode` VARCHAR(255) NOT NULL,
  `semester` VARCHAR(255) NOT NULL,
  `grade` VARCHAR(255) DEFAULT NULL,
  PRIMARY KEY (`studId`,`crsCode`, `semester`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
