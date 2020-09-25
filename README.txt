
推荐使用Spring Tool Suite(STS)开发工具
目前支持MySql的自动建表和视图
## 操作步骤
1)MySql先新建一个数据库，名为：mydb，添加该数据库账号密码： cms_user和cms_pwd
2)首次运行初始化需要将sprig.datasource.initialization-mode设置为always，
	之后运行后请改为nerver,将会自动执行schema.sql和data.sql进行建表和数据初始化
3) 浏览器输入http://localhost:8080	账号密码分别为：admin	654321888

## 核心技术：
 - 核心框架：Spring Boot
 - 安全框架：Apache Shiro
 - 持久层框架：Mybatis + Mybatis plus
 - 模板引擎：freemarker(考虑换成thymeleaf）
 - 缓存框架：caffeine
 - 前端框架：bootstrap,DataTables