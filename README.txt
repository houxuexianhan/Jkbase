推荐使用Spring Tool Suite(STS)开发工具
支持SqlServer和MySql的自动建表和视图
1) MySql先新建一个数据库，名为：MyDb，添加该数据库账号密码： cms_user和cms_pwd
2) 首次运行项目时请将ddl-auto设置成create，将自动生成表和视图，并导入初始化数据
	数据初始完后改为 spring.jpa.hibernate.ddl-auto=update
3) 浏览器输入http://localhost:8080	账号密码分别为：admin	admin123


