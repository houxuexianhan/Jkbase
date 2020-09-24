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
-- Temporary view structure for view `view_sys_function`
--

DROP TABLE IF EXISTS `view_sys_function`;
/*!50001 DROP VIEW IF EXISTS `view_sys_function`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `view_sys_function` AS SELECT 
 1 AS `FunctionId`,
 1 AS `F_Desc`,
 1 AS `F_Enable`,
 1 AS `F_ModuleId`,
 1 AS `F_Name`,
 1 AS `F_Value`,
 1 AS `ModuleID`,
 1 AS `M_AppID`,
 1 AS `M_CName`,
 1 AS `M_Code`,
 1 AS `M_Icon`,
 1 AS `M_IsClose`,
 1 AS `M_IsSys`,
 1 AS `M_OrderLevel`,
 1 AS `M_ParentID`,
 1 AS `M_URL`,
 1 AS `AppID`,
 1 AS `A_AppDesc`,
 1 AS `A_AppName`,
 1 AS `A_AppUrl`,
 1 AS `A_IsSys`,
 1 AS `A_Version`,
 1 AS `M_ParentName`*/;
SET character_set_client = @saved_cs_client;

--
-- Temporary view structure for view `view_sys_user`
--

DROP TABLE IF EXISTS `view_sys_user`;
/*!50001 DROP VIEW IF EXISTS `view_sys_user`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `view_sys_user` AS SELECT 
 1 AS `UserId`,
 1 AS `U_CName`,
 1 AS `U_CompanyID`,
 1 AS `U_Disabled`,
 1 AS `U_Expired`,
 1 AS `U_ExtendField`,
 1 AS `U_JoinTime`,
 1 AS `U_LastIp`,
 1 AS `U_LastTime`,
 1 AS `U_LoginName`,
 1 AS `U_MobileNo`,
 1 AS `U_PhotoUrl`,
 1 AS `U_Pwd`,
 1 AS `U_Salt`,
 1 AS `U_Status`,
 1 AS `U_Type`,
 1 AS `U_TypeText`,
 1 AS `U_StatusText`,
 1 AS `U_CompanyName`*/;
SET character_set_client = @saved_cs_client;

--
-- Temporary view structure for view `view_sys_role_app`
--

DROP TABLE IF EXISTS `view_sys_role_app`;
/*!50001 DROP VIEW IF EXISTS `view_sys_role_app`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `view_sys_role_app` AS SELECT 
 1 AS `A_RoleID`,
 1 AS `A_AppID`,
 1 AS `RoleID`,
 1 AS `R_Description`,
 1 AS `R_RoleName`,
 1 AS `AppID`,
 1 AS `A_AppDesc`,
 1 AS `A_AppName`,
 1 AS `A_AppUrl`,
 1 AS `A_IsSys`,
 1 AS `A_Version`*/;
SET character_set_client = @saved_cs_client;

--
-- Temporary view structure for view `view_sys_company`
--

DROP TABLE IF EXISTS `view_sys_company`;
/*!50001 DROP VIEW IF EXISTS `view_sys_company`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `view_sys_company` AS SELECT 
 1 AS `CompanyID`,
 1 AS `C_AreaId`,
 1 AS `C_ChildCount`,
 1 AS `C_CName`,
 1 AS `C_Level`,
 1 AS `C_ParentID`,
 1 AS `C_ShowOrder`,
 1 AS `A_AreaName`,
 1 AS `C_ParentName`*/;
SET character_set_client = @saved_cs_client;

--
-- Temporary view structure for view `view_sys_user_role_module`
--

DROP TABLE IF EXISTS `view_sys_user_role_module`;
/*!50001 DROP VIEW IF EXISTS `view_sys_user_role_module`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `view_sys_user_role_module` AS SELECT 
 1 AS `R_UserID`,
 1 AS `R_RoleID`,
 1 AS `P_RoleID`,
 1 AS `P_ModuleID`,
 1 AS `P_Value`,
 1 AS `ModuleID`,
 1 AS `M_AppID`,
 1 AS `M_CName`,
 1 AS `M_Code`,
 1 AS `M_Icon`,
 1 AS `M_IsClose`,
 1 AS `M_IsSys`,
 1 AS `M_OrderLevel`,
 1 AS `M_ParentID`,
 1 AS `M_URL`,
 1 AS `A_AppName`,
 1 AS `M_ParentName`*/;
SET character_set_client = @saved_cs_client;

--
-- Temporary view structure for view `view_sys_module`
--

DROP TABLE IF EXISTS `view_sys_module`;
/*!50001 DROP VIEW IF EXISTS `view_sys_module`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `view_sys_module` AS SELECT 
 1 AS `ModuleID`,
 1 AS `M_AppID`,
 1 AS `M_CName`,
 1 AS `M_Code`,
 1 AS `M_Icon`,
 1 AS `M_IsClose`,
 1 AS `M_IsSys`,
 1 AS `M_OrderLevel`,
 1 AS `M_ParentID`,
 1 AS `M_URL`,
 1 AS `A_AppName`,
 1 AS `M_ParentName`*/;
SET character_set_client = @saved_cs_client;

--
-- Final view structure for view `view_sys_function`
--

/*!50001 DROP VIEW IF EXISTS `view_sys_function`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`cms_user`@`%` SQL SECURITY DEFINER */
/*!50001 VIEW `view_sys_function` AS select `a`.`FunctionId` AS `FunctionId`,`a`.`F_Desc` AS `F_Desc`,`a`.`F_Enable` AS `F_Enable`,`a`.`F_ModuleId` AS `F_ModuleId`,`a`.`F_Name` AS `F_Name`,`a`.`F_Value` AS `F_Value`,`b`.`ModuleID` AS `ModuleID`,`b`.`M_AppID` AS `M_AppID`,`b`.`M_CName` AS `M_CName`,`b`.`M_Code` AS `M_Code`,`b`.`M_Icon` AS `M_Icon`,`b`.`M_IsClose` AS `M_IsClose`,`b`.`M_IsSys` AS `M_IsSys`,`b`.`M_OrderLevel` AS `M_OrderLevel`,`b`.`M_ParentID` AS `M_ParentID`,`b`.`M_URL` AS `M_URL`,`c`.`AppID` AS `AppID`,`c`.`A_AppDesc` AS `A_AppDesc`,`c`.`A_AppName` AS `A_AppName`,`c`.`A_AppUrl` AS `A_AppUrl`,`c`.`A_IsSys` AS `A_IsSys`,`c`.`A_Version` AS `A_Version`,(select `x`.`M_CName` from `sys_module` `x` where (`x`.`ModuleID` = `b`.`M_ParentID`)) AS `M_ParentName` from ((`sys_function` `a` join `sys_module` `b` on((`a`.`F_ModuleId` = `b`.`ModuleID`))) join `sys_app` `c` on((`b`.`M_AppID` = `c`.`AppID`))) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `view_sys_user`
--

/*!50001 DROP VIEW IF EXISTS `view_sys_user`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`cms_user`@`%` SQL SECURITY DEFINER */
/*!50001 VIEW `view_sys_user` AS select `a`.`UserId` AS `UserId`,`a`.`U_CName` AS `U_CName`,`a`.`U_CompanyID` AS `U_CompanyID`,`a`.`U_Disabled` AS `U_Disabled`,`a`.`U_Expired` AS `U_Expired`,`a`.`U_ExtendField` AS `U_ExtendField`,`a`.`U_JoinTime` AS `U_JoinTime`,`a`.`U_LastIp` AS `U_LastIp`,`a`.`U_LastTime` AS `U_LastTime`,`a`.`U_LoginName` AS `U_LoginName`,`a`.`U_MobileNo` AS `U_MobileNo`,`a`.`U_PhotoUrl` AS `U_PhotoUrl`,`a`.`U_Pwd` AS `U_Pwd`,`a`.`U_Salt` AS `U_Salt`,`a`.`U_Status` AS `U_Status`,`a`.`U_Type` AS `U_Type`,(case `a`.`U_Type` when 0 then '超级用户' when 1 then '管理用户' when 2 then '企业用户' else '未定义' end) AS `U_TypeText`,(case `a`.`U_Status` when 0 then '正常' when 1 then '禁止' else '未定义' end) AS `U_StatusText`,`b`.`C_CName` AS `U_CompanyName` from (`sys_user` `a` join `sys_company` `b` on((`a`.`U_CompanyID` = `b`.`CompanyID`))) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `view_sys_role_app`
--

/*!50001 DROP VIEW IF EXISTS `view_sys_role_app`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`cms_user`@`%` SQL SECURITY DEFINER */
/*!50001 VIEW `view_sys_role_app` AS select `a`.`A_RoleID` AS `A_RoleID`,`a`.`A_AppID` AS `A_AppID`,`b`.`RoleID` AS `RoleID`,`b`.`R_Description` AS `R_Description`,`b`.`R_RoleName` AS `R_RoleName`,`c`.`AppID` AS `AppID`,`c`.`A_AppDesc` AS `A_AppDesc`,`c`.`A_AppName` AS `A_AppName`,`c`.`A_AppUrl` AS `A_AppUrl`,`c`.`A_IsSys` AS `A_IsSys`,`c`.`A_Version` AS `A_Version` from ((`sys_role_app` `a` join `sys_role` `b` on((`a`.`A_RoleID` = `b`.`RoleID`))) join `sys_app` `c` on((`a`.`A_AppID` = `c`.`AppID`))) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `view_sys_company`
--

/*!50001 DROP VIEW IF EXISTS `view_sys_company`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`cms_user`@`%` SQL SECURITY DEFINER */
/*!50001 VIEW `view_sys_company` AS select `c`.`CompanyID` AS `CompanyID`,`c`.`C_AreaId` AS `C_AreaId`,`c`.`C_ChildCount` AS `C_ChildCount`,`c`.`C_CName` AS `C_CName`,`c`.`C_Level` AS `C_Level`,`c`.`C_ParentID` AS `C_ParentID`,`c`.`C_ShowOrder` AS `C_ShowOrder`,`a`.`A_AreaName` AS `A_AreaName`,(select `sys_company`.`C_CName` from `sys_company` where (`sys_company`.`CompanyID` = `c`.`C_ParentID`)) AS `C_ParentName` from (`sys_company` `c` join `sys_area` `a` on((`c`.`C_AreaId` = `a`.`AreaId`))) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `view_sys_user_role_module`
--

/*!50001 DROP VIEW IF EXISTS `view_sys_user_role_module`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `view_sys_user_role_module` AS select `r`.`R_UserID` AS `R_UserID`,`r`.`R_RoleID` AS `R_RoleID`,`p`.`P_RoleID` AS `P_RoleID`,`p`.`P_ModuleID` AS `P_ModuleID`,`p`.`P_Value` AS `P_Value`,`m`.`ModuleID` AS `ModuleID`,`m`.`M_AppID` AS `M_AppID`,`m`.`M_CName` AS `M_CName`,`m`.`M_Code` AS `M_Code`,`m`.`M_Icon` AS `M_Icon`,`m`.`M_IsClose` AS `M_IsClose`,`m`.`M_IsSys` AS `M_IsSys`,`m`.`M_OrderLevel` AS `M_OrderLevel`,`m`.`M_ParentID` AS `M_ParentID`,`m`.`M_URL` AS `M_URL`,`m`.`A_AppName` AS `A_AppName`,`m`.`M_ParentName` AS `M_ParentName` from ((`sys_user_role` `r` join `sys_role_module` `p` on(((`r`.`R_RoleID` = `p`.`P_RoleID`) and (`p`.`P_Value` > 0)))) join `view_sys_module` `m` on((`m`.`ModuleID` = `p`.`P_ModuleID`))) order by `m`.`M_AppID`,`m`.`M_OrderLevel` */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `view_sys_module`
--

/*!50001 DROP VIEW IF EXISTS `view_sys_module`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`cms_user`@`%` SQL SECURITY DEFINER */
/*!50001 VIEW `view_sys_module` AS select `a`.`ModuleID` AS `ModuleID`,`a`.`M_AppID` AS `M_AppID`,`a`.`M_CName` AS `M_CName`,`a`.`M_Code` AS `M_Code`,`a`.`M_Icon` AS `M_Icon`,`a`.`M_IsClose` AS `M_IsClose`,`a`.`M_IsSys` AS `M_IsSys`,`a`.`M_OrderLevel` AS `M_OrderLevel`,`a`.`M_ParentID` AS `M_ParentID`,`a`.`M_URL` AS `M_URL`,`b`.`A_AppName` AS `A_AppName`,(select `x`.`M_CName` from `sys_module` `x` where (`x`.`ModuleID` = `a`.`M_ParentID`)) AS `M_ParentName` from (`sys_module` `a` join `sys_app` `b` on((`a`.`M_AppID` = `b`.`AppID`))) */;
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

-- Dump completed on 2020-09-24 17:52:40
