CREATE  VIEW View_sys_Module 
AS 
SELECT a.*,
	(SELECT   x.M_CName FROM sys_Module x WHERE   (x.ModuleID = a.M_ParentID)) AS M_ParentName FROM      
	 sys_Module AS a INNER JOIN sys_App AS b  ON a.M_AppID = b.AppID;

CREATE VIEW  View_sys_Function
AS
SELECT   a.*,b.*,c.*
FROM      sys_Function AS a INNER JOIN
                sys_Module AS b ON a.F_ModuleId = b.ModuleID
inner join sys_App AS c ON b.M_AppID = c.AppID;

CREATE VIEW View_sys_Company
AS
SELECT   c.*,a.*,
                    (SELECT   C_CName
                     FROM      sys_Company
                     WHERE   (CompanyID = c.C_ParentID)) AS C_ParentName
FROM      sys_Company AS c INNER JOIN
                sys_Area AS a ON c.C_AreaId = a.AreaId;

CREATE VIEW View_sys_RoleApp
AS
SELECT   a.*,b.*,c.*
FROM      sys_RoleApp AS a INNER JOIN
                sys_Role AS b ON a.A_RoleID = b.RoleID INNER JOIN
                sys_App AS c ON a.A_AppID = c.AppID;

CREATE VIEW View_sys_RoleUser
AS
SELECT   a.*,b.*, 
                (CASE U_Type WHEN 0 THEN '超级用户' WHEN 1 THEN '管理用户' WHEN 2 THEN '企业用户' ELSE '未定义' END) 
                AS U_TypeText, (CASE U_Status WHEN 0 THEN '正常' WHEN 1 THEN '禁止' ELSE '未定义' END) AS U_StatusText,
                    (SELECT   C_CName
                     FROM      sys_Company
                     WHERE   (CompanyID = b.U_CompanyID)) AS U_CompanyName
FROM      sys_UserRole AS a INNER JOIN
                sys_User b ON a.R_UserID = b.UserId;

CREATE VIEW view_sys_User
AS
SELECT     a.*,b.*,c.*, (CASE U_Type WHEN 0 THEN '超级用户' WHEN 1 THEN '管理用户' WHEN 2 THEN '企业用户' ELSE '未定义' END) AS U_TypeText, 
                      (CASE U_Status WHEN 0 THEN '正常' WHEN 1 THEN '禁止' ELSE '未定义' END) AS U_StatusText,
                          b.C_CName AS U_CompanyName
FROM         sys_User a INNER JOIN
                      sys_Company AS b ON a.U_CompanyID = b.CompanyID INNER JOIN
                      sys_Area c ON b.C_AreaId = c.AreaId ;         
                
