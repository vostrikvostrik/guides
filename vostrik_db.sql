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
CREATE DATABASE /*!32312 IF NOT EXISTS*/`vostrik_db` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `vostrik_db`;

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

/*Data for the table `vostrik_member` */

insert  into `vostrik_member`(`member_id`,`member_name`,`member_login`,`member_password`,`member_email`) values (1,'vostrik','vostrik','password','vostrikovaen@gmail.com\r\n'),(2,'patrik','patrik','patrikword','patrik@gmail.com');

/*Table structure for table `vostrik_member_note` */

DROP TABLE IF EXISTS `vostrik_member_note`;

CREATE TABLE `vostrik_member_note` (
  `note_id` int(11) NOT NULL AUTO_INCREMENT,
  `note_text` mediumtext,
  `note_date` datetime DEFAULT NULL,
  `note_member_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`note_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `vostrik_member_note` */

/*Table structure for table `vostrik_short_links` */

DROP TABLE IF EXISTS `vostrik_short_links`;

CREATE TABLE `vostrik_short_links` (
  `ID` int(11) DEFAULT NULL,
  `SHORT_LINK` text,
  `LONG_LINK` text
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `vostrik_short_links` */

insert  into `vostrik_short_links`(`ID`,`SHORT_LINK`,`LONG_LINK`) values (NULL,NULL,'eeeee'),(NULL,NULL,'eeeee'),(NULL,NULL,'eeeee');

/*Table structure for table `vostrik_user` */

DROP TABLE IF EXISTS `vostrik_user`;

CREATE TABLE `vostrik_user` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'УИД пользователя сайта',
  `user_group_id` int(11) DEFAULT NULL,
  `user_name` text,
  `user_password` text,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `vostrik_user` */

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
