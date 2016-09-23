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


-- Dumping structure for テーブル skill.stuff_db
CREATE TABLE IF NOT EXISTS `stuff_db` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `stuff_id` int(11) NOT NULL COMMENT '社員ナンバー',
  `db_name` varchar(50) NOT NULL COMMENT 'DB名称',
  PRIMARY KEY (`id`),
  KEY `stuff_id` (`stuff_id`),
  CONSTRAINT `STUFF_DB_STUFF_ID_FK` FOREIGN KEY (`stuff_id`) REFERENCES `stuff_meta` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- エクスポートするデータが選択されていません


-- Dumping structure for テーブル skill.stuff_db_mst
CREATE TABLE IF NOT EXISTS `stuff_db_mst` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `version` varchar(50) DEFAULT NULL,
  `enable_version` tinyint(4) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `name_version` (`name`,`version`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- エクスポートするデータが選択されていません


-- Dumping structure for テーブル skill.stuff_develop_language
CREATE TABLE IF NOT EXISTS `stuff_develop_language` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `stuff_id` int(11) NOT NULL COMMENT '社員ナンバー',
  `develop_language_name` varchar(50) NOT NULL COMMENT '言語名称',
  PRIMARY KEY (`id`),
  KEY `stuff_id` (`stuff_id`),
  CONSTRAINT `STUFF_DEVELOP_LANGUAGE_STUFF_ID_FK` FOREIGN KEY (`stuff_id`) REFERENCES `stuff_meta` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- エクスポートするデータが選択されていません


-- Dumping structure for テーブル skill.stuff_license
CREATE TABLE IF NOT EXISTS `stuff_license` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `stuff_id` int(11) NOT NULL COMMENT '社員ナンバー',
  `license_name` varchar(50) NOT NULL COMMENT '資格名称',
  PRIMARY KEY (`id`),
  KEY `stuff_id` (`stuff_id`),
  CONSTRAINT `STUFF_LICENSE_STUFF_ID_FK` FOREIGN KEY (`stuff_id`) REFERENCES `stuff_meta` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- エクスポートするデータが選択されていません


-- Dumping structure for テーブル skill.stuff_meta
CREATE TABLE IF NOT EXISTS `stuff_meta` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `name` varchar(50) NOT NULL COMMENT '名前',
  `age` int(11) NOT NULL COMMENT '年齢',
  `sex` tinyint(4) NOT NULL COMMENT '性別 1:男 0:女',
  `nationality` varchar(50) NOT NULL COMMENT '国籍',
  `experience_year` int(11) NOT NULL COMMENT '経験年数',
  `price` int(11) NOT NULL COMMENT '単価',
  `is_member` tinyint(4) NOT NULL COMMENT '自社社員 1:自社 0:他社',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- エクスポートするデータが選択されていません


-- Dumping structure for テーブル skill.stuff_os
CREATE TABLE IF NOT EXISTS `stuff_os` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `stuff_id` int(11) NOT NULL COMMENT '社員ナンバー',
  `os_name` varchar(50) NOT NULL COMMENT '環境(OS)名称',
  PRIMARY KEY (`id`),
  KEY `stuff_id` (`stuff_id`),
  CONSTRAINT `STUFF_OS_STUFF_ID_FK` FOREIGN KEY (`stuff_id`) REFERENCES `stuff_meta` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- エクスポートするデータが選択されていません
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
