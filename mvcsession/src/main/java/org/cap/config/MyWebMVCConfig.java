package org.cap.config;

import org.cap.dto.SessionData;
import org.cap.entities.AppUser;
import org.springframework.context.annotation.*;
import org.springframework.web.context.request.RequestContextListener;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import javax.servlet.http.HttpServletRequest;

@Configuration
@EnableWebMvc
@ComponentScan("org.cap")
public class MyWebMVCConfig {

    @Bean
    public ViewResolver getViewResolver() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/pages/");
        viewResolver.setSuffix(".jsp");
        return viewResolver;
    }

    @Bean
    @Scope(value = "session", proxyMode = ScopedProxyMode.TARGET_CLASS)
    public SessionData sessionData() {
        return new SessionData();
    }

}
