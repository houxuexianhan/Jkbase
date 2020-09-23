package com.jack.jkbase.generate;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.baomidou.mybatisplus.core.exceptions.MybatisPlusException;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.FileOutConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.TemplateConfig;
import com.baomidou.mybatisplus.generator.config.TemplateType;
import com.baomidou.mybatisplus.generator.config.converts.MySqlTypeConvert;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.DbColumnType;
import com.baomidou.mybatisplus.generator.config.rules.IColumnType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

//演示例子，执行 main 方法控制台输入模块表名回车自动生成对应项目目录中
public class CodeGenerator {

 /**
  * <p>
  * 读取控制台内容
  * </p>
  */
 public static String scanner(String tip) {
     Scanner scanner = new Scanner(System.in);
     StringBuilder help = new StringBuilder();
     help.append("请输入" + tip + "：");
     System.out.println(help.toString());
     if (scanner.hasNext()) {
         String ipt = scanner.next();
         if (StringUtils.isNotBlank(ipt)) {
             return ipt;
         }
     }
     throw new MybatisPlusException("请输入正确的" + tip + "！");
 }

 public static void main(String[] args) {
     // 代码生成器
     AutoGenerator mpg = new AutoGenerator();

     // 全局配置
     GlobalConfig gc = new GlobalConfig();
     String projectPath = "F://gen";//System.getProperty("user.dir");
     gc.setOutputDir(projectPath + "/src/main/java");
     gc.setFileOverride(false);
     gc.setAuthor("LIBO");
     gc.setOpen(true);
     //gc.setSwagger2(true); //实体属性 Swagger2 注解
     //gc.setActiveRecord(true);
     //gc.setBaseResultMap(true);
     mpg.setGlobalConfig(gc);

     // 数据源配置
     DataSourceConfig dsc = new DataSourceConfig();
     dsc.setUrl("jdbc:mysql://localhost:3306/mydb?allowPublicKeyRetrieval=true&serverTimezone=Asia/Shanghai&useUnicode=true&useSSL=false&characterEncoding=utf8");
     // dsc.setSchemaName("public");
     dsc.setDriverName("com.mysql.cj.jdbc.Driver");
     dsc.setUsername("cms_user");
     dsc.setPassword("cms_pwd");
     dsc.setTypeConvert(new MySqlTypeConvert() {
    	 @Override
    	public IColumnType processTypeConvert(GlobalConfig config, String fieldType) {
    		 if ( fieldType.toLowerCase().contains( "int" ) ) {
                 return DbColumnType.BASE_INT;
              }
    		return super.processTypeConvert(config, fieldType);
    	}
     });
     mpg.setDataSource(dsc);

     // 包配置
     PackageConfig pc = new PackageConfig();
     //pc.setModuleName(scanner("模块名"));
     pc.setParent("com.jack.jkbase");
     //pc.setEntity("model");
     //pc.setMapper("mapping");
     mpg.setPackageInfo(pc);

     // 自定义配置
     InjectionConfig cfg = new InjectionConfig() {
         @Override
         public void initMap() {
             // to do nothing
         }
     };

     // 如果模板引擎是 freemarker
     String templatePath = "/templates/mapper.xml.ftl";
     // 如果模板引擎是 velocity
     // String templatePath = "/templates/mapper.xml.vm";

     // 自定义输出配置
     List<FileOutConfig> focList = new ArrayList<>();
     // 自定义配置会被优先输出
     focList.add(new FileOutConfig(templatePath) {
         @Override
         public String outputFile(TableInfo tableInfo) {
             // 自定义输出文件名 ， 如果你 Entity 设置了前后缀、此处注意 xml 的名称会跟着发生变化！！
             return projectPath + "/src/main/resources/mappering/" + pc.getModuleName()
                     + "/" + tableInfo.getEntityName() + "Mapper" + StringPool.DOT_XML;
         }
     });
     /*
     cfg.setFileCreate(new IFileCreate() {
         @Override
         public boolean isCreate(ConfigBuilder configBuilder, FileType fileType, String filePath) {
             // 判断自定义文件夹是否需要创建
             checkDir("调用默认方法创建的目录，自定义目录用");
             if (fileType == FileType.MAPPER) {
                 // 已经生成 mapper 文件判断存在，不想重新生成返回 false
                 return !new File(filePath).exists();
             }
             // 允许生成模板文件
             return true;
         }
     });
     */
     cfg.setFileOutConfigList(focList);
     mpg.setCfg(cfg);

     // 配置模板
     TemplateConfig templateConfig = new TemplateConfig();
     templateConfig.disable(TemplateType.XML);
     templateConfig.disable(TemplateType.CONTROLLER);
     // 配置自定义输出模板
     //指定自定义模板路径，注意不要带上.ftl/.vm, 会根据使用的模板引擎自动识别
     // templateConfig.setEntity("templates/entity2.java");
     // templateConfig.setService();
     //templateConfig.setController(null);
     templateConfig.setXml(null);
     mpg.setTemplate(templateConfig);

     // 策略配置
     StrategyConfig strategy = new StrategyConfig();
     strategy.setNaming(NamingStrategy.underline_to_camel);
     strategy.setColumnNaming(NamingStrategy.underline_to_camel);
     //strategy.setSuperEntityClass("你自己的父类实体,没有就不用设置!");
     strategy.setEntityLombokModel(true);
     strategy.setRestControllerStyle(true);
     strategy.setEntityTableFieldAnnotationEnable(true);
     // 公共父类
     //strategy.setSuperControllerClass("你自己的父类控制器,没有就不用设置!");
     // 写于父类中的公共字段
     //strategy.setSuperEntityColumns("id");
     //strategy.setInclude("sys_function");
     //strategy.setInclude(scanner("表名，多个英文逗号分割").split(","));
     /*strategy.setInclude("sys_app","sys_area","sys_company","sys_event"
    		 ,"sys_field","sys_fieldValue","sys_function","sys_module","sys_online","sys_role"
    		 ,"sys_roleapp","sys_rolepermission","sys_user","sys_userroole");
     */
     strategy.setControllerMappingHyphenStyle(true);
     //strategy.setTablePrefix(pc.getModuleName() + "_");
     mpg.setStrategy(strategy);
     mpg.setTemplateEngine(new FreemarkerTemplateEngine());
     mpg.execute();
 }

}