/*
SQLyog Community v11.42 (64 bit)
MySQL - 5.5.23 : Database - vostrik_db
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`vostrik_db` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `vostrik_db`;

/*Table structure for table `vostrik_cities` */

DROP TABLE IF EXISTS `vostrik_cities`;

CREATE TABLE `vostrik_cities` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` char(128) CHARACTER SET ascii NOT NULL,
  `country` smallint(5) unsigned NOT NULL,
  `region` smallint(5) unsigned NOT NULL,
  `latitude` decimal(20,17) DEFAULT NULL,
  `longitude` decimal(20,17) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `all_cols_idx` (`latitude`,`longitude`,`name`,`country`,`region`),
  KEY `name_id_idx` (`name`)
) ENGINE=MyISAM AUTO_INCREMENT=1501690 DEFAULT CHARSET=utf8 ROW_FORMAT=FIXED;

/*Table structure for table `vostrik_countries` */

DROP TABLE IF EXISTS `vostrik_countries`;

CREATE TABLE `vostrik_countries` (
  `id` int(10) unsigned NOT NULL DEFAULT '0',
  `name` varchar(255) DEFAULT NULL,
  `code` varchar(255) DEFAULT NULL,
  `alias` varchar(255) NOT NULL,
  `lat` decimal(20,17) DEFAULT NULL,
  `lng` decimal(20,17) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `el_name` (`name`),
  KEY `f930` (`code`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

/*Table structure for table `vostrik_currency` */

DROP TABLE IF EXISTS `vostrik_currency`;

CREATE TABLE `vostrik_currency` (
  `currency_id` int(11) DEFAULT NULL,
  `currency_code` text,
  `currency_name` text
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Table structure for table `vostrik_member` */

DROP TABLE IF EXISTS `vostrik_member`;

CREATE TABLE `vostrik_member` (
  `member_id` int(11) NOT NULL AUTO_INCREMENT,
  `member_name` text,
  `member_login` text,
  `member_password` text,
  `member_email` text,
  PRIMARY KEY (`member_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

/*Table structure for table `vostrik_member_note` */

DROP TABLE IF EXISTS `vostrik_member_note`;

CREATE TABLE `vostrik_member_note` (
  `note_id` int(11) NOT NULL AUTO_INCREMENT,
  `note_text` mediumtext,
  `note_date` datetime DEFAULT NULL,
  `note_member_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`note_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

/*Table structure for table `vostrik_param` */

DROP TABLE IF EXISTS `vostrik_param`;

CREATE TABLE `vostrik_param` (
  `param_id` int(11) NOT NULL AUTO_INCREMENT,
  `param_name` text,
  `param_value` text,
  `param_describe` text,
  PRIMARY KEY (`param_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Table structure for table `vostrik_regions` */

DROP TABLE IF EXISTS `vostrik_regions`;

CREATE TABLE `vostrik_regions` (
  `id` int(10) unsigned NOT NULL DEFAULT '0',
  `name` varchar(255) DEFAULT NULL,
  `country_id` int(10) unsigned DEFAULT '0',
  `code` char(20) DEFAULT NULL,
  `lat` double(15,8) DEFAULT '0.00000000',
  `lng` double(15,8) DEFAULT '0.00000000',
  PRIMARY KEY (`id`),
  KEY `el_name` (`name`),
  KEY `reg` (`code`),
  KEY `f797` (`country_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

/*Table structure for table `vostrik_short_links` */

DROP TABLE IF EXISTS `vostrik_short_links`;

CREATE TABLE `vostrik_short_links` (
  `ID` int(11) DEFAULT NULL,
  `SHORT_LINK` text,
  `LONG_LINK` text
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Table structure for table `vostrik_tag_content_type` */

DROP TABLE IF EXISTS `vostrik_tag_content_type`;

CREATE TABLE `vostrik_tag_content_type` (
  `content_type_id` int(11) DEFAULT NULL,
  `content_type_link` text,
  `content_type_descr` text
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Table structure for table `vostrik_tag_ref` */

DROP TABLE IF EXISTS `vostrik_tag_ref`;

CREATE TABLE `vostrik_tag_ref` (
  `tag_id` int(11) NOT NULL COMMENT 'ид тэга из таблицы vostrik_tag. Записей с таким ид может быть столько сколько упоминаний этого тега в контенте',
  `tag_ref` text,
  `tag_content_type` int(11) DEFAULT NULL COMMENT 'тип контента, где тэг упомянут',
  `tag_content_short` text
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Table structure for table `vostrik_tags` */

DROP TABLE IF EXISTS `vostrik_tags`;

CREATE TABLE `vostrik_tags` (
  `tag_id` int(11) NOT NULL AUTO_INCREMENT,
  `tag_name` text,
  PRIMARY KEY (`tag_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

/*Table structure for table `vostrik_tourclients` */

DROP TABLE IF EXISTS `vostrik_tourclients`;

CREATE TABLE `vostrik_tourclients` (
  `tour_id` int(11) DEFAULT NULL,
  `tour_clientid` int(11) DEFAULT NULL,
  `tour_clientprepaid` int(11) DEFAULT '0',
  `tour_clientapproved` int(11) DEFAULT '0',
  `tour_clientdecline` int(11) DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Table structure for table `vostrik_tours` */

DROP TABLE IF EXISTS `vostrik_tours`;

CREATE TABLE `vostrik_tours` (
  `tour_id` int(11) DEFAULT NULL,
  `tour_name` text,
  `tour_describe` text,
  `tour_startdate` date DEFAULT NULL,
  `tour_enddate` date DEFAULT NULL,
  `tour_price` decimal(10,0) DEFAULT NULL,
  `tour_currency` int(11) DEFAULT NULL,
  `tour_active` int(11) DEFAULT NULL COMMENT '0 - заблокирован, 1 - активен',
  `tour_guide` int(11) DEFAULT NULL COMMENT 'ид гида из таблички user',
  `tour_country` int(11) DEFAULT NULL,
  `tour_city` int(11) DEFAULT NULL,
  `tour_type` int(11) DEFAULT NULL,
  `tour_placesCount` int(11) DEFAULT '0',
  `tour_lifecircle` int(11) DEFAULT '0' COMMENT '0 - тур не начался, 1 - тур начался, 2 - тур окончен, 3- тур отменен',
  `tour_url` text COMMENT 'ссылка на сайт с описанием тура'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Table structure for table `vostrik_tourtype` */

DROP TABLE IF EXISTS `vostrik_tourtype`;

CREATE TABLE `vostrik_tourtype` (
  `type_id` int(11) NOT NULL AUTO_INCREMENT,
  `type_name` text,
  `type_descr` text,
  PRIMARY KEY (`type_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

/*Table structure for table `vostrik_user` */

DROP TABLE IF EXISTS `vostrik_user`;

CREATE TABLE `vostrik_user` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'УИД пользователя сайта',
  `user_group_id` int(11) DEFAULT NULL,
  `user_name` text CHARACTER SET latin1,
  `user_password` text CHARACTER SET latin1,
  `user_describe` text CHARACTER SET latin1 COMMENT 'Текстовый комментарий',
  `user_vk_id` text CHARACTER SET latin1,
  `user_fb_id` text CHARACTER SET latin1,
  `user_client_state` varchar(1) CHARACTER SET latin1 DEFAULT NULL COMMENT 'Статус пользователя: A - активен, B - блокирован, D - удален',
  `user_guide_state` varchar(1) CHARACTER SET latin1 DEFAULT NULL COMMENT 'Статус пользователя: A - активен, B - блокирован, D - удален',
  `user_email` text CHARACTER SET latin1,
  `user_photo` tinyblob,
  `user_phone` text CHARACTER SET latin1,
  `user_country` int(11) DEFAULT NULL COMMENT 'ид из справочника country',
  `user_city` int(11) DEFAULT NULL COMMENT 'ид из справочника city',
  `user_activity` int(11) DEFAULT NULL COMMENT 'ид из справочника "направление деятельности"',
  `user_site_ref` text CHARACTER SET latin1 COMMENT 'ссылка на сайт пользователя',
  `user_social_ref` text CHARACTER SET latin1 COMMENT 'Ссылка на переход к странице пользователя в СОЦ СЕТЬ.',
  `user_is_guide` int(11) DEFAULT '0' COMMENT 'пользователь ГИД',
  `user_is_client` int(11) DEFAULT '1' COMMENT 'пользователь КЛИЕНТ',
  `user_mail_notify` int(11) DEFAULT '0' COMMENT 'получать уведомление на «е-майл» о присоединении/отсоединении участников к его турам',
  `user_mail_validate` int(11) DEFAULT '0' COMMENT 'Прошел валидацию почтой',
  `user_mail_validate_param` text CHARACTER SET latin1,
  `user_is_first_hand` int(11) DEFAULT '1' COMMENT 'Параметр «Гид первой руки» - Да\\Нет – по умолчанию Да',
  `user_public_name` text CHARACTER SET latin1,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

/*Table structure for table `vostrik_usertype` */

DROP TABLE IF EXISTS `vostrik_usertype`;

CREATE TABLE `vostrik_usertype` (
  `type_id` int(11) NOT NULL AUTO_INCREMENT,
  `type_name` text,
  PRIMARY KEY (`type_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
