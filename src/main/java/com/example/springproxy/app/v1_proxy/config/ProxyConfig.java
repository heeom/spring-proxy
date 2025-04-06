package com.example.springproxy.app.v1_proxy.config;

import com.example.springproxy.app.common.LogTrace;
import com.example.springproxy.app.v1.*;
import com.example.springproxy.app.v1_proxy.OrderControllerProxy;
import com.example.springproxy.app.v1_proxy.OrderRepositoryProxy;
import com.example.springproxy.app.v1_proxy.OrderServiceProxy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProxyConfig {

    @Bean
    public OrderControllerV1 orderControllerV1(LogTrace logTrace) {
        return new OrderControllerProxy(new OrderControllerV1Impl(orderServiceV1(logTrace)), logTrace);
    }

    @Bean
    public OrderServiceV1 orderServiceV1(LogTrace logTrace) {
        return new OrderServiceProxy(new OrderServiceV1Impl(orderRepositoryV1(logTrace)), logTrace);
    }

    @Bean
    public OrderRepositoryV1 orderRepositoryV1(LogTrace logTrace) {
        return new OrderRepositoryProxy(new OrderRepositoryV1Impl(), logTrace);
    }
}
