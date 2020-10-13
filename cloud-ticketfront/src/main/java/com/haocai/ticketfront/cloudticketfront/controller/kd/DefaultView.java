package com.haocai.ticketfront.cloudticketfront.controller.kd;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @Description TODO
 * @Author CQ
 * @Date 2020/8/24 10:06
 **/
@Configuration
public class DefaultView extends WebMvcConfigurerAdapter{
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("project/list");
        registry.setOrder(Ordered.HIGHEST_PRECEDENCE);//最先
        super.addViewControllers(registry);
    }
}
