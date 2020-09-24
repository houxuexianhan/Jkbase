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
-- Dumping data for table `sys_app`
--

LOCK TABLES `sys_app` WRITE;
/*!40000 ALTER TABLE `sys_app` DISABLE KEYS */;
INSERT INTO `sys_app` VALUES (1,'设置集成的应用及其功能模块23ab','框架应用系统','',1,'4.0'),(2,'应用系统管理及其功能模块','应用系统管理','',0,'1.0'),(3,'用于检票口的广告系统','广告系统','',0,'1.0');
/*!40000 ALTER TABLE `sys_app` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `sys_area`
--

LOCK TABLES `sys_area` WRITE;
/*!40000 ALTER TABLE `sys_area` DISABLE KEYS */;
INSERT INTO `sys_area` VALUES (1,'BJ','北京市','110000',1,'直辖市',0,1,'华北地区'),(2,'TJ','天津市','120000',1,'直辖市',0,2,'华北地区'),(3,'HEB','河北省','130000',1,'省',0,3,'华北地区'),(4,'SX','山西省','140000',1,'省',0,4,'华北地区'),(5,'NMG','内蒙古自治区','150000',1,'自治区',0,5,'华北地区'),(6,'LN','辽宁省','210000',1,'省',0,6,'东北地区'),(7,'JL','吉林省','220000',1,'省',0,7,'东北地区'),(8,'HLJ','黑龙江省','230000',1,'省',0,8,'东北地区'),(9,'SH','上海市','310000',1,'直辖市',0,9,'华东地区'),(10,'JS','江苏省','320000',1,'省',0,10,'华东地区'),(11,'ZJ','浙江省','330000',1,'省',0,11,'华东地区'),(12,'AH','安徽省','340000',1,'省',0,12,'华东地区'),(13,'FJ','福建省','350000',1,'省',0,13,'华东地区'),(14,'JX','江西省','360000',1,'省',0,14,'华东地区'),(15,'SD','山东省','370000',1,'省',0,15,'华东地区'),(16,'HEN','河南省','410000',1,'省',0,16,'华中地区'),(17,'HUB','湖北省','420000',1,'省',0,17,'华中地区'),(18,'HUN','湖南省','430000',1,'省',0,18,'华中地区'),(19,'GD','广东省','440000',1,'省',0,19,'华南地区'),(20,'GX','广西壮族自治区','450000',1,'自治区',0,20,'华南地区'),(21,'HN','海南省','460000',1,'省',0,21,'华南地区'),(22,'CQ','重庆市','500000',1,'直辖市',0,22,'西南地区'),(23,'SC','四川省','510000',1,'省',0,23,'西南地区'),(24,'GZ','贵州省','520000',1,'省',0,24,'西南地区'),(25,'YN','云南省','530000',1,'省',0,25,'西南地区'),(26,'XZ','西藏自治区','540000',1,'自治区',0,26,'西南地区'),(27,'SXS','陕西省','610000',1,'省',0,27,'西北地区'),(28,'GS','甘肃省','620000',1,'省',0,28,'西北地区'),(29,'QH','青海省','630000',1,'省',0,29,'西北地区'),(30,'NX','宁夏回族自治区','640000',1,'自治区',0,30,'西北地区'),(31,'XJ','新疆维吾尔自治区','650000',1,'自治区',0,31,'西北地区'),(32,'TW','台湾省','710000',1,'省',0,32,'港澳台'),(33,'HK','香港特别行政区','810000',1,'行政区',0,33,'港澳台'),(34,'AM','澳门特别行政区','820000',1,'行政区',0,34,'港澳台'),(35,'HNHK','海口市','460100',2,'地级市',21,1,'华南地区'),(36,'HNSY','三亚市','460200',2,'地级市',21,2,'华南地区'),(37,'HNSA','三沙市','460300',2,'县级市',21,3,'华南地区'),(38,'HNWZS','五指山市','469001',2,'县级市',21,4,'华南地区'),(39,'HNQH','琼海市','469002',2,'县级市',21,5,'华南地区'),(40,'HNDZ','儋州市','469003',2,'县级市',21,6,'华南地区'),(41,'HNWC','文昌市','469005',2,'县级市',21,7,'华南地区'),(42,'HNWN','万宁市','469006',2,'县级市',21,8,'华南地区'),(43,'HNDF','东方市','469007',2,'县级市',21,9,'华南地区'),(44,'HNDA','定安县','469021',2,'县',21,10,'华南地区'),(45,'HNTC','屯昌县','469022',2,'县',21,11,'华南地区'),(46,'HNCM','澄迈县','469023',2,'县',21,12,'华南地区'),(47,'HNLG','临高县','469024',2,'县',21,13,'华南地区'),(48,'HNBS','白沙黎族自治县','469025',2,'自治县',21,14,'华南地区'),(49,'HNCJ','昌江黎族自治县','469026',2,'自治县',21,15,'华南地区'),(50,'HNLD','乐东黎族自治县','469027',2,'自治县',21,16,'华南地区'),(51,'HNLS','陵水黎族自治县','469028',2,'自治县',21,17,'华南地区'),(52,'HNBT','保亭黎族苗族自治县','469029',2,'自治县',21,18,'华南地区'),(53,'HNQZ','琼中黎族苗族自治县','469030',2,'自治县',21,19,'华南地区'),(58,'23','dyd2','233432',2,'直辖市',57,2323,'港澳台'),(59,'2342','dyd3','23424',2,'自治县',57,242423,'港澳台'),(60,'424','2342342','234242',3,'乡',58,42,'港澳台'),(62,'dyd1','dyd1','333333',2,'县',61,1,'港澳台'),(64,'dyd2','dyd2','3333334444',3,'区',62,2,'港澳台');
/*!40000 ALTER TABLE `sys_area` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `sys_company`
--

LOCK TABLES `sys_company` WRITE;
/*!40000 ALTER TABLE `sys_company` DISABLE KEYS */;
INSERT INTO `sys_company` VALUES (1,21,0,'信息中心',1,0,1),(3,35,0,'车站总部',1,0,1),(4,35,0,'海口汽车客运总站',2,3,2),(6,2,0,'车站2',2,5,32),(7,3,0,'琼海车站2',3,6,33),(8,2,0,'琼海汽车站',1,0,1);
/*!40000 ALTER TABLE `sys_company` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `sys_event`
--

LOCK TABLES `sys_event` WRITE;
/*!40000 ALTER TABLE `sys_event` DISABLE KEYS */;
/*!40000 ALTER TABLE `sys_event` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `sys_field`
--

LOCK TABLES `sys_field` WRITE;
/*!40000 ALTER TABLE `sys_field` DISABLE KEYS */;
INSERT INTO `sys_field` VALUES (1,'常用语','常用短语，便于用户输入，如：审核通过等。'),(2,'计量单位','常用计量单位，如个、件等。'),(3,'牌照颜色','车辆牌照颜色，蓝色、黄色、黑色、白色四种'),(4,'行政区域划分','中国可分为8个大区: 华北、东北、华东、华中、华南、西北、西南、港澳台'),(5,'行政区域级别','省、自治区、直辖市、行政区、地级市、县级市、县、自治县、乡、镇');
/*!40000 ALTER TABLE `sys_field` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `sys_fieldvalue`
--

LOCK TABLES `sys_fieldvalue` WRITE;
/*!40000 ALTER TABLE `sys_fieldvalue` DISABLE KEYS */;
INSERT INTO `sys_fieldvalue` VALUES (1,4,0,'华北地区'),(2,4,1,'东北地区'),(3,4,2,'华东地区'),(4,4,3,'华中地区'),(5,4,4,'华南地区'),(6,4,5,'西北地区'),(7,4,6,'西南地区'),(8,4,7,'港澳台'),(9,5,0,'直辖市'),(10,5,1,'省'),(11,5,2,'自治区'),(12,5,3,'地级市'),(13,5,4,'县级市'),(14,5,5,'县'),(15,5,6,'自治县'),(16,5,7,'乡'),(17,5,8,'镇'),(18,5,9,'区'),(19,3,0,'蓝色'),(20,3,1,'黄色'),(21,3,2,'黑色'),(22,3,3,'白色'),(23,2,0,'个'),(24,2,1,'件'),(25,2,2,'米'),(26,2,3,'升'),(27,1,0,'送货上门'),(28,1,1,'加急'),(29,1,2,'注意轻放'),(34,2,3,'只'),(35,1,1,'afd');
/*!40000 ALTER TABLE `sys_fieldvalue` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `sys_function`
--

LOCK TABLES `sys_function` WRITE;
/*!40000 ALTER TABLE `sys_function` DISABLE KEYS */;
INSERT INTO `sys_function` VALUES (1,'查看',1,2,'查看模块',1),(2,'查看',1,2,'查看应用',32),(3,'删除',0,2,'删除模块',8),(4,'删除',0,2,'删除应用',256),(5,'添加顶级模块',1,2,'添加顶级模块',16),(6,'添加',1,2,'添加子模块',2),(7,'添加',1,2,'添加应用',64),(8,'修改',1,2,'修改模块',4),(9,'修改',1,2,'修改应用',128),(10,'查看',1,48,'查看角色用户',1),(11,'移除',1,48,'移除角色用户',8),(12,'添加',1,48,'添加角色用户',2),(13,'修改',1,48,'修改角色用户',4),(14,'查看',1,10,'查看角色应用',1),(18,'添加',1,10,'添加角色应用',2),(19,'修改',1,10,'修改角色应用',4),(20,'删除',1,10,'删除角色应用',8),(22,'权限',1,10,'设置应用权限',16),(23,'审核不通过',1,23,'审核不通过',1),(24,'查看',1,11,'查看用户',1),(25,'添加',1,11,'添加用户',2),(26,'编辑',1,11,'修改用户',4),(28,'删除',0,11,'删除用户',8),(29,'查看',1,48,'查看角色',16),(30,'添加',1,48,'添加角色',32),(31,'修改',1,48,'修改角色',64),(32,'删除',1,48,'删除角色',128),(33,'查看',1,61,'查看功能',1),(34,'添加',1,61,'添加功能',2),(35,'修改',1,61,'修改功能',4),(36,'删除',0,61,'删除功能',8),(40,'查看',1,6,'查看日志',1),(41,'删除',1,6,'删除日志',8),(42,'查看',1,4,'查看字段',1),(43,'添加',1,4,'添加字段',2),(44,'修改',1,4,'修改字段',4),(45,'删除',0,4,'删除字段',8),(46,'查看',1,12,'查看数据字段',1),(47,'添加',1,12,'添加数据字段',2),(48,'修改',1,12,'修改数据字段',4),(49,'删除',1,12,'删除数据字段',8),(50,'查看',1,8,'查看行政区',1),(51,'添加',1,8,'添加子级行政区',2),(52,'修改',1,8,'修改行政区',4),(53,'删除',0,8,'删除行政区',8),(54,'添加顶级行政区（省）',1,8,'添加顶级行政区',16),(55,'查看',1,9,'查看单位部门',1),(56,'添加',1,9,'添加子部门',2),(57,'修改',1,9,'修改单位部门',4),(58,'删除',1,9,'删除单位部门',8),(59,'添加顶级单位部门',1,9,'添加顶级单位部门',16),(60,'重置密码',1,11,'重置密码',16),(61,'移除本角色下所有用户',1,48,'移除所有用户',256),(62,'查看',1,26,'查看',1),(63,'保存',1,14,'保存',1),(65,'导出Excel',1,8,'导出Excel',32),(66,'导出Excel',1,9,'导出Excel',32),(67,'全部导出Excel',1,24,'全部导出Excel',1),(68,'查看',1,25,'查看',1),(69,'查看',1,42,'查看',1),(70,'查看',1,27,'查看',1),(71,'查看',1,39,'查看',1),(72,'导出Excel',1,40,'导出Excel',2),(73,'导出Excel',1,29,'导出Excel',1),(74,'导出Excel',1,30,'导出Excel',1),(75,'导出Excel',1,62,'导出Excel',1),(76,'查看',1,32,'查看',1),(77,'查看',1,33,'查看',1),(78,'查看',1,63,'查看',1),(79,'查看',1,14,'查看',2),(80,'导出Excel',1,37,'导出Excel',1),(81,'是否可选网络视频',1,70,'是否可选网络视频',128),(82,'添加用户车站',1,65,'添加用户车站',1),(83,'上传视频',1,66,'上传视频',1),(84,'发布文本通知',1,68,'发布文本通知',1),(85,'发布图片通知',1,69,'发布图片通知',1),(88,'会员资料审核（绑定车辆所属单位）',1,35,'审核',2),(89,'所选的资料审核不通过',1,35,'审核不通过',4),(90,'重置密码',1,37,'重置密码',2),(91,'打回，重新审核',1,35,'打回',8),(92,'审核通过',1,23,'审核通过',2),(93,'打回',1,23,'打回',4),(94,'播放视频',1,66,'播放',2),(95,'删除视频',1,66,'删除',4),(96,'按查询结果导出Excel',1,24,'按查询结果导出Excel',2),(97,'发布检票班次通知',1,72,'发布检票班次通知',1),(99,'查看',1,13,'查看',1),(100,'会员资料审核（绑定车辆所属单位）',1,35,'注销',1),(101,'发布视频通知',1,70,'发布视频通知',1),(102,'清空列表',1,71,'清空列表',1),(103,'导出Excel',1,32,'导出Excel',2),(104,'导出Excel',1,33,'导出Excel',2),(105,'导出Excel',1,63,'导出Excel',2),(106,'是否可选本地视频',1,70,'是否可选本地视频',256),(107,'清空播放列表',1,68,'清空播放列表',2),(108,'发送欢迎标语',1,74,'发送欢迎标语',1),(109,'发送升级命令',1,75,'发送升级命令',1),(110,'发送高级命令',1,76,'发送高级命令',1),(111,'批量设置为滚动线路',1,77,'批量设置为滚动线路',1),(112,'撤销滚动',1,26,'撤销滚动',2),(117,'查看',1,79,'查看',1),(118,'导出Excel',1,79,'导出Excel',2),(119,'查看',1,80,'查看',1),(120,'导出Excel',1,80,'导出Excel',2),(123,'查询',1,82,'fasfsa',1),(124,'导出Excel',1,82,'导出Excel',2),(125,'导出Excel',1,83,'导出Excel',2),(126,'查看',1,83,'查看',1),(127,'删除全部视频',1,66,'全部删除',32),(128,'查看',1,84,'查看',1),(129,'导出Excel',1,84,'导出Excel',4),(130,'导出Excel',1,38,'导出Excel',4),(131,'重置密码',1,38,'重置密码',32),(132,'添加子单位',1,37,'添加子单位',8),(133,'添加顶级区域线',1,85,'添加顶级区域线',4),(134,'添加子线',1,85,'添加子线',16),(135,'编辑',1,85,'编辑区域线',32),(136,'删除',1,85,'删除区域线',64),(137,'查看',1,85,'查看',1),(138,'添加滚动线路',1,85,'添加滚动线路',128),(139,'查看',1,86,'查看',1),(140,'添加区域线的滚动线路',1,86,'添加区域线的滚动线路',2),(141,'解除绑定',1,86,'解除绑定',8),(142,'导出Excel',1,39,'导出Excel',2),(143,'查看',1,87,'查看',1),(144,'导出Excel',1,87,'导出Excel',2),(145,'导出Excel',1,89,'导出Excel',8),(146,'导出Excel',1,89,'线路详情导出Excel',16),(147,'导出Excel',1,89,'线路结算单详情导出Excel',32),(148,'查看',1,88,'查看',1),(149,'更改',1,88,'更改结算单',2),(150,'导出Excel',1,74,'统计线详情导出Excel',4),(152,'查看',1,90,'查看',1),(153,'批量通过核对',1,90,'批量通过核对',16),(154,'批量撤销核对',1,90,'批量撤销核对',32),(157,'清空播放列表',1,69,'清空播放列表',2),(158,'清空播放列表',1,70,'清空播放列表',2),(159,'删除该用户的车站',1,65,'删除',2),(160,'编辑用户车站',1,65,'编辑',8),(161,'刷新列表',1,71,'刷新列表',2),(162,'清除',1,71,'清除',4),(166,'zvzxv',1,82,'aaaabbb',16),(167,'zvxvzvz',1,82,'xxx22',32),(168,'vzv',1,82,'ccccxxx',64);
/*!40000 ALTER TABLE `sys_function` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `sys_module`
--

LOCK TABLES `sys_module` WRITE;
/*!40000 ALTER TABLE `sys_module` DISABLE KEYS */;
INSERT INTO `sys_module` VALUES (1,1,'框架系统','frm','fa fa-square-o',0,1,'0000',0,''),(2,1,'应用与模块管理','ModuleMng','fa fa-square',0,1,'0001',1,'frm/ModuleMng/module.page'),(4,1,'字段类型管理','FieldMng','fa fa-tag',0,1,'0004',1,'frm/FieldMng/module.page'),(5,1,'系统异常日志','SystemErrorLog','fa fa-file',1,1,'0005',1,'frm/SystemErrorLog/module.page'),(7,2,'系统管理','sys','fa fa-asterisk',0,0,'0000',0,''),(8,2,'行政区管理','AreaMng','fa fa-map-o',0,0,'0002',7,'sys/AreaMng/module.page'),(9,2,'组织机构管理','CompanyMng','fa fa-tree',0,0,'0003',7,'sys/CompanyMng/module.page'),(10,2,'角色应用权限','RoleMng','fa fa-key',0,0,'0006',7,'sys/RoleMng/module.page'),(11,2,'用户管理','UserMng','fa fa-user',0,0,'0004',7,'sys/UserMng/module.page'),(12,2,'数据字典','FieldValueMng','fa fa-book',0,0,'0001',7,'sys/FieldValueMng/module.page'),(13,2,'事件日志查询','EventMng','fa fa-sticky-note-o',0,0,'0007',7,'sys/EventMng/module.page'),(14,2,'系统参数管理','SystemParam','fa fa-cogs',0,0,'0008',7,'sys/SystemParam/module.page'),(16,2,'在线用户列表','OnlineUser','fa fa-street-view',1,0,'0010',7,'sys/OnlineUser/module.page'),(48,2,'角色(用户)管理','RoleUserMng','fa fa-user-secret',0,0,'0005',7,'sys/RoleUserMng/module.page'),(61,1,'功能管理','FunctionMng','fa fa-envira',0,1,'0002',1,'frm/FunctionMng/module.page'),(64,3,'广告管理','advMng','fa fa-bell',0,0,'2001',0,''),(66,3,'视频管理','VideoMng','fa fa-video-camera',0,0,'2003',64,'Advertising/VideoMng/module.page'),(67,3,'广告发布','','fa fa-television',0,0,'2101',0,''),(68,3,'发布文本通知','TextPublish','fa fa-file-text-o',0,0,'2102',67,'Advertising/TextPublish/module.page'),(69,3,'发布图片通知','ImagePublish','fa fa-picture-o',0,0,'2103',67,'Advertising/ImagePublish/module.page'),(70,3,'发布视频通知','VideoPublish','fa fa-video-camera',0,0,'2104',67,'Advertising/VideoPublish/module.page'),(71,3,'清除通知','Clear','fa fa-eraser',0,0,'2105',67,'Advertising/Clear/module.page'),(72,3,'发布检票班次','CheckPublish','fa fa-bus',0,0,'2106',67,'Advertising/CheckPublish/module.page');
/*!40000 ALTER TABLE `sys_module` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `sys_online`
--

LOCK TABLES `sys_online` WRITE;
/*!40000 ALTER TABLE `sys_online` DISABLE KEYS */;
/*!40000 ALTER TABLE `sys_online` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `sys_role`
--

LOCK TABLES `sys_role` WRITE;
/*!40000 ALTER TABLE `sys_role` DISABLE KEYS */;
INSERT INTO `sys_role` VALUES (1,'框架管理，超级管理员权限','框架管理组'),(2,'系统管理','系统管理组'),(3,'只能发布广告，（不能上传视频）','广告发布组'),(4,'bbb','ccc'),(7,'dddxxx','ddd');
/*!40000 ALTER TABLE `sys_role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `sys_role_app`
--

LOCK TABLES `sys_role_app` WRITE;
/*!40000 ALTER TABLE `sys_role_app` DISABLE KEYS */;
INSERT INTO `sys_role_app` VALUES (1,1),(2,2),(2,3),(3,3);
/*!40000 ALTER TABLE `sys_role_app` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `sys_role_module`
--

LOCK TABLES `sys_role_module` WRITE;
/*!40000 ALTER TABLE `sys_role_module` DISABLE KEYS */;
INSERT INTO `sys_role_module` VALUES (2,66,0),(2,68,3),(2,69,0),(2,70,0),(2,71,0),(2,72,1),(3,66,38),(3,68,0),(3,69,0),(3,70,0),(3,71,0),(3,72,0);
/*!40000 ALTER TABLE `sys_role_module` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `sys_user`
--

LOCK TABLES `sys_user` WRITE;
/*!40000 ALTER TABLE `sys_user` DISABLE KEYS */;
INSERT INTO `sys_user` VALUES (1,'超级管理员',1,0,0,'0,10,blue','2015-06-10 10:26:15.000000','10.10.10.89','2016-06-15 11:07:19','admin','182xxxxxxxxx','/resources/upload/user/image/15209958046719763_.jpg','b4f92a719c98cd13a50a117092f04250809a303ce0d63d5861b37e59d02d4b90','9e77501e-725f-4d69-812e-56b0c2186f11',0,0),(2,'aa',1,0,0,'','2020-09-23 10:20:55.186000',NULL,NULL,'aa','',NULL,'2287871b650ccd0ff233ca02aca8d419caba207882de2029cf008950795a7378','f3366bc8-a353-4ef3-a0db-13848c1966ff',0,2),(3,'cc',4,0,0,'',NULL,NULL,NULL,'cc','',NULL,'2eeca72ac63014743a75d71c930d27c533902b0c39f8035cbe9d1986043c528c',NULL,0,2);
/*!40000 ALTER TABLE `sys_user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `sys_user_role`
--

LOCK TABLES `sys_user_role` WRITE;
/*!40000 ALTER TABLE `sys_user_role` DISABLE KEYS */;
INSERT INTO `sys_user_role` VALUES (2,4);
/*!40000 ALTER TABLE `sys_user_role` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-09-24 22:42:46
