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
-- Table structure for table `sys_user`
--

DROP TABLE IF EXISTS `sys_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sys_user` (
  `UserId` int NOT NULL AUTO_INCREMENT,
  `U_CName` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `U_CompanyID` int NOT NULL,
  `U_Disabled` int NOT NULL DEFAULT '0',
  `U_Expired` int NOT NULL DEFAULT '0',
  `U_ExtendField` varchar(255) DEFAULT NULL,
  `U_JoinTime` datetime(6) DEFAULT NULL,
  `U_LastIp` varchar(50) DEFAULT NULL,
  `U_LastTime` datetime DEFAULT NULL,
  `U_LoginName` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `U_MobileNo` varchar(15) DEFAULT NULL,
  `U_PhotoUrl` varchar(150) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `U_Pwd` varchar(64) NOT NULL,
  `U_Salt` varchar(64) DEFAULT NULL,
  `U_Status` int NOT NULL,
  `U_Type` int NOT NULL,
  PRIMARY KEY (`UserId`),
  UNIQUE KEY `sys_User_ix1` (`U_LoginName`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_user`
--

LOCK TABLES `sys_user` WRITE;
/*!40000 ALTER TABLE `sys_user` DISABLE KEYS */;
INSERT INTO `sys_user` VALUES (1,'超级管理员',1,0,0,'0,10,blue','2015-06-10 10:26:15.000000','10.10.10.89','2016-06-15 11:07:19','admin','182xxxxxxxxx','/resources/upload/user/image/15209958046719763_.jpg','b4f92a719c98cd13a50a117092f04250809a303ce0d63d5861b37e59d02d4b90','9e77501e-725f-4d69-812e-56b0c2186f11',0,0),(2,'aa',1,0,0,'','2020-09-23 10:20:55.186000',NULL,NULL,'aa','',NULL,'2287871b650ccd0ff233ca02aca8d419caba207882de2029cf008950795a7378','f3366bc8-a353-4ef3-a0db-13848c1966ff',0,2),(3,'cc',4,0,0,'',NULL,NULL,NULL,'cc','',NULL,'2eeca72ac63014743a75d71c930d27c533902b0c39f8035cbe9d1986043c528c',NULL,0,2);
/*!40000 ALTER TABLE `sys_user` ENABLE KEYS */;
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
