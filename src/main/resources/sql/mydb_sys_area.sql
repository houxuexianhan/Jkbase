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
-- Table structure for table `sys_area`
--

DROP TABLE IF EXISTS `sys_area`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sys_area` (
  `AreaId` int NOT NULL AUTO_INCREMENT,
  `A_AreaCode` varchar(10) NOT NULL,
  `A_AreaName` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `A_AreaNo` varchar(10) NOT NULL,
  `A_Level` int NOT NULL,
  `A_LevelName` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `A_ParentId` int NOT NULL,
  `A_ShowOrder` int NOT NULL,
  `A_Zoning` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`AreaId`),
  UNIQUE KEY `sys_Area_ix1` (`A_AreaNo`),
  UNIQUE KEY `sys_Area_ix2` (`A_AreaCode`)
) ENGINE=InnoDB AUTO_INCREMENT=65 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_area`
--

LOCK TABLES `sys_area` WRITE;
/*!40000 ALTER TABLE `sys_area` DISABLE KEYS */;
INSERT INTO `sys_area` VALUES (1,'BJ','北京市','110000',1,'直辖市',0,1,'华北地区'),(2,'TJ','天津市','120000',1,'直辖市',0,2,'华北地区'),(3,'HEB','河北省','130000',1,'省',0,3,'华北地区'),(4,'SX','山西省','140000',1,'省',0,4,'华北地区'),(5,'NMG','内蒙古自治区','150000',1,'自治区',0,5,'华北地区'),(6,'LN','辽宁省','210000',1,'省',0,6,'东北地区'),(7,'JL','吉林省','220000',1,'省',0,7,'东北地区'),(8,'HLJ','黑龙江省','230000',1,'省',0,8,'东北地区'),(9,'SH','上海市','310000',1,'直辖市',0,9,'华东地区'),(10,'JS','江苏省','320000',1,'省',0,10,'华东地区'),(11,'ZJ','浙江省','330000',1,'省',0,11,'华东地区'),(12,'AH','安徽省','340000',1,'省',0,12,'华东地区'),(13,'FJ','福建省','350000',1,'省',0,13,'华东地区'),(14,'JX','江西省','360000',1,'省',0,14,'华东地区'),(15,'SD','山东省','370000',1,'省',0,15,'华东地区'),(16,'HEN','河南省','410000',1,'省',0,16,'华中地区'),(17,'HUB','湖北省','420000',1,'省',0,17,'华中地区'),(18,'HUN','湖南省','430000',1,'省',0,18,'华中地区'),(19,'GD','广东省','440000',1,'省',0,19,'华南地区'),(20,'GX','广西壮族自治区','450000',1,'自治区',0,20,'华南地区'),(21,'HN','海南省','460000',1,'省',0,21,'华南地区'),(22,'CQ','重庆市','500000',1,'直辖市',0,22,'西南地区'),(23,'SC','四川省','510000',1,'省',0,23,'西南地区'),(24,'GZ','贵州省','520000',1,'省',0,24,'西南地区'),(25,'YN','云南省','530000',1,'省',0,25,'西南地区'),(26,'XZ','西藏自治区','540000',1,'自治区',0,26,'西南地区'),(27,'SXS','陕西省','610000',1,'省',0,27,'西北地区'),(28,'GS','甘肃省','620000',1,'省',0,28,'西北地区'),(29,'QH','青海省','630000',1,'省',0,29,'西北地区'),(30,'NX','宁夏回族自治区','640000',1,'自治区',0,30,'西北地区'),(31,'XJ','新疆维吾尔自治区','650000',1,'自治区',0,31,'西北地区'),(32,'TW','台湾省','710000',1,'省',0,32,'港澳台'),(33,'HK','香港特别行政区','810000',1,'行政区',0,33,'港澳台'),(34,'AM','澳门特别行政区','820000',1,'行政区',0,34,'港澳台'),(35,'HNHK','海口市','460100',2,'地级市',21,1,'华南地区'),(36,'HNSY','三亚市','460200',2,'地级市',21,2,'华南地区'),(37,'HNSA','三沙市','460300',2,'县级市',21,3,'华南地区'),(38,'HNWZS','五指山市','469001',2,'县级市',21,4,'华南地区'),(39,'HNQH','琼海市','469002',2,'县级市',21,5,'华南地区'),(40,'HNDZ','儋州市','469003',2,'县级市',21,6,'华南地区'),(41,'HNWC','文昌市','469005',2,'县级市',21,7,'华南地区'),(42,'HNWN','万宁市','469006',2,'县级市',21,8,'华南地区'),(43,'HNDF','东方市','469007',2,'县级市',21,9,'华南地区'),(44,'HNDA','定安县','469021',2,'县',21,10,'华南地区'),(45,'HNTC','屯昌县','469022',2,'县',21,11,'华南地区'),(46,'HNCM','澄迈县','469023',2,'县',21,12,'华南地区'),(47,'HNLG','临高县','469024',2,'县',21,13,'华南地区'),(48,'HNBS','白沙黎族自治县','469025',2,'自治县',21,14,'华南地区'),(49,'HNCJ','昌江黎族自治县','469026',2,'自治县',21,15,'华南地区'),(50,'HNLD','乐东黎族自治县','469027',2,'自治县',21,16,'华南地区'),(51,'HNLS','陵水黎族自治县','469028',2,'自治县',21,17,'华南地区'),(52,'HNBT','保亭黎族苗族自治县','469029',2,'自治县',21,18,'华南地区'),(53,'HNQZ','琼中黎族苗族自治县','469030',2,'自治县',21,19,'华南地区'),(58,'23','dyd2','233432',2,'直辖市',57,2323,'港澳台'),(59,'2342','dyd3','23424',2,'自治县',57,242423,'港澳台'),(60,'424','2342342','234242',3,'乡',58,42,'港澳台'),(62,'dyd1','dyd1','333333',2,'县',61,1,'港澳台'),(64,'dyd2','dyd2','3333334444',3,'区',62,2,'港澳台');
/*!40000 ALTER TABLE `sys_area` ENABLE KEYS */;
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
