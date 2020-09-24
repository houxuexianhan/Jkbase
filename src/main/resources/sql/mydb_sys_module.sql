-- MySQL dump 10.13  Distrib 8.0.20, for Win64 (x86_64)
--
-- Host: localhost    Database: mydb
-- ------------------------------------------------------
-- Server version	8.0.20

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `sys_module`
--

DROP TABLE IF EXISTS `sys_module`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sys_module` (
  `ModuleID` int NOT NULL AUTO_INCREMENT,
  `M_AppID` int NOT NULL,
  `M_CName` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `M_Code` varchar(50) NOT NULL,
  `M_Icon` varchar(50) DEFAULT NULL,
  `M_IsClose` int NOT NULL,
  `M_IsSys` int NOT NULL,
  `M_OrderLevel` varchar(4) DEFAULT NULL,
  `M_ParentID` int NOT NULL,
  `M_URL` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`ModuleID`),
  UNIQUE KEY `sys_Module_idx1` (`M_AppID`,`M_CName`),
  UNIQUE KEY `sys_Module_idx2` (`M_Code`)
) ENGINE=InnoDB AUTO_INCREMENT=73 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_module`
--

LOCK TABLES `sys_module` WRITE;
/*!40000 ALTER TABLE `sys_module` DISABLE KEYS */;
INSERT INTO `sys_module` VALUES (1,1,'框架系统','frm','fa fa-square-o',0,1,'0000',0,''),(2,1,'应用与模块管理','ModuleMng','fa fa-square',0,1,'0001',1,'frm/ModuleMng/module.page'),(4,1,'字段类型管理','FieldMng','fa fa-tag',0,1,'0004',1,'frm/FieldMng/module.page'),(5,1,'系统异常日志','SystemErrorLog','fa fa-file',1,1,'0005',1,'frm/SystemErrorLog/module.page'),(7,2,'系统管理','sys','fa fa-asterisk',0,0,'0000',0,''),(8,2,'行政区管理','AreaMng','fa fa-map-o',0,0,'0002',7,'sys/AreaMng/module.page'),(9,2,'组织机构管理','CompanyMng','fa fa-tree',0,0,'0003',7,'sys/CompanyMng/module.page'),(10,2,'角色应用权限','RoleMng','fa fa-key',0,0,'0006',7,'sys/RoleMng/module.page'),(11,2,'用户管理','UserMng','fa fa-user',0,0,'0004',7,'sys/UserMng/module.page'),(12,2,'数据字典','FieldValueMng','fa fa-book',0,0,'0001',7,'sys/FieldValueMng/module.page'),(13,2,'事件日志查询','EventMng','fa fa-sticky-note-o',0,0,'0007',7,'sys/EventMng/module.page'),(14,2,'系统参数管理','SystemParam','fa fa-cogs',0,0,'0008',7,'sys/SystemParam/module.page'),(16,2,'在线用户列表','OnlineUser','fa fa-street-view',1,0,'0010',7,'sys/OnlineUser/module.page'),(48,2,'角色(用户)管理','RoleUserMng','fa fa-user-secret',0,0,'0005',7,'sys/RoleUserMng/module.page'),(61,1,'功能管理','FunctionMng','fa fa-envira',0,1,'0002',1,'frm/FunctionMng/module.page'),(64,3,'广告管理','advMng','fa fa-bell',0,0,'2001',0,''),(66,3,'视频管理','VideoMng','fa fa-video-camera',0,0,'2003',64,'Advertising/VideoMng/module.page'),(67,3,'广告发布','','fa fa-television',0,0,'2101',0,''),(68,3,'发布文本通知','TextPublish','fa fa-file-text-o',0,0,'2102',67,'Advertising/TextPublish/module.page'),(69,3,'发布图片通知','ImagePublish','fa fa-picture-o',0,0,'2103',67,'Advertising/ImagePublish/module.page'),(70,3,'发布视频通知','VideoPublish','fa fa-video-camera',0,0,'2104',67,'Advertising/VideoPublish/module.page'),(71,3,'清除通知','Clear','fa fa-eraser',0,0,'2105',67,'Advertising/Clear/module.page'),(72,3,'发布检票班次','CheckPublish','fa fa-bus',0,0,'2106',67,'Advertising/CheckPublish/module.page');
/*!40000 ALTER TABLE `sys_module` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-09-24 17:52:38
