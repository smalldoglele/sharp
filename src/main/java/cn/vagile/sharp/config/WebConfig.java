package cn.vagile.sharp.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.format.datetime.DateFormatter;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.thymeleaf.spring5.view.ThymeleafViewResolver;

import javax.annotation.Resource;
/**
 * web的配置文件
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {
    /**
     * 登录的拦截器
     *
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
/*        registry.addInterceptor(new AdminSessionInterceptor()).addPathPatterns("/pl/**").excludePathPatterns("/pl/login/**");
        registry.addInterceptor(new CustomerSessionInterceptor()).addPathPatterns("/cu/**").excludePathPatterns("/cu/login/**");
        registry.addInterceptor(new LogInterceptor()).addPathPatterns("/pl/**");*/
    }

    /**
     * 静态资源
     *
     * @param registry
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
    }

    /**
     * 日期格式化类
     *
     * @param registry
     */
    @Override
    public void addFormatters(FormatterRegistry registry) {
        /*registry.addFormatter(new DateFormatter());*/
    }

    /**
     * 配置全局静态变量
     *
     * @param viewResolver
     */
    @Resource
    private void configureThymeleafStaticVars(ThymeleafViewResolver viewResolver) {
        if (viewResolver != null) {
/*            Map<String, Object> vars = new HashMap<>();
            vars.put("SYS_NAME", AirleadConfig.SYS_NAME);
            vars.put("SYS_CODE", AirleadConfig.SYS_CODE);
            viewResolver.setStaticVariables(vars);*/
        }
    }
}
