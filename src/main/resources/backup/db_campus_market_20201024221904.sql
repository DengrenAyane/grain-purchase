-- MySQL dump 10.13  Distrib 8.0.15, for Win64 (x86_64)
--
-- Host: localhost    Database: db_campus_market
-- ------------------------------------------------------
-- Server version	8.0.15

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8mb4 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `lssf_comment`
--

DROP TABLE IF EXISTS `lssf_comment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `lssf_comment` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `create_time` datetime NOT NULL,
  `update_time` datetime NOT NULL,
  `content` varchar(1024) NOT NULL,
  `reply_to` varchar(64) DEFAULT NULL,
  `goods_id` bigint(20) DEFAULT NULL,
  `peasant_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKd01gnchhuj06oumqxrikccc3r` (`goods_id`),
  KEY `FKswirics8hhydki5ff0emtmbii` (`peasant_id`),
  CONSTRAINT `FKd01gnchhuj06oumqxrikccc3r` FOREIGN KEY (`goods_id`) REFERENCES `lssf_goods` (`id`),
  CONSTRAINT `FKswirics8hhydki5ff0emtmbii` FOREIGN KEY (`peasant_id`) REFERENCES `lssf_peasant` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `lssf_comment`
--

LOCK TABLES `lssf_comment` WRITE;
/*!40000 ALTER TABLE `lssf_comment` DISABLE KEYS */;
INSERT INTO `lssf_comment` VALUES (12,'2020-10-19 11:44:28','2020-10-19 11:44:28','没人买吗？？？',NULL,34,6),(13,'2020-10-19 11:44:54','2020-10-19 11:44:54','回复：“没人买吗？？？”<br>没人','Ayane',34,6),(14,'2020-10-19 15:30:58','2020-10-19 15:30:58','回复：“回复：“没人买吗？？？”<br>没人”<br>憨批','Ayane',34,7),(15,'2020-10-20 13:10:27','2020-10-20 13:10:27','kjsdkajskdjasd',NULL,40,6),(16,'2020-10-20 14:13:25','2020-10-20 14:13:25','kjajsdkajskdjaksdasd',NULL,38,7),(17,'2020-10-20 14:13:33','2020-10-20 14:13:33','回复：“kjajsdkajskdjaksdasd”<br>大大叔大叔大叔大叔大','DR',38,7),(18,'2020-10-20 16:48:37','2020-10-20 16:48:37','hjljknknknkl',NULL,38,7),(19,'2020-10-20 16:48:47','2020-10-20 16:48:47','回复：“kjajsdkajskdjaksdasd”<br>llkl','DR',38,7);
/*!40000 ALTER TABLE `lssf_comment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `lssf_database_bak`
--

DROP TABLE IF EXISTS `lssf_database_bak`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `lssf_database_bak` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `create_time` datetime NOT NULL,
  `update_time` datetime NOT NULL,
  `filename` varchar(32) NOT NULL,
  `filepath` varchar(128) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `lssf_database_bak`
--

LOCK TABLES `lssf_database_bak` WRITE;
/*!40000 ALTER TABLE `lssf_database_bak` DISABLE KEYS */;
INSERT INTO `lssf_database_bak` VALUES (10,'2020-03-22 19:36:47','2020-03-22 19:36:47','db_boot_base_20200322193647.sql','D:/workspace_devloper/baseproject/base/src/main/resources/backup/'),(11,'2020-03-22 19:37:54','2020-03-22 19:37:54','db_boot_base_20200322193754.sql','D:/workspace_devloper/baseproject/base/src/main/resources/backup/'),(12,'2020-03-22 19:40:04','2020-03-22 19:40:04','db_boot_base_20200322194004.sql','D:/workspace_devloper/baseproject/base/src/main/resources/backup/'),(14,'2020-03-22 19:40:14','2020-03-22 19:40:14','db_boot_base_20200322194014.sql','D:/workspace_devloper/baseproject/base/src/main/resources/backup/'),(15,'2020-03-22 19:40:19','2020-03-22 19:40:19','db_boot_base_20200322194019.sql','D:/workspace_devloper/baseproject/base/src/main/resources/backup/'),(17,'2020-03-22 19:43:34','2020-03-22 19:43:34','db_boot_base_20200322194334.sql','D:/workspace_devloper/baseproject/base/src/main/resources/backup/'),(18,'2020-03-22 19:43:39','2020-03-22 19:43:39','db_boot_base_20200322194339.sql','D:/workspace_devloper/baseproject/base/src/main/resources/backup/'),(20,'2020-03-22 19:43:49','2020-03-22 19:43:49','db_boot_base_20200322194349.sql','D:/workspace_devloper/baseproject/base/src/main/resources/backup/'),(21,'2020-03-22 19:43:54','2020-03-22 19:43:54','db_boot_base_20200322194354.sql','D:/workspace_devloper/baseproject/base/src/main/resources/backup/'),(22,'2020-03-22 19:43:59','2020-03-22 19:43:59','db_boot_base_20200322194359.sql','D:/workspace_devloper/baseproject/base/src/main/resources/backup/'),(23,'2020-03-22 19:44:04','2020-03-22 19:44:04','db_boot_base_20200322194404.sql','D:/workspace_devloper/baseproject/base/src/main/resources/backup/'),(24,'2020-03-22 19:44:09','2020-03-22 19:44:09','db_boot_base_20200322194409.sql','D:/workspace_devloper/baseproject/base/src/main/resources/backup/'),(25,'2020-03-22 19:44:14','2020-03-22 19:44:14','db_boot_base_20200322194414.sql','D:/workspace_devloper/baseproject/base/src/main/resources/backup/'),(26,'2020-03-22 19:44:19','2020-03-22 19:44:19','db_boot_base_20200322194419.sql','D:/workspace_devloper/baseproject/base/src/main/resources/backup/'),(27,'2020-03-22 19:44:24','2020-03-22 19:44:24','db_boot_base_20200322194424.sql','D:/workspace_devloper/baseproject/base/src/main/resources/backup/'),(28,'2020-03-22 19:44:29','2020-03-22 19:44:29','db_boot_base_20200322194429.sql','D:/workspace_devloper/baseproject/base/src/main/resources/backup/'),(29,'2020-03-22 19:44:34','2020-03-22 19:44:34','db_boot_base_20200322194434.sql','D:/workspace_devloper/baseproject/base/src/main/resources/backup/'),(30,'2020-03-22 19:44:39','2020-03-22 19:44:39','db_boot_base_20200322194439.sql','D:/workspace_devloper/baseproject/base/src/main/resources/backup/'),(31,'2020-03-23 17:46:49','2020-03-23 17:46:49','db_boot_base_20200323174649.sql','D:/workspace_devloper/baseproject/base/src/main/resources/backup/');
/*!40000 ALTER TABLE `lssf_database_bak` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `lssf_friend_link`
--

DROP TABLE IF EXISTS `lssf_friend_link`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `lssf_friend_link` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `create_time` datetime NOT NULL,
  `update_time` datetime NOT NULL,
  `name` varchar(64) NOT NULL,
  `sort` int(11) NOT NULL,
  `url` varchar(256) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `lssf_friend_link`
--

LOCK TABLES `lssf_friend_link` WRITE;
/*!40000 ALTER TABLE `lssf_friend_link` DISABLE KEYS */;
INSERT INTO `lssf_friend_link` VALUES (11,'2020-04-18 15:49:20','2020-10-17 20:32:19','DrAyaneShindou博客',0,'https://www.cnblogs.com/DrAyaneShindou/');
/*!40000 ALTER TABLE `lssf_friend_link` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `lssf_goods`
--

DROP TABLE IF EXISTS `lssf_goods`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `lssf_goods` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `create_time` datetime NOT NULL,
  `update_time` datetime NOT NULL,
  `content` varchar(1024) NOT NULL,
  `flag` int(11) NOT NULL,
  `name` varchar(32) NOT NULL,
  `photo` varchar(128) NOT NULL,
  `recommend` int(11) NOT NULL,
  `sell_price` float NOT NULL,
  `status` int(11) NOT NULL,
  `goods_category_id` bigint(20) DEFAULT NULL,
  `peasant_id` bigint(20) DEFAULT NULL,
  `view_number` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKjtyl6pmb9j4aj64sm54xi1hbi` (`goods_category_id`),
  KEY `FKf68a0a9u8u8hqckg0ycnjarv6` (`peasant_id`),
  CONSTRAINT `FKf68a0a9u8u8hqckg0ycnjarv6` FOREIGN KEY (`peasant_id`) REFERENCES `lssf_peasant` (`id`),
  CONSTRAINT `FKjtyl6pmb9j4aj64sm54xi1hbi` FOREIGN KEY (`goods_category_id`) REFERENCES `lssf_goods_category` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=43 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `lssf_goods`
--

LOCK TABLES `lssf_goods` WRITE;
/*!40000 ALTER TABLE `lssf_goods` DISABLE KEYS */;
INSERT INTO `lssf_goods` VALUES (34,'2020-10-19 09:07:12','2020-10-20 13:06:01','打算打算打算打算打啥啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊',0,'小麦','20201019/1603069612147.png',0,200,1,5,6,24),(35,'2020-10-19 15:41:51','2020-10-20 11:21:40','我这个稻谷是真的不错，但是没卖完，希望有人来买，总共10斤',0,'稻谷','20201019/1603093127872.jpg',0,100,1,4,7,1),(36,'2020-10-19 15:45:30','2020-10-19 15:45:56','这就是大麦，属于南方品种，很不错，速来抢购',0,'南方大麦','20201019/1603093528141.jpg',0,50,1,6,7,0),(37,'2020-10-19 15:47:46','2020-10-20 14:16:13','多好的玉米啊，还有多，希望需要的能赶紧买',0,'南方玉米','20201019/1603093614642.jpg',0,233,1,7,7,5),(38,'2020-10-19 15:50:45','2020-10-20 17:02:46','马铃薯，实物见照片，快点来买，都快没了',0,'马铃薯','20201019/1603093790743.jpg',0,2312,1,10,7,7),(39,'2020-10-19 16:08:57','2020-10-20 14:16:26','蚕豆大，蚕豆是半圆，像个大月亮',0,'蚕豆','20201019/1603094310514.jpg',0,21,1,17,7,1),(40,'2020-10-19 16:14:53','2020-10-21 11:10:02','看绿豆这成色，多好啊，跟实物基本一模一样',0,'绿豆','20201019/1603095178862.jpg',0,12,1,19,7,6),(41,'2020-10-19 16:22:09','2020-10-20 16:48:20','刚刚从地里挖出来的红薯，很新鲜，有四斤，有意向私聊',0,'红薯','20201019/1603095663097.jpg',0,10,1,9,7,3),(42,'2020-10-20 17:36:23','2020-10-20 17:37:06','sdasdasdasdasdasdsdsad',0,'asdadsad','20201020/1603186562978.jpg',0,21,1,10,7,0);
/*!40000 ALTER TABLE `lssf_goods` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `lssf_goods_category`
--

DROP TABLE IF EXISTS `lssf_goods_category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `lssf_goods_category` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `create_time` datetime NOT NULL,
  `update_time` datetime NOT NULL,
  `icon` varchar(32) DEFAULT NULL,
  `name` varchar(18) NOT NULL,
  `sort` int(11) NOT NULL,
  `parent_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKos35mkmw4k5dvi4fi2govg2pa` (`parent_id`),
  CONSTRAINT `FKos35mkmw4k5dvi4fi2govg2pa` FOREIGN KEY (`parent_id`) REFERENCES `lssf_goods_category` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=56 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `lssf_goods_category`
--

LOCK TABLES `lssf_goods_category` WRITE;
/*!40000 ALTER TABLE `lssf_goods_category` DISABLE KEYS */;
INSERT INTO `lssf_goods_category` VALUES (1,'2020-04-02 20:20:05','2020-10-18 17:06:07','20201018/1603011964557.png','谷类作物',0,NULL),(4,'2020-04-02 20:26:45','2020-10-18 16:29:48','20201018/1603009785303.jpg','稻谷',1,1),(5,'2020-04-02 21:13:04','2020-10-18 16:30:32','20201018/1603009829719.jpg','小麦',2,1),(6,'2020-04-02 21:37:05','2020-10-18 16:31:32','20201018/1603009888218.jpg','大麦',3,1),(7,'2020-04-02 21:37:23','2020-10-18 16:32:39','20201018/1603009951789.jpg','玉米',4,1),(8,'2020-04-02 21:37:50','2020-10-18 17:09:41','20201018/1603012178936.png','薯类作物',5,NULL),(9,'2020-04-02 21:38:08','2020-10-18 16:37:11','20201018/1603010228179.jpg','甘薯',6,8),(10,'2020-04-02 21:38:26','2020-10-18 16:48:04','20201018/1603010882085.jpg','马铃薯',7,8),(11,'2020-04-02 21:38:45','2020-10-18 16:48:49','20201018/1603010926835.jpg','木薯',8,8),(15,'2020-04-05 18:46:54','2020-10-18 17:10:00','20201018/1603012198402.png','豆类作物',9,NULL),(16,'2020-04-05 19:06:56','2020-10-18 16:51:25','20201018/1603011082689.jpg','大豆',10,15),(17,'2020-04-05 19:07:45','2020-10-18 16:52:11','20201018/1603011129202.jpg','蚕豆',11,15),(18,'2020-04-05 19:08:15','2020-10-18 16:53:00','20201018/1603011176816.jpg','豌豆',12,15),(19,'2020-04-05 19:08:44','2020-10-18 16:53:58','20201018/1603011236767.jpg','绿豆',13,15),(20,'2020-04-05 19:09:04','2020-10-18 16:55:27','20201018/1603011324395.jpg','小豆',14,15);
/*!40000 ALTER TABLE `lssf_goods_category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `lssf_menu`
--

DROP TABLE IF EXISTS `lssf_menu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `lssf_menu` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `create_time` datetime NOT NULL,
  `update_time` datetime NOT NULL,
  `name` varchar(18) NOT NULL,
  `url` varchar(128) DEFAULT NULL,
  `icon` varchar(32) DEFAULT NULL,
  `sort` int(11) NOT NULL,
  `parent_id` bigint(20) DEFAULT NULL,
  `is_bitton` bit(1) NOT NULL,
  `is_show` bit(1) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKsbtnjocfrq29e8taxdwo21gic` (`parent_id`),
  CONSTRAINT `FKsbtnjocfrq29e8taxdwo21gic` FOREIGN KEY (`parent_id`) REFERENCES `lssf_menu` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=63 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `lssf_menu`
--

LOCK TABLES `lssf_menu` WRITE;
/*!40000 ALTER TABLE `lssf_menu` DISABLE KEYS */;
INSERT INTO `lssf_menu` VALUES (2,'2020-03-14 14:26:03','2020-03-14 18:24:53','系统设置','','mdi-settings',0,NULL,_binary '\0',_binary ''),(3,'2020-03-14 16:58:55','2020-03-14 18:26:02','菜单管理','/admin/menu/list','mdi-view-list',1,2,_binary '\0',_binary ''),(5,'2020-03-14 17:04:44','2020-03-14 18:27:53','新增','/admin/menu/add','mdi-plus',2,3,_binary '\0',_binary ''),(7,'2020-03-14 17:07:43','2020-03-15 12:11:25','角色管理','/admin/role/list','mdi-account-settings-variant',5,2,_binary '\0',_binary ''),(8,'2020-03-14 18:28:48','2020-03-21 22:04:45','编辑','edit(\'/admin/menu/edit\')','mdi-grease-pencil',3,3,_binary '',_binary ''),(9,'2020-03-14 18:30:00','2020-03-21 22:08:20','删除','del(\'/admin/menu/delete\')','mdi-close',4,3,_binary '',_binary ''),(10,'2020-03-15 12:12:00','2020-03-15 12:12:00','添加','/admin/role/add','mdi-account-plus',6,7,_binary '\0',_binary ''),(11,'2020-03-15 12:12:36','2020-03-21 22:10:45','编辑','edit(\'/admin/role/edit\')','mdi-account-edit',7,7,_binary '',_binary ''),(12,'2020-03-15 12:13:19','2020-03-21 22:15:27','删除','del(\'/admin/role/delete\')','mdi-account-remove',8,7,_binary '',_binary ''),(13,'2020-03-15 12:14:52','2020-03-15 12:17:00','用户管理','/admin/user/list','mdi-account-multiple',9,2,_binary '\0',_binary ''),(14,'2020-03-15 12:15:22','2020-03-15 12:17:27','添加','/admin/user/add','mdi-account-plus',10,13,_binary '\0',_binary ''),(15,'2020-03-16 17:18:14','2020-03-21 22:11:19','编辑','edit(\'/admin/user/edit\')','mdi-account-edit',11,13,_binary '',_binary ''),(16,'2020-03-16 17:19:01','2020-03-21 22:15:36','删除','del(\'/admin/user/delete\')','mdi-account-remove',12,13,_binary '',_binary ''),(19,'2020-03-22 11:24:36','2020-03-22 11:26:00','上传图片','/admin/upload/upload_photo','mdi-arrow-up-bold-circle',0,13,_binary '\0',_binary '\0'),(20,'2020-03-22 14:09:35','2020-03-22 14:09:47','日志管理','/system/operator_log_list','mdi-tag-multiple',13,2,_binary '\0',_binary ''),(21,'2020-03-22 14:11:39','2020-03-22 14:11:39','删除','del(\'/system/delete_operator_log\')','mdi-tag-remove',14,20,_binary '',_binary ''),(22,'2020-03-22 14:12:57','2020-03-22 14:46:55','清空日志','delAll(\'/system/delete_all_operator_log\')','mdi-delete-circle',15,20,_binary '',_binary ''),(23,'2020-03-22 14:46:40','2020-03-22 14:47:09','数据备份','/admin/database_bak/list','mdi-database',16,2,_binary '\0',_binary ''),(24,'2020-03-22 14:48:07','2020-03-22 15:13:41','备份','add(\'/admin/database_bak/add\')','mdi-database-plus',17,23,_binary '',_binary ''),(25,'2020-03-22 14:49:03','2020-03-22 14:49:03','删除','del(\'/admin/database_bak/delete\')','mdi-database-minus',18,23,_binary '',_binary ''),(26,'2020-03-22 19:36:20','2020-03-22 19:36:20','还原','restore(\'/admin/database_bak/restore\')','mdi-database-minus',19,23,_binary '',_binary ''),(27,'2020-04-01 20:35:09','2020-10-17 19:40:39','粮食管理','/admin/goods_category/list','mdi-dialpad',0,NULL,_binary '\0',_binary ''),(28,'2020-04-01 20:35:46','2020-04-12 22:28:09','分类管理','/admin/goods_category/list','mdi-apps',0,27,_binary '\0',_binary ''),(29,'2020-04-01 20:36:27','2020-10-17 19:41:52','粮食管理','/admin/goods/list','mdi-cart',0,27,_binary '\0',_binary ''),(30,'2020-04-01 20:40:48','2020-04-12 22:28:34','添加','/admin/goods_category/add','mdi-battery-positive',0,28,_binary '\0',_binary ''),(31,'2020-04-01 20:41:33','2020-04-12 22:30:02','编辑','edit(\'/admin/goods_category/edit\')','mdi-border-color',0,28,_binary '',_binary ''),(32,'2020-04-01 20:42:15','2020-04-12 22:30:21','删除','del(\'/admin/goods_category/delete\')','mdi-close',0,28,_binary '',_binary ''),(33,'2020-04-13 18:52:12','2020-04-13 18:52:12','上架','up(\'/admin/goods/up_down\')','mdi-arrow-up-bold-box',0,29,_binary '',_binary ''),(34,'2020-04-13 18:52:55','2020-04-13 18:52:55','下架','down(\'/admin/goods/up_down\')','mdi-arrow-down-bold-box',0,29,_binary '',_binary ''),(35,'2020-04-13 18:54:10','2020-04-15 19:17:48','删除','del(\'/admin/goods/delete\')','mdi-close-box',0,29,_binary '',_binary ''),(36,'2020-04-15 19:06:49','2020-04-15 19:06:49','推荐','recommend(\'/admin/goods/recommend\')','mdi-thumb-up',0,29,_binary '',_binary ''),(37,'2020-04-15 19:07:45','2020-04-15 19:07:45','取消推荐','unrecommend(\'/admin/goods/recommend\')','mdi-thumb-down',0,29,_binary '',_binary ''),(38,'2020-04-15 19:32:16','2020-10-17 20:38:33','求购粮食','/admin/wanted_goods/list','mdi-ticket',0,27,_binary '\0',_binary ''),(39,'2020-04-15 19:32:55','2020-04-15 19:59:53','删除','del(\'/admin/wanted_goods/delete\')','mdi-close-box',0,38,_binary '',_binary ''),(40,'2020-04-15 20:02:04','2020-10-20 15:04:40','用户管理','/admin/peasant/list','mdi-account-multiple',0,NULL,_binary '\0',_binary ''),(41,'2020-04-15 20:02:38','2020-10-20 15:05:06','用户列表','/admin/peasant/list','mdi-account-multiple',0,40,_binary '\0',_binary ''),(42,'2020-04-15 20:06:28','2020-10-20 15:05:23','冻结','freeze(\'/admin/peasant/update_status\')','mdi-account-settings-variant',0,41,_binary '',_binary ''),(43,'2020-04-15 20:06:59','2020-10-20 15:05:41','激活','openStudent(\'/admin/peasant/update_status\')','mdi-account-key',0,41,_binary '',_binary ''),(44,'2020-04-15 20:07:33','2020-10-20 15:06:02','删除','del(\'/admin/peasant/delete\')','mdi-account-remove',0,41,_binary '',_binary ''),(45,'2020-04-15 21:52:57','2020-04-15 21:52:57','评论管理','/admin/comment/list','mdi-comment-account',0,NULL,_binary '\0',_binary ''),(46,'2020-04-15 21:53:39','2020-04-15 21:53:39','评论列表','/admin/comment/list','mdi-comment-multiple-outline',0,45,_binary '\0',_binary ''),(47,'2020-04-15 21:54:35','2020-04-15 21:54:35','删除','del(\'/admin/comment/delete\')','mdi-message-bulleted-off',0,46,_binary '',_binary ''),(48,'2020-04-16 19:28:48','2020-04-16 19:28:48','举报管理','/admin/report/list','mdi-alert',0,NULL,_binary '\0',_binary ''),(49,'2020-04-16 19:30:31','2020-04-16 19:30:31','举报列表','/admin/report/list','mdi-view-headline',0,48,_binary '\0',_binary ''),(50,'2020-04-16 19:31:09','2020-04-16 19:31:09','删除','del(\'/admin/report/delete\')','mdi-close-box',0,49,_binary '',_binary ''),(51,'2020-04-16 19:46:08','2020-04-16 19:46:08','新闻公告','/admin/news/list','mdi-onenote',0,NULL,_binary '\0',_binary ''),(52,'2020-04-16 19:46:39','2020-04-16 19:46:39','公告列表','/admin/news/list','mdi-book-open',0,51,_binary '\0',_binary ''),(53,'2020-04-16 19:48:01','2020-04-16 19:48:01','添加','/admin/news/add','mdi-plus',0,52,_binary '\0',_binary ''),(54,'2020-04-16 19:48:46','2020-04-16 19:48:46','编辑','edit(\'/admin/news/edit\')','mdi-border-color',0,52,_binary '',_binary ''),(55,'2020-04-16 19:49:37','2020-04-16 19:49:37','删除','del(\'/admin/news/delete\')','mdi-close',0,52,_binary '',_binary ''),(56,'2020-04-18 14:25:58','2020-04-18 14:25:58','网站设置','','mdi-settings',0,NULL,_binary '\0',_binary ''),(57,'2020-04-18 14:27:31','2020-04-18 14:27:31','友情链接','/admin/friend_link/list','mdi-vector-line',0,56,_binary '\0',_binary ''),(58,'2020-04-18 14:28:36','2020-04-18 14:28:36','添加','/admin/friend_link/add','mdi-plus',0,57,_binary '\0',_binary ''),(59,'2020-04-18 14:29:17','2020-04-18 15:38:53','编辑','edit(\'/admin/friend_link/edit\')','mdi-border-color',0,57,_binary '',_binary ''),(60,'2020-04-18 14:29:45','2020-04-18 14:29:45','删除','del(\'/admin/friend_link/delete\')','mdi-close-box',0,57,_binary '',_binary ''),(61,'2020-04-18 16:26:45','2020-04-18 16:26:45','站点设置','/admin/site_setting/setting','mdi-wrench',0,56,_binary '\0',_binary ''),(62,'2020-04-18 16:28:25','2020-04-18 16:28:25','提交修改','/admin/site_setting/save_setting','mdi-marker-check',0,61,_binary '',_binary '\0');
/*!40000 ALTER TABLE `lssf_menu` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `lssf_news`
--

DROP TABLE IF EXISTS `lssf_news`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `lssf_news` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `create_time` datetime NOT NULL,
  `update_time` datetime NOT NULL,
  `content` varchar(10024) NOT NULL,
  `sort` int(11) NOT NULL,
  `title` varchar(1024) NOT NULL,
  `view_number` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `lssf_news`
--

LOCK TABLES `lssf_news` WRITE;
/*!40000 ALTER TABLE `lssf_news` DISABLE KEYS */;
INSERT INTO `lssf_news` VALUES (1,'2020-04-16 21:29:17','2020-10-17 20:30:17','粮食收发平台，为天下粮民服务',2,'关于粮食收发平台',0),(2,'2020-04-16 21:29:49','2020-10-17 20:28:39','1.禁止和限制发布粮食管理规则\r\n2.重复铺货粮食管理规则\r\n3.支付方式不符粮食管理规则\r\n4.粮食价格、邮费不符粮食管理规则\r\n5.信用炒作粮食管理规则',0,'粮食收发平台发布粮食规则',0),(3,'2020-04-16 21:30:22','2020-10-17 20:29:10','注册时请填写详细的注册信息，用户ID为必填项。',1,'粮食收发平台账号注册规则',0);
/*!40000 ALTER TABLE `lssf_news` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `lssf_operater_log`
--

DROP TABLE IF EXISTS `lssf_operater_log`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `lssf_operater_log` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `create_time` datetime NOT NULL,
  `update_time` datetime NOT NULL,
  `content` varchar(1024) NOT NULL,
  `operator` varchar(18) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=461 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `lssf_operater_log`
--

LOCK TABLES `lssf_operater_log` WRITE;
/*!40000 ALTER TABLE `lssf_operater_log` DISABLE KEYS */;
INSERT INTO `lssf_operater_log` VALUES (395,'2020-10-15 20:27:18','2020-10-15 20:27:18','用户【Ayane】于【2020-10-15 20:27:18】登录系统！','Ayane'),(396,'2020-10-17 19:23:05','2020-10-17 19:23:05','用户【Ayane】于【2020-10-17 19:23:04】登录系统！','Ayane'),(397,'2020-10-17 19:32:40','2020-10-17 19:32:40','用户【Ayane】于【2020-10-17 19:32:40】登录系统！','Ayane'),(398,'2020-10-17 19:34:51','2020-10-17 19:34:51','用户【Ayane】于【2020-10-17 19:34:50】登录系统！','Ayane'),(399,'2020-10-17 19:39:54','2020-10-17 19:39:54','编辑菜单信息【Menu [name=用户管理, parent=null, url=/admin/student/list, icon=mdi-account-multiple, sort=0, isButton=false, isShow=true]】','Ayane'),(400,'2020-10-17 19:40:16','2020-10-17 19:40:16','编辑菜单信息【Menu [name=用户列表, parent=Menu [name=null, parent=null, url=null, icon=null, sort=0, isButton=false, isShow=true], url=/admin/student/list, icon=mdi-account-multiple, sort=0, isButton=false, isShow=true]】','Ayane'),(401,'2020-10-17 19:40:39','2020-10-17 19:40:39','编辑菜单信息【Menu [name=粮食管理, parent=null, url=/admin/goods_category/list, icon=mdi-dialpad, sort=0, isButton=false, isShow=true]】','Ayane'),(402,'2020-10-17 19:41:52','2020-10-17 19:41:52','编辑菜单信息【Menu [name=粮食管理, parent=Menu [name=null, parent=null, url=null, icon=null, sort=0, isButton=false, isShow=true], url=/admin/goods/list, icon=mdi-cart, sort=0, isButton=false, isShow=true]】','Ayane'),(403,'2020-10-17 19:46:57','2020-10-17 19:46:57','用户【Ayane】于【2020-10-17 19:46:57】登录系统！','Ayane'),(404,'2020-10-17 20:05:38','2020-10-17 20:05:38','修改网站设置:SiteSetting [siteName=粮食收发平台, siteUrl=www.Ayane.com, logo1=20201017/1602936217225.png, logo2=20200418/1587201663687.png, qrcode=20200418/1587201667179.png, allRights=©2016-2020【AyaneShindou】 版权所有]','Ayane'),(405,'2020-10-17 20:06:55','2020-10-17 20:06:55','批量删除友情链接，友情链接IDS：1,15,16,17','Ayane'),(406,'2020-10-17 20:08:39','2020-10-17 20:08:39','用户【Ayane】于【2020-10-17 20:08:39】登录系统！','Ayane'),(407,'2020-10-17 20:12:15','2020-10-17 20:12:15','修改网站设置:SiteSetting [siteName=粮食收发平台, siteUrl=www.Ayane.com, logo1=20201017/1602936712658.jpg, logo2=20201017/1602936719735.png, qrcode=20200418/1587201667179.png, allRights=©2016-2020【AyaneShindou】 版权所有]','Ayane'),(408,'2020-10-17 20:12:57','2020-10-17 20:12:57','修改网站设置:SiteSetting [siteName=粮食收发平台, siteUrl=www.Ayane.com, logo1=20201017/1602936765602.png, logo2=20201017/1602936773549.jpg, qrcode=20200418/1587201667179.png, allRights=©2016-2020【AyaneShindou】 版权所有]','Ayane'),(409,'2020-10-17 20:14:05','2020-10-17 20:14:05','修改网站设置:SiteSetting [siteName=粮食收发平台, siteUrl=www.DrAyane.com, logo1=20201017/1602936765602.png, logo2=20201017/1602936773549.jpg, qrcode=20200418/1587201667179.png, allRights=©2016-2020【AyaneShindou】 版权所有]','Ayane'),(410,'2020-10-17 20:14:18','2020-10-17 20:14:18','修改网站设置:SiteSetting [siteName=粮食收发平台, siteUrl=www.DrAyane.com, logo1=20201017/1602936765602.png, logo2=20201017/1602936773549.jpg, qrcode=20200418/1587201667179.png, allRights=©2016-2020【DrAyaneShindou】 版权所有]','Ayane'),(411,'2020-10-17 20:16:59','2020-10-17 20:16:59','修改网站设置:SiteSetting [siteName=粮食收发平台, siteUrl=www.DrAyane.com, logo1=20201017/1602936765602.png, logo2=20201017/1602936928871.jpg, qrcode=20201017/1602937012455.jpg, allRights=©2016-2020【DrAyaneShindou】 版权所有]','Ayane'),(412,'2020-10-17 20:19:18','2020-10-17 20:19:18','用户【Ayane】于【2020-10-17 20:19:17】登录系统！','Ayane'),(413,'2020-10-17 20:27:18','2020-10-17 20:27:18','用户【Ayane】于【2020-10-17 20:27:18】登录系统！','Ayane'),(414,'2020-10-17 20:28:39','2020-10-17 20:28:39','编辑新闻公告：News [title=粮食收发平台发布粮食规则, content=1.禁止和限制发布粮食管理规则\r\n2.重复铺货粮食管理规则\r\n3.支付方式不符粮食管理规则\r\n4.粮食价格、邮费不符粮食管理规则\r\n5.信用炒作粮食管理规则, viewNumber=0, sort=0]','Ayane'),(415,'2020-10-17 20:29:10','2020-10-17 20:29:10','编辑新闻公告：News [title=粮食收发平台账号注册规则, content=注册时请填写详细的注册信息，用户ID为必填项。, viewNumber=0, sort=1]','Ayane'),(416,'2020-10-17 20:30:17','2020-10-17 20:30:17','编辑新闻公告：News [title=关于粮食收发平台, content=粮食收发平台，为天下粮民服务, viewNumber=0, sort=2]','Ayane'),(417,'2020-10-17 20:32:19','2020-10-17 20:32:19','编辑友情链接：FriendLink [name=DrAyaneShindou博客, url=https://www.cnblogs.com/DrAyaneShindou/, sort=0]','Ayane'),(418,'2020-10-17 20:37:27','2020-10-17 20:37:27','用户【Ayane】于【2020-10-17 20:37:27】登录系统！','Ayane'),(419,'2020-10-17 20:38:33','2020-10-17 20:38:33','编辑菜单信息【Menu [name=求购粮食, parent=Menu [name=null, parent=null, url=null, icon=null, sort=0, isButton=false, isShow=true], url=/admin/wanted_goods/list, icon=mdi-ticket, sort=0, isButton=false, isShow=true]】','Ayane'),(420,'2020-10-17 22:06:29','2020-10-17 22:06:29','用户【Ayane】于【2020-10-17 22:06:28】登录系统！','Ayane'),(421,'2020-10-18 16:10:28','2020-10-18 16:10:28','用户【Ayane】于【2020-10-18 16:10:27】登录系统！','Ayane'),(422,'2020-10-18 16:25:18','2020-10-18 16:25:18','用户【Ayane】于【2020-10-18 16:25:17】登录系统！','Ayane'),(423,'2020-10-18 17:14:04','2020-10-18 17:14:04','用户【Ayane】于【2020-10-18 17:14:04】登录系统！','Ayane'),(424,'2020-10-18 17:17:21','2020-10-18 17:17:21','用户【Ayane】于【2020-10-18 17:17:21】登录系统！','Ayane'),(425,'2020-10-18 17:21:30','2020-10-18 17:21:30','用户【Ayane】于【2020-10-18 17:21:30】登录系统！','Ayane'),(426,'2020-10-19 15:32:23','2020-10-19 15:32:23','用户【Ayane】于【2020-10-19 15:32:22】登录系统！','Ayane'),(427,'2020-10-19 16:29:06','2020-10-19 16:29:06','用户【Ayane】于【2020-10-19 16:29:06】登录系统！','Ayane'),(428,'2020-10-20 00:18:50','2020-10-20 00:18:50','用户【Ayane】于【2020-10-20 00:18:50】登录系统！','Ayane'),(429,'2020-10-20 09:52:53','2020-10-20 09:52:53','用户【Ayane】于【2020-10-20 09:52:52】登录系统！','Ayane'),(430,'2020-10-20 09:59:10','2020-10-20 09:59:10','用户【Ayane】于【2020-10-20 09:59:10】登录系统！','Ayane'),(431,'2020-10-20 10:02:29','2020-10-20 10:02:29','用户【Ayane】于【2020-10-20 10:02:28】登录系统！','Ayane'),(432,'2020-10-20 10:06:24','2020-10-20 10:06:24','用户【Ayane】于【2020-10-20 10:06:23】登录系统！','Ayane'),(433,'2020-10-20 10:09:16','2020-10-20 10:09:16','用户【Ayane】于【2020-10-20 10:09:15】登录系统！','Ayane'),(434,'2020-10-20 10:12:26','2020-10-20 10:12:26','用户【Ayane】于【2020-10-20 10:12:25】登录系统！','Ayane'),(435,'2020-10-20 10:17:32','2020-10-20 10:17:32','用户【Ayane】于【2020-10-20 10:17:32】登录系统！','Ayane'),(436,'2020-10-20 10:20:56','2020-10-20 10:20:56','用户【Ayane】于【2020-10-20 10:20:56】登录系统！','Ayane'),(437,'2020-10-20 10:30:41','2020-10-20 10:30:41','用户【Ayane】于【2020-10-20 10:30:41】登录系统！','Ayane'),(438,'2020-10-20 10:34:42','2020-10-20 10:34:42','用户【Ayane】于【2020-10-20 10:34:41】登录系统！','Ayane'),(439,'2020-10-20 10:58:32','2020-10-20 10:58:32','用户【Ayane】于【2020-10-20 10:58:32】登录系统！','Ayane'),(440,'2020-10-20 11:03:43','2020-10-20 11:03:43','用户【Ayane】于【2020-10-20 11:03:42】登录系统！','Ayane'),(441,'2020-10-20 14:31:25','2020-10-20 14:31:25','用户【Ayane】于【2020-10-20 14:31:24】登录系统！','Ayane'),(442,'2020-10-20 14:31:54','2020-10-20 14:31:54','添加用户，用户ID：1','Ayane'),(443,'2020-10-20 14:32:11','2020-10-20 14:32:11','添加用户，用户ID：2','Ayane'),(444,'2020-10-20 14:32:27','2020-10-20 14:32:27','添加用户，用户ID：5','Ayane'),(445,'2020-10-20 14:32:31','2020-10-20 14:32:31','添加用户，用户ID：7','Ayane'),(446,'2020-10-20 15:03:17','2020-10-20 15:03:17','用户【Ayane】于【2020-10-20 15:03:17】登录系统！','Ayane'),(447,'2020-10-20 15:04:40','2020-10-20 15:04:40','编辑菜单信息【Menu [name=用户管理, parent=null, url=/admin/peasant/list, icon=mdi-account-multiple, sort=0, isButton=false, isShow=true]】','Ayane'),(448,'2020-10-20 15:05:06','2020-10-20 15:05:06','编辑菜单信息【Menu [name=用户列表, parent=Menu [name=null, parent=null, url=null, icon=null, sort=0, isButton=false, isShow=true], url=/admin/peasant/list, icon=mdi-account-multiple, sort=0, isButton=false, isShow=true]】','Ayane'),(449,'2020-10-20 15:05:23','2020-10-20 15:05:23','编辑菜单信息【Menu [name=冻结, parent=Menu [name=null, parent=null, url=null, icon=null, sort=0, isButton=false, isShow=true], url=freeze(\'/admin/peasant/update_status\'), icon=mdi-account-settings-variant, sort=0, isButton=true, isShow=true]】','Ayane'),(450,'2020-10-20 15:05:41','2020-10-20 15:05:41','编辑菜单信息【Menu [name=激活, parent=Menu [name=null, parent=null, url=null, icon=null, sort=0, isButton=false, isShow=true], url=openStudent(\'/admin/peasant/update_status\'), icon=mdi-account-key, sort=0, isButton=true, isShow=true]】','Ayane'),(451,'2020-10-20 15:06:02','2020-10-20 15:06:02','编辑菜单信息【Menu [name=删除, parent=Menu [name=null, parent=null, url=null, icon=null, sort=0, isButton=false, isShow=true], url=del(\'/admin/peasant/delete\'), icon=mdi-account-remove, sort=0, isButton=true, isShow=true]】','Ayane'),(452,'2020-10-20 16:11:04','2020-10-20 16:11:04','用户【Ayane】于【2020-10-20 16:11:04】登录系统！','Ayane'),(453,'2020-10-20 16:37:29','2020-10-20 16:37:29','用户【Ayane】于【2020-10-20 16:37:28】登录系统！','Ayane'),(454,'2020-10-20 16:38:40','2020-10-20 16:38:40','编辑角色【超级管理员】','Ayane'),(455,'2020-10-20 16:38:51','2020-10-20 16:38:51','编辑用户，用户名：Ayane','Ayane'),(456,'2020-10-20 16:50:20','2020-10-20 16:50:20','用户【Ayane】于【2020-10-20 16:50:19】登录系统！','Ayane'),(457,'2020-10-20 17:00:11','2020-10-20 17:00:11','用户【Ayane】于【2020-10-20 17:00:11】登录系统！','Ayane'),(458,'2020-10-20 17:37:31','2020-10-20 17:37:31','用户【Ayane】于【2020-10-20 17:37:30】登录系统！','Ayane'),(459,'2020-10-20 19:32:05','2020-10-20 19:32:05','用户【Ayane】于【2020-10-20 19:32:05】登录系统！','Ayane'),(460,'2020-10-21 11:05:22','2020-10-21 11:05:22','用户【Ayane】于【2020-10-21 11:05:21】登录系统！','Ayane');
/*!40000 ALTER TABLE `lssf_operater_log` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `lssf_peasant`
--

DROP TABLE IF EXISTS `lssf_peasant`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `lssf_peasant` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `create_time` datetime NOT NULL,
  `update_time` datetime NOT NULL,
  `mobile` varchar(18) DEFAULT NULL,
  `nickname` varchar(32) DEFAULT NULL,
  `qq` varchar(18) DEFAULT NULL,
  `pn` varchar(18) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `head_pic` varchar(128) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `password` varchar(18) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_5se32pxcytmbwgepjrjrdmvjr` (`pn`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `lssf_peasant`
--

LOCK TABLES `lssf_peasant` WRITE;
/*!40000 ALTER TABLE `lssf_peasant` DISABLE KEYS */;
INSERT INTO `lssf_peasant` VALUES (6,'2020-10-18 19:39:57','2020-10-19 15:29:59','17346716698','Ayane','1548488689','20171768','20201018/1603021340182.jpg',1,'123456'),(7,'2020-10-19 14:36:41','2020-10-19 15:27:02','17346716698','DR','2317823712','20171767','20201019/1603089759094.png',1,'123456');
/*!40000 ALTER TABLE `lssf_peasant` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `lssf_report_goods`
--

DROP TABLE IF EXISTS `lssf_report_goods`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `lssf_report_goods` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `create_time` datetime NOT NULL,
  `update_time` datetime NOT NULL,
  `content` varchar(1024) NOT NULL,
  `goods_id` bigint(20) DEFAULT NULL,
  `peasant_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK6g0s4688rq2bnty1u1ev1rgly` (`goods_id`),
  KEY `FKmr7s3q3jpq824h69f5ip9gleq` (`peasant_id`),
  CONSTRAINT `FK6g0s4688rq2bnty1u1ev1rgly` FOREIGN KEY (`goods_id`) REFERENCES `lssf_goods` (`id`),
  CONSTRAINT `FKmr7s3q3jpq824h69f5ip9gleq` FOREIGN KEY (`peasant_id`) REFERENCES `lssf_peasant` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `lssf_report_goods`
--

LOCK TABLES `lssf_report_goods` WRITE;
/*!40000 ALTER TABLE `lssf_report_goods` DISABLE KEYS */;
/*!40000 ALTER TABLE `lssf_report_goods` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `lssf_role`
--

DROP TABLE IF EXISTS `lssf_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `lssf_role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `create_time` datetime NOT NULL,
  `update_time` datetime NOT NULL,
  `name` varchar(18) NOT NULL,
  `remark` varchar(128) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `lssf_role`
--

LOCK TABLES `lssf_role` WRITE;
/*!40000 ALTER TABLE `lssf_role` DISABLE KEYS */;
INSERT INTO `lssf_role` VALUES (1,'2020-03-15 13:16:38','2020-10-20 16:38:39','超级管理员','超级管理员拥有最高权限。',1),(2,'2020-03-15 13:18:57','2020-03-21 22:18:43','普通管理员','普通管理员只有部分权限',1),(4,'2020-03-21 20:11:00','2020-03-23 17:49:00','测试角色','sadsa',0);
/*!40000 ALTER TABLE `lssf_role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `lssf_role_authorities`
--

DROP TABLE IF EXISTS `lssf_role_authorities`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `lssf_role_authorities` (
  `role_id` bigint(20) NOT NULL,
  `authorities_id` bigint(20) NOT NULL,
  KEY `FKhj7ap1o1cjrl7enr9arf5f2qp` (`authorities_id`),
  KEY `FKg3xdaexmr0x1qx8omhvjtk46d` (`role_id`),
  CONSTRAINT `FKg3xdaexmr0x1qx8omhvjtk46d` FOREIGN KEY (`role_id`) REFERENCES `lssf_role` (`id`),
  CONSTRAINT `FKhj7ap1o1cjrl7enr9arf5f2qp` FOREIGN KEY (`authorities_id`) REFERENCES `lssf_menu` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `lssf_role_authorities`
--

LOCK TABLES `lssf_role_authorities` WRITE;
/*!40000 ALTER TABLE `lssf_role_authorities` DISABLE KEYS */;
INSERT INTO `lssf_role_authorities` VALUES (2,2),(2,3),(2,5),(2,7),(2,11),(2,13),(2,16),(4,2),(4,13),(4,15),(1,2),(1,3),(1,5),(1,8),(1,9),(1,7),(1,10),(1,11),(1,12),(1,13),(1,14),(1,15),(1,16),(1,19),(1,20),(1,21),(1,22),(1,23),(1,24),(1,25),(1,26),(1,27),(1,28),(1,30),(1,31),(1,32),(1,29),(1,33),(1,34),(1,35),(1,36),(1,37),(1,38),(1,39),(1,40),(1,41),(1,42),(1,43),(1,44),(1,45),(1,46),(1,47),(1,48),(1,49),(1,50),(1,51),(1,52),(1,53),(1,54),(1,55),(1,56),(1,57),(1,58),(1,59),(1,60),(1,61),(1,62);
/*!40000 ALTER TABLE `lssf_role_authorities` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `lssf_site_setting`
--

DROP TABLE IF EXISTS `lssf_site_setting`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `lssf_site_setting` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `create_time` datetime NOT NULL,
  `update_time` datetime NOT NULL,
  `all_rights` varchar(256) NOT NULL,
  `logo_1` varchar(256) NOT NULL,
  `logo_2` varchar(256) NOT NULL,
  `qrcode` varchar(256) NOT NULL,
  `site_name` varchar(128) NOT NULL,
  `site_url` varchar(256) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `lssf_site_setting`
--

LOCK TABLES `lssf_site_setting` WRITE;
/*!40000 ALTER TABLE `lssf_site_setting` DISABLE KEYS */;
INSERT INTO `lssf_site_setting` VALUES (1,'2020-04-18 17:02:17','2020-10-17 20:16:59','©2016-2020【DrAyaneShindou】 版权所有','20201017/1602936765602.png','20201017/1602936928871.jpg','20201017/1602937012455.jpg','粮食收发平台','www.DrAyane.com');
/*!40000 ALTER TABLE `lssf_site_setting` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `lssf_user`
--

DROP TABLE IF EXISTS `lssf_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `lssf_user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `create_time` datetime NOT NULL,
  `update_time` datetime NOT NULL,
  `email` varchar(32) DEFAULT NULL,
  `head_pic` varchar(128) DEFAULT NULL,
  `mobile` varchar(12) DEFAULT NULL,
  `password` varchar(32) NOT NULL,
  `sex` int(11) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `username` varchar(18) NOT NULL,
  `role_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_btsosjytrl4hu7fnm1intcpo8` (`username`),
  KEY `FKg09b8o67eu61st68rv6nk8npj` (`role_id`),
  CONSTRAINT `FKg09b8o67eu61st68rv6nk8npj` FOREIGN KEY (`role_id`) REFERENCES `lssf_role` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `lssf_user`
--

LOCK TABLES `lssf_user` WRITE;
/*!40000 ALTER TABLE `lssf_user` DISABLE KEYS */;
INSERT INTO `lssf_user` VALUES (8,'2020-10-15 20:23:55','2020-10-15 20:30:20','DRAyaneShindou@163.com','20201015/1602765015937.jpg','17346716698','123456',1,1,'Ayane',1);
/*!40000 ALTER TABLE `lssf_user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `lssf_wanted_goods`
--

DROP TABLE IF EXISTS `lssf_wanted_goods`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `lssf_wanted_goods` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `create_time` datetime NOT NULL,
  `update_time` datetime NOT NULL,
  `content` varchar(1024) NOT NULL,
  `name` varchar(32) NOT NULL,
  `sell_price` float NOT NULL,
  `trade_place` varchar(128) NOT NULL,
  `view_number` int(11) NOT NULL,
  `peasant_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKqvrfd43yhp11er38hkfcxi103` (`peasant_id`),
  CONSTRAINT `FKqvrfd43yhp11er38hkfcxi103` FOREIGN KEY (`peasant_id`) REFERENCES `lssf_peasant` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `lssf_wanted_goods`
--

LOCK TABLES `lssf_wanted_goods` WRITE;
/*!40000 ALTER TABLE `lssf_wanted_goods` DISABLE KEYS */;
INSERT INTO `lssf_wanted_goods` VALUES (8,'2020-10-19 09:08:02','2020-10-19 09:08:02','动卡空间圣诞节阿克苏监督卡进口商的健康拉丝机读卡机是看得见啊跨世纪的卡拉是经典款了敬爱是大件事到卡上','小麦',200,'江西南昌',0,6),(9,'2020-10-19 11:46:53','2020-10-19 11:46:53','最好是优质的，不要以烂充好，。。。。。。。','大麦',300,'江西',0,6),(10,'2020-10-20 13:11:14','2020-10-20 13:11:14','斯柯达快圣诞节卡拉是基督教啊数据库的骄傲是扩大是看得见卡数据库大师级的卡口','大麦',12,'江西南昌',0,6);
/*!40000 ALTER TABLE `lssf_wanted_goods` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-10-24 22:19:06
