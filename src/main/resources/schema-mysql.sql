-- MySQL dump 10.13  Distrib 8.0.20, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: mydb
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
-- Table structure for table `sys_app`
--

DROP TABLE IF EXISTS sys_app;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE sys_app (
  AppID int NOT NULL AUTO_INCREMENT,
  A_AppDesc varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  A_AppName varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  A_AppUrl varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  A_IsSys int NOT NULL DEFAULT '0',
  A_Version varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (AppID),
  UNIQUE KEY sys_App_ix (A_AppName)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `sys_area`
--

DROP TABLE IF EXISTS sys_area;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE sys_area (
  AreaId int NOT NULL AUTO_INCREMENT,
  A_AreaCode varchar(10) NOT NULL,
  A_AreaName varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  A_AreaNo varchar(10) NOT NULL,
  A_Level int NOT NULL,
  A_LevelName varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  A_ParentId int NOT NULL,
  A_ShowOrder int NOT NULL,
  A_Zoning varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (AreaId),
  UNIQUE KEY sys_Area_ix1 (A_AreaNo),
  UNIQUE KEY sys_Area_ix2 (A_AreaCode)
) ENGINE=InnoDB AUTO_INCREMENT=65 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `sys_company`
--

DROP TABLE IF EXISTS sys_company;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE sys_company (
  CompanyID int NOT NULL AUTO_INCREMENT,
  C_AreaId int NOT NULL,
  C_ChildCount int NOT NULL DEFAULT '0',
  C_CName varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  C_Level int NOT NULL DEFAULT '1',
  C_ParentID int NOT NULL DEFAULT '0',
  C_ShowOrder int NOT NULL DEFAULT '0',
  PRIMARY KEY (CompanyID),
  UNIQUE KEY sys_Company_idx1 (C_ParentID,C_CName)
) ENGINE=InnoDB AUTO_INCREMENT=41 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `sys_company_role`
--

DROP TABLE IF EXISTS sys_company_role;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE sys_company_role (
  Companyid int NOT NULL,
  Roleid int NOT NULL,
  PRIMARY KEY (Companyid,Roleid)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='部门与角色';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `sys_event`
--

DROP TABLE IF EXISTS sys_event;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE sys_event (
  EventID bigint NOT NULL AUTO_INCREMENT,
  E_AppID int DEFAULT NULL,
  E_AppName varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  E_DateTime datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  E_From varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  E_IP varchar(50) DEFAULT NULL,
  E_ModCode varchar(6) DEFAULT NULL,
  E_ModName varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  E_Record varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  E_Type int NOT NULL,
  E_UserID int DEFAULT NULL,
  E_UserName varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (EventID)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `sys_field`
--

DROP TABLE IF EXISTS sys_field;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE sys_field (
  FieldID int NOT NULL AUTO_INCREMENT,
  F_CName varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  F_Remark varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (FieldID),
  UNIQUE KEY sys_Field_ix1 (F_CName)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `sys_fieldvalue`
--

DROP TABLE IF EXISTS sys_fieldvalue;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE sys_fieldvalue (
  ValueID int NOT NULL AUTO_INCREMENT,
  V_FieldID int NOT NULL,
  V_ShowOrder int NOT NULL,
  V_Text varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (ValueID),
  UNIQUE KEY sys_FieldValue_ix1 (V_FieldID,V_Text)
) ENGINE=InnoDB AUTO_INCREMENT=37 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `sys_function`
--

DROP TABLE IF EXISTS sys_function;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE sys_function (
  FunctionId int NOT NULL AUTO_INCREMENT,
  F_Desc varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  F_Enable int NOT NULL,
  F_ModuleId int NOT NULL,
  F_Name varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  F_Value int NOT NULL,
  PRIMARY KEY (FunctionId),
  UNIQUE KEY sys_Function_ix1 (F_ModuleId,F_Value),
  UNIQUE KEY sys_Function_ix2 (F_ModuleId,F_Name)
) ENGINE=InnoDB AUTO_INCREMENT=169 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `sys_module`
--

DROP TABLE IF EXISTS sys_module;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE sys_module (
  ModuleID int NOT NULL AUTO_INCREMENT,
  M_AppID int NOT NULL,
  M_CName varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  M_Code varchar(50) NOT NULL,
  M_Icon varchar(50) DEFAULT NULL,
  M_IsClose int NOT NULL,
  M_OrderLevel varchar(4) DEFAULT NULL,
  M_ParentID int NOT NULL,
  M_URL varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (ModuleID),
  UNIQUE KEY sys_Module_idx1 (M_AppID,M_CName),
  UNIQUE KEY sys_Module_idx2 (M_Code)
) ENGINE=InnoDB AUTO_INCREMENT=73 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `sys_online`
--

DROP TABLE IF EXISTS sys_online;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE sys_online (
  OnlineID int NOT NULL AUTO_INCREMENT,
  O_Ip varchar(20) NOT NULL,
  O_LastTime datetime NOT NULL,
  O_LastUrl varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  O_LoginTime datetime NOT NULL,
  O_SessionID varchar(24) NOT NULL,
  O_UserName varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (OnlineID)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `sys_role`
--

DROP TABLE IF EXISTS sys_role;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE sys_role (
  RoleID int NOT NULL AUTO_INCREMENT,
  R_Description varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  R_RoleName varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (RoleID),
  UNIQUE KEY sys_Role_ix (R_RoleName)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `sys_role_app`
--

DROP TABLE IF EXISTS sys_role_app;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE sys_role_app (
  A_RoleID int NOT NULL,
  A_AppID int NOT NULL,
  PRIMARY KEY (A_RoleID,A_AppID)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `sys_role_module`
--

DROP TABLE IF EXISTS sys_role_module;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE sys_role_module (
  P_RoleID int NOT NULL,
  P_ModuleID int NOT NULL,
  P_Value int NOT NULL,
  PRIMARY KEY (P_RoleID,P_ModuleID)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `sys_user`
--

DROP TABLE IF EXISTS sys_user;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE sys_user (
  UserId int NOT NULL AUTO_INCREMENT,
  U_CName varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  U_CompanyID int NOT NULL,
  U_Disabled int NOT NULL DEFAULT '0',
  U_Expired int NOT NULL DEFAULT '0',
  U_Email varchar(255) DEFAULT NULL,
  U_JoinTime datetime(6) DEFAULT NULL,
  U_LastIp varchar(50) DEFAULT NULL,
  U_LastTime datetime DEFAULT NULL,
  U_LoginName varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  U_MobileNo varchar(15) DEFAULT NULL,
  U_PhotoUrl varchar(150) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  U_Pwd varchar(64) NOT NULL,
  U_Salt varchar(64) DEFAULT NULL,
  U_Status int NOT NULL,
  U_Type int NOT NULL,
  PRIMARY KEY (UserId),
  UNIQUE KEY sys_User_ix1 (U_LoginName)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `sys_user_role`
--

DROP TABLE IF EXISTS sys_user_role;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE sys_user_role (
  R_UserID int NOT NULL,
  R_RoleID int NOT NULL,
  PRIMARY KEY (R_UserID,R_RoleID)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Temporary view structure for view `view_sys_company`
--

DROP TABLE IF EXISTS view_sys_company;
/*!50001 DROP VIEW IF EXISTS view_sys_company*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `view_sys_company` AS SELECT 
 1 AS CompanyID,
 1 AS C_AreaId,
 1 AS C_ChildCount,
 1 AS C_CName,
 1 AS C_Level,
 1 AS C_ParentID,
 1 AS C_ShowOrder,
 1 AS A_AreaName,
 1 AS C_ParentName*/;
SET character_set_client = @saved_cs_client;

--
-- Temporary view structure for view `view_sys_company_role`
--

DROP TABLE IF EXISTS view_sys_company_role;
/*!50001 DROP VIEW IF EXISTS view_sys_company_role*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `view_sys_company_role` AS SELECT 
 1 AS CompanyID,
 1 AS C_AreaId,
 1 AS C_ChildCount,
 1 AS C_CName,
 1 AS C_Level,
 1 AS C_ParentID,
 1 AS C_ShowOrder,
 1 AS roles*/;
SET character_set_client = @saved_cs_client;

--
-- Temporary view structure for view `view_sys_function`
--

DROP TABLE IF EXISTS view_sys_function;
/*!50001 DROP VIEW IF EXISTS view_sys_function*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `view_sys_function` AS SELECT 
 1 AS FunctionId,
 1 AS F_Desc,
 1 AS F_Enable,
 1 AS F_ModuleId,
 1 AS F_Name,
 1 AS F_Value,
 1 AS M_CName,
 1 AS M_Code,
 1 AS M_AppID,
 1 AS M_OrderLevel,
 1 AS A_AppName,
 1 AS M_ParentName*/;
SET character_set_client = @saved_cs_client;

--
-- Temporary view structure for view `view_sys_module`
--

DROP TABLE IF EXISTS view_sys_module;
/*!50001 DROP VIEW IF EXISTS view_sys_module*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `view_sys_module` AS SELECT 
 1 AS ModuleID,
 1 AS M_AppID,
 1 AS M_CName,
 1 AS M_Code,
 1 AS M_Icon,
 1 AS M_IsClose,
 1 AS M_OrderLevel,
 1 AS M_ParentID,
 1 AS M_URL,
 1 AS A_AppName,
 1 AS M_ParentName*/;
SET character_set_client = @saved_cs_client;

--
-- Temporary view structure for view `view_sys_role_app`
--

DROP TABLE IF EXISTS view_sys_role_app;
/*!50001 DROP VIEW IF EXISTS view_sys_role_app*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `view_sys_role_app` AS SELECT 
 1 AS A_RoleID,
 1 AS A_AppID,
 1 AS RoleID,
 1 AS R_Description,
 1 AS R_RoleName,
 1 AS AppID,
 1 AS A_AppDesc,
 1 AS A_AppName,
 1 AS A_AppUrl,
 1 AS A_IsSys,
 1 AS A_Version*/;
SET character_set_client = @saved_cs_client;

--
-- Temporary view structure for view `view_sys_user`
--

DROP TABLE IF EXISTS view_sys_user;
/*!50001 DROP VIEW IF EXISTS view_sys_user*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `view_sys_user` AS SELECT 
 1 AS UserId,
 1 AS U_CName,
 1 AS U_CompanyID,
 1 AS U_Disabled,
 1 AS U_Expired,
 1 AS U_Email,
 1 AS U_JoinTime,
 1 AS U_LastIp,
 1 AS U_LastTime,
 1 AS U_LoginName,
 1 AS U_MobileNo,
 1 AS U_PhotoUrl,
 1 AS U_Pwd,
 1 AS U_Salt,
 1 AS U_Status,
 1 AS U_Type,
 1 AS U_TypeText,
 1 AS U_StatusText,
 1 AS U_CompanyName*/;
SET character_set_client = @saved_cs_client;

--
-- Temporary view structure for view `view_sys_user_attr`
--

DROP TABLE IF EXISTS view_sys_user_attr;
/*!50001 DROP VIEW IF EXISTS view_sys_user_attr*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `view_sys_user_attr` AS SELECT 
 1 AS R_UserID,
 1 AS AttrKey,
 1 AS AttrValue,
 1 AS U_LoginName*/;
SET character_set_client = @saved_cs_client;

--
-- Temporary view structure for view `view_sys_user_role`
--

DROP TABLE IF EXISTS view_sys_user_role;
/*!50001 DROP VIEW IF EXISTS view_sys_user_role*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `view_sys_user_role` AS SELECT 
 1 AS R_UserID,
 1 AS R_RoleID*/;
SET character_set_client = @saved_cs_client;

--
-- Temporary view structure for view `view_sys_user_role_module`
--

DROP TABLE IF EXISTS view_sys_user_role_module;
/*!50001 DROP VIEW IF EXISTS view_sys_user_role_module*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `view_sys_user_role_module` AS SELECT 
 1 AS R_UserID,
 1 AS R_RoleID,
 1 AS P_RoleID,
 1 AS P_ModuleID,
 1 AS P_Value,
 1 AS ModuleID,
 1 AS M_AppID,
 1 AS M_CName,
 1 AS M_Code,
 1 AS M_Icon,
 1 AS M_IsClose,
 1 AS M_OrderLevel,
 1 AS M_ParentID,
 1 AS M_URL,
 1 AS A_AppName,
 1 AS M_ParentName*/;
SET character_set_client = @saved_cs_client;

--
-- Final view structure for view `view_sys_company`
--

/*!50001 DROP VIEW IF EXISTS view_sys_company*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=ssouser@`%` SQL SECURITY DEFINER */
/*!50001 VIEW view_sys_company AS select c.CompanyID AS CompanyID,c.C_AreaId AS C_AreaId,c.C_ChildCount AS C_ChildCount,c.C_CName AS C_CName,c.C_Level AS C_Level,c.C_ParentID AS C_ParentID,c.C_ShowOrder AS C_ShowOrder,a.A_AreaName AS A_AreaName,(select sys_company.C_CName from sys_company where (sys_company.CompanyID = c.C_ParentID)) AS C_ParentName from (sys_company c join sys_area a on((c.C_AreaId = a.AreaId))) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `view_sys_company_role`
--

/*!50001 DROP VIEW IF EXISTS view_sys_company_role*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=ssouser@`%` SQL SECURITY DEFINER */
/*!50001 VIEW view_sys_company_role AS select c.CompanyID AS CompanyID,c.C_AreaId AS C_AreaId,c.C_ChildCount AS C_ChildCount,c.C_CName AS C_CName,c.C_Level AS C_Level,c.C_ParentID AS C_ParentID,c.C_ShowOrder AS C_ShowOrder,(select group_concat(r.R_RoleName separator ',') from (sys_company_role cr join sys_role r on((cr.Roleid = r.RoleID))) where (c.CompanyID = cr.Companyid)) AS roles from sys_company c */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `view_sys_function`
--

/*!50001 DROP VIEW IF EXISTS view_sys_function*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=ssouser@`%` SQL SECURITY DEFINER */
/*!50001 VIEW view_sys_function AS select a.FunctionId AS FunctionId,a.F_Desc AS F_Desc,a.F_Enable AS F_Enable,a.F_ModuleId AS F_ModuleId,a.F_Name AS F_Name,a.F_Value AS F_Value,b.M_CName AS M_CName,b.M_Code AS M_Code,b.M_AppID AS M_AppID,b.M_OrderLevel AS M_OrderLevel,c.A_AppName AS A_AppName,(select x.M_CName from sys_module x where (x.ModuleID = b.M_ParentID)) AS M_ParentName from ((sys_function a join sys_module b on((a.F_ModuleId = b.ModuleID))) join sys_app c on((b.M_AppID = c.AppID))) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `view_sys_module`
--

/*!50001 DROP VIEW IF EXISTS view_sys_module*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=ssouser@`%` SQL SECURITY DEFINER */
/*!50001 VIEW view_sys_module AS select a.ModuleID AS ModuleID,a.M_AppID AS M_AppID,a.M_CName AS M_CName,a.M_Code AS M_Code,a.M_Icon AS M_Icon,a.M_IsClose AS M_IsClose,a.M_OrderLevel AS M_OrderLevel,a.M_ParentID AS M_ParentID,a.M_URL AS M_URL,b.A_AppName AS A_AppName,(select x.M_CName from sys_module x where (x.ModuleID = a.M_ParentID)) AS M_ParentName from (sys_module a join sys_app b on((a.M_AppID = b.AppID))) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `view_sys_role_app`
--

/*!50001 DROP VIEW IF EXISTS view_sys_role_app*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=ssouser@`%` SQL SECURITY DEFINER */
/*!50001 VIEW view_sys_role_app AS select a.A_RoleID AS A_RoleID,a.A_AppID AS A_AppID,b.RoleID AS RoleID,b.R_Description AS R_Description,b.R_RoleName AS R_RoleName,c.AppID AS AppID,c.A_AppDesc AS A_AppDesc,c.A_AppName AS A_AppName,c.A_AppUrl AS A_AppUrl,c.A_IsSys AS A_IsSys,c.A_Version AS A_Version from ((sys_role_app a join sys_role b on((a.A_RoleID = b.RoleID))) join sys_app c on((a.A_AppID = c.AppID))) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `view_sys_user`
--

/*!50001 DROP VIEW IF EXISTS view_sys_user*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=ssouser@`%` SQL SECURITY DEFINER */
/*!50001 VIEW view_sys_user AS select a.UserId AS UserId,a.U_CName AS U_CName,a.U_CompanyID AS U_CompanyID,a.U_Disabled AS U_Disabled,a.U_Expired AS U_Expired,a.U_Email AS U_Email,a.U_JoinTime AS U_JoinTime,a.U_LastIp AS U_LastIp,a.U_LastTime AS U_LastTime,a.U_LoginName AS U_LoginName,a.U_MobileNo AS U_MobileNo,a.U_PhotoUrl AS U_PhotoUrl,a.U_Pwd AS U_Pwd,a.U_Salt AS U_Salt,a.U_Status AS U_Status,a.U_Type AS U_Type,(case a.U_Type when 0 then '超级用户' when 1 then '管理用户' when 2 then '企业用户' else '未定义' end) AS U_TypeText,(case a.U_Status when 0 then '正常' when 1 then '禁止' else '未定义' end) AS U_StatusText,b.C_CName AS U_CompanyName from (sys_user a join sys_company b on((a.U_CompanyID = b.CompanyID))) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `view_sys_user_attr`
--

/*!50001 DROP VIEW IF EXISTS view_sys_user_attr*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=ssouser@`%` SQL SECURITY DEFINER */
/*!50001 VIEW view_sys_user_attr AS select v.R_UserID AS R_UserID,v.AttrKey AS AttrKey,v.AttrValue AS AttrValue,u.U_LoginName AS U_LoginName from ((select ur.R_UserID AS R_UserID,'role' AS AttrKey,r.R_RoleName AS AttrValue from ((view_sys_user_role ur join sys_user u on((ur.R_UserID = u.UserId))) join sys_role r on((r.RoleID = ur.R_RoleID))) union all select distinct ur.R_UserID AS R_UserID,'app' AS AttrKey,a.A_AppName AS AttrValue from ((sys_user_role ur join sys_role_app ra on((ur.R_RoleID = ra.A_RoleID))) join sys_app a on((a.AppID = ra.A_AppID)))) v join sys_user u on((v.R_UserID = u.UserId))) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `view_sys_user_role`
--

/*!50001 DROP VIEW IF EXISTS view_sys_user_role*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=ssouser@`%` SQL SECURITY DEFINER */
/*!50001 VIEW view_sys_user_role AS select distinct v.R_UserID AS R_UserID,v.R_RoleID AS R_RoleID from (select sys_user_role.R_UserID AS R_UserID,sys_user_role.R_RoleID AS R_RoleID from sys_user_role union all select u.UserId AS userid,cr.Roleid AS roleid from (sys_user u join sys_company_role cr on((u.U_CompanyID = cr.Companyid)))) v */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `view_sys_user_role_module`
--

/*!50001 DROP VIEW IF EXISTS view_sys_user_role_module*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=ssouser@`%` SQL SECURITY DEFINER */
/*!50001 VIEW view_sys_user_role_module AS select r.R_UserID AS R_UserID,r.R_RoleID AS R_RoleID,p.P_RoleID AS P_RoleID,p.P_ModuleID AS P_ModuleID,p.P_Value AS P_Value,m.ModuleID AS ModuleID,m.M_AppID AS M_AppID,m.M_CName AS M_CName,m.M_Code AS M_Code,m.M_Icon AS M_Icon,m.M_IsClose AS M_IsClose,m.M_OrderLevel AS M_OrderLevel,m.M_ParentID AS M_ParentID,m.M_URL AS M_URL,m.A_AppName AS A_AppName,m.M_ParentName AS M_ParentName from ((view_sys_user_role r join sys_role_module p on(((r.R_RoleID = p.P_RoleID) and (p.P_Value > 0)))) join view_sys_module m on((m.ModuleID = p.P_ModuleID))) order by m.M_AppID,m.M_OrderLevel */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed
