package com.example.springproxy.cglib;

import com.example.springproxy.common.ConcreteService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.cglib.proxy.Enhancer;

@Slf4j
public class CglibTest {

    @Test
    void cglib() {
        ConcreteService target = new ConcreteService();
        Enhancer enhancer = new Enhancer(); // cglib 프록시 생성기
        enhancer.setSuperclass(ConcreteService.class); // 구체클래스를 기반으로 생성 -> ConcreteService를 상속 받아서 proxy 생성
        enhancer.setCallback(new TimeMethodInterceptor(target)); // 프록시에 적용할 실행로직
        ConcreteService proxy = (ConcreteService) enhancer.create(); // 프로젝트 생성 -> ConcreteService를 상속 받았으므로 업캐스팅 가능

        log.info("targetClass={}", target.getClass());
        // proxyClass=class com.example.springproxy.common.ConcreteService$$EnhancerByCGLIB$$db8c652
        log.info("proxyClass={}", proxy.getClass()); // ConcreteService$$EnhancerByCGLIB$$db8c652 -> ConcreteService를 상속 받아서 생성

        proxy.call();
    }
}
