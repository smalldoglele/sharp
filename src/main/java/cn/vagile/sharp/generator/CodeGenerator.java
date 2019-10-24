package cn.vagile.sharp.generator;

import com.baomidou.mybatisplus.core.exceptions.MybatisPlusException;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

import java.util.Scanner;

public class CodeGenerator {
    public static void main(String[] args) {
        //代码生成器
        AutoGenerator generator = new AutoGenerator();

        //全局配置
        GlobalConfig globalConfig = new GlobalConfig();
        String projectPath = System.getProperty("user.dir");
        globalConfig.setOutputDir(projectPath+"/src/main/java");
        globalConfig.setAuthor("walden");
        globalConfig.setOpen(false);
        //globalConfig.setSwagger2(true); //实体属性 Swagger2注解
        generator.setGlobalConfig(globalConfig);


        //数据源配置
        DataSourceConfig dataSourceConfig = new DataSourceConfig();
        dataSourceConfig.setUrl("jdbc:mysql://localhost:3306/sharp_dev?useUnicode=true&useSSL=false&characterEncoding=utf8");
        //dataSourceConfig.setSchemaName("public");
        dataSourceConfig.setDriverName("com.mysql.cj.jdbc.Driver");
        dataSourceConfig.setUsername("root");
        dataSourceConfig.setPassword("1");
        generator.setDataSource(dataSourceConfig);

        //包配置
        PackageConfig packageConfig = new PackageConfig();
        //packageConfig.setModuleName(scanner("模块名"));
        packageConfig.setParent("cn.vagile.sharp");
        packageConfig.setEntity("bean.entity");

        generator.setPackageInfo(packageConfig);
        //配置面板
        TemplateConfig templateConfig = new TemplateConfig();
        generator.setTemplate(templateConfig);

        //策略配置
        StrategyConfig strategyConfig = new StrategyConfig();
        strategyConfig.setNaming(NamingStrategy.underline_to_camel);
        strategyConfig.setColumnNaming(NamingStrategy.underline_to_camel);
        strategyConfig.setEntityLombokModel(true);
        strategyConfig.setEntityBuilderModel(false);
        strategyConfig.setRestControllerStyle(true);
        //公共父类 start
        strategyConfig.setSuperEntityClass("cn.vagile.sharp.bean.object.BaseEntity");
        strategyConfig.setSuperEntityColumns("id","create_time","update_time","create_by","update_by","deleted");
        //公共父类 end
        strategyConfig.setInclude(scanner("表名,多个英文逗号分割").split(","));
        strategyConfig.setControllerMappingHyphenStyle(true);
        //strategyConfig.setTablePrefix(packageConfig.getModuleName()+"_");
        strategyConfig.setTablePrefix(scanner("表前缀"));
        generator.setStrategy(strategyConfig);
        //执行
        generator.execute();

    }

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
            if (StringUtils.isNotEmpty(ipt)) {
                return ipt;
            }
        }
        throw new MybatisPlusException("请输入正确的" + tip + "！");
    }

}
