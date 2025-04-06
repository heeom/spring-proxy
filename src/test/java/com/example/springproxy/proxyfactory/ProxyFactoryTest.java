package com.example.springproxy.proxyfactory;

import com.example.springproxy.common.ConcreteService;
import com.example.springproxy.common.ServiceInterface;
import com.example.springproxy.common.ServiceInterfaceImpl;
import com.example.springproxy.common.TimeAdvice;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.AopUtils;

@Slf4j
public class ProxyFactoryTest {

    @Test
    @DisplayName("인터페이스가 있으면 JDK 동적 프록시 사용")
    void interfaceProxy() {
        ServiceInterface target = new ServiceInterfaceImpl();
        ProxyFactory proxyFactory = new ProxyFactory(target);
        proxyFactory.addAdvice(new TimeAdvice());
        ServiceInterface proxy = (ServiceInterface) proxyFactory.getProxy();
        log.info("TargetClass : {}", target.getClass());
        log.info("ProxyClass : {}", proxy.getClass()); // class jdk.proxy3.$Proxy13 -> 인터페이스 기반으로 생성 -> JDK 프록시
        proxy.save();

        Assertions.assertTrue(AopUtils.isAopProxy(proxy)); // 프록시 패턴을 쓸때만 사용가능
        Assertions.assertTrue(AopUtils.isJdkDynamicProxy(proxy));
        Assertions.assertFalse(AopUtils.isCglibProxy(proxy));
    }

    @Test
    @DisplayName("구체클래스만 있으면 CGLIB 사용")
    void concreteProxy() {
        ConcreteService target = new ConcreteService();
        ProxyFactory proxyFactory = new ProxyFactory(target);
        proxyFactory.addAdvice(new TimeAdvice());
        ConcreteService proxy = (ConcreteService) proxyFactory.getProxy();
        log.info("TargetClass : {}", target.getClass());
        log.info("ProxyClass : {}", proxy.getClass()); // ConcreteService$$SpringCGLIB$$0 -> CGLIB 로 생성

        proxy.call();

        Assertions.assertTrue(AopUtils.isAopProxy(proxy)); // 프록시 패턴을 쓸때만 사용가능
        Assertions.assertFalse(AopUtils.isJdkDynamicProxy(proxy));
        Assertions.assertTrue(AopUtils.isCglibProxy(proxy));
    }

    @Test
    @DisplayName("proxyTargetClass 옵션을 사용하면 인터페이스가 있어도 CGLIB를 사용하고, 클래스 기반 프록시 사용")
    void proxyTargetClass() {
        ServiceInterface target = new ServiceInterfaceImpl();
        ProxyFactory proxyFactory = new ProxyFactory(target);
        proxyFactory.addAdvice(new TimeAdvice());
        proxyFactory.setProxyTargetClass(true); // 타겟 클래스 기반으로 프록시 생성

        ServiceInterface proxy = (ServiceInterface) proxyFactory.getProxy();
        log.info("TargetClass : {}", target.getClass());
        log.info("ProxyClass : {}", proxy.getClass()); // ServiceInterfaceImpl$$SpringCGLIB$$0 ->  ServiceInterfaceImpl 클래스 기반으로 동적 프록시 생성
        proxy.save();

        Assertions.assertTrue(AopUtils.isAopProxy(proxy)); // 프록시 패턴을 쓸때만 사용가능
        Assertions.assertFalse(AopUtils.isJdkDynamicProxy(proxy));
        Assertions.assertTrue(AopUtils.isCglibProxy(proxy));
    }


}
