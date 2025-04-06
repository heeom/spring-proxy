package com.example.springproxy.common;

import lombok.extern.slf4j.Slf4j;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

@Slf4j
public class TimeAdvice implements MethodInterceptor {

    @Override // MethodInvocation 에 target 정보가 있음
    public Object invoke(MethodInvocation invocation) throws Throwable {
        log.info("TimeProxy 실행");
        long startTime = System.currentTimeMillis();

        Object result = invocation.proceed(); // target을 찾아서 target 메서드를 실행

        long endTime = System.currentTimeMillis();
        log.info("TimeProxy 종료 : {} ms, result : {}, ", endTime - startTime, result);
        return result;
    }
}
