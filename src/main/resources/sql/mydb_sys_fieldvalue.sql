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
-- Table structure for table `sys_fieldvalue`
--

DROP TABLE IF EXISTS `sys_fieldvalue`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sys_fieldvalue` (
  `ValueID` int NOT NULL AUTO_INCREMENT,
  `V_FieldID` int NOT NULL,
  `V_ShowOrder` int NOT NULL,
  `V_Text` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`ValueID`),
  UNIQUE KEY `sys_FieldValue_ix1` (`V_FieldID`,`V_Text`)
) ENGINE=InnoDB AUTO_INCREMENT=37 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_fieldvalue`
--

LOCK TABLES `sys_fieldvalue` WRITE;
/*!40000 ALTER TABLE `sys_fieldvalue` DISABLE KEYS */;
INSERT INTO `sys_fieldvalue` VALUES (1,4,0,'华北地区'),(2,4,1,'东北地区'),(3,4,2,'华东地区'),(4,4,3,'华中地区'),(5,4,4,'华南地区'),(6,4,5,'西北地区'),(7,4,6,'西南地区'),(8,4,7,'港澳台'),(9,5,0,'直辖市'),(10,5,1,'省'),(11,5,2,'自治区'),(12,5,3,'地级市'),(13,5,4,'县级市'),(14,5,5,'县'),(15,5,6,'自治县'),(16,5,7,'乡'),(17,5,8,'镇'),(18,5,9,'区'),(19,3,0,'蓝色'),(20,3,1,'黄色'),(21,3,2,'黑色'),(22,3,3,'白色'),(23,2,0,'个'),(24,2,1,'件'),(25,2,2,'米'),(26,2,3,'升'),(27,1,0,'送货上门'),(28,1,1,'加急'),(29,1,2,'注意轻放'),(34,2,3,'只'),(35,1,1,'afd');
/*!40000 ALTER TABLE `sys_fieldvalue` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-09-24 17:52:39
