package com.example.springproxy.jdkdynamic;

import com.example.springproxy.jdkdynamic.code.*;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Proxy;

@Slf4j
public class JdkDynamicProxyTest {

    @Test
    void dynamicA() {
        InterfaceA target = new InterfaceAImpl();
        TimeInvocationHandler handler = new TimeInvocationHandler(target);

        // 프록시 동적 생성
        // 1. 프록시 정의할 classLoader 2. 프록시 생성할 기반 인터페이스 3. 동작시킬 로직
        InterfaceA proxy = (InterfaceA) Proxy.newProxyInstance(InterfaceA.class.getClassLoader(), new Class[]{InterfaceA.class}, handler);

        proxy.call(); // handler.invoke() 호출
        // targetClass=class com.example.springproxy.jdkdynamic.code.InterfaceAImpl
        log.info("targetClass={}", target.getClass());
        // proxyClass=class jdk.proxy3.$Proxy12
        log.info("proxyClass={}", proxy.getClass());
    }

    @Test
    void dynamicB() {
        InterfaceB target = new InterfaceBImpl();
        TimeInvocationHandler handler = new TimeInvocationHandler(target);

        InterfaceB proxy = (InterfaceB) Proxy.newProxyInstance(InterfaceB.class.getClassLoader(), new Class[]{InterfaceB.class}, handler);
        proxy.call();

        // com.example.springproxy.jdkdynamic.code.InterfaceBImpl
        log.info("targetClass={}", target.getClass());
        // class jdk.proxy3.$Proxy12
        log.info("proxyClass={}", proxy.getClass());
    }
}
