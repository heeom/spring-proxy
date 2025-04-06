package com.example.springproxy.app.common;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
public class LogTraceImpl implements LogTrace {

    @Override
    public void log() {
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        StackTraceElement currentClass = stackTrace[1]; // 0: getStackTrace, 1: 현재 메서드, 2: 호출자
        StackTraceElement caller = stackTrace[2]; // 0: getStackTrace, 1: 현재 메서드, 2: 호출자

        String currentClassName = currentClass.getClassName();
        String currentMethodName = currentClass.getMethodName();

        String className = caller.getClassName();
        String methodName = caller.getMethodName();


        log.info("Thread: {}, CallerClassName: {}, CallerMethodName: {}, Current Class: {}, Current Method: {}",
                Thread.currentThread().getName(),
                className,
                methodName,
                currentClassName,
                currentMethodName);
    }
}
