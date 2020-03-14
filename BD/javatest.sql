/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50714
Source Host           : localhost:3306
Source Database       : javatest

Target Server Type    : MYSQL
Target Server Version : 50714
File Encoding         : 65001

Date: 2020-03-14 17:01:40
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for cat_prod
-- ----------------------------
DROP TABLE IF EXISTS `cat_prod`;
CREATE TABLE `cat_prod` (
  `REF_PROD` varchar(255) NOT NULL,
  `DESIGNATION` varchar(255) DEFAULT NULL,
  `PRIX` float DEFAULT NULL,
  `QUANTITE` int(11) DEFAULT NULL,
  PRIMARY KEY (`REF_PROD`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- ----------------------------
-- Table structure for noms
-- ----------------------------
DROP TABLE IF EXISTS `noms`;
CREATE TABLE `noms` (
  `id` int(11) DEFAULT NULL,
  `nom` varchar(200) DEFAULT NULL,
  `prenom` varchar(200) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
