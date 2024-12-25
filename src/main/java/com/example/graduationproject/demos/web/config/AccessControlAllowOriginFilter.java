package com.example.graduationproject.demos.web.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @projectName: graduation-project
 * @package: com.example.graduationproject.demos.web.config
 * @className: AccessControlAllowOriginFilter
 * @author: yangletian
 * @date: 2024/12/25 11:41
 * @version: 1.0
 */
//解决前端跨域问题
@Configuration
public class AccessControlAllowOriginFilter  implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry){
        registry.addMapping("/*/**")
                .allowedHeaders("*")
                .allowedMethods("*")
                .maxAge(1800)
                .allowedOrigins("*");
    }

}
