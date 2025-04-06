package com.example.springproxy.app.v1_dynamicproxy;

import com.example.springproxy.app.common.LogTrace;
import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

@Slf4j
public class LogTraceBasicHandler implements InvocationHandler {

    private final Object target; // 프록시가 호출할 대상
    private final LogTrace logTrace;

    public LogTraceBasicHandler(Object target, LogTrace logTrace) {
        this.target = target;
        this.logTrace = logTrace;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object result = method.invoke(target, args);
        log.info("LogTraceBasicHandler ====== {}.{} / result : {}", method.getDeclaringClass().getSimpleName(), method.getName(), result);
        return result;
    }
}
