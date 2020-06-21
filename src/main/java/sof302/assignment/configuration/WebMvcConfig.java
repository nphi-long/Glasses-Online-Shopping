package sof302.assignment.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import sof302.assignment.interceptor.AdminInterceptor;
import sof302.assignment.interceptor.BlockAdminToClientPage;

@Configuration
public class WebMvcConfig extends WebMvcConfigurerAdapter {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new AdminInterceptor())
                .addPathPatterns("/admin/*")
                .addPathPatterns("/admin");
        registry.addInterceptor(new BlockAdminToClientPage())
                .addPathPatterns("")
                .addPathPatterns("/")
                .addPathPatterns("/*")
                .excludePathPatterns("/admin")
                .excludePathPatterns("/admin/*")
                .excludePathPatterns("/notfound");
    }
}
