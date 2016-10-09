-- --------------------------------------------------------
-- ホスト:                          127.0.0.1
-- サーバのバージョン:                    5.7.15-log - MySQL Community Server (GPL)
-- サーバー OS:                      Win64
-- HeidiSQL バージョン:               9.3.0.4984
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

-- Dumping database structure for skill
CREATE DATABASE IF NOT EXISTS `skill` /*!40100 DEFAULT CHARACTER SET utf8mb4 */;
ALTER DATABASE `skill` COLLATE 'utf8mb4_general_ci';
USE `skill`;


-- Dumping structure for ビュー skill.license_view
DROP VIEW IF EXISTS `license_view`;
-- Creating temporary table to overcome VIEW dependency errors
CREATE TABLE `license_view` (
	`skill_id` INT(11) NOT NULL,
	`title_name` VARCHAR(50) NOT NULL COLLATE 'utf8mb4_general_ci',
	`version_name` VARCHAR(50) NOT NULL COLLATE 'utf8mb4_general_ci'
) ENGINE=MyISAM;


-- Dumping structure for テーブル skill.skill_category_mst
DROP TABLE IF EXISTS `skill_category_mst`;
CREATE TABLE IF NOT EXISTS `skill_category_mst` (
  `skill_category_id` int(11) NOT NULL AUTO_INCREMENT,
  `category_name` varchar(50) NOT NULL,
  PRIMARY KEY (`skill_category_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- エクスポートするデータが選択されていません


-- Dumping structure for テーブル skill.skill_title_mst
DROP TABLE IF EXISTS `skill_title_mst`;
CREATE TABLE IF NOT EXISTS `skill_title_mst` (
  `skill_title_id` int(11) NOT NULL AUTO_INCREMENT,
  `title_name` varchar(50) NOT NULL,
  `skill_category` int(11) NOT NULL COMMENT '1:資格 2:OS 3:DB 4:言語',
  PRIMARY KEY (`skill_title_id`),
  KEY `SKILL_TITLE_MST_SKILL_CATEGORY_FK1` (`skill_category`),
  CONSTRAINT `SKILL_TITLE_MST_SKILL_CATEGORY_FK1` FOREIGN KEY (`skill_category`) REFERENCES `skill_category_mst` (`skill_category_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- エクスポートするデータが選択されていません


-- Dumping structure for テーブル skill.skill_version_mst
DROP TABLE IF EXISTS `skill_version_mst`;
CREATE TABLE IF NOT EXISTS `skill_version_mst` (
  `skill_id` int(11) NOT NULL AUTO_INCREMENT,
  `skill_title` int(11) NOT NULL,
  `version_name` varchar(50) NOT NULL DEFAULT '',
  PRIMARY KEY (`skill_id`),
  UNIQUE KEY `name_version` (`skill_title`,`version_name`),
  CONSTRAINT `SKILL_VERSION_MST_SKILL_TITLE_FK` FOREIGN KEY (`skill_title`) REFERENCES `skill_title_mst` (`skill_title_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- エクスポートするデータが選択されていません


-- Dumping structure for ビュー skill.stuff_db
DROP VIEW IF EXISTS `stuff_db`;
-- Creating temporary table to overcome VIEW dependency errors
CREATE TABLE `stuff_db` (
	`id` INT(11) NOT NULL,
	`stuff_id` INT(11) NOT NULL,
	`db_name` VARCHAR(101) NOT NULL COLLATE 'utf8mb4_general_ci'
) ENGINE=MyISAM;


-- Dumping structure for ビュー skill.stuff_develop_language
DROP VIEW IF EXISTS `stuff_develop_language`;
-- Creating temporary table to overcome VIEW dependency errors
CREATE TABLE `stuff_develop_language` (
	`id` INT(11) NOT NULL,
	`stuff_id` INT(11) NOT NULL,
	`develop_language_name` VARCHAR(101) NOT NULL COLLATE 'utf8mb4_general_ci'
) ENGINE=MyISAM;


-- Dumping structure for ビュー skill.stuff_license
DROP VIEW IF EXISTS `stuff_license`;
-- Creating temporary table to overcome VIEW dependency errors
CREATE TABLE `stuff_license` (
	`id` INT(11) NOT NULL,
	`stuff_id` INT(11) NOT NULL,
	`license_name` VARCHAR(101) NOT NULL COLLATE 'utf8mb4_general_ci'
) ENGINE=MyISAM;


-- Dumping structure for テーブル skill.stuff_meta
DROP TABLE IF EXISTS `stuff_meta`;
CREATE TABLE IF NOT EXISTS `stuff_meta` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `name` varchar(50) NOT NULL COMMENT '名前',
  `age` int(11) NOT NULL COMMENT '年齢',
  `sex` tinyint(1) NOT NULL COMMENT '性別 1:男 0:女',
  `nationality` varchar(50) NOT NULL COMMENT '国籍',
  `experience_year` int(11) NOT NULL COMMENT '経験年数',
  `price` int(11) NOT NULL COMMENT '単価',
  `is_member` tinyint(1) NOT NULL COMMENT '自社社員 1:自社 0:他社',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- エクスポートするデータが選択されていません


-- Dumping structure for ビュー skill.stuff_os
DROP VIEW IF EXISTS `stuff_os`;
-- Creating temporary table to overcome VIEW dependency errors
CREATE TABLE `stuff_os` (
	`id` INT(11) NOT NULL,
	`stuff_id` INT(11) NOT NULL,
	`os_name` VARCHAR(101) NOT NULL COLLATE 'utf8mb4_general_ci'
) ENGINE=MyISAM;


-- Dumping structure for テーブル skill.stuff_skill
DROP TABLE IF EXISTS `stuff_skill`;
CREATE TABLE IF NOT EXISTS `stuff_skill` (
  `stuff_id` int(11) NOT NULL,
  `skill_id` int(11) NOT NULL,
  PRIMARY KEY (`stuff_id`,`skill_id`),
  KEY `STUFF_SKILL_STUFF_ID_FK1` (`stuff_id`),
  KEY `STUFF_SKILL_SKILL_ID_FK1` (`skill_id`),
  CONSTRAINT `STUFF_SKILL_SKILL_ID_FK1` FOREIGN KEY (`skill_id`) REFERENCES `skill_version_mst` (`skill_id`),
  CONSTRAINT `STUFF_SKILL_STUFF_ID_FK1` FOREIGN KEY (`stuff_id`) REFERENCES `stuff_meta` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- エクスポートするデータが選択されていません


-- Dumping structure for ビュー skill.license_view
DROP VIEW IF EXISTS `license_view`;
-- Removing temporary table and create final VIEW structure
DROP TABLE IF EXISTS `license_view`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `license_view` AS select `v`.`skill_id` AS `skill_id`,`t`.`title_name` AS `title_name`,`v`.`version_name` AS `version_name` from (`skill_title_mst` `t` join `skill_version_mst` `v` on((`t`.`skill_title_id` = `v`.`skill_title`)));


-- Dumping structure for ビュー skill.stuff_db
DROP VIEW IF EXISTS `stuff_db`;
-- Removing temporary table and create final VIEW structure
DROP TABLE IF EXISTS `stuff_db`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `stuff_db` AS select `v`.`skill_id` AS `id`,`s`.`stuff_id` AS `stuff_id`,concat(`t`.`title_name`,' ',`v`.`version_name`) AS `db_name` from ((`skill_title_mst` `t` join `skill_version_mst` `v`) join `stuff_skill` `s` on(((`t`.`skill_category` = 3) and (`t`.`skill_title_id` = `v`.`skill_title`) and (`v`.`skill_id` = `s`.`skill_id`))));


-- Dumping structure for ビュー skill.stuff_develop_language
DROP VIEW IF EXISTS `stuff_develop_language`;
-- Removing temporary table and create final VIEW structure
DROP TABLE IF EXISTS `stuff_develop_language`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `stuff_develop_language` AS select `v`.`skill_id` AS `id`,`s`.`stuff_id` AS `stuff_id`,concat(`t`.`title_name`,' ',`v`.`version_name`) AS `develop_language_name` from ((`skill_title_mst` `t` join `skill_version_mst` `v`) join `stuff_skill` `s` on(((`t`.`skill_category` = 4) and (`t`.`skill_title_id` = `v`.`skill_title`) and (`v`.`skill_id` = `s`.`skill_id`))));


-- Dumping structure for ビュー skill.stuff_license
DROP VIEW IF EXISTS `stuff_license`;
-- Removing temporary table and create final VIEW structure
DROP TABLE IF EXISTS `stuff_license`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `stuff_license` AS select `v`.`skill_id` AS `id`,`s`.`stuff_id` AS `stuff_id`,concat(`t`.`title_name`,' ',`v`.`version_name`) AS `license_name` from ((`skill_title_mst` `t` join `skill_version_mst` `v`) join `stuff_skill` `s` on(((`t`.`skill_category` = 1) and (`t`.`skill_title_id` = `v`.`skill_title`) and (`v`.`skill_id` = `s`.`skill_id`))));


-- Dumping structure for ビュー skill.stuff_os
DROP VIEW IF EXISTS `stuff_os`;
-- Removing temporary table and create final VIEW structure
DROP TABLE IF EXISTS `stuff_os`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `stuff_os` AS select `v`.`skill_id` AS `id`,`s`.`stuff_id` AS `stuff_id`,concat(`t`.`title_name`,' ',`v`.`version_name`) AS `os_name` from ((`skill_title_mst` `t` join `skill_version_mst` `v`) join `stuff_skill` `s` on(((`t`.`skill_category` = 2) and (`t`.`skill_title_id` = `v`.`skill_title`) and (`v`.`skill_id` = `s`.`skill_id`))));
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
