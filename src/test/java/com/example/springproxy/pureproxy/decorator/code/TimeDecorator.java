package com.example.springproxy.pureproxy.decorator.code;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TimeDecorator implements Component {

    private Component realComponent;

    public TimeDecorator(Component realComponent) {
        this.realComponent = realComponent;
    }

    @Override
    public String operation() {
        log.info("TimeDecorator 실행");
        long startTime = System.currentTimeMillis();
        String operation = realComponent.operation();
        long endTime = System.currentTimeMillis();
        log.info("TimeDecorator 종료 resultTime = {} ms ", endTime - startTime);
        return operation;
    }
}
