package com.honey;

import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

import java.util.ArrayList;
import java.util.List;

/**
 * Mybatis-Plus代码生成器
 * 临时版本，后期优化
 */
public class Generator {

    public static void main(String[] args) {
        String[] tables = {"order_info"};
        //仅生成部分表的entity代码，适用于表的部分字段被修改，需要手动去修改xml中的resultMap
//        createECodeByTables(tables);
        //生成部分表的dao、entity和xml代码，适用于新增表
        createDEXCodeByTables(tables);
        //生成全量dao、entity和xml，谨慎使用，会覆盖已编辑的dao和xml
//        createDEXCode();
    }

    /** 获取项目路径 */
    private static final String PROJECT_PATH = System.getProperty("user.dir");
    /** 工程路径 */
    private static final String MODULE_PATH = "/coding-domain";
    /** 输出路径 */
    private static final String OUT_PUT_DIR = PROJECT_PATH + MODULE_PATH + "/src/main/java";
    //spring.datasource.url=jdbc:mysql://mysql.feiersmart.local:3306/vbox_product?relaxAutoCommit=true&zeroDateTimeBehavior=convertToNull&characterEncoding=utf-8&autoReconnect=true&failOverReadOnly=false&allowMultiQueries=true&rewriteBatchedStatements=true
    //spring.datasource.username=product
    //spring.datasource.password=GFLmbm1KeUKLiWhk
    /** 数据库连接地址 */
    private static final String DATA_SOURCE_URL = "jdbc:mysql://mysql.feiersmart.local:3306/vbox_product?useUnicode=true&characterEncoding=utf-8&allowMultiQueries=true";
    /** 数据库用户名 */
    private static final String DATA_SOURCE_USER_NAME = "product";
    /** 数据库密码 */
    private static final String DATA_SOURCE_PWD = "GFLmbm1KeUKLiWhk";
    /** 主包目录 */
    private static final String PACKAGE_PARENT = "com.darling.domain.emall";
    /** bean包目录 */
    private static final String PACKAGE_ENTITY = "dao.entity";
    /** dao包目录 */
    private static final String PACKAGE_MAPPER = "dao.mapper";
    /** 自定义Mapper的XML文件路径 */
    private static final String PACKAGE_CUSTMER_MAPPER_XML = PROJECT_PATH + MODULE_PATH + "/src/main/resources/mapper/emall/";

    /**
     * 仅生成部分表的entity代码
     * 适用于表的部分字段被修改
     * 需要手动去修改xml中的resultMap
     * @param tables 表名称集
     */
    private static void createECodeByTables(String[] tables){
        AutoGenerator mpg = generateCode();
        TemplateConfig tc = initTemplateConfig(false);
        StrategyConfig sc = initStrategyConfig(tables);
        mpg.setTemplate(tc);
        mpg.setStrategy(sc);

        mpg.execute();
    }

    /**
     * 生成部分表的dao、entity和xml代码
     * 适用于新增表
     * @param tables 表名称集
     */
    private static void createDEXCodeByTables(String[] tables){
        //公共设置
        AutoGenerator mpg = generateCode();
        InjectionConfig ic = initInjectionConfig();
        TemplateConfig tc = initTemplateConfig(true);
        StrategyConfig sc = initStrategyConfig(tables);

        mpg.setCfg(ic);
        mpg.setTemplate(tc);
        mpg.setStrategy(sc);

        mpg.execute();
    }

    /**
     * 生成全量表的dao、entity和xml代码
     * 谨慎使用，会覆盖已编辑的dao和xml
     */
    private static void createDEXCode(){
        //公共设置
        AutoGenerator mpg = generateCode();
        //参数设置
        InjectionConfig ic = initInjectionConfig();
        TemplateConfig tc = initTemplateConfig(true);
        StrategyConfig sc = initStrategyConfig(null);
        //自定义配置
        mpg.setCfg(ic);
        // 配置模板
        mpg.setTemplate(tc);
        //配置策略
        mpg.setStrategy(sc);

        //执行生成操作
        mpg.execute();
    }

    private static AutoGenerator generateCode(){
        AutoGenerator mpg = new AutoGenerator();
        //初始化
        GlobalConfig gc = initGlobalConfig();
        // 全局配置
        mpg.setGlobalConfig(gc);
        DataSourceConfig dc = initDataSourceConfig();
        PackageConfig pc = initPackageConfig();

        //参数设置
        // 数据源配置
        mpg.setDataSource(dc);
        // 包配置
        mpg.setPackageInfo(pc);
        //设置自定义模板
//        mpg.setTemplateEngine(new FreemarkerTemplateEngine());

        return mpg;
    }

    /**
     * 全局配置
     * 设置作者、输出目录自定义类名等等
     * @return
     */
    private static GlobalConfig initGlobalConfig(){
        GlobalConfig gc = new GlobalConfig();

        gc.setOutputDir(OUT_PUT_DIR);
        gc.setAuthor("zlzhou");
        gc.setOpen(false); //是否打开目录
        gc.setBaseResultMap(true);
        gc.setBaseColumnList(true);
        gc.setFileOverride(true); //覆盖已有文件，默认false
        gc.setActiveRecord(true); //启用ActiveRecord特性
        // 自定义类名称
        gc.setMapperName("%sMapper");
        gc.setXmlName("%sMapper");
        gc.setEntityName("%sDO");
        return gc;
    }

    /**
     * 数据源配置
     * 通过该配置，指定需要生成代码的具体数据库
     * @return
     */
    private static DataSourceConfig initDataSourceConfig(){
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setUrl(DATA_SOURCE_URL);
        dsc.setDriverName("com.mysql.jdbc.Driver");
        dsc.setUsername(DATA_SOURCE_USER_NAME);
        dsc.setPassword(DATA_SOURCE_PWD);
        return dsc;
    }

    /**
     * 包路径配置
     * @return
     */
    private static PackageConfig initPackageConfig(){
        PackageConfig pc = new PackageConfig();
        pc.setParent(PACKAGE_PARENT)
                .setEntity(PACKAGE_ENTITY)
                .setMapper(PACKAGE_MAPPER);
        return pc;
    }

    /**
     * 注入配置
     * 映射的xml文件放在resource目录下
     * @return
     */
    private static InjectionConfig initInjectionConfig(){
        InjectionConfig cfg = new InjectionConfig() {
            @Override
            public void initMap() {
            }
        };
        //自定义输出配置
        List<FileOutConfig> focList = new ArrayList<>();
        //自定义配置会优先输出
        focList.add(new FileOutConfig("/templates/mapper.xml.vm") {
            @Override
            public String outputFile(TableInfo tableInfo) {
                // 自定义输出文件名 ， 如果你 Entity 设置了前后缀、此处注意 xml 的名称会跟着发生变化！！
                return PACKAGE_CUSTMER_MAPPER_XML
                        + tableInfo.getMapperName() + StringPool.DOT_XML;
            }
        });
        cfg.setFileOutConfigList(focList);
        return cfg;
    }

    /**
     * 模板配置
     * 自定义代码生成的模板，实现个性化操作
     * 过滤Controller、Service和Service实现层生成
     * @return
     */
    private static TemplateConfig initTemplateConfig(boolean isMapper){
        TemplateConfig tc = new TemplateConfig();
        // 配置自定义输出模板
        //指定自定义模板路径，注意不要带上.ftl/.vm, 会根据使用的模板引擎自动识别
        // tc.setEntity("templates/entity2.java");
        if(!isMapper) { //不需要生成mapper
            tc.setMapper(null);
        }
        tc.setService(null); //不生成service接口层
        tc.setServiceImpl(null); //不生成service实现层
        tc.setController(null); //不生成controller层
        tc.setXml(null); //不生成Mapper.xml文件，使用自定义生成
        return tc;
    }

    /**
     * 策略配置
     * 通过该配置，可指定需要生成哪些表或者排除哪些表
     * @return
     */
    private static StrategyConfig initStrategyConfig(String[] tables){
        StrategyConfig strategy = new StrategyConfig();
        strategy.setNaming(NamingStrategy.underline_to_camel);
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);
        strategy.setEntityLombokModel(true);//默认是false
        strategy.setRestControllerStyle(true);
        strategy.setControllerMappingHyphenStyle(true);
        if(tables != null && tables.length > 0){
            strategy.setInclude(tables); // 需要生成的表
        }
        //strategy.setTablePrefix("sys_"); //表前缀配置
        //strategy.setExclude(new String[]{"test"}); // 排除生成的表
        // 自定义实体父类
        // strategy.setSuperEntityClass("com.baomidou.demo.TestEntity");
        // 自定义实体，公共字段
        // strategy.setSuperEntityColumns(new String[] { "test_id", "age" });
        // 自定义 mapper 父类
        // strategy.setSuperMapperClass("com.baomidou.demo.TestMapper");
        // 自定义 service 父类
        // strategy.setSuperServiceClass("com.baomidou.demo.TestService");
        // 自定义 service 实现类父类
        // strategy.setSuperServiceImplClass("com.baomidou.demo.TestServiceImpl");
        // 自定义 controller 父类
        // strategy.setSuperControllerClass("com.baomidou.demo.TestController");
        // 【实体】是否生成字段常量（默认 false）
        // public static final String ID = "test_id";
        // strategy.setEntityColumnConstant(true);
        // 【实体】是否为构建者模型（默认 false）
        // public User setName(String name) {this.name = name; return this;}
        // strategy.setEntityBuilderModel(true);
        return strategy;
    }

}
