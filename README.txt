支持SqlServer和MySql的自动建表和视图
1) SQLServer先新建一个数据库，名为：MyDb，添加数据库账号密码： cms_user	cms_pwd
2) 运行一次项目后，将自动生成表（根据JPA)，再次运行项目后可生成的视图以及初始化数据
3) 浏览器输入http://localhost:8080	账号密码分别为：admin	admin123
数据初始完后改为
spring.datasource.initialization-mode=never
spring.jpa.hibernate.ddl-auto=none

若要改成MySql，只需要更改连接参数driver和url