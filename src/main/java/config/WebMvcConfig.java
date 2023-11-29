package config;

import interceptor.LogInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.annotation.Resource;

/**
 * @ClassName: WebMvcConfig
 * @Description:
 * @Author: ice
 */

/**
 * <!-- https://mvnrepository.com/artifact/org.springframework/spring-context -->
 * <dependency>
 * <groupId>org.springframework</groupId>
 * <artifactId>spring-context</artifactId>
 * <version>6.0.8</version>
 * </dependency>
 */
@EnableWebMvc
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

//        @Autowired
//        private PreventRepeatSubmitInterceptor preventRepeatSubmitInterceptor;

    @Resource
    private LogInterceptor logInterceptor;

    public void addCorsMappings(CorsRegistry registry) {
        //设置允许跨域的路径
        registry.addMapping("/**") //映射地址
                .allowedOrigins("*")//允许跨域地址
                .allowedHeaders("*")
                .allowCredentials(true)
                .allowedMethods("GET", "POST")
                .maxAge(3600);
    }

    public void addInterceptors(InterceptorRegistry registry) {
        //.excludePathPatterns("/wechatwork/**")  .addPathPatterns("/order/**")
        //防重复提交拦截器
        // registry.addInterceptor(preventRepeatSubmitInterceptor);
        //日志拦截器
        registry.addInterceptor(logInterceptor);
        //.addPathPatterns("/**");
    }

}
