package groupELstupido.sso;

import groupELstupido.sso.interceptors.AuthenticationInterceptor;
import jakarta.servlet.annotation.MultipartConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.view.JstlView;
import org.springframework.web.servlet.view.UrlBasedViewResolver;

@EnableWebMvc
@Configuration
@MultipartConfig
@ComponentScan("groupELstupido.sso")
public class SSOConfiguration implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry interceptorRegistry) {
        InterceptorRegistration interceptorRegistration =  interceptorRegistry.addInterceptor(new AuthenticationInterceptor());
    }

    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
        UrlBasedViewResolver urlBasedViewResolver = new UrlBasedViewResolver();
        urlBasedViewResolver.setViewClass(JstlView.class);
        urlBasedViewResolver.setPrefix("/WEB-INF/views/");
        urlBasedViewResolver.setSuffix(".jsp");
        registry.viewResolver(urlBasedViewResolver);
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/favicon.ico").addResourceLocations("classpath:/static/");
        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
    }

    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }

    @Bean("multipartResolver")
    public StandardServletMultipartResolver multipartResolver() {
        StandardServletMultipartResolver resolver = new StandardServletMultipartResolver();
        return new StandardServletMultipartResolver();
    }
}
