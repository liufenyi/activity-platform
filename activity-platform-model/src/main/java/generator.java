

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.core.exceptions.MybatisPlusException;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.po.TableFill;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.sun.javafx.PlatformUtil;
import lombok.SneakyThrows;

import java.sql.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

/**
 * @Description:
 * @Author: huang cong
 * @Date: 2021/3/11 17:58
 */


public class generator {

    @SneakyThrows
    private static String getTableName() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(JDBC_MYSQL_URL, JDBC_USERNAME, JDBC_PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        // StringBuilder sb = new StringBuilder();
        List<String> list = new ArrayList<>();
        DatabaseMetaData metaData = conn.getMetaData();
        ResultSet rs = metaData.getTables("activity_platform", null, null, new String[]{"TABLE"});
        while (rs.next()) {
            list.add(rs.getString(3));
        }
        String join = org.apache.commons.lang3.StringUtils.join(list, ",");
        return join;

    }


    /**
     * 代码生成位置
     */
    public static final String PARENT_NAME = "com.caisl.ap.common.generator";
    /**
     * modular 名字
     */
    public static final String MODULAR_NAME = "activity-platform-model";

    /**
     * 基本路径
     */
    public static final String SRC_MAIN_JAVA = "/src/main/java/";

    /**
     * 作者
     */
    public static final String AUTHOR = "huang cong";

    /**
     * 是否是 rest 接口
     */
    private static final boolean REST_CONTROLLER_STYLE = true;

    public static final String JDBC_MYSQL_URL = "jdbc:mysql://121.5.56.15:3306/activity_platform?useUnicode=true&characterEncoding=utf8&zeroDateTimeBehavior=convertToNull&useSSL=true&serverTimezone=GMT%2B8";

    public static final String JDBC_DRIVER_NAME = "com.mysql.cj.jdbc.Driver";

    public static final String JDBC_USERNAME = "root";

    public static final String JDBC_PASSWORD = "83867191";

    public static void main(String[] args) {
        //String moduleName = scanner("a");
        String moduleName = MODULAR_NAME;
        // String tableName = scanner("表名");
        String tableName = getTableName();
        //t_accompany_direction,t_cultivate_direction,t_prop,t_prop_cultivate_relation,t_recommended,t_recommended_accompany_relation,t_recommended_cultivate_relation,t_recommended_gamemode_relation,t_recommended_statistics,t_user_event_record
        // String tablePrefix = scanner("表前缀(不含'_'，无前缀输入#)").replaceAll("#", "");
        String tablePrefix = "t";
        autoGenerator(moduleName, tableName, tablePrefix);
    }

    public static void autoGenerator(String moduleName, String tableName, String tablePrefix) {
        new AutoGenerator()
                .setGlobalConfig(getGlobalConfig())
                .setDataSource(getDataSourceConfig())
                .setPackageInfo(getPackageConfig(moduleName))
                .setStrategy(getStrategyConfig(tableName.split(","), tablePrefix))
                .setCfg(getInjectionConfig(moduleName))
                .setTemplate(getTemplateConfig())
                .execute();
    }

    private static String getDateTime() {
        LocalDateTime localDate = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        return localDate.format(formatter);
    }

    private static InjectionConfig getInjectionConfig(final String moduleName) {
        return new InjectionConfig() {
            @Override
            public void initMap() {
                Map map = new HashMap();
                map.put("dateTime", getDateTime());
                setMap(map);
                final String projectPath = System.getProperty("user.dir");
                List<FileOutConfig> fileOutConfigList = new ArrayList<FileOutConfig>();
                // 自定义配置会被优先输出
                fileOutConfigList.add(new FileOutConfig("/templates/mapper.xml.vm") {
                    @Override
                    public String outputFile(TableInfo tableInfo) {
                        // 自定义输出文件名，如果entity设置了前后缀，此次注意xml的名称也会跟着发生变化
                        return projectPath + moduleName + "/src/main/resources/mapper" + "/" + tableInfo.getEntityName() + "Mapper" + StringPool.DOT_XML;
                    }
                });
                setFileOutConfigList(fileOutConfigList);
            }
        };
    }


    private static StrategyConfig getStrategyConfig(String[] tableName, String tablePrefix) {

        //自动填充
        List<TableFill> tableFills = new ArrayList<>();
        TableFill updateTime = new TableFill("update_time", FieldFill.INSERT_UPDATE);
        TableFill createTime = new TableFill("create_time", FieldFill.INSERT);
        tableFills.add(updateTime);
        tableFills.add(createTime);


        return new StrategyConfig()
                .setNaming(NamingStrategy.underline_to_camel)
                .setColumnNaming(NamingStrategy.underline_to_camel)
                .setInclude(tableName)
                .setRestControllerStyle(REST_CONTROLLER_STYLE)
                //【实体】是否为链式模型（默认 false），3.3.2以下版本默认生成了链式模型
                // .setEntityBuilderModel(true)
                //驼峰转连字符
                .setControllerMappingHyphenStyle(true)
                // 【实体】是否为lombok模型，3.3.2以下版本默认生成了链式模型，3.3.2以后，默认不生成，如有需要，请开启 chainModel
                .setEntityLombokModel(true)
                //生成 @RestController 控制器
                //Boolean类型字段是否移除is前缀（默认 false）
                .setEntityBooleanColumnRemoveIsPrefix(true)
                //生成 @RestController 控制器
                .setRestControllerStyle(true)
                //是否生成实体时，生成字段注解
                .entityTableFieldAnnotationEnable(true)
                //逻辑删除字段
                .setLogicDeleteFieldName("delete_flag")
                //自动填充
                .setTableFillList(tableFills)
                //乐观锁属性名称
                .setVersionFieldName("version")
                //跳过视图
                .setSkipView(true)
                .setTablePrefix(tablePrefix + "_");
    }

    private static PackageConfig getPackageConfig(String moduleName) {
        return new PackageConfig()
                .setParent(PARENT_NAME)
                .setService("service")
                .setServiceImpl("service.impl")
                .setController("controller")
                .setEntity("po");
    }

    private static DataSourceConfig getDataSourceConfig() {
        return new DataSourceConfig()
                .setUrl(JDBC_MYSQL_URL)
                .setDriverName(JDBC_DRIVER_NAME)
                .setUsername(JDBC_USERNAME)
                .setPassword(JDBC_PASSWORD)
                .setDbType(DbType.MYSQL);

    }

    private static GlobalConfig getGlobalConfig() {
        String projectPath = System.getProperty("user.dir");
        String filePath = projectPath + "/" + MODULAR_NAME + SRC_MAIN_JAVA;
        if (PlatformUtil.isWindows()) {
            filePath = filePath.replaceAll("/+|\\\\+", "\\\\");
        } else {
            filePath = filePath.replaceAll("/+|\\\\+", "/");
        }
        return new GlobalConfig()
                .setOutputDir(filePath)
                .setDateType(DateType.ONLY_DATE)
                .setIdType(IdType.ASSIGN_ID)
                .setAuthor(AUTHOR)
                .setEntityName("%sPO")
                .setMapperName("%sDao")
                .setXmlName("%sMapper")
                .setBaseColumnList(true)
                // .setSwagger2(true)
                .setEnableCache(false)
                .setBaseResultMap(true)
                //是否覆盖已有文件
                .setFileOverride(true)
                .setOpen(false);
    }

    private static TemplateConfig getTemplateConfig() {
        return new TemplateConfig()
                .setController(null)
                .setService(null)
                .setServiceImpl(null)
                .setEntity("/templates-generator/entity.java.vm")
                .setMapper("/templates-generator/mapper.java.vm")
                .setXml(null)
                ;
    }

    private static String scanner(String tip) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        sb.append("please input " + tip + " : ");
        System.out.println(sb.toString());
        if (scanner.hasNext()) {
            String ipt = scanner.next();
            if (StringUtils.isNotBlank(ipt)) {
                return ipt;
            }
        }
        throw new MybatisPlusException("please input the correct " + tip + ". ");
    }
}


