package com.example.springproxy.reflection;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

@Slf4j
public class ReflectionTest {

    @Test
    void reflectionTest() {
        Hello hello = new Hello();
        log.info("start");
        String a = hello.callA(); // 동적 처리
        log.info("result = {}", a);


        log.info("start");
        String b = hello.callB();
        log.info("result = {}", b);
    }

    @Slf4j
    static class Hello {
        public String callA() {
            log.info("hello");
            return "A";
        }

        public String callB() {
            log.info("hello");
            return "B";
        }
    }

    @Test
    void reflectionTest2() throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {

        // 클래스 메타 정보 획득
        Class classHello = Class.forName("com.example.springproxy.reflection.ReflectionTest$Hello");

        Hello target = new Hello();
        // 추상화
        Method callA = classHello.getMethod("callA"); //메서드 메타 정보
        Object result1 = callA.invoke(target); // 메서드 호출
        log.info("result1 = {}", result1);

        Method callB = classHello.getMethod("callB");
        Object result2 = callB.invoke(target);
        log.info("result2 = {}", result2);
    }

    @Test
    void reflectionTest3() throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {

        // 클래스 메타 정보 획득
        Class classHello = Class.forName("com.example.springproxy.reflection.ReflectionTest$Hello");

        Hello hello = new Hello();

        dynamicCall(classHello.getMethod("callA"), hello);
        dynamicCall(classHello.getMethod("callB"), hello);
    }

    private void dynamicCall(Method method, Object target) throws InvocationTargetException, IllegalAccessException {
        log.info("start");
        Object result = method.invoke(target);
        log.info("result = {}", result);
    }
}
